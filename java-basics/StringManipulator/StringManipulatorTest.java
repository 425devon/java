public class StringManipulatorTest{
    public static void main(String[] args) {
        StringManipulator iD = new StringManipulator();
        String trimcat = iD.trimAndConcat("  big  ", "   words   ");
        System.out.println(trimcat);

        char ch = 'o';
        String letter = Character.toString(ch);
        Integer a = iD.getIndexOrNull("Hello World", letter);
        Integer b = iD.getIndexOrNull("Hi", letter);
        String word = "Hello";
        String subString = "llo";
        String notSub = "world";
        Integer c = iD.getIndexOrNull(word, subString);
        Integer d = iD.getIndexOrNull(word, notSub);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        String newWord = iD.concatSubstring("Hello", 1, 2, "World");
        System.out.println(newWord);
    }
}