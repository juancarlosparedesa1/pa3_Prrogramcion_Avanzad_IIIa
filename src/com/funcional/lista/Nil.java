package com.funcional.lista;

//--nodo final

public final class Nil<T> implements Lista<T> {
	// constructor
	// protegido proteger que nadie mas tenga un nill
	// nodo ultimo elemento de la lista
	// elemento unico
	protected Nil() {

	}

	// implementacion de metodos abstractos
	@Override
	public T head() {
		return null;
	}

	@Override
	public Lista<T> tail() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "NIL";
	}
}
