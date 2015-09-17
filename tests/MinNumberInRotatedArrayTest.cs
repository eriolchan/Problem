namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class MinNumberInRotatedArrayTest
    {
        [TestMethod]
        public void TestNoDuplicatedElement()
        {
            int[] array = new int[] { 3, 4, 5, 1, 2 };
            Assert.AreEqual(1, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        public void TestMinIsDuplicatedElement()
        {
            int[] array = new int[] { 3, 4, 5, 1, 1, 2 };
            Assert.AreEqual(1, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        public void TestMinIsNotDuplicatedElement()
        {
            int[] array = new int[] { 3, 4, 5, 1, 2, 2 };
            Assert.AreEqual(1, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        public void TestStartAndEndSameNotMin()
        {
            int[] array = new int[] { 1, 0, 1, 1, 1 };
            Assert.AreEqual(0, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        public void TestMinIsBothStartAndEnd()
        {
            int[] array = new int[] { 1, 1, 1, 2, 1 };
            Assert.AreEqual(1, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        public void TestSortedArray()
        {
            int[] array = new int[] { 1, 2, 3, 4, 5 };
            Assert.AreEqual(1, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        public void TestSameElements()
        {
            int[] array = new int[] { 1, 1, 1, 1, 1 };
            Assert.AreEqual(1, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        public void TestOnlyOneElement()
        {
            int[] array = new int[] { 1 };
            Assert.AreEqual(1, MinNumberInRotatedArray.Process(array));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestNull()
        {
            MinNumberInRotatedArray.Process(null);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestEmptyArray()
        {
            MinNumberInRotatedArray.Process(new int[0]);
        }
    }
}
