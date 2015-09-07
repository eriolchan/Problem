using System;
using System.Collections.Generic;

namespace Problems
{
    /// <summary>
    /// Problem: 用两个队列实现一个栈
    /// </summary>
    /// <typeparam name="T"></typeparam>
    public class StackWithTwoQueues<T>
    {
        private Queue<T> inQueue;
        private Queue<T> outQueue;

        public StackWithTwoQueues()
        {
            inQueue = new Queue<T>();
            outQueue= new Queue<T>();
        }

        public void Push(T value)
        {
            inQueue.Enqueue(value);
        }

        public T Pop()
        {
            if (inQueue.Count == 0)
            {
                throw new InvalidOperationException(Constants.EmptyContainer);
            }

            if (inQueue.Count == 1)
            {
                return inQueue.Dequeue();
            }

            while (inQueue.Count > 1)
            {
                outQueue.Enqueue(inQueue.Dequeue());
            }

            Queue<T> temp = inQueue;
            inQueue = outQueue;
            outQueue = temp;

            return outQueue.Dequeue();
        }
    }
}
