package series.serie2;


import java.util.*;
import java.lang.*;

public class Iterables {
	
	public static <T> Iterable<T> flatten( final Iterable< Iterable<T> > src) {
		throw new UnsupportedOperationException();
	}

	public static  Iterable<Integer> alternateEvenOdd(final Iterable<Integer> src){
		int count = 0;
		Iterator<Integer> it = src.iterator();
		List<Integer> aux = new LinkedList<>();
		if(!it.hasNext()) {
            throw NoSuchElementException;
        }
		while(it.hasNext()){
			int number = it.next();
			if(number%2==1 && count == 0) {
				aux.add(number);
				count = 1;
			}else if(number%2==0 && count == 1){
				aux.add(number);
				count = 0;
			}
		}
		return aux;
	}
}
