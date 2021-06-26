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

public class Queue<T> {

    LinkedList<T> l = new LinkedList<T>();

    public void enqueue(T el) {
        l.addLast(el);
        System.out.println("Add to list successful");
    }

    public T dequeue() {
        if ((l.getFirst() == null)) {
            System.out.println("Empty list,nothing to delete");
        }
        System.out.println("List of elements:" + l);
        System.out.println("First element to remove:" + l.getLast());
        System.out.println("Remove last element of the list successful");
        System.out.println("Edited list:" + l);
        return l.removeFirst();
    }

    public boolean isEmpty() {
        if (l.isEmpty()) {
            System.out.println("List is empty");
            return true;
        } else {
            return false;
        }
    }

    public int Size() {
        if (l.isEmpty()) {
            System.out.println("List is empty");
            return 0;
        } else {
            System.out.println("Size of the list is:" + l.size());
        }
        return l.size();
    }

    public T front() {
        if (l.isEmpty()) {
            System.out.println("Empty list");
        }
        return l.peekFirst();
    }

    public void clear() {
        if (l.isEmpty()) {
            System.out.println("Empty list,clear what?");
        } else {
            System.out.println("List to be clear:" + l.element());
            l.removeAll(l);
        }
    }

    public String toString() {
        return l.toString();
    }
}
