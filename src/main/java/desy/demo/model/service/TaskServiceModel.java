package desy.demo.model.service;

import desy.demo.model.entity.Classification;
import desy.demo.model.entity.ClassificationName;
import desy.demo.model.entity.ProgressType;
import desy.demo.model.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskServiceModel extends BaseServiceModel{
    private String name;
    private String description;
    private String progress;
    private LocalDate dueDate;
    private ClassificationName classification;
    private String userName;

    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getProgress() {
        return progress;
    }

    public TaskServiceModel setProgress(String progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TaskServiceModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
