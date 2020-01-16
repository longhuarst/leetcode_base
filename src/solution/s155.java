package solution;
//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) -- 将元素 x 推入栈中。
// pop() -- 删除栈顶的元素。
// top() -- 获取栈顶元素。
// getMin() -- 检索栈中的最小元素。
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
// Related Topics 栈 设计


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class s155 {

    public static class MinStack {
        Stack<Integer> stack;
        PriorityQueue<Integer> queue;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            queue = new PriorityQueue<>();

        }

        public void push(int x) {
            stack.push(x);
            queue.add(x);
        }

        public void pop() {
            int x = stack.pop();
            queue.remove(x);
        }

        public int top() {
            return stack.peek();
    }

        public int getMin() {
            return queue.peek();
        }
    }


    public static void main(String[] args) {

//        MinStack minStack = new MinStack();
//
//

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.

    }

}
