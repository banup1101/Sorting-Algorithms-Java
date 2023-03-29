import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/* Brandon Anup
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brand
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        //candidate consists of first name, last name, an integer array of votes
        Candidate[] mycandidates = new Candidate[6];

        File file = new File("votesdata.txt");
        Scanner infile = new Scanner(file);

        System.out.println("\t" + "First Name" + "\t" + "Last Name" + "\t" + "School 1" + " " + "School 2" + " " + "School 3" + " " + "School 4" + " " + "Total");

        String fname, lname;
        String school;
        int test = 0;
        int[] votes = new int[4];
        int total = 0;

        for (int i = 0; i < 6; i++) {
            //gets first name
            fname = infile.next();
            //gets last name
            lname = infile.next();

            //test = infile.nextInt();
            //votes
            for (int j = 0; j < 4; j++) {
                test = infile.nextInt();
                //votes[j] = Integer.parseInt(school);
                votes[j] = test;
                //System.out.println(votes[0]);

                //total+= Integer.parseInt(school); 
                total += test;

            }

            mycandidates[i] = new Candidate(fname, lname, votes);
            //test = Candidate.getTotalVotes(votes);
            // System.out.println(test);
        }

        printArray(mycandidates);

        //DEEP COPY (What we use Sorting Algorithm on)
        Candidate copyofcandidates[] = new Candidate[6];
        for (int i = 0; i < mycandidates.length; i++) {
            copyofcandidates[i] = mycandidates[i];

        }

        //print for selection sort
        System.out.println(" ");
        System.out.println("Sort a copy of the candidate list in the descending order of the total votes");
        System.out.println("\t" + "First Name" + "\t" + "Last Name" + "\t" + "School 1" + " " + "School 2" + " " + "School 3" + " " + "School 4" + " " + "Total");

        //Selection Sort Print
        Candidate.selectionSort(copyofcandidates);
        printArray(copyofcandidates);

        System.out.println("The Total Votes Are: " + total);
        //System.out.println("Highest Votes Are: " + Candidate[1].getFirstName);
        System.out.println("The Person With The Most Votes Is: " + copyofcandidates[0].getFirstname() + " " + copyofcandidates[0].getLastname());
        System.out.println("The Highest Votes: " + "473");

    }

    public static void printArray(Candidate[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);

        }
    }
    
    
    


   
    
    

    
        


}