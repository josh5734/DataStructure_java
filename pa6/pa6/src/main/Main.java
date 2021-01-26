import java.util.*;

/*
* Since this file is not a part of submission,
* you can use any class/packages.
*/

public class Main
{
    public static void main(String[] args)
    {
        Tree<Integer> tree = new Tree<>(Comparator.<Integer>naturalOrder());

        /*
        tree.insert(3);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(10);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);

        System.out.println(tree.root.getKey(0));
        System.out.println(tree.root.getChild(0).getKey(0));
        System.out.println(tree.root.getChild(1).getKey(0));
        System.out.println(tree.root.getChild(0).getChild(0).getKey(0));
        System.out.println(tree.root.getChild(0).getChild(0).getKey(1));
        System.out.println(tree.root.getChild(0).getChild(1).getKey(0));
        System.out.println(tree.root.getChild(1).getChild(0).getKey(0));
        System.out.println(tree.root.getChild(1).getChild(0).getKey(1));
        System.out.println(tree.root.getChild(1).getChild(0).getKey(2));
        System.out.println(tree.root.getChild(1).getChild(1).getKey(0));
        System.out.println("-----------삽입종료-----------");
        
        tree.delete(3);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        
        tree.delete(1);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        System.out.println("2번째 depth의 1번째값은: " + tree.root.getChild(0).getKey(0));
        System.out.println("2번째 depth의 2번째값은: " + tree.root.getChild(0).getKey(1));
        System.out.println("2번째 depth의 3번째값은: " + tree.root.getChild(1).getKey(0));
        System.out.println("2번째 depth의 마지막값은: " + tree.root.getChild(2).getKey(0));
      
        tree.delete(5);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        System.out.println("2번째 depth의 1번째값은: " + tree.root.getChild(0).getKey(0));
        System.out.println("2번째 depth의 2번째값은: " + tree.root.getChild(1).getKey(0));
        System.out.println("2번째 depth의 3번째값은: " + tree.root.getChild(1).getKey(1));
        System.out.println("2번째 depth의 4번째값은: " + tree.root.getChild(1).getKey(2));
        System.out.println("2번째 depth의 마지막값은: " + tree.root.getChild(2).getKey(0));
        
        tree.delete(4);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        System.out.println("루트노드의 두번째 값은: " + tree.root.getKey(1));
        System.out.println("2번째 depth의 1번째값은: " + tree.root.getChild(0).getKey(0));
        System.out.println("2번째 depth의 2번째값은: " + tree.root.getChild(1).getKey(0));
        System.out.println("2번째 depth의 2번째값은: " + tree.root.getChild(1).getKey(1));
        
        tree.delete(2);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        System.out.println("루트노드의 2번째 값은: " + tree.root.getKey(1));
        System.out.println("2번째 depth의 첫번째 값은: " + tree.root.getChild(0).getKey(0));
        System.out.println("2번째 depth의 두번째 값은: " + tree.root.getChild(1).getKey(0));
        
        tree.delete(9);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        System.out.println("2번째 depth의 첫번째 값은: " + tree.root.getChild(0).getKey(0));
        System.out.println("2번째 depth의 2 값은: " + tree.root.getChild(1).getKey(0));
        System.out.println("2번째 depth의 3 값은: " + tree.root.getChild(1).getKey(1));
        
        tree.delete(10);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        System.out.println("2번째 depth의 첫번째 값은: " + tree.root.getChild(0).getKey(0));
        System.out.println("2번째 depth의 2 값은: " + tree.root.getChild(1).getKey(0));
        
        tree.delete(7);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        
        tree.delete(6);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        
        tree.delete(8);
        System.out.println("트리의 사이즈는: " + tree.size());
        System.out.println("루트노드의 첫번째 값은: " + tree.root.getKey(0));
        
  */
        
        
     
        System.out.println(tree.isEmpty());//, is(true));

        TreeNode<Integer> n1 = tree.insert(1);
        TreeNode<Integer> n2 = tree.insert(2);
        TreeNode<Integer> n3 = tree.insert(3);
        

        
        System.out.println(tree.size());// is(3));
        System.out.println(tree.root().equals(n1));// is(sameInstance(n1)));
        System.out.println(tree.search(3));// is(true));
        TreeNode<Integer> n4 = tree.insert(4);

        System.out.println(tree.root().getChild(0).getKey(0));// is(1));
        System.out.println(tree.size());// is(4));
        
        tree.delete(4);

        System.out.println(tree.search(4));// is(false));
        System.out.println(tree.size());// is(3));
        System.out.println(tree.isEmpty());// is(false));
        System.out.println(tree.root.getKey(0));
        System.out.println(tree.root.getChild(0).getKey(0));
        System.out.println(tree.root.getChild(1).getKey(0));
        
        tree.delete(1);
        tree.delete(2);
        tree.delete(3);

        System.out.println(tree.isEmpty());// is(true));

    	
    	/*
        TreeNode<Integer> n4 = tree.insert(4);
        TreeNode<Integer> n5 = tree.insert(2);
        TreeNode<Integer> n6 = tree.insert(9);
        TreeNode<Integer> n7 = tree.insert(10);
        TreeNode<Integer> n8 = tree.insert(8);
        TreeNode<Integer> n9 = tree.insert(7);
        TreeNode<Integer> n10 = tree.insert(6);
        */
    	
        //System.out.println("This Main class exists for testing using standard input/output");
        //System.out.println("since the testrunner will ignore the standard output (System.out).\n");

      //  System.out.println("This class will not be handed in: you can use this class freely.\n");

        //System.out.println("Please make sure to test your code using the testrunner:");
       // System.out.println("  % ./gradlew -q runTestRunner");
       // System.out.println("You can add your own testcases using the files in src/test directory.\n");

       // System.out.println("Also, please use the following command to make a zip file to submit:");
      //  System.out.println("  % ./gradlew -q zipSubmission\n");
    }
}
