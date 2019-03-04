package inatjunior.website.Repositories;

import inatjunior.website.Entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface TrainingRepository extends JpaRepository<Training,Long> {



}
