package inatjunior.website.Controllers;


import inatjunior.website.Business.*;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProjectController {

    @Autowired
    ProjectBusiness projectBusiness;

    @Autowired
    EnterpriseBusiness enterpriseBusiness;

    @PostMapping("/project")
    public Project createProject(@RequestParam long clientid, @RequestBody Project e){
        return projectBusiness.createProject(e.getName(),e.getDescription(),e.getOpening(),e.getClosing(),e.isAcademic(),enterpriseBusiness.getEnterprise(clientid));
    }

    @GetMapping(value = "/project/{id}")
    public Project getProject(@PathVariable("id") long id){
        return projectBusiness.getProject(id);
    }

    @DeleteMapping(value = "/project/{id}")
    public void deleteProject(@PathVariable("id") long id){
        Project e = projectBusiness.getProject(id);
        projectBusiness.deleteProject(e);
    }

    @PutMapping(value = "/project/{id}")
    public Project updateProject(@PathVariable("id") long id, @RequestBody Project n, @RequestParam long clientid){
        Project e = projectBusiness.getProject(id);
        return projectBusiness.updateProject(e,n.getName(),n.getDescription(),n.getOpening(),n.getClosing(),e.isAcademic(),enterpriseBusiness.getEnterprise(clientid));
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectBusiness.getAllProjects();
    }

    @PostMapping("/projectphoto/{projectid}")
    public ProjectPhoto addPhoto(@PathVariable long projectid, @RequestParam("path") String path){
        return projectBusiness.addPhoto(projectBusiness.getProject(projectid),path);
    }

    @DeleteMapping("/projectphoto/{id}")
    public void removePhoto(@PathVariable long id){
        projectBusiness.removePhoto(projectBusiness.getPhoto(id));
    }

    @GetMapping("/projectphoto/{id}")
    public ProjectPhoto getPhoto(@PathVariable long id){
        return projectBusiness.getPhoto(id);
    }

    @PutMapping("/projectphoto/{id}")
    public ProjectPhoto updatePhoto(@PathVariable("id") long id, @RequestParam("path") String path){
        ProjectPhoto ep=projectBusiness.getPhoto(id);
        return projectBusiness.updatePhoto(ep,path);
    }

    @GetMapping("/projectphotos/{projectid}")
    public List<ProjectPhoto> getPhotos(@PathVariable long projectid){
        return projectBusiness.getPhotos(projectBusiness.getProject(projectid));
    }


}
