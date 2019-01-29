/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_5;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1elmasriahm
 */
public class Student {

    private String firstName;
    private String lastName;
    private int key;
    private long phoneNumber;
    private int yearBorn;
    private int monthBorn;
    private int dayBorn;

    public Student() {
        this.firstName = null;
        this.lastName = null;
        this.key = 0;
        this.phoneNumber = 0;
    }

    public Student(int key, String firstName, String lastName, long incoming) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.key = key;
        this.phoneNumber = incoming;
    }

    public Student(String firstName, String lastName, int key, long phoneNumber, int yearBorn, int monthBorn, int dayBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.key = key;
        this.phoneNumber = phoneNumber;
        this.yearBorn = yearBorn;
        this.monthBorn = monthBorn;
        this.dayBorn = dayBorn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public int getMonthBorn() {
        return monthBorn;
    }

    public void setMonthBorn(int monthBorn) {
        this.monthBorn = monthBorn;
    }

    public int getDayBorn() {
        return dayBorn;
    }

    public void setDayBorn(int dayBorn) {
        this.dayBorn = dayBorn;
    }

    @Override
    public String toString() {
        if (this.isValid()) {
            return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", key=" + key + ", phoneNumber=" + phoneNumber + '}';
        }else{
            return "STUDENT EMPTY";
        }
        

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + this.key;
        hash = 53 * hash + this.monthBorn;
        hash = 53 * hash + this.dayBorn;
        return hash;
    }

    
    public void generateKey() {
        if (this.isValid()) {
            int keyGen = 0;
            while(keyGen <= 0){
                keyGen = Math.abs(this.hashCode());
            } 
            this.setKey(keyGen);
        }else{
            System.out.println("Not enough information to generate a key");
        }
        
    }
    @Override
    public boolean equals(Object obj) {

        boolean isEqual = false;
        Student otherStudent = (Student) obj;

        if (this == obj) {
            return true;
        }

        if (obj == null || this == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        if (this.getKey() > 0 && otherStudent.getKey() > 0) {
            if (this.getKey() == otherStudent.getKey()) {
                isEqual = true;
            }
        }
        if (!isEqual && this.isValid() && otherStudent.isValid()) {
            if (this.firstName.equals(otherStudent.getFirstName()) && this.lastName.equals(otherStudent.getLastName()) && this.getPhoneNumber() == otherStudent.getPhoneNumber()) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    public boolean isValid() {
        boolean valid = true;
        if (this.key <= 0) {
            valid = false;
        }
        if (this.firstName == null) {
            valid = false;
        }
        if (this.lastName == null) {
            valid = false;
        }
        if (this.phoneNumber <= 0) {
            valid = false;
        }
        return valid;
    }

}
