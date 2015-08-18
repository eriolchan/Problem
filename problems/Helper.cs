namespace Problems
{
    using System;

    static class Helper
    {
        public static void PrintArray(int[][] array)
        {
            if (array == null)
            {
                return;
            }

            for (int i = 0; i < array.Length; i++)
            {
                for (int j = 0; j < array[0].Length; j++)
                {
                    Console.Write(array[i][j] + " ");
                }

                Console.WriteLine();
            }
        }
    }
}
