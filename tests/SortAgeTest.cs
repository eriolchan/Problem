namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class SortAgeTest
    {
        [TestMethod]
        public void TestOnlyOneElement()
        {
            int[] array = new int[] { 1 };
            SortAge.Process(array);

            CollectionAssert.AreEqual(new int[] { 1 }, array);
        }

        [TestMethod]
        public void TestWithNoDuplicateElement()
        {
            int[] array = new int[] { 99, 5, 45, 20, 15 };
            SortAge.Process(array);

            CollectionAssert.AreEqual(new int[] { 5, 15, 20, 45, 99 }, array);
        }

        [TestMethod]
        public void TestWithDuplicateElement()
        {
            int[] array = new int[] { 80, 10, 20, 10, 5, 45, 45 };
            SortAge.Process(array);

            CollectionAssert.AreEqual(new int[] { 5, 10, 10, 20, 45, 45, 80 }, array);
        }

        [TestMethod]
        public void TestWithSameElements()
        {
            int[] array = new int[] { 5, 5, 5 };
            SortAge.Process(array);

            CollectionAssert.AreEqual(new int[] { 5, 5, 5 }, array);
        }

        [TestMethod]
        public void TestWithSortedArray()
        {
            int[] array = new int[] { 1, 2, 3 };
            SortAge.Process(array);

            CollectionAssert.AreEqual(new int[] { 1, 2, 3 }, array);
        }

        [TestMethod]
        public void TestNull()
        {
            int[] array = null;
            SortAge.Process(array);

            Assert.IsNull(array);
        }

        [TestMethod]
        public void TestEmptyArray()
        {
            int[] array = new int[0];
            SortAge.Process(array);

            CollectionAssert.AreEqual(new int[0], array);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInvalidInput()
        {
            int[] array = new int[] { 1, 3, 100, -1 };
            SortAge.Process(array);
        }
    }
}
