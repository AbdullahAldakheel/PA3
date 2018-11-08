
public class BTUtils {


		// First Method ..

	public static <T> int nbLeaf(BT<T> bt, T e) {
		bt.find(Relative.Root);
		int c=0;
		return RecurNbLeaf(bt, e);
	
	}
	
	
	private static <T> int RecurNbLeaf(BT<T> bt, T e) {
		BT<T> Tmp = bt;
		if(bt.empty()) {
			return 0;
		}
		if(bt.isLeaf()) {
			if(bt.retrieve().equals(e)) {
				return 1;
			}else {
				return 0;
			}
		}
			if(Tmp.isLeaf()) {
				if(Tmp.retrieve().equals(e)) {
					return 1;
				}else {
					return 0;
				}
		}
		
				
			return checkRightLift(bt.find(Relative.RightChild),bt, e, 1) + checkRightLift(bt.find(Relative.LeftChild), bt, e, 2);		
		
			}
	
	private static <T> int checkRightLift(boolean find, BT<T> bt, T e, int i) {
		if(find) {
			
			if(i==1) {
				return RecurNbLeaf(bt, e);
			}else {
				bt.find(Relative.Parent);
				bt.find(Relative.Parent);
				bt.find(Relative.LeftChild);
				return RecurNbLeaf(bt, e);
			}
			
		}else if(!find) {
			if(i==2) {
				bt.find(Relative.Parent);
				bt.find(Relative.LeftChild);
				return RecurNbLeaf(bt, e);
			}
		}
		return 0;
	}

		// Second Method ..
	
	
	public static <T> void pruneBranch(BT<T> bt, T e) {

		
		bt.find(Relative.Root);
		recursivePruneBranch(bt, e);
		

		
		
		
		
		
		
		
		
	}
	private static <T> void recursivePruneBranch(BT<T> bt, T e) {
		boolean G = true;
		if(bt.empty()) {
			return;
		}
		if(bt.isLeaf()) {
						if(bt.retrieve().equals(e)) {
							System.out.println("leaf deleted");
							G = false;
							bt.deleteSub();
						
							return;
						}else {
				
							return;
						}
		}else {
			if(bt.retrieve().equals(e)) {
				bt.deleteSub();
				System.out.println("D");
				return;
			}
			System.out.println("here");

			
				checkTrueFalse(bt.find(Relative.RightChild), bt, e, 1);
				System.out.println("del");
				
				checkTrueFalse(G, bt, e, 2);
				
			
		}
	}

	private static <T> boolean checkTrueFalse(boolean find,BT<T> bt, T e, int i) {
		if(find) {
			
			if(i==1) {
				 recursivePruneBranch(bt, e);
			}else {
				
				bt.find(Relative.Parent);
				
				bt.find(Relative.LeftChild);
				recursivePruneBranch(bt, e);
			}
			
		}else if(!find) {
			if(i==2) {
				
				bt.find(Relative.LeftChild);
				recursivePruneBranch(bt, e);
			}else {
				System.out.println("efwwefe");
			}
		}
		return true;
	}
	
	public static <T> void print(BT<T> bt){
		if(bt.empty()) {
			return ;
		}
		if(bt.isLeaf()) {
			System.out.println(bt.retrieve());
			return;
		}
		
		
		BT<T> Tmp = bt;
		System.out.println(bt.retrieve());
		bt.find(Relative.LeftChild);
		Tmp.find(Relative.RightChild);
		
			 print(bt) ;
				//System.out.println(Tmp.retrieve());

			 print(Tmp);
			
			
			
		}
	
			public static void main(String[] args) {
		
				LinkedBT BT = new LinkedBT();

				BT.insert(10, Relative.Root);
				System.out.println(BT.insert(30, Relative.LeftChild));
				BT.find(Relative.Root);
				System.out.println(BT.insert(20, Relative.RightChild));
				BT.find(Relative.Root);
				print(BT);
				pruneBranch(BT,30);
				System.out.println("delete");
				BT.find(Relative.Root);
				BT.toString();
				
			}


}
