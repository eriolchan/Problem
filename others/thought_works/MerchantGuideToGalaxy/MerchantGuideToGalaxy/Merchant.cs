namespace MerchantGuideToGalaxy
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using MerchantGuideToGalaxy.Models;
    using MerchantGuideToGalaxy.Parsers;
    using MerchantGuideToGalaxy.Solvers;

    public class Merchant
    {
        public static string Process(IEnumerable<string> lines)
        {
            IParser[] parsers =
            {
                new DefinitionParser(),
                new StatementParser(),
                new QuestionParser()
            };

            ISolver[] solvers =
            {
                new DefinitionSolver(),
                new StatementSolver()
            };

            Context context = new Context();

            ParseConversation(lines, parsers, context);
            return SolveQuestion(solvers, context);
        }

        private static void ParseConversation(IEnumerable<string> lines, IParser[] parsers, Context context)
        {
            lines.ToList().ForEach(line =>
            {
                foreach (var parser in parsers)
                {
                    bool parsed = false;

                    try
                    {
                        parsed = parser.Parse(line, context);
                    }
                    catch (Exception e)
                    {
                        Console.Error.WriteLine(e.Message);
                    }

                    if (parsed)
                    {
                        break;
                    }
                }
            });
        }

        private static string SolveQuestion(ISolver[] solvers, Context context)
        {
            StringBuilder output = new StringBuilder();

            context.Questions.ForEach(question =>
            {
                bool solved = false;
                string answer = null;

                foreach (var solver in solvers)
                {
                    try
                    {
                        solved = solver.Solve(question, context, out answer);
                    }
                    catch (Exception e)
                    {
                        Console.Error.WriteLine(e.Message);
                    }

                    if (solved)
                    {
                        break;
                    }
                }

                output.AppendLine(solved ? answer : Constants.NotKnow);
            });

            return output.ToString();
        }
    }
}
