package desy.demo.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
public class Task extends BaseEntity{
    private String name;
    private String description;
    private ProgressType progress;
    private LocalDateTime dueDate;
    private Classification classification;
    private User user;

    public Task() {
    }
    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }
    @Enumerated(value = EnumType.STRING)
    public ProgressType getProgress() {
        return progress;
    }

    public Task setProgress(ProgressType progress) {
        this.progress = progress;
        return this;
    }
    @Column(name="due_date")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
    @ManyToOne
    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }
    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
