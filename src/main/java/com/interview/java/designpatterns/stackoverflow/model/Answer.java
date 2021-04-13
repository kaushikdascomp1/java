package com.interview.java.designpatterns.stackoverflow.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "answer")
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String text;

    @Column
    public int voteCount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id")
    public List<Comment> commentList = new ArrayList<Comment>();

    public Answer(){

    }

    public Answer(String text, int voteCount){
        this.text = text;
        this.voteCount += voteCount;
    }

    public Answer(String text, int voteCount,List<Comment> list){
        this.text = text;
        this.voteCount += voteCount;
        this.commentList = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
//public Member creatingMember;


    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", voteCount=" + voteCount +
                '}';
    }
}
