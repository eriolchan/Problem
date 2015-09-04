namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class PrintListInReversedOrderTest
    {
        [TestMethod]
        public void TestOnlyOneNode()
        {
            ListNode head = new ListNode(4);

            PrintListInReversedOrder.ProcessRecursively(head);
            Assert.AreEqual("4", PrintListInReversedOrder.Result);

            PrintListInReversedOrder.ProcessIteratively(head);
            Assert.AreEqual("4", PrintListInReversedOrder.Result);
        }

        [TestMethod]
        public void TestMultipleNodes()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 3, 5 });

            PrintListInReversedOrder.ProcessRecursively(head);
            Assert.AreEqual("531", PrintListInReversedOrder.Result);

            PrintListInReversedOrder.ProcessIteratively(head);
            Assert.AreEqual("531", PrintListInReversedOrder.Result);
        }

        [TestMethod]
        public void TestNull()
        {
            ListNode head = null;

            PrintListInReversedOrder.ProcessRecursively(head);
            Assert.IsNull(PrintListInReversedOrder.Result);

            PrintListInReversedOrder.ProcessIteratively(head);
            Assert.IsNull(PrintListInReversedOrder.Result);
        } 
    }
}
