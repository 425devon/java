import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJavaTest{
    public static void main(String[] args){
        PuzzleJava iD = new PuzzleJava();
        /*
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        ArrayList answer = iD.sumGreat(arr, 10);
        System.out.println(answer.toString());
        ---
        ArrayList answer = iD.nameGame();
        System.out.println(answer);
        ---
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        iD.randomAlpha(alphabet);
        ---
        int[] answer = iD.randomTen();
        System.out.println(Arrays.toString(answer));
        ---
        int[] answer = iD.randomSorted();
        System.out.println(Arrays.toString(answer));
        ---
        String answer = iD.randString();
        System.out.println(answer);
        */
        String[] answer = iD.jibber();
        System.out.println(Arrays.toString(answer));
    }
}