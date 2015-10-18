namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class DeleteNodeInListTest
    {
        [TestMethod]
        public void TestNodeIsHead()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            ListNode toBeDeleted = head;

            DeleteNodeInList.Process(ref head, toBeDeleted);
            Assert.IsTrue(Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 2, 3, 4, 5 }), head));
        }
        
        [TestMethod]
        public void TestNodeInTheMiddle()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            ListNode toBeDeleted = head.Next.Next;

            DeleteNodeInList.Process(ref head, toBeDeleted);
            Assert.IsTrue(Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 1, 2, 4, 5 }), head));
        }

        [TestMethod]
        public void TestNodeInTheEnd()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            ListNode toBeDeleted = head;
            while (toBeDeleted.Next != null)
            {
                toBeDeleted = toBeDeleted.Next;
            }

            DeleteNodeInList.Process(ref head, toBeDeleted);
            Assert.IsTrue(Helper.CompareLinkedList(Helper.CreateLinkedList(new int[] { 1, 2, 3, 4 }), head));
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            ListNode head = new ListNode(1);
            ListNode toBeDeleted = head;

            DeleteNodeInList.Process(ref head, toBeDeleted);
            Assert.IsNull(head);
        }

        [TestMethod]
        public void TestNull()
        {
            ListNode head = null;
            ListNode toBeDeleted = new ListNode(1);

            DeleteNodeInList.Process(ref head, toBeDeleted);
            Assert.IsNull(head);

            head = toBeDeleted;
            toBeDeleted = null;

            DeleteNodeInList.Process(ref head, toBeDeleted);
            Assert.AreEqual(new ListNode(1), head);
       }
    }
}
