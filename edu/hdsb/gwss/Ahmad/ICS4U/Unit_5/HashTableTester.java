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
public class HashTableTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Student ahmad = new Student(350, "Ahmad");
        
        //Test #1 - Empty
        
        HashTable list = new HashTable();
        
        Student test = new Student(123, "Ahmad", "Elmasri", 2899521479L);
        Student secondTest = new Student (521, "Ahmad", "Elmasri", 2899521479L);
        
        
          
        
        //size() == 0
        //capacity == 53
        //contains(123)
        //get(123)
        //contains(Student)
        //containsKey(123)
        //loadFactor()
        //Test 1 - Empty Hashtable
        list.displayStudents();
        System.out.println("-------------------");
        System.out.println("TEST 1 : EMPTY HASHTABLE");
        
        System.out.println("Size: " + list.size());
        assert(list.size() == 0);
        
        System.out.println("Capacity: " + list.capacity());
        assert(list.capacity() == 53);
        
        System.out.println("Contains Key: " +list.containsKey(test.getKey()));
        assert(!list.containsKey(test.getKey()));
        
        System.out.println("Student get: " + list.get(test.getKey()).toString());
        assert(list.get(test.getKey()).toString().equals("STUDENT EMPTY"));
        
        System.out.println("Contains " + test.getFirstName() + " " + test.getLastName() + ": " + list.contains(test));
        assert(!list.contains(test));
        
        System.out.println("Load Factor: " + list.loadFactor());
        assert(list.loadFactor() == 0);
        
        System.out.println("TEST 1 : SUCCESS");
        System.out.println("-------------------");
        
        
        
        
        
        //Test 2 - Single Entry
        list.put(test.getKey(), test);
        list.displayStudents();
        System.out.println("-------------------");
        System.out.println("TEST 2 : SINGLE ENTRY");
        
        System.out.println("Size: " + list.size());
        assert(list.size() == 1);
        
        System.out.println("Capacity: " + list.capacity());
        assert(list.capacity() == 53);
        
        System.out.println("Contains Key: " +list.containsKey(test.getKey()));
        assert(list.containsKey(test.getKey()));
        
        System.out.println("Student get: " + list.get(test.getKey()).toString());
        assert(list.get(test.getKey()).toString().equals(test.toString()));
        
        System.out.println("Contains " + test.getFirstName() + " " + test.getLastName() + ": " + list.contains(test));
        assert(list.contains(test));
        
        System.out.println("Load Factor: " + list.loadFactor());
        assert(list.loadFactor() == (((double)1/53) * 100));
        
        System.out.println("TEST 2 : SUCCESS");
        System.out.println("-------------------");
        
        //Test 3 - Making Sure the same key does not get inserted twice
        System.out.println("TEST 3 : CHECKING FOR REPEATING DATA WITH PRIMARY KEY");
        System.out.println("Putting Student " + test.getFirstName() + " with key " + test.getKey() );
        list.put(test.getKey(), test);
        assert(list.contains(test));
        assert(list.containsKey(123));
        assert(list.size() == 1);
        assert(list.capacity() == 53);
        assert(list.loadFactor() == (((double)1/53) * 100));
        
        //Test 4 - Making sure the same two students don't exist (Different keys but same information)
        System.out.println("TEST 4 : CHECKING FOR REPEATING DATA WITH SECONDARY KEY");
        System.out.println("Putting Student " + secondTest.getFirstName() + " with key " + secondTest.getKey() );
        list.put(secondTest.getKey(), secondTest);
        assert(list.contains(test));
        assert(list.containsKey(123));
        assert(!list.containsKey(secondTest.getKey()));
        assert(list.size() == 1);
        assert(list.capacity() == 53);
        assert(list.loadFactor() == (((double)1/53) * 100));
        
        //Making an array of students to add ( No resizing yet ) 
        System.out.println("-------------------");
        System.out.println("TEST 5 - LOAD FACTORS AND LARGE STUDENT LISTS");
        
        String[] firstNames = { "Ahmad", "James", "Johnathan", "Omar", "Sally", "Olivia", "Zachary", "Caitlin", "Sean", "Samantha"};
        String[] lastNames = {"El Masri", "Mohammed", "Gurgul", "Connery", "Hamzawi", "DeLuca", "Antonio" , "Hailey"};
        Student[] studentsToAdd = new Student[38];
        for (int i = 0; i < studentsToAdd.length; i++) {
            Student tempStudent = new Student(((int)(Math.random() * 10000)) + i , firstNames[(int)(Math.random() * firstNames.length)], lastNames[(int)(Math.random() * lastNames.length)],2899526578L + (int)(Math.random() * 99999999) + i);
            tempStudent.generateKey();
            studentsToAdd[i] = tempStudent;
        }
        
        for (int i = 0; i < studentsToAdd.length; i++) {
            list.put(studentsToAdd[i].getKey(), studentsToAdd[i]);
        }
        
        //Check if they all exist
        for (int i = 0; i < studentsToAdd.length; i++) {
            assert(list.contains(studentsToAdd[i]));
        }
        
        list.displayStudents();
        
        
        System.out.println("Size: " + list.size());
        assert(list.size() == 39);
        
        System.out.println("Capacity: " + list.capacity());
        assert(list.capacity() == 53);
        
        
        
        System.out.println("Load Factor: " + list.loadFactor());
        assert(list.loadFactor() == ((double)39 / 53 * 100));
        
        Student resizeStudent = new Student(12345678, "Micheal","Jackson", 2719362190331L);
        list.put(12345678, resizeStudent);
        
        
        
        //Test 6 - Resizing the list
        list.displayStudents();
        System.out.println("-------------------");
        System.out.println("TEST 6 : RESIZE HASHTABLE");
        
        System.out.println("Size: " + list.size());
        assert(list.size() == 40);
        
        System.out.println("Capacity: " + list.capacity());
        assert(list.capacity() == 163);
        
        
        System.out.println("Student get: " + list.get(test.getKey()).toString());
        assert(list.get(test.getKey()).toString().equals(test.toString()));
        
        System.out.println("Contains " + test.getFirstName() + " " + test.getLastName() + ": " + list.contains(test));
        assert(list.contains(test));
        
//        System.out.println("Load Factor: " + list.loadFactor());
//        assert(list.loadFactor() == 0);
        
        System.out.println("TEST 6 : SUCCESS");
        System.out.println("-------------------");
        

    }

}
