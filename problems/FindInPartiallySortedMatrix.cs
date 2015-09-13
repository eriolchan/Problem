namespace Problems
{
    /// <summary>
    /// Problem: 二维数组中的查找
    /// 在一个二维数组中, 每一行都按照从左到右递增的顺序排序,
    /// 每一列都按照从上到下递增的顺序排序。请完成一个函数, 输入这样的
    /// 一个二维数组和一个整数, 判断数组中是否含有该整数。
    /// </summary>
    public class FindInPartiallySortedMatrix
    {
        public static bool Process(int[][] matrix, int number)
        {
            bool found = false;

            if (matrix != null && 
                matrix.Length > 0 && 
                matrix[0] != null &&
                matrix[0].Length > 0)
            {
                int row = 0;
                int column = matrix[0].Length - 1;

                while (row < matrix.Length && column >= 0)
                {
                    if (matrix[row][column] == number)
                    {
                        found = true;
                        break;
                    }
                    else if (matrix[row][column] < number)
                    {
                        row++;
                    }
                    else
                    {
                        column--;
                    }
                }
            }

            return found;
        }
    }
}
