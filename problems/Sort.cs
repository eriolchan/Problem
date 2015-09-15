using System;

namespace Problems
{
    /// <summary>
    /// Problem: 排序
    /// </summary>
    public class Sort
    {
        /// <summary>
        /// Average: O(nlogn)
        /// Best: O(nlogn)
        /// Worst: O(n2)
        /// Stable: No
        /// </summary>
        /// <param name="array"></param>
        public static void QuickSort(int[] array)
        {
            if (array == null || array.Length == 0)
            {
                return;
            }

            QuickSortCore(array, 0, array.Length - 1);
        }

        private static void QuickSortCore(int[] array, int start, int end)
        {
            if (start < end)
            {
                int index = Partition(array, start, end);
                QuickSortCore(array, start, index - 1);
                QuickSortCore(array, index + 1, end);
            }
        }

        private static int Partition(int[] array, int start, int end)
        {
            int pivot = Helper.random.Next(start, end);
            Helper.Swap(array, pivot, end);

            pivot = start - 1;
            for (int i = start; i < end; i++)
            {
                if (array[i] < array[end])
                {
                    pivot++;
                    Helper.Swap(array, pivot, i);
                }
            }

            pivot++;
            Helper.Swap(array, pivot, end);

            return pivot;
        }

        /// <summary>
        /// Average: O(n)
        /// Best: O(n)
        /// Worst: O(n)
        /// Stable: Yes
        /// Condition: 数组中的每个元素都是0~k之间的整数
        /// </summary>
        /// <param name="array"></param>
        public static void CountingSort(int[] array)
        {
            if (array == null || array.Length == 0)
            {
                return;
            }

            const int k = 9;
            int[] counter = new int[k + 1];

            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] < 0 || array[i] > k)
                {
                    throw new ArgumentException(Constants.InvalidInput);
                }

                counter[array[i]]++;
            }

            for (int i = 1; i < counter.Length; i++)
            {
                counter[i] += counter[i - 1];
            }

            int[] result = new int[array.Length];
            for (int i = array.Length - 1; i >= 0; i--)
            {
                result[--counter[array[i]]] = array[i];
            }

            result.CopyTo(array, 0);
        }
    }
}
