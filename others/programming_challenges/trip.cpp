/* Programming challenges - 110103 - The Trip */

#include<iostream>
#include<iomanip>

using namespace std;

int main()
{
  int count;
  double money[1000];

  while (cin >> count)
  {
    if (count == 0)
    {
      break;
    }
    
    double sum = 0;
    for (int i = 0; i < count; ++i)
    {
      cin >> money[i];
      sum += money[i];
    }

    double average = sum / count;

    double positiveExchange = 0;
    double negativeExchange = 0;
    for (int i = 0; i < count; ++i)
    {
      double difference = double (int ((money[i] - average) * 100.0) / 100.0);
      if (difference > 0)
      {
        positiveExchange += difference;
      }
      else
      {
        negativeExchange += -difference;
      }
    }
    
    double exchange = positiveExchange > negativeExchange ? positiveExchange : negativeExchange;

    cout << '$' << fixed << setprecision(2) << exchange << endl;
  }

  return 0;
}
