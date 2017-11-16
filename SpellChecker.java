import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

   /**
    * This method takes in a filename and spells check it	
    * @param filename an input file stream (i.e. bonk.txt)	
    * @return ArrayList<String> list of words not found in dictionary 
    */
    public ArrayList<String> spell(String filename) throws IOException {
    	ArrayList<String> return_list = new ArrayList<String>();
    	
    	BufferedReader br1 = null;
		FileReader fr1 = null;
		fr1 = new FileReader("dictionary.txt");
		br1 = new BufferedReader(fr1);
		String dictionary[];
		String sCurrentLine;
		int values = 0;
		while((sCurrentLine = br1.readLine()) != null)
			++values;
		
		br1.close();
		fr1.close();
		fr1 = new FileReader("dictionary.txt");
		br1 = new BufferedReader(fr1);
		
		dictionary = new String[values];
		int i = 0;
		while((sCurrentLine = br1.readLine()) != null)
		{
			dictionary[i++] = sCurrentLine;
		}
		br1.close();
		fr1.close();
		
		fr1 = new FileReader(filename);
		br1 = new BufferedReader(fr1);
		while((sCurrentLine = br1.readLine()) != null)
		{
			sCurrentLine = sCurrentLine.replaceAll("[\\/().,\":\t\n\r0123456789]", "");
			sCurrentLine = sCurrentLine.replaceAll("[-]", " ");
			String words[] = sCurrentLine.split(" ");
			for(i = 0; i < words.length; ++i)
			{
				if(words[i].matches("\n"))
					continue;
				if(!inDictionary(words[i].toLowerCase().trim(),dictionary))
					if(!return_list.contains(words[i]))
						if(!words[i].matches(""))
							return_list.add(words[i]);
			}
		}
		br1.close();
		fr1.close();
		return return_list;
		
    }

   /**
    * This method takes the list of words not found in the dictionary	
    * and prints a list of non-duplicate words
    * @param ArrayList<String> List of words not found in dictionary	
    */
    public void printNonDuplicates(ArrayList<String> t) {
    	for(int i = 0; i < t.size(); ++i)
    		System.out.println(t.get(i));
    }
   
   /**
    * This method returns true if a word in input file stream	
    * (i.e. bonk.txt) is in the dictionary, false otherwise.	
    * @param word a string that contains a word to be checked	
    * @return the boolean status of the word (i.e. true or false)	
    */
    public boolean inDictionary(String word, String[] dictionary) {
    	for(int i = 0; i < dictionary.length; ++i)
    		if(dictionary[i].toLowerCase().matches(word))
    			return true;
    	return false;
    }

    public static void main(String[] args) {
      // Prompt the user to enter a file to be spell checked
      Scanner scanner = new Scanner( System.in );
      System.out.print( "Input the filename: " );
      String input = scanner.nextLine();
      
      SpellChecker sc = new SpellChecker();
	  try{
		  sc.printNonDuplicates(sc.spell(input));
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
    }
}
