package desy.demo.service;

import desy.demo.model.entity.Classification;
import desy.demo.model.entity.ClassificationName;

public interface ClassificationService {
    void initClassification();

    Classification findByClassificationaname(ClassificationName classificationName);
}
