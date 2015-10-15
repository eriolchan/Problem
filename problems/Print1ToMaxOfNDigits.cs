namespace Problems
{
    using System.Text;

    /// <summary>
    /// Problem: 打印1到最大的N位数
    /// 输入数字n, 按顺序打印出从1到最大的n位十进制数。
    /// </summary>
    public class Print1ToMaxOfNDigits
    {
        private const int Zero = 48;
        private static StringBuilder output = new StringBuilder();

        public static string Result
        {
            get
            {
                return Helper.Output(output);
            }
        }

        public static void Process_Recursively(int n)
        {
            if (n <= 0)
            {
                return;
            }

            char[] number = new char[n];

            for (int i = 0; i < 10; ++i)
            {
                number[0] = (char)(i + Zero);
                ProcessCore(number, n, 0);
            }
        }

        private static void ProcessCore(char[] number, int length, int index)
        {
            if (index == length - 1)
            {
                PrintNumber(number);
                return;
            }

            for (int i = 0; i < 10; ++i)
            {
                number[index + 1] = (char)(i + Zero);
                ProcessCore(number, length, index + 1);
            }
        }

        private static void PrintNumber(char[] number)
        {
            bool isBeginningZero = true;
            
            for (int i = 0; i < number.Length; ++i)
            {
                if (isBeginningZero && number[i] != '0')
                {
                    isBeginningZero = false;
                }

                if (!isBeginningZero)
                {
                    output.Append(number[i]);
                }
            }

            if (!isBeginningZero)
            {
                output.Append(',');
            }
        }
    }
}
