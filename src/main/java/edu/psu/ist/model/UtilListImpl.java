package edu.psu.ist.model;

import java.util.*;

public class UtilListImpl<E> implements ISplittableList<E> {

    private List<E> left = new LinkedList<>();
    private List<E> right = new LinkedList<>();
    private Map<E, Integer> countingMap = new HashMap<>();

    public UtilListImpl() {}

    public UtilListImpl(ISplittableList<E> other) {
        this();
        String listStr = other.toString();
        String[] parts = listStr.split("\\|");

        if (parts.length > 0) {
            for (String l : parts[0].trim().split("\\s+")) {
                if (!l.isEmpty()) left.add((E) l.trim());
            }
        }
        if (parts.length > 1) {
            for (String r : parts[1].trim().split("\\s+")) {
                if (!r.isEmpty()) right.add((E) r.trim());
            }
        }


        rebuildCount();
    }


    private void rebuildCount() {
        countingMap.clear();
        for (E e : left) countingMap.put(e, countingMap.getOrDefault(e, 0) + 1);
        for (E e : right) countingMap.put(e, countingMap.getOrDefault(e, 0) + 1);
    }

    @Override
    public void addToRightAtFront(E e) {
        right.add(0, e);
        countingMap.put(e, countingMap.getOrDefault(e, 0) + 1);
    }

    @Override
    public E removeFromRightAtFront() {
        if (right.isEmpty()) throw new NoSuchElementException("Right list is empty!");
        E removed = right.remove(0);
        countingMap.put(removed, countingMap.get(removed) - 1);
        if (countingMap.get(removed) == 0) countingMap.remove(removed);
        return removed;
    }

    @Override
    public void moveToVeryBeginning() {
        right.addAll(0, left);
        left.clear();
        rebuildCount();
    }

    @Override
    public int countOf(E e) {
        return countingMap.getOrDefault(e, 0);
    }

    @Override
    public void moveForward() {
        if (right.isEmpty()) throw new IllegalStateException("Cannot move forward into empty right list.");
        left.add(right.remove(0));
    }

    public void moveBackward() {
        if (left.isEmpty()) throw new IllegalStateException("Cannot move backward into empty left list.");
        right.add(0, left.remove(left.size() - 1));
    }

    @Override
    public int leftLength() {
        return left.size();
    }

    @Override
    public int rightLength() {
        return right.size();
    }

    @Override
    public void clear() {
        left.clear();
        right.clear();
        countingMap.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : left) sb.append(e).append(" ");
        sb.append("| ");
        for (E e : right) sb.append(e).append(" ");
        return sb.toString().trim();
    }
}
