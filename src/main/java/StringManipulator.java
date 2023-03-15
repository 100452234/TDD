public class StringManipulator {
    // Method 7: create a method that reverse the order of characters in a string and returns the result
    public static String method7(String a){
        StringBuilder sb = new StringBuilder(a);
        return sb.reverse().toString();
    }

    // Method 8: method that counts the number of vowels in a string and returns the count
    public static int method8(String a){
        // Rewrite the string in lower case
        a = a.toLowerCase();

        // Compute result and return it
        int count = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) == 'a' || a.charAt(i) == 'e' || a.charAt(i) == 'i' || a.charAt(i) == 'o' || a.charAt(i) == 'u'){
                count ++;
            }
        }
        return count;
    }

    // Method 9: method that counts the number of words in a string and returns the count
    public static int method9(String a){
        if (a.isEmpty()) { return 0; }

        String[] words = a.split("\\s+");   // separates string on white spaces
        return words.length;
    }

    // Method 10: method that removes all whites spaces from string and returns the result
    public static String method10(String a){
        return a.replaceAll("\\s+", "");
    }

    // Method 11: method that checks if a string reads the same forwards and backwards and returns the result
    public static boolean method11(String a){
        a = a.toLowerCase();    // Rewrite in lower case
        a = method10(a);        // Remove blank spaces
        String b = method7(a);  // Store the string reversed

        return a.equals(b);
    }

}
