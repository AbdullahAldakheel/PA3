
public class BTUtils {


	Relative Root=null, LeftChild = null, Parent=null;
	static Relative RightChild=null;
	public static <T> int nbLeaf(BT<T> bt, T e) {
		//BT<T> bt;
		Relative Root=null, LeftChild = null, Parent=null,RightChild=null;
		int C = 0;
		
		boolean A = bt.find(Root);
		T Tmp = bt.retrieve();
		if(bt.isLeaf()) {
			if(bt.retrieve().equals(e)) {
				C++;
				return C;
			}
			
			while(bt.find(LeftChild) && !bt.isLeaf());
				
			if(bt.retrieve().equals(e)) {
				C++;
			}
			bt.find(Parent);
			while(bt.retrieve() != Tmp) {
				if(bt.find(RightChild)) {
					if(bt.isLeaf()) {
						if(bt.retrieve().equals(e)) {
							C++;
						}
				}
				
				bt.find(Parent);
				bt.find(Parent);
			}
		
			

			
			
			
			
			
			
		}
		}
		return C;

			
		
	}
	
	
	private static <T> int Recursive(BT<T> A, BT<T> B) {
		

		if(B.empty()) {
			return 0;
		}
		if(B.find(RightChild)) {
			
		}
		
	}

	public static <T> void pruneBranch(BT<T> bt, T e) {

	}
}
