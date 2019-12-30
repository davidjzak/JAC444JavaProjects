
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("enter number of elements to give: ");
			int num = Helper.getInt();
			double nums[] = new double [num];
			for(int i = 0; i < num; i++){
				System.out.println("enter a number: ");
				nums[i] = Helper.getDouble();
				
			}
			
			Manage manage = new Manage(nums);
		
	}

}
