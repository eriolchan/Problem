namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class StackPushPopOrderTest
    {
        [TestMethod]
        public void TestIsOrder()
        {
            int[] pushOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] popOrder = new int[] { 2, 5, 4, 3, 1 };

            Assert.IsTrue(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestIsOrderWithPopOneByOne()
        {
            int[] pushOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] popOrder = new int[] { 1, 2, 3, 4, 5 };

            Assert.IsTrue(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestIsOrderWithPopAll()
        {
            int[] pushOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] popOrder = new int[] { 5, 4, 3, 2, 1 };

            Assert.IsTrue(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestIsNotOrder()
        {
            int[] pushOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] popOrder = new int[] { 2, 5, 4, 1, 3 };

            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestHasDifferentElement()
        {
            int[] pushOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] popOrder = new int[] { 3, 5, 4, 0, 1 };

            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestOnlyOneElement()
        {
            int[] pushOrder = new int[] { 1 };
            int[] popOrder = new int[] { 1 };
            Assert.IsTrue(StackPushPopOrder.Process(pushOrder, popOrder));

            popOrder = new int[] { 2 };
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestLengthIsNotEqual()
        {
            int[] pushOrder = new int[] { 1 };
            int[] popOrder = new int[] { 1, 2 };
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));

            pushOrder = new int[] { 1, 2, 3 };
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestNull()
        {
            int[] pushOrder = new int[] { 1 };
            int[] popOrder = null;
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));

            pushOrder = null;
            popOrder = new int[] { 1 };
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));

            popOrder = null;
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));
        }

        [TestMethod]
        public void TestEmptyArray()
        {
            int[] pushOrder = new int[] { 1 };
            int[] popOrder = new int[0];
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));

            pushOrder = new int[0];
            popOrder = new int[] { 1 };
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));

            popOrder = new int[0];
            Assert.IsFalse(StackPushPopOrder.Process(pushOrder, popOrder));
        }
    }
}
