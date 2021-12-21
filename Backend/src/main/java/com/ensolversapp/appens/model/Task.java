package com.ensolversapp.appens.model;

import javax.persistence.*;
import java.io.Serializable; // Helps transform java class into dif types of strings


@Entity // Allows us to connect to db
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String to_do;
    private boolean is_done = false;
    private String folder="None";

    public Task() {}

    public Task(String to_do){
    this.to_do = to_do;
    this.is_done = false;
    this.folder = "None";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo_do() {
        return to_do;
    }

    public void setTo_do(String to_do) {
        this.to_do = to_do;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id +
                "to_do='" + to_do + '\''+
                "is_done='" + is_done + '\''+
                "folder='" + folder +'\'' +
                '}';
    }

}
