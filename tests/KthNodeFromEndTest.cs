namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class KthNodeFromEndTest
    {
        [TestMethod]
        public void TestNodeInTheMiddle()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            Assert.AreEqual(4, KthNodeFromEnd.Process(head, 2).Value);
        }

        [TestMethod]
        public void TestNodeIsHead()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            Assert.AreEqual(1, KthNodeFromEnd.Process(head, 5).Value);
        }

        [TestMethod]
        public void TestNodeInTheEnd()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            Assert.AreEqual(5, KthNodeFromEnd.Process(head, 1).Value);
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            ListNode head = new ListNode(1);
            Assert.AreEqual(1, KthNodeFromEnd.Process(head, 1).Value);
        }

        [TestMethod]
        public void TestNull()
        {
            ListNode head = null;
            Assert.IsNull(KthNodeFromEnd.Process(head, 1));
        }

        [TestMethod]
        public void TestKIsZero()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            Assert.IsNull(KthNodeFromEnd.Process(head, 0));
        }

        [TestMethod]
        public void TestListLengthIsInsufficient()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            Assert.IsNull(KthNodeFromEnd.Process(head, 6));
        }
    }
}
