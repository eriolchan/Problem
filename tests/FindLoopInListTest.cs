namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class FindLoopInListTest
    {
        [TestMethod]
        public void TestLoopLengthIsOdd()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3 });
            ListNode tail = Helper.GetLastNode(head);
            tail.Next = head;

            Assert.IsTrue(FindLoopInList.Process(head));
        }

        [TestMethod]
        public void TestLoopLengthIsEven()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4 });
            ListNode tail = Helper.GetLastNode(head);
            tail.Next = head;

            Assert.IsTrue(FindLoopInList.Process(head));
        }

        [TestMethod]
        public void TestLoopNotAtStart()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4 });
            ListNode tail = Helper.GetLastNode(head);
            tail.Next = head.Next;

            Assert.IsTrue(FindLoopInList.Process(head));
        }

        [TestMethod]
        public void TestWithoutLoop()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4 });
            Assert.IsFalse(FindLoopInList.Process(head));
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            ListNode head = new ListNode(1);
            Assert.IsFalse(FindLoopInList.Process(head));
        }

        [TestMethod]
        public void TestNull()
        {
            ListNode head = null;
            Assert.IsFalse(FindLoopInList.Process(head));
        }
    }
}
