package com.rest.api.model;

import java.util.Random;

public class Cinema {
    private long id;
    private final String name;
    private final int room;
    private final int places;
    private final String screensize;
    private final int exit;
    private final int duration;


    public Cinema(long id, String name) {
        this.id = id;
        this.name = name;
        this.room = new Random().nextInt(5);
        this.duration = new Random().nextInt((120 - 60) + 1) + 60;
        this.exit = new Random().nextInt((5 - 3) + 1) + 3;
        this.screensize = "54000 x32000";
        this.places = new Random().nextInt((150 - 100) + 1) + 100;
    }

    public int getPlaces() {
        return places;
    }

    public String getScreensize() {
        return screensize;
    }

    public int getExit() {
        return exit;
    }

    public int getDuration() {
        return duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getRoom() {
        return room;
    }



}
