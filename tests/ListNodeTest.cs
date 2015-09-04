namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class ListNodeTest
    {
        [TestMethod]
        public void TestAddToTailWithNull()
        {
            ListNode head = null;
            ListNode.AddToTail(ref head, 5);

            Assert.AreEqual(true, Helper.CompareLinkedList(new ListNode(5), head));
        }

        [TestMethod]
        public void TestAddToTailWithOneNode()
        {
            ListNode head = new ListNode(1);
            ListNode.AddToTail(ref head, 5);

            Assert.AreEqual(true, Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 1, 5 }), head));
        }

        [TestMethod]
        public void TestAddToTailWithMultipleNodes()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3 });
            ListNode.AddToTail(ref head, 5);

            Assert.AreEqual(true, Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 1, 2, 3, 5 }), head));
        }

        [TestMethod]
        public void TestRemoveNodeWithNull()
        {
            ListNode head = null;
            ListNode.RemoveNode(ref head, 5);

            Assert.IsNull(head);
        }

        [TestMethod]
        public void TestRemoveNodeWithOnlyNode()
        {
            ListNode head = new ListNode(5);
            ListNode.RemoveNode(ref head, 5);

            Assert.IsNull(head);
        }

        [TestMethod]
        public void TestRemoveNodeWithInTheBegin()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 5, 7 });
            ListNode.RemoveNode(ref head, 5);

            Assert.AreEqual(true, Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 7 }), head));
        }

        [TestMethod]
        public void TestRemoveNodeWithInTheEnd()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            ListNode.RemoveNode(ref head, 5);

            Assert.AreEqual(true, Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 1, 3 }), head));
        }
        
        [TestMethod]
        public void TestRemoveNodeWithInTheMiddle()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 5, 7 });
            ListNode.RemoveNode(ref head, 5);

            Assert.AreEqual(true, Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 1, 7 }), head));
        }

        [TestMethod]
        public void TestRemoveNodeNotExist()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 3 });
            ListNode.RemoveNode(ref head, 5);

            Assert.AreEqual(true, Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 1, 3 }), head));
        }
    }
}
