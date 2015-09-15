namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class SortTest
    {
        [TestMethod]
        public void TestWithNoDuplicateElement()
        {
            int[] original = new int[] { 3, 9, 1, 7, 5 };
            int[] expected = new int[] { 1, 3, 5, 7, 9 };

            int[] array = (int[])original.Clone();
            Sort.QuickSort(array);
            CollectionAssert.AreEqual(expected, array);

            array = (int[])original.Clone();
            Sort.CountingSort(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestWithDuplicateElement()
        {
            int[] original = new int[] { 1, 5, 5, 9, 1 };
            int[] expected = new int[] { 1, 1, 5, 5, 9 };

            int[] array = (int[])original.Clone();
            Sort.QuickSort(array);
            CollectionAssert.AreEqual(expected, array);

            array = (int[])original.Clone();
            Sort.CountingSort(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestWithSortedArray()
        {
            int[] original = new int[] { 1, 3, 5, 7, 9 };
            int[] expected = original;

            int[] array = (int[])original.Clone();
            Sort.QuickSort(array);
            CollectionAssert.AreEqual(expected, array);

            array = (int[])original.Clone();
            Sort.CountingSort(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestWithSameElements()
        {
            int[] original = new int[] { 1, 1, 1, 1, 1 };
            int[] expected = original;

            int[] array = (int[])original.Clone();
            Sort.QuickSort(array);
            CollectionAssert.AreEqual(expected, array);

            array = (int[])original.Clone();
            Sort.CountingSort(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestOnlyOneElement()
        {
            int[] original = new int[] { 1 };
            int[] expected = original;

            int[] array = (int[])original.Clone();
            Sort.QuickSort(array);
            CollectionAssert.AreEqual(expected, array);

            array = (int[])original.Clone();
            Sort.CountingSort(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestNull()
        {
            int[] array = null;

            Sort.QuickSort(array);
            Assert.IsNull(array);

            Sort.CountingSort(array);
            Assert.IsNull(array);
        }

        [TestMethod]
        public void TestEmptyArray()
        {
            int[] array = new int[0];
            int[] expected = (int[])array.Clone();

            Sort.QuickSort(array);
            CollectionAssert.AreEqual(expected, array);

            Sort.CountingSort(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInvalidInput()
        {
            int[] array = new int[] { 1, 3, 10, 5, 7 };
            Sort.CountingSort(array);
        }
    }
}
