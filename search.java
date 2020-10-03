import java.util.Scanner;
public class search {
	static int search(int arr[],int n,int x) {
		for(int i=0;i<n;i++) {
			if(arr[i]==x) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int userid;
		
		int []arr= {2035,2033,2052,2068};
		int n=arr.length;
		
		Scanner input=new Scanner(System.in);
		System.out.print("USERID: ");
		userid=input.nextInt();
		
		int x=userid;
		int index=search(arr,n,x);
		if(index==-1) {
			System.out.println("Invalid Input");
		}
		else {
			System.out.println("found");//bro yaha se agle page mein jayega yani interface mein
		}
		
		
		
		
	}

}
