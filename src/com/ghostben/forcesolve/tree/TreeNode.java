package com.ghostben.forcesolve.tree;

import lombok.Data;

/**
 * @program: arithmetic
 * @description: 算法排序树实现，Java实现排序树
 * @author: ghostben
 * @create: 2018-11-01 01:20
 **/
@Data
public class TreeNode {
    private Integer iNode;
    private String iData;
    private TreeNode leftNode;
    private TreeNode rightNode;
}