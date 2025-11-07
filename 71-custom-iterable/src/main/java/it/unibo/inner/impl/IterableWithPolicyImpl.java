package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public final class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final T[] array;

    public IterableWithPolicyImpl(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
		return new IteratorImpl<>(array);
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {

    }

    public static final class IteratorImpl<T> implements Iterator<T> {

        private final T[] array;
		private int currentId = 0;

        IteratorImpl(T[] arr) {
            array = arr;
			currentId = 0;
        }

        @Override
        public boolean hasNext() {
			return currentId < array.length;
        }

        @Override
        public T next() {
			return array[currentId++];
        }

    }

	public static void main(String... args) {
		final Integer[] arr = {1, 2, 4, 5, 6, 8};
		final IterableWithPolicyImpl<Integer> iter =
		 		new IterableWithPolicyImpl<Integer>(arr);

		for (var a : iter)
			System.out.println(a);

		System.out.println();

		for (var itera = iter.iterator(); itera.hasNext(); ) {
			System.out.println(itera.next());
		}
	}
    
}
