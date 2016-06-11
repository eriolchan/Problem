namespace Tests
{
    using System;
    using System.Collections.Generic;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using MerchantGuideToGalaxy.Models;

    [TestClass]
    public class RomanTests
    {
        [TestMethod]
        public void TestRomanPrimitive()
        {
            RomanPrimitive primitive = RomanPrimitive.Parse('I');

            Assert.IsNotNull(primitive);
            Assert.AreEqual("I", primitive.Symbol);
            Assert.AreEqual(1, primitive.Value);
            Assert.IsTrue(primitive.AllowRepeat);
            Assert.IsTrue(primitive.AllowSubtract);
            Assert.AreEqual("VX", primitive.SubtractFrom);
        }

        [TestMethod]
        public void TestRomanPrimitive_NotFound()
        {
            RomanPrimitive primitive = RomanPrimitive.Parse('A');

            Assert.IsNull(primitive);
        }

        [TestMethod]
        public void TestRoman()
        {
            const string line = "pish tegj glob glob";
            Dictionary<string, RomanPrimitive> romanMapping = new Dictionary<string, RomanPrimitive>
            {
                {"glob", RomanPrimitive.Parse('I')},
                {"pish", RomanPrimitive.Parse('X')},
                {"tegj", RomanPrimitive.Parse('L')}
            };

            Assert.AreEqual(42, Roman.Parse(line, romanMapping));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestRoman_NotDefined()
        {
            const string line = "pish tegj glob glob";
            Dictionary<string, RomanPrimitive> romanMapping = new Dictionary<string, RomanPrimitive>
            {
                {"pish", RomanPrimitive.Parse('X')},
                {"tegj", RomanPrimitive.Parse('L')}
            };

            Roman.Parse(line, romanMapping);
        }

        [TestMethod]
        public void TestRoman_OnePrimitive()
        {
            Assert.AreEqual(10, Roman.Parse("X"));
        }

        [TestMethod]
        public void TestRoman_CanRepeat()
        {
            Assert.AreEqual(2, Roman.Parse("II"));
            Assert.AreEqual(300, Roman.Parse("CCC"));
            Assert.AreEqual(39, Roman.Parse("XXXIX"));
            Assert.AreEqual(2000, Roman.Parse("MM"));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestRoman_ExceedMaxRepeatCount()
        {
            Roman.Parse("IIII");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestRoman_CannotRepeat()
        {
            Roman.Parse("VV");
        }

        [TestMethod]
        public void TestRoman_CanSubtract()
        {
            Assert.AreEqual(444, Roman.Parse("CDXLIV"));
            Assert.AreEqual(999, Roman.Parse("CMXCIX"));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestRoman_CannotSubtract()
        {
            Roman.Parse("VX");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestRoman_InvalidSubtractFrom()
        {
            Roman.Parse("IL");
        }
    }
}
