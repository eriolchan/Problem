namespace MerchantGuideToGalaxy.Solvers
{
    using MerchantGuideToGalaxy.Models;

    interface ISolver
    {
        bool Solve(string line, Context context, out string answer);
    }
}
