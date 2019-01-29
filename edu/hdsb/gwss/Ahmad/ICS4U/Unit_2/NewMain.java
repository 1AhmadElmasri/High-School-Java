/*
 * Example using ArrayList
 */

import java.util.ArrayList;

public class NewMain {
  public static void main(String [] args) {
    //Create ArrayList
    ArrayList myFriends = new ArrayList();

    myFriends.add("Sheldon");
    myFriends.add("Sue");
    myFriends.add("Sammy");
    myFriends.add("Sheldon");
    
    myFriends.add("Sheldon");
    
    System.out.println(myFriends);

    //Print out only Sue (index #1)
    System.out.println(((int) myFriends.get(4)) + 12);

    //Remove Sue from the list
    myFriends.remove("Sheldon");
    myFriends.remove("Sheldon");

    //Print out the list again
    System.out.println(myFriends);
  }
}