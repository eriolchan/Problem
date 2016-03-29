// Programming challenges - 110106 - Interpreter

#include<iostream>
#include<string>

using namespace std;

int getNumber(string s)
{
  return 100 * (s[0] - '0') + 10 * (s[1] - '0') + s[2] - '0';
}

int process(int *reg, int *mem)
{
  int index = 0;
  int count = 0;
  bool halt = false;

  while (!halt)
  {
    int command = mem[index];
    int a = command / 100;
    int b = (command / 10) % 10;
    int c = command % 10;

    switch (a)
    {
      case 1:
        halt = true;
        break;
      case 2:
        reg[b] = c;
        break;
      case 3:
        reg[b] += c;
        break;
      case 4:
        reg[b] *= c;
        break;
      case 5:
        reg[b] = reg[c];
        break;
      case 6:
        reg[b] += reg[c];
        break;
      case 7:
        reg[b] *= reg[c];
        break;
      case 8:
        reg[b] = mem[reg[c]];
        break;
      case 9:
        mem[reg[c]] = reg[b];
        break;
      case 0:
        if (reg[c])
        {
          index = reg[b] - 1;
        }
        break;
    }

    reg[b] %= 1000;
    ++index;
    ++count;
  }
  
  return count;
}

int main()
{
  int reg[10];
  int mem[1000];
  int cases;
  string line;

  cin >> cases;
  cin.ignore();
  getline(cin, line);

  while (cases--)
  {
    for (int i = 0; i < 1000; ++i)
    {
      mem[i] = 0;
    }

    for (int i = 0; i < 10; ++i)
    {
      reg[i] = 0;
    }

    for (int i = 0; getline(cin, line) && line.size(); ++i)
    {
      mem[i] = getNumber(line);
    }

    cout << process(reg, mem) << endl;

    if (cases)
    {
      cout << endl;
    }
  }

  return 0;
}
