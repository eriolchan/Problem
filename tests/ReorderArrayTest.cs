namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class ReorderArrayTest
    {
        [TestMethod]
        public void TestOddIsBeforeEven()
        {
            int[] array = new int[] { 1, 3, 5, 2, 4 };
            int[] expected = Helper.CreateArray(array, array.Length);

            ReorderArray.Process_OddEven(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestOddIsAfterEven()
        {
            int[] array = new int[] { 2, 4, 1, 3, 5 };
            int[] expected = new int[] { 1, 3, 5, 4, 2 };

            ReorderArray.Process_OddEven(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestOddCrossEven()
        {
            int[] array = new int[] { 1, 2, 3, 4, 5 };
            int[] expected = new int[] { 1, 3, 5, 4, 2 };

            ReorderArray.Process_OddEven(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestOnlyOneOddElement()
        {
            int[] array = new int[] { 1 };
            int[] expected = Helper.CreateArray(array, array.Length);

            ReorderArray.Process_OddEven(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestOnlyOneEvenElement()
        {
            int[] array = new int[] { 2 };
            int[] expected = Helper.CreateArray(array, array.Length);

            ReorderArray.Process_OddEven(array);
            CollectionAssert.AreEqual(expected, array);
        }

        [TestMethod]
        public void TestNull()
        {
            int[] array = null;

            ReorderArray.Process_OddEven(array);
            Assert.IsNull(array);

            array = new int[0];

            ReorderArray.Process_OddEven(array);
            CollectionAssert.AreEqual(new int[0], array);
        }
    }
}
