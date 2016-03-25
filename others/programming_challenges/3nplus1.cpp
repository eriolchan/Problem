// Programming challenges - 110101 - The 3n+1 problem

#include<iostream>

using namespace std;

int getMaxLength(int start, int end)
{
  if (start > end)
  {
    int temp = start;
    start = end;
    end = temp;
  }

  int max = 0;
  for (int i = start; i <= end; ++i)
  {
    int count = 1;
    int current = i;
    while (current != 1)
    {
      ++count;
      
      if (current % 2 == 0)
      {
        current >>= 1;
      }
      else
      {
        current = 3 * current + 1;
      }
    }

    if (count > max)
    {
      max = count;
    }

  }

  return max;
}

int main()
{
  int a, b;

  while (cin >> a >> b)
  {
    cout << a << ' ' << b << ' ' << getMaxLength(a, b) << endl;
  }

  return 0;
}
