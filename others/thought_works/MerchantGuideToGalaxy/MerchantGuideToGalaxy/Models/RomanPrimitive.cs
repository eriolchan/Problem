namespace MerchantGuideToGalaxy.Models
{
    using System.Collections.Generic;

    public class RomanPrimitive
    {
        private static readonly Dictionary<char, RomanPrimitive> RomanDictionary = new Dictionary<char, RomanPrimitive>()
        {
            { 'I', new RomanPrimitive("I", 1, true, true, "VX") },
            { 'V', new RomanPrimitive("V", 5) },
            { 'X', new RomanPrimitive("X", 10, true, true, "LC") },
            { 'L', new RomanPrimitive("L", 50) },
            { 'C', new RomanPrimitive("C", 100, true, true, "DM") },
            { 'D', new RomanPrimitive("D", 500) },
            { 'M', new RomanPrimitive("M", 1000, true) }
        };

        public string Symbol { get; set; }
        public int Value { get; set; }
        public bool AllowRepeat { get; set; }
        public bool AllowSubtract { get; set; }
        public string SubtractFrom { get; set; }

        private RomanPrimitive(string symbol, int value, bool allowRepeat = false, bool allowSubtract = false, string subtractFrom = null)
        {
            this.Symbol = symbol;
            this.Value = value;
            this.AllowRepeat = allowRepeat;
            this.AllowSubtract = allowSubtract;
            this.SubtractFrom = subtractFrom;
        }

        public static RomanPrimitive Parse(char symbol)
        {
            return RomanDictionary.ContainsKey(symbol) ? RomanDictionary[symbol] : null;
        }
    }
}
