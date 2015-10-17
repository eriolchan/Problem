namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System.Text;

    [TestClass]
    public class Print1ToMaxOfNDigitsTest
    {
        [TestMethod]
        public void TestNIsNegative()
        {
            Print1ToMaxOfNDigits.Process_Recursively(-1);
            Assert.IsNull(Print1ToMaxOfNDigits.Result);

            Print1ToMaxOfNDigits.Process(-1);
            Assert.IsNull(Print1ToMaxOfNDigits.Result);
        }

        [TestMethod]
        public void TestNIsZero()
        {
            Print1ToMaxOfNDigits.Process_Recursively(0);
            Assert.IsNull(Print1ToMaxOfNDigits.Result);

            Print1ToMaxOfNDigits.Process(0);
            Assert.IsNull(Print1ToMaxOfNDigits.Result);
        }

        [TestMethod]
        public void TestNIsOne()
        {
            StringBuilder expected = new StringBuilder();
            for (int i = 1; i < 10; ++i)
            {
                expected.Append(i + ",");
            }

            Print1ToMaxOfNDigits.Process_Recursively(1);
            Assert.AreEqual(expected.ToString(), Print1ToMaxOfNDigits.Result);

            Print1ToMaxOfNDigits.Process(1);
            Assert.AreEqual(expected.ToString(), Print1ToMaxOfNDigits.Result);
        }

        [TestMethod]
        public void TestNIsPositive()
        {
            StringBuilder expected = new StringBuilder();
            for (int i = 1; i < 1000; ++i)
            {
                expected.Append(i + ",");
            }

            Print1ToMaxOfNDigits.Process_Recursively(3);
            Assert.AreEqual(expected.ToString(), Print1ToMaxOfNDigits.Result);
        }
    }
}
