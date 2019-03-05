package inatjunior.website.Controllers;

import inatjunior.website.Business.MemberBusiness;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MemberController {

    @Autowired
    MemberBusiness memberBusiness;

    @PostMapping("/member")
    public Member createMember(@RequestBody Member m){
            return memberBusiness.createMember(m.getName(),m.getFamily(),m.getEmail(),m.getPhone());
    }

    @PostMapping(value = "/officeMember")
    public Member createOfficeMember(@RequestBody Member om){
        return memberBusiness.createOfficeMember(om.getName(),om.getFamily(),om.getEmail(),om.getPhone(),om.getJob(),om.getQuote());
    }

    @DeleteMapping({"/member/{id}","/officeMember/{id}"})
    public void deleteMember(@PathVariable long id){
            memberBusiness.deleteMember(memberBusiness.getMember(id));
    }

    @PutMapping("/member/{id}")
    public Member updateMember(@PathVariable long id, @RequestBody Member member){
        return memberBusiness.updateMember(memberBusiness.getMember(id),member.getName(),member.getFamily(),member.getEmail(),member.getPhone(),null,null,false);
    }

    @PutMapping("/officeMember/{id}")
    public Member updateOfficeMember(@PathVariable long id, @RequestBody Member officeMember){
        return memberBusiness.updateMember(memberBusiness.getMember(id),officeMember.getName(),officeMember.getFamily(),officeMember.getEmail(),officeMember.getPhone(),officeMember.getJob(),officeMember.getQuote(),true);
    }

    @GetMapping({"/member/{id}","/officeMember/{id}"})
    public Member getMember(@PathVariable long id){
        return memberBusiness.getMember(id);
    }

    @PutMapping("/office/{id}")
    public Member office(@PathVariable long id, @RequestBody Member member){
        return memberBusiness.updateMember(memberBusiness.getMember(id),member.getName(),member.getFamily(),member.getEmail(),member.getPhone(),member.getJob(),member.getQuote(),true);
    }

    @PutMapping("/noOffice/{id}")
    public Member noOffice(@PathVariable long id, @RequestBody Member member){
        return memberBusiness.updateMember(memberBusiness.getMember(id),member.getName(),member.getFamily(),member.getEmail(),member.getPhone(),null,null,false);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers(){
            return memberBusiness.getAllMembers();
    }

    @GetMapping("/officeMembers")
    public List<Member> getAllOfficeMembers(){
            return memberBusiness.getAllOfficeMembers();
    }

    @GetMapping("/trainings/{id}")
    public List<Training> getTrainings(@PathVariable long id){
            return memberBusiness.getTrainings(memberBusiness.getMember(id));
    }

    @GetMapping("/events/{id}")
    public List<Event> getEvents(@PathVariable long id){
            return memberBusiness.getEvents(memberBusiness.getMember(id));
    }

    @PostMapping("/memberphoto/{memberid}")
    public MemberPhoto addPhoto(@PathVariable long memberid, @RequestParam("path") String path){
        return memberBusiness.addPhoto(memberBusiness.getMember(memberid),path);
    }

    @DeleteMapping("/memberphoto/{id}")
    public void removePhoto(@PathVariable long id){
        memberBusiness.removePhoto(memberBusiness.getPhoto(id));
    }

    @GetMapping("/memberphoto/{id}")
    public MemberPhoto getPhoto(@PathVariable long id){
        return memberBusiness.getPhoto(id);
    }

    @PutMapping("/memberphoto/{id}")
    public MemberPhoto updatePhoto(@PathVariable("id") long id, @RequestParam("path") String path){
        MemberPhoto ep=memberBusiness.getPhoto(id);
        return memberBusiness.updatePhoto(ep,path);
    }

    @GetMapping("/memberphotos/{memberid}")
    public List<MemberPhoto> getPhotos(@PathVariable long memberid){
        return memberBusiness.getPhotos(memberBusiness.getMember(memberid));
    }

}