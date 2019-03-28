package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.ProjectPhotoRepository;
import inatjunior.website.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProjectBusiness {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectPhotoRepository projectPhotoRepository;

    public Project createProject(String name, String description, Date opening, Date closing, boolean academic, Enterprise client){
        Project p = new Project(name,description,opening,closing, academic, client);
        projectRepository.save(p);
        return p;
    }

    public Project getProject (long id){
            return projectRepository.getOne(id);
    }

    public void deleteProject(Project p){
            Project pr = projectRepository.getOne(p.getProjectid());
            projectRepository.delete(pr);
    }

    public Project updateProject(Project p, String name, String description, Date opening, Date closing, boolean academic, Enterprise client){
            p.setName(name);
            p.setDescription(description);
            p.setOpening(opening);
            p.setClosing(closing);
            p.setAcademic(academic);
            p.setClient(client);
            projectRepository.save(p);
        return p;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public ProjectPhoto addPhoto(Project e, String path){
        ProjectPhoto ep = new ProjectPhoto(e, path);
        projectPhotoRepository.save(ep);
        return ep;
    }

    public ProjectPhoto getPhoto(Long id){
        return projectPhotoRepository.getOne(id);
    }

    public void removePhoto(ProjectPhoto ep){
        ProjectPhoto e = projectPhotoRepository.getOne(ep.getPhotoid());
        projectPhotoRepository.delete(e);
    }

    public ProjectPhoto updatePhoto(ProjectPhoto e, String path){
        e.setPath(path);
        projectPhotoRepository.save(e);
        return e;
    }

    public List<ProjectPhoto> getPhotos(Project e){
        List<ProjectPhoto> all=projectPhotoRepository.findAll();
        List<ProjectPhoto> the=new ArrayList<>();
        Iterator<ProjectPhoto> it=all.iterator();
        while(it.hasNext()){
            ProjectPhoto ep=it.next();
            if(e.getProjectid()==ep.getProject().getProjectid())
                the.add(ep);
        }
        return the;
    }

}
