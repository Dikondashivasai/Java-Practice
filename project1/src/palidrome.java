import java.util.Scanner;


public class palidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,r,s=0,temp;
		Scanner user_input;
		user_input=new Scanner(System.in);
		System.out.print("enter  Palidrome number:");	
		n=user_input.nextInt();
		temp=n;
while(n>0)
{
	r=n%10;
	s=(s*10)+r;
	n=n/10;
} if(temp==s)	
System.out.println("palidorme");
else
	System.out.println("not palidrome");	
	
	}
	

}
