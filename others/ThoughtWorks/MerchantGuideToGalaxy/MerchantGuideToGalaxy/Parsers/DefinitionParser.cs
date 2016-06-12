namespace MerchantGuideToGalaxy.Parsers
{
    using System;
    using MerchantGuideToGalaxy.Models;

    public class DefinitionParser : IParser
    {
        // Format: [Name] is [Primitive]
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

            string right = fields[1].Trim();
            if (right.Length != 1)
            {
                return false;
            }

            string[] left = fields[0].Split(new[] {Constants.Space}, StringSplitOptions.RemoveEmptyEntries);
            if (left.Length != 1)
            {
                return false;
            }

            RomanPrimitive primitive = RomanPrimitive.Parse(right[0]);
            if (primitive == null)
            {
                throw new ArgumentException(Constants.InvalidRomanPrimitive, right);
            }

            context.RomanMapping[left[0]] = primitive;

            return true;
        }
    }
}
