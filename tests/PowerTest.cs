namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class PowerTest
    {
        [TestMethod]
        public void TestExponentIsZero()
        {
            Assert.AreEqual(1, Power.Process(2, 0), Constants.Precision);
            Assert.AreEqual(1, Power.Process(-2, 0), Constants.Precision);
            Assert.AreEqual(1, Power.Process(0, 0), Constants.Precision);
        }

        [TestMethod]
        public void TestExponentIsOne()
        {
            Assert.AreEqual(2, Power.Process(2, 1), Constants.Precision);
            Assert.AreEqual(-2, Power.Process(-2, 1), Constants.Precision);
            Assert.AreEqual(0, Power.Process(0, 1), Constants.Precision);
        }


        [TestMethod]
        public void TestExponentIsOdd()
        {
            Assert.AreEqual(8, Power.Process(2, 3), Constants.Precision);
            Assert.AreEqual(-8, Power.Process(-2, 3), Constants.Precision);
            Assert.AreEqual(0, Power.Process(0, 3), Constants.Precision);
        }

        [TestMethod]
        public void TestExponentIsEven()
        {
            Assert.AreEqual(16, Power.Process(2, 4), Constants.Precision);
            Assert.AreEqual(16, Power.Process(-2, 4), Constants.Precision);
            Assert.AreEqual(0, Power.Process(0, 4), Constants.Precision);
        }

        [TestMethod]
        public void TestExponentIsNegative()
        {
            Assert.AreEqual(0.5, Power.Process(2, -1), Constants.Precision);
            Assert.AreEqual(0.25, Power.Process(-2, -2), Constants.Precision);
            Assert.AreEqual(-0.125, Power.Process(-2, -3), Constants.Precision);
        }

        [TestMethod]
        public void TestRootIsDouble()
        {
            Assert.AreEqual(1.21, Power.Process(1.1, 2), Constants.Precision);
            Assert.AreEqual(-1.331, Power.Process(-1.1, 3), Constants.Precision);
            Assert.AreEqual(4, Power.Process(-0.5, -2), Constants.Precision);
            Assert.AreEqual(8, Power.Process(0.5, -3), Constants.Precision);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInvalidInput()
        {
            Power.Process(0, -2);
        }
    }
}
