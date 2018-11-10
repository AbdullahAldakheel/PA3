
public class BTUtils {

		
		private static int count=0;
		// First Method ..

		public static <T> int nbLeaf(BT<T> bt, T e) {
			bt.find(Relative.Root);
			T Tmp = bt.retrieve();

			int tm = RecNbLeaf(bt, e, Tmp);
			tm += RecNbLeaf2(bt, e, Tmp);
			return tm ;
			
		}
		private static <T> int RecNbLeaf(BT<T> bt, T e , T Tmp) {
			if(bt.empty()) {
				return 0;
			}
			if( bt.isLeaf() ) {
				if(bt.retrieve().equals(e)) {
					return 1;
				}else {
					return 0;
				}
			}
			
			count++;
			return RecNbLeaf2(bt, e, 1, Tmp) + RecNbLeaf2(bt, e, 2, Tmp);
			
			
			
		}
		private static <T> int RecNbLeaf2(BT<T> bt, T e ,int i,T Tmp) {
			if(i==1) {
				bt.find(Relative.LeftChild);
				return RecNbLeaf(bt, e, Tmp);
			}else {
				bt.find(Relative.Parent);
				if(bt.retrieve().equals(Tmp)) {
					return 0;
				}
				bt.find(Relative.RightChild);
				return RecNbLeaf(bt, e, Tmp);
			}
		}
		
		private static <T> int RecNbLeaf2(BT<T> bt, T e , T Tmp) {
			if(bt.empty()) {
				return 0;
			}
			if( bt.isLeaf() ) {
				if(bt.retrieve().equals(e)) {
					return 1;
				}else {
					return 0;
				}
			}
			
			count++;
			return RecNbLeaf22(bt, e, 1, Tmp) + RecNbLeaf22(bt, e, 2, Tmp);
			
			
			
		}
		private static <T> int RecNbLeaf22(BT<T> bt, T e ,int i,T Tmp) {
			if(i==1) {
				bt.find(Relative.RightChild);
				return RecNbLeaf2(bt, e, Tmp);
			}else {
				bt.find(Relative.Parent);
				if(bt.retrieve().equals(Tmp)) {
					return 0;
				}
				bt.find(Relative.LeftChild);
				return RecNbLeaf2(bt, e, Tmp);
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
				c.insert(15, Relative.LeftChild);
				c.insert(30, Relative.LeftChild);
				c.find(Relative.Parent);
				c.insert(50, Relative.RightChild);
				c.find(Relative.Root);
				c.insert(17, Relative.RightChild);
				c.insert(14, Relative.LeftChild);
				c.find(Relative.Parent);
				c.insert(16, Relative.RightChild);
				c.insert(17, Relative.LeftChild);
				c.find(Relative.Parent);
				c.insert(16, Relative.RightChild);

				int leaf = nbLeaf(c ,50);
				System.out.println(leaf);
				

//				LinkedBT<Integer> c = new LinkedBT<Integer>();
				

//				c.insert(10, Relative.Root);
//				c.insert(15, Relative.LeftChild);
//				c.insert(16, Relative.LeftChild);
//				c.find(Relative.Parent);
//				c.insert(16, Relative.RightChild);
//				c.insert(6, Relative.RightChild);
//				c.insert(5, Relative.RightChild);
//				c.insert(4, Relative.RightChild);
//				c.insert(3, Relative.RightChild);
//				c.insert(2, Relative.RightChild);
//				c.insert(1, Relative.RightChild);
//				c.find(Relative.Root);
//				c.insert(17, Relative.RightChild);
//				c.insert(10, Relative.LeftChild);
//				c.find(Relative.Parent);
//				c.insert(16, Relative.RightChild);
//				c.insert(17, Relative.LeftChild);
//				c.find(Relative.Parent);
//				c.insert(16, Relative.RightChild);
//				c.insert(6, Relative.RightChild);
//				c.insert(5, Relative.RightChild);
//				c.insert(4, Relative.RightChild);
//				c.insert(3, Relative.RightChild);
//				c.insert(2, Relative.RightChild);
//				c.insert(1, Relative.RightChild);
				

//				c.insert(1, Relative.Root);
//				c.insert(2, Relative.RightChild);
//				c.insert(3, Relative.RightChild);
//				c.insert(4, Relative.RightChild);
//				c.insert(5, Relative.RightChild);
//				c.insert(6, Relative.RightChild);
//				c.insert(7, Relative.RightChild);
//				c.insert(8, Relative.RightChild);
//				c.insert(9, Relative.RightChild);
//				c.find(Relative.Root);
//				c.insert(1, Relative.Root);
//				c.insert(2, Relative.LeftChild);
//				c.insert(3, Relative.LeftChild);
//				c.insert(4, Relative.LeftChild);
//				c.insert(5, Relative.LeftChild);
//				c.insert(6, Relative.LeftChild);
//				c.insert(7, Relative.LeftChild);
//				c.insert(8, Relative.LeftChild);
//				c.insert(9, Relative.LeftChild);
				


				//int leaf = nbLeaf(c ,9);


				


			}


}
