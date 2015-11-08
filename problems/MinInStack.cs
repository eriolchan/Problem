namespace Problems
{
    using System;
    using System.Collections.Generic;

    /// <summary>
    /// Problem: 包含min函数的栈
    /// 定义栈的数据结构, 请在该类型中实现一个能够得到栈
    /// 的最小元素的min函数。在该栈中, 调用min, push, pop的
    /// 时间复杂度为O(1)。
    /// </summary>
    public class MinInStack<T> where T : IComparable
    {
        private Stack<T> stack;
        private Stack<T> minStack;

        public MinInStack()
        {
            stack = new Stack<T>();
            minStack = new Stack<T>();
        }

        public void Push(T value)
        {
            stack.Push(value);

            if (minStack.Count == 0)
            {
                minStack.Push(value);
            }
            else
            {
                T min = Min();
                minStack.Push(value.CompareTo(min) < 0 ? value : min);
            }
        }

        public T Pop()
        {
            if (stack.Count == 0)
            {
                throw new InvalidOperationException(Constants.EmptyContainer);
            }

            minStack.Pop();
            return stack.Pop();
        }

        public T Min()
        {
            if (minStack.Count == 0)
            {
                throw new InvalidOperationException(Constants.EmptyContainer);
            }

            return minStack.Peek();
        }
    }
}
