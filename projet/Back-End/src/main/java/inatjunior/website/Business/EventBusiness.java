package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EventBusiness {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    EventPhotoRepository eventPhotoRepository;

    public Event createEvent(String name, String description, Date opening, Date closing, String place, String program, Member member){
        Event ev1 = new Event(name,description,opening,closing,place,program);
            eventRepository.save(ev1);
            organizerRepository.save(new Organizer(new OrganizerKey(member.getMemberid(),ev1.getEventid()),ev1,member));
        return ev1;
    }

    public void deleteEvent(Event ev1){
            List<Organizer> organizers = this.getOrganizers(ev1);
            Iterator<Organizer> iter = organizers.iterator();
            while (iter.hasNext()) {
                Organizer t = iter.next();
                if (t.getId().getEventid() == ev1.getEventid())
                    organizerRepository.delete(t);
            }
            Event ev2 = eventRepository.getOne(ev1.getEventid());
            eventRepository.delete(ev2);
    }

    public Event getEvent(Long id){
            return eventRepository.getOne(id);
    }

    public void addOrganizer (Event ev1, Member member){
            organizerRepository.save(new Organizer(new OrganizerKey(member.getMemberid(),ev1.getEventid()),ev1,member));
    }

    public void removeOrganizer(Event ev1, Member member){
            organizerRepository.delete(new Organizer(new OrganizerKey(member.getMemberid(),ev1.getEventid()),ev1,member));
    }

    public List<Organizer> getOrganizers(Event ev){
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

    public Event updateEvent(Event t,String name, String description, Date opening, Date closing, String place, String program){
            t.setName(name);
            t.setDescription(description);
            t.setOpening(opening);
            t.setClosing(closing);
            t.setPlace(place);
            t.setProgram(program);
            eventRepository.save(t);
        return t;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public List<Member> getOrganizers1(Event ev){
            List<Organizer> all = organizerRepository.findAll();
            List<Member> the = new ArrayList<>();
            Iterator<Organizer> it = all.iterator();
            while (it.hasNext()){
                Organizer t = it.next();
                if (t.getEvent().getEventid() == ev.getEventid())
                    the.add(t.getMember());
            }
            return the;
    }

    public EventPhoto addPhoto(Event e, String path){
        EventPhoto ep = new EventPhoto(e, path);
        eventPhotoRepository.save(ep);
        return ep;
    }

    public EventPhoto getPhoto(Long id){
        return eventPhotoRepository.getOne(id);
    }

    public void removePhoto(EventPhoto ep){
        EventPhoto e = eventPhotoRepository.getOne(ep.getPhotoid());
        eventPhotoRepository.delete(e);
    }

    public EventPhoto updatePhoto(EventPhoto e, String path){
        e.setPath(path);
        eventPhotoRepository.save(e);
        return e;
    }

    public List<EventPhoto> getPhotos(Event e){
        List<EventPhoto> all=eventPhotoRepository.findAll();
        List<EventPhoto> the=new ArrayList<>();
        Iterator<EventPhoto> it=all.iterator();
        while(it.hasNext()){
            EventPhoto ep=it.next();
            if(e.getEventid()==ep.getEvent().getEventid())
                the.add(ep);
        }
        return the;
    }
}
