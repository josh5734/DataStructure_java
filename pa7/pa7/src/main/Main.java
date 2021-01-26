import java.util.*;

/*
* Since this file is not a part of submission,
* you can use any class/packages.
*/

public class Main
{
    public static void main(String[] args)
    {    
       Trie t = new Trie();
       Node root = t.root();
       System.out.println(root.numKeys());
       /*
       t.insert("a");
       t.insert("a");
       t.insert("a");
       t.insert("ab");
       t.insert("ab");
       t.insert("abc");
       t.insert("abcc");
       t.insert("abcd");
       t.insert("abce");
       t.insert("aba");
       t.insert("abb");
       t.insert("abaa");
       t.insert("abaaa");
       t.insert("ababa");
       t.insert("ababb");
       t.insert("abccc");
       t.insert("abacca");
       t.insert("abbz");
       
       for(String x : t.dictionary()) {
    	   System.out.println(x);
    	   
       }
       System.out.println(t.dictionary().length);
       */
       
        
       t.insert("a");
       t.insert("ab");
       t.insert("ac");
       t.insert("acd");
       
       System.out.println(root.getKey(0));
       System.out.println(root.getChild(0).getKey(0));
       System.out.println(root.getChild(0).getKey(1));
       System.out.println(root.getChild(0).getChild(1).getKey(0));
       System.out.println(root.getChild(0).getChild(1).getChild(0).getLastChar());
       System.out.println(root.getChild(0).getChild(1).getLastChar());
       
       System.out.println(root.getChild(0).getLastChar());
       System.out.println(root.getChild(0).getChild(0).getLastChar());
       System.out.println(root.getChild(0).getChild(0).getLastChar());
   

       Autocomplete a = new Autocomplete ();
   	   String[] dic = {"a", "ab", "ac", "acd"};
   	   a.construct(dic);
   	   System.out.println(a.autocompletedWord("ad"));
   	   System.out.println(a.average());
       
   	   System.out.println();
   	
   	   String[] dic2 = { "ice", "icy", "icecream", "cream","creamy" };
       a.construct(dic2);
       System.out.println(a.autocompletedWord("i"));
       System.out.println(a.autocompletedWord("ic"));
       System.out.println(a.autocompletedWord("ice"));
       System.out.println(a.autocompletedWord("cy"));
       System.out.println(a.autocompletedWord("cm"));
       System.out.println(a.average());
       System.out.println();
      
 	  String[] dic3 = { "i", "id", "idea", "ideal" };
 	  a.construct(dic3);


 	  System.out.println(a.autocompletedWord("i"));
 	  System.out.println(a.autocompletedWord("id"));
 	  System.out.println(a.autocompletedWord("ide"));
 	  System.out.println(a.autocompletedWord("idea"));
 	  System.out.println(a.autocompletedWord("ideal"));
 	  System.out.println(a.average());
 	  System.out.println(a.trie.root().numKeys());
  	  System.out.println();
  	  
 	  String[] dic4 = { "pe", "p", "per","wind","win","w","k","kk","kkt","kt","kakao","ka" };
      a.construct(dic4);
      System.out.println(a.average());
      for(String x: a.trie.dictionary()) {
    	  System.out.print(x+ " ");
      }System.out.println();
      
      
      
        /*
       t.insert("hi!");
       t.insert("1.23");
       t.insert("winter");
       t.insert("window");
       t.insert("cat");
       t.insert("cats");
       t.insert("catss");
       t.insert("a");
       t.insert("b");
       t.insert("c");
       t.insert("안녕하세요???????????");
       t.insert("xxxxxxxxxxxxxxxxxxxxx");
       System.out.println(t.exists("winter"));
       System.out.println(t.exists("window"));
       System.out.println(t.exists("cat"));
       System.out.println(t.exists("cats"));
       System.out.println(t.exists("catss"));
       System.out.println(t.exists("a"));
       System.out.println(t.exists("b"));
       System.out.println(t.exists("c"));
       System.out.println(t.exists("xxxxxxxxxxxxxxxxxxxxx"));
       System.out.println(t.exists("hi!"));
       System.out.println(t.exists("1.23"));
       System.out.println(t.exists("안녕하세요???????????"));
       System.out.println(t.exists("xxxxxxxxxxxxxxxxxxxx"));
       for(String words : t.dictionary()) {
          System.out.print(words+ " ");
       }System.out.println();
       /*
       /*
       System.out.println("ROOT의 1번째 값: " + root.getKey(0));
       System.out.println("깊이1의 1번째 값: " + root.getChild(0).getKey(0));
       System.out.println("깊이2의 1번째 값: " + root.getChild(0).getChild(0).getKey(0));
       System.out.println("깊이3의 1번째 값: " + root.getChild(0).getChild(0).getChild(0).getKey(0));
       System.out.println("깊이3의 2번째 값: " + root.getChild(0).getChild(0).getChild(0).getKey(1));
       
       System.out.println("깊이4의 1번째 값: " + root.getChild(0).getChild(0).getChild(0).getChild(0).getKey(0));

       System.out.println("깊이4의 2번째 값: " + root.getChild(0).getChild(0).getChild(0).getChild(1).getKey(0));
       System.out.println("깊이5의 1번째 값: " + root.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getKey(0));
       System.out.println("깊이5의 2번째 값: " + root.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getKey(0));
*/
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       /*
      t.insert("sell");
      t.insert("stock");
      t.insert("stop");
       t.insert("bear");
      t.insert("bell");
      t.insert("bid");
      t.insert("bull");
      t.insert("buy");
      
      for(String x: t.dictionary()) {
         System.out.println(x);
      }
      
      System.out.println(t.exists("bear"));
      System.out.println(t.exists("stop"));   
      System.out.println(t.exists("sad"));
      Node root = t.root();
      System.out.println("1번째 라인의 첫번째 값: " + root.getChild(0).getKey(0));
      System.out.println("2번째 라인의 첫번째 값: " + root.getChild(0).getChild(0).getKey(0));
      System.out.println("2번째 라인의 첫번째 값: " + root.getChild(0).getChild(1).getKey(0));
      System.out.println("2번째 라인의 첫번째 값: " + root.getChild(0).getChild(2).getKey(0));
   
      System.out.println("3번째 라인의 첫번째 값: " + root.getChild(0).getChild(0).getChild(0).getKey(0));
      System.out.println("3번째 라인의 첫번째 값: " + root.getChild(0).getChild(0).getChild(1).getKey(0));
      System.out.println("3번째 라인의 첫번째 값: " + root.getChild(0).getChild(1).getChild(0).getKey(0));
      
      */
      
      /*
      String[] dic5 = { "a", "ab", "abc", "bc", "bte", "cet", "ceyu", "bcyu", "ctpa", "ctp" };
      a.construct(dic5);
      System.out.println(a.average());
    
	  String str ="";
      for(int i = 0; i < 10001; i++) {
    	  t.insert(str);
    	  str += "b";
      }
      System.out.print(t.dictionary().length);	
      
      */
	  /*
	  System.out.println(a.autocompletedWord("y"));
	  System.out.println(a.autocompletedWord("yn"));
	  System.out.println(a.autocompletedWord("d"));
	  System.out.println(a.autocompletedWord("yg"));
	  System.out.println(a.autocompletedWord("yu"));
	  System.out.println(a.autocompletedWord("yun"));
	  System.out.println(a.autocompletedWord("yut"));
	  System.out.println(a.autocompletedWord("yo"));
	  System.out.println(a.average());
	  */
	  }
}
/*
System.out.println("This Main class exists for testing using standard input/output");
System.out.println("since the testrunner will ignore the standard output (System.out).\n");

System.out.println("This class will not be handed in: you can use this class freely.\n");

System.out.println("Please make sure to test your code using the testrunner:");
System.out.println("  % ./gradlew -q runTestRunner");
System.out.println("You can add your own testcases using the files in src/test directory.\n");

System.out.println("Also, please use the following command to make a zip file to submit:");
System.out.println("  % ./gradlew -q zipSubmission\n");
*/