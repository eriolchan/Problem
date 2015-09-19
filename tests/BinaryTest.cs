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
    }
}
