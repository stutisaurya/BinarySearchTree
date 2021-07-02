package com.Binary;

public class BinaryTree<K extends Comparable<K>> {

	private BinaryNode<K> root;

	public void add(K key) {
		this.root = addRecursively(root, key); // comparing the present key with the root key
	}

	private BinaryNode<K> addRecursively(BinaryNode<K> current, K key) {
		if (current == null) {
			return new BinaryNode<>(key);
		}
		int compareResult = key.compareTo(current.key);
		if (compareResult == 0) {
			return current;
		}
		if (compareResult < 0) {
			current.left = addRecursively(current.left, key);
		} else {
			current.right = addRecursively(current.right, key);
		}
		return current;
	}

	public void displayNode() {
		displayNode(root);
	}

	public void displayNode(BinaryNode<K> root) {
		if (root != null) {
			displayNode(root.left);
			System.out.println(root.key);
			displayNode(root.right);
		}
	}

}
