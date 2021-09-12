package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {
	
	public String BILLBOARD_FILE_NAME = "data/BillboardDataExported.csv";
	private List<Billboard> billboards;

	public InfrastructureDepartment() throws FileNotFoundException, IOException {
		billboards = new ArrayList <Billboard>();
		loadBillboards();
	}
	
	public void addBillboard(double w, double h, boolean iu, String b) throws FileNotFoundException, IOException {
		billboards.add(new Billboard(w, h, iu, b));
	}
	
	public void saveBillboards() throws FileNotFoundException, IOException {
		//Document csv
		FileWriter fw = new FileWriter(BILLBOARD_FILE_NAME, false);
		fw.write("width|height|inUse|brand\n");
		
		for(int i=0; i < billboards.size(); i++) {
			Billboard myBillboards = billboards.get(i);
			fw.write(myBillboards.getWidth()+"|"+myBillboards.getHeigth()+"|"+myBillboards.isInUse()+"|"+myBillboards.getBrand()+"\n");;
		}
		
		fw.close();
		//Archive serialized
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("data/Billboards.apo2")));
		oos.writeObject(billboards);
		oos.close();
	}
	
	private void loadBillboards() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(BILLBOARD_FILE_NAME));
		String line = br.readLine();
		if(line.equalsIgnoreCase("width|height|inUse|brand")) {
			line = br.readLine();
		}
		
		while(line!=null) {
			String[] parts = line.split("\\|");
			addBillboard(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Boolean.parseBoolean(parts[2]), parts[3]);
			line = br.readLine();
		}
		br.close();
	}
	
	public void exportDangerousBillboardReport(String fn) throws IOException {
		FileWriter fwEX = new FileWriter("data/report.txt", false);
		fwEX.write("==========================\n"+
				"DANGEROUS BILLBOARD REPORT\n"+
				"==========================\n"+
				"The dangerous billboard are:\n");

		for(int i=0; i < billboards.size(); i++) {
			if (billboards.get(i).calculateArea()>=160) {
				Billboard exBillboards = billboards.get(i);
				fwEX.write((i+1)+". Billboard "+exBillboards.getBrand()+" with area "+ exBillboards.calculateArea()+"\n");
			}	
		}

		fwEX.close();
	}
	
	public void importData(String fn) {
		// no supe para que usar este metodo, pero estaba en el diagrama asi que lo dejo aqui uwu
	}
	
	public String toString() {
		String answer= "";
		answer+="w		h		inUse		Brand\n";
		for (int i = 0; i<billboards.size(); i++) {
			answer+=(billboards.get(i).getWidth()+"		"+billboards.get(i).getHeigth()+"		"+billboards.get(i).isInUse()+"		"+billboards.get(i).getBrand()+"		\n");;
			
		}
		answer+="\nTOTAL: "+ billboards.size() + " vallas";
		return answer;
	}

	public List<Billboard> getBillboards() {
		return billboards;
	}
	
	
	
}
