// Programming challenges - 110105 - Graphical Editor

#include<iostream>
#include<string>
#include<sstream>

using namespace std;

char image[251][251];
bool visit[251][251];
int row;
int column;

void clear()
{
  for (int i = 1; i <= row; ++i)
  {
    for (int j = 1; j <= column; ++j)
    {
      image[i][j] = 'O';
    }
  }
}

void print()
{
  for (int i = 1; i <= row; ++i)
  {
    for (int j = 1; j <= column; ++j)
    {
      cout << image[i][j];
    }

    cout << endl;
  }
}

void sort(int &a, int &b)
{
  if (a > b)
  {
    int temp = a;
    a = b;
    b = temp;
  }
}

void flood(int x, int y, char origin, char color)
{
  if (x < 1 || y < 1 || x > column || y > row ||
      visit[y][x] || image[y][x] != origin)
  {
    return;
  }

  image[y][x] = color;
  visit[y][x] = true;

  flood(x - 1, y, origin, color);
  flood(x + 1, y, origin, color);
  flood(x, y - 1, origin, color);
  flood(x, y + 1, origin, color);
}

void fill(int x, int y, char color)
{
  char origin = image[y][x];

  for (int i = 1; i <= row; ++i)
  {
    for (int j = 1; j <= column; ++j)
    {
      visit[i][j] = false;
    }
  }

  flood(x, y, origin, color);
}

int main()
{
  string line;
  char command;
  char color;
  int x1, y1, x2, y2;
  string name;

  while (getline(cin, line) && line[0] != 'X')
  {
    istringstream buffer(line);

    buffer >> command;
    switch (command)
    {
      case 'I':
        buffer >> column >> row;
        clear();
        break;
      case 'C':
        clear();
        break;
      case 'L':
        buffer >> x1 >> y1 >> color;
        image[y1][x1] = color;
        break;
      case 'V':
        buffer >> x1 >> y1 >> y2 >> color;
        sort(y1, y2);
        for (int i = y1; i <= y2; ++i)
        {
          image[i][x1] = color;
        }
        break;
      case 'H':
        buffer >> x1 >> x2 >> y1 >> color;
        sort(x1, x2);
        for (int i = x1; i <= x2; ++i)
        {
          image[y1][i] = color;
        }
        break;
      case 'K':
        buffer >> x1 >> y1 >> x2 >> y2 >> color;
        for (int i = y1; i <= y2; ++i)
        {
          for (int j = x1; j <= x2; ++j)
          {
            image[i][j] = color;
          }
        }
        break;
      case 'F':
        buffer >> x1 >> y1 >> color;
        fill(x1, y1, color);
        break;
      case 'S':
        buffer >> name;
        cout << name << endl;
        print();
    }
  }

  return 0;
}
