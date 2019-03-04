package inatjunior.website.Repositories;

import inatjunior.website.Entities.EnterprisePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterprisePhotoRepository extends JpaRepository<EnterprisePhoto,Long> {
}
