package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import model.InfrastructureDepartment;

public class Main {
	
	public int EXIT_OPTION = 5;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static InfrastructureDepartment infrastructureDepartment;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		infrastructureDepartment  = new InfrastructureDepartment();
		menu();
	}
	
	public static void menu() throws IOException {
		int answer =0;
		do {
			System.out.println("==================================================================\n"+
					"Welcome to the Infrastructure department, please choose an option:\n"+
					"==================================================================\n"+
					"1. To add a billboard\n"+
					"2. To see the billboards\n"+
					"3. To generate the dangerousness report of the billboards\n"+
					"4. To go out");
			answer = Integer.parseInt(br.readLine());
			option(answer);
		} while (answer!=4);
			br.close();
			System.out.println("Bye!");
	}
	
	public static void option(int a) throws IOException {
		switch (a) {
		case 1:
			String newBillboard = "";
			System.out.println("Enter width, height, if in use (true or false) \n"+
					"and the brand of the company that owns the billboard respectively and separated by ++\n"+
					"Example: 200++300++true++Canal Caracol");
			newBillboard = br.readLine();
			String[] parts = newBillboard.split("\\++");
			infrastructureDepartment.addBillboard(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Boolean.parseBoolean(parts[2]), parts[3]);
			infrastructureDepartment.saveBillboards();
			break;
		case 2:
			System.out.println(infrastructureDepartment.toString());
			break;
		case 3:
			infrastructureDepartment.exportDangerousBillboardReport("exportar");
			FileOutputStream os = new FileOutputStream("report.txt");
			PrintStream ps = new PrintStream(os);
			ps.println("prueba de impresión realizada");
			break;
		default:
			break;
		}
	}
	
}
