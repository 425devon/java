public class StringManipulator{
    public String trimAndConcat(String a, String b){
        String str = a.trim();
        str = str.concat(b.trim());
        return str;
    }
    public Integer getIndexOrNull(String s, String c){
        String words = s;
        String letter = c;
        if(words.indexOf(letter)> -1){
            Integer position = words.indexOf(letter);
            return position;
        }else{
            return null;
        }
    }
    public String concatSubstring(String str1, int a, int b, String str2){
        String subString = str1;
        String sub = subString.substring(a, b);
        sub = sub.concat(str2.trim());
        return sub;
    }
}