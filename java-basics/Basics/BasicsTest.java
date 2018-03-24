import java.util.ArrayList;

public class BasicsTest{
    public static void main(String[] args){
        Basics iD = new Basics();
        int[]arr = {5,8,2,25,1,-6,9};
        
        int[] answer = iD.shiftArr(arr);
        System.out.println(java.util.Arrays.toString(answer));

    }
}