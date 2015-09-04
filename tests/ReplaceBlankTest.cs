namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class ReplaceBlankTest
    {
        [TestMethod]
        public void TestBlankInTheMiddle()
        {
            char[] sentence = Helper.CreateArray("hello world", 20);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("hello%20world", 20), sentence);
        }

        [TestMethod]
        public void TestBlankInTheBegin()
        {
            char[] sentence = Helper.CreateArray(" helloworld", 20);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("%20helloworld", 20), sentence);
        }

        [TestMethod]
        public void TestBlankInTheEnd()
        {
            char[] sentence = Helper.CreateArray("helloworld ", 20);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("helloworld%20", 20), sentence);
        }

        [TestMethod]
        public void TestMultipleBlanks()
        {
            char[] sentence = Helper.CreateArray("hello  world", 20);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("hello%20%20world", 20), sentence);
        }

        [TestMethod]
        public void TestNull()
        {
            char[] sentence = null;
            ReplaceBlank.Process(sentence);

            Assert.IsNull(sentence);
        }

        [TestMethod]
        public void TestEmpty()
        {
            char[] sentence = new char[0];
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(new char[0], sentence);
        }

        [TestMethod]
        public void TestOnlyOneBlank()
        {
            char[] sentence = Helper.CreateArray(" ", 20);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("%20", 20), sentence);
        }

        [TestMethod]
        public void TestNoBlank()
        {
            char[] sentence = Helper.CreateArray("helloworld", 20);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("helloworld", 20), sentence);
        }

        [TestMethod]
        public void TestAllBlanks()
        {
            char[] sentence = Helper.CreateArray("   ", 20);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("%20%20%20", 20), sentence);
        }

        [TestMethod]
        public void TestInsufficientArrayLength()
        {
            char[] sentence = Helper.CreateArray("hello  world", 15);
            ReplaceBlank.Process(sentence);

            CollectionAssert.AreEqual(Helper.CreateArray("hello  world", 15), sentence);
        }
    }
}
