namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class QueueWithTwoStacksTest
    {
        [TestMethod]
        public void TestWithEmptyQueue()
        {
            QueueWithTwoStacks<int> queue = new QueueWithTwoStacks<int>();
            queue.AppendTail(1);
            queue.AppendTail(2);

            Assert.AreEqual(1, queue.DeleteHead());
            Assert.AreEqual(2, queue.DeleteHead());
        }

        [TestMethod]
        public void TestWithNonEmptyQueue()
        {
            QueueWithTwoStacks<int> queue = new QueueWithTwoStacks<int>();
            queue.AppendTail(1);
            queue.AppendTail(2);
            Assert.AreEqual(1, queue.DeleteHead());

            queue.AppendTail(3);
            Assert.AreEqual(2, queue.DeleteHead());

            queue.AppendTail(4);
            Assert.AreEqual(3, queue.DeleteHead());
            Assert.AreEqual(4, queue.DeleteHead());
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void TestDequeuWithEmptyQueue()
        {
            QueueWithTwoStacks<int> queue = new QueueWithTwoStacks<int>();
            queue.DeleteHead();
        }
    }
}
