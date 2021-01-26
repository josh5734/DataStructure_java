/*
* Name: JO SUNG HYEON
* Student ID #: 2016147008
*/

/*
* Do NOT import additional packages/classes.
* If you (un)intentionally use packages/classes we did not provide,
* you will get 0.
*/

public class Trie implements ITrie {
	
	Node<String> root;	
	boolean isLastChar;
	String[] dic;
	int wordNumber;
	public Trie() {
		/*
		* Constructor.
		*
		* Note that we will check the number of compare calls;
		* if the count is too low or too high (depending on cases),
		* you will fail the case.
		*/
		this.root = new Node<>();
		isLastChar = true;
		dic = new String[10000];
		wordNumber = 0;
	}

	@Override
	public void insert(String s) {
		if(exists(s)) return;
		
		
		Node<String> cursor = root;
		int length = s.length();
		
		for(int i = 0; i < length; i++) {
			boolean exist = false;
			String c = Character.toString(s.charAt(i));
			Node<String> newNode = new Node<>();
			
			if(cursor.numKeys() != 0) {
				for(int j = 0; j < cursor.numKeys(); j++) {
					if(cursor.getKey(j).equals(c)) {
						cursor = cursor.getChild(j);
						exist = true;
						break;
					}
				}
				if(!exist) {
					int index = findLocation(cursor,c);
					cursor.insertKey(index,c);
					cursor.insertChild(index, newNode);
					newNode.setParent(cursor);
					cursor = cursor.getChild(index);
				}
			}
			else {
				int index = 0;
				cursor.insertKey(index,c);
				cursor.insertChild(index, newNode);
				newNode.setParent(cursor);
				cursor = cursor.getChild(index);
			}
		}
		cursor.setLastChar(isLastChar);
		
		if (dic.length == wordNumber) {
			String temp[] = new String[2 * wordNumber];
			for (int i = 0; i < dic.length; i++) {
				temp[i] = dic[i];
			}
			dic = temp;
		}
		dic[wordNumber] = s;
		
		wordNumber++;
	}
	
	@Override
	public boolean exists(String s) {
		Node<String> cursor = root;
		for(char c : s.toCharArray()) {
			String str = Character.toString(c);
			
			if(subNode(cursor,str) == null)
				return false;
			else
				cursor = subNode(cursor,str);
		}
		if(cursor.getLastChar() == true){
			return true;
		}
		return false;
	
	}
	

	@Override
	public String[] dictionary() {
		int num = 0;
		for(int i = 0; i < dic.length; i++) {
			if (dic[i] == null) {
				num = i;
				break;
			}
		}
		String[] ans = new String[num];
		for(int i = 0; i < num; i ++) {
			ans[i] = dic[i];
		}
		ans = arrSort(ans, 0, ans.length-1);	
		return ans;
	}

	@Override
	public Node root() {
		return root;
	}
	
	public int findLocation(Node<String> node, String w) {
		int items = node.numKeys();
		int idx = 0;
		for(int i = items-1; i >=0 ; i--) {
			if(node.getKey(i).toString().compareTo(w) < 0) {
				idx = i + 1;
				break;
			}
		}
		return idx;
	}
	
	
	public Node<String> subNode(Node<String> cursor, String c) {
		if(cursor.numKeys() != 0) {
			for(int i = 0; i < cursor.numKeys(); i++) {
				if(cursor.getKey(i).equals(c))
					return cursor.getChild(i);
			}
		}
		return null;
	}
	
	public String[] arrSort(String[] arr, int start, int end) {
		
		int p = partition(arr, start, end);
		if(start < p-1) {
			arrSort(arr, start, p-1);
		}
		if(p < end) {
			arrSort(arr, p, end);
		}
		return arr;
		
	}
	
	public int partition(String[] arr, int start, int end) {
		String pivot = arr[(start+end) / 2];
		while(start <= end) {
			while(arr[start].compareTo(pivot) < 0) start++;
			while(arr[end].compareTo(pivot) > 0) end--;
			if(start <= end) {
				String tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
				start++;
				end--;
			}
		}
		return start;
	}
}