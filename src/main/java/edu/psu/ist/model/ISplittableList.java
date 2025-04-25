package edu.psu.ist.model;

import java.util.NoSuchElementException;

public interface ISplittableList<T> {
    void addToRightAtFront(T e);
    T removeFromRightAtFront();
    void moveToVeryBeginning();
    int countOf(T e);
    void moveForward();
    int leftLength();
    int rightLength();
    void clear();
}
