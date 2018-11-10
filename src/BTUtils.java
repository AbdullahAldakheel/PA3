
public class BTUtils {

		
		
		// First Method ..

		public static <T> int nbLeaf(BT<T> bt, T e) {
			bt.find(Relative.Root);
			if(bt.empty()) {
				return 0;
			}
			boolean flag = false;
			boolean leftChecked =false;
			boolean rightChecked = false;
			return RecNbLeaf(bt, e, flag, leftChecked,rightChecked);
			//return count ;
		}
		private static <T> int RecNbLeaf(BT<T> bt, T e , boolean flag, boolean leftChecked,  boolean rightChecked) {
			if( bt.isLeaf() ) {
				if(bt.retrieve().equals(e) ) {
					System.out.println(bt.retrieve());
					bt.find(Relative.Parent);
					if(flag) {
						bt.find(Relative.Parent);
						//bt.find(Relative.RightChild);
					}
					
					return 1;
				}else {
					bt.find(Relative.Parent);
					
					if(flag) {
						bt.find(Relative.Parent);
						//bt.find(Relative.RightChild);
					}
					return 0;
				}
			}
			
			
			return RecNbLeaf2(bt, e, 1, flag, leftChecked, rightChecked) + RecNbLeaf2(bt, e, 2, flag, leftChecked, rightChecked);
			
			
			
		}
		private static <T> int RecNbLeaf2(BT<T> bt, T e ,int i, boolean flag, boolean leftChecked, boolean rightChecked) {
			leftChecked = false;
			rightChecked = false;
			flag = false;
			if(i==1) {
				leftChecked = bt.find(Relative.LeftChild);
				
				if(!leftChecked)return 0;
				
				return RecNbLeaf(bt, e, flag, leftChecked, rightChecked);
			}else {
				//bt.find(Relative.Parent);
				rightChecked = bt.find(Relative.RightChild);
				flag = true;
				if (!rightChecked)return 0;
				
				return RecNbLeaf(bt, e , flag, leftChecked, rightChecked);
			}
		}
		
		



		// Second Method ..
	
	
		public static <T> void pruneBranch(BT<T> bt, T e) {	
		bt.find(Relative.Root);
		recursivePruneBranch(bt, e);
		if(bt.find(Relative.Root)) {
			recursivePruneBranch2(bt, e);
		}
	}
		
		private static <T> int recursivePruneBranch(BT<T> bt, T e) {
		
		if(bt.empty()) {
			return 0;
		}
		if(bt.isLeaf()) {
						if(bt.retrieve().equals(e)) {
							bt.deleteSub();
						
							return 1;
						}else {
							
							return 0;
						}
		}else {
			if(bt.retrieve().equals(e)) {
				bt.deleteSub();
				return 1;
			}
			
			
				return checkTrueFalse(bt, e, 1) + checkTrueFalse(bt, e, 2) ;
				//+ checkTrueFalse(bt.find(Relative.RightChild), bt, e, 2);
			
		}
	}
		private static <T> int checkTrueFalse(BT<T> bt, T e, int i) {
		if(i==1) {
			bt.find(Relative.LeftChild);

			return recursivePruneBranch(bt, e);
		}else {
			bt.find(Relative.RightChild);

			return recursivePruneBranch(bt, e);
		}
	}
		
		private static <T> int recursivePruneBranch2(BT<T> bt, T e) {
			if(bt.empty()) {
				return 0;
			}
			if(bt.isLeaf()) {
							if(bt.retrieve().equals(e)) {
								System.out.println("leaf deleted");
								bt.deleteSub();
							
								return 1;
							}else {
								
								return 0;
							}
			}else {
				if(bt.retrieve().equals(e)) {
					bt.deleteSub();
					System.out.println("D");
					return 1;
				}
				
				
					return checkTrueFalse2(bt, e, 1) + checkTrueFalse2(bt, e, 2) ;
					//+ checkTrueFalse(bt.find(Relative.RightChild), bt, e, 2);
				
			}
		}
		private static <T> int checkTrueFalse2(BT<T> bt, T e, int i) {
			if(i==1) {
				bt.find(Relative.RightChild);

				return recursivePruneBranch2(bt, e);
			}else {
				bt.find(Relative.LeftChild);

				return recursivePruneBranch2(bt, e);
			}
		}


//		if(find) {
//			
//			if(i==1) {
//				return RecurNbLeaf(bt, e);
//			}else {
//				bt.find(Relative.Parent);
//				//bt.find(Relative.Parent);
//				//bt.find(Relative.LeftChild);
//				return RecurNbLeaf(bt, e);
//			}
//			
//		}else if(!find) {
//			if(i==2) {
//				bt.find(Relative.Parent);
//				bt.find(Relative.LeftChild);
//				return RecurNbLeaf(bt, e);
//			}
//		}
//		return 0;
		/*
		if(find) {
			
			if(i==1) {
				 return recursivePruneBranch(bt, e);
			}else {
				
			//	bt.find(Relative.Parent);
			//bt.find(Relative.Parent);

			//bt.find(Relative.LeftChild);
				return recursivePruneBranch(bt, e);
				

			}
			
		}else if(!find) {
			if(i==2) {
				bt.find(Relative.Parent);
				bt.find(Relative.LeftChild);
				return recursivePruneBranch(bt, e);
			}else {
				return 0;	
				}
		}
		return 0;
	*/
	
	
		
	
			public static void main(String[] args) {
				LinkedBT<Integer> c = new LinkedBT<Integer>();
				

				c.insert(10, Relative.Root);
			
				c.insert(20, Relative.LeftChild);
				c.insert(180, Relative.RightChild);
				c.find(Relative.Parent);
				c.insert(30, Relative.LeftChild);
				c.find(Relative.Root);
				c.insert(50, Relative.RightChild);
				c.insert(30, Relative.RightChild);
				c.find(Relative.Parent);
				c.insert(30, Relative.LeftChild);
				c.insert(60, Relative.RightChild);
				c.insert(120, Relative.LeftChild);
				c.insert(180, Relative.RightChild);
				c.print(c.getRoot());
				System.out.println("===");
				System.out.println(nbLeaf(c, 180));

			}


}
