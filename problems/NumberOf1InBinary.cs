namespace Problems
{
    /// <summary>
    /// Problem: 二进制中1的个数
    /// 请实现一个函数, 输入一个整数, 输出该数二进制
    /// 表示中1的个数。
    /// </summary>
    public class NumberOf1InBinary
    {
        public static int Process(int n)
        {
            int count = 0;

            while (n != 0)
            {
                ++count;
                n = (n - 1) & n;
            }

            return count;
        }
    }
}
