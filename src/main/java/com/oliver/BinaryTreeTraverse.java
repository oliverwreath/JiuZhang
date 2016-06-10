package com.oliver;

import com.oliver.BinaryTree.TreeNode;

import java.util.ArrayList;


/**
 * Created by Yanliang Han on 2016/6/10.
 */
public class BinaryTreeTraverse {
    public static void main(String[] args) {
        testPreorderTraversal();
        testInorderTraversal();
        testPostorderTraversal();
    }

    public static void testPreorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("root=" + root);
        ArrayList<Integer> result = preorderTraversal(root);
        System.out.println("result=" + result);
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        preorderTraverse(root, result);
        return result;
    }

    public static void preorderTraverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraverse(root.left, result);
        preorderTraverse(root.right, result);
        return;
    }

    public static void testInorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("root=" + root);
        ArrayList<Integer> result = inorderTraversal(root);
        System.out.println("result=" + result);
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        inorderTraverse(root, result);
        return result;
    }

    public static void inorderTraverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left, result);
        result.add(root.val);
        inorderTraverse(root.right, result);
        return;
    }

    public static void testPostorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("root=" + root);
        ArrayList<Integer> result = postorderTraversal(root);
        System.out.println("result=" + result);
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        postorderTraverse(root, result);
        return result;
    }

    public static void postorderTraverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraverse(root.left, result);
        postorderTraverse(root.right, result);
        result.add(root.val);
        return;
    }
}
