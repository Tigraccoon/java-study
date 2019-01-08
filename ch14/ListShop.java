package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListShop {
	public static void main(String[] args) {
		List<Shop> list = new ArrayList<>();
		
		System.out.println("첫 번째 제품을 입력하세요!");
		Shop s1 = new Shop();
		s1.input();
		list.add(s1);
		System.out.println("두 번째 제품을 입력하세요!");
		Shop s2 = new Shop();
		s2.input();
		list.add(s2);
		
		System.out.println("제품\t제조사\t단가\t수량\t금액");
		for(Shop s : list) {
			System.out.println(s.getModel()+"\t"+s.getPress()+"\t"+s.getPrice()+"\t"+s.getAmount()+"\t"+s.getMoney());
		}
		
		
		
	}
	
}
