namespace Tests
{
    using System;
    using System.Collections.Generic;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using MerchantGuideToGalaxy.Models;
    using MerchantGuideToGalaxy.Solvers;

    [TestClass]
    public class SolverTests
    {
        [TestMethod]
        public void TestDefinitionSolver()
        {
            const string question = "how much is pish tegj glob glob ";
            string answer;
            Context context = new Context();
            context.RomanMapping = new Dictionary<string, RomanPrimitive>
            {
                {"glob", RomanPrimitive.Parse('I')},
                {"pish", RomanPrimitive.Parse('X')},
                {"tegj", RomanPrimitive.Parse('L')}
            };

            Assert.IsFalse(new StatementSolver().Solve(question, context, out answer));
            Assert.IsNull(answer);

            const string expected = "pish tegj glob glob is 42";
            Assert.IsTrue(new DefinitionSolver().Solve(question, context, out answer));
            Assert.AreEqual(expected, answer);
        }

        [TestMethod]
        public void TestStatementSolver()
        {
            const string question = "how many Credits is glob prok Silver ";
            string answer;
            Context context = new Context();
            context.RomanMapping = new Dictionary<string, RomanPrimitive>
            {
                {"glob", RomanPrimitive.Parse('I')},
                {"prok", RomanPrimitive.Parse('V')}
            };
            context.ItemPrice["Silver"] = 17m;

            Assert.IsFalse(new DefinitionSolver().Solve(question, context, out answer));
            Assert.IsNull(answer);

            const string expected = "glob prok Silver is 68 Credits";
            Assert.IsTrue(new StatementSolver().Solve(question, context, out answer));
            Assert.AreEqual(expected, answer);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestDefinitionSolver_InvalidRomanNumber()
        {
            const string question = "how much is pish tegj glob glob ";
            string answer;
            Context context = new Context();

            new DefinitionSolver().Solve(question, context, out answer);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestStatementSolver_InvalidRomanNumber()
        {
            const string question = "how many Credits is glob prok Silver ";
            string answer;
            Context context = new Context();
            context.ItemPrice["Silver"] = 17m;

            new StatementSolver().Solve(question, context, out answer);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestStatementSolver_ItemNotFound()
        {
            const string question = "how many Credits is glob prok Silver ";
            string answer;
            Context context = new Context();
            context.RomanMapping = new Dictionary<string, RomanPrimitive>
            {
                {"glob", RomanPrimitive.Parse('I')},
                {"prok", RomanPrimitive.Parse('V')}
            };

            new StatementSolver().Solve(question, context, out answer);
        }
    }
}
