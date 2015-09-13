using System;

namespace Problems
{
    /// <summary>
    /// Problem: 年龄排序
    /// </summary>
    public class SortAge
    {
        public static void Process(int[] array)
        {
            if (array == null || array.Length == 0)
            {
                return;
            }

            const int MaxAge = 99;
            int[] ages = new int[MaxAge + 1];

            foreach (int age in array)
            {
                if (age < 0 || age > 99)
                {
                    throw new ArgumentException(Constants.InvalidInput);
                }

                ages[age]++;
            }

            int index = 0;
            for (int i = 0; i < ages.Length; i++)
            {
                for (int j = 0; j < ages[i]; j++)
                {
                    array[index++] = i;
                    if (index == array.Length)
                    {
                        break;
                    }
                }
            }
        }
    }
}
