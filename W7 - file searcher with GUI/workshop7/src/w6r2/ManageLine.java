package w6r2;

import java.io.RandomAccessFile;

public class ManageLine {

	RandomAccessFile raf;
	String rafname = "address.txt";
	int pos = 2;
	int addressIndex = 1;
	static int count;



	void begin() {
		count = 0;
		try {
			raf = new RandomAccessFile(rafname, "rw");
			while(raf.readLine() != null)
				count++;
		} catch (Exception e) {
		System.out.print(e + "\n");
		};
	};
	
	int returnCounter() {
		return count;
	};

	void write(String firstName, String lastName, String city, String province, String postalCode) {
		try {
			raf = new RandomAccessFile(rafname, "rw");
			String newline = "\r\n";
			if(returnCounter() > 1) {
				pos = 2 + (returnCounter() * 129);
			};
			raf.seek(pos);
			pos = pos + 21;		
			raf.seek(pos);
			raf.write(limitFieldSize(firstName).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(lastName).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(city).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(province).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(postalCode).getBytes());		
			raf.write(newline.getBytes());
			pos = pos + 24;	
			raf.close();
		} catch (Exception e) {
			System.out.print(e + "\n");
		};

	};

	String getRow(int line) {
		String person = "\0";
		int x = 1;
		try {
			RandomAccessFile raf = new RandomAccessFile(rafname, "r");
			while ((person = raf.readLine()) != null) {
				if (x == line) {
					break;
				} else {
					x++;
				};
			}raf.close();
		} catch (Exception e) {
			System.out.print(e + "\n");
		};
		return person;
	};

	String sendData(int index, String field) {
		String fill = "\0"; 
		String person = getRow(index);
		switch (field) { 
		case "firstNameString": 
			fill = person.substring(23, 43);
			break;
		case "lastNameString":
			fill = person.substring(44, 63);
			break;
		case "cityString":
			fill = person.substring(65, 83);
			break;
		case "provinceString":
			fill = person.substring(86, 103);
			break;
		case "postalCodeString":
			fill = person.substring(107, person.length());
		};
		return fill;
	};

	void update(int addressIndex, String firstName, String lastName, String city, String province, String postalCode) {
		String persons = "Address Index: " + addressIndex;
		try {
			raf = new RandomAccessFile(rafname, "rw");
			int pos = (2 + (129 * (addressIndex - 1))); 
			raf.seek(pos);
			raf.write(limitFieldSize(persons).getBytes());
			addressIndex = addressIndex + 1;
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(firstName).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(lastName).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(city).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(province).getBytes());
			pos = pos + 21;
			raf.seek(pos);
			raf.write(limitFieldSize(postalCode).getBytes());
			pos = pos + 24;
			raf.write(("\r\n").getBytes());
			raf.close();
		} catch (Exception e) {
			System.out.print(e + "\n");
		};
	};
	
	
	String limitFieldSize(String data) {
		int buffer = 20 - data.length();
		String temp = data;
		for (int i = 0; i < buffer; i++) {
			temp = temp + " ";
		};
		return temp;
	};
};