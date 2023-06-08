package com.funcional.lista;

import java.util.function.Predicate;

public sealed interface Lista<T> permits Nil, Cons {

	Lista NIL = new Nil();// objeto de la clase Nill

	// metodos abstractos
	// clse de la interfaz implementa la logicia
	// intefraz la firma;

	T head();// funcionalidad lo da la interfaz //metodo abstracto 1
//    <T> tipos de datos genericos...revisar
	// T ... elems un numero indefinido de elementos T
	// elems es un nombre

	Lista<T> tail(); // metodo abstracto 2

	boolean isEmpty(); // metodo abstracto 3

	// metodo abstracto 4 toString que implementa en todas las clases

	static <T> Lista<T> of(T h, Lista<T> t) {
		return new Cons<>(h, t);
	}

	// metodo para crear lista y le llama al metdo of de arriba
	static <T> Lista<T> of(T... elems) {
		Lista<T> ret = Lista.NIL;
		for (int i = elems.length - 1; i >= 0; i--) {
			T h = elems[i];
			var tmp = Lista.of(h, ret);
			ret = tmp;
		}
		return ret;
	}

	//
	default Lista<T> append(T elemen) {
		if (isEmpty()) {
			return Lista.of(elemen);
		} else {
			return Lista.of(head(), tail().append(elemen));
		}
	}

	default Lista<T> prepend(T elem) {
		return Lista.of(elem, this);
	}

	default Lista<T> remove(T elem) {
		if (isEmpty()) {
			return NIL;
		} else {
			if (elem.equals(head())) {
				return tail();
			} else {
				return Lista.of(head(), tail().remove(elem));
			}
		}
	}

	default Lista<T> drop(int n) {
		// elimina un numero determinado de elemntos drop(2) // elimina dos elementos
		if (isEmpty() || n <= 0) {
			return this;
		} else {
			return tail().drop(n - 1);
		}

	}

	default Lista<T> dropWhile(Predicate<T> p) {
		if (isEmpty() || p.test(head())) {
			return this;
		} else {
			return tail().dropWhile(p);
		}
	}

	default Lista<T> concat(Lista<T> a) {
		if (isEmpty()) {
			return a;
		} else {
			return Lista.of(head(), tail().concat(a));
		}
	}

	default Lista<T> take(int n) {
		if (isEmpty() || n <= 0) {
			return NIL;
		} else {
			return Lista.of(head(), tail().take(n - 1));
		}
	}

	default Lista<T> takeWile(Predicate<T> p) {// revisar Predicate<T>
		if (isEmpty() || !p.test(head())) {
			return NIL;
		} else {
			return Lista.of(head(), tail().takeWile(p));
		}
	}
}
