package com.example.project;

import java.util.Date;

enum Status{
    ToDo, Complete
}

public class Item {
    private String name;
    private String description;
    private Status status;
    private String deadLine;

    Item(String name, String description, String deadLine){
        this.status=Status.ToDo;
        this.name=name;
        this.description=description;
        this.deadLine="";
    }

    public void UpdateItem(){
        this.status=Status.Complete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

}
