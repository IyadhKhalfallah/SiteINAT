package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TrainingBusiness {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    MemberRepository memberRepository;

    public Training createTraining(String name, String description, Date opening, Date closing, String place, String goals, String prerequisites, String equipment, Member member){
        Training tr1 = new Training(name,description,opening,closing,place,goals,prerequisites,equipment);
        try {
            trainingRepository.save(tr1);
            trainerRepository.save(new Trainer(new TrainerKey(member.getMemberid(),tr1.getEventid()),tr1,member));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tr1;
    }

    public void deleteTraining(Training tr1){
        try {
            List<Trainer> trainers = this.getTrainers(tr1);
            Iterator<Trainer> iter = trainers.iterator();
            while (iter.hasNext()) {
                Trainer t = iter.next();
                if (t.getId().getEventid() == tr1.getEventid())
                    trainerRepository.delete(t);
            }
            Training tr2 = trainingRepository.getOne(tr1.getEventid());
            trainingRepository.delete(tr2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Training getTraining(Long id){
        try {
            return trainingRepository.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTrainer (Training tr1, Member member){
        try {
            trainerRepository.save(new Trainer(new TrainerKey(member.getMemberid(),tr1.getEventid()),tr1,member));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeTrainer(Training tr1, Member member){
        try {
            trainerRepository.delete(new Trainer(new TrainerKey(member.getMemberid(),tr1.getEventid()),tr1,member));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTrainers(Training tg){
        try {
            System.out.println("Trainers :");
            List<Trainer> trainers = this.getTrainers(tg);
            Iterator<Trainer> iter=trainers.iterator();
            while (iter.hasNext())
            {
                Trainer t = iter.next();
                System.out.println(t.getId().getMemberId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Trainer> getTrainers(Training tg){
        try {
            List<Trainer> all = trainerRepository.findAll();
            List<Trainer> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getTraining().getEventid() == tg.getEventid())
                    the.add(t);
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Training updateTraining(Training t,String name, String description, Date opening, Date closing, String place, String goals, String prerequisites, String equipment){
        try {
            t.setName(name);
            t.setDescription(description);
            t.setOpening(opening);
            t.setClosing(closing);
            t.setPlace(place);
            t.setGoals(goals);
            t.setPrerequisites(prerequisites);
            t.setEquipment(equipment);
            trainingRepository.save(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public List<Training> getAllTrainings(){
        return trainingRepository.findAll();
    }

    public List<Member> getTrainers1(Training tg){
        try {
            List<Trainer> all = trainerRepository.findAll();
            List<Member> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getTraining().getEventid() == tg.getEventid())
                    the.add(t.getMember());
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
