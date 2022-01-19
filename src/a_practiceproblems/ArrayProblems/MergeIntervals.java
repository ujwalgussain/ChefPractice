package a_practiceproblems.ArrayProblems;

import a_practiceproblems.TestClass3;

import java.util.PriorityQueue;
import java.util.Stack;

public class MergeIntervals {
    class Interval {
        int s, e;
        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public int[][] merge(int[][] intervals) {
        //https://leetcode.com/problems/merge-intervals/submissions/
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>((x, y) -> x.s - y.s);

        for (int interval[] : intervals)
            priorityQueue.add(new Interval(interval[0], interval[1]));

        Stack<Interval> stack = new Stack<>();
        stack.push(priorityQueue.poll());

        while (!priorityQueue.isEmpty()) {
            Interval interval = priorityQueue.poll();
            if (stack.peek().e >= interval.s){
                stack.peek().e = Math.max(stack.peek().e,interval.e);
            }
            else
                stack.push(interval);
        }
        int[][] result = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            Interval popped = stack.pop();
            result[i][0] = popped.s;
            result[i][1] = popped.e;

        }
        return result;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>((x, y) -> x.s - y.s);

        for (int interval[] : intervals)
            priorityQueue.add(new Interval(interval[0], interval[1]));
        priorityQueue.add(new Interval(newInterval[0],newInterval[1]));

        Stack<Interval> stack = new Stack<>();
        stack.push(priorityQueue.poll());

        while (!priorityQueue.isEmpty()) {
            Interval interval = priorityQueue.poll();
            if (stack.peek().e >= interval.s){
                stack.peek().e = Math.max(stack.peek().e,interval.e);
            }
            else
                stack.push(interval);
        }
        int[][] result = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            Interval popped = stack.pop();
            result[i][0] = popped.s;
            result[i][1] = popped.e;

        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new MergeIntervals().merge(
                new int[][]{{1,3},{2,6},{8,10},{15,18}}
        ));
    }
}
