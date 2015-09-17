namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class AddFrom1ToNTest
    {
        [TestMethod]
        public void TestNLessThan1()
        {
            Assert.AreEqual(0, AddFrom1ToN.Process_Recursively(-1));
            Assert.AreEqual(0, AddFrom1ToN.Process_Iteratively(-1));

            Assert.AreEqual(0, AddFrom1ToN.Process_Recursively(0));
            Assert.AreEqual(0, AddFrom1ToN.Process_Iteratively(0));
        }

        [TestMethod]
        public void TestNEqualsTo1()
        {
            Assert.AreEqual(1, AddFrom1ToN.Process_Recursively(1));
            Assert.AreEqual(1, AddFrom1ToN.Process_Iteratively(1));
        }

        [TestMethod]
        public void TestNMoreThan1()
        {
            Assert.AreEqual(55, AddFrom1ToN.Process_Recursively(10));
            Assert.AreEqual(55, AddFrom1ToN.Process_Iteratively(10));
        }
    }
}
