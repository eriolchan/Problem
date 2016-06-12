// Programming challenges - 110107 - Check the Check

#include<iostream>
#include<string>

#define MAX 8

using namespace std;

char chess[MAX][MAX];

bool validate(int i)
{
  return i >= 0 && i < MAX;
}

bool verifyChess(int x, int y, int extra, char expected)
{
  return chess[x][y] == expected + extra;
}

bool checkByStep(int x, int y, int extra, int offsetX, int offsetY, char expected)
{
  int row = x + offsetX;
  int column = y + offsetY;

  while (validate(row) && validate(column))
  {
    if (verifyChess(row, column, extra, expected) ||
        verifyChess(row, column, extra, 'Q'))
    {
      return true;
    }

  	if (chess[row][column] != '.')
	  {
		  break;
	  }

    row += offsetX;
    column += offsetY;
  }

  return false;
}

bool checkP(int x, int y, int extra)
{
  int row = (extra == 0 ? 1 : -1) + x;

  return (validate(row) && validate(y - 1) && verifyChess(row, y - 1, extra, 'P')) ||
         (validate(row) && validate(y + 1) && verifyChess(row, y + 1, extra, 'P'));
}

bool checkR(int x, int y, int extra)
{
  return checkByStep(x, y, extra, -1, 0, 'R') ||
	       checkByStep(x, y, extra, 1, 0, 'R') ||
	       checkByStep(x, y, extra, 0, -1, 'R') ||
	       checkByStep(x, y, extra, 0, 1, 'R');
}

bool checkB(int x, int y, int extra)
{
  return checkByStep(x, y, extra, -1, -1, 'B') ||
         checkByStep(x, y, extra, -1, 1, 'B') ||
         checkByStep(x, y, extra, 1, -1, 'B') ||
         checkByStep(x, y, extra, 1, 1, 'B');
}

bool checkN(int x, int y, int offset)
{
  return (validate(x - 1) && validate(y - 2) && verifyChess(x - 1, y - 2, offset, 'N')) ||
         (validate(x - 2) && validate(y - 1) && verifyChess(x - 2, y - 1, offset, 'N'))||
         (validate(x - 2) && validate(y + 1) && verifyChess(x - 2, y + 1, offset, 'N')) ||
         (validate(x - 1) && validate(y + 2) && verifyChess(x - 1, y + 2, offset, 'N')) ||
         (validate(x + 1) && validate(y - 2) && verifyChess(x + 1, y - 2, offset, 'N')) ||
         (validate(x + 2) && validate(y - 1) && verifyChess(x + 2, y - 1, offset, 'N')) ||
         (validate(x + 2) && validate(y + 1) && verifyChess(x + 2, y + 1, offset, 'N')) ||
         (validate(x + 1) && validate(y + 2) && verifyChess(x + 1, y + 2, offset, 'N'));
}

bool check(int x, int y)
{
  int offset = chess[x][y] == 'k' ? 0 : 'a' - 'A';

  return checkP(x, y, offset) ||
         checkR(x, y, offset) ||
         checkB(x, y, offset) ||
         checkN(x, y, offset);
}

int main()
{
  int x1, y1, x2, y2;
  int count = 0;
  bool exit;
  string result;

  while (true)
  {
    exit = true;

    for (int i = 0; i < MAX; ++i)
    {
      for (int j = 0; j < MAX; ++j)
      {
        cin >> chess[i][j];

        if (exit && chess[i][j] != '.')
        {
          exit = false;
        }

        if (chess[i][j] == 'k')
        {
          x1 = i;
          y1 = j;
        }

        if (chess[i][j] == 'K')
        {
          x2 = i;
          y2 = j;
        }
      }
    }

    if (exit)
    {
      break;
    }

    if (check(x1, y1))
    {
      result = "black";
    }
    else if (check(x2, y2))
    {
      result = "white";
    }
    else
    {
      result = "no";
    }

    cout << "Game #" << ++count << ": " << result << " king is in check.\n";
  }
  
  return 0;
}
