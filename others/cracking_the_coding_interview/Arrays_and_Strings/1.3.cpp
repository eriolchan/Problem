// Problem 1.3
// Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
// NOTE: One or two additional variables are fine. An extra copy o fthe array is not.

#include<iostream>

using namespace std;

void removeDuplicate(char s[])
{
  int len = strlen(s);
  if (len < 2)
  {
    return;
  }

  int p = 0;
  for (int i = 0; i < len; ++i)
  {
    if (s[i] != '\0')
    {
      s[p++] = s[i];

      for (int j = i + 1; j < len; ++j)
      {
        if (s[j] == s[i])
        {
          s[j] = '\0';
        }
      }
    }
  }

  s[p] = '\0';
}

void removeDuplicate2(char s[])
{
  int len = strlen(s);
  if (len < 2)
  {
    return;
  }

  bool exists[256];
  memset(exists, 0, sizeof(exists));

  int p = 0;
  for (int i = 0; i < len; ++i)
  {
    int value = (int)s[i];

    if(!exists[value])
    {
      s[p++] = s[i];
      exists[value] = true;
    }
  }

  s[p] = '\0';
}

void test(char actual[], char expected[], int num)
{
  cout << "removeDuplicate" << num << " - actual: " << actual << " expected: " << expected << endl;
}

int main()
{
  char s[] = "";
  removeDuplicate(s);
  test(s, "", 1);

  char p[] = "";
  removeDuplicate2(p);
  test(p, "", 2);

  char s1[] = "a";
  removeDuplicate(s1);
  test(s1, "a", 1);

  char p1[] = "a";
  removeDuplicate2(p1);
  test(p1, "a", 2);

  char s2[] = "abcde";
  removeDuplicate(s2);
  test(s2, "abcde", 1);

  char p2[] = "abcde";
  removeDuplicate2(p2);
  test(p2, "abcde", 2);

  char s3[] = "aaaa";
  removeDuplicate(s3);
  test(s3, "a", 1);

  char p3[] = "aaaa";
  removeDuplicate2(p3);
  test(p3, "a", 2);

  char s4[] = "abababc";
  removeDuplicate(s4);
  test(s4, "abc", 1);

  char p4[] = "abababc";
  removeDuplicate2(p4);
  test(p4, "abc", 2);

  char s5[] = "aaabbb";
  removeDuplicate(s5);
  test(s5, "ab", 1);

  char p5[] = "aaabbb";
  removeDuplicate2(p5);
  test(p5, "ab", 2);

  return 0;
}


