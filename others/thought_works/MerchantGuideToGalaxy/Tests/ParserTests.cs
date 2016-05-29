namespace Tests
{
    using System;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using MerchantGuideToGalaxy.Models;
    using MerchantGuideToGalaxy.Parsers;

    [TestClass]
    public class ParserTests
    {
        [TestMethod]
        public void TestDefinitionParser()
        {
            const string line = "glob is I";
            Context context = new Context();

            Assert.IsFalse(new StatementParser().Parse(line, context));

            Assert.IsFalse(new QuestionParser().Parse(line, context));

            Assert.IsTrue(new DefinitionParser().Parse(line, context));
            Assert.AreEqual(1, context.RomanMapping.Count);
            Assert.AreEqual("I", context.RomanMapping["glob"].Symbol);
        }

        [TestMethod]
        public void TestStatementParser()
        {
            const string line = "glob glob Silver is 34 Credits";
            Context context = new Context();
            context.RomanMapping["glob"] = RomanPrimitive.Parse('I');

            Assert.IsFalse(new DefinitionParser().Parse(line, context));

            Assert.IsFalse(new QuestionParser().Parse(line, context));

            Assert.IsTrue(new StatementParser().Parse(line, context));
            Assert.AreEqual(1, context.ItemPrice.Count);
            Assert.AreEqual(17m, context.ItemPrice["Silver"]);
        }

        [TestMethod]
        public void TestQuestionParser()
        {
            const string line = "how much is pish tegj glob glob ?";
            Context context = new Context();

            Assert.IsFalse(new DefinitionParser().Parse(line, context));

            Assert.IsFalse(new StatementParser().Parse(line, context));

            Assert.IsTrue(new QuestionParser().Parse(line, context));
            Assert.AreEqual(1, context.Questions.Count);
            Assert.AreEqual(line.Replace("?", string.Empty), context.Questions[0]);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestDefinitionParser_InvalidRomanPrimitive()
        {
            const string line = "glob is A";
            Context context = new Context();

            new DefinitionParser().Parse(line, context);
        }

        [TestMethod]
        [ExpectedException(typeof(FormatException))]
        public void TestStatementParser_InvalidNumber()
        {
            const string line = "glob glob Silver is 3a Credits";
            Context context = new Context();
            context.RomanMapping["glob"] = RomanPrimitive.Parse('I');

            new StatementParser().Parse(line, context);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestStatementParser_RomanPrimitiveNotDefined()
        {
            const string line = "glob glob Silver is 34 Credits";
            Context context = new Context();

            new StatementParser().Parse(line, context);
        }
    }
}
