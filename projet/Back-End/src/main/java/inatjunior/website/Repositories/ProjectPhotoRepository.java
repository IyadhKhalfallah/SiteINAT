package inatjunior.website.Repositories;

import inatjunior.website.Entities.ProjectPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPhotoRepository extends JpaRepository<ProjectPhoto,Long> {
}
