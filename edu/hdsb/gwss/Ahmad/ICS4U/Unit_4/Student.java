/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_4;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1elmasriahm
 */
public class Student {

    /**
     * @param args the command line arguments
     */
    
    public static final String SCHOOL = "Garth Webb";
    
    private static int nextId;
    
    private int studentNumber;
    private String firstName;
    private String lastName;
    private Date dob;
    private int grade;
    
    public Student(){
        
    }
    
    public Student( int studentNumber ){
        this.studentNumber = studentNumber;
    }

    public Student(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }
    
    //Encapsulate : Force client to use setters and getters 

    public int getStudentNumber() {
        return studentNumber;
    }

    private void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString() {
        return "Student{" + "studentNumber=" + studentNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", grade=" + grade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (this.studentNumber > 0 && this.studentNumber == other.studentNumber) {
            return true;
        }
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
    
        public static void main(String[] args){
            Student a = new Student( 1 );
            Student b = new Student( 1 );
            Student c = new Student( 2 );
            Student d = a;
            //Student e = 
            
            System.out.println(a == b); //FALSE : Different objects
            System.out.println(a == d);//TRUE : Same object
            System.out.println(a.equals(b));//TRUE : Same object value
            System.out.println(a.equals(c));//FALSE : Different object value
            
            Date dB = new Date();
            Student aa = new Student("First", "Last", dB);
            Student ab = new Student("First", "Last", dB);
            
        }
   
    
    
}
