package app;

import java.util.*;
import java.io.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
   
    static void levelOrder(Node root) {
        Queue<Node> allRoots = new ArrayDeque<>();
        if (root != null) allRoots.offer(root);

        while (!allRoots.isEmpty()) {
            Node currentRoot = allRoots.poll();
            System.out.print(currentRoot.data + " ");
            if(currentRoot.left != null) allRoots.offer(currentRoot.left);
            if(currentRoot.right != null) allRoots.offer(currentRoot.right);
        }

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
        levelOrder(root);
        sc.close();
    }
}