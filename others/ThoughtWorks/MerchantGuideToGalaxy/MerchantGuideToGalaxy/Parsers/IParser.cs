namespace MerchantGuideToGalaxy.Parsers
{
    using MerchantGuideToGalaxy.Models;

    interface IParser
    {
        bool Parse(string line, Context context);
    }
}
