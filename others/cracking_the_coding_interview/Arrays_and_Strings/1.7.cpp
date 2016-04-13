// Problem 1.7
// Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column is set to 0.

#include<iostream>

using namespace std;

void zero(int **matrix, int m, int n)
{
  if (!matrix)
  {
    return;
  }

  bool *row = new bool[m];
  bool *column = new bool[n];

  memset(row, 0, m * sizeof(bool));
  memset(column, 0, n * sizeof(bool));

  for (int i = 0; i < m; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (*((int *)matrix + n * i + j) == 0)
      {
        row[i] = true;
        column[j] = true;
      }
    }
  }

  for (int i = 0; i < m; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (row[i] || column[j])
      {
        *((int *)matrix + n * i + j) = 0;
      }
    }
  }

  delete []row;
  delete []column;
}

void print(int **matrix, int m, int n)
{
  if (!matrix)
  {
    return;
  }

  for (int i = 0; i < m; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      cout << (*((int *)matrix + n * i + j)) << ' ';
    }
    
    cout << endl;
  }
}

void test(int **matrix, int m, int n)
{
  cout << "Original matrix:" << endl;
  print(matrix, m, n);

  zero(matrix, m, n);

  cout << "\nAfter zero:" << endl;
  print(matrix, m, n);

  cout << endl;
}

int main()
{
  int matrix[3][4] = {
    1, 2, 3, 4,
    5, 0, 7, 8,
    9, 10, 11, 0
  };

  test((int **)matrix, 3, 4);
  test(NULL, 3, 4);

  return 0;
}
