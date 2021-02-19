package desy.demo.model.view;

import desy.demo.model.entity.ClassificationName;

import java.time.LocalDate;

public class TaskViewModel {
    private String id;
    private String name;
    private String assigned_to;
    private String progress;
    private LocalDate due_date;
    private ClassificationName classification;

    public TaskViewModel() {
    }

    public String getId() {
        return id;
    }

    public TaskViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public TaskViewModel setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
        return this;
    }

    public String getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(String progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public TaskViewModel setDue_date(LocalDate due_date) {
        this.due_date = due_date;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }
}
