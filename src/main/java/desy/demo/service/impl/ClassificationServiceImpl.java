package desy.demo.service.impl;

import desy.demo.model.entity.Classification;
import desy.demo.model.entity.ClassificationName;
import desy.demo.repository.ClassificationRepository;
import desy.demo.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {

private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassification() {
        if(classificationRepository.count()==0){
            Arrays.stream(ClassificationName.values())
                    .forEach((classificationName -> {
                        this.classificationRepository
                                .save(new Classification(classificationName,
                                        String.format("Description for %s",classificationName.name())));
                    }));
        }

    }

    @Override
    public Classification findByClassificationaname(ClassificationName classificationName) {
        return this.classificationRepository.findByClassificationName(classificationName).orElse(null);
    }
}
