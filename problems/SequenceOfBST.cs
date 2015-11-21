namespace Problems
{
    /// <summary>
    /// Problem: 二叉搜索树的后序遍历序列
    /// 输入一个整数数组, 判断该数组是不是某个二叉搜索树
    /// 的后序遍历的结果。假设输入的数组的任意两个数字都
    /// 互不相同。
    /// </summary>
    public class SequenceOfBST
    {
        public static bool Process(int[] sequence)
        {
            if (sequence == null || sequence.Length == 0)
            {
                return false;
            }

            return ProcessCore(sequence, 0, sequence.Length - 1);
        }

        private static bool ProcessCore(int[] sequence, int start, int end)
        {
            if (start >= end)
            {
                return true;
            }

            int root = sequence[end];

            int i = start;
            while (i < end && sequence[i] < root)
            {
                ++i;
            }

            for (int j = i; j < end; ++j)
            {
                if (sequence[j] < root)
                {
                    return false;
                }
            }

            return ProcessCore(sequence, start, i - 1) &&
                ProcessCore(sequence, i, end - 1);
        }
    }
}
