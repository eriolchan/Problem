namespace Problems
{
    using System;

    /// <summary>
    /// Problem: 调整数组顺序使奇数位于偶数前面
    /// 输入一个整数数组, 实现一个函数来调整该数组中数字的顺序,
    /// 使得所有奇数位于数组的前半部, 所有偶数位于数组的后半部。
    /// </summary>
    public class ReorderArray
    {
        public static void Process_OddEven(int[] array)
        {
            Process(array, IsOdd);
        }

        private static bool IsOdd(int i)
        {
            return (i & 1) == 1;
        }

        private static void Process(int[] array, Func<int, bool> function)
        {
            if (array == null || array.Length == 0 || function == null)
            {
                return;
            }

            int i = -1;
            for (int j = 0; j < array.Length; ++j)
            {
                if (function(array[j]))
                {
                    Helper.Swap(array, ++i, j);
                }
            }
        }
    }
}
