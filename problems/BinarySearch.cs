namespace Problems
{
    /// <summary>
    /// Problem: 二分查找
    /// </summary>
    public class BinarySearch
    {
        public static int ProcessRecursively(int[] array, int number)
        {
            if (array == null || array.Length == 0)
            {
                return -1;
            }

            return ProcessCore(array, 0, array.Length - 1, number);
        }

        private static int ProcessCore(int[] array, int low, int high, int number)
        {
            if (low <= high)
            {
                int mid = (low + high) / 2;
                if (array[mid] == number)
                {
                    return mid;
                }
                else if (array[mid] < number)
                {
                    return ProcessCore(array, mid + 1, high, number);
                }
                else
                {
                    return ProcessCore(array, low, mid - 1, number);
                }
            }

            return -1;
        }

        public static int ProcessIteratively(int[] array, int number)
        {
            if (array == null || array.Length == 0)
            {
                return -1;
            }

            int low = 0;
            int high = array.Length - 1;
            int mid;

            while (low <= high)
            {
                mid = (low + high) / 2;
                if (array[mid] == number)
                {
                    return mid;
                }
                else if (array[mid] < number)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }

            return -1;
        }
    }
}
