namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class BinaryTest
    {
		[TestMethod]
		public void TestIsPowerOf2WithNegative()
        {
            Assert.IsFalse(Binary.IsPowerOf2(-1));
        }

		[TestMethod]
		public void TestIsPowerOf2WithZero()
        {
            Assert.IsFalse(Binary.IsPowerOf2(0));
        }

		[TestMethod]
		public void TestIsPowerOf2WithOne()
        {
            Assert.IsTrue(Binary.IsPowerOf2(1));
        }

		[TestMethod]
		public void TestIsPowerOf2WithTwo()
        {
            Assert.IsTrue(Binary.IsPowerOf2(2));
        }

		[TestMethod]
		public void TestIsPowerOf2WithTrue()
        {
            Assert.IsTrue(Binary.IsPowerOf2(16));
        }

		[TestMethod]
		public void TestIsPowerOf2WithFalse()
        {
            Assert.IsFalse(Binary.IsPowerOf2(15));
        }

        [TestMethod]
        public void TestBitsToChange()
        {
            Assert.AreEqual(3, Binary.BitsToChange(10, 13));
        }

        [TestMethod]
        public void TestBitsToChangeWithZero()
        {
            Assert.AreEqual(1, Binary.BitsToChange(0, 4));
        }

        [TestMethod]
        public void TestBitsToChangeWithSame()
        {
            Assert.AreEqual(0, Binary.BitsToChange(1, 1));
        }

        [TestMethod]
        public void TestBitsToChangeWithAllBits()
        {
            Assert.AreEqual(32, Binary.BitsToChange(int.MaxValue, int.MinValue));
            Assert.AreEqual(32, Binary.BitsToChange(0, -1));
        }

        [TestMethod]
        public void TestBitsToChangeWithNegativeAndPositive()
        {
            Assert.AreEqual(31, Binary.BitsToChange(1, -1));
        }
    }
}
