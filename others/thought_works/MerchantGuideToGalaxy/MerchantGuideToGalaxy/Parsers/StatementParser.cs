namespace MerchantGuideToGalaxy.Parsers
{
    using System;
    using System.Linq;
    using MerchantGuideToGalaxy.Models;

    public class StatementParser : IParser
    {
        // Format: [Quantity] [Item] is [Amount] Credits
        public bool Parse(string line, Context context)
        {
            if (line.EndsWith(Constants.QuestionMark))
            {
                return false;
            }

            string[] fields = line.Split(new[] {Constants.ParserDelimiter}, StringSplitOptions.RemoveEmptyEntries);
            if (fields.Length != 2)
            {
                return false;
            }

            string[] left = fields[0].Split(new[] {Constants.Space}, StringSplitOptions.RemoveEmptyEntries);
            if (left.Length < 2)
            {
                return false;
            }

            string[] right = fields[1].Split(new[] {Constants.Space}, StringSplitOptions.RemoveEmptyEntries);
            if (right.Length != 2)
            {
                return false;
            }

            string item = left.Last();
            int quantity = Roman.Parse(string.Join(Constants.Space, left.Take(left.Length - 1)), context.RomanMapping);
            int amount = int.Parse(right[0]);
            decimal price = ((decimal) amount)/quantity;

            context.ItemPrice[item] = price;

            return true;
        }
    }
}
