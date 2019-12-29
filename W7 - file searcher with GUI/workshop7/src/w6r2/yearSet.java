package w6r2;

import java.util.ArrayList;
import java.util.List;

public class yearSet {
	List<Person> boy;
	List<Person> girl;
	
	public yearSet()
	{	boy = new ArrayList<Person>();
	girl = new ArrayList<Person>();}
	
	public Person findName(String name, char Gender) {
		
	
	
		if(Gender == 'M' || Gender == 'm') {
			for(int i = 0; i < boy.size(); i++) {
				if(boy.get(i).name.toUpperCase().equals(name.toUpperCase()) ) {
				
					return boy.get(i);
				}
			}
		}else if(Gender == 'F'|| Gender == 'f') {
			for(int i = 0; i < girl.size(); i++) {
				if(girl.get(i).name.toUpperCase().equals(name.toUpperCase())) {
					return girl.get(i);
				}
			
		}
	}
		return null;
	
}
	
	

}