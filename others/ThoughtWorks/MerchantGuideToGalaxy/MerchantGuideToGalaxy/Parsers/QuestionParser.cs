namespace MerchantGuideToGalaxy.Parsers
{
    using MerchantGuideToGalaxy.Models;

    public class QuestionParser : IParser
    {
        // Format: [Question] ?
        public bool Parse(string line, Context context)
        {
            if (!line.EndsWith(Constants.QuestionMark))
            {
                return false;
            }

            context.Questions.Add(line.Replace(Constants.QuestionMark, string.Empty));

            return true;
        }
    }
}
