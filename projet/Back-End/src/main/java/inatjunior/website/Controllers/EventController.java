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

    @PostMapping("/event")
    public Event createEvent(@RequestBody Event t, @RequestParam("memberid") long memberid){
        return eventBusiness.createEvent(t.getName(),t.getDescription(),t.getOpening(),t.getClosing(),t.getPlace(),t.getProgram(),memberBusiness.getMember(memberid));
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable long id){
        eventBusiness.deleteEvent(eventBusiness.getEvent(id));
    }

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable long id){
        return eventBusiness.getEvent(id);
    }

    @PostMapping("/organizer")
    public void addOrganizer(@RequestParam("eventid") long eventid, @RequestParam("memberid") long memberid){
        eventBusiness.addOrganizer(eventBusiness.getEvent(eventid),memberBusiness.getMember(memberid));
    }

    @DeleteMapping("/organizer")
    public void removeOrganizer(@RequestParam("eventid") long eventid, @RequestParam("memberid") long memberid){
        eventBusiness.removeOrganizer(eventBusiness.getEvent(eventid),memberBusiness.getMember(memberid));
    }

    @PutMapping("/event/{id}")
    public Event updateEvent(@PathVariable("id") long id, @RequestBody Event t){
        Event event=eventBusiness.getEvent(id);
        return eventBusiness.updateEvent(event,t.getName(),t.getDescription(),t.getOpening(),t.getClosing(),t.getPlace(),t.getProgram());
    }

    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventBusiness.getAllEvents();
    }

    @GetMapping("/organizers/{id}")
    public List<Member> getOrganizers(@PathVariable long id){
        return eventBusiness.getOrganizers1(eventBusiness.getEvent(id));
    }

    @PostMapping("/eventphoto/{eventid}")
    public EventPhoto addPhoto(@PathVariable long eventid, @RequestParam("path") String path){
        return eventBusiness.addPhoto(eventBusiness.getEvent(eventid),path);
    }

    @DeleteMapping("/eventphoto/{id}")
    public void removePhoto(@PathVariable long id){
        eventBusiness.removePhoto(eventBusiness.getPhoto(id));
    }

    @GetMapping("/eventphoto/{id}")
    public EventPhoto getPhoto(@PathVariable long id){
        return eventBusiness.getPhoto(id);
    }

    @PutMapping("/eventphoto/{id}")
    public EventPhoto updatePhoto(@PathVariable("id") long id, @RequestParam("path") String path){
        EventPhoto ep=eventBusiness.getPhoto(id);
        return eventBusiness.updatePhoto(ep,path);
    }

    @GetMapping("/eventphotos/{eventid}")
    public List<EventPhoto> getPhotos(@PathVariable long eventid){
        return eventBusiness.getPhotos(eventBusiness.getEvent(eventid));
    }
}
