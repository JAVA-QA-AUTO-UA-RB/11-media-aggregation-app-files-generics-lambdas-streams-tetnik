package com.example.media.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic playlist class.
 */
public class Playlist<T extends Media> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    // TODO: Implement method to calculate total duration
    public int getTotalDuration() {
        return 0; // TODO
    }

    // TODO: Implement method to print all items
    public void printAll() {
        // TODO
    }
}
