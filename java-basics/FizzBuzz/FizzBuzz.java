public class FizzBuzz{
    public String fizzBuzz(int number){
        if(number % 15 == 0){
            String fizzbuzz ="FizzBuzz";
            return(fizzbuzz);
        }else if(number % 5 == 0){
            String buzz = "Buzz";
            return(buzz);
        }else if(number % 3 == 0){
            String fizz = "Fizz";
            return(fizz);
        }
        else{
            String numString = Integer.toString(number);
            return(numString);
        }
    }
}