package series.serie3;

public class DNACollection {

	private static final int CHILDREN_SIZE = 4;
	private static final int FIRST_CHAR = 97;
	private static TNode root;

	public DNACollection() {
		root = new TNode(CHILDREN_SIZE, 0, ' ');
	}

	public void add(String fragment) {
		fragment = fragment.toLowerCase();
		TNode current = root, aux;
		for (int i = 0, idx = 0; i < fragment.length(); i++) {
			idx = converterIdx(fragment.charAt(i) - FIRST_CHAR);
			if(current.getChilds()[idx] == null){
				aux = new TNode(CHILDREN_SIZE, current.getCount() + 1, fragment.charAt(i));
				current.setChilds(idx, aux);
				current = aux;
			}
			else 
				current = current.getChilds()[idx];
		}
	}
	
	private static int converterIdx(int idx){		
		return idx == 2 ? 1 : idx == 19 ? 2 : idx == 6 ? 3 : 0;
	}

	public int prefixCount(String p) {
		p = p.toLowerCase();
		TNode aux = root;
		for(int i = 0, idx = 0; i < p.length(); ++i){
			idx = converterIdx(p.charAt(i) - FIRST_CHAR);
			if(aux.getChilds()[idx] == null)
				return 0;
			aux = aux.getChilds()[idx];
		}
		return countFragments(aux);
	}
	
	private int countFragments(TNode root) {
		if(root == null)
			return 0;
		TNode [] childs = root.getChilds();
		int count = 0;
		if(checkChilds(childs))
			return 1;		
		for(int i = 0; i < childs.length; ++i)
			count += countFragments(childs[i]);
		return count;
	}
	
	private static boolean checkChilds(TNode[] childs){
		for(int i = 0; i < childs.length; ++i)
			if(childs[i] != null)
				return false;
		return true;
	}
	
	public TNode getRoot(){
		return root;
	}
}
