
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brand
 */
public class Candidate {

    private String firstname;
    private String lastname;
    private int votes[] = new int[4];

    public Candidate() {
        firstname = "None";
        lastname = "None";
        votes = null;
    }

    public Candidate(String firstname, String lastname, int votes[]) {
        this.firstname = firstname;
        this.lastname = lastname;
        for (int i = 0; i < 4; i++) {
            this.votes[i] = votes[i];
        }
    }

    public Candidate(Candidate other) {
        firstname = other.firstname;
        lastname = other.lastname;
        for (int i = 0; i < 4; i++) {
            votes = other.votes;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int[] getVotes() {
        return this.votes;
    }

    public void setVotes(int[] votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        String str = String.format("%16s%16s%26s,%20d", firstname, lastname, Arrays.toString(this.votes), getTotalVotes(this.votes));
        return str;
    }

    public static int getTotalVotes(int[] votes) {
        int total = 0;
        for (int i = 0; i < votes.length; i++) {
            //this.votes[i] = votes[i];
            total += votes[i];

        }
        //System.out.println(total);
        return total;
    }

    public static void swap(Candidate[] list, int i, int j) {
        Candidate tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    public static int indexOfSmallest(Candidate[] list, int first, int last) {
        int indexOfMin = first;
        for (int i = 0; i < list.length; i++) {
            int min = list[first].getTotalVotes(list[i].getVotes()); 
            
            for (int k = first + 1; k <= last; k++) { //first+1 because we assume the first element is the minimum so start at second element
                if (list[k].getTotalVotes(list[k].getVotes()) > min) {
                    min = list[k].getTotalVotes(list[k].getVotes());
                    indexOfMin = k;
                    
                }
            }
            //return indexOfMin;
        }
        return indexOfMin;
    }
    
    

    public static void selectionSort(Candidate[] list) {
        int i, j, indexOfMin;
        int size = list.length;
            for (i = 0; i < size - 1; i++) {
                indexOfMin = indexOfSmallest(list, i, size - 1);
                swap(list, i, indexOfMin);
            }
        

    }

}
