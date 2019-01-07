package ch14;

import java.util.Vector;

//컬렉션(Collection) - 배열의 단점을 보완한 클래스들
//배열의 단점 - 사이즈 조절, 삽입, 삭제가 어려움, 다양한 자료형 저장 불가
//컬렉션 Map계열 - 순서는 제공되지 않지만 키(key)가 제공 (key로 조회 마치 index와 같은 역할)
//List계열 - 순서대로 저장(FIFO), 키가 없음(index로 조회)

public class VectorExam {
	public static void main(String[] args) {
		
		Vector<Object> v = new Vector<>();
		//<Object>로 모든 자료형 처리가 가능
		//사이즈가 자동으로 가변
		System.out.println("초기 사이즈 : "+v.capacity());	//capacity() 벡터의 현재 용량
		//벡터는 기본적으로 10개의 사이즈를 가짐
		
		v.add("first");
		v.add(2);
		v.add(3.5);
		v.add(true);
		v.add(100);
		v.add(101);
		v.add(102);
		v.add(103);
		v.add(104);
		v.add(105);
		v.add(106);
		v.add(107);
		v.add(108);
		
		System.out.println("중간 사이즈 : "+v.capacity());
		//입력된 데이터가 초기 사이즈인 10개를 넘어가면 10개씩 사이즈가 늘어남
		
		System.out.println("데이터의 갯수 : "+v.size());	//size() 벡터의 현재 데이터의 갯수
		
		System.out.print("초기 데이터 : ");
		for(int i=0;i<v.size();i++) {
			System.out.print(v.get(i)+" ");
		}
		System.out.println();
		
		v.add(1, "index1");
		v.add(14, 109);
		
		for(int i=0;i<v.size();i++) {
			System.out.print(v.get(i)+" ");
		}
		System.out.println();
		
		v.remove("index1");
		v.remove(0);
		
		for(int i=0;i<v.size();i++) {
			System.out.print(v.get(i)+" ");
		}
		
	}
	
}
