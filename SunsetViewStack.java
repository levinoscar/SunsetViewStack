import java.util.*;

import java.util.Stack;

import java.util.NoSuchElementException;

/*

Solves the sunset view problem by maintaining a
running maximum of building heights. Uses a while loop to loop in
the direction away from the sun and keep track of the maximum
height seen so far. If the current building is taller, it can see
the sun, otherwise it can't. So at each iteration, it compares the
height of the current building to the running maximum and updates
the running maximum accordingly. Runs in O(n) time and O(n) space.

*/

public class SunsetViewStack {

    public List<Integer> sunsetViews(int[] buildings, String direction) {

        //calculating and storing length in a variable n

        int n = buildings.length;

        //if length of building is 0 then return an empty arraylist

        if(n == 0) { return new ArrayList<>(); }

        //O(n) extra space will be needed, so we will store the answer in a stack

        //top of stack will represent the building with maximum height till current index

        Stack<Integer> stack = new Stack<>();

        //if sun is in east then start index will be length of the array - 1

        int startAt = n - 1;

        int step = -1;

        // if sun is in west then start index will be zero and step or jump will be 1 for the loop

        if(direction.equals("WEST")) {

            startAt = 0;

            step = 1;

        }

        int i = startAt; // since we already pushed the start index building, so we will continue from next index

        while(i >= 0 && i < n) {

            int height = buildings[i]; // get current building's height

            // if height is 0 then there is no building

            if (height == 0) {

                i += step;

                continue;

            }

            // for first time when height is greater than 0 and at that time stack is initially empty

            if(height > 0 && stack.isEmpty()) { stack.push(i); }

            // the top of the stack will always store the index of the building with maximum height until the ith index,

            // so we will peek the stack to get index of maximum height building index



            if(height > buildings[stack.peek()]) { stack.push(i); }

            i += step;

        }

        // when all building's height is 0 then return empty list

        if (stack.isEmpty()) { return new ArrayList<>(); }

        // Convert stack to list

        // The space complexity will remain O(1)

        // Time complexity will also be O(N)

        List<Integer> answer = new ArrayList<>(stack);

        // reversing the list if direction is east

        // will take O(N) time

        if (direction.equals("EAST")) { Collections.reverse(answer); }

        return answer;

    }

    // Main function

    public static void main(String[] args) throws NoSuchElementException {

        SunsetViewStack solution = new SunsetViewStack();

        // test 1

        System.out.println("-------------------TEST 1-------------------");

        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};

        System.out.println(solution.sunsetViews(buildings,"EAST"));

        System.out.println(solution.sunsetViews(buildings,"WEST"));

        // test 2

        System.out.println("-------------------TEST 2-------------------");

        buildings = new int[]{0, 1};

        System.out.println(solution.sunsetViews(buildings,"EAST"));

        System.out.println(solution.sunsetViews(buildings,"WEST"));

        // test 3

        System.out.println("-------------------TEST 3-------------------");

        buildings = new int[]{};

        System.out.println(solution.sunsetViews(buildings,"EAST"));

        System.out.println(solution.sunsetViews(buildings,"WEST"));

        // test 4

        System.out.println("-------------------TEST 4-------------------");

        buildings = new int[]{1, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8};

        System.out.println(solution.sunsetViews(buildings,"EAST"));

        System.out.println(solution.sunsetViews(buildings,"WEST"));

    }

}
