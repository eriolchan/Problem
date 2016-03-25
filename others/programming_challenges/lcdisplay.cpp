// Programming challenges - 110104 - LC-Display

#include<iostream>
#include<iomanip>
#include<string>

using namespace std;

int main()
{
  int s;
  string number;

  /* LED representation
   *
   *  -0-
   * |   |
   * 2   1
   * |   |
   *  -3-
   * |   |
   * 5   4
   * |   |
   *  -6-
   *
   */

  char model[10][7] = {
    '-', '|', '|', ' ', '|', '|', '-',
    ' ', '|', ' ', ' ', '|', ' ', ' ',
    '-', '|', ' ', '-', ' ', '|', '-',
    '-', '|', ' ', '-', '|', ' ', '-',
    ' ', '|', '|', '-', '|', ' ', ' ',
    '-', ' ', '|', '-', '|', ' ', '-',
    '-', ' ', '|', '-', '|', '|', '-',
    '-', '|', ' ', ' ', '|', ' ', ' ',
    '-', '|', '|', '-', '|', '|', '-',
    '-', '|', '|', '-', '|', ' ', '-'
  };


  while (cin >> s >> number)
  {
    if (s == 0)
    {
      break;
    }

    int n = number.length();
    for (int i = 0; i < 2 * s + 3; ++i)
    {
      for (int j = 0; j < n; ++j)
      {
        int digit = number[j] - '0';
        
        if (i % (s + 1) == 0)
        {
          cout << ' ';

          for (int k = 0; k < s; ++k)
          {
            cout << model[digit][i / (s + 1) * 3];
          }

          cout << ' ';

        }
        else if (i > 0 && i < s + 1)
        {
          cout << model[digit][2];

          for (int k = 0; k < s; ++k)
          {
            cout << ' ';
          }

          cout << model[digit][1];
        }
        else if (i > s + 1 && i < 2 * (s + 1))
        {
          cout << model[digit][5];

          for (int k = 0; k < s; ++k)
          {
            cout << ' ';
          }

          cout << model[digit][4];
        }

        if (j != n - 1)
        {
          cout << ' ';
        }
      }

      cout << endl;
    }

    cout << endl;
  }

  return 0;
}
