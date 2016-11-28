package series.serie2;


import java.lang.*;
import java.util.*;

public class Iterables {

	public static <T> Iterable<T> flatten(final Iterable<Iterable<T>> src) {
		return new Iterable<T>() {
			Iterator<Iterable<T>> outIT = src.iterator();
			Iterator<T> inIT = null;
			T value = null;
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					@Override
					public boolean hasNext() {
						if(value!=null)return true;

						if(inIT!=null){
							if(inIT.hasNext()) {
								value = inIT.next();
								return true;
							}
							inIT = null;
						}

						while(outIT.hasNext()){
							inIT = outIT.next().iterator();
							if(inIT.hasNext()) {
								value = inIT.next();
								return true;
							}
							inIT = null;
						}


						return false;
					}

					@Override
					public T next() {
						if(value==null) hasNext();
						T newVal=value;
						value = null;
						if(newVal==null) throw new NoSuchElementException("flatten: no more elements");
						return newVal;
					}
				};
			}
		};



	}

	public static Iterable<Integer> alternateEvenOdd(final Iterable<Integer> src) {
		return new Iterable<Integer>() {
			Iterator<Integer> it = src.iterator();
			boolean isOdd = true;
			int value = -1;
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					@Override
					public boolean hasNext() {
						while(it.hasNext()){
							int number = it.next();
							if (number % 2 == 1 && isOdd) {
								value = number;
								isOdd = false;
								return true;
							} else if (number % 2 == 0 && !isOdd) {
								value = number;
								isOdd = true;
								return true;
							}
						}
						return false;
					}

					@Override
					public Integer next() {
						if(value==-1) hasNext();
						int newVal=value;
						value = -1;
						if(newVal==-1) throw new NoSuchElementException("alternateEvenoOdd: no more elements");
						return newVal;
					}

					@Override
					public void remove(){
						throw new UnsupportedOperationException("alternateEvenoOdd: remove not supported");
					}
				};
			}
		};
	}
}