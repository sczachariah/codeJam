package com.sczachariah;

//Even numbers first and then odd numbers
public class FirstEvenThenOddInArray {
    public static void main(String[] args) {
        int [] items = new int [] {1,2,3,4,5,6,7,8,9,10};

        System.out.print("Old Array : ");
        for(int i=0;i<items.length;i++)
            System.out.print(items[i] + "\t");

        System.out.print("\nNew Array : ");
        OddSort(items);

        for(int i=0;i<items.length;i++)
            System.out.print(items[i] + "\t");
    }

    private static int[] OddSort(int[] items)
    {
        int oddPos, nextEvenPos;
        for (nextEvenPos = 0;
             nextEvenPos < items.length && items[nextEvenPos] % 2 == 0;
             nextEvenPos++) { }
        // nextEvenPos is now positioned at the first odd number in the array,
        // i.e. it is the next place an even number will be placed

        // We already know that items[nextEvenPos] is odd (from the condition of the
        // first loop), so we'll start looking for even numbers at nextEvenPos + 1
        for (oddPos = nextEvenPos + 1; oddPos < items.length; oddPos++)
        {
            // If we find an even number
            if (items[oddPos] % 2 == 0)
            {
                // Swap the values
                items[oddPos] = items[oddPos] ^ items[nextEvenPos];
                items[nextEvenPos] = items[oddPos] ^ items[nextEvenPos];
                items[oddPos] = items[oddPos] ^ items[nextEvenPos];
                // And increment the location for the next even number
                nextEvenPos++;
            }
        }

        return items;
    }
}
