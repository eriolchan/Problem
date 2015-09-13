namespace Problems
{
    using System;

    /// <summary>
    /// Problem: 合并两个排序数组
    /// 有两个排序的数组A1和A2, 内存在A1的末尾有足够多的空余空间
    /// 容纳A2。请实现一个函数, 把A2中的所有数字插入到A1中并且所有
    /// 的数字是排序的。
    /// </summary>
    public class MergeTwoSortedList
    {
        public static void Process(int[] first, int[] second, int firstCount)
        {
            if (first == null || second == null || second.Length == 0)
            {
                return;
            }

            int newLength = firstCount + second.Length;
            if (newLength > first.Length)
            {
                throw new ArgumentException(Constants.InvalidInput);
            }

            int newIndex = newLength - 1;
            int firstIndex = firstCount - 1;
            int secondIndex = second.Length - 1;
            while (firstIndex >= 0 && secondIndex >= 0)
            {
                if (first[firstIndex] >= second[secondIndex])
                {
                    first[newIndex--] = first[firstIndex--];
                }
                else
                {
                    first[newIndex--] = second[secondIndex--];
                }
            }

            while (secondIndex >= 0)
            {
                first[newIndex--] = second[secondIndex--];
            }
        }
    }
}
