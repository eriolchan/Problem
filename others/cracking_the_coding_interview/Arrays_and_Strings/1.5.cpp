// Problem 1.5
// Write a method to replace all spaces in a string with '%20'

#include<iostream>

using namespace std;

void replace(char *s)
{
  if (!s)
  {
    return;
  }

  int len = strlen(s);
  int counter = 0;

  for (int i = 0; i < len; ++i)
  {
    if (s[i] == ' ')
    {
      ++counter;
    }
  }

  char *p = s + len;
  char *q = s + len + 2 * counter;
  while (p < q)
  {
    if (*p == ' ')
    {
      *q-- = '0';
      *q-- = '2';
      *q-- = '%';
      --p;
    }
    else
    {
      *q-- = *p--;
    }
  }
}

void test(char *actual, char *expected)
{
  cout << "actual: " << actual << " expected: " << expected << endl;
}

int main()
{
  char *s = NULL;
  replace(s);
  cout << "actual: " << (s ? s: "NULL") << " expected: NULL" << endl;

  char s1[] = "";
  replace(s1);
  test(s1, "");

  char s2[] = "abc";
  replace(s2);
  test(s2, "abc");

  char s3[] = " abc";
  replace(s3);
  test(s3, "%20abc");

  char s4[] = "abc ";
  replace(s4);
  test(s4, "abc%20");

  char s5[] = "a bc";
  replace(s5);
  test(s5, "a%20bc");

  char s6[] = "a b  c";
  replace(s6);
  test(s6, "a%20b%20%20c");

  char s7[] = " ";
  replace(s7);
  test(s7, "%20");

  return 0;
}
