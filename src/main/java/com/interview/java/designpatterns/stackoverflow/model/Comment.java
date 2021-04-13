package com.interview.java.designpatterns.stackoverflow.model;

import javax.persistence.*;

@Table(name = "comment")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column
    public String text;
    @Column
    public int voteCount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Member askingMember;


    public Comment(String text, int voteCount, Member member) {
        this.text = text;
        this.voteCount = voteCount;
        this.askingMember = member;
    }


    public Comment() {

    }

    public Comment(String text, int voteCount) {
        this.text = text;
        this.voteCount = voteCount;
    }


    public boolean incrementVoteCount() {
        return false;
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

    public Member getAskingMember() {
        return askingMember;
    }

    public void setAskingMember(Member askingMember) {
        this.askingMember = askingMember;
    }

}
