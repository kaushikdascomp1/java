package com.interview.java.designpatterns.stackoverflow.model;

import com.interview.java.designpatterns.stackoverflow.enums.QuestionClosingRemark;
import com.interview.java.designpatterns.stackoverflow.enums.QuestionStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Members should be able to post new questions.
 * Members should be able to add an answer to an open question.
 * Members can add comments to any question or answer.
 */


@Table(name = "question")
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    @Column
    public String title;
    @Column
    public String desc;
    @Column
    public int upVote;
    @Column
    public QuestionStatus status;

    //This answer cannot exist individually without the question that's why (orphanremoval is true and cascade type is all) where it will delete any child not associated with parents
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_id")
    public List<Answer> answers = new ArrayList<>();

    @Column
    public QuestionClosingRemark questionClosingRemark;
    @Column
    public LocalDateTime createdTime;
    @Column
    public LocalDateTime lastUpdatedTime;

    public boolean close(int questionId){
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    public QuestionStatus getStatus() {
        return status;
    }

    public void setStatus(QuestionStatus status) {
        this.status = status;
    }

    public QuestionClosingRemark getQuestionClosingRemark() {
        return questionClosingRemark;
    }

    public void setQuestionClosingRemark(QuestionClosingRemark questionClosingRemark) {
        this.questionClosingRemark = questionClosingRemark;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", upVote=" + upVote +
                ", status=" + status +
               // ", answers=" + answers +
                ", questionClosingRemark=" + questionClosingRemark +
                ", createdTime=" + createdTime +
                ", lastUpdatedTime=" + lastUpdatedTime +
                '}';
    }
}
