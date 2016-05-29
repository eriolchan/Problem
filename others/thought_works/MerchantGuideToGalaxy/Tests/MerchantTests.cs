namespace Tests
{
    using System;
    using System.Collections.Generic;
    using MerchantGuideToGalaxy;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class MerchantTests
    {
        [TestMethod]
        public void TestCanSolveQuestion()
        {
            List<string> input = new List<string>
            {
                "glob is I",
                "prok is V",
                "pish is X",
                "tegj is L",
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits",
                "how much is pish tegj glob glob ?",
                "how many Credits is glob prok Silver ?",
                "how many Credits is glob prok Gold ?",
                "how many Credits is glob prok Iron ?",
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
            };

            string output = Merchant.Process(input);

            string expected = string.Join(Environment.NewLine, new List<string>
            {
                "pish tegj glob glob is 42",
                "glob prok Silver is 68 Credits",
                "glob prok Gold is 57800 Credits",
                "glob prok Iron is 782 Credits",
                "I have no idea what you are talking about"
            });

            Assert.AreEqual(expected + Environment.NewLine, output);
        }

        [TestMethod]
        public void TestCannotSolveQuestion()
        {
            List<string> input = new List<string>
            {
                "glob is I",
                "prok is A", // invalid Roman primitive
                "pish is X",
                "tegj is L",
                "glob glob Silver is 34 Credits",
                "how much is pish tegj glob glob ?",
                "how many Credits is glob prok Silver ?"
            };

            string output = Merchant.Process(input);

            string expected = string.Join(Environment.NewLine, new List<string>
            {
                "pish tegj glob glob is 42",
                "I have no idea what you are talking about"
            });

            Assert.AreEqual(expected + Environment.NewLine, output);
        }
    }
}
