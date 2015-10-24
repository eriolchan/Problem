namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class FindMiddleNodeOfListTest
    {
        [TestMethod]
        public void TestLengthIsOdd()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5 });
            Assert.AreEqual(3, FindMiddleNodeOfList.Process(head).Value);
        }

        [TestMethod]
        public void TestLengthIsEven()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2, 3, 4 });
            Assert.AreEqual(2, FindMiddleNodeOfList.Process(head).Value);
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            ListNode head = new ListNode(1);
            Assert.AreEqual(1, FindMiddleNodeOfList.Process(head).Value);
        }

        [TestMethod]
        public void TestOnlyTwoNodes()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 2 });
            Assert.AreEqual(1, FindMiddleNodeOfList.Process(head).Value);
        }

        [TestMethod]
        public void TestNull()
        {
            ListNode head = null;
            Assert.IsNull(FindMiddleNodeOfList.Process(head));
        }
    }
}
