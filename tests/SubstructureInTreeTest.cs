namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class SubstructureInTreeTest
    {
        [TestMethod]
        public void TestSubTreeInNotCompleteTree()
        {
            TreeNode first = new TreeNode(8);
            first.Left = new TreeNode(8);
            first.Left.Left = new TreeNode(9);
            first.Left.Right = new TreeNode(2);
            first.Left.Right.Left = new TreeNode(4);
            first.Left.Right.Right = new TreeNode(7);
            first.Right = new TreeNode(7);

            TreeNode second = new TreeNode(8);
            second.Left = new TreeNode(9);
            second.Right = new TreeNode(2);

            Assert.IsTrue(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestNotSubTreeInNotCompleteTree()
        {
            TreeNode first = new TreeNode(8);
            first.Left = new TreeNode(8);
            first.Left.Left = new TreeNode(9);
            first.Left.Right = new TreeNode(3);
            first.Left.Right.Left = new TreeNode(4);
            first.Left.Right.Right = new TreeNode(7);
            first.Right = new TreeNode(7);

            TreeNode second = new TreeNode(8);
            second.Left = new TreeNode(9);
            second.Right = new TreeNode(2);

            Assert.IsFalse(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestSubTreeInNoRightChildTree()
        {
            TreeNode first = new TreeNode(8);
            first.Left = new TreeNode(8);
            first.Left.Left = new TreeNode(9);
            first.Left.Left.Left = new TreeNode(2);
            first.Left.Left.Left.Left = new TreeNode(5);

            TreeNode second = new TreeNode(8);
            second.Left = new TreeNode(9);
            second.Left.Left = new TreeNode(2);

            Assert.IsTrue(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestNotSubTreeInNoRightChildTree()
        {
            TreeNode first = new TreeNode(8);
            first.Left = new TreeNode(8);
            first.Left.Left = new TreeNode(9);
            first.Left.Left.Left = new TreeNode(3);
            first.Left.Left.Left.Left = new TreeNode(5);

            TreeNode second = new TreeNode(8);
            second.Left = new TreeNode(9);
            second.Left.Left = new TreeNode(2);

            Assert.IsFalse(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestSubTreeInNoLeftChildTree()
        {
            TreeNode first = new TreeNode(8);
            first.Right = new TreeNode(8);
            first.Right.Right = new TreeNode(9);
            first.Right.Right.Right = new TreeNode(2);
            first.Right.Right.Right.Right = new TreeNode(5);

            TreeNode second = new TreeNode(8);
            second.Right = new TreeNode(9);
            second.Right.Right = new TreeNode(2);

            Assert.IsTrue(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestNotSubTreeInNoLeftChildTree()
        {
            TreeNode first = new TreeNode(8);
            first.Right = new TreeNode(8);
            first.Right.Right = new TreeNode(9);
            first.Right.Right.Right = new TreeNode(2);
            first.Right.Right.Right.Right = new TreeNode(5);

            TreeNode second = new TreeNode(8);
            second.Right = new TreeNode(9);
            second.Right.Left = new TreeNode(3);
            second.Right.Right = new TreeNode(2);

            Assert.IsFalse(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestFirstIsSubTree()
        {
            TreeNode first = new TreeNode(8);
            first.Left = new TreeNode(9);
            first.Left.Left = new TreeNode(2);

            TreeNode second = new TreeNode(8);
            second.Left = new TreeNode(8);
            second.Left.Left = new TreeNode(9);
            second.Left.Left.Left = new TreeNode(2);
            second.Left.Left.Left.Left = new TreeNode(5);

            Assert.IsFalse(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            TreeNode first = new TreeNode(1);
            TreeNode second = new TreeNode(1);

            Assert.IsTrue(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestWithSameTree()
        {
            TreeNode first = new TreeNode(8);
            first.Left = new TreeNode(8);
            first.Left.Left = new TreeNode(9);
            first.Left.Right = new TreeNode(2);
            first.Left.Right.Left = new TreeNode(4);
            first.Left.Right.Right = new TreeNode(7);
            first.Right = new TreeNode(7);

            TreeNode second = Helper.Clone(first);

            Assert.IsTrue(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestFirstIsNull()
        {
            TreeNode first = null;
            TreeNode second = new TreeNode(1);

            Assert.IsFalse(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestSecondIsNull()
        {
            TreeNode first = new TreeNode(1);
            TreeNode second = null;

            Assert.IsFalse(SubstructureInTree.Process(first, second));
        }

        [TestMethod]
        public void TestBothNull()
        {
            Assert.IsFalse(SubstructureInTree.Process(null, null));
        }
    }
}
