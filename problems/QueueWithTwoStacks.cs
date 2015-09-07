namespace Problems
{
    using System;
    using System.Collections.Generic;

    /// <summary>
    /// Problem: 用两个栈实现队列
    /// 用两个栈实现一个队列。队列的声明如下, 
    /// 请实现它的两个函数AppendTail和DeleteHead,
    /// 分别完成在队列尾部插入结点和在队列头部删除结点的功能
    /// </summary>
    public class QueueWithTwoStacks<T>
    {
        private readonly Stack<T> inStack;
        private readonly Stack<T> outStack;

        public QueueWithTwoStacks()
        {
            inStack = new Stack<T>();
            outStack = new Stack<T>();
        }

        public void AppendTail(T value)
        {
            inStack.Push(value);
        }

        public T DeleteHead()
        {
            if (outStack.Count == 0)
            {
                while (inStack.Count > 0)
                {
                    outStack.Push(inStack.Pop());
                }
            }

            if (outStack.Count == 0)
            {
                throw new InvalidOperationException(Constants.EmptyContainer);
            }

            return outStack.Pop();
        }
    }
}
