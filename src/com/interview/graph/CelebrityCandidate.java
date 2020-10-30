package src.com.interview.graph;

public class CelebrityCandidate {

    /*
    In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
    We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.
Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} }
Output:id = 2
Explanation: The person with ID 2 does not
know anyone but everyone knows him
     */
    static int MATRIX[][] = { { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };
    public static void main(String[] args) {
        System.out.println(celebrity(4));
    }

    public static boolean knows(int a, int b){
        return MATRIX[a][b] == 1?true:false;
    }

    public static int celebrity(int n){
        int candidate = 0;
        for(int i=1;i<n;i++){
            if(knows(candidate,i))
                candidate = i;
        }

        //Loop to go through all ppl
        for(int i=0;i<n;i++){
            //The person should not be candidate, checking with itself
            //candidate should not know anyone
            //Other ppl doesn't know candidate then he is not candiddate
            if(i!=candidate && knows(candidate,i) && !knows(i,candidate))
                return -1;
        }
        return candidate;

    }

}
