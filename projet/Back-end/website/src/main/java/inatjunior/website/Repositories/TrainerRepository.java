package inatjunior.website.Repositories;

import inatjunior.website.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,TrainerKey> {
}
