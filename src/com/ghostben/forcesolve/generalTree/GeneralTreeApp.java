package com.ghostben.forcesolve.generalTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: arithmetic
 * @description: 二叉排序树的实现测试类
 * @author: ghostben
 * @create: 2018-11-19 02:09
 **/
public class GeneralTreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        GeneralTree theTree = new GeneralTree();
        theTree.insert(50,50.2);
        theTree.insert(25,34.32);
        theTree.insert(75,234.35);
        theTree.insert(12,56.575);
        theTree.insert(37,464.464);
        theTree.insert(43,23.35456);
        theTree.insert(30,3435.34);
        theTree.insert(33,45.08);
        theTree.insert(87,2.134);
        theTree.insert(93,134.676);
        theTree.insert(63,134.676);
        theTree.insert(97,67.0676);

        while (true){
            System.out.println("请输入 list find delete insert show");
            int choice = getChar();
            switch (choice){
                case 's' :
                    theTree.display();
                    break;
                case 'i' :
                    System.out.println("请输入一个要插入的值：");
                    value = getInt();
                    theTree.insert(value, value + 0.7684);
                    break;
                case 'd' :
                    System.out.println("请输入你要删除的节点：");
                    value = getInt();
                    if(theTree.delete(value)){
                        System.out.println("删除成功 ： ");
                        System.out.println("删除了" + value);
                    }else{
                        System.out.println("删除失败 ： ");
                        System.out.println("不存在节点 " + value + "\n");
                    }
                    break;
                case 'f' :
                    System.out.println("请输入你要查找的节点");
                    value = getInt();
                    TreeNode treeNode = theTree.find(value);
                    if(treeNode != null){
                        System.out.println("节点已经找到：");
                        System.out.println(treeNode.toString());
                        System.out.println();
                    }else {
                        System.out.println("没有找到节点" + value + "\n");
                    }
                    break;
                case 'l' :
                    System.out.println("请输入你要遍历的类型：  供选择的遍历有1,2,3");
                    value = getInt();
                    theTree.list(value);
                    break;
                default:
                    System.out.println("期待开发者的完善功能");
            }
        }
    }


    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }

    private static char getChar() throws  IOException{
        return getString().charAt(0);
    }

    public static int getInt() throws IOException{
        return Integer.parseInt(getString());
    }
}