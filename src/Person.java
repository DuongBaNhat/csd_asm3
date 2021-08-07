package model;

import java.util.Scanner;

public class Person {
    private String ID;
    private String name, birthplace, dob;
    private boolean isDeleted = false;

    //Constructor
    public Person(){}
    public Person(String ID, String name, String birthplace, String dob) {
        this.ID = ID;
        this.name = name;
        this.birthplace = birthplace;
        this.dob = dob;
    }

    public static String dataPersonFrame() {
        return String.format("%-10s%-20s%-20s%-20s%-20s", "ID", "NAME", "BIRTHPLACE", "DOB","\n----------------------------------------------------------");
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20s", ID, name, birthplace, dob);
    }

    @Override
    public boolean equals(Object object) {
        return (object == this)?true:false;
    }

    //Getter, setter method

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getDob() {
        return dob;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
