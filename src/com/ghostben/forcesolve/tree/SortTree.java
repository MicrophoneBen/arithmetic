package com.ghostben.forcesolve.tree;

import java.util.Stack;

/**
 * @program: arithmetic
 * @description: 二叉排序树的实现，代码
 * @author: ghostben
 * @create: 2018-11-01 01:33
 **/
public class SortTree {
    private TreeNode root;

    public SortTree(){
        root = null;
    }

    /**
    *@author    : Microphoneben
    *@date      : 2018/11/4
    *@description : SortTree  插入一个节点
    */
    public void insert(int dd, String value){
        TreeNode newNode = new TreeNode();
        newNode.setINode(dd);
        newNode.setIData(value);
        if(root == null){
            // 树是空的
            root = newNode;
        }else{
            TreeNode parent;
            TreeNode current = root ;
            while(true){
                parent = current;
                if(dd <  current.getINode()){
                    current = current.getLeftNode();
                    if(current == null){
                        parent.setLeftNode(newNode);
                        return;
                    }
                }else{
                    current = current.getRightNode();
                    if(current == null){
                        parent.setRightNode(newNode);
                        return;
                    }
                }
            }
        }
    }

    public TreeNode delete(int key){
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftNode = true;
        //循环寻找要删除的节点
        while(current.getINode() != key){
            //记录父节点
            parent = current;
            if(key < current.getINode()){
                isLeftNode = true;
                current = current.getLeftNode();
            }else {
                isLeftNode = false;
                current = current.getRightNode();
            }
            if (current == null){
                //没有找到要删除的节点
                System.out.println("空树！");
                return null;
            }
        }
        //跳出循环，找到要删除的节点，节点current就是要删除的节点。

        //第一种删除情况，没有左子树也没有右子树，删除节点为叶子
        if(current.getLeftNode() == null && current.getRightNode() == null){
            //删除的是根节点，并且没有子树
            if(current == root) {
                root = null;
            }else if(isLeftNode){
                //删除的是父节点的左子树
                parent.setLeftNode(null);
            }else {
                //删除的是父节点的右子树
                return parent.getRightNode();
            }
        }

        //第二种删除情况，删除的节点只有左子节点
        if(current.getRightNode() == null){
            if (current == root){
                root = current.getLeftNode();
            }else if(isLeftNode) {
                parent.setLeftNode(current.getLeftNode());
            }else{
                parent.setRightNode(current.getLeftNode());
            }
            //第三种删除情况，删除的节点只有右子节点
        }else if(current.getLeftNode() == null){
            if(current == root ) {
                root = current.getRightNode();
            }else if(isLeftNode){
                parent.setLeftNode(current.getRightNode());
            }else{
                parent.setRightNode(current.getRightNode());
            }
            //第四种删除情况，删除的节点有左右两个节点
        }else {
            TreeNode successor = getSuccessor(current);
            if (root == current){
                root = successor;
            }else if(isLeftNode){
                parent.setLeftNode(successor);
            }else{
                parent.setRightNode(successor);
            }
        }
        return current;
    }
    /**
    *@author    : Microphoneben
    *@date      : 2018/11/3
    *@description : 向要删除节点的右子节点向下寻找要用来替代的节点
    */
    private TreeNode getSuccessor(TreeNode delNode){
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.getRightNode();
        while(null != current){
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }
        //这个时候current指向空节点，successor指向要移动的节点，successorParent指向要移动节点的父节点
        if(successor != delNode.getRightNode()){
            //这个时候要移动的节点不是要删除节点的右子节点，要进行处理,把移动节点的右子节点作为父节点的右子节点
            successorParent.setLeftNode(successor.getRightNode());
            //移动上去之后，进行节点处理
            successor.setLeftNode(delNode.getLeftNode());
            successor.setRightNode(delNode.getRightNode());
        }
        return  successor;
    }

    public TreeNode find (int key){
        TreeNode current;
        current = root;
        //当节点的值不等于要寻找的节点值
        while(key != current.getINode()){
            if(key > current.getINode()) {
                current = current.getRightNode();
            }else{
                current = current.getLeftNode();
            }
            if(current == null) {
                return null;
            }
        }
        return current;
    }

    /**
    *@author    : Microphoneben
    *@date      : 2018/11/3
    *@description : 树的遍历，三种遍历方式
    */
    public void list(int listType){
        switch(listType){
            case 1:
                System.out.println("PreOrder List， 从上到下，从左到右的遍历方式");
                preOrder(root);
                break;
            case 2:
                System.out.println("InOrder List, 从下到上，从左到右的遍历方式，即是从小到大的遍历");
                inOrder(root);
                break;
            case 3:
                System.out.println("PostOrder List, 从下到上，从右到左的遍历方式");
                postOrder(root);
                break;
            default:
                System.out.println("一个期待开发者实现的方法");
        }
        System.out.println();
    }

    private void preOrder(TreeNode localRoot){
        //从上到下，从左到右的遍历方式
        if(localRoot != null){
            System.out.print(localRoot.getINode() + "   ");
            preOrder(localRoot.getLeftNode());
            preOrder(localRoot.getRightNode());
        }
    }

    private void inOrder(TreeNode localRoot){
        //从下到上，从左到右的遍历方式，从小到大
        if(localRoot != null){
            inOrder(localRoot.getLeftNode());
            System.out.print(localRoot.getINode() + "   ");
            inOrder(localRoot.getRightNode());
        }
    }

    private void postOrder(TreeNode localRoot){
        //从下到上，从右到左的遍历方式
        if(localRoot != null){
            postOrder(localRoot.getLeftNode());
            postOrder(localRoot.getRightNode());
            System.out.print(localRoot.getINode() + "   ");
        }
    }

    public void display(){
        Stack<TreeNode> localTreeStack = new Stack<>();
        localTreeStack.push(root);
        int nBlank = 32;
        boolean isRowEmpty = false;
        System.out.println("………………………………………………………………………………………………………………………………………………………………………………………………");
        while (!isRowEmpty){
            Stack<TreeNode> localStack = new Stack<>();
            isRowEmpty = true;
            for(int i = 0; i < nBlank; i++){
                System.out.print(" ");
            }
            while (!localTreeStack.isEmpty()) {
                //不为空进入循环
                TreeNode temp = localTreeStack.pop();
                if(temp != null){
                    System.out.print(temp.getINode());
                    localStack.push(temp.getLeftNode());
                    localStack.push(temp.getRightNode());
                    if(temp.getLeftNode() != null || temp.getRightNode() != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlank*2 - 2; j++){
                    System.out.print(" ");
                }
            }//while end
            System.out.println();
            nBlank /= 2;
            while (!localStack.isEmpty()){
                localTreeStack.push(localStack.pop());
            }
        }
        System.out.println("………………………………………………………………………………………………………………………………………………………………………………………………");
    }
}
















