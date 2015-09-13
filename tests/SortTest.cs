namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class SortTest
    {
        [TestMethod]
        public void TestWithNoDuplicateElement()
        {
            int[] array = new int[] { 5, 1, 2, 4, 3 };
            Sort.QuickSort(array);

            CollectionAssert.AreEqual(new int[] { 1, 2, 3, 4, 5 }, array);
        }

        [TestMethod]
        public void TestWithDuplicateElement()
        {
            int[] array = new int[] { 2, 1, 1, 2, 3 };
            Sort.QuickSort(array);

            CollectionAssert.AreEqual(new int[] { 1, 1, 2, 2, 3 }, array);
        }

        [TestMethod]
        public void TestWithSortedArray()
        {
            int[] array = new int[] { 1, 3, 5, 7, 8 };
            Sort.QuickSort(array);

            CollectionAssert.AreEqual(new int[] { 1, 3, 5, 7, 8 }, array);
        }

        [TestMethod]
        public void TestWithSameElements()
        {
            int[] array = new int[] { 1, 1, 1 };
            Sort.QuickSort(array);

            CollectionAssert.AreEqual(new int[] { 1, 1, 1 }, array);
        }

        [TestMethod]
        public void TestOnlyOneElement()
        {
            int[] array = new int[] { 1 };
            Sort.QuickSort(array);

            CollectionAssert.AreEqual(new int[] { 1 }, array);
        }

        [TestMethod]
        public void TestNull()
        {
            int[] array = null;
            Sort.QuickSort(array);

            Assert.IsNull(array);
        }

        [TestMethod]
        public void TestEmptyArray()
        {
            int[] array = new int[0];
            Sort.QuickSort(array);

            CollectionAssert.AreEqual(new int[0], array);
        }
    }
}
