namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class StackWithTwoQueuesTest
    {
        [TestMethod]
        public void TestWithEmptyStack()
        {
            StackWithTwoQueues<int> stack = new StackWithTwoQueues<int>();
            stack.Push(1);
            stack.Push(2);

            Assert.AreEqual(2, stack.Pop());
            Assert.AreEqual(1, stack.Pop());
        }

        [TestMethod]
        public void TestWithNonEmptyStack()
        {
            StackWithTwoQueues<int> stack = new StackWithTwoQueues<int>();
            stack.Push(1);
            stack.Push(2);
            Assert.AreEqual(2, stack.Pop());

            stack.Push(3);
            Assert.AreEqual(3, stack.Pop());

            stack.Push(4);
            Assert.AreEqual(4, stack.Pop());
            Assert.AreEqual(1, stack.Pop());
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void TestPopWithEmptyStack()
        {
            StackWithTwoQueues<int> stack = new StackWithTwoQueues<int>();
            stack.Pop();
        }
    }
}
