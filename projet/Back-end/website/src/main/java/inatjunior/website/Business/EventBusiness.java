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

    public Event createEvent(String name, String description, Date opening, Date closing, String place, Member member){
        Event ev1 = new Event(name,description,opening,closing,place);
        try {
            eventRepository.save(ev1);
            organizerRepository.save(new Organizer(new OrganizerKey(member.getMemberid(),ev1.getEventid()),ev1,member));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ev1;
    }

    public void deleteEvent(Event ev1){
        try {
            List<Organizer> organizers = this.getOrganizers(ev1);
            Iterator<Organizer> iter = organizers.iterator();
            while (iter.hasNext()) {
                Organizer t = iter.next();
                if (t.getId().getEventid() == ev1.getEventid())
                    organizerRepository.delete(t);
            }
            Event ev2 = eventRepository.getOne(ev1.getEventid());
            eventRepository.delete(ev2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Event getEvent(Long id){
        try {
            return eventRepository.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addOrganizer (Event ev1, Member member){
        try {
            organizerRepository.save(new Organizer(new OrganizerKey(member.getMemberid(),ev1.getEventid()),ev1,member));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeOrganizer(Event ev1, Member member){
        try {
            organizerRepository.delete(new Organizer(new OrganizerKey(member.getMemberid(),ev1.getEventid()),ev1,member));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printOrganizers(Event ev){
        try {
            System.out.println("Organizers :");
            List<Organizer> organizers = this.getOrganizers(ev);
            Iterator<Organizer> iter=organizers.iterator();
            while (iter.hasNext())
            {
                Organizer t = iter.next();
                System.out.println(t.getId().getMemberId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Organizer> getOrganizers(Event ev){
        try {
            List<Organizer> all = organizerRepository.findAll();
            List<Organizer> the = new ArrayList<>();
            Iterator<Organizer> it = all.iterator();
            while (it.hasNext()){
                Organizer t = it.next();
                if (t.getEvent().getEventid() == ev.getEventid())
                    the.add(t);
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Event updateEvent(Event t,String name, String description, Date opening, Date closing, String place){
        try {
            t.setName(name);
            t.setDescription(description);
            t.setOpening(opening);
            t.setClosing(closing);
            t.setPlace(place);
            eventRepository.save(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public List<Member> getOrganizers1(Event ev){
        try {
            List<Organizer> all = organizerRepository.findAll();
            List<Member> the = new ArrayList<>();
            Iterator<Organizer> it = all.iterator();
            while (it.hasNext()){
                Organizer t = it.next();
                if (t.getEvent().getEventid() == ev.getEventid())
                    the.add(t.getMember());
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
