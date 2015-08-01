package next_greater_element;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element {
		static Stack<Integer> s=new Stack<Integer>();
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of elements::");
			int n=Integer.parseInt(sc.nextLine());
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
			}
			sc.nextLine();
			System.out.println("finding first next greater element using loop");
			find_greater_loops(arr);
			System.out.println("finding first next greater element using stack");
			find_greater_stack(arr);
			sc.close();
		}
		public static void find_greater_stack(int[] arr)
		{
			int len=arr.length;
			s.push(arr[0]);
			for(int i=1;i<len;i++)
			{
				int y=s.pop();
				
				while(y < arr[i])
				{
					System.out.printf("%d -> %d\n",y,arr[i]);
					if(!s.isEmpty())
						y=s.pop();
					else
						break;
				}
				if(arr[i] < y)
					s.push(y);
				s.push(arr[i]);
			}
			while(!s.isEmpty())
			{
				System.out.printf("%d -> %d\n",s.pop(),-1);
			}
		}
		public static void find_greater_loops(int[] arr)
		{
			int n=arr.length;
			for(int i=0;i<n-1;i++)
			{
				int index=arr[i+1];
				int j=i+1;
				   while(j<n && index < arr[i])
				   {
					   j++;
					   if(j<n)
					   index=arr[j];
				   }
				   if(index > arr[i])
					   System.out.printf("%d -> %d\n",arr[i],index);
				   else if(j==n)
					   System.out.printf("%d -> %d\n",arr[i],-1);
			}
			System.out.printf("%d -> %d\n",arr[n-1],-1);
		}
}