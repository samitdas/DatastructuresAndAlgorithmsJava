package org.samit.practice.search;

/**
 * Given a sorted array with duplicates find the number of occurrences of the given value
 * Idea is to call FirstIndex and LastIndex and compute diff + 1
 */
public class CountOccurrence {
    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 30, 30, 30, 40, 50};
        SearchIndexOfOccurrence bs = new SearchIndexOfOccurrence();
        var firstIndex = bs.firstOccurrence(arr, 40) ;
        var lastIndex = bs.lastOccurrence(arr, 40) ;

        var res = lastIndex == -1 ? 0 : (lastIndex - firstIndex) + 1;

        System.out.println("Count of occurrence of 40 : " + res);
    }



}
