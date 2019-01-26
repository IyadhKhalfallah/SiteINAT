package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.EnterpriseRepository;
import inatjunior.website.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EnterpriseBusiness {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Autowired
    ProjectRepository projectRepository;

    public Enterprise createEnterprise(String name, String description, String email, Long phone, String address, boolean partner){
        Enterprise e = new Enterprise(name,description,email,phone,address,partner);
        try {
            enterpriseRepository.save(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return e;
    }

    public Enterprise getEnterprise(long id){
        try {
            return enterpriseRepository.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteEnterprise(Enterprise enterprise){
        try {
            List<Project> projects = enterprise.getProjects();
            Iterator<Project> iter = projects.iterator();
            while (iter.hasNext()) {
                Project t = iter.next();
                projectRepository.delete(t);
            }
            Enterprise e = enterpriseRepository.getOne(enterprise.getEnterpriseid());
            enterpriseRepository.delete(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public Enterprise updateEnterprise(Enterprise e, String name, String description, String email, Long phone, String address, boolean partner){
        try {
            e.setName(name);
            e.setDescription(description);
            e.setEmail(email);
            e.setPhone(phone);
            e.setAddress(address);
            e.setPartner(partner);
            enterpriseRepository.save(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return e;
    }

    public List<Enterprise> getAllPartners(){
        List<Enterprise> all=enterpriseRepository.findAll();
        List<Enterprise> the=new ArrayList<>();
        Iterator<Enterprise> it=all.iterator();
        while(it.hasNext()){
            Enterprise e=it.next();
            if(e.isPartner())
                the.add(e);
        }
        return the;
    }
}
