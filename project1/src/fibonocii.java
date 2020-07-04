import java.util.Scanner;

public class fibonocii {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a=0,b=1,c,n=10;
Scanner user_input;
user_input=new Scanner(System.in);
System.out.print("enter no of fibonocii series is required:");
n=user_input.nextInt();

System.out.print("enter no of fibonocii series:"+a +" "+ b);

for(int i=1;i<=n;i++)
{
	c=a+b;
	a=b;
	b=c;

System.out.print("\n"+c);
}		
	}

}
