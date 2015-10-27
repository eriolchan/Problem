namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class MergeSortedListTest
    {
        [TestMethod]
        public void TestFirstIsNull()
        {
            ListNode first = null;
            ListNode second = Helper.CreateLinkedList(new int[] { 2, 4, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 2, 4, 6 }),
                MergeSortedList.Process(first, second)));
            
            first = null;
            second = Helper.CreateLinkedList(new int[] { 2, 4, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 2, 4, 6 }),
                MergeSortedList.Process_Recursively(first, second)));
        }
        
        [TestMethod]
        public void TestSecondIsNull()
        {
            ListNode first = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            ListNode second = null;

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 3, 5 }),
                MergeSortedList.Process(first, second)));
            
            first = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            second = null;

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 3, 5 }),
                MergeSortedList.Process_Recursively(first, second)));
        }

        [TestMethod]
        public void TestFirstCrossSecond()
        {
            ListNode first = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            ListNode second = Helper.CreateLinkedList(new int[] { 2, 4, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process(first, second)));

            first = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            second = Helper.CreateLinkedList(new int[] { 2, 4, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process_Recursively(first, second)));
        }

        [TestMethod]
        public void TestFirstBeforeSecond()
        {
            ListNode first = Helper.CreateLinkedList(new int[] { 1, 2, 4 });
            ListNode second = Helper.CreateLinkedList(new int[] { 3, 5, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process(first, second)));

            first = Helper.CreateLinkedList(new int[] { 1, 2, 4 });
            second = Helper.CreateLinkedList(new int[] { 3, 5, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process_Recursively(first, second)));
        }

        [TestMethod]
        public void TestFirstAfterSecond()
        {
            ListNode first = Helper.CreateLinkedList(new int[] { 3, 5, 6 });
            ListNode second = Helper.CreateLinkedList(new int[] { 1, 2, 4 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process(first, second)));

            first = Helper.CreateLinkedList(new int[] { 3, 5, 6 });
            second = Helper.CreateLinkedList(new int[] { 1, 2, 4 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process_Recursively(first, second)));
        }

        [TestMethod]
        public void TestFirstSecondBySort()
        {
            ListNode first = Helper.CreateLinkedList(new int[] { 1, 2, 3 });
            ListNode second = Helper.CreateLinkedList(new int[] { 4, 5, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process(first, second)));

            first = Helper.CreateLinkedList(new int[] { 1, 2, 3 });
            second = Helper.CreateLinkedList(new int[] { 4, 5, 6 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }),
                MergeSortedList.Process_Recursively(first, second)));
        }

        [TestMethod]
        public void TestHasSameValue()
        {
            ListNode first = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            ListNode second = Helper.CreateLinkedList(new int[] { 1, 3, 5 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 1, 3, 3, 5, 5 }),
                MergeSortedList.Process(first, second)));

            first = Helper.CreateLinkedList(new int[] { 1, 3, 5 });
            second = Helper.CreateLinkedList(new int[] { 1, 3, 5 });

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 1, 3, 3, 5, 5 }),
                MergeSortedList.Process_Recursively(first, second)));
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            ListNode first = new ListNode(2);
            ListNode second = new ListNode(1);

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2 }),
                MergeSortedList.Process(first, second)));

            first = new ListNode(2);
            second = new ListNode(1);

            Assert.IsTrue(Helper.CompareLinkedList(
                Helper.CreateLinkedList(new int[] { 1, 2 }),
                MergeSortedList.Process_Recursively(first, second)));
        }

        [TestMethod]
        public void TestNull()
        {
            Assert.IsNull(MergeSortedList.Process(null, null));
            Assert.IsNull(MergeSortedList.Process_Recursively(null, null));
        }
    }
}
