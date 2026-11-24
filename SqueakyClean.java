public class SqueakyClean {

    public static String clean(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if(Character.isLetter(ch))
                result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(SqueakyClean.clean("a$#.b"));
    }
}
