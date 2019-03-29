package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MemberBusiness {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    MemberPhotoRepository memberPhotoRepository;


    public Member createMember (String name, String family, String email, Long phone){
        Member m = new Member(name,family,email,phone,null,null,false);
        memberRepository.save(m);
        return m;
    }

    public void deleteMember(Member member){
            List<Trainer> trainers = this.getTrainers(member);
            Iterator<Trainer> iter1 = trainers.iterator();
            while (iter1.hasNext()) {
                Trainer t = iter1.next();
                if (t.getId().getMemberId() == member.getMemberid())
                    trainerRepository.delete(t);
            }
            List<Organizer> organizers = this.getOrganizers(member);
            Iterator<Organizer> iter2 = organizers.iterator();
            while (iter2.hasNext()) {
                Organizer t = iter2.next();
                if (t.getId().getMemberId() == member.getMemberid())
                    organizerRepository.delete(t);
            }
            List<MemberPhoto> photos = member.getMemberphotos();
            Iterator<MemberPhoto> iter = photos.iterator();
            while (iter.hasNext()) {
            MemberPhoto t = iter.next();
            memberPhotoRepository.delete(t);
            }
            Member m = memberRepository.getOne(member.getMemberid());
            memberRepository.delete(m);
    }

    public Member getMember(Long id){
            return memberRepository.getOne(id);
    }

    public List<Member> getAllMembers(){
            return memberRepository.findAll();
    }

    public List<Member> getAllOfficeMembers(){
        List<Member> all=memberRepository.findAll();
        List<Member> the=new ArrayList<>();
        Iterator<Member> it=all.iterator();
        while(it.hasNext()){
            Member e=it.next();
            if(e.isOffice())
                the.add(e);
        }
        return the;
    }

    public Member createOfficeMember(String name, String family, String email, Long phone, String job, String quote){
            Member m = new Member(name,family,email,phone,job,quote,true);
            memberRepository.save(m);
            return m;
    }

    public Member updateMember(Member x,String name, String family, String email, Long phone, String job, String quote, boolean office){
            x.setName(name);
            x.setFamily(family);
            x.setEmail(email);
            x.setPhone(phone);
            x.setJob(job);
            x.setQuote(quote);
            x.setOffice(office);
            memberRepository.save(x);
        return x;
    }

    public List<Trainer> getTrainers(Member m){
            List<Trainer> all = trainerRepository.findAll();
            List<Trainer> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t);
            }
            return the;
    }

    public List<Organizer> getOrganizers(Member m){
            List<Organizer> all = organizerRepository.findAll();
            List<Organizer> the = new ArrayList<>();
            Iterator<Organizer> it = all.iterator();
            while (it.hasNext()){
                Organizer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t);
            }
            return the;
    }

    public List<Training> getTrainings(Member m){
            List<Trainer> all = trainerRepository.findAll();
            List<Training> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t.getTraining());
            }
            return the;
    }

    public List<Event> getEvents(Member m){
            List<Organizer> all = organizerRepository.findAll();
            List<Event> the = new ArrayList<>();
            Iterator<Organizer> it = all.iterator();
            while (it.hasNext()){
                Organizer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t.getEvent());
            }
            return the;
    }

    public MemberPhoto addPhoto(Member e, String path){
        MemberPhoto ep = new MemberPhoto(e, path);
        memberPhotoRepository.save(ep);
        return ep;
    }

    public MemberPhoto getPhoto(Long id){
        return memberPhotoRepository.getOne(id);
    }

    public void removePhoto(MemberPhoto ep){
        MemberPhoto e = memberPhotoRepository.getOne(ep.getPhotoid());
        memberPhotoRepository.delete(e);
    }

    public MemberPhoto updatePhoto(MemberPhoto e, String path){
        e.setPath(path);
        memberPhotoRepository.save(e);
        return e;
    }

    public List<MemberPhoto> getPhotos(Member e){
        List<MemberPhoto> all=memberPhotoRepository.findAll();
        List<MemberPhoto> the=new ArrayList<>();
        Iterator<MemberPhoto> it=all.iterator();
        while(it.hasNext()){
            MemberPhoto ep=it.next();
            if(e.getMemberid()==ep.getMember().getMemberid())
                the.add(ep);
        }
        return the;
    }
}
