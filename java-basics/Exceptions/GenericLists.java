import java.util.ArrayList;

public class GenericLists{
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        int temp;

        for(int i=0; i<myList.size();i++){
            Object a = myList.get(i);
            try{
            Integer castedValue = (Integer) a;
            System.out.println(castedValue);
            }catch(Exception e){
            System.out.println("Error "+ i + e.getMessage());
            }
        }
    }
}