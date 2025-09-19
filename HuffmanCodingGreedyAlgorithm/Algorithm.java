import java.util.*;

public class Algorithm {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public Algorithm(String feeder) {
        HashMap<Character, Integer> fmap = new HashMap<>();

        // Step 1: Frequency map
        for (int i = 0; i < feeder.length(); i++) {
            char cc = feeder.charAt(i);
            fmap.put(cc, fmap.getOrDefault(cc, 0) + 1);
        }

        // Step 2: PriorityQueue as min-heap
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        // Step 3: Build Huffman Tree
        while (minHeap.size() > 1) {
            Node first = minHeap.poll();
            Node second = minHeap.poll();

            Node merged = new Node(null, first.cost + second.cost);
            merged.left = first;
            merged.right = second;

            minHeap.add(merged);
        }

        Node root = minHeap.poll();

        // Step 4: Build encoder and decoder maps
        encoder = new HashMap<>();
        decoder = new HashMap<>();
        buildCode(root, "");
    }

    private void buildCode(Node node, String path) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            encoder.put(node.data, path);
            decoder.put(path, node.data);
            return;
        }

        buildCode(node.left, path + "0");
        buildCode(node.right, path + "1");
    }

    public String encode(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sb.append(encoder.get(ch));
        }
        return sb.toString();
    }

    public String decode(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (char ch : str.toCharArray()) {
            temp.append(ch);
            if (decoder.containsKey(temp.toString())) {
                sb.append(decoder.get(temp.toString()));
                temp.setLength(0);
            }
        }

        return sb.toString();
    }
}