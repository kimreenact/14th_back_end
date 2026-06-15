package com.example.owcs.domain;


import lombok.Getter;

public class Owcs {

    private Long id;
    private String team;
    private String nickname;
    private String position;
    private String heros;

    public Owcs(Long id, String team, String nickname, String position, String heros ){
        this.id = id;
        this.team = team;
        this.nickname = nickname;
        this.position = position;
        this.heros = heros;
    }

    public Long getId(){
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPosition() {
        return position;
    }

    public String getHeros() {
        return heros;
    }

    public void update(String team, String nickname, String position, String heros){
        this.team = team;
        this.nickname = nickname;
        this.position = position;
        this.heros = heros;
    }
}
