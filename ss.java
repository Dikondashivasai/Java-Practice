
public class ss {
	public void speak(String text){
		System.out.println(text);
	}
	public void move(String direction,int distance){
	 System.out.println("move:" +direction+ "going:"+distance);
	}
	
	public void jump(int height ){
		System.out.println("jumping:"+height);
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
ss sai=new ss();
sai.speak("hello ");
sai.move("west",12);
sai.jump(25);		
String geeting="hi shiva";
sai.speak(geeting);
	}
		
		

}
