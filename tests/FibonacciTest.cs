namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class FibonacciTest
    {
        [TestMethod]
        public void TestNEqualsTo0()
        {
            Assert.AreEqual(0, Fibonacci.Process_Recursively(0));
            Assert.AreEqual(0, Fibonacci.Process_Iteratively(0));
        }

        [TestMethod]
        public void TestNEqualsTo1()
        {
            Assert.AreEqual(1, Fibonacci.Process_Recursively(1));
            Assert.AreEqual(1, Fibonacci.Process_Iteratively(1));
        }

        [TestMethod]
        public void TestNMoreThan1()
        {
            Assert.AreEqual(55, Fibonacci.Process_Recursively(10));
            Assert.AreEqual(55, Fibonacci.Process_Iteratively(10));
        }
    }
}
