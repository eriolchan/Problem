namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class TreeNodeTest
    {
        [TestMethod]
        public void TestPreOrderTraverseNotCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NotCompleteTree);
            string expected = "12473568";

            TreeNode.PreOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PreOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestInOrderTraverseNotCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NotCompleteTree);
            string expected = "47215386";

            TreeNode.InOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.InOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPostOrderTraverseNotCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NotCompleteTree);
            string expected = "74258631";

            TreeNode.PostOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PostOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestLevelOrderTraverseNotCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NotCompleteTree);
            string expected = "12345678";

            TreeNode.LevelOrderTraverse(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPreOrderTraverseNoRightChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoRightChildTree);
            string expected = "12345";

            TreeNode.PreOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PreOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestInOrderTraverseNoRightChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoRightChildTree);
            string expected = "54321";

            TreeNode.InOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.InOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPostOrderTraverseNoRightChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoRightChildTree);
            string expected = "54321";

            TreeNode.PostOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PostOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestLevelOrderTraverseNoRightChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoRightChildTree);
            string expected = "12345";

            TreeNode.LevelOrderTraverse(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPreOrderTraverseNoLeftChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoLeftChildTree);
            string expected = "12345";

            TreeNode.PreOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PreOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestInOrderTraverseNoLeftChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoLeftChildTree);
            string expected = "12345";

            TreeNode.InOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.InOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPostOrderTraverseNoLeftChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoLeftChildTree);
            string expected = "54321";

            TreeNode.PostOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PostOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestLevelOrderTraverseNoLeftChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoLeftChildTree);
            string expected = "12345";

            TreeNode.LevelOrderTraverse(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPreOrderTraverseOnlyRootTree()
        {
            TreeNode root = new TreeNode(1);
            string expected = "1";

            TreeNode.PreOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PreOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestInOrderTraverseOnlyRootTree()
        {
            TreeNode root = new TreeNode(1);
            string expected = "1";

            TreeNode.InOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.InOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPostOrderTraverseOnlyRootTree()
        {
            TreeNode root = new TreeNode(1);
            string expected = "1";

            TreeNode.PostOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PostOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestLevelOrderTraverseOnlyRootTree()
        {
            TreeNode root = new TreeNode(1);
            string expected = "1";

            TreeNode.LevelOrderTraverse(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPreOrderTraverseCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.CompleteTree);
            string expected = "1245367";

            TreeNode.PreOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PreOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestInOrderTraverseCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.CompleteTree);
            string expected = "4251637";

            TreeNode.InOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.InOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPostOrderTraverseCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.CompleteTree);
            string expected = "4526731";

            TreeNode.PostOrderTraverseRecursively(root);
            Assert.AreEqual(expected, TreeNode.Result);

            TreeNode.PostOrderTraverseIteratively(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestLevelOrderTraverseCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.CompleteTree);
            string expected = "1234567";

            TreeNode.LevelOrderTraverse(root);
            Assert.AreEqual(expected, TreeNode.Result);
        }

        [TestMethod]
        public void TestPreOrderTraverseNull()
        {
            TreeNode root = null;

            TreeNode.PreOrderTraverseRecursively(root);
            Assert.IsNull(root);

            TreeNode.PreOrderTraverseIteratively(root);
            Assert.IsNull(root);
        }

        [TestMethod]
        public void TestInOrderTraverseNull()
        {
            TreeNode root = null;

            TreeNode.InOrderTraverseRecursively(root);
            Assert.IsNull(root);

            TreeNode.InOrderTraverseIteratively(root);
            Assert.IsNull(root);
        }

        [TestMethod]
        public void TestPostOrderTraverseNull()
        {
            TreeNode root = null;

            TreeNode.PostOrderTraverseRecursively(root);
            Assert.IsNull(root);

            TreeNode.PostOrderTraverseIteratively(root);
            Assert.IsNull(root);
        }

        [TestMethod]
        public void TestLevelOrderTraverseNull()
        {
            TreeNode root = null;

            TreeNode.LevelOrderTraverse(root);
            Assert.IsNull(root);
        }
    }
}
