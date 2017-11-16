import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Resistor {
	
	public static void saveGood(double R1, double R2, double R3, double R4, double R5, double R6) throws IOException

{
		BufferedWriter writer = new BufferedWriter(new FileWriter("good.txt"));
		String return_string = R1 + "\t" + R2 + "\t" + R3 + "\t" + R4 + "\t" + R5 + "\t" + R6 + "\n";
		writer.append(return_string);
		writer.close();
	}
	
	public static void main(String[] args) {
		String filename = args[0];
		BufferedReader br = null;
		FileReader fr = null;
		
    try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			System.out.println("Reading filename: " + filename);
			
			System.out.println("Saving good designs to good.txt");
			System.out.println("The following are bad designs: ");
			String sCurrentLine;
			while((sCurrentLine = br.readLine()) != null)
			{
	
        String number[] = sCurrentLine.split("\t");
				double R1 = Double.parseDouble(number[0]);
				double R2 = Double.parseDouble(number[1]);
				double R3 = Double.parseDouble(number[2]);
				double R4 = Double.parseDouble(number[3]);
				double R5 = Double.parseDouble(number[4]);
				double R6 = Double.parseDouble(number[5]);
				
				double upper = (R1 + R2)*R4*R6;
				double down = (R3 + R4)*R1*R5;
				if(upper/down == 7.5)
					saveGood(R1,R2,R3,R4,R5,R6);
				else
					System.out.println((int)R1 + "\t" + (int)R2 + "\t" + (int)R3 + "\t" + (int)R4 + "\t" + (int)R5 + "\t" + (int)R6);
					
			}
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
