namespace MerchantGuideToGalaxy.Solvers
{
    using MerchantGuideToGalaxy.Models;

    public class DefinitionSolver : ISolver
    {
        // Format: how much is [Quantity]
        public bool Solve(string line, Context context, out string answer)
        {
            if (!line.StartsWith(Constants.DefinitionQuestion))
            {
                answer = null;
                return false;
            }

            string right = line.Substring(Constants.DefinitionQuestion.Length);
            int quantity = Roman.Parse(right, context.RomanMapping);
            answer = string.Format("{0}is {1}", right, quantity);

            return true;
        }
    }
}
