import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class Basics{
    public void printNum(){
        for(int i = 1; i <= 255; i++){
            System.out.println(i);
        }
        return;
    }
    public void printOdd(){
        for(int i = 1; i <= 255; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
        return;
    }
    public void printSum(){
        int sum = 0;
        for(int i = 0; i <= 255; i++){
            sum += i;
            String result = String.format("New number: %d Sum: %d", i, sum);
            System.out.println(result);
        }
        return;
    }
    public void loopArr(int[] arr){
        for(int number: arr){
            System.out.println(number);
        }
        return;
    }
    public int findMax(int[] inputArr){
        int[] myArr = inputArr;
        int max = inputArr[0];
        for(int i=1;i<myArr.length;i++){
            if(myArr[i]>max){
                max = myArr[i];
            }
        }
        return max;
    }
    public int findAvg(int[] arr){
        int sum = 0;
        for(int number: arr){
            sum += number;
        }
        int avg = sum / arr.length;
        return avg;
    }
    public ArrayList<Integer>oddArr(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(Integer i = 1; i <= 255; i++){
            if( i % 2 != 0){
                y.add(i);
            }
        }
        return(y);
    }
    public int greaterThan(int[] arr, int val){
        int count = 0;
        for(int number: arr){
            if(number > val){
                count++;
            }
        }
        return count;
    }
    public int[] squared(int[] arr){
        for(int i=0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
        return arr;
    }
    public int[] noNegative(int[] arr){
        for(int i=0; i < arr.length; i++){
            if(arr[i]<0){
                arr[i] = 0;
            }
        }
        return arr;
    }
    public int[] minMaxAvg(int[] arr){
        int max, min, sum, avg;
        max = min = sum = avg = 0;
        for(int i=0; i<arr.length;i++){
            sum += arr[i];
            if(arr[i]> max){
                max = arr[i];
            }
            if( arr[i]< min){
                min = arr[i];
            }
        }
        avg = sum / arr.length;
        int[] newArr = {max, min, avg};
        return newArr;
    }
    public int[] shiftArr(int[] arr){
        for(int i=1; i<arr.length-1;i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = 0;
        return arr;
    }

}
