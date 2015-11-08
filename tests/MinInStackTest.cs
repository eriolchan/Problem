namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class MinInStackTest
    {
        [TestMethod]
        public void TestInsertIncrease()
        {
            MinInStack<int> stack = new MinInStack<int>();

            stack.Push(1);
            Assert.AreEqual(1, stack.Min());

            stack.Push(2);
            Assert.AreEqual(1, stack.Min());

            stack.Push(3);
            Assert.AreEqual(1, stack.Min());

            stack.Pop();
            Assert.AreEqual(1, stack.Min());

            stack.Pop();
            Assert.AreEqual(1, stack.Min());
        }
        
        [TestMethod]
        public void TestInsertDecrease()
        {
            MinInStack<int> stack = new MinInStack<int>();

            stack.Push(3);
            Assert.AreEqual(3, stack.Min());

            stack.Push(2);
            Assert.AreEqual(2, stack.Min());

            stack.Push(1);
            Assert.AreEqual(1, stack.Min());

            stack.Pop();
            Assert.AreEqual(2, stack.Min());

            stack.Pop();
            Assert.AreEqual(3, stack.Min());
        }
        
        [TestMethod]
        public void TestInsertUnsorted()
        {
            MinInStack<int> stack = new MinInStack<int>();

            stack.Push(2);
            Assert.AreEqual(2, stack.Min());

            stack.Push(1);
            Assert.AreEqual(1, stack.Min());

            stack.Push(3);
            Assert.AreEqual(1, stack.Min());

            stack.Pop();
            Assert.AreEqual(1, stack.Min());

            stack.Pop();
            Assert.AreEqual(2, stack.Min());
        }

        [TestMethod]
        public void TestWithSameElement()
        {
            MinInStack<int> stack = new MinInStack<int>();

            stack.Push(2);
            Assert.AreEqual(2, stack.Min());

            stack.Push(3);
            Assert.AreEqual(2, stack.Min());

            stack.Push(2);
            Assert.AreEqual(2, stack.Min());

            stack.Push(1);
            Assert.AreEqual(1, stack.Min());

            stack.Pop();
            Assert.AreEqual(2, stack.Min());

            stack.Pop();
            Assert.AreEqual(2, stack.Min());

            stack.Pop();
            Assert.AreEqual(2, stack.Min());
        }

        [TestMethod]
        public void TestOnlyOneElement()
        {
            MinInStack<int> stack = new MinInStack<int>();

            stack.Push(1);
            Assert.AreEqual(1, stack.Min());

            stack.Pop();
            stack.Push(2);
            Assert.AreEqual(2, stack.Min());
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void TestEmpty()
        {
            MinInStack<int> stack = new MinInStack<int>();
            stack.Min();
        }
    }
}
