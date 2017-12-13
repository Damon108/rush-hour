package mtr;

import java.util.Iterator;

class PathFinderTreeNode<E> {
	public E element;
	public PathFinderTreeNode<E> left;
	public PathFinderTreeNode<E> right;

	// Constructor for creating a leaf node
	public PathFinderTreeNode(E element) {
		this.element = element;
		left = null;
		right = null; // no children
	}

	// Constructor for creating a parent node
	public PathFinderTreeNode(E element, PathFinderTreeNode<E> left, PathFinderTreeNode<E> right) 
	{
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}
}
