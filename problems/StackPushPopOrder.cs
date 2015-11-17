namespace Problems
{
    using System.Collections.Generic;

    /// <summary>
    /// Problem: 栈的压入弹出序列
    /// 输入两个整数序列, 第一个序列表示栈的压入顺序, 请判断
    /// 第二个序列是否为该栈的弹出序列。假设压入栈的所有数字
    /// 均不相等。
    /// </summary>
    public class StackPushPopOrder
    {
        public static bool Process(int[] pushOrder, int[] popOrder)
        {
            bool result = false;

            if (pushOrder != null &&
                popOrder != null &&
                pushOrder.Length == popOrder.Length &&
                pushOrder.Length > 0)
            {
                Stack<int> stack = new Stack<int>();
                int i = 0;
                int j = 0;

                while (j < popOrder.Length)
                {
                    while (stack.Count == 0 || stack.Peek() != popOrder[j])
                    {
                        if (i == pushOrder.Length)
                        {
                            break;
                        }

                        stack.Push(pushOrder[i++]);
                    }

                    if (stack.Peek() != popOrder[j])
                    {
                        break;
                    }

                    stack.Pop();
                    ++j;
                }

                if (stack.Count == 0 && j == popOrder.Length)
                {
                    result = true;
                }
            }

            return result;
        }
    }
}
