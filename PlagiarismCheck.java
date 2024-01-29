import java.util.Scanner;

public class PlagiarismCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Text document
        System.out.println("Enter the text document:");
        String textDocument = scanner.nextLine();

        // Input: Pattern to search for
        System.out.println("Enter the pattern to search for:");
        String pattern = scanner.nextLine();

        // Output: Count of occurrences
        int occurrences = countOccurrences(textDocument, pattern);
        System.out.println("Count of occurrences: " + occurrences);
    }

    private static int countOccurrences(String textDocument, String pattern) {
        int count = 0;
        int index = textDocument.indexOf(pattern);

        //iterate through text document and count occurences
        while(index != -1){
            count++;
            index = textDocument.indexOf(pattern,index + 1);
        }
        return count;
    }

}

/*

Problem Statement
In an academic institution, the faculty is concerned about the possibility of plagiarism in student papers. To address this concern, the institution has decided to implement a plagiarism detection system. The system aims to find instances where a specific pattern (a sequence of words or phrases) appears in multiple papers. As part of this system, you are tasked with implementing a solution that efficiently identifies the count of occurrences of a given pattern within a large collection of text documents.

Input Format
Line1: Collection of academic papers stored as a text document 
Line 2: Specific pattern that you want to search for within these papers.
Output Format
The expected output of the program would be the count of occurrences of the pattern in the text document.
Example
Sample Input 1
This is an academic paper discussing the importance of algorithms in computer science. algorithms play a crucial role in various applications, including plagiarism detection.              // First input text (separated by space)
algorithm           // Second input pattern that needs to be checked (case sensitive)

Sample Output 1
2                         // count of occurrences of the second input in the first input
Sample Input 2
Java is a powerful programming language commonly used in software development.  // First input text (separated by space)
java           // Second input pattern that needs to be checked (case sensitive)
Sample Output 2
0                   // count of occurrences of the second input in the first input
Sample test case Explanation
In the first test case, count the number of occurrences in first input. algorithm is present two times so the output is 2.
In the second test case, as its case sensitive java is not present in text anywhere, so its output is 0.

 */
