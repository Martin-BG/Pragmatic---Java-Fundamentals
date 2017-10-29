package edu.homework10.task2_registry;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Registry<T> {
	private String name;
	private List<T> elements;
	private int maxElements;
	private int currentElements;

	/**
	 * @param name
	 * @param maxElements
	 */
	public Registry(String name, int maxElements) {
		super();
		this.name = name;
		this.maxElements = maxElements;
		this.elements = new LinkedList<>();
	}

	public String getName() {
		return this.name;
	}

	public int size() {
		return this.currentElements;
	}

	public boolean add(T element) throws RegistryException {
		if (this.currentElements >= this.maxElements) {
			return false;
		}

		if (this.elements.add(element)) {
			this.currentElements++;
			return true;
		}

		throw new RegistryException("Failed to add new element to registry");
	}

	public boolean remove(T element) {
		if (this.elements.remove(element)) {
			this.currentElements--;
			return true;
		}

		return false;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T[] getElements() {
		if (this.currentElements > 0) {
			T[] result = (T[]) Array.newInstance(this.elements.get(0).getClass(), this.currentElements);
			result = this.elements.toArray(result);
			return (T[]) result;
		}
		return null;
	}

	@Override
	public String toString() {
		return String.format("Registry [name=%s, maxElements=%s, currentElements=%s]", name, maxElements,
				currentElements);
	}

}
