/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class TestQueue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("----------------------QUEUE--------------------");
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(6);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(9);
        outputQueue(q);
        sortQueue2(q);
        outputQueue(q);
//                Stack<Integer> s=new Stack<Integer>();
//                s.add(5);
//                s.add(1);
//                s.add(8);
//                s.add(4);
//                outputStack(s);
//                reverse(s);
    }

    static void inputQueue(Queue<Integer> Q) {
        System.out.print("Enter elements separated by space: ");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            Q.enqueue(sc.nextInt());
        }
    }

    static void outputQueue(Queue<Integer> Q) {
        System.out.println(Q);
    }

    static void outputStack(Stack<Integer> S) {
        System.out.println(S);
    }

    public static void reverse(Stack<Integer> S) {
        //Reverse the order of elements on stack S using one additional queue
        Queue<Integer> Q = new Queue<Integer>();
        while (!S.isEmpty()) {
            Q.enqueue(S.pop());//1.pop el from stack to queue
        }//repeat loop until stack is empty
        if (S.isEmpty()) {//when stack is empty
            while (!Q.isEmpty()) {
                S.push(Q.front());//2.Remove top el of queue,push to stack
                Q.dequeue();
            }//repeat until queue is empty
        }
        System.out.println(S);
        System.out.println("Reversed stack:" + S);
    }

    public static void sortQueue1(Queue<Integer> Q) {
        Queue<Integer> q = new Queue<Integer>();
        Queue<Integer> q1 = new Queue<Integer>();
        //make the top el the biggest/smallest num
        int top = Q.front();
        int precount = Q.Size();
        int count = 0;
        while (count < precount) {//counting for number of el to sort
            while (!Q.isEmpty()) {//if ori queue is not empty

                if (Q.front() >= top) {
                    top = Q.front();//1.Find the biggest/smallest,assign to top
                }
                q.enqueue(Q.dequeue());//2.Pass to queue 1 as usual

            }//repeat the loop until Q is empty

            q1.enqueue(top);//3.Assign biggest num from above step to queue1

            if (Q.isEmpty()) {
                while (!q.isEmpty()) {//4.Throw nums back from q to Q to find match 
                    //num of top el to del
                    if (q.front() == top) {//if it's a match then del it
                        q.dequeue();
                    }
                    if (q.front() == null) {//if front el==null => meaning no more num
                        //to sort => break
                        break;
                    }
                    if (q.front() != top) {//if it's not a match then move to next num
                        Q.enqueue(q.dequeue());
                    }
                }
            }
            count += 1;//increase count to avoid infinite loop
            if (Q.front() == null) {//if Q front == null => meaning no more num to sort
                //=>break
                break;
            }
            top = Q.front();//set top el to Q.front so that in next loop,biggest/smallest
            //num is the one from the remaining of ori queue not the current 
            //top
        }
        while (!q1.isEmpty()) {//when everything has been sorted
            Q.enqueue(q1.dequeue());//loop to push num back to Q
        }
        System.out.println("Q after is:" + Q);
        //1.find the biggest num
        //Using two additional queue and some non-array variables, order all elements on a queue

    }

    public static void sortQueue2(Queue<Integer> Q) {
        Queue<Integer> q = new Queue<Integer>();
        int tmp = Q.front();
        int precount = Q.Size();
        int count = 0;
        while (count < precount) {
            while (!Q.isEmpty()) {
                if (Q.front() >= tmp) {
                    tmp = Q.front();//find the biggest/smallest num
                }
                q.enqueue(Q.dequeue());//pass el from Q to q
            }
            if(Q.isEmpty()){
                while(!q.isEmpty()){
                    if(q.front()==tmp){
                        q.dequeue();
                    }
                    if(q.front()==null){
                        break;
                    }
                    if(q.front()!=tmp){
                        Q.enqueue(q.dequeue());
                    }
                
                }
            }
                q.enqueue(tmp);
                
        }
        while (!q.isEmpty()) {
            Q.enqueue(q.dequeue());
        }
        System.out.println("Original queue:" + Q);
        System.out.println("Sorted queue:" + q);
        //Using one additional queue and some non-array variables, order all elements on a queue

    }

}
