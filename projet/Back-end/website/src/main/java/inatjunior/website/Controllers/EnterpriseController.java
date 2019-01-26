package inatjunior.website.Controllers;

import inatjunior.website.Business.EnterpriseBusiness;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseBusiness enterpriseBusiness;

    @PostMapping("/createEnterprise")
    public Enterprise createEnterprise(@RequestBody Enterprise e){
        return enterpriseBusiness.createEnterprise(e.getName(),e.getDescription(),e.getEmail(),e.getPhone(),e.getAddress(),e.isPartner());
    }

    @GetMapping(value = "/getEnterprise/{id}")
    public Enterprise getEnterprise(@PathVariable("id") long id){
        return enterpriseBusiness.getEnterprise(id);
    }

    @DeleteMapping(value = "/deleteEnterprise/{id}")
    public void deleteEnterprise(@PathVariable("id") long id){
        Enterprise e = enterpriseBusiness.getEnterprise(id);
        enterpriseBusiness.deleteEnterprise(e);
    }

    @PutMapping(value = "/updateEnterprise/{id}")
    public Enterprise updateEnterprise(@PathVariable("id") long id, @RequestBody Enterprise n){
        Enterprise e = enterpriseBusiness.getEnterprise(id);
        return enterpriseBusiness.updateEnterprise(e,n.getName(),n.getDescription(),n.getEmail(),n.getPhone(),n.getAddress(),n.isPartner());
    }

    @GetMapping("/getAllPartners")
    public List<Enterprise> getAllPartners(){
        return enterpriseBusiness.getAllPartners();
    }

}
