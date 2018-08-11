package com.cyt.study.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/19
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    TreeNode(){

    }
    public static void printPreOrder(TreeNode root){
        if(root!=null) {
            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }
    /**
     * 中序打印
     */
    public  void printInOrder(TreeNode root){

        if(root!=null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
    /**
     * 先序遍历
     * @param root
     */

    /**
     * 后序遍历
     * @param root
     */
    public static void printPostOrder(TreeNode root){

        if(root!=null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.val + " ");
        }


    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public static ArrayList<Integer> printLevel(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        LinkedList<TreeNode> tmp=new LinkedList<TreeNode>();
        if(root == null){
            return res;
        }
        tmp.add(root);
        while (!tmp.isEmpty()){
            TreeNode out=tmp.poll();//检索并移除此列表的头元素(第一个元素)
            res.add(out.val);
            if(out.left!=null){
                tmp.add(out.left);
            }
            if(out.right!=null){
                tmp.add(out.right);
            }
        }
        return res;
    }




    /**
     * 树的子结构
     * 输入两棵二叉树root1，root2，判断root2是不是root1的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null){
            return false;
        }else{
            return isSubTree(root1,root2)||HasSubtree(root1.left,root2)|| HasSubtree(root1.right,root2);
        }
    }
    private boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val == root2.val){
            return (isSubTree(root1.left,root2.left))&&(isSubTree(root1.right,root2.right));
        }else{
            return false;
        }
    }

    /**
     * 递归的函数选择错误，应该在判断正确结点的函数里选择递归
     * 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length==0) return false;
        if(sequence.length<3) return true;
        int mid=isNodeOfBST(sequence);
        if(mid!=-1){
            int[] left=new int[mid];
            int[] right=new int[sequence.length-mid-1];
            for(int i=0;i<mid;i++){
                left[i]=sequence[i];
            }
            for(int i=0;i<sequence.length-mid-1;i++){
                right[i]=sequence[mid+i];
            }
            boolean leftFlag=true,rightFlag=true;
            if(left.length>0 ){
                leftFlag=VerifySquenceOfBST(left);
            }
            if(right.length>0 ){
                rightFlag=VerifySquenceOfBST(right);
            }
            return  leftFlag && rightFlag;
        }else {
            return false;
        }

    }
    private static int isNodeOfBST(int [] sequence) {
        for(int i=0;i<sequence.length;i++){
            System.out.print(sequence[i]+",");
        }

        if(sequence.length<2) return 0;
        int pointer=0;
        for(;pointer<sequence.length-1;){
            if(sequence[pointer]>sequence[sequence.length-1]) break;
            else pointer++;
        }

        System.out.println("pointer: "+pointer);

        for(int j=pointer;j<sequence.length-1;j++){
            if(sequence[j]<sequence[sequence.length-1]) return -1;
        }
        return pointer;
    }
    /**
     * 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST1(int[] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return isNodeOfBST1(sequence, 0, sequence.length - 1);
    }
    private static boolean isNodeOfBST1(int [] sequence,int start,int end) {
        //遍历完数组的一部分，没报错，返回true
        if(start>end) return true;
        int i=start;//从start开始遍历,找到第一个大于end 的下标
        while (i<end && sequence[i]<sequence[end]){
            i++;
        }
        for (int j=i;j<end;j++){
            if(sequence[j]<sequence[end]){
                return false;
            }
        }
        return isNodeOfBST1(sequence,start,i-1) && isNodeOfBST1(sequence,i,end-1);
    }

    /**
     * 代码太多
     * 二叉树中和为某一值的路径
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        List<TreeNode> list=new ArrayList<TreeNode>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        list.add(root);
        mustPrint(res,list,root.val,target);
        return res;
    }
    private static void mustPrint(ArrayList<ArrayList<Integer>> res,List<TreeNode> list,int current,int target){
        int len=list.size();
        if(list.get(len-1).right==null && list.get(len-1).left==null){
            if(current==target){
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                for(int i=0;i<list.size();i++){
                    tmp.add(list.get(i).val);
                }
                res.add(tmp);
            }
        }else{

            if(list.get(len-1).left!=null){
                list.add(list.get(len-1).left);
                mustPrint(res,list,current+list.get(len-1).left.val,target);
            }
            if(list.get(len-1).right!=null){
                list.add(list.get(len - 1).right);
                mustPrint(res,list,current+list.get(len-1).right.val,target);
            }

        }

        list.remove(len-1);
    }
    private ArrayList<ArrayList<Integer>> findPathListAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> findPathList = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        if(root == null) return findPathListAll;
        findPathList.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            findPathListAll.add(new ArrayList<Integer>(findPathList));
        FindPath(root.left, target);
        FindPath(root.right, target);
        findPathList.remove(findPathList.size()-1);
        return findPathListAll;
    }

    /**
     * 二叉搜索树与双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     *
     * 递归版
     解题思路：
     1.将左子树构造成双链表，并返回链表头节点。
     2.定位至左子树双链表最后一个节点。
     3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     4.将右子树构造成双链表，并返回链表头节点。
     5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     6.根据左子树链表是否为空确定返回的节点。

     * @param pRootOfTree
     * @return
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        if(pRootOfTree.left==null&&pRootOfTree.right==null)
            return pRootOfTree;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left!=null?left:pRootOfTree;

    }
/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */


    /**
     * 平衡二叉树
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    /**
     * 二叉树的下一个结点
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    /**
     * 对称的二叉树
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    /**
     * 按之字形顺序打印二叉树
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    /**
     * 把二叉树打印成多行
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    /**
     * 序列化二叉树
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     */

    /**
     * 二叉搜索树的第k个结点
     * 给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
     */

    public static void main(String[]args) {
        LinkedList<TreeNode> tmp=new LinkedList<TreeNode>();
        TreeNode treeNode=new TreeNode(9);

    }

}
