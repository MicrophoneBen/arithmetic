package com.ghostben.forcesolve.generalTree;

import lombok.Data;

/**
 * @program: arithmetic
 * @description: 树的根节点，数据&指针
 * @author: ghostben
 * @create: 2018-11-18 22:28
 **/
@Data
public class TreeNode {
    private int anInt;
    private double aDouble;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public void diplay(){
        System.out.print("节点Integer数据" + anInt);
        System.out.println("节点Double数据" + aDouble);
    }
}