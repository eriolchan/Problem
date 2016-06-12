namespace Problems
{
    using System.Text;

    /// <summary>
    /// Problem: 二叉树中和为某一值的路径
    /// 输入一棵二叉树和一个整数, 打印出二叉树中结点值的和为
    /// 输入整数的所有路径。从树的根结点开始往下一直到叶结点
    /// 所经过的结点形成一条路径。
    /// </summary>
    public class PathInTree
    {
        private static StringBuilder output = new StringBuilder();

        public static string Result
        {
            get
            {
                return Helper.Output(output);
            }
        }

        public static void Process(TreeNode root, int sum)
        {
            if (root == null)
            {
                return;
            }
        }
    }
}
