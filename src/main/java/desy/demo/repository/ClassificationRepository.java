package desy.demo.repository;

import desy.demo.model.entity.Classification;
import desy.demo.model.entity.ClassificationName;
import desy.demo.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification,String> {

    Optional<Classification> findByClassificationName(ClassificationName classificationName);


}
