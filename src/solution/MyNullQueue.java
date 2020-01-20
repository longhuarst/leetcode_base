package solution;

import java.util.*;

public class MyNullQueue<T> implements Queue {

    List<T> lst;

    MyNullQueue(){
        lst = new LinkedList<>();
    }

    @Override
    public int size() {
        return lst.size();
    }

    @Override
    public boolean isEmpty() {
        return lst.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return lst.contains(o);
    }

    @Override
    public Iterator iterator() {
        return lst.iterator();
    }

    @Override
    public Object[] toArray() {
        return lst.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return lst.toArray();
    }

    @Override
    public boolean add(Object o) {
        return lst.add((T) o);
    }

    @Override
    public boolean remove(Object o) {
        return lst.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return lst.addAll(c);
    }

    @Override
    public void clear() {
        lst.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        return lst.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return lst.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return lst.containsAll(c);
    }

    @Override
    public boolean offer(Object o) {
        return lst.add((T) o);
    }

    @Override
    public Object remove() {
        return lst.remove(0);
    }

    @Override
    public Object poll() {
        return lst.remove(0);
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return lst.get(0);
    }

    //允许为空的队列

}
