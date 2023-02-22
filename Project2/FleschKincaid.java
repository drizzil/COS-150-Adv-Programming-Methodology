import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FleschKincaid {

	public static void main(String[] args) throws IOException {
		
		try {
		String dictionaryfilename = "cmudict.txt";
		
		
		String filename;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a filename: ");
		filename = keyboard.nextLine();
	
		File file = new File(filename);
		FileReader in = new FileReader(file);
		BufferedReader br = new BufferedReader(in);
		String line = br.readLine();
		String fullContent = "";
		
		while(line != null && line.length() > 0) {
		    fullContent += line;
		    line = br.readLine();
		}
		
		int length = 0;
		int count = 0;
		int senLength = 0;
		int avgSenLength = 0;
		int totWordLength = 0;
		
		String largestSentence = null;
		for(String sentence : getSentences(fullContent)) {
		    
		    int maxSenLength = 0;
		    String longestSentence = null;
		    maxSenLength = getMaxSentence(sentence);
		    if (count == 0) {
		    	maxSenLength++;
		    }
		    // System.out.println(maxSenLength);
		    avgSenLength = maxSenLength + avgSenLength;
		    if (maxSenLength > senLength) {
		    	longestSentence = sentence;
		    	senLength = maxSenLength;
		    }
		    count++;
		}
		
		int totSyl = 0;
		
		// Scanner txtscan = new Scanner(new File("cmudict.txt"));
		
		for(String sentence: getSentences(fullContent)) {
			String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			
			for (int i = 0; i < words.length; i++) {
				FileReader freader = new FileReader(dictionaryfilename);
				BufferedReader inputFile = new BufferedReader(freader);
				
				
				totWordLength = words[i].length() + totWordLength;
				String upperCase = words[i].toUpperCase();
				
				
				int sylAmt = totalSyllables(upperCase, inputFile);
				totSyl = sylAmt + totSyl;
			}


			int maxWordLength = 0;
		    maxWordLength = getMaxWordLength(sentence, maxWordLength);
		    
		    
		    if(maxWordLength > length) {
		        largestSentence = sentence;
		        length = maxWordLength;
		    }
		}
		
		
		double avgSenLenDouble = avgSenLength;
		double countDouble = count;
		double avgSen = avgSenLenDouble/countDouble;
		double totWordLengthDouble = totWordLength;
		double avgWord = totWordLengthDouble/avgSenLenDouble;
		double totSylDouble = totSyl;
		double avgSylDouble = totSylDouble/avgSenLenDouble;
		
		double readingEase = 206.835 - 1.015 * (avgSenLength/count) - 84.6 * (totSyl/avgSenLength);
		double gradeLevel = 0.39 * (avgSenLength/count) + 11.8 * (totSyl/avgSenLength) - 15.59;
		
		
		
		
		DecimalFormat df = new DecimalFormat("#.0");
		
		System.out.println("Character count: 	" + totWordLength);
		System.out.println("Syllable count:		" + totSyl);
		System.out.println("Word count: 		" + avgSenLength);
		System.out.println("Sentence count: 	" + count);
		System.out.println("Characters per word: 	" + df.format(avgWord));
		System.out.println("Syllables per word: 	" + df.format(avgSylDouble));
		System.out.println("Words per sentence:	" + df.format(avgSen));
		System.out.println("Longest word: 		" + length);
		System.out.println("Longest sentence:	" + senLength);
		System.out.println();
		System.out.println("Flesch-Kincaid Reading Ease =	" + df.format(readingEase));
		System.out.println("Flesch-Kincaid Grade Level =	" + df.format(gradeLevel));
		
		keyboard.close();
	}
	catch (FileNotFoundException e) {
		System.out.println("The file was NOT found.");
		System.out.println(e.getMessage());
	}
}

	
	
	private static String[] getSentences(String file) {
	     return file.split("\\.");          
	}
	
	public static int getMaxSentence(String sentence) {
		int senLen = sentence.split(" ").length - 1;
		return senLen;
	}
	
	public static int getMaxWordLength(String sentence, int maxWordLength) {
	    for(String word : sentence.split(" ")) {
	        int wordLength = word.trim().length();
	        if(wordLength > maxWordLength) {
	            maxWordLength = wordLength; 
	        }
	    }
	    return maxWordLength;
	}
	
	public static int totalWords(String sentence) {
		String[] senArr = sentence.split(" ");
		int wordLength = senArr.length;
		return wordLength;
	}

	public static int totalSyllables(String word, BufferedReader inputFile) throws IOException {
		// System.out.println(word);
		int count = 0;
		String line;
        while((line = inputFile.readLine()) != null) {
            if((line.contains(word))) {
            	String[] sen = line.split(" ");
            	if (sen[0].equals(word)) {
            		// System.out.println(line);
            		String str = line;
            		str = str.replaceAll("[^0-9]", "");
                    count = str.length();
                    break;
            	}
            	// System.out.println(line);
                // count++;
                // break;
                // System.out.println("Number of instances of String " + count);
            }
            else {
            	count = 1;
            }
        }
        return count;
	}

}


/*
 * 
 * NOTES:
 * Each version of the chapter John 2 were pretty similar. Small variances in stuff like 
 * character count but all were pretty close.
 * 
 * Version			Reading Ease			Grade Level
 * NLT				107.0					2.1
 * KJV				97.9					5.6
 * NASB				95.8					6.4
 * NIV				103.0					3.6
 * 
 * NIV is the easiest and NASB is the hardest. Unrealistic results since the formula 
 * doesn't account for the difficulty of old English, but still pretty nice for a 
 * rough guideline.
 * 
 * 
 * https://www.w3schools.com/java/ref_string_touppercase.asp
 * https://stackoverflow.com/questions/36917209/how-to-quickly-search-a-large-file-for-a-string-in-java
 * 
 */