
public class BTUtils {

		
		
		// First Method ..
	

	private static boolean leftChecked=false;
	private static boolean rightChecked=false;

	public static <T> int nbLeaf(BT<T> bt, T e) {
			bt.find(Relative.Root);
			if(bt.empty()) {
				return 0;
			}
			 
			 return RecNbLeaf(bt, e,0);
	}

	private static <T> int RecNbLeaf(BT<T> Hash, T e, int i) {
			if(Hash.isLeaf() && Hash.equals(e)) {
				while(Hash.find(Relative.Parent)&& i==2) {
					if(Hash.find(Relative.RightChild))
						break;
				}
				Hash.find(Relative.Parent);
				return 1;
			}
			if(Hash.isLeaf()) {
				
				while(Hash.find(Relative.Parent)&& i==2) {
					if(Hash.find(Relative.RightChild))
						break;
				}
				Hash.find(Relative.Parent);
				return 0;
			}
			return RecNbLeaf2(Hash, e, 1) + RecNbLeaf2(Hash, e, 2);

	
		
}
	private static <T> int RecNbLeaf2(BT<T> Hash, T e, int i) {
;
		if(i==1) {
			
			leftChecked=Hash.find(Relative.LeftChild);
			if(!leftChecked) return 0;
			
			return RecNbLeaf(Hash, e, 1);
		}else {
			rightChecked=Hash.find(Relative.RightChild);
			if(!rightChecked) {
				while(Hash.find(Relative.Parent)&& i==2) {
					if(Hash.find(Relative.RightChild))
						break;
				}
				Hash.find(Relative.Parent);
				return 0;
			}
			
			return RecNbLeaf(Hash, e, 2);
			
			
		}


	
}
//		private static int count = 0;
//		public static <T> int nbLeaf(BT<T> bt, T e) {
//			bt.find(Relative.Root);
//			count = 0;
//			if(bt.empty()) {
//				return 0;
//			}
//			boolean flag = false;
//			boolean leftChecked =false;
//			boolean rightChecked = false;
//			boolean tmpRightCheck1 = false;
//			try {
//				RecNbLeaf(bt, e, flag, leftChecked,rightChecked, tmpRightCheck1);
//				return count ;
//			}catch(Exception E) {
//				return count ;
//			}
//			
//			
//		}
//		private static <T> int RecNbLeaf(BT<T> bt, T e , boolean flag, boolean leftChecked,  boolean rightChecked, boolean tmpRightCheck1) {
//			try {
//				//System.out.println(bt.retrieve());
//				if( bt.isLeaf() ) {
//					if(bt.retrieve().equals(e) ) {
//						//System.out.println(bt.retrieve());
//						bt.find(Relative.Parent);
//						if(flag) {
//							bt.find(Relative.Parent);
//							//bt.find(Relative.RightChild);
//						}
//						count++;
//						return 1;
//					}else {
//						bt.find(Relative.Parent);
//						
//						if(flag) {
//							bt.find(Relative.Parent);
//							//bt.find(Relative.RightChild);
//						}
//						return 0;
//					}
//				}else {
//					if(tmpRightCheck1 && !leftChecked) {
//						bt.find(Relative.Parent);
//						bt.find(Relative.Parent);
//						if(!bt.find(Relative.Parent)) {
//							//bt.find(Relative.LeftChild);
//							bt.find(Relative.RightChild);
//							
//						}else {
//							bt.find(Relative.Parent);
//						}
//						
//					
//					}
//				}
//				
//				
//				return RecNbLeaf2(bt, e, 1, flag, leftChecked, rightChecked,  tmpRightCheck1) + RecNbLeaf2(bt, e, 2, flag, leftChecked, rightChecked,  tmpRightCheck1);
//				
//				
//			}catch(Exception E) {
//				return count;
//			}
//		
//			
//		}
//		private static <T> int RecNbLeaf2(BT<T> bt, T e ,int i, boolean flag, boolean leftChecked, boolean rightChecked, boolean tmpRightCheck1) {
//try {
//	//leftChecked = false;
//	//rightChecked = false;
//	flag = false;
//	if(i==1) {
//		leftChecked = bt.find(Relative.LeftChild);
//		
//		if(!leftChecked)return 0;
//		
//		return RecNbLeaf(bt, e, flag, leftChecked, rightChecked, tmpRightCheck1);
//	}else {
//
//		rightChecked = bt.find(Relative.RightChild);
//		if(rightChecked) {
//			tmpRightCheck1 = true;
//		}
//		flag = true;
//		if (!rightChecked) {
//			
//			bt.find(Relative.Parent);
//		
//			return 0;
//		}
//		
//		return RecNbLeaf(bt, e , flag, leftChecked, rightChecked, tmpRightCheck1);
//	}
//	
//}catch(Exception E) {
//	return 0;
//}
//
//		}
//		
		
//
//	private static int count = 0;
//		public static <T> int nbLeaf(BT<T> bt, T e) {
//		
//		
//			
//				bt.find(Relative.Root);
//				boolean leftCheck=false;
//				boolean rightCheck=false;
//				int where =0;
//				if(bt.empty()) {
//					return 0;
//				}
//				T Tmp = (T)bt.retrieve();
//				return RecNbLeaf(bt, e, leftCheck, rightCheck, where, 0, Tmp);
//			
//
//		
//		
//		
//		}
//
//		
//		private static <T> int RecNbLeaf(BT<T> Hash, T e, boolean leftCheck, boolean rightCheck, int where, int time, T Tmp) {
//
//			if(where==2 && time ==0) {
//				 Tmp = (T)Hash.retrieve();
//			}
//			
//			if(Hash.isLeaf()) {
//				
//				if(Hash.retrieve().equals(e)) {
//			
//					Hash.find(Relative.Parent);
//					if(where==2) {
//						while(!Hash.retrieve().equals(Tmp)) {
//							Hash.find(Relative.Parent);	
//						}
//						Hash.find(Relative.Parent);
//
//			
//						time=0;
//					}
//					return 1;
//				}else {
//					Hash.find(Relative.Parent);
//					if( where==2) {
//						while(!Hash.retrieve().equals(Tmp)) {
//							Hash.find(Relative.Parent);	
//						}
//						Hash.find(Relative.Parent);
//
//						time=0;
//					}
//					return 0;
//				}
//	
//			
//		
//			
//}
//				return	RecNbLeaf2(Hash, e, 1, leftCheck, rightCheck, where, time, Tmp) + RecNbLeaf2(Hash, e, 2, leftCheck, rightCheck, where, time,Tmp) ;	
//		}
//
//		private static <T> int RecNbLeaf2(BT<T> Hash ,T e, int i, boolean leftCheck, boolean rightCheck, int where,int time,T Tmp) {
//			
//			if(i==1) {
//		
//					leftCheck = Hash.find(Relative.LeftChild);
//					where = 1;
//					time = 0;
//				return RecNbLeaf(Hash, e, leftCheck, rightCheck, where, time, Tmp); 
//			}else {
//	
//					rightCheck = Hash.find(Relative.RightChild);	
//					time++;
//					where = 2;
//			
//				
//				return RecNbLeaf(Hash, e, leftCheck, rightCheck, where, time, Tmp);
//				
//				
//			}
//			
//		}
//	
//	
	
		// Second Method ..
	
	
		public static <T> void pruneBranch(BT<T> bt, T e) {	
			bt.find(Relative.Root);
			if(bt.empty()) {
				return;
			}
			boolean flag = false;
			boolean leftChecked =false;
			boolean rightChecked = false;
			boolean tmpRightCheck1 = false;
					recursivePruneBranch(bt, e, flag, leftChecked,rightChecked, tmpRightCheck1);
	}
		
		private static <T> int recursivePruneBranch(BT<T> bt, T e , boolean flag, boolean leftChecked,  boolean rightChecked, boolean tmpRightCheck1) {
			if(bt.retrieve().equals(e) ) {
				bt.deleteSub();
				if(flag) {
					bt.find(Relative.Parent);
					//bt.find(Relative.RightChild);
				}
				return 1;
			}
			if( bt.isLeaf() ) {
	
					
					bt.find(Relative.Parent);
					if(bt.retrieve().equals(e) ) {
						bt.deleteSub();
						if(flag) {
							bt.find(Relative.Parent);
							//bt.find(Relative.RightChild);
						}
						return 1;
					}
					if(flag) {
						bt.find(Relative.Parent);
						//bt.find(Relative.RightChild);
					}
					
					return 1;
			
			}else {
				if(tmpRightCheck1 && !leftChecked) {
					bt.find(Relative.Parent);
					bt.find(Relative.Parent);
					if(!bt.find(Relative.Parent)) {
						//bt.find(Relative.LeftChild);
						bt.find(Relative.RightChild);
						
					}else {
						bt.find(Relative.Parent);
					}
					
				
				}
			}
			if(bt.retrieve().equals(e) ) {
				bt.deleteSub();
				if(flag) {
					bt.find(Relative.Parent);
					//bt.find(Relative.RightChild);
				}
				return 1;
			}

			return checkTrueFalse(bt, e, 1, flag, leftChecked, rightChecked, tmpRightCheck1) + checkTrueFalse(bt, e, 2, flag, leftChecked, rightChecked, tmpRightCheck1);
			
			
			
	}
		private static <T> int checkTrueFalse(BT<T> bt, T e ,int i, boolean flag, boolean leftChecked, boolean rightChecked, boolean tmpRightCheck1) {
			
			//leftChecked = false;
			//rightChecked = false;
			flag = false;
			if(i==1) {
				leftChecked = bt.find(Relative.LeftChild);
				
				if(!leftChecked)return 0;
				
				return recursivePruneBranch(bt, e, flag, leftChecked, rightChecked, tmpRightCheck1);
			}else {
				if(rightChecked) {
					tmpRightCheck1 = true;
				}
				//bt.find(Relative.Parent);
				rightChecked = bt.find(Relative.RightChild);
				flag = true;
				if (!rightChecked) {
					//bt.find(Relative.Parent);
					return 0;
				}
				
				return recursivePruneBranch(bt, e , flag, leftChecked, rightChecked, tmpRightCheck1);
			}
	}
		
	
	
		
	
			public static void main(String[] args) {
				LinkedBT<Integer> c = new LinkedBT<Integer>();
				

				c.insert(10, Relative.Root);
				c.insert(20, Relative.LeftChild);
				c.insert(40, Relative.RightChild);
				c.insert(50, Relative.LeftChild);
				c.find(Relative.Parent);
				c.find(Relative.Parent);
				c.insert(30, Relative.LeftChild);
				c.find(Relative.Root);
				c.insert(50, Relative.RightChild);
				c.insert(60, Relative.LeftChild);
				c.find(Relative.Parent);
				c.insert(70, Relative.RightChild);
				c.insert(45, Relative.LeftChild);
				c.print(c.getRoot());

				System.out.println("===");
				System.out.println(nbLeaf(c, 45));
				

				
				LinkedBT<Integer> g = new LinkedBT<Integer>();

				
				g.insert(10, Relative.Root);
				g.insert(15, Relative.LeftChild);
				g.insert(16, Relative.LeftChild);
				g.find(Relative.Parent);
				g.insert(16, Relative.RightChild);
				g.find(Relative.Root);
				g.insert(17, Relative.RightChild);
				g.insert(10, Relative.LeftChild);
				g.find(Relative.Parent);
				g.insert(16, Relative.RightChild);
				g.insert(17, Relative.LeftChild);
				g.find(Relative.Parent);
				g.insert(16, Relative.RightChild);

				int leaf = nbLeaf(g ,16);
				System.out.println(leaf);

				

				
			}


}
