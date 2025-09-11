package Day3.q19;

import java.util.*;

//class SD{
//    public List<String> serialize(TreeNode node ){
//        List<String> list = new ArrayList<>();
//        helper(node, list);
//        return list;
//    }
//
//    private void helper(TreeNode node, List<String> list) {
//        if (node == null) {
//            list.add("null");
//            return;
//        }
//        list.add(String.valueOf(node.val));
//        helper(node.left, list);
//        helper(node.right, list);
//    }
//
//    TreeNode deserialize(List<String> list){
//        Collections.reverse(list);
//        TreeNode node = helper2(list);
//        return node;
//    }
//
//    private TreeNode helper2(List<String> list) {
//        String val = list.remove(list.size() - 1);
//
//        if (val.charAt(0) == 'n'){
//            return null;
//        }
//
//        TreeNode node = new TreeNode(Integer.parseInt(val));
//
//        node.left = helper2(list);
//        node.right = helper2(list);
//
//        return node;
//    }
//}

public class Codec {
    private int index;

    public String serialize(TreeNode root) {
        // Use char[] or StringBuilder with preallocated size if needed
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        sb.setLength(sb.length() - 1); // remove trailing comma
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("n,"); // shorter token
            return;
        }
        sb.append(node.val).append(",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        int[] idx = new int[]{0};
        return parse(data.toCharArray(), idx);
    }

    private TreeNode parse(char[] arr, int[] idx) {
        if (arr[idx[0]] == 'n') {
            idx[0] += 2; // skip 'n' and ','
            return null;
        }

        int val = 0;
        boolean neg = false;
        if (arr[idx[0]] == '-') {
            neg = true;
            idx[0]++;
        }

        while (idx[0] < arr.length && arr[idx[0]] != ',') {
            val = val * 10 + (arr[idx[0]++] - '0');
        }
        idx[0]++; // skip comma

        TreeNode node = new TreeNode(neg ? -val : val);
        node.left = parse(arr, idx);
        node.right = parse(arr, idx);
        return node;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println("Serialized: " + data);

        TreeNode restored = codec.deserialize(data);
        System.out.println("Restored root: " + restored.val);
    }
}
