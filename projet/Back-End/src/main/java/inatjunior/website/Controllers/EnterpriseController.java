package inatjunior.website.Controllers;

import inatjunior.website.Business.EnterpriseBusiness;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseBusiness enterpriseBusiness;

    @PostMapping("/enterprise")
    public Enterprise createEnterprise(@RequestBody Enterprise e){
        return enterpriseBusiness.createEnterprise(e.getName(),e.getDescription(),e.getEmail(),e.getPhone(),e.getAddress(),e.isPartner(),e.isSponsor());
    }

    @GetMapping(value = "/enterprise/{id}")
    public Enterprise getEnterprise(@PathVariable("id") long id){
        return enterpriseBusiness.getEnterprise(id);
    }

    @DeleteMapping(value = "/enterprise/{id}")
    public void deleteEnterprise(@PathVariable("id") long id){
        Enterprise e = enterpriseBusiness.getEnterprise(id);
        enterpriseBusiness.deleteEnterprise(e);
    }

    @PutMapping(value = "/enterprise/{id}")
    public Enterprise updateEnterprise(@PathVariable("id") long id, @RequestBody Enterprise n){
        Enterprise e = enterpriseBusiness.getEnterprise(id);
        return enterpriseBusiness.updateEnterprise(e,n.getName(),n.getDescription(),n.getEmail(),n.getPhone(),n.getAddress(),n.isPartner());
    }

    @GetMapping("/partners")
    public List<Enterprise> getAllPartners(){
        return enterpriseBusiness.getAllPartners();
    }

    @GetMapping("/sponsors")
    public List<Enterprise> getAllSponsors(){
        return enterpriseBusiness.getAllSponsors();
    }

    @PostMapping("/enterprisephoto/{enterpriseid}")
    public EnterprisePhoto addPhoto(@PathVariable long enterpriseid, @RequestParam("path") String path){
        return enterpriseBusiness.addPhoto(enterpriseBusiness.getEnterprise(enterpriseid),path);
    }

    @DeleteMapping("/enterprisephoto/{id}")
    public void removePhoto(@PathVariable long id){
        enterpriseBusiness.removePhoto(enterpriseBusiness.getPhoto(id));
    }

    @GetMapping("/enterprisephoto/{id}")
    public EnterprisePhoto getPhoto(@PathVariable long id){
        return enterpriseBusiness.getPhoto(id);
    }

    @PutMapping("/enterprisephoto/{id}")
    public EnterprisePhoto updatePhoto(@PathVariable("id") long id, @RequestParam("path") String path){
        EnterprisePhoto ep=enterpriseBusiness.getPhoto(id);
        return enterpriseBusiness.updatePhoto(ep,path);
    }

    @GetMapping("/enterprisephotos/{enterpriseid}")
    public List<EnterprisePhoto> getPhotos(@PathVariable long enterpriseid){
        return enterpriseBusiness.getPhotos(enterpriseBusiness.getEnterprise(enterpriseid));
    }

}