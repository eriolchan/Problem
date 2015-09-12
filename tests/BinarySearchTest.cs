namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class BinarySearchTest
    {
        [TestMethod]
        public void TestNull()
        {
            int number = 1;

            Assert.AreEqual(-1, BinarySearch.ProcessRecursively(null, number));
            Assert.AreEqual(-1, BinarySearch.ProcessIteratively(null, number));
        }

        [TestMethod]
        public void TestEmptyArray()
        {
            int[] array = new int[0];
            int number = 1;

            Assert.AreEqual(-1, BinarySearch.ProcessRecursively(array, number));
            Assert.AreEqual(-1, BinarySearch.ProcessIteratively(array, number));
        }

        [TestMethod]
        public void TestOnlyOneElement()
        {
            int[] array = new int[] { 1 };
            int number = 1;

            Assert.AreEqual(0, BinarySearch.ProcessRecursively(array, number));
            Assert.AreEqual(0, BinarySearch.ProcessIteratively(array, number));
        }

        [TestMethod]
        public void TestResultExist()
        {
            int[] array = new int[] { 1, 2, 3 };
            int number = 2;

            Assert.AreEqual(1, BinarySearch.ProcessRecursively(array, number));
            Assert.AreEqual(1, BinarySearch.ProcessIteratively(array, number));
        }

        [TestMethod]
        public void TestResultNotExist()
        {
            int[] array = new int[] { 1, 2, 3 };
            int number = 4;

            Assert.AreEqual(-1, BinarySearch.ProcessRecursively(array, number));
            Assert.AreEqual(-1, BinarySearch.ProcessIteratively(array, number));
        }
    }
}
