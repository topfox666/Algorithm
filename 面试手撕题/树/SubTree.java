/**
 * 判断B是不是A的子结构
 * 时间复杂度 O(mn) mn分别为AB的节点数
 * 空间复杂度 o(m)  m为A的节点数
 */
public class SubTree {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
         if(A==null || B==null) return false;
         return isMatch(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean isMatch(TreeNode A, TreeNode B){

        if(A==null && B!=null) return false;
        if(B==null) return true;
            return A.val==B.val && isMatch(A.left,B.left)&& isMatch(A.right,B.right);
    }
}
