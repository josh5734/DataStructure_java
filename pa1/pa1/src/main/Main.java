public class Main {
	public static void main(String[] args) {
		Array array = new Array();
		ISet set1 = new Set();       //Set set1? -> set1.array�� ���ٰ��� / ISet�� ������ interface�� �ִ� �޼ҵ常 ���� ���� / ISet���� array�� ����
		ISet set2 = new Set(); 
	
		
		
		set1.subtraction(set2);
		int[] ans1 = set1.show();
	
		for(int i = 0; i < ans1.length; i++) {
			System.out.println(ans1[i]);	
		}
		System.out.println(' ');
		
		array.insert(3);
		array.insert(3);
		array.insert(3);
		array.delete(3);
		System.out.println("array size: "+ array.size());
		
		array.insert(8);
		array.insert(1);
		array.insert(2);
		array.insert(4);
		for(int i = 0; i<6; i++) {
			System.out.println(array.atIndex(i));
		}
		System.out.println("array�� ���ĵ� �����Դϱ�?: "+ array.isSorted());
		
		System.out.println("array�� �����մϴ�.");
		array.sort();
		System.out.println("array�� ���ĵ� �����Դϱ�?: "+ array.isSorted());
		
		for(int i = 0; i<6; i++) {
			System.out.println(array.atIndex(i));
		}
		
		System.out.println("array�� ���ĵ� ���¿��� ���� �����մϴ�.");
		array.insert(5);
		for(int i = 0; i<7; i++) {
			System.out.println(array.atIndex(i));
		}
		
		
		System.out.println("Hello, world\n");
	}
}