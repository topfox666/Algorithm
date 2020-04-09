import java.util.*;

public class TreeTraversal {
    List<Integer> list = new ArrayList<>();
    //递归前序遍历
    public List<Integer> preorderTraversal1(TreeNode root) {
        if(root==null) return list;
        list.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
        return list;
    }
    //迭代前序遍历
    public List<Integer> preorderTraversal2(TreeNode root){
        Stack<TreeNode> s=new Stack<>();
        if(root==null) return list;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode current=s.pop();
            list.add(current.val);
            if(current.right!=null) s.push(current.right);
            if(current.left!=null) s.push(current.left);
        }
        return list;
    }
    //递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
    //递归后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
    //层序遍历，队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        int count=1;
        while(!q.isEmpty()) {

            ArrayList<Integer> templist = new ArrayList<>();
            while (count > 0) {
                count--;
                TreeNode current = q.poll();
                templist.add(current.val);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            list.add(templist);
            count = q.size();
        }
        return list;
    }
}
