namespace Problems
{
    public class SubstructureInTree
    {
        public static bool Process(TreeNode first, TreeNode second)
        {
            bool result = false;

            if (first != null && second != null)
            {
                if (first.Value == second.Value)
                {
                    result = ProcessCore(first, second);
                }

                if (!result)
                {
                    result = Process(first.Left, second);
                }

                if (!result)
                {
                    result = Process(first.Right, second);
                }
            }

            return result;
        }

        private static bool ProcessCore(TreeNode first, TreeNode second)
        {
            if (second == null)
            {
                return true;
            }

            if (first == null)
            {
                return false;
            }

            if (first.Value != second.Value)
            {
                return false;
            }

            return ProcessCore(first.Left, second.Left)
                && ProcessCore(first.Right, second.Right);
        }
    }
}
