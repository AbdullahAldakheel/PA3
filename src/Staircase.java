
public class Staircase {
	public static BT<Integer> getTree(int n, int k1, int k2) {
		LinkedBT<Integer> haShm = new LinkedBT<Integer>();
		if(k1>0 && k2>k1) {
			haShm.insert(0, Relative.Root);
			boolean leftCheck=true;
			boolean rightCheck=false;
			getTreeRec(haShm, k1, k2, n, leftCheck, rightCheck);
		}

	
	return haShm;
	
	}
	
	private static int getTreeRec(BT<Integer> Hash, int k1, int k2, int n, boolean leftCheck, boolean rightCheck) {
		if((int)Hash.retrieve() >= n) {
			Hash.find(Relative.Parent);
			//Hash.find(Relative.Parent);
			return 0;	
		}
		if(!leftCheck) {
			return 0;
		}
		if(!rightCheck) {
			Hash.find(Relative.Parent);
			

		}
			return	getTreeCheck(Hash, k1, k2, n, 1, leftCheck, rightCheck) + getTreeCheck(Hash, k1, k2, n, 2, leftCheck, rightCheck) ;	
	}
	
	private static int getTreeCheck(BT<Integer> Hash, int k1, int k2, int n, int i, boolean leftCheck, boolean rightCheck) {
		leftCheck = true;
		rightCheck = true;
		if(i==1) {
			if(Hash.retrieve()+k1 > n) return 0;
			
			leftCheck = Hash.insert(Hash.retrieve()+k1, Relative.LeftChild);
			return getTreeRec(Hash,k1, k2, n, leftCheck, rightCheck); 
		}else {
			
			if(Hash.retrieve()+k2 > n) {
				Hash.find(Relative.Parent);
				return 0;
			}
			
			rightCheck = Hash.insert(Hash.retrieve()+k2, Relative.RightChild);
			return getTreeRec(Hash,k1, k2, n, leftCheck, rightCheck);
			
			
		}
		
	}
	
	
	
	


	public static BT<Integer> getTreeWithout(int n, int k1, int k2, int k) {
		LinkedBT<Integer> haShm ;

		haShm = (LinkedBT<Integer>) getTree(n, k1, k2);
		BTUtils B = new BTUtils();
		B.pruneBranch(haShm, k);
		return haShm;
	}

	public static int getNbSol(int n, int k1, int k2) {
	
			LinkedBT<Integer> haShm =  (LinkedBT<Integer>) getTree(n, k1, k2);
			BTUtils B = new BTUtils();
			
			return B.nbLeaf(haShm, n);
			


	
	}

	public static int getNbSolWithout(int n, int k1, int k2, int k) {
		LinkedBT<Integer> haShm =  (LinkedBT<Integer>) getTreeWithout(n, k1, k2, k);
		BTUtils B = new BTUtils();
		return B.nbLeaf(haShm, n);
		
	}

	
	
	public static void main(String[] args) {
		
		
		LinkedBT<Integer> T = (LinkedBT<Integer>) getTree(20,1,2);
		
	
		
		//T.print(T.getRoot());
		System.out.println("===");
		int k =getNbSol(4,1,2);
		System.out.println("===");
		System.out.println(k);
		
		//LinkedBT<Integer> T1 = (LinkedBT<Integer>)getTreeWithout(6,1,2,3);
		//T1.print(T1.getRoot());
		//System.out.println("===");
		//System.out.println(getNbSolWithout(6,1,2,3));
	}
}
