package com.algoexpert.medium;

public class e41SumOfLinkedLists {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        public static LinkedList addMany(LinkedList linkedList, int[] values) {
            LinkedList current = linkedList;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new LinkedList(value);
                current = current.next;
            }
            return linkedList;
        }
    }

    //O(max(n,m)) | O(max(n,m))
    public static LinkedList sumOfLinkedLists(LinkedList llOne, LinkedList llTwo) {
        LinkedList outputHead = new LinkedList(0);

        LinkedList currentNode = outputHead;
        int carry=0;

        while(llOne!=null && llTwo!=null) {
            int value1 = llOne.value;
            int value2 = llTwo.value;

            int sum = value1 + value2 + carry;

            carry = sum/10;
            int nodeValue = sum%10;
            currentNode.next = new LinkedList(nodeValue);
            llOne = llOne.next;
            llTwo = llTwo.next;
            currentNode = currentNode.next;
        }
        while(llOne==null && llTwo!=null) {
            int value2 = llTwo.value;
            int sum = value2 + carry;

            carry = sum/10;
            int nodeValue = sum%10;
            currentNode.next = new LinkedList(nodeValue);
            llTwo = llTwo.next;
            currentNode = currentNode.next;
        }
        while(llOne!=null && llTwo==null) {
            int value1 = llOne.value;
            int sum = value1 + carry;

            carry = sum/10;
            int nodeValue = sum%10;
            currentNode.next = new LinkedList(nodeValue);
            llOne = llOne.next;
            currentNode = currentNode.next;
        }
        if(carry!=0) {
            currentNode=outputHead;
            while(currentNode.next!=null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new LinkedList(carry);
        }
        return outputHead.next;
    }

    public static LinkedList sumOfLinkedListsTheir(LinkedList llOne, LinkedList llTwo) {
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;

        LinkedList nodeOne = llOne;
        LinkedList nodeTwo = llTwo;

        while(nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = (nodeOne!=null) ? nodeOne.value  : 0;
            int valueTwo = (nodeTwo!=null) ? nodeTwo.value  : 0;

            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues/10;
            nodeOne = nodeOne!=null ? nodeOne.next : null;
            nodeTwo = nodeTwo!=null ? nodeTwo.next : null;
        }
        return newLinkedListHeadPointer;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList(2);
        LinkedList.addMany(ll1, new int[] {4, 7, 1});

        LinkedList ll2 = new LinkedList(9);
        LinkedList.addMany(ll2, new int[] {4, 5});

        sumOfLinkedLists(ll1, ll2);
        
            
    //     # - a and b are arrays of ints that represent a big number 
    //     # - each element will be from 0 to 9 
    //     # - a and b will be the same size / length 
    //     # - return the result of adding a and b together, also in the format of an array of ints


    //     #  [0, 2, 1] a
    //     # +[1, 3, 9] b
    //     #  ----------
    //     #  [1, 6, 0]  

          List<Integer> a = new ArrayList<>();
          List<Integer> b = new ArrayList<>();
          a.add(9);
          a.add(2);
          a.add(1);
          b.add(1);
          b.add(3);
          b.add(9);

        // [1, 0, 6, 0]

         System.out.println(add_big_ints(a,b));
    }
    

    
      public static List<Integer> add_big_ints(List<Integer> a, List<Integer> b) {
          List<Integer> result = new ArrayList<>(); 

          Collections.reverse(a);
          Collections.reverse(b);


          int carry = 0;

          int idx = 0;
          while(idx<a.size() || idx<b.size() || carry !=0) {
              int valueOne = idx < a.size() ? a.get(idx) : 0;
              int valueTwo = idx < b.size() ? b.get(idx) : 0;

              int sum = valueOne + valueTwo + carry;

              int newValue = sum % 10;

              result.add(newValue);

              carry = sum /10;
              idx++;
          }
          Collections.reverse(result);
          return result;
      }
}
