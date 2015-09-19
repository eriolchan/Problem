namespace Problems
{
    /// <summary>
    /// Problem: 斐波那契数列
    /// 写一个函数, 输入n, 求斐波那契数列的第n项。
    /// </summary>
    public class Fibonacci
    {
        public static long Process_Recursively(uint n)
        {
            return n < 2 ? n : Process_Recursively(n - 1) + Process_Recursively(n - 2);
        }

        public static long Process_Iteratively(uint n)
        {
            if (n < 2)
            {
                return n;
            }

            long fibNMinusTwo = 0;
            long fibNMinusOne = 1;
            long fibN = 0;

            for (int i = 2; i <= n; ++i)
            {
                fibN = fibNMinusTwo + fibNMinusOne;
                fibNMinusTwo = fibNMinusOne;
                fibNMinusOne = fibN;
            }

            return fibN;
        }
    }
}
