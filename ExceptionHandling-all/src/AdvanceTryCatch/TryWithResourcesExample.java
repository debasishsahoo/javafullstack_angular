package AdvanceTryCatch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesExample {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("input.txt");
				FileOutputStream fos = new FileOutputStream("output.txt");
				BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {

			System.out.println("Reading from input.txt and writing to output.txt...");
			// Copy data from input.txt → output.txt
			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			System.out.println("Reading first line from data.txt:");
			String line = br.readLine();
			System.out.println(line);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n All resources automatically closed in reverse order!");

	}

	private static void createSampleFile() {
		try (FileWriter fw1 = new FileWriter("input.txt"); FileWriter fw2 = new FileWriter("data.txt")) {
			fw1.write("Hello World from input.txt!");
			fw2.write("This is the first line in data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
