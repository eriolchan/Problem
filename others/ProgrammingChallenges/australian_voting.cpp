// Programming challenges - 110108 - Australian Voting

#include<iostream>
#include<sstream>
#include<string>

using namespace std;

void process(string candidates[], int candidatesNum, int votes[][20], int votesNum)
{
  int counts[20] = {0};
  int positions[1000] = {0};

  for (int i = 0; i < votesNum; ++i)
  {
    ++counts[votes[i][0] - 1];
  }

  while (true)
  {
    for (int i = 0; i < votesNum; ++i)
    {
      bool change = false;
      while (counts[votes[i][positions[i]] - 1] == 0)
      {
        ++positions[i];
        change = true;
      }

      if (change)
      {
        ++counts[votes[i][positions[i]] - 1];
      }
    }

    int max = 0;
    int min = 1000;

    for (int i = 0; i < candidatesNum; ++i)
    {
      if (counts[i] == 0)
      {
        continue;
      }

      if (counts[i] > max)
      {
        max = counts[i];
      }

      if (counts[i] < min)
      {
        min = counts[i];
      }
    }

    if (max == min || max * 2 > votesNum)
    {
      for (int i = 0; i < candidatesNum; ++i)
      {
        if (counts[i] == max)
        {
          cout << candidates[i] << endl;
        }
      }

      return;
    }
    else
    {
      for (int i = 0; i < candidatesNum; ++i)
      {
        if (counts[i] == min)
        {
          counts[i] = 0;
        }
      }
    }
  }
}

int main()
{
  int cases;
  int number;
  string candidates[20];
  string line;
  int votes[1000][20];

  cin >> cases;
  cin.ignore();
  getline(cin, line);

  while (cases--)
  {
     cin >> number;
     cin.ignore();

     for (int i = 0; i < number; ++i)
     {
       getline(cin, line);
       candidates[i] = line;
     }

     int index = 0;
     while (getline(cin, line) && line.size())
     {
       istringstream buffer(line);

       for (int i = 0; i < number; ++i)
       {
         buffer >> votes[index][i];
       }

       ++index;
     }

     process(candidates, number, votes, index);

     if (cases)
     {
       cout << endl;
     }
  }

  return 0;
}
