namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class ReverseListTest
    {
        [TestMethod]
        public void TestLengthIsOdd()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3 });
            ListNode expected = Helper.CreateLinkedList(new int[] { 3, 2, 1 });

            Assert.IsTrue(Helper.CompareLinkedList(expected, ReverseList.Process(head)));

            head = Helper.CreateLinkedList(new int[] { 1, 2, 3 });
            Assert.IsTrue(Helper.CompareLinkedList(expected, ReverseList.Process_Recursively(head)));
        }

        [TestMethod]
        public void TestLengthIsEven()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4 });
            ListNode expected = Helper.CreateLinkedList(new int[] { 4, 3, 2, 1 });

            Assert.IsTrue(Helper.CompareLinkedList(expected, ReverseList.Process(head)));
            
            head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4 });
            Assert.IsTrue(Helper.CompareLinkedList(expected, ReverseList.Process_Recursively(head)));
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            ListNode head = new ListNode(1);
            Assert.AreEqual(new ListNode(1), ReverseList.Process(head));

            head = new ListNode(1);
            Assert.AreEqual(new ListNode(1), ReverseList.Process_Recursively(head));
        }

        [TestMethod]
        public void TestNull()
        {
            ListNode head = null;
            Assert.IsNull(ReverseList.Process(head));
            Assert.IsNull(ReverseList.Process_Recursively(head));
        }
    }
}
