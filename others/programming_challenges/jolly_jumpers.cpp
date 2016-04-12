// Programming challenges - 110201 - Jolly Jumpers

#include<iostream>
#include<stdlib.h>

using namespace std;

void process(int *array, int number)
{
  bool exist[3000] = {0};
  bool result = true;

  for (int i = 1; i < number; ++i)
  {
    int diff = abs(array[i] - array[i - 1]);
    if (diff < 1 || diff > number - 1 || exist[diff])
    {
      result = false;
      break;
    }
    else
    {
      exist[diff] = true;
    }
  }

  cout << (result ? "Jolly" : "Not jolly") << endl;
}

int main()
{
  int array[3000];
  int number;

  while (cin >> number)
  {
    for (int i = 0; i < number; ++i)
    {
      cin >> array[i];
    }

    process(array, number);
  }

  return 0;
}
