package inatjunior.website.Repositories;

import inatjunior.website.Entities.MemberPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPhotoRepository extends JpaRepository<MemberPhoto,Long> {
}
