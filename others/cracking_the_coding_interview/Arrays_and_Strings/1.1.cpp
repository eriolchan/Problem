// Problem 1.1
// Implement an algorithm to determine if a string has all unique characters.
// What if you can not use additional data structues?

#include<iostream>
#include<string>

using namespace std;

bool isUnique(string s)
{
  bool exists[256];
  memset(exists, 0, sizeof(exists));

  for (int i = 0; i < s.length(); ++i)
  {
    int value = (int)s[i];

    if (exists[value])
    {
      return false;
    }

    exists[value] = true;
  }

  return true;
}

bool isUnique2(string s)
{
  int exists[8];
  memset(exists, 0, sizeof(exists));

  for (int i = 0; i < s.length(); ++i)
  {
    int value = (int)s[i];
    int index = value / 32;
    int shift = value % 32;

    if (exists[index] & (1 << shift))
    {
      return false;
    }

    exists[index] |= (1 << shift);
  }

  return true;
}

void test(bool actual, bool expected, int num)
{
  cout << "isUnique" << num << " - actual: " << actual << " expected: " << expected << endl;
}

int main()
{
  string s = "a";
  test(isUnique(s), true, 1);
  test(isUnique2(s), true, 2);

  s = "abcd";
  test(isUnique(s), true, 1);
  test(isUnique2(s), true, 2);

  s = "aaaa";
  test(isUnique(s), false, 1);
  test(isUnique2(s), false, 2);

  s = "ababab";
  test(isUnique(s), false, 1);
  test(isUnique2(s), false, 2);

  s = "aaabbb";
  test(isUnique(s), false, 1);
  test(isUnique2(s), false, 2);

  return 0;
}
