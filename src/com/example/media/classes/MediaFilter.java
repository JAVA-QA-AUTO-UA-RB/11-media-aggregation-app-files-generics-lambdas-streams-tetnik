package com.example.media.classes;

/**
 * Functional interface for media filtering.
 */
@FunctionalInterface
public interface MediaFilter<T extends Media> {
    boolean test(T item);
}
