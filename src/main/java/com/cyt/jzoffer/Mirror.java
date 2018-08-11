package com.cyt.jzoffer;

import com.cyt.study.ds.TreeNode;

/**
 * @Description: 二叉树的镜像
 * @Function List: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author: ytchen
 * @Date: 2016/7/26
 */
public class Mirror {

    public void Mirror(TreeNode root) {
        if(root !=null){
            TreeNode left=root.left;
            root.left=new TreeNode(0);
            root.left=root.right;
            root.right=new TreeNode(0);
            root.right=left;
            Mirror(root.left);
            Mirror(root.right);
        }

    }
}
