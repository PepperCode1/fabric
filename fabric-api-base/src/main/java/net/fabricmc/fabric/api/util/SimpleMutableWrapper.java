package net.fabricmc.fabric.api.util;

import java.util.function.Supplier;

public class SimpleMutableWrapper<T> implements Supplier<T> {
	private T wrapped;

	public SimpleMutableWrapper() {
	}

	public SimpleMutableWrapper(T wrapped) {
		set(wrapped);
	}

	@Override
	public T get() {
		return wrapped;
	}

	public void set(T wrapped) {
		this.wrapped = wrapped;
	}
}
