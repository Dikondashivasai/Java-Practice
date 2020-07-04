public class array {

	public static void main(String[] args) 
		{
			display obj= new display();
			obj.show(10,5,6,55,202);
		}
	}
	class display
{
	public void show(int ...a )
	 {
		for(int:a)
		System.out.println(a);
	 }
}