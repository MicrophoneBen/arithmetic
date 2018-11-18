package com.ghostben.forcesolve.generalTree;

import java.util.Stack;

/**
 * @program: arithmetic
 * @description: 普通树的建立，一棵普通树
 * @author: ghostben
 * @create: 2018-11-18 23:33
 **/
public class GeneralTree {
    private TreeNode root;

    public GeneralTree(){
        root = null;
    }

    public void display(){
        Stack<TreeNode> localTreeStack = new Stack<>();
        localTreeStack.push(root);
        int nBlank = 32;
        boolean isRowEmpty = false;
        System.out.println("………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………");
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
                    System.out.print(temp.getAnInt());
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
        System.out.println("………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………");
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
            System.out.print(localRoot.getAnInt() + "   ");
            preOrder(localRoot.getLeftNode());
            preOrder(localRoot.getRightNode());
        }
    }

    private void inOrder(TreeNode localRoot){
        //从下到上，从左到右的遍历方式，从小到大
        if(localRoot != null){
            inOrder(localRoot.getLeftNode());
            System.out.print(localRoot.getAnInt() + "   ");
            inOrder(localRoot.getRightNode());
        }
    }

    private void postOrder(TreeNode localRoot){
        //从下到上，从右到左的遍历方式
        if(localRoot != null){
            postOrder(localRoot.getLeftNode());
            postOrder(localRoot.getRightNode());
            System.out.print(localRoot.getAnInt() + "   ");
        }
    }

    public TreeNode find(int key){
        TreeNode current = root;
        while (key != current.getAnInt()){
            if(key < current.getAnInt()){
                current = current.getLeftNode(); //往左边找
            }else {
                current = current.getRightNode();  //往右边找
            }
        }//退出循环就是找到了
        return current;
    }

    //删除一个节点
    public boolean delete(int id){
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftNode = true;

        //循环过程有三种情况，当前节点为空，当前节点比id小，当前节点比id大，注意，每次要记录下父节点
        while(current.getAnInt() != id){
            //每次循环开始，记下当前的节点
            parent = current;
            if(id < current.getAnInt()){
                //往左的标志为真
                isLeftNode = true;
                current = current.getLeftNode();
            }else {
                //往左找的标志为假
                isLeftNode = false;
                current = current.getRightNode();
            }
            // 找不到id的节点值，直接返回，删除失败
            if(current == null){
                //没有找到节点，删除失败
                return false;
            }
        }//跳出循环代表是找到了要删除的节点,此时current.getAnInt()==id

        /**
         *@author    : Microphoneben
         *@description : 找到要删除的节点了，这个节点有四种情况
         *  这个节点是一个叶子节点，没有左右子节点；
         *  这个节点只有左子节点；
         *  这个节点只有右子节点；
         *  这个节点有左右子节点；
         */
        //叶子节点
        if(current.getLeftNode() == null && current.getRightNode() == null){
            if(current == root){
                root = null;
            }else if(isLeftNode){
                parent.setLeftNode(null);
            }else {
                parent.setRightNode(null);
            }
        }else if(current.getLeftNode() == null){  //左子节点为空
            if(current == root){
                root = current.getRightNode();
            }else if(isLeftNode){   //删除的是左子节点
                parent.setLeftNode(current.getRightNode());
            }else {  //删除的是右子节点
                parent.setRightNode(current.getRightNode());
            }
        }else if(current.getRightNode() == null){  //右子节点为空
            if(current == root){
                root = current.getLeftNode();
            }else if(isLeftNode){  //删除的是左子节点
                parent.setLeftNode(current.getLeftNode());
            }else { //删除的是右子节点
                parent.setRightNode(current.getLeftNode());
            }
        }else{   //左右子节点都不为空
            //首先有了要删除的节点了，要找到继承者节点
            TreeNode successor = getSuccessor(current);
            //接下来就是三个判断
            if(current == root){
                root = successor;
            }else if(isLeftNode){
                parent.setLeftNode(successor);
            }else {
                parent.setRightNode(successor);
            }
            successor.setLeftNode(current.getLeftNode());
        }
        return true; //删除成功
    }

    //向右子节点向下找继承节点
    private TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.getRightNode();
        //循环寻找继承的节点
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }//循环结束，就是找到了继承的节点
        /**
        *@author    : Microphoneben
        *@description : GeneralTree 找到了要继承的节点，进行判断
        */
        if(successor != delNode.getRightNode()){ //继承节点不是删除节点的右子节点，所以是一路向下找到的左子叶子节点
            //把拿去继承的节点的右子节点放到继承节点的父节点的左子节点
            successorParent.setLeftNode(successor.getRightNode());
            //把继承节点的右子节点改掉,改成它去继承的位置的右子树
            successor.setRightNode(delNode.getRightNode());
        }
        //找到了，处理好了，返回
        return successor;
    }

    public void insert(int anInt, Double aDoble){
        TreeNode newNode = new TreeNode();
        newNode.setAnInt(anInt);
        newNode.setADouble(aDoble);

        if(root == null){
            root = newNode;
        }else {
            TreeNode current = root;
            TreeNode parent;
            while (true){
                parent = current;
                if(anInt < current.getAnInt()){
                    current = current.getLeftNode();
                    if(current == null){
                        parent.setLeftNode(newNode);
                        return; //插入节点后退出
                    }
                }else {
                    current = current.getRightNode();
                    if(current == null){
                        parent.setRightNode(newNode);
                        return;  // 插入一个节点后退出
                    }
                }
            }
        }
    }
}