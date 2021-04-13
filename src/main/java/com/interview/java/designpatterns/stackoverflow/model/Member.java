package com.interview.java.designpatterns.stackoverflow.model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Account account;


    // private List<Badge> badges;

    public Member(){

    }

    public int getReputation(){
        return 0;
    }
    public String getEmail(){
        return "";
    }

    public boolean createQuestion(Question question) {
        return false;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public boolean createTag(Tag tag);
}
