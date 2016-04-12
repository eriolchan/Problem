// Problem 1.6
// Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes,
// write a method to rotate the image by 90 degrees.
// Can you do this in place?

#include<iostream>

using namespace std;

void swap(int &a, int &b)
{
  a = a ^ b;
  b = a ^ b;
  a = a ^ b;
}

void rotate(int **matrix, int n)
{
  for (int i = 0; i < n; ++i)
  {
    for (int j = i + 1; j < n; ++j)
    {
      swap(*((int *)matrix + n * i + j),
           *((int *)matrix + n * j + i));
    }
  }

  for (int i = 0; i < n / 2; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      swap(*((int *)matrix + n * i + j),
           *((int *)matrix + n * (n - 1 - i) + j));
    }
  }
}

void print(int **matrix, int n)
{
  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      cout << *((int *)matrix + n * i + j) << ' ';
    }

    cout << endl;
  }
}

void test(int ** matrix, int n)
{
  cout << "Original matrix:" << endl;
  print((int **)matrix, n);

  rotate((int **)matrix, n);

  cout << "\nAfter rotate:" << endl;
  print((int **)matrix, n);
}

int main()
{
  int matrix[4][4] = {
     1,  2,  3,  4,
     5,  6,  7,  8, 
     9, 10, 11, 12,
    13, 14, 15, 16
  };

  test((int **)matrix, 4);

  return 0;
}
