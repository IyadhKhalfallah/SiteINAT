package inatjunior.website.Controllers;


import inatjunior.website.Business.*;
import inatjunior.website.Entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectBusiness projectBusiness;

    @Autowired
    EnterpriseBusiness enterpriseBusiness;

    @PostMapping("/createProject")
    public Project createProject(@RequestParam long clientid, @RequestBody Project e){
        return projectBusiness.createProject(e.getName(),e.getDescription(),e.getOpening(),e.getClosing(),enterpriseBusiness.getEnterprise(clientid));
    }

    @GetMapping(value = "/getProject/{id}")
    public Project getProject(@PathVariable("id") long id){
        return projectBusiness.getProject(id);
    }

    @DeleteMapping(value = "/deleteProject/{id}")
    public void deleteProject(@PathVariable("id") long id){
        Project e = projectBusiness.getProject(id);
        projectBusiness.deleteProject(e);
    }

    @PutMapping(value = "/updateProject/{id}")
    public Project updateProject(@PathVariable("id") long id, @RequestBody Project n, @RequestParam long clientid){
        Project e = projectBusiness.getProject(id);
        return projectBusiness.updateProject(e,n.getName(),n.getDescription(),n.getOpening(),n.getClosing(),enterpriseBusiness.getEnterprise(clientid));
    }

    @GetMapping("/getAllProjects")
    public List<Project> getAllProjects(){
        return projectBusiness.getAllProjects();
    }

}
