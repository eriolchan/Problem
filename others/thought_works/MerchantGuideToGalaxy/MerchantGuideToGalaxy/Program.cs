namespace MerchantGuideToGalaxy
{
    using System.IO;
    using MerchantGuideToGalaxy.Models;

    class Program
    {
        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines(Constants.InputFile);

            string result = Merchant.Process(lines);

            File.WriteAllText(Constants.OutputFile, result);
        }
    }
}
