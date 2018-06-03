import java.util.*;

class MergeSortExample
{
  public static void main(String[] args)
  {
    int [] data = {35, 20, 55, 42, 88, 77, 15, 99, 100};
        
    mergeSort(data, new int[data.length], 0,data.length-1);
    
    for(int i=0; i< data.length; i++)
    {
        System.out.print(data[i] + ", ");
    }
    
  }

  public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
    if( leftStart == rightEnd)   // one item in array means it's already sorted
        return;
    else
    {
        int midPoint = (leftStart + rightEnd) /2;
        
        // merge sort left half
        mergeSort(array, temp, leftStart, midPoint);
        
        // merge sort right half
        mergeSort(array, temp, midPoint+1,rightEnd);
        
        // now merge the two sorted halves together
        merge(array, temp, leftStart, rightEnd);
    }
}

  public static void merge(int[] array, int[] tempArray, int leftStart, int rightEnd)
  {
    int leftEnd = (leftStart+rightEnd)/2;
    int rightStart = leftEnd + 1;
    int size = rightEnd-leftEnd + 1; // # of elements to copy

    int tempIndex=leftStart;
    int left = leftStart;
    int right = rightStart;
    // while both halves are in bounds
    while(left <= leftEnd && right<=rightEnd)
    {
      if(array[left] <= array[right])
        tempArray[tempIndex++] = array[left++];
      else
        tempArray[tempIndex++] = array[right++];
    }

    // if right side went out of bounds, only left is left. Copy the remaining items over.
    System.arraycopy(array, left, tempArray, tempIndex, leftEnd-left+1);
    
    // if left side went out of bounds, only RIGHT is remaining. Copy the remaining items over.
    System.arraycopy(array, right, tempArray, tempIndex, rightEnd-right+1);

    // Copy over values from temp array to original array
    System.arraycopy(tempArray, leftStart, array, leftStart, size);

    /*
    // if right side went out of bounds, only left is left. Copy the remaining items over.
    while(left <= leftEnd)
      tempArray[tempIndex++] = array[left++];

    // if left side went out of bounds, only RIGHT is remaining. Copy the remaining items over.
    while(right <= rightEnd)
      tempArray[tempIndex++] = array[right++];

    // Copy over values from temp array to original array
    System.arraycopy(tempArray, leftStart, array, leftStart, size);*/
  }
}