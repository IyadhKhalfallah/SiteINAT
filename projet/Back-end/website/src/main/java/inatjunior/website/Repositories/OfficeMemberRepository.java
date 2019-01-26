package inatjunior.website.Repositories;

import inatjunior.website.Entities.OfficeMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeMemberRepository extends JpaRepository<OfficeMember,Long> {
}
