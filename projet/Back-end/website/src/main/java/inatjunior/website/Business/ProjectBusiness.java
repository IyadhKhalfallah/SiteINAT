package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProjectBusiness {

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(String name, String description, Date opening, Date closing, Enterprise client){
        Project p = new Project(name,description,opening,closing,client);
        try {
            projectRepository.save(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public Project getProject (long id){
        try {
            return projectRepository.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteProject(Project p){
        try {
            Project pr = projectRepository.getOne(p.getProjectid());
            projectRepository.delete(pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Project updateProject(Project p, String name, String description, Date opening, Date closing, Enterprise client){
        try {
            p.setName(name);
            p.setDescription(description);
            p.setOpening(opening);
            p.setClosing(closing);
            p.setClient(client);
            projectRepository.save(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
}
