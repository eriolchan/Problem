namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class FindInPartiallySortedMatrixTest
    {
        private static readonly int[][] matrix = new int[][]
        {
            new int[] {1, 2, 8, 9},
            new int[] {2, 4, 9, 12},
            new int[] {4, 7, 10, 13},
            new int[] {6, 8, 11, 15}
        };

        [TestMethod]
        public void TestNumberInMatrix()
        {
            Assert.IsTrue(FindInPartiallySortedMatrix.Process(matrix, 7));
        }

        [TestMethod]
        public void TestNumberNotInMatrix()
        {
            Assert.IsFalse(FindInPartiallySortedMatrix.Process(matrix, 5));
        }

        [TestMethod]
        public void TestNumberIsMin()
        {
            Assert.IsTrue(FindInPartiallySortedMatrix.Process(matrix, 1));
        }

        [TestMethod]
        public void TestNumberIsMax()
        {
            Assert.IsTrue(FindInPartiallySortedMatrix.Process(matrix, 15));
        }

        [TestMethod]
        public void TestNumberIsLessThanMin()
        {
            Assert.IsFalse(FindInPartiallySortedMatrix.Process(matrix, 0));
        }

        [TestMethod]
        public void TestNumberIsMoreThanMax()
        {
            Assert.IsFalse(FindInPartiallySortedMatrix.Process(matrix, 16));
        }

        [TestMethod]
        public void TestNullMatrix()
        {
            Assert.IsFalse(FindInPartiallySortedMatrix.Process(null, 7));
        }
    }
}
