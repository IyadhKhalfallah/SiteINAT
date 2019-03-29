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
    OrganizerRepository organizerRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EventPhotoRepository eventPhotoRepository;

    public Training createTraining(String name, String description, Date opening, Date closing, String place, String program, String goals, String prerequisites, String equipment){
        Training tr1 = new Training(name,description,opening,closing,place,program,goals,prerequisites,equipment);
            trainingRepository.save(tr1);
        return tr1;
    }

    public void deleteTraining(Training tr1){
            List<Trainer> trainers = this.getTrainers(tr1);
            Iterator<Trainer> iter = trainers.iterator();
            while (iter.hasNext()) {
                Trainer t = iter.next();
                if (t.getId().getEventid() == tr1.getEventid())
                    trainerRepository.delete(t);
            }
            List<Organizer> organizers = this.getOrganizers(tr1);
            Iterator<Organizer> iter1 = organizers.iterator();
            while (iter1.hasNext()) {
                Organizer o = iter1.next();
                if (o.getId().getEventid() == tr1.getEventid())
                    organizerRepository.delete(o);
            }
            List<EventPhoto> photos = tr1.getEventphotos();
            Iterator<EventPhoto> iterp = photos.iterator();
            while (iterp.hasNext()) {
            EventPhoto p = iterp.next();
            eventPhotoRepository.delete(p);
            }
            Training tr2 = trainingRepository.getOne(tr1.getEventid());
            trainingRepository.delete(tr2);
    }

    public Training getTraining(Long id){
            return trainingRepository.getOne(id);
    }

    public void addTrainer (Training tr1, Member member){
            trainerRepository.save(new Trainer(new TrainerKey(member.getMemberid(),tr1.getEventid()),tr1,member));
    }

    public void removeTrainer(Training tr1, Member member){
            trainerRepository.delete(new Trainer(new TrainerKey(member.getMemberid(),tr1.getEventid()),tr1,member));
    }

    public List<Trainer> getTrainers(Training tg){
            List<Trainer> all = trainerRepository.findAll();
            List<Trainer> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getTraining().getEventid() == tg.getEventid())
                    the.add(t);
            }
            return the;
    }

    public List<Organizer> getOrganizers(Training ev){
        List<Organizer> all = organizerRepository.findAll();
        List<Organizer> the = new ArrayList<>();
        Iterator<Organizer> it = all.iterator();
        while (it.hasNext()){
            Organizer t = it.next();
            if (t.getEvent().getEventid() == ev.getEventid())
                the.add(t);
        }
        return the;
    }

    public Training updateTraining(Training t,String name, String description, Date opening, Date closing, String place, String program, String goals, String prerequisites, String equipment){
            t.setName(name);
            t.setDescription(description);
            t.setOpening(opening);
            t.setClosing(closing);
            t.setPlace(place);
            t.setProgram(program);
            t.setGoals(goals);
            t.setPrerequisites(prerequisites);
            t.setEquipment(equipment);
            trainingRepository.save(t);
        return t;
    }

    public List<Training> getAllTrainings(){
        return trainingRepository.findAll();
    }

    public List<Member> getTrainers1(Training tg){
            List<Trainer> all = trainerRepository.findAll();
            List<Member> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getTraining().getEventid() == tg.getEventid())
                    the.add(t.getMember());
            }
            return the;
    }

}
