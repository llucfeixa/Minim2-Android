package com.grupo3.androiddsa.domain;

public class Partida {
    String email;
    String date;
    int points;
    String avatar;

    public Partida() {

    }

    public Partida(String email, String date, int points, String avatar) {
        this.email = email;
        this.date = date;
        this.points = points;
        this.avatar = avatar;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}