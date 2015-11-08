namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class PrintMatrixClockwiselyTest
    {
        [TestMethod]
        public void TestTwoByTwoMatrix()
        {
            int[][] array = new int[2][]
            {
                new int[] { 1, 2 },
                new int[] { 3, 4 }
            };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual("1,2,4,3,", PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestFiveByFiveMatrix()
        {
            int[][] array = new int[5][]
            {
                new int[] { 1, 2, 3, 4, 5 },
                new int[] { 6, 7, 8, 9, 10 },
                new int[] { 11, 12, 13, 14, 15 },
                new int[] { 16, 17, 18, 19, 20 },
                new int[] { 21, 22, 23, 24, 25 }
            };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual(
                "1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13,",
                PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestFourByFourMatrix()
        {
            int[][] array = new int[4][]
            {
                new int[] { 1, 2, 3, 4 },
                new int[] { 5, 6, 7, 8 },
                new int[] { 9, 10, 11, 12 },
                new int[] { 13, 14, 15, 16 }
            };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual("1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10,", PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestFiveByTwoMatrix()
        {
            int[][] array = new int[5][]
            {
                new int[] { 1, 2 },
                new int[] { 3, 4 },
                new int[] { 5, 6 },
                new int[] { 7, 8 },
                new int[] { 9, 10 }
            };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual(
                "1,2,4,6,8,10,9,7,5,3,",
                PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestFiveByThreeMatrix()
        {
            int[][] array = new int[5][]
            {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9 },
                new int[] { 10, 11, 12 },
                new int[] { 13, 14, 15 }
            };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual(
                "1,2,3,6,9,12,15,14,13,10,7,4,5,8,11,",
                PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestTwoByFiveMatrix()
        {
            int[][] array = new int[2][]
            {
                new int[] { 1, 2, 3, 4, 5 },
                new int[] { 6, 7, 8, 9, 10 }
            };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual(
                "1,2,3,4,5,10,9,8,7,6,",
                PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestOnlyOneColumn()
        {
            int[][] array = new int[5][]
            {
                new int[] { 1 },
                new int[] { 2 },
                new int[] { 3 },
                new int[] { 4 },
                new int[] { 5 }
            };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual("1,2,3,4,5,", PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestOnlyOneRow()
        {
            int[][] array = new int[1][];
            array[0] = new int[] { 1, 2, 3, 4, 5 };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual("1,2,3,4,5,", PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestOnlyOneElement()
        {
            int[][] array = new int[1][];
            array[0] = new int[] { 1 };

            PrintMatrixClockwisely.Process(array);
            Assert.AreEqual("1,", PrintMatrixClockwisely.Result);
        }

        [TestMethod]
        public void TestNull()
        {
            int[][] array = null;
            PrintMatrixClockwisely.Process(array);
            Assert.IsNull(PrintMatrixClockwisely.Result);

            array = new int[0][];
            PrintMatrixClockwisely.Process(array);
            Assert.IsNull(PrintMatrixClockwisely.Result);

            array = new int[1][];
            array[0] = new int[0];
            PrintMatrixClockwisely.Process(array);
            Assert.IsNull(PrintMatrixClockwisely.Result);
        }
    }
}
