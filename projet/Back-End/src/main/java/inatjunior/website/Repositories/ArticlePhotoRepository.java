package inatjunior.website.Repositories;

import inatjunior.website.Entities.ArticlePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlePhotoRepository extends JpaRepository<ArticlePhoto,Long> {
}
