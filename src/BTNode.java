class BTNode<T> {
	public T data;
	public BTNode<T> left, right, parent;

	public BTNode(T data) {
		this.data = data;
		parent = left = right = null;
	}
	

	public BTNode(T data, BTNode<T> l, BTNode<T> r, BTNode<T> p) {
		this.data = data;
		parent = p;
		right = r;
		left = l;
	}
}
