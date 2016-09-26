package cyt.jzoffer;

import cyt.study.ds.TreeNode;

/**
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/19
 */
public class reConstructBinaryTree {
    public static void main(String[] args){
        int[] pre=new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root=reConstructBinaryTree(pre,in);
//        print(root);
      /*  TreeNode root=null;
        root=insert(root,1,in);
        root=insert(root,2,in);
        root=insert(root,4,in);
        root=insert(root,7,in);
        root=insert(root,3,in);
        root=insert(root,5,in);
        root=insert(root,6,in);
        root=insert(root,8,in);*/
//[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
      //  System.out.println();

        System.out.println("==");

        print(root);
        System.out.println("==");
       // root.print();

    }

    public static void print(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");

            if(root.left!=null){
                print(root.left);
            }
            if(root.right!=null){
                print(root.right);
            }
        }

    }
    public  static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=null;
        for(int i=0;i<pre.length;i++){
            root=insert(root,pre[i],in);
        }

        return root;
    }
    private  static TreeNode insert(TreeNode root,int insert,int [] in){
        if(root==null){
            return new TreeNode(insert);

        }else{
            int tag=find(in,root.val,insert);
            if(tag==-1){
                root.left=insert(root.left,insert,in);
            }else{
                root.right=insert(root.right,insert,in);
            }
        }
      return root;
    }
    private  static int find(int[] input,int root,int insert){
        for(int i=0;i<input.length;i++){
            if(input[i]==root){//先找到root 插入值在右子树
                return 1;
            }else if(input[i]==insert){//先找到insert 插入值在左子树
                return -1;
            }
        }
        return 0;

    }
}
