
import java.util.Base64;

class Base64Example {
    public static String encodeBase64(String input) {
        byte[] encodedBytes = Base64.getEncoder().encode(input.getBytes());
        return new String(encodedBytes);
    }

    public static void main(String[] args) {
        String originalString = "HelloWorld";
        String encodedString = encodeBase64(originalString);
        System.out.println("Original: " + originalString);
        System.out.println("Base64 Encoded: " + encodedString);
    }
}


