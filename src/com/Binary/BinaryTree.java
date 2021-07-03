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

	public int getSize() {
		return this.getSizeRecursive(root);
	}

	private int getSizeRecursive(BinaryNode<K> current) {
		return current == null ? 0 : 1 + this.getSizeRecursive(current.left) + this.getSizeRecursive(current.right);
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

	public BinaryNode<K> searchNode(K key) {
		return searchNode(root, key);
	}

	private BinaryNode<K> searchNode(BinaryNode<K> root, K key) {

		if (root == null || root.key == key)
			return root;

		int compareResult = root.key.compareTo(key);
		if (compareResult < 0) {
			return searchNode(root.right, key);
		}

		return searchNode(root.left, key);
	}
}
