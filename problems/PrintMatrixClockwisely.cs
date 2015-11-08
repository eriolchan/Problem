namespace Problems
{
    using System.Text;

    /// <summary>
    /// Problem: 顺时针打印矩阵
    /// 输入一个矩阵, 按照从外向里以顺时针的顺序依次打印出每一个数字。
    /// </summary>
    public class PrintMatrixClockwisely
    {
        private static StringBuilder output = new StringBuilder();

        public static string Result
        {
            get
            {
                return Helper.Output(output);
            }
        }

        public static void Process(int[][] array)
        {
            if (array == null || array.Length == 0 || array[0].Length == 0)
            {
                return;
            }

            int start = 0;
            while (array.Length > start * 2 && array[0].Length > start * 2)
            {
                ProcessCore(array, start);
                ++start;
            }
        }

        private static void ProcessCore(int[][] array, int start)
        {
            int endX = array[0].Length - 1 - start;
            int endY = array.Length - 1 - start;

            for (int i = start; i <= endX; ++i)
            {
                output.Append(array[start][i] + ",");
            }

            if (endY > start)
            {
                for (int i = start + 1; i <= endY; ++i)
                {
                    output.Append(array[i][endX] + ",");
                }
            }

            if (endX > start && endY > start)
            {
                for (int i = endX - 1; i >= start; --i)
                {
                    output.Append(array[endY][i] + ",");
                }
            }

            if (endY > start + 1 && endX > start)
            {
                for (int i = endY - 1; i > start; --i)
                {
                    output.Append(array[i][start] + ",");
                }
            }
        }
    }
}
