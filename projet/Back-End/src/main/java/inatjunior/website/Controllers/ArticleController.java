package inatjunior.website.Controllers;

import inatjunior.website.Business.ArticleBusiness;
import inatjunior.website.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArticleController {
    @Autowired
    ArticleBusiness articleBusiness;

    @PostMapping("/article")
    public Article createArticle(@RequestBody Article e){
        return articleBusiness.createArticle(e.getName(),e.getDate(),e.getShortdescription(),e.getLongdescription());
    }

    @GetMapping(value = "/article/{id}")
    public Article getArticle(@PathVariable("id") long id){
        return articleBusiness.getArticle(id);
    }

    @GetMapping(value = "/article/all")
    public List<Article> getArticle(){

        return articleBusiness.getAllArticles();
    }

    @DeleteMapping(value = "/article/{id}")
    public void deleteArticle(@PathVariable("id") long id){
        Article e = articleBusiness.getArticle(id);
        articleBusiness.deleteArticle(e);
    }

    @PutMapping(value = "/article/{id}")
    public Article updateArticle(@PathVariable("id") long id, @RequestBody Article n){
        Article e = articleBusiness.getArticle(id);
        return articleBusiness.updateArticle(e,n.getName(),n.getDate(),n.getShortdescription(),n.getLongdescription());
    }

    @PostMapping("/articlephoto/{articleid}")
    public ArticlePhoto addPhoto(@PathVariable long articleid, @RequestParam("path") String path){
        return articleBusiness.addPhoto(articleBusiness.getArticle(articleid),path);
    }

    @DeleteMapping("/articlephoto/{id}")
    public void removePhoto(@PathVariable long id){
        articleBusiness.removePhoto(articleBusiness.getPhoto(id));
    }

    @GetMapping("/articlephoto/{id}")
    public ArticlePhoto getPhoto(@PathVariable long id){
        return articleBusiness.getPhoto(id);
    }

    @PutMapping("/articlephoto/{id}")
    public ArticlePhoto updatePhoto(@PathVariable("id") long id, @RequestParam("path") String path){
        ArticlePhoto ep=articleBusiness.getPhoto(id);
        return articleBusiness.updatePhoto(ep,path);
    }

    @GetMapping("/articlephotos/{articleid}")
    public List<ArticlePhoto> getPhotos(@PathVariable long articleid){
        return articleBusiness.getPhotos(articleBusiness.getArticle(articleid));
    }

}
