package inatjunior.website.Controllers;

import inatjunior.website.Business.MemberBusiness;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberBusiness memberBusiness;

    @PostMapping("/createMember")
    public Member createMember(@RequestBody Member m){
            return memberBusiness.createMember(m.getName(),m.getFamily(),m.getEmail(),m.getPhone());
    }

    @DeleteMapping("/deleteMember/{id}")
    public void deleteMember(@PathVariable long id){
            memberBusiness.deleteMember(memberBusiness.getMember(id));
    }

    @RequestMapping(value = "/addOfficeMember/{memberid}", method = {RequestMethod.DELETE,RequestMethod.POST})
    public OfficeMember addOfficeMember(@PathVariable long memberid, @RequestBody OfficeMember om){
            return memberBusiness.addOfficeMember(memberBusiness.getMember(memberid),om.getJob(),om.getQuote());
    }

    @RequestMapping(value = "/removeOfficeMember/{memberid}", method = {RequestMethod.DELETE,RequestMethod.POST})
    public Member removeOfficeMember(@PathVariable long memberid){
            return memberBusiness.removeOfficeMember(memberBusiness.getOfficeMember(memberid));
    }

    @GetMapping("/getMember/{id}")
    public Member getMember(@PathVariable long id){
            return memberBusiness.getMember(id);
    }

    @GetMapping("/getOfficeMember/{id}")
    public OfficeMember getOfficeMember(@PathVariable long id){
            return memberBusiness.getOfficeMember(id);
    }

    @GetMapping("/getAllMembers")
    public List<Member> getAllMembers(){
            return memberBusiness.getAllMembers();
    }

    @GetMapping("getAllOfficeMembers")
    public List<OfficeMember> getAllOfficeMembers(){
            return memberBusiness.getAllOfficeMembers();
    }

    @PutMapping("updateMember/{id}")
    public Member updateMember(@PathVariable long id, @RequestBody Member member){
            return memberBusiness.updateMember(memberBusiness.getMember(id),member.getName(),member.getFamily(),member.getEmail(),member.getPhone());
    }

    @PutMapping("/updateOfficeMember/{id}")
    public OfficeMember updateOfficeMember(@PathVariable long id, @RequestBody OfficeMember officeMember){
            return memberBusiness.updateOfficeMember(memberBusiness.getOfficeMember(id),officeMember.getName(),officeMember.getFamily(),officeMember.getEmail(),officeMember.getPhone(),officeMember.getJob(),officeMember.getQuote());
    }

    @GetMapping("/getTrainings/{id}")
    public List<Training> getTrainings(@PathVariable long id){
            return memberBusiness.getTrainings(memberBusiness.getMember(id));
    }

    @GetMapping("getEvents/{id}")
    public List<Event> getEvents(@PathVariable long id){
            return memberBusiness.getEvents(memberBusiness.getMember(id));
    }
}