package series.serie2;

import java.util.Comparator;

public class ListUtils {
	
	public static <E extends Comparable<E>> void quicksort(Node<E> first, Node<E> last, Comparator<E> cmp){
		if (first == null) return;
		if (first.next == null) return;
		Node<E> i, j;
		for(i = first; !(i.equals(last)); i = i.next){
			for(j=i.next; !j.equals(last); j = j.next ){
				int checkCompare = cmp.compare(i.value, j.value);
				if( checkCompare > 0 ){
					E aux = j.value;
					j.value = i.value;
					i.value = aux;
				}

			}
		}
	}
	
	public static Node<Node<String>> splitBySentence(Node<String> list) {
		Node<Node<String>> dummy = new Node<>();
		Node<Node<String>> x = new Node<>();
		dummy.next = dummy.previous = dummy;
		Node<String> first = list.next, auxList = new Node<>();
		while(first.value != null){
			if( first.value != "."){
				insert(auxList, first.value);
			}else{
				x.value = auxList;
				x.next = dummy;
				if (dummy != null)
					dummy.next = x;
				dummy = x;
			}
			first = first.next;
		}
		return dummy;
	}
	//Insert element head List
	public static <E> Node<E> insert(Node<E> list, E e) {
		Node<E> x = new Node<E>();
		x.value = e; x.next = list;
		if(list != null)
			list.previous = x;
		list = x;
		return list;
	}
}