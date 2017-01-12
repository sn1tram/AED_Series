package series.serie3;

public class TNode {

	private int count;
	private TNode[] childs;
	private char value;
	
	public TNode(int lenght, int count, char value){
		childs = new TNode[lenght];
		this.count= count;
		this.value = value;
	}

	public TNode[] getChilds() {
		return childs;
	}
	
	public int getCount() {
		return count;
	}
	
	public char getValue() {
		return value;
	}

	public void setChilds(int idx, TNode n) {
		childs[idx] = n;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setValue(char value) {
		this.value = value;
	}
}
