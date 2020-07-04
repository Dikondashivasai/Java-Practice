import java.util.Scanner;


public class even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Scanner user_input;
		user_input=new Scanner(System.in);
		System.out.print("enter no u required:");
		n=user_input.nextInt();

		if(n%2==0)
		{
			System.out.println("even");
		}		else
		System.out.print("odd");
		}
	}


