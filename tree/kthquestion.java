package tree;

import java.util.*;

public class kthquestion {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    // 1. Print K-th level
    static void printKthLevel(Node root, int k) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                if (level == k) {
                    System.out.print(current.data + " ");
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (level == k) {
                return;
            }

            level++;
        }
    }


    // 2. Sum at K-th level
    static int sumAtKthLevel(Node root, int k) {

        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                if (level == k) {
                    sum += current.data;
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (level == k) {
                return sum;
            }

            level++;
        }

        return 0;
    }


    // 3. Count at K-th level
    static int countAtKthLevel(Node root, int k) {

        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int count = 0;

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                if (level == k) {
                    count++;
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (level == k) {
                return count;
            }

            level++;
        }

        return 0;
    }


    // 4. Maximum at K-th level
    static int maxAtKthLevel(Node root, int k) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                if (level == k) {
                    max = Math.max(max, current.data);
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (level == k) {
                return max;
            }

            level++;
        }

        return Integer.MIN_VALUE;
    }


    // 5. Minimum at K-th level
    static int minAtKthLevel(Node root, int k) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                if (level == k) {
                    min = Math.min(min, current.data);
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (level == k) {
                return min;
            }

            level++;
        }

        return Integer.MAX_VALUE;
    }


    // 6. Average at K-th level
    static double averageAtKthLevel(Node root, int k) {

        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            int sum = 0;
            int count = 0;

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                if (level == k) {
                    sum += current.data;
                    count++;
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (level == k) {
                return (double) sum / count;
            }

            level++;
        }

        return 0;
    }


    // 7. Level Order
    static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                System.out.print(current.data + " ");

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            System.out.println();
        }
    }


    // 8. Sum of every level
    static void sumEveryLevel(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {

                Node current = q.remove();

                sum += current.data;

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            System.out.println(sum);
        }
    }


    public static void main(String[] args) {

        /*
                      1
                    /   \
                   2     3
                  / \   / \
                 4   5 6   7
                / \
               8   9
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);


        int k = 2;

        System.out.println("K-th Level:");
        printKthLevel(root, k);

        System.out.println("\n\nSum:");
        System.out.println(sumAtKthLevel(root, k));

        System.out.println("\nCount:");
        System.out.println(countAtKthLevel(root, k));

        System.out.println("\nMaximum:");
        System.out.println(maxAtKthLevel(root, k));

        System.out.println("\nMinimum:");
        System.out.println(minAtKthLevel(root, k));

        System.out.println("\nAverage:");
        System.out.println(averageAtKthLevel(root, k));

        System.out.println("\nLevel Order:");
        levelOrder(root);

        System.out.println("Sum of Every Level:");
        sumEveryLevel(root);
    }
}