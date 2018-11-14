
public class LinkedBT<T> implements BT<T> {

	private BTNode<T> root, current;
	
	public LinkedBT(){
		root = current = null;
	}
	
	
	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}


	public boolean find(Relative rel) {
		switch(rel) {
		
		case Root: 
					current = root;
					return true;
		case Parent: 
					if(current == root) {
						return false;
					}
					current = current.parent; 
					//findparent(current, root);	
					return true;
		case LeftChild:
					if(current.left == null) {
						return false;
					}
					current = current.left;
					return true;
				
		case RightChild: 
					if(current.right == null) {
						return false;
					}
					current = current.right;
					return true;
					
		default: 
					return false;
		}
		
	}

	private BTNode<T> findparent(BTNode<T> p, BTNode<T> t){
		
		if(t==null) {
			return null;
		}
		if(t.right == null && t.left == null) {
			return null;
		} 
		else if(t.right== p && t.right == p){
			return t;
		}
		else {
			BTNode q = findparent(p, t.left);
			if(q != null) {
				return q;
			}
			else {
				
				return findparent(p, t.right);
			}
		}
		
		
	}
	
	public T retrieve() {
		return current.data;
	}


	public void update(T val) {
		current.data = val;
	}

	public boolean insert(T val, Relative rel) {
		switch(rel) {
		
		case Root: 
					if(!empty()) {
						return false;
					}
					
					current = root = new BTNode<T>(val);
					return true;
					
		case Parent: return false;
		case LeftChild:
					if(current.left != null) {
						return false;
					}
					
					current.left = new BTNode<T>(val);
					BTNode<T> Tmp = current;
					current = current.left;
					current.parent =  Tmp;
					return true;
				
		case RightChild: 
					if(current.right != null) {
						return false;
					}
					
					current.right = new BTNode<T>(val);
					BTNode<T> Tmp2 = current;
					current = current.right;
					current.parent =  Tmp2;

					return true;
					
		default: 
					return false;
		}
		
	}

	public void deleteSub() {
		if(empty()) {
			return;
		}
		if(current == root) {
			current = root = null;
		}
		else {
			BTNode<T> p = current;
			//current = p;
			//current = findparent(current,root);
			
			current = current.parent;
			if(current.left == p) {
				current.left = null;
			}else if(current.right == p){
				current.right = null;
				
			}
			
			
		}
		
		
	}

	public boolean isLeaf() {

		
			if(current.left == null && current.right == null) {
				return true;
			}
		
		return false;

	}

	public BTNode<T> getRoot() {
		BTNode<T> Tmp=root;
	return Tmp;
	
	
	}
	
	public int print(BTNode<T> left) {
		if(left==null) {
			return 0;
		}
		 
		if(left.left== null && left.right == null) {
			System.out.println(left.data);

			return 1;
		}
		System.out.println(left.data);
		
		return print(left.left) + print(left.right) + 1;
		
		
		
		
	}

	
}
