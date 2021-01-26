/*
* Name: JO SUNG HYEON
* Student ID #: 2016147008
*/

import java.lang.Math;
import java.util.Comparator;
/*
* Do NOT import additional packages/classes.
* If you (un)intentionally use packages/classes we did not provide,
* you will get 0.
*/


public class Tree<K> implements ITree<K> {
	TreeNode<K> root;
	Comparator<K> comp;
	int numItems;
	

	
	public Tree(Comparator<K> comp) {
		/*
        * Constructor.
        *
        * Note that we will check the number of compare calls;
        * if the count is too low or too high (depending on cases),
        * you will fail the case.
        */
		this.root = new TreeNode<K>();
		this.comp = comp;
		this.numItems = 0;
		
		
	}
	@Override
	public TreeNode<K> root()
		throws IllegalStateException {
		/*
        * Return the root node.
        * If there is no root, raise an IllegalStateException.
        */
		if(root == null) {
			throw new IllegalStateException();
		}else {
			return root;
		}
	}

	@Override
	public TreeNode<K> insert(K key) {
		/*
        * Insert the given key at the appropriate node
        * with correct position and return the node.
        * You need to handle the cases of 'overflow' and
        * perform a split operation.
        * Note that you do not need to consider the case of inserting
        * the key that is already in the tree. As stated in the
        * guideline, we will only insert the key that is not in the
        * tree.
        */
		TreeNode<K> cursor = root;
		
		while(!isLeaf(cursor) || cursor.numKeys() == 3) { 
			if(cursor.numKeys() == 3) { 
				split(cursor);
				cursor = root;
			}
			int index = findLocation(cursor, key); 
			cursor = cursor.getChild(index); 
			
		}
		
		int index = 0;
		for(int i = 0; i < cursor.numKeys(); i++) {
			if(comp.compare(cursor.getKey(i), key) <= 0) {
				index = i + 1;
			}
		}
		
		cursor.insertKey(index, key);
		numItems++;
		return cursor;
	}

	@Override
	public void delete(K key) {
		/*
        * Find the node with a given key and delete the key.
        * You need to handle the cases of 'underflow' and
        * perform a fusion operation.
        * If there is no "key" in the tree, please ignore it.
        */
		
		
		/*
		 * Case1: Element is in a leaf Node that contains at least 2 keys -> delete
		 * 
		 * Case2: Element is an internal Node:
		 * 1. left child has 2 keys: replace with predecessor and delete it
		 * 2. right child has 2 keys: replace with successor and delete it
		 * 3. Both children has 1 key: Merge
		 * 
		 * Case3: Element is not an internal Node
		 * 1. if the Child Node has 1 key and a sibling has at least 2 keys:
		 * move rotate sibling element into the parent and parent element into the
		 * element you are deleting
		 * 2. If both child nodes are siblings with 1 key each: merge the two children and the
		 * parent element
		 * 
		 *
		 */
		
		if(search(key)) {
			// merging down
			TreeNode<K> path = traverse(key);
			
			for(int i = path.numChildren() -1; i >= 0; i--) {
				if(isLeaf(path.getChild(i))) break;
				else if(needMerge(path.getChild(i))) {
					merge1(path.getChild(i));
					break;
					
				}
			}
			TreeNode<K> deleteNode = findNode(key);
			if(numItems == 1) {
				deleteNode = findNode(key);
				deleteNode.removeKey(findItem(deleteNode,key));
				root = null;
				numItems--;
			}
			else {
				// Case1
				if(isLeaf(deleteNode)) {
					if(deleteNode.numKeys() > 1) {
						deleteNode.removeKey(findItem(deleteNode,key));
					}else { // Case3
						TreeNode<K> sibling = findSb(deleteNode);
						if(findSb(deleteNode).numKeys() == 1) {
							shrinkTree(deleteNode,sibling);
							deleteNode = findNode(key);
							deleteNode.removeKey(findItem(deleteNode,key));

						}else {
							rotate(deleteNode,sibling);
							deleteNode = findNode(key);
							deleteNode.removeKey(findItem(deleteNode,key));

						}
						
					}
				}
				else { // Case2 
					int idx = findItem(deleteNode,key);
					if(deleteNode.getChild(idx).numKeys() == 1 
							&& deleteNode.getChild(idx+1).numKeys() == 1) {
						
						TreeNode<K> temp = new TreeNode<K>();
						temp.insertKey(0, deleteNode.getChild(idx).getKey(0));
						temp.insertKey(1, deleteNode.getKey(idx));
						temp.insertKey(2, deleteNode.getChild(idx+1).getKey(0));
						deleteNode.removeChild(idx);
						deleteNode.insertChild(idx, temp);
						deleteNode.removeKey(idx);
						
						deleteNode.removeChild(idx+1);
						
						temp.setParent(deleteNode);
						deleteNode = temp;
						deleteNode.removeKey(findItem(deleteNode,key));
					}
					else if(deleteNode.getChild(idx).numKeys() 
							>= 2) {
						int num = deleteNode.getChild(idx).numKeys();
						K pred = deleteNode.getChild(idx).getKey(num-1);
						
						deleteNode.removeKey(idx);
						deleteNode.insertKey(idx, pred);
						deleteNode.getChild(idx).removeKey(num-1);
					}else {
						K pred = deleteNode.getChild(idx+1).getKey(0);
						deleteNode.removeKey(idx);
						deleteNode.insertKey(idx, pred);
						deleteNode.getChild(idx+1).removeKey(0);
					}
				}
				numItems--;
			}
		}
	}

	@Override
	public boolean search(K key) {
		/*
		* Find a node with a given key and return true if you can find it.
		* Return false if you cannot.
		*/
	
		TreeNode<K> node = findNode(key);
		int index = findLocation(node, key);

		if (index == node.numKeys()) {
			index = index - 1;
		}

		if (node.getKey(index).equals(key)) {
			return true;
		} else {
			return false;
		}
	}

	

	@Override
	public int size() {
		/*
		* Return the number of keys in the tree.
		*/
		return numItems;
	}
	
	@Override
	public boolean isEmpty() {
		/*
		* Return whether the tree is empty or not.
		*/
		return (numItems == 0);
	}
	
	public int findItem(TreeNode<K> node, K key) {
		for(int i = 0; i < node.numKeys(); i++) {
			if(node.getKey(i).equals(key))
				return i;
		}
		return -1;
	}
	
	public int findLocation(TreeNode<K> node, K key) {
		for(int i = 0; i < node.numKeys(); i++) {
			if(comp.compare(node.getKey(i), key) >= 0) {
				return i;
			}else if(i == node.numKeys()-1) {
				return i+1;	
			}
		}
		return -1;
	}
	
	public TreeNode<K> findNode(K key){
		K cursor;
		TreeNode<K> cursorNode = root;
		
		while(!isLeaf(cursorNode)) {
			
			int idx = findLocation(cursorNode, key);
			
			if(idx == cursorNode.numKeys()) {
				cursor = cursorNode.getKey(idx - 1);
			}else {
				cursor = cursorNode.getKey(idx);
			}
			
			if(cursor.equals(key))
				break;
			else
				cursorNode = cursorNode.getChild(idx);
		}
		return cursorNode;
	}	

	public boolean isFull(TreeNode<K> node) {
		return (node.numKeys() == 3);
	}
	
	public boolean needMerge(TreeNode<K> node) {
		if(node.numKeys() == 1) {
			if(node.getChild(0).numKeys() == 1 && node.getChild(1).numKeys() == 1) {
				return true;
			}
		}
		return false;
	}
	
	public void split(TreeNode<K> current) {
		TreeNode<K> parent;	
		
		if(current.equals(root)) {
			parent = new TreeNode<K>();
			parent.insertChild(0, current);
			current.setParent(parent);
			root = parent;
		}else { 
			parent = current.getParent();
		}
		
		int childIndex = childLocation(current); 
		parent.insertKey(childIndex, current.getKey(1));
		parent.removeChild(childIndex); 
		
		TreeNode<K> left = new TreeNode<>(); 
		left.insertKey(0, current.getKey(0)); 
		
		TreeNode<K> right = new TreeNode<K>(); 
		right.insertKey(0, current.getKey(2)); 

		if(!isLeaf(current)) { 
			left.insertChild(0,current.getChild(0));
			left.insertChild(1,current.getChild(1));
			current.getChild(0).setParent(left);
			current.getChild(1).setParent(left);

			right.insertChild(0, current.getChild(2));
			right.insertChild(1, current.getChild(3));			
			current.getChild(2).setParent(right);
			current.getChild(3).setParent(right);
		
		}
		
		left.setParent(parent);
		right.setParent(parent);
		parent.insertChild(childIndex, left);
		parent.insertChild(childIndex+1, right);

		
	}
	
	
	public int childLocation(TreeNode<K> node) {
		TreeNode<K> parent = node.getParent();
		int nodeIdx;
		for(nodeIdx = 0; nodeIdx < parent.numChildren(); nodeIdx++) {
			if(parent.getChild(nodeIdx).equals(node)) {
				break;
			}
		}
		return nodeIdx;
	}
	

	public boolean isLeaf(TreeNode<K> node) {
		return(node.numChildren() == 0);
	}
	

	public TreeNode<K> findSb(TreeNode<K> node){
		TreeNode<K> parent = node.getParent();
		int myidx = childLocation(node);
		
		if(myidx == 0) { 
			return parent.getChild(1);
		}else if(myidx == parent.numChildren()-1) { 
			return parent.getChild(myidx-1); 
		} else { 
			if(parent.getChild(myidx + 1).numKeys() > parent.getChild(myidx-1).numKeys()) {
				return parent.getChild(myidx + 1);
				
			}else {
				return parent.getChild(myidx -1);
			}
		}
	}
	

	public TreeNode<K> findPredNode(K key){
		TreeNode<K> node = findNode(key);
		for(int i = 0; i < node.numChildren(); i++) {
			TreeNode<K> child = node.getChild(i);
			int num = child.numKeys();
			if(comp.compare(child.getKey(num-1), key) <= 0){
				node = child;
				break;
			}
		}
		if(!isLeaf(node)) {
			while(!isLeaf(node)) {
				int direction = node.numChildren();
				node = node.getChild(direction-1);
			}
		}
		return node;
	}
	
	public TreeNode<K> traverse(K key){
		K cursor;
		TreeNode<K> cursorNode = root;
		TreeNode<K> path = new TreeNode<>();
		
		path.insertChild(0, cursorNode);
		int cnt = 0;
		while(!isLeaf(cursorNode)) {
			int idx = findLocation(cursorNode, key);
			
			if(idx == cursorNode.numKeys()) {
				cursor = cursorNode.getKey(idx -1);
			}else {
				cursor = cursorNode.getKey(idx);
			}
			
			if(cursor.equals(key)) {
				break;
			}
			else {
				path.insertChild(cnt, cursorNode);
				cursorNode = cursorNode.getChild(idx);
			}
		}
		path.insertChild(0, cursorNode);
		return path;
	}
	
	
	public void merge1(TreeNode<K> node) {
		
		TreeNode<K> left = new TreeNode<K>();
		left = node.getChild(0);
		TreeNode<K> right = new TreeNode<K>();
		right = node.getChild(1);
		
		node.insertKey(0, left.getKey(0));
		node.insertKey(2, right.getKey(0));
		node.removeChild(childLocation(left));
		node.removeChild(childLocation(right));

		if(!isLeaf(left) && !isLeaf(right)) {
			node.insertChild(0, left.getChild(0));
			left.getChild(0).setParent(node);
			node.insertChild(1, left.getChild(1));
			left.getChild(1).setParent(node);
			node.insertChild(2, right.getChild(0));
			right.getChild(0).setParent(node);
			node.insertChild(3, right.getChild(1));
			right.getChild(0).setParent(node);
		
		}
			
		
	}
	

	public void shrinkTree(TreeNode<K> node, TreeNode<K> sibling) {
		TreeNode<K> parent = node.getParent();
		TreeNode<K> tempNode = new TreeNode<>();
		int direction = childLocation(sibling) - childLocation(node);
		if(direction > 0) {
			tempNode.insertKey(0, node.getKey(0));
			tempNode.insertKey(1, parent.getKey(childLocation(node)));
			tempNode.insertKey(2, sibling.getKey(0));
			
			parent.removeKey(childLocation(node));
			parent.insertChild(childLocation(node), tempNode);
			parent.removeChild(childLocation(node));
			parent.removeChild(childLocation(sibling));
			
			tempNode.setParent(parent);
			node = tempNode;

			
		}else {
			tempNode.insertKey(0, findSb(node).getKey(0));
			tempNode.insertKey(1, parent.getKey(childLocation(sibling)));
			tempNode.insertKey(2, node.getKey(0));
			
			parent.removeKey(childLocation(sibling));
			parent.insertChild(childLocation(sibling), tempNode);

			tempNode.setParent(parent);
			node = tempNode;
		}
	}
	
	
	public TreeNode<K> rotate(TreeNode<K> node, TreeNode<K> sibling) {
		TreeNode<K> parentNode = node.getParent();
		if (childLocation(sibling) > childLocation(node)) {
			node.insertKey(node.numKeys(), parentNode.getKey(childLocation(node)));
			parentNode.removeKey(childLocation(node));
			parentNode.insertKey(childLocation(node), sibling.getKey(0));
			sibling.removeKey(0);
		} else {
			node.insertKey(0, parentNode.getKey(childLocation(sibling)));
			parentNode.removeKey(childLocation(sibling));
			parentNode.insertKey(childLocation(sibling), sibling.getKey(sibling.numKeys() - 1));
			sibling.removeKey(sibling.numKeys() - 1);
		}
		return node;
	}
	


}