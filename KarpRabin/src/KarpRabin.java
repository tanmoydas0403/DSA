public class KarpRabin {
    private final int PRIME = 101;

    private long calculateHash(String str, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private long updateHash(String text, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - text.charAt(oldIndex);
        newHash /= PRIME;
        newHash += text.charAt(newIndex) * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();

        if (patternLength > textLength) return;

        long patternHash = calculateHash(pattern, patternLength);
        long textHash = calculateHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && text.substring(i, i + patternLength).equals(pattern)) {
                int start = i;
                int end = i + patternLength - 1;
                System.out.println("Pattern found from index " + start + " to " + end);
            }

            if (i < textLength - patternLength) {
                textHash = updateHash(text, i, i + patternLength, textHash, patternLength);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        KarpRabin kr = new KarpRabin();

        String text = "Misra Tanmoy subha";
        String pattern = "Tanmoy";

        kr.search(text, pattern);
    }
}