package inatjunior.website.Controllers;

import inatjunior.website.Business.*;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class EventController {

    @Autowired
    EventBusiness eventBusiness;

    @Autowired
    MemberBusiness memberBusiness;

    @PostMapping("/createEvent")
    public Event createEvent(@RequestBody Event t, @RequestParam("memberid") long memberid){
        return eventBusiness.createEvent(t.getName(),t.getDescription(),t.getOpening(),t.getClosing(),t.getPlace(),memberBusiness.getMember(memberid));
    }

    @DeleteMapping("/deleteEvent/{id}")
    public void deleteEvent(@PathVariable long id){
        eventBusiness.deleteEvent(eventBusiness.getEvent(id));
    }

    @GetMapping("/getEvent/{id}")
    public Event getEvent(@PathVariable long id){
        return eventBusiness.getEvent(id);
    }

    @PostMapping("/addOrganizer")
    public void addOrganizer(@RequestParam("eventid") long eventid, @RequestParam("memberid") long memberid){
        eventBusiness.addOrganizer(eventBusiness.getEvent(eventid),memberBusiness.getMember(memberid));
    }

    @DeleteMapping("/removeOrganizer")
    public void removeOrganizer(@RequestParam("eventid") long eventid, @RequestParam("memberid") long memberid){
        eventBusiness.removeOrganizer(eventBusiness.getEvent(eventid),memberBusiness.getMember(memberid));
    }

    @PutMapping("/updateEvent/{id}")
    public Event updateEvent(@PathVariable("id") long id, @RequestBody Event t){
        Event event=eventBusiness.getEvent(id);
        return eventBusiness.updateEvent(event,t.getName(),t.getDescription(),t.getOpening(),t.getClosing(),t.getPlace());
    }

    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents(){
        return eventBusiness.getAllEvents();
    }

    @GetMapping("getOrganizers/{id}")
    public List<Member> getOrganizers(@PathVariable long id){
        return eventBusiness.getOrganizers1(eventBusiness.getEvent(id));
    }

}
