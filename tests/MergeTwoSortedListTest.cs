namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class MergeTwoSortedListTest
    {
        [TestMethod]
        public void TestFirstListIsNull()
        {
            int[] first = null;
            int[] second = new int[] { 4, 5, 6 };

            MergeTwoSortedList.Process(first, second, 0);
            Assert.IsNull(first);
        }

        [TestMethod]
        public void TestSecondListIsNull()
        {
            int[] first = Helper.CreateArray(new int[] { 1, 2, 3 }, 10);
            int[] second = null;

            MergeTwoSortedList.Process(first, second, 3);
            CollectionAssert.AreEqual(Helper.CreateArray(new int[] { 1, 2, 3 }, 10), first);
        }

        [TestMethod]
        public void TestFirstListIsEmpty()
        {
            int[] first = new int[10];
            int[] second = new int[] { 3, 4, 5 };

            MergeTwoSortedList.Process(first, second, 0);
            CollectionAssert.AreEqual(Helper.CreateArray(second, 10), first);
        }
        
        [TestMethod]
        public void TestSecondListIsEmpty()
        {
            int[] first = Helper.CreateArray(new int[] { 1, 2, 3 }, 10);
            int[] second = new int[0];

            MergeTwoSortedList.Process(first, second, 3);
            CollectionAssert.AreEqual(Helper.CreateArray(first, 10), first);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInsufficientArrayLength()
        {
            int[] first = Helper.CreateArray(new int[] { 1, 2, 3 }, 5);
            int[] second = new int[] { 4, 5, 6 };

            MergeTwoSortedList.Process(first, second, 3);
        }

        [TestMethod]
        public void TestFirstIsMoreThanSecond()
        {
            int[] first = Helper.CreateArray(new int[] { 4, 5, 6 }, 10);
            int[] second = new int[] { 1, 2, 3 };

            MergeTwoSortedList.Process(first, second, 3);
            CollectionAssert.AreEqual(Helper.CreateArray(new int[] { 1, 2, 3, 4, 5, 6 }, 10), first);
        }

        [TestMethod]
        public void TestFirstIsLessThanSecond()
        {
            int[] first = Helper.CreateArray(new int[] { 1, 2, 3 }, 10);
            int[] second = new int[] { 4, 5, 6 };

            MergeTwoSortedList.Process(first, second, 3);
            CollectionAssert.AreEqual(Helper.CreateArray(new int[] { 1, 2, 3, 4, 5, 6 }, 10), first);
        }

        [TestMethod]
        public void TestFirstInMiddleOfSecond()
        {
            int[] first = Helper.CreateArray(new int[] { 2, 4, 5 }, 10);
            int[] second = new int[] { 1, 3, 6 };

            MergeTwoSortedList.Process(first, second, 3);
            CollectionAssert.AreEqual(Helper.CreateArray(new int[] { 1, 2, 3, 4, 5, 6 }, 10), first);
        }

        [TestMethod]
        public void TestFirstIsSameAsSecond()
        {
            int[] first = Helper.CreateArray(new int[] { 1, 2 }, 5);
            int[] second = new int[] { 1, 2, 3 };

            MergeTwoSortedList.Process(first, second, 2);
            CollectionAssert.AreEqual(Helper.CreateArray(new int[] { 1, 1, 2, 2, 3 }, 5), first);
        }
    }
}
