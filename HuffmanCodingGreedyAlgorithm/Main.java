public class Main {
    public static void main(String[] args) {
        String input = "abbccda";
        Algorithm algo = new Algorithm(input);

        String encoded = algo.encode(input);
        String decoded = algo.decode(encoded);

        System.out.println("Original: " + input);
        System.out.println("Encoded : " + encoded);
        System.out.println("Decoded : " + decoded);
    }
    
}
