
/*
* Name: JO SUNG HYEON
* Student ID #: 2016147008
*/
import java.lang.Math;
/*
* Do NOT import additional packages/classes.
* If you (un)intentionally use packages/classes we did not provide,
* you will get 0.
*/

public class Autocomplete implements IAutocomplete {

	Trie trie;
	public Autocomplete() {
		/*
		* Constructor.
		*
		* Note that we will check the number of compare calls;
		* if the count is too low or too high (depending on cases),
		* you will fail the case.
		*/
		trie = new Trie();
	}

	@Override
	public void construct(String[] s) {
		trie = new Trie();
		for(int i = 0; i < s.length; i++) {
			trie.insert(s[i]);
		}
	}
	
	@Override
	public String autocompletedWord(String s) {
		Node<String> cursor = trie.root;
		String str = "";
	
		for(char ch : s.toCharArray()) {
			String x = Character.toString(ch);
			for(int i = 0; i < cursor.numKeys(); i++) {
				if(cursor.getKey(i).equals(x)) {
					cursor = cursor.getChild(i);
					str += ch;
					while(cursor.numKeys() == 1) {
						if(cursor.getLastChar()) {
							break;
						}
						else {
							str += cursor.getKey(0);
							cursor = cursor.getChild(0);
						}
					}
					break;
				}
			}
		}
		
		return str;
	}
	@Override
	public float average() {
		int cnt = 0;
		for(String str : trie.dictionary()) {
			String input = "";
			int start = 0;
			while(start <= str.length()) {
				String x = Character.toString(str.charAt(start));
				input += x;
				String word = autocompletedWord(input);
				start = word.length();
				cnt++;
				if(word.equals(str)) break;
				
			}
		}
		float answer = (float) (Math.round((float)cnt / trie.dictionary().length*100)/100.0);
		return answer;
	}
}