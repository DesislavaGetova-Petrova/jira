package desy.demo.model.binding;

import desy.demo.model.entity.Classification;
import desy.demo.model.entity.ClassificationName;
import desy.demo.model.entity.ProgressType;
import desy.demo.model.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class TaskAddBindingModel {
    private String name;
    private String description;
    private LocalDateTime dueDate;
    private ClassificationName classification;

    public TaskAddBindingModel() {
    }
    @NotBlank
    @Size(min=3,max=20, message = "Name must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public TaskAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @Size(min=5, message = "Description must be more then 5 characters!")
    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
    @DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }
    @NotBlank(message = "Cannot be null")
    public TaskAddBindingModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }
}
