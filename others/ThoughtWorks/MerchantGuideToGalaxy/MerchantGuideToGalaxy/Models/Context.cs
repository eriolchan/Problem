namespace MerchantGuideToGalaxy.Models
{
    using System.Collections.Generic;

    public class Context
    {
        public Context()
        {
            this.RomanMapping = new Dictionary<string, RomanPrimitive>();
            this.ItemPrice = new Dictionary<string, decimal>();
            this.Questions = new List<string>();
        }

        public Dictionary<string, RomanPrimitive> RomanMapping { get; set; }
        public Dictionary<string, decimal> ItemPrice { get; set; }
        public List<string> Questions { get; set; }
    }
}
