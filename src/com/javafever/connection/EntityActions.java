package com.javafever.connection;

import java.util.List;

public abstract class EntityActions<T> {

	protected abstract boolean create(T element);

	protected abstract List<T> read();

	protected abstract boolean update(T element);

	protected abstract boolean delete(T element);

}
