package inatjunior.website.Controllers;

import inatjunior.website.Business.*;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class TrainingController {

    @Autowired
    TrainingBusiness trainingBusiness;

    @Autowired
    MemberBusiness memberBusiness;

    @PostMapping("/training")
    public Training createTraining(@RequestBody Training t){
        return trainingBusiness.createTraining(t.getName(),t.getDescription(),t.getOpening(),t.getClosing(),t.getPlace(),t.getProgram(),t.getGoals(),t.getPrerequisites(),t.getEquipment());
    }

    @DeleteMapping("/training/{id}")
    public void deleteTraining(@PathVariable long id){
        trainingBusiness.deleteTraining(trainingBusiness.getTraining(id));
    }

    @GetMapping("/training/{id}")
    public Training getTraining(@PathVariable long id){
        return trainingBusiness.getTraining(id);
    }

    @PostMapping("/trainer")
    public void addTrainer(@RequestParam("trainingid") long trainingid, @RequestParam("memberid") long memberid){
        trainingBusiness.addTrainer(trainingBusiness.getTraining(trainingid),memberBusiness.getMember(memberid));
    }

    @DeleteMapping("/trainer")
    public void removeTrainer(@RequestParam("trainingid") long trainingid, @RequestParam("memberid") long memberid){
        trainingBusiness.removeTrainer(trainingBusiness.getTraining(trainingid),memberBusiness.getMember(memberid));
    }

    @PutMapping("/training/{id}")
    public Training updateTraining(@PathVariable("id") long id, @RequestBody Training t){
        Training training=trainingBusiness.getTraining(id);
        return trainingBusiness.updateTraining(training,t.getName(),t.getDescription(),t.getOpening(),t.getClosing(),t.getPlace(),t.getProgram(),t.getGoals(),t.getPrerequisites(),t.getEquipment());
    }

    @GetMapping("/trainings")
    public List<Training> getAllTrainings(){
        return trainingBusiness.getAllTrainings();
    }

    @GetMapping("/trainers/{id}")
    public List<Member> getTrainers(@PathVariable long id){
        return trainingBusiness.getTrainers1(trainingBusiness.getTraining(id));
    }
}
