/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_5;

/**
 *
 * @author 1elmasriahm
 */
public class HashTable implements HashTableInterface {

    public Student[] studentList;
    private final int DEFAULT_SIZE = 53;

    protected HashTable(int length) {
        this.studentList = new Student[length];
    }

    public HashTable() {
        this.studentList = new Student[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        int studentAmount = 0;
        if (!this.isEmpty()) {
            studentAmount = 0;
            for (int i = 0; i < studentList.length; i++) {
                if (studentList[i] != null) {
                    studentAmount++;
                }
            }
        }

        return studentAmount;
    }

    @Override
    public int capacity() {
        return this.studentList.length;
    }

    @Override
    public double loadFactor() {
        double value = 0;
        if (!this.isEmpty()) {
            value = (((double) this.size() / this.capacity())) * 100;
        }
        return value;
    }

    @Override
    public void makeEmpty() {
        if (!this.isEmpty()) {
            for (int i = 0; i < studentList.length; i++) {
                studentList[i] = null;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    @Override
    public void rehash() { //KEEP PRIVATE
        if (this.loadFactor() >= 75) {
            Student[] holder = this.studentList;
            int newCapacity = this.capacity() * 3;
            while (!isPrime(newCapacity)) {
                newCapacity++;
            }

            this.studentList = new Student[newCapacity];
            for (int i = 0; i < holder.length; i++) {
                if (holder[i] != null) {
                    this.put(holder[i].getKey(), holder[i]);
                }
            }
        }
    }

    @Override
    public Student get(int key) {
        int position = this.hash(key);
        Student holder = new Student();//so that the to stribng method still works
        if (this.isEmpty()) {
            return holder;
        } else {
            Student s;
            boolean found = false;
            do {
                s = this.studentList[position];
                if (s != null && s.getKey() == key) {
                    found = true;
                    holder = s;
                } else {
                    position = ((position + 1) % this.capacity());
                }
            } while (!found && s != null);

        }
        return holder;
    }

    @Override
    public void put(int key, Student value) {
        int position = this.hash(key);
        if (this.isEmpty()) {
            this.studentList[position] = value;
        } else if (this.studentList[position] == null && !this.contains(value)) {
            this.studentList[position] = value;
        } else if (!this.contains(value) && !this.containsKey(key)) {
            int newPosition = ((position + 1) % this.capacity());
            while (this.studentList[newPosition] != null && newPosition != position) {
                newPosition = ((newPosition + 1) % this.capacity());

            }
            if (this.studentList[newPosition] == null) {
                this.studentList[newPosition] = value;
            }
        } else {
            System.out.println("Student Already Exists");
        }
        this.rehash();
    }

    @Override
    public boolean contains(Student value) {
        int position = this.hash(value.getKey());
        Student holder = null;
        boolean found = false;

        if (this.isEmpty()) {
            return false;
        } else {
            Student s;
            do {
                s = this.studentList[position];
                if (value.equals(s)) {
                    found = true;
                } else {
                    position = ((position + 1) % this.capacity());
                }
            } while (!found && s != null);

            if (!found) {
                for (int i = 0; i < this.capacity(); i++) {
                    if (this.studentList[i] != null) {
                        s = this.studentList[i];
                        if (s.equals(value)) {
                            found = true;
                        }
                    }
                }
            }

        }
        return found;
    }

    @Override
    public boolean containsKey(int key) {
        int position = hash(key);
        boolean keyExists = false;
        if (!this.isEmpty()) {
            if (this.studentList[position] != null) {
                if (studentList[position].getKey() == key) {
                    keyExists = true;
                } else {
                    do {
                        if (this.studentList[position].getKey() == key) {
                            keyExists = true;
                        } else {
                            position = ((position + 1) % this.capacity());
                        }
                    } while (!keyExists && this.studentList[position] != null);

                }
            }

        }
        return keyExists;
    }

    @Override
    public int hash(int key) {

        int hashCode = key % this.capacity();
        return hashCode;

    }

    public void displayStudents() {
        System.out.println("length : " + this.studentList.length);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println((i) + " : " + studentList[i].toString());
            } else {
                System.out.println((i) + " : " + "Empty");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
