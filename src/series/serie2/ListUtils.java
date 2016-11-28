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
		Node<Node<String>> principal = new Node<>();
		Node<String> first = list;
		Node<String> inNode = new Node<>();
		Node<Node<String>> head = principal;
		principal.next = principal.previous = principal;
		while((first = first.next) != list){
			Node<Node<String>> aux = new Node<>();
			if( !first.value.equals(".")) {
				insert(inNode, first.value);
				remove(first);
			}else {
				if (first.next.value != null) {
					if (first.next.value.equals("."))
						continue;
					else {
						principal.next = aux;
						aux.previous = principal;
						aux.next = head;
						head.previous = aux;
						aux.value = inNode;
						principal = principal.next;
						inNode = new Node<>();
					}
				}
			}
			if(first.next.value == null) {
				principal.next = aux;
				aux.previous = principal;
				aux.next = head;
				head.previous = aux;
				aux.value = inNode;
				break;
			}
		}
		/*while((first = first.next) != list){
			if( first.value != "."){
				insert(auxList, first.value);
			}else {
					x.value = auxList;
					x.next = dummy;
					if (dummy != null)
						dummy.value = auxList;
					dummy = x;
			}if(first.next.value==null)
				return dummy;

		}
		return dummy;*/
		return head;
	}
	//Insert element head List
	public static <E> void insert(Node<E> list, E e) {
		Node<E> x = new Node<>();
		Node<E> aux = list;
		if (list.value == null) {
			list.value = e;
			return;
		}
		while (aux.next != null)
			aux = aux.next;
		aux.next = x;
		x.previous = aux;
		x.value = e;
	}

	private static <E> void remove (Node<E> node){
		node.previous.next = node.next;
		node.next.previous = node.previous;
	}
}