// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
public static int minTime(Node root, int target) {
    // Your code goes here
    Map<Node, Node> map = new HashMap<>();
    Node[] targetNode = new Node[1];
    fill(root, target, map, targetNode);
    if(targetNode[0] == null) {
        return 0;
    }

    return findMinTime(targetNode[0], map);
}

private static void fill(Node root, int target, Map<Node, Node> map, Node[] targetNode) {
    if(root == null) {
        return;
    }
    if(root.data == target) {
        targetNode[0] = root;
    }
    if (root.left != null) {
        map.put(root.left, root);
        fill(root.left, target, map, targetNode);
    }
    if (root.right != null) {
        map.put(root.right, root);
        fill(root.right, target, map, targetNode);
    }
}

private static int findMinTime(Node targetNode, Map<Node, Node> map) {
    Map<Node, Boolean> visited = new HashMap<>();
    Queue<Node> q = new LinkedList<>();
    q.add(targetNode);
    visited.put(targetNode, true);

    int result = 0;
    while(!q.isEmpty()) {
        int size = q.size();
        boolean anyBurnt = false;
        for (int i = 0; i < size; i++) {
            Node n = q.remove();
            if(n.left != null && !visited.containsKey(n.left)) {
                q.add(n.left);
                visited.put(n.left, true);
                anyBurnt = true;
            }
            if(n.right != null && !visited.containsKey(n.right)) {
                q.add(n.right);
                visited.put(n.right, true);
                anyBurnt = true;
            }
            if(map.containsKey(n) && !visited.containsKey(map.get(n))) {
                q.add(map.get(n));
                visited.put(map.get(n), true);
                anyBurnt = true;
            }
        }
        if(anyBurnt) {
            result++;
        }
    }
    return result;
}

}