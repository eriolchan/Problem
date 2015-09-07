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
            string expected = "4";

            PrintListInReversedOrder.ProcessRecursively(head);
            Assert.AreEqual(expected, PrintListInReversedOrder.Result);

            PrintListInReversedOrder.ProcessIteratively(head);
            Assert.AreEqual(expected, PrintListInReversedOrder.Result);
        }

        [TestMethod]
        public void TestMultipleNodes()
        {
            ListNode head = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            string expected = "531";

            PrintListInReversedOrder.ProcessRecursively(head);
            Assert.AreEqual(expected, PrintListInReversedOrder.Result);

            PrintListInReversedOrder.ProcessIteratively(head);
            Assert.AreEqual(expected, PrintListInReversedOrder.Result);
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
