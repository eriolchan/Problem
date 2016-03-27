// Programming challenges - 110102 - Minesweeper

#include<iostream>

using namespace std;

void process(int field[][102], int row, int column)
{
  for (int i = row - 1; i <= row + 1; ++i)
  {
    for (int j = column - 1; j <= column + 1; ++j)
    {
      if (field[i][j] != -1)
      {
        ++field[i][j];
      }
    }
  }
}

int main()
{
  int m, n;
  int counter = 0;
  char c;

  while (cin >> m >> n)
  {
    if (m == 0 && n == 0)
    {
      break;
    }

    int field[102][102] = {0};
    for (int i = 1; i < m+1; ++i)
    {
      for (int j = 1; j < n+1; ++j)
      {
        cin >> c;
        if (c == '*')
        {
          field[i][j] = -1;
          process(field, i, j);
        }
      }
    }

    ++counter;
    if (counter > 1)
    {
      cout << endl;
    }

    cout << "Field #" << counter << ":\n";
    for (int i = 1; i < m + 1; ++i)
    {
      for (int j = 1; j < n + 1; ++j)
      {
        if (field[i][j] == -1)
        {
          cout << '*';
        }
        else
        {
          cout << field[i][j];
        }
      }

      cout << endl;
    }

  }

  return 0;
}
