package com.memocards.memocards.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.memocards.memocards.enums.DificultyLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank(message = "This field is required.")
    private String question;
    @NotNull
    @NotBlank(message = "This field is required.")
    private String answer;
    private LocalDate creationDate;
    private LocalDate reviewDate;
    private Integer level;
    private Double daysToUpdate = 5.0;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Card(){}


    public Card(Long id, String question, String answer, LocalDate creationDate, DificultyLevel level, Subject subject) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.creationDate = creationDate;
        setLevel(level);
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public DificultyLevel getLevel() {
        return DificultyLevel.valueOf(level);
    }

    public void setLevel(DificultyLevel level) {
        if(level != null){
            this.level = level.getLevel();
        }
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getDaysToUpdate() {
        return daysToUpdate;
    }

    public void setDaysToUpdate(Double daysToUpdate) {
        this.daysToUpdate = daysToUpdate;
    }

    public String toString(){
         return "Question: " + question + "\n" +
                "Aswer: " + answer + "\n" +
                "Dificulty: " + level + "\n" +
                "Cretion: " + creationDate + "\n" +
                "Review Date: " + reviewDate;
    }
}