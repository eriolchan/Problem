namespace Problems
{
    using System;

    /// <summary>
    /// Problem: 替换空格
    /// 请实现一个函数, 把字符串中的每个空格换成“%20”。
    /// </summary>
    public class ReplaceBlank
    {
        public static void Process(char[] sentence)
        {
            if (sentence == null || sentence.Length == 0)
            {
                return;
            }

            int originalLength = 0;
            int numberOfBlank = 0;
            int i = 0;

            while (sentence[i] != '\0')
            {
                originalLength++;

                if (sentence[i] == ' ')
                {
                    numberOfBlank++;
                }

                i++;
            }

            int newLength = originalLength + 2 * numberOfBlank;
            if (newLength > sentence.Length)
            {
                throw new ArgumentException(Constants.InvalidInput);
            }

            int indexOfOriginal = originalLength - 1;
            int indexOfNew = newLength - 1;
            while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal)
            {
                if (sentence[indexOfOriginal] != ' ')
                {
                    sentence[indexOfNew--] = sentence[indexOfOriginal];
                }
                else
                {
                    sentence[indexOfNew--] = '0';
                    sentence[indexOfNew--] = '2';
                    sentence[indexOfNew--] = '%';
                }

                indexOfOriginal--;
            }
        }
    }
}
