package solution;

//使用队列实现栈的下列操作：
//
//
// push(x) -- 元素 x 入栈
// pop() -- 移除栈顶元素
// top() -- 获取栈顶元素
// empty() -- 返回栈是否为空
//
//
// 注意:
//
//
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
//
// Related Topics 栈 设计


import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class s225 {

    static class MyStack {
        int flag;

        Queue<Integer> [] queue;


        /** Initialize your data structure here. */
        public MyStack() {
            flag = 0;

            queue = new Queue[2];
            queue[0] = new LinkedBlockingDeque<>();
            queue[1] = new LinkedBlockingDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int inv = (flag+1)%2;
            queue[inv].add(x);//加入空队列
            int size = queue[flag].size();
            for(int i=0;i<size;++i){
                queue[inv].add(queue[flag].remove());
            }
            flag = inv;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue[flag].remove();
        }

        /** Get the top element. */
        public int top() {
            //return queue[flag].peek();
            return queue[flag].peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue[flag].isEmpty();
        }
    }


    public static void main(String[] args) {
        System.out.println(0);
        System.out.println(!true);

//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        System.out.println(myStack.top());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.empty());


//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        System.out.println(myStack.top());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.empty());



        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);


        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

        System.out.println(myStack.empty());
    }
}
