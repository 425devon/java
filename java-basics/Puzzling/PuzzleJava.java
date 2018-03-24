import java.util.ArrayList;
import java.util.*;

public class PuzzleJava{
    public ArrayList<Integer> sumGreat(int[] arr, int greaterThan){
        int sum = 0;
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(arr[i] > greaterThan){
                newArr.add(arr[i]);
            }
        }
        System.out.println(String.format("The sum is %d", sum));
        return newArr;
    }
    public ArrayList<String> nameGame(){
        ArrayList<String> newArr = new ArrayList<String>();
        ArrayList<String> longArr = new ArrayList<String>();
        newArr.add("Nancy");
        newArr.add("Jinichi");
        newArr.add("Fujibayashi");
        newArr.add("Momochi");
        newArr.add("Ishikawa");
        newArr.add("Ted");
        Collections.shuffle(newArr);
        for(String person: newArr){
            System.out.println(person);
            if(person.length() > 5){
                longArr.add(person);
            }
        }
        return(longArr);
    }
    public void randomAlpha(Object[] alpha){
        int numOfElements = alpha.length;
        for(int i=0;i<numOfElements;i++){
            int s = i + (int)(Math.random()* (numOfElements -i));
            Object temp = alpha[s];
            alpha[s] = alpha[i];
            alpha[i] = temp;
        }
        System.out.println(alpha[alpha.length-1]);
        char ch = alpha[0].toString().charAt(0);
        if(ch == ('a') ||
        ch == ('e') ||
        ch == ('i') ||
        ch == ('o') ||
        ch == ('u')){
            System.out.println(String.format("First letter: %s is a vowel!",alpha[0]));
        }
        else{
            System.out.println(String.format("The first letter is: %s", alpha[0]));
        }
    }
    public int[] randomTen(){
        int[] randArr;
        randArr = new int[10];
        Random r = new Random();
        int i = 0;
        while(i < 10){
            randArr[i] = r.nextInt(100 - 55 + 1) + 55;
            i++;
        }
        return randArr;
    }
    public int[] randomSorted(){
        int[] randArr;
        int min;
        int max = 0;
        randArr = new int[10];
        Random r = new Random();
        int i = 0;
        while(i < 10){
            randArr[i] = r.nextInt(100 - 55 + 1) + 55;
            i++;
        }
        min = randArr[0];
        for(int n=0;n<randArr.length;n++){
            if (randArr[n]>max){
                max = randArr[n];
            }else{
                if(randArr[n]<min){
                    min = randArr[n];
                }
            }
        }
        System.out.println(String.format("The minimum is: %d and the maxium is: %d", min, max));
        Arrays.sort(randArr);
        return randArr;
    }
    public String randString(){
        String alphabet= "abcdefghijklmnopqrstuvwxyz";
        String myString = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char ch = alphabet.charAt(random.nextInt(26));
            myString+=ch;
        }
        return myString;
    }
    public String[] jibber(){
        String[] jibberish;
        jibberish = new String[10];
        String alphabet= "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        for(int n=0; n<10;n++){
            String myString = "";
            for (int i = 0; i < 5; i++) {
                char ch = alphabet.charAt(random.nextInt(26));
                myString+=ch;
            }
            jibberish[n] = myString;
        }
        return jibberish;
    }
}