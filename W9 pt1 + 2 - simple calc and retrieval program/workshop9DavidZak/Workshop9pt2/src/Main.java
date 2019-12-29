import java.util.HashMap;
import java.util.Map;

/*David Zak 158458174 */

public class Main {
	static int i = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Map<String, String> c =  new HashMap< String, String>(); 
		 c.put("canada", "ottawa");
		 c.put("austria", "vienna");
		 c.put("cuba", "havana");
		 c.put("egypt", "cairo");
		 c.put("france", "paris");
		 c.put("greece", "athens");
		 c.put("iran", "tehran");
		 c.put("ireland", "Dublin");
		 c.put("japan", "Tokyo");
		 c.put("laos", "vientiane");
		 c.put("nepal", "kathmandu");
		 c.put("malta", "valletta");
		 c.put("norway", "oslo");
		 c.put("peru", "lima");
		 c.put("philippines", "manila");
		 c.put("poland", "warsaw");
		 c.put("russia", "moscow");
		 c.put("spain", "madrid");
		 c.put("sweden", "stockholm");
		 c.put("taiwan", "taipei");
		 c.put("united states", "washignton");
		 c.put("britain", "london");
		 c.put("vietnam", "hanoi");
		 c.put("turkey", "ankara");
		 c.put("zambia", "lusaka");
		 
		 
		 c.entrySet().forEach(country->{
			 
			    System.out.println(increment() + ". " + country.getKey()); 
			   
			 });
		 boolean done = false;
		 while(done == false){
			System.out.print("\nEnter a Country on the list to get the capital: ");
			String country  = Helper.getStringToLowerCase();
			if(country.isEmpty()) {
				System.out.println("Incorrect country name, try again");
				break;
			}
			String capital = null;
			try {
			capital = c.get(country);
			}catch(Exception Err) {}
			
			if(capital  == null) {
				System.out.println("Incorrect country name, try again");
				continue;
			}
		
			System.out.println("Capital of " + country + " is " + capital);
			System.out.print("Enter y to try again, n to exit : ");
			done = !(Helper.yesOrNo());
			
		 }
	}
	
	public static int increment() {
		++i;
		return i;
	}
	

}
