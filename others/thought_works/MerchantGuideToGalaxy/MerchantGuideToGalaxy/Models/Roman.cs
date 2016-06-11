namespace MerchantGuideToGalaxy.Models
{
    using System;
    using System.Collections.Generic;
    using System.Text;

    public class Roman
    {
        public static int Parse(string line, Dictionary<string, RomanPrimitive> romanMapping)
        {
            string[] names = line.Split(new[] {Constants.Space}, StringSplitOptions.RemoveEmptyEntries);

            StringBuilder result = new StringBuilder();

            foreach (var name in names)
            {
                if (!romanMapping.ContainsKey(name))
                {
                    throw new ArgumentException(Constants.NotDefined, name);
                }

                result.Append(romanMapping[name].Symbol);
            }

            return Parse(result.ToString());
        }

        public static int Parse(string roman)
        {
            int result = 0;
            int count = 0;
            RomanPrimitive previous = null;

            for (int i = roman.Length - 1; i >= 0; --i)
            {
                RomanPrimitive current = RomanPrimitive.Parse(roman[i]);

                if (previous == null || current.Value > previous.Value)
                {
                    count = 1;
                    result += current.Value;
                }
                else if (current.Value < previous.Value)
                {
                    if (!current.AllowSubtract)
                    {
                        throw new ArgumentException(Constants.InvalidRomanNumber, roman);
                    }

                    if (!current.SubtractFrom.Contains(previous.Symbol))
                    {
                        throw new ArgumentException(Constants.InvalidRomanNumber, roman);
                    }

                    count = 1;
                    result -= current.Value;
                }
                else if (current.Value == previous.Value)
                {
                    if (!current.AllowRepeat)
                    {
                        throw new ArgumentException(Constants.InvalidRomanNumber, roman);
                    }

                    ++count;
                    if (count > 3)
                    {
                        throw new ArgumentException(Constants.InvalidRomanNumber, roman);
                    }

                    result += current.Value;
                }

                previous = current;
            }

            return result;
        }
    }
}
