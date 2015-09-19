namespace Problems
{
    /// <summary>
    /// Problem: 二进制运算
    /// </summary>
    public class Binary
    {
        /// <summary>
        /// 判断一个整数是不是2的整数次方
        /// </summary>
        /// <param name="n"></param>
        /// <returns></returns>
        public static bool IsPowerOf2(int n)
        {
            return n > 0 && (n & (n - 1)) == 0;
        }

        /// <summary>
        /// 输入两个整数m和n, 计算需要改变m的二进制表示中的
        /// 多少位才能得到n。
        /// </summary>
        public static int BitsToChange(int m, int n)
        {
            return NumberOf1InBinary.Process(m ^ n);
        }
    }
}
