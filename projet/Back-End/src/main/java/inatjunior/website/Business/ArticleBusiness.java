package inatjunior.website.Business;

import inatjunior.website.Entities.*;
import inatjunior.website.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleBusiness {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticlePhotoRepository articlePhotoRepository;

    public Article createArticle(String name, Date date, String shortdescription, String longdescription){
        Article e = new Article(name,date,shortdescription,longdescription);
        articleRepository.save(e);
        return e;
    }

    public Article getArticle(long id){
        return articleRepository.getOne(id);
    }

    public void deleteArticle(Article article){
        List<ArticlePhoto> photos = article.getArticlephotos();
        Iterator<ArticlePhoto> iterp = photos.iterator();
        while (iterp.hasNext()) {
            ArticlePhoto p = iterp.next();
            articlePhotoRepository.delete(p);
        }
        Article e = articleRepository.getOne(article.getArticleid());
        articleRepository.delete(e);
    }

    public Article updateArticle(Article e, String name, Date date, String shortdescription, String longdescription){
        e.setName(name);
        e.setDate(date);
        e.setShortdescription(shortdescription);
        e.setLongdescription(longdescription);
        articleRepository.save(e);
        return e;
    }

    public ArticlePhoto addPhoto(Article e, String path){
        ArticlePhoto ep = new ArticlePhoto(e, path);
        articlePhotoRepository.save(ep);
        return ep;
    }

    public ArticlePhoto getPhoto(Long id){
        return articlePhotoRepository.getOne(id);
    }

    public void removePhoto(ArticlePhoto ep){
        ArticlePhoto e = articlePhotoRepository.getOne(ep.getPhotoid());
        articlePhotoRepository.delete(e);
    }

    public ArticlePhoto updatePhoto(ArticlePhoto e, String path){
        e.setPath(path);
        articlePhotoRepository.save(e);
        return e;
    }

    public List<ArticlePhoto> getPhotos(Article e){
        List<ArticlePhoto> all=articlePhotoRepository.findAll();
        List<ArticlePhoto> the=new ArrayList<>();
        Iterator<ArticlePhoto> it=all.iterator();
        while(it.hasNext()){
            ArticlePhoto ep=it.next();
            if(e.getArticleid()==ep.getArticle().getArticleid())
                the.add(ep);
        }
        return the;
    }
}
