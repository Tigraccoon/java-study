package ch08;

public class MyManagerUse {
	public static void main(String[] args) {
		MyManager mgr = MyManager.getinstance();
		System.out.println("mgr.getScore() : " + mgr.getScore());
		mgr.setScore(100);
		System.out.println("mgr.getScore() : " + mgr.getScore());
		
		MyManager newmgr = MyManager.getinstance();
		System.out.println("newmgr.getScore() : " + newmgr.getScore());
		newmgr.setScore(30);
		System.out.println("newmgr.getScore() : " + newmgr.getScore());

		
	}
	
}
