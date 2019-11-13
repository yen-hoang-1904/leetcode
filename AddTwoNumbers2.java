package leetcode;

/****
    You are given two non-empty linked lists representing two non-negative integers. 
    The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
/**/
public class AddTwoNumbers2 {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }
  
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currNode1 = l1;
    ListNode currNode2 = l2;
    int sum = currNode1.val + currNode2.val;
    ListNode last = new ListNode(sum) ;
    ListNode l3 = last;
    int carrying = 0;
    // eg. [5] + [6] = [1, 1]
    if (currNode1.next == null && currNode2.next == null) {
      if (sum > 9) {
        last.val = last.val %10;
        last.next = new ListNode(1);
      }
      return l3;
    } else {
      while (currNode1.next != null || currNode2.next != null) {
        if (sum > 9) {
          last.val = last.val %10;
          carrying = 1;
        }
        if (currNode1.next != null) {
          currNode1 = currNode1.next;
          if (currNode2.next != null) {
            currNode2 = currNode2.next;
          } else {
            currNode2 = new ListNode(0);
          }
        } else {
          currNode1 = new ListNode(0);
          if (currNode2.next != null) {
            currNode2 = currNode2.next;
          }
        }
        sum = currNode1.val + currNode2.val + carrying;
        carrying = 0;
        last.next = new ListNode(sum);
        last = last.next;
      }
      if (sum > 9) {
        last.val = last.val %10;
        last.next = new ListNode(1);
      }
      return l3;
    }
  }

  public static void main(String[] args) {
    //Create listNode1
    ListNode l1 = new ListNode(9);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(9);
    l2.next.next = new ListNode(9);
    l2.next.next.next = new ListNode(9);
    l2.next.next.next.next = new ListNode(9);
    l2.next.next.next.next.next = new ListNode(9);
    l2.next.next.next.next.next.next = new ListNode(9);
    l2.next.next.next.next.next.next.next = new ListNode(9);
    l2.next.next.next.next.next.next.next.next = new ListNode(9);
    l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
    ListNode l3 = AddTwoNumbers2.addTwoNumbers(l1,l2);
    AddTwoNumbers2.printListNode(l3);
  }

  public static void printListNode(ListNode l) {
    ListNode currNode = l;
    System.out.println("");
    while (currNode != null) {
      System.out.print(currNode.val + " ");
      currNode = currNode.next;
    }
    System.out.println("");
  }

}
