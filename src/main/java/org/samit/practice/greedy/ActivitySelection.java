package org.samit.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given pairs of start and end time of jobs, find the maximum number of jobs that can be performed on a single machine with single processor
 * TC : O(n Log n)
 */
public class ActivitySelection {

    public static void main(String[] args) {
        ActivitySelection as = new ActivitySelection();
        Activity a1 = new Activity(12, 25);
        Activity a2 = new Activity(10, 20);
        Activity a3 = new Activity(20, 30);
        System.out.println("result : " + as.activitySelection(new Activity[]{a1, a2, a3}));
    }

    private int activitySelection(Activity[] arr) {

        Arrays.sort(arr, Comparator.comparingInt(o -> o.finish));
        System.out.println("sorted : " + Arrays.toString(arr));
        int res = 1;
        Activity selected = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i].start >= selected.finish){
                res++;
                selected = arr[i];
            }
        }
        return res;
    }

    private static class Activity {
        int start;
        int finish;

        Activity(int st, int fin) {
            this.start = st;
            this.finish = fin;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }
    }
}
