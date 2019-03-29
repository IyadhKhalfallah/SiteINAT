package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.EnterprisePhotoRepository;
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

    @Autowired
    EnterprisePhotoRepository enterprisePhotoRepository;

    public Enterprise createEnterprise(String name, String description, String email, Long phone, String address, boolean partner, boolean sponsor){
        Enterprise e = new Enterprise(name,description,email,phone,address,partner,sponsor);
        enterpriseRepository.save(e);
        return e;
    }

    public Enterprise getEnterprise(long id){
            return enterpriseRepository.getOne(id);
    }

    public void deleteEnterprise(Enterprise enterprise){
            List<Project> projects = enterprise.getProjects();
            Iterator<Project> iter = projects.iterator();
            while (iter.hasNext()) {
                Project t = iter.next();
                projectRepository.delete(t);
            }
            List<EnterprisePhoto> photos = enterprise.getEnterprisephotos();
            Iterator<EnterprisePhoto> iterp = photos.iterator();
            while (iterp.hasNext()) {
            EnterprisePhoto p = iterp.next();
            enterprisePhotoRepository.delete(p);
            }
            Enterprise e = enterpriseRepository.getOne(enterprise.getEnterpriseid());
            enterpriseRepository.delete(e);
    }

    public Enterprise updateEnterprise(Enterprise e, String name, String description, String email, Long phone, String address, boolean partner){
            e.setName(name);
            e.setDescription(description);
            e.setEmail(email);
            e.setPhone(phone);
            e.setAddress(address);
            e.setPartner(partner);
            enterpriseRepository.save(e);
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

    public List<Enterprise> getAllSponsors(){
        List<Enterprise> all=enterpriseRepository.findAll();
        List<Enterprise> the=new ArrayList<>();
        Iterator<Enterprise> it=all.iterator();
        while(it.hasNext()){
            Enterprise e=it.next();
            if(e.isSponsor())
                the.add(e);
        }
        return the;
    }

    public EnterprisePhoto addPhoto(Enterprise e, String path){
        EnterprisePhoto ep = new EnterprisePhoto(e, path);
        enterprisePhotoRepository.save(ep);
        return ep;
    }

    public EnterprisePhoto getPhoto(Long id){
        return enterprisePhotoRepository.getOne(id);
    }

    public void removePhoto(EnterprisePhoto ep){
        EnterprisePhoto e = enterprisePhotoRepository.getOne(ep.getPhotoid());
        enterprisePhotoRepository.delete(e);
    }

    public EnterprisePhoto updatePhoto(EnterprisePhoto e, String path){
        e.setPath(path);
        enterprisePhotoRepository.save(e);
        return e;
    }

    public List<EnterprisePhoto> getPhotos(Enterprise e){
        List<EnterprisePhoto> all=enterprisePhotoRepository.findAll();
        List<EnterprisePhoto> the=new ArrayList<>();
        Iterator<EnterprisePhoto> it=all.iterator();
        while(it.hasNext()){
            EnterprisePhoto ep=it.next();
            if(e.getEnterpriseid()==ep.getEnterprise().getEnterpriseid())
                the.add(ep);
        }
        return the;
    }
}
