// Problem 1.8
// Assume you have a method isSubstring which checks if one word is a substring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
// (i.e., "waterbottle" is a rotation of "erbottlewat").

#include<iostream>
#include<string>

using namespace std;

bool isSubstring(string s1, string s2)
{
  return s1.find(s2) != string::npos;
}

bool isRotation(string s1, string s2)
{
  int len1 = s1.length();
  int len2 = s2.length();

  if (len1 != len2 || len1 == 0 || len2 == 0)
  {
    return false;
  }

  return isSubstring(s1 + s1, s2);
}

void test(bool actual, bool expected)
{
  cout << "actual: " << actual << " expected: " << expected << endl;
}

int main()
{
  string s1 = "waterbottle";
  string s2 = "erbottlewat";
  test(isRotation(s1, s2), true);

  s1 = "";
  test(isRotation(s1, s2), false);

  s1 = "waterbottle";
  s2 = "erbottlewar";
  test(isRotation(s1, s2), false);

  s1 = "ab";
  s2 = "bab";
  test(isRotation(s1, s2), false);
}
