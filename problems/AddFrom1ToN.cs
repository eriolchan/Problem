namespace Problems
{
    /// <summary>
    /// Problem: 求从1加到N的和
    /// </summary>
    public class AddFrom1ToN
    {
        public static int Process_Recursively(int n)
        {
            return n <= 0 ? 0 : n + Process_Recursively(n - 1);
        }

        public static int Process_Iteratively(int n)
        {
            int result = 0;
            for (int i = 1; i <= n; ++i)
            {
                result += i;
            }

            return result;
        }
    }
}
