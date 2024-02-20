package com.asule.database;



import com.asule.application.model.Member;
import com.asule.application.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
    private List<Member> members = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private static Database dbInstance;
    private  String databaseCreatedAt;

    public Database() {}
    public static Database getDbInstance() {
        if(dbInstance == null) {
            dbInstance = new Database();
            System.out.println("Database instance created");
        }
        return dbInstance;
    }

    public List<Member> getEvents() {
        return members;
    }

    public void setEvents(List<Member> events) {
        if(members != null) {
            this.members = events;
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        if(users != null) {
            this.users = users;
        }
    }
    public List<Member> getMember() {
        return members;
    }
    
    public String getDatabaseCreatedAt() {
        return null;
    }
}
