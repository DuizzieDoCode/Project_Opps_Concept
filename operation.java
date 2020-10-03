package user;
class id{
	int ownerid;
	int userid;
	
}

class owner extends id{
	private static final int True = 0;
	String owner;
	private int k;
	public int value(int ...ownern) {
		if(ownerid==True) {
		for (int i = 0; i < ownern.length; i++) {
			k = ownern[i];
		}
		}
		else
		{
			System.out.println("Invalid OwnerID.");
		}
		return ownerid;
	}
}
class user extends owner{
	private static final int True = 0;
	String user;
	private int l;
	public int value(int ...usern) {
		if(ownerid==True) {
		for (int i = 0; i < usern.length; i++) {
			l = usern[i];
		}
		}
		else
		{
			System.out.println("Invalid UserID.");
		}
		return userid;
}

public static class operation {

	public static void main(String[] args) {
		

	}



}
}
