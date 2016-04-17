// Problem 2.1
// Write code to remove duplicates from an unsorted linked list.
// How would you solve this problem if a temporary buffer is not allowed?

#include<iostream>
#include<sstream>
#include<string>
#include<unordered_set>

using namespace std;

struct node
{
  int data;
  node *next;
};

node* init(int values[], int num)
{
  node *head, *previous;

  for (int i = 0; i < num; ++i)
  {
    node *current = new node();
    current->data = values[i];

    if (i == 0)
    {
      head = previous = current;
      continue;
    }

    previous->next = current;
    previous = current;
  }

  return head;
}

void removeDuplicate(node *head)
{
  if (!head)
  {
    return;
  }

  node *current = head;
  node *p, *q;

  while (current)
  {
    p = current;
    q = current->next;

    while (q)
    {
      if (q->data == current->data)
      {
        node *temp = q;
        p->next = q->next;
        q = q->next;
        delete temp;
      }
      else
      {
        p = q;
        q = q->next;
      }
    }

    current = current->next;
  }
}

void removeDuplicate2(node *head)
{
  if (!head)
  {
    return;
  }

  unordered_set<int> hs;
  hs.insert(head->data);

  node *previous = head;
  node *current = head->next;

  while (current)
  {
    if (hs.find(current->data) != hs.end())
    {
      node *temp = current;
      previous->next = current->next;
      current = current->next;
      delete temp;
    }
    else
    {
      hs.insert(current->data);
      previous = current;
      current = current->next;
    }
  }
}

string print(node *head)
{
  ostringstream oss;

  for (node *p = head; p; p = p->next)
  {
    oss << p->data << "->";
  }

  oss << "NULL";

  return oss.str();
}

void test(string actual, string expected, int version)
{
  cout << "removeDuplicate" << version << " - actual: " << actual << " expected: " << expected << endl;
}

int main()
{
  node *head = NULL;
  removeDuplicate(head);
  test(print(head), "NULL", 1);

  head = NULL;
  removeDuplicate2(head);
  test(print(head), "NULL", 2);

  int array[] = { 1 };
  head = init(array, 1);
  removeDuplicate(head);
  test(print(head), "1->NULL", 1);

  head = init(array, 1);
  removeDuplicate2(head);
  test(print(head), "1->NULL", 2);

  int array2[] = { 3, 2, 1, 3, 5, 6, 2, 6, 3, 1 };
  head = init(array2, 10);
  removeDuplicate(head);
  test(print(head), "3->2->1->5->6->NULL", 1);

  head = init(array2, 10);
  removeDuplicate2(head);
  test(print(head), "3->2->1->5->6->NULL", 2);

  return 0;
}


