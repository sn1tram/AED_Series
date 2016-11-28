package series.serie2;

public class Utils {

	public static <E> Node<E>[] shrink(Node<E>[] hashTable) {
		// hash(k) = k mod d
		// size of the table = 2^d
		//int oldD = hashTable.length - 1;
		// since the new table has to be half the size the pow is d-1
		//int newD = oldD - 1;
		Node<E>[] newTable = new Node[(hashTable.length)/2];
		int newCode;
		for(int i=0; i<hashTable.length; ++i){
			if(hashTable[i]==hashTable[i].next)continue;
			else {
				newCode = newIndex(hashTable, i);
				insert(hashTable,newCode,i);
			}
		}
		for (int i = 0; i < newTable.length; i++) {
			newTable[i]=hashTable[i];
		}
		hashTable=newTable;
		return hashTable;
	}

	public static <E> int newIndex(Node<E>[] hashTable, int index) {
		int newValue = hashTable.length / 2;
		return hashTable[index].hashCode() % newValue;
	}

	public static <E> void insert(Node<E>[] hashtable,int targetIndex, int oldIndex){
		if(hashtable[targetIndex]==hashtable[targetIndex].next){
			hashtable[targetIndex].next = hashtable[oldIndex].next;
			hashtable[oldIndex].previous=hashtable[targetIndex];
			hashtable[targetIndex].previous=hashtable[oldIndex];
		}else{
			hashtable[targetIndex].previous.next = hashtable[oldIndex].next;
			hashtable[targetIndex].previous = hashtable[oldIndex];
		}
	}
}