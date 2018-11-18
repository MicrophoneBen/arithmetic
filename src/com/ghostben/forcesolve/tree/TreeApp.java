package com.ghostben.forcesolve.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: arithmetic
 * @description: 使用写好的树的算法测试类
 * @author: ghostben
 * @create: 2018-11-03 23:46
 **/
public class TreeApp {
    public static void main(String[] args) throws IOException{
        int value;
        SortTree theTree = new SortTree();
        theTree.insert(50,"dfsdf");
        theTree.insert(30,"h2");
        theTree.insert(75,"db2");
        theTree.insert(54,"mysql");
        theTree.insert(59,"oracle");
        theTree.insert(23,"ibm");
        theTree.insert(16,"css");
        theTree.insert(9,"vdf");
        theTree.insert(60,"2.134");
        theTree.insert(35,"134");
        theTree.insert(37,"cdf");
        theTree.insert(97,"abc");

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
                    theTree.insert(value, value + "BenInsert");
                    break;
                case 'd' :
                    System.out.println("请输入你要删除的节点：");
                    value = getInt();
                    TreeNode delNode = theTree.delete(value);
                    if(delNode != null){
                        System.out.println("删除成功 ： ");
                        System.out.println(delNode.toString());
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