namespace Problems
{
    using System;

    /// <summary>
    /// Problem: 旋转数组的最小数字
    /// 把一个数组最开始的若干个元素搬到数组的末尾, 我们称之为
    /// 数组的旋转。输入一个递增排序的数组的一个旋转, 输出旋转数组
    /// 的最小元素。
    /// </summary>
    public class MinNumberInRotatedArray
    {
        public static int Process(int[] array)
        {
            if (array == null || array.Length == 0)
            {
                throw new ArgumentException(Constants.InvalidInput);
            }

            int start = 0;
            int end = array.Length - 1;
            int mid = start;

            while (array[start] >= array[end])
            {
                if (end - start == 1)
                {
                    mid = end;
                    break;
                }

                mid = (start + end) / 2;

                if (array[start] == array[end] && array[mid] == array[start])
                {
                    return MinInOrder(array, start, end);
                }

                if (array[mid] >= array[start])
                {
                    start = mid;
                }
                else if (array[mid] <= array[end])
                {
                    end = mid;
                }
            }

            return array[mid];
        }
        private static int MinInOrder(int[] array, int start, int end)
        {
            int min = array[start];
            for (int i = start + 1; i <= end; ++i)
            {
                if (array[i] < min)
                {
                    min = array[i];
                }
            }

            return min;
        }
    }
}
