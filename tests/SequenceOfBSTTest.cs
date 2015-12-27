namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class SequenceOfBSTTest
    {
        [TestMethod]
        public void TestIsNotSequence()
        {
            int[] sequence = new int[] { 4, 6, 12, 8, 16, 14, 10 };
            Assert.IsFalse(SequenceOfBST.Process(sequence));

            sequence = new int[] { 10, 6, 8, 14, 4, 12, 18 };
            Assert.IsFalse(SequenceOfBST.Process_PreOrder(sequence));
        }

        [TestMethod]
        public void TestCompleteTree()
        {
            int[] sequence = new int[] { 4, 8, 6, 12, 16, 14, 10 };
            Assert.IsTrue(SequenceOfBST.Process(sequence));

            sequence = new int[] { 10, 6, 4, 8, 14, 12, 18 };
            Assert.IsTrue(SequenceOfBST.Process_PreOrder(sequence));
        }

        [TestMethod]
        public void TestNotCompleteTree()
        {
            int[] sequence = new int[] { 4, 6, 7, 5 };
            Assert.IsTrue(SequenceOfBST.Process(sequence));

            sequence = new int[] { 5, 4, 7, 6 };
            Assert.IsTrue(SequenceOfBST.Process_PreOrder(sequence));
        }

        [TestMethod]
        public void TestNoLeftChildTree()
        {
            int[] sequence = new int[] { 5, 4, 3, 2, 1 };
            Assert.IsTrue(SequenceOfBST.Process(sequence));

            sequence = new int[] { 1, 2, 3, 4, 5 };
            Assert.IsTrue(SequenceOfBST.Process_PreOrder(sequence));
        }

        [TestMethod]
        public void TestNoRightChildTree()
        {
            int[] sequence = new int[] { 1, 2, 3, 4, 5 };
            Assert.IsTrue(SequenceOfBST.Process(sequence));

            sequence = new int[] { 5, 4, 3, 2, 1 };
            Assert.IsTrue(SequenceOfBST.Process_PreOrder(sequence));
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            int[] sequence = new int[] { 1 };
            Assert.IsTrue(SequenceOfBST.Process(sequence));
            Assert.IsTrue(SequenceOfBST.Process_PreOrder(sequence));
        }

        [TestMethod]
        public void TestNull()
        {
            int[] sequence = null;
            Assert.IsFalse(SequenceOfBST.Process(sequence));
            Assert.IsFalse(SequenceOfBST.Process_PreOrder(sequence));
        }

        [TestMethod]
        public void TestEmpty()
        {
            int[] sequence = new int[0];
            Assert.IsFalse(SequenceOfBST.Process(sequence));
            Assert.IsFalse(SequenceOfBST.Process_PreOrder(sequence));
        }
    }
}
