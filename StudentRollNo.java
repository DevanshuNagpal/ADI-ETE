import java.util.*;

public class StudentRollNo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //input space separated words(student names)
        System.out.println("Enter space separated names");
        String[] names = in.nextLine().split(" ");
        
        //input roll number to be checked
        System.out.println("Enter the roll number to check");
        int rollToCheck = in.nextInt();
        //create a hashtable to store students with roll numbers
        Hashtable<Integer,String> students = new Hashtable<>();

        //Assign roll numbers and pupulate the hashtable
        for(int i = 0; i<names.length;i++){
            int rollNumber = i+1;
            students.put(rollNumber,names[i]);
        }
        //Print the list of students in descending order based on roll numbers
        printStudentDescending(students);

        //check if the given roll number is present or not
        checkRollPresent(students,rollToCheck);

    }
    public static void printStudentDescending(Hashtable<Integer,String> students){
        //create a list to store the entries of the hashtable
        List<Map.Entry<Integer,String>> list = new ArrayList<>(students.entrySet());

        //sort the list in descending order based on roll numbers
        list.sort((entry1,entry2) -> entry2.getKey().compareTo(entry1.getKey()));

        //print the sorted list
        for(Map.Entry<Integer,String> entry:list){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
    public static void checkRollPresent(Hashtable<Integer,String> students,int rollToCheck)
    {
        //check if the roll number sis present in the hashtable
        if(students.containsKey(rollToCheck)){
            System.out.println("present");
        }
        else{
            System.out.println("not present");
        }
    }
}
/*
Certainly! Let's break down the code snippet:

1. `students.entrySet()`: This method returns a set view of the mappings contained in the `students` Hashtable. Each element in the set is a `Map.Entry<Integer, String>` object, representing a key-value pair (roll number and student name).

2. `new ArrayList<>(students.entrySet())`: This creates a new ArrayList and initializes it with the elements from the set of entries obtained from the `students` Hashtable. So, `list` is now an ArrayList containing the entries (key-value pairs) from the Hashtable.

3. `list.sort((entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey()))`: This line sorts the ArrayList `list` in descending order based on the roll numbers (`entry.getKey()`). The lambda expression `(entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey())` is a comparator function that defines how the sorting should be done. It compares the keys (roll numbers) of two entries in reverse order.

4. `for (Map.Entry<Integer, String> entry : list) { ... }`: This loop iterates over the sorted list of entries (`list`) and prints each entry's key (roll number) and value (student name). It uses `entry.getKey()` to get the roll number and `entry.getValue()` to get the student name.

In summary, this code snippet creates a sorted list of entries (key-value pairs) from the `students` Hashtable based on roll numbers and then prints the sorted list. The sorting is done in descending order of roll numbers.
 */
/*
3. Making students list by their roll numbers and names and search particular student by roll no.

Problem Statement
Amrit is teaching the ADI subject in the class. He said to all students to come one by one and tell their names. Amrit is making the list of students in a sheet and adding roll no by default from 1,2,3 … and so on. After that, he also wants to search for the student, by giving the roll number and checking whether present or not.

Create a code for Amrit to input the names of the students, and their roll numbers should be added by default from 1 2 3 ….so on. After that input a roll number for searching, whether it is present or not. Print the complete list of the students with their roll numbers into descending order according to roll numbers, and check whether the searching roll no is present or not.

Input Format
First Line: Space Separated Words consists of input strings containing the names of students.
Second Line: Input the Roll no. of the student that needs to be checked present or not.
Output Format
Print the list of students with names and Roll numbers (in descending order)
Next Line returns the status of the student based on the roll number input (Present or not present)
Note: You can use “Hashtable” in java for making the students list with their roll numbers.
Example
Sample Input 1
Amit Sumit Anil    // First Line list of student names separated by space
4                             // Roll number of the student that needs to be checked (present or not)
Sample Output 1
3 Anil
2 Sumit
1 Amit
not present
Sample Input 2
Sumit Seema Gauri                   // First Line list of student names separated by space
1                                      // Roll number of the student that needs to be checked (present or not)

Sample Output 2
3 Gauri
2 Seema
1 Sumit
present

Sample test case Explanation
In the first test case, there are 3 student names taking the first word and assigning the roll number 1 to that student, similarly taking the next word and assigning the roll number 2 to that student and repeating the same process till the end of the input list. The second input is the roll number which is 4 which checks in the student list if the roll number is present, it prints present otherwise it prints not present, 4 is not present so it prints not present.
In the second test case, there are 3 student names taking the first word and assigning the roll number 1 to that student, similarly taking the next word and assigning the roll number 2 to that student and repeating the same process till the end of the input list. The second input is the roll number which is 1 which checks in the student list if the roll number is present, it prints present otherwise it prints not present, 1 is present in the list so it prints present.

 */