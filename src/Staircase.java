
public class Staircase {
	public static BT<Integer> getTree(int n, int k1, int k2) {
		LinkedBT<Integer> haShm = new LinkedBT<Integer>();
		haShm.insert(0, Relative.Root);
		getTreeRec(haShm, k1, k2, n);
	
	return haShm;
	
	}
	
	private static int getTreeRec(BT<Integer> Hash, int k1, int k2, int n) {
		if(Hash.retrieve()>= n) {
			Hash.find(Relative.Parent);
			return 0;
		}
		
			return	getTreeRec(Hash, k1, k2, n, 1) + getTreeRec(Hash, k1, k2, n, 2) ;
				
				//
				
		
	}
	public static int getTreeRec(BT<Integer> Hash, int k1, int k2, int n, int i) {
		
		if(i==1) {
			Hash.insert(Hash.retrieve()+k1, Relative.LeftChild);
			return getTreeRec(Hash, k1, k2, n);
		}else {
			
				Hash.insert(Hash.retrieve()+k2, Relative.RightChild);
				return getTreeRec(Hash, k1, k2, n);
		}
		
		
	}

	public static BT<Integer> getTreeWithout(int n, int k1, int k2, int k) {
		return null;
	}

	public static int getNbSol(int n, int k1, int k2) {
		return 0;
	}

	public static int getNbSolWithout(int n, int k1, int k2, int k) {
		return 0;
	}

	
	
	public static void main(String[] args) {
		
		
		LinkedBT<Integer> T = (LinkedBT<Integer>) getTree(4,1,2);
		
		T.print(T.getRoot());
		
		
	}
}
