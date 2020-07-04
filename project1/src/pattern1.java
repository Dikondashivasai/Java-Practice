import java.util.Scanner;
public class pattern1 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
int i,j,k,n;
Scanner user_input;
user_input=new Scanner(System.in);
System.out.print("enter no of layers:");
n=user_input.nextInt();

		for(i=1;i<=n;i++)
		{	
		for(j=i;j<=n;j++)
			System.out.print(" ");
				for(k=1;k<(i*2);k++)
					System.out.print("*");
					System.out.print("\n");
		}
	}

}
/*REvrese pyramid
  for(i=0;i>n;i--)
j=0;j<n;j++
k=0;k<(i*2)-1;k++
*/