package q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//  * Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }


public class Main {

	public static void main(String[] args) {
    // Constructing the tree
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(3, null, node6);
    TreeNode root = new TreeNode(1, node2, node3);

    // Calling levelOrder
    Main mainObj = new Main();
    List<List<Integer>> levels = mainObj.levelOrder(root);

    // Printing the result
    for (List<Integer> level : levels) {
        System.out.println(level);
    }
}
	
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		 while(!queue.isEmpty()){
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();

			for (int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				currentLevel.add(currentNode.val);

				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}

				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(currentLevel);
		 }
		return result;
	}
}
