namespace Problems
{
    using System;

    /// <summary>
    /// Problem: 数值的整数次方
    /// 实现函数 double Power(double root, int exponent), 
    /// 求base的exponent次方。不需要考虑大数问题。
    /// </summary>
    public class Power
    {
        public static double Process(double root, int exponent)
        {
            if (Helper.DoubleIsEqual(root, 0.0) && exponent < 0)
            {
                throw new ArgumentException(Constants.InvalidInput);
            }

            double result = ProcessCore(root, Math.Abs(exponent));
            return exponent < 0 ? 1.0 / result : result;
        }

        private static double ProcessCore(double root, int exponent)
        {
            if (exponent == 0)
            {
                return 1;
            }

            if (exponent == 1)
            {
                return root;
            }

            double result = root;
            for (int i = 1; (i << 1) <= exponent; i <<= 1)
            {
                result *= result;
            }

            if ((exponent & 0x1) == 1)
            {
                result *= root;
            }

            return result;
        }
    }
}
