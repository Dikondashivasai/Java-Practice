
public class pattern {

	public static void main(String[] args) {
		int i,j;
		for(i=5;i>=1;--i)/*(i=1;i<=5;i++)*/
		{	
			for(j=1;j<=i;j++)
			{
			System.out.print(j+"*");
			}
			System.out.println();
		}
		/*char last='S',alphabet='A';
		for( int i=1;i<=(last-'A'+1);i++)
		{	
			for(int j=1;j<=i;j++)
			{
			System.out.print(alphabet+" ");
			}++alphabet;
			System.out.println();
		}*/
	}
	

}
