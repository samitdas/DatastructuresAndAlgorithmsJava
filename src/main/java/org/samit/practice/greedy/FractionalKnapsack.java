package org.samit.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given few items of certain weight and values and a knapsack of X capacity
 * find the maximum value that can be obtained. Taking fraction of values is allowed
 * TC : O(n Log n)
 */
public class FractionalKnapsack {
    public static void main(String[] args) {

        Item[] items = {new Item(10, 60), new Item(40, 40), new Item(20, 100), new Item(30, 120)};
        int knapsackCapacity = 50;

        FractionalKnapsack fk = new FractionalKnapsack();
        System.out.println("result : " + fk.compute(items, knapsackCapacity));
    }

    private double compute(Item[] items, int knapsackCapacity) {
        Arrays.sort(items, (i1, i2) -> (int) (i2.ratio - i1.ratio));
        System.out.println("sorted : " + Arrays.toString(items));

        double res = 0;

        for(int i=0; i < items.length; i++){
            if(items[i].weight <= knapsackCapacity){
                res += items[i].value;
                knapsackCapacity -= items[i].weight;
            }else{
                res += items[i].ratio * knapsackCapacity;
                break;
            }
        }
        return res;
    }

    private static class Item {
        int weight;
        int value;

        double ratio;

        Item(int w, int v) {
            this.weight = w;
            this.value = v;
            this.ratio = (double) this.value / this.weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", value=" + value +
                    ", ratio=" + ratio +
                    '}';
        }
    }
}
