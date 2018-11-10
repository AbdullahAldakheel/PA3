
public class BTUtils {

		
		
		// First Method ..
		private static int count = 0;
		public static <T> int nbLeaf(BT<T> bt, T e) {
			bt.find(Relative.Root);
			count = 0;
			if(bt.empty()) {
				return 0;
			}
			boolean flag = false;
			boolean leftChecked =false;
			boolean rightChecked = false;
			boolean tmpRightCheck1 = false;
			try {
				RecNbLeaf(bt, e, flag, leftChecked,rightChecked, tmpRightCheck1);
				return count ;
			}catch(Exception E) {
				
			}
			return count ;
			
		}
		private static <T> int RecNbLeaf(BT<T> bt, T e , boolean flag, boolean leftChecked,  boolean rightChecked, boolean tmpRightCheck1) {
			try {
				//System.out.println(bt.retrieve());
				if( bt.isLeaf() ) {
					if(bt.retrieve().equals(e) ) {
						//System.out.println(bt.retrieve());
						bt.find(Relative.Parent);
						if(flag) {
							bt.find(Relative.Parent);
							//bt.find(Relative.RightChild);
						}
						count++;
						return 1;
					}else {
						bt.find(Relative.Parent);
						
						if(flag) {
							bt.find(Relative.Parent);
							//bt.find(Relative.RightChild);
						}
						return 0;
					}
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
				
				
				return RecNbLeaf2(bt, e, 1, flag, leftChecked, rightChecked,  tmpRightCheck1) + RecNbLeaf2(bt, e, 2, flag, leftChecked, rightChecked,  tmpRightCheck1);
				
				
			}catch(Exception E) {
				return count;
			}
		
			
		}
		private static <T> int RecNbLeaf2(BT<T> bt, T e ,int i, boolean flag, boolean leftChecked, boolean rightChecked, boolean tmpRightCheck1) {
try {
	//leftChecked = false;
	//rightChecked = false;
	flag = false;
	if(i==1) {
		leftChecked = bt.find(Relative.LeftChild);
		
		if(!leftChecked)return 0;
		
		return RecNbLeaf(bt, e, flag, leftChecked, rightChecked, tmpRightCheck1);
	}else {

		rightChecked = bt.find(Relative.RightChild);
		if(rightChecked) {
			tmpRightCheck1 = true;
		}
		flag = true;
		if (!rightChecked) {
			
			bt.find(Relative.Parent);
		
			return 0;
		}
		
		return RecNbLeaf(bt, e , flag, leftChecked, rightChecked, tmpRightCheck1);
	}
	
}catch(Exception E) {
	return 0;
}

		}
		
		
//
//	private static int count = 0;
//	public static <T> int nbLeaf(BT<T> bt, T e) {
//		count=0;
//		bt.find(Relative.Root);
//		if(bt.empty()) {
//			return 0;
//		}
//		boolean Right=true;
//		 RecNbLeaf(bt,e, Right);
//		return count;
//
//	}
//	private static <T> int RecNbLeaf(BT<T> bt, T e, boolean Right) {
//		System.out.println(bt.retrieve());
//		if(bt.isLeaf()) {
//			if(bt.retrieve()==e) {
//				count++;
//				if(!Right) {
//					//bt.find(Relative.Parent);
//				}
//				bt.find(Relative.Parent);
//				return 1;
//			}
//			bt.find(Relative.Parent);
//			if(!Right) {
//				//bt.find(Relative.Parent);
//			}
//			return 0;
//		}
//	
//		
//		return RecNbLeaf2(bt, e, 1, Right) + RecNbLeaf2(bt, e, 2, Right);
//		
//		
//	}
//	
//	private static <T> int RecNbLeaf2(BT<T> bt, T e, int i, boolean Right) {
//		Right = true;
//		if(i==1) {
//			bt.find(Relative.LeftChild);
//			return RecNbLeaf(bt ,e ,Right);
//		}else {
//			
//			bt.find(Relative.Parent);
//			Right = bt.find(Relative.RightChild);
//			if(!Right) {
//				return 0;
//			}
//			return RecNbLeaf(bt ,e ,Right);
//			
//			
//		}
//	}
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
					recursivePruneBranch(bt, e, flag, leftChecked,rightChecked);
	}
		
		private static <T> int recursivePruneBranch(BT<T> bt, T e , boolean flag, boolean leftChecked,  boolean rightChecked) {
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
					if(flag) {
						bt.find(Relative.Parent);
						//bt.find(Relative.RightChild);
					}
					
					return 1;
			
			}
			

			return checkTrueFalse(bt, e, 1, flag, leftChecked, rightChecked) + checkTrueFalse(bt, e, 2, flag, leftChecked, rightChecked);
			
			
			
	}
		private static <T> int checkTrueFalse(BT<T> bt, T e ,int i, boolean flag, boolean leftChecked, boolean rightChecked) {
			
			leftChecked = false;
			rightChecked = false;
			flag = false;
			if(i==1) {
				leftChecked = bt.find(Relative.LeftChild);
				
				if(!leftChecked)return 0;
				
				return recursivePruneBranch(bt, e, flag, leftChecked, rightChecked);
			}else {
				//bt.find(Relative.Parent);
				rightChecked = bt.find(Relative.RightChild);
				flag = true;
				if (!rightChecked)return 0;
				
				return recursivePruneBranch(bt, e , flag, leftChecked, rightChecked);
			}
	}
		
	
	
		
	
			public static void main(String[] args) {
				LinkedBT<Integer> c = new LinkedBT<Integer>();
				

				c.insert(10, Relative.Root);
			
				c.insert(20, Relative.LeftChild);
				
				c.insert(40, Relative.RightChild);
				c.find(Relative.Parent);
				c.insert(30, Relative.LeftChild);
				
				c.find(Relative.Root);
				c.insert(50, Relative.RightChild);
				c.insert(60, Relative.LeftChild);
				c.find(Relative.Parent);
				c.insert(70, Relative.RightChild);
				
				c.print(c.getRoot());

				System.out.println("===");
				System.out.println(nbLeaf(c, 30));
				
				//pruneBranch(c,30);
				System.out.println("===");
			}


}
