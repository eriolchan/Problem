// Problem 1.2
// Write code to reverse a C-Style String.
// (C-String means that "abcd" is presented as five characters, including the null character.)

#include<iostream>

using namespace std;

void swap(char &a, char &b)
{
  a = a ^ b;
  b = a ^ b;
  a = a ^ b;
}

void reverse(char *s)
{
  if (!s)
  {
    return;
  }

  char *p = s, *q = s;
  while (*q)
  {
    ++q;
  }
  --q;

  while (p < q)
  {
    swap(*p++, *q--);
  }
}

void test(char *actual, char *expected)
{
  cout << "actual: " << actual << " expected: " << expected << endl;
}

int main()
{
  char *s = NULL;
  reverse(s);
  cout << "actual: " << (s ? s : "NULL") << " expected: NULL" << endl;

  char str[] = "0123456789";
  reverse(str);
  test(str, "9876543210");

  return 0;
}
