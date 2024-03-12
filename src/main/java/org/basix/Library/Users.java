package org.basix.Library;

import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Users {

    private long id;
    private String name;
    private  String branch;
    private char semester;
    private enum type {STUDENT, PROFESSOR, OTHERS};
    private String date;

    public Users(long id, String name, String branch, char semester) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.semester = semester;
        getDate();
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

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public char getSemester() {
        return semester;
    }

    public void setSemester(char semester) {
        this.semester = semester;
    }

    public String getDate() {
        date = DateTime.now().toString("yyyy-MM-dd HH:MM:ss");
        return date;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", semester=" + semester +
                ", date='" + date + '\'' +
                '}';
    }
}
