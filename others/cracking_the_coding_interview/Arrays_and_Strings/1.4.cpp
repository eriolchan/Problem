// Problem 1.4
// Write a method to decide if two strings are anagrams or not.

#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

bool isAnagram(string s, string t)
{
  int sLen = s.length();
  int tLen = t.length();

  if (s == "" || t == "" || sLen != tLen)
  {
    return false;
  }

  sort(&s[0], &s[0] + sLen);
  sort(&t[0], &t[0] + tLen);

  return s == t;
}

bool isAnagram2(string s, string t)
{
  int sLen = s.length();
  int tLen = t.length();

  if (s == "" || t == "" || sLen != tLen)
  {
    return false;
  }

  int counter[256];
  memset(counter, 0, sizeof(counter));

  for (int i = 0; i < sLen;++i)
  {
    ++counter[(int)s[i]];
    --counter[(int)t[i]];
  }

  for (int i = 0; i < 256; ++i)
  {
    if (counter[i] != 0)
    {
      return false;
    }
  }

  return true;
}

void test(bool actual, bool expected, int version)
{
  cout << "isAnagram" << version << " - actual: " << actual << " expected: " << expected << endl;
}

int main()
{
  string s = "";
  string t = "a";
  test(isAnagram(s, t), false, 1);
  test(isAnagram2(s, t), false, 2);

  s = "a";
  t = "";
  test(isAnagram(s, t), false, 1);
  test(isAnagram2(s, t), false, 2);

  s = "";
  t = "";
  test(isAnagram(s, t), false, 1);
  test(isAnagram2(s, t), false, 2);

  s = "a";
  t = "a";
  test(isAnagram(s, t), true, 1);
  test(isAnagram2(s, t), true, 2);

  s = "a";
  t = "b";
  test(isAnagram(s, t), false, 1);
  test(isAnagram2(s, t), false, 2);

  s = "a";
  t = "ba";
  test(isAnagram(s, t), false, 1);
  test(isAnagram2(s, t), false, 2);

  s = "abcd";
  t = "badc";
  test(isAnagram(s, t), true, 1);
  test(isAnagram2(s, t), true, 2);

  s = "abcd";
  t = "eadc";
  test(isAnagram(s, t), false, 1);
  test(isAnagram2(s, t), false, 2);

  s = "aaabbb";
  t = "ababab";
  test(isAnagram(s, t), true, 1);
  test(isAnagram2(s, t), true, 2);

  return 0;
}
