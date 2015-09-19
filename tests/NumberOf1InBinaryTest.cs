namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class NumberOf1InBinaryTest
    {
        [TestMethod]
        public void TestNIsOne()
        {
            Assert.AreEqual(1, NumberOf1InBinary.Process(1));
        }

        [TestMethod]
        public void TestNIsZero()
        {
            Assert.AreEqual(0, NumberOf1InBinary.Process(0));
        }

        [TestMethod]
        public void TestNIsPositive()
        {
            Assert.AreEqual(2, NumberOf1InBinary.Process(10));
        }

        [TestMethod]
        public void TestNIsMaxInt()
        {
            Assert.AreEqual(31, NumberOf1InBinary.Process(int.MaxValue));
        }

        [TestMethod]
        public void TestNIsMinusOne()
        {
            Assert.AreEqual(32, NumberOf1InBinary.Process(-1));
        }

        [TestMethod]
        public void TestNIsMinInt()
        {
            Assert.AreEqual(1, NumberOf1InBinary.Process(int.MinValue));
        }
    }
}
