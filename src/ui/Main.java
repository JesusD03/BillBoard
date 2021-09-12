package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import model.InfrastructureDepartment;

public class Main {
	
	public int EXIT_OPTION = 5;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static InfrastructureDepartment infrastructureDepartment;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		infrastructureDepartment  = new InfrastructureDepartment();
		//menu();
	}
	
	public static void menu() throws IOException {
		int answer =0;
		do {
			System.out.println("Welcome to the Infrastructure department, please choose an option:\n"+
					"1. To add a billboard\n"+
					"2. To see the billboards\n"+
					"3. To generate the dangerousness report of the billboards\n"+
					"4. To go out");
			answer = Integer.parseInt(br.readLine());
			br.close();
		} while (answer!=4);

	}
	
	public static void option(int a) throws IOException {
		switch (a) {
		case 1:
			String newBillboard = "";
			System.out.println("Ingrese el ancho, altura, si se encuentra en uso \n"+
					"y la marca de la empresa dueña de la valla publicitaria respectivamente y separados por ++");
			newBillboard = br.readLine();
			String[] parts = newBillboard.split("\\|");
			infrastructureDepartment.addBillboard(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Boolean.parseBoolean(parts[2]), parts[3]);
			break;

		default:
			break;
		}
	}
	
}
