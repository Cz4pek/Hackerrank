package app;

import java.util.Scanner;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    public static int getHeight(Node root) {
        if (root.left == null && root.right == null)
            return 0;
        else if (root.left != null && root.right != null)
            return Math.max(1 + getHeight(root.left), (1 + getHeight(root.right)));
        else if (root.left == null)
            return 1 + getHeight(root.right);
        else
            return 1 + getHeight(root.left);
        
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height=0;
        try {
            height = getHeight(root);
        } catch (NullPointerException e) {
            System.out.println("Tree is empty" + e.getMessage());
        }
       

        System.out.println(height);
        sc.close();
    }
}