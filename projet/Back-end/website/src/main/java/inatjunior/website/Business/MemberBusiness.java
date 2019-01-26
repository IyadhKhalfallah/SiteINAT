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
    OfficeMemberRepository officeMemberRepository;

    public Member createMember (String name, String family, String email, Long phone){
        Member m = new Member(name,family,email,phone);
        try {
            memberRepository.save(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public void deleteMember(Member member){
        try {
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
            Member m = memberRepository.getOne(member.getMemberid());
            memberRepository.delete(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Member getMember(Long id){
        try {
            return memberRepository.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public OfficeMember getOfficeMember(Long id) {
        try {
            return officeMemberRepository.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Member> getAllMembers(){
        try {
            return memberRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<OfficeMember> getAllOfficeMembers(){
        try {
            return officeMemberRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public OfficeMember addOfficeMember(Member member, String job, String quote){
        try {
            Member m = memberRepository.getOne(member.getMemberid());
            memberRepository.delete(m);
            OfficeMember om = new OfficeMember(member.getName(),member.getFamily(),member.getEmail(),member.getPhone(),job,quote);
            officeMemberRepository.save(om);
            return om;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Member removeOfficeMember(OfficeMember officeMember){
        try {
            OfficeMember om = officeMemberRepository.getOne(officeMember.getMemberid());
            officeMemberRepository.delete(officeMember);
            Member m = new Member(officeMember.getName(),officeMember.getFamily(),officeMember.getEmail(),officeMember.getPhone());
            memberRepository.save(m);
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printMembers(){
        try {
            System.out.println("Members :");
            List<Member> members = memberRepository.findAll();
            Iterator<Member> miter = members.iterator();
            while (miter.hasNext()) {
                Member m = miter.next();
                System.out.println(m.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printOfficeMembers(){
        try {
            System.out.println("Office members :");
            List<OfficeMember> officeMembers=officeMemberRepository.findAll();
            Iterator<OfficeMember> oiter = officeMembers.iterator();
            while (oiter.hasNext()) {
                OfficeMember o = oiter.next();
                System.out.println(o.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Member updateMember(Member x,String name, String family, String email, Long phone){
        try {
            x.setName(name);
            x.setFamily(family);
            x.setEmail(email);
            x.setPhone(phone);
            memberRepository.save(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public OfficeMember updateOfficeMember(OfficeMember x,String name, String family, String email, Long phone, String job, String quote){
        try {
            x.setName(name);
            x.setFamily(family);
            x.setEmail(email);
            x.setPhone(phone);
            x.setJob(job);
            x.setQuote(quote);
            officeMemberRepository.save(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public List<Trainer> getTrainers(Member m){
        try {
            List<Trainer> all = trainerRepository.findAll();
            List<Trainer> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t);
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Organizer> getOrganizers(Member m){
        try {
            List<Organizer> all = organizerRepository.findAll();
            List<Organizer> the = new ArrayList<>();
            Iterator<Organizer> it = all.iterator();
            while (it.hasNext()){
                Organizer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t);
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Training> getTrainings(Member m){
        try {
            List<Trainer> all = trainerRepository.findAll();
            List<Training> the = new ArrayList<>();
            Iterator<Trainer> it = all.iterator();
            while (it.hasNext()){
                Trainer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t.getTraining());
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> getEvents(Member m){
        try {
            List<Organizer> all = organizerRepository.findAll();
            List<Event> the = new ArrayList<>();
            Iterator<Organizer> it = all.iterator();
            while (it.hasNext()){
                Organizer t = it.next();
                if (t.getMember().getMemberid() == m.getMemberid())
                    the.add(t.getEvent());
            }
            return the;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
