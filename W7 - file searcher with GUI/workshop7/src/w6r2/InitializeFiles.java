package w6r2;
import java.io.RandomAccessFile;
import java.util.List;


public class InitializeFiles {
	String [] mNFN; //4 slots, ranking, mens name, number, womans name, number
	String tempMale;
	String mNumber;
	String tempFemale;
	String fNumber;
	yearSet y2001 = new yearSet();
	yearSet y2002 = new yearSet();
	yearSet y2003 = new yearSet();
	yearSet y2004 = new yearSet();
	yearSet y2005 = new yearSet();
	yearSet y2006 = new yearSet();
	yearSet y2007 = new yearSet();
	yearSet y2008 = new yearSet();
	yearSet y2009 = new yearSet();
	yearSet y2010 = new yearSet();
	
	RandomAccessFile raf;
	//String rafname = "address.txt";
	public InitializeFiles(){
		
		
			
			loadFile("babynamesranking2001.txt", "2001");
			loadFile("babynamesranking2002.txt", "2002");
			loadFile("babynamesranking2003.txt", "2003");
			loadFile("babynamesranking2004.txt", "2004");
			loadFile("babynamesranking2005.txt", "2005");
			loadFile("babynamesranking2006.txt", "2006");
			loadFile("babynamesranking2007.txt", "2007");
			loadFile("babynamesranking2008.txt", "2008");
			loadFile("babynamesranking2009.txt", "2009");
			loadFile("babynamesranking2010.txt", "2010");
			
		
	}
	
	public void loadFile(String filename, String year){
		
		try {
			raf = new RandomAccessFile(filename, "r");
			do{
			String line = raf.readLine();
			Person tempM = new Person();
			Person tempF = new Person();
			
		
			try {
		    mNFN = line.split("\\s+");
			
			tempM.ranking = mNFN[0];
			tempF.ranking = mNFN[0];
			tempM.name = mNFN[1];
			tempM.number = mNFN[2];
			tempF.name = mNFN[3];
			tempF.number = mNFN[4];
			tempF.gender = "Girl";
			tempM.gender = "Boy";
		
			
			
			
			switch (year) {
			case "2001":
				
				
				y2001.boy.add(tempM);
				y2001.girl.add(tempF);
				break;
			case "2002":
				
				y2002.boy.add(tempM);
				y2002.girl.add(tempF);
				break;
			case "2003":
				
				y2003.boy.add(tempM);
				y2003.girl.add(tempF);
				break;
			case "2004":
				
				y2004.boy.add(tempM);
				y2004.girl.add(tempF);
				break;
			case "2005":
				
				y2005.boy.add(tempM);
				y2005.girl.add(tempF);				
				break;
			case "2006":
				
				y2006.boy.add(tempM);
				y2006.girl.add(tempF);
				break;
			case "2007":
				
				y2007.boy.add(tempM);
				y2007.girl.add(tempF);
				break;
			case "2008":
				
				y2008.boy.add(tempM);
				y2008.girl.add(tempF);
				break;
			case "2009":
				
				y2009.boy.add(tempM);
				y2009.girl.add(tempF);
				break;
			case "2010":
				
				y2010.boy.add(tempM);
				y2010.girl.add(tempF);
				break;
			
			}
			
			
			}catch(Exception err){
			System.out.println("b4 file" + err );	
			}
			}while(raf.length() > raf.getFilePointer());
				//count++;
		} catch (Exception e) {
		System.out.print(e + "\n");
		};
		
	}
	
	public String findName(String name, char Gender, String year) {
		
		Person temp = null;
		switch (year) {
		case "2001":
			
			temp = y2001.findName(name, Gender);
			System.out.println(temp);
			break;
		case "2002":
			temp = 	y2002.findName(name, Gender);
			break;
		case "2003":
			temp = y2003.findName(name, Gender);
			break;
		case "2004":
			temp = y2004.findName(name, Gender);
			break;
		case "2005":
			temp = y2005.findName(name, Gender);
			break;
		case "2006":
			temp = 	y2006.findName(name, Gender);
			break;
		case "2007":
			temp = y2007.findName(name, Gender);
			break;
		case "2008":
			temp = y2008.findName(name, Gender);
			break;
		case "2009":
			temp = 	y2009.findName(name, Gender);
			break;
		case "2010":
			temp = y2010.findName(name, Gender);
			break;
		
		}
	
				
		return temp.gender + " name " + temp.name + " is ranked # " + temp.ranking + " in " + year;
				

	}
	
	
}
