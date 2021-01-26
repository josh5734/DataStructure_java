public class Main {
	public static void main(String[] args) {
		Array array = new Array();
		ISet set1 = new Set();       //Set set1? -> set1.array로 접근가능 / ISet는 무조건 interface에 있는 메소드만 접근 가능 / ISet에는 array가 없음
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
		System.out.println("array가 정렬된 상태입니까?: "+ array.isSorted());
		
		System.out.println("array를 정렬합니다.");
		array.sort();
		System.out.println("array가 정렬된 상태입니까?: "+ array.isSorted());
		
		for(int i = 0; i<6; i++) {
			System.out.println(array.atIndex(i));
		}
		
		System.out.println("array가 정렬된 상태에서 값을 삽입합니다.");
		array.insert(5);
		for(int i = 0; i<7; i++) {
			System.out.println(array.atIndex(i));
		}
		
		
		System.out.println("Hello, world\n");
	}
}