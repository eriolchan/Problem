namespace MerchantGuideToGalaxy.Solvers
{
    using System;
    using System.Linq;
    using MerchantGuideToGalaxy.Models;

    public class StatementSolver : ISolver
    {
        // Format: how many Credits is [Quantity] [Item]
        public bool Solve(string line, Context context, out string answer)
        {
            if (!line.StartsWith(Constants.StatementQuestion))
            {
                answer = null;
                return false;
            }

            string question = line.Substring(Constants.StatementQuestion.Length);
            string[] right = question.Split(new[] {Constants.Space}, StringSplitOptions.RemoveEmptyEntries);

            string item = right.Last();
            int quantity = Roman.Parse(string.Join(Constants.Space, right.Take(right.Length - 1)), context.RomanMapping);

            if (!context.ItemPrice.ContainsKey(item))
            {
                throw new ArgumentException(Constants.ItemNotFound, item);
            }

            decimal amount = quantity*context.ItemPrice[item];
            answer = string.Format("{0}is {1} Credits", question, decimal.ToInt32(amount));

            return true;
        }
    }
}
