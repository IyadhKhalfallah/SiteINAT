package inatjunior.website.Repositories;

import inatjunior.website.Entities.EventPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPhotoRepository extends JpaRepository<EventPhoto,Long> {
}
