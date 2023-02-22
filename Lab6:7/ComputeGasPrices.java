import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ComputeGasPrices {

	public static void readDataFile() throws FileNotFoundException {
	
		Map<Integer, DataSet> dataByYear = new HashMap<Integer,DataSet>();
		Map<Integer, DataSet> dataByMonth = new HashMap<Integer,DataSet>();
		Map<Integer, DataRange> dataByRange = new HashMap<Integer,DataRange>();
		List<Data> dataList = new ArrayList<>();
		
		try (Scanner fileScan = new Scanner(new File("GasPrices.txt"))) {
			String line = fileScan.nextLine();
			while (fileScan.hasNext()) {
				line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(":");
				String date = lineScan.next();
				
				Integer mm = Integer.parseInt(date.split("-")[0]);
				Integer yy = Integer.parseInt(date.split("-")[2]);
				
				Float value = lineScan.nextFloat();
				
				dataList.add(new Data(date, value));
				
				DataSet y = dataByYear.get(yy);
				dataByYear.put(yy, (y == null) ? new DataSet(1,value) : y.updateValue(value));
				DataSet m = dataByMonth.get(mm);
				dataByMonth.put(mm, (m == null) ? new DataSet(1,value) : m.updateValue(value));
				DataRange r = dataByRange.get(yy);
				dataByRange.put(yy, (r == null) ? new DataRange().update(value) : r.update(value));
				lineScan.close();
			}
			System.out.println("Average by year");
			printMap1(dataByYear,"Year");
			System.out.println("Average by month");
			printMap1(dataByMonth,"Month");	
			System.out.println("Highest and lowest prices by year");
			printMap2(dataByRange,"Year");
			writeDataToFile(true, "GasPricesLowestToHighest.txt", dataList);
			writeDataToFile(false, "GasPricesHighestToLowest.txt", dataList);
		}
		catch(Exception e) {
			System.out.println("Something went wrong!");
			System.out.println(e.getMessage());
		}
	}
	
	public static void printMap1(Map<Integer, DataSet> map, String keyName){
		for (Map.Entry<Integer, DataSet> entry : map.entrySet()) {
			System.out.println(keyName + ": " + entry.getKey() + " Average: " + (entry.getValue().getValue()/entry.getValue().getCount()));
		}
	}
	
	public static void printMap2(Map<Integer, DataRange> map, String keyName){
		for (Map.Entry<Integer, DataRange> entry : map.entrySet()) {
			System.out.println(keyName + ": " + entry.getKey() + " Max: " + (entry.getValue().getMax() + " Min: " + (entry.getValue().getMin())));
		}
	}
	
	public static void writeDataToFile(boolean ascending, String filename, List<Data> dataList) {
		Collections.sort(dataList, new Comparator<Data>() {
			public int compare(Data o1, Data o2) {
				if (ascending) {
					if (o1.getPrice()>o2.getPrice()) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else {
					if(o1.getPrice()>o2.getPrice()) {
						return -1;
					}
					else {
						return 1;
					}
				}
			}
		});
		try {   
			FileWriter fw = new FileWriter(filename);   
			for(Data data:dataList)
			fw.write(data.getDate()+":"+data.getPrice()+"\n");   
			fw.close();
			System.out.println("File " + filename + " created.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readDataFile();
	}
	
}

/*
 * NOTES:
 * https://spark.apache.org/docs/latest/api/java/index.html?org/apache/spark/sql/Dataset.html
 * https://stackoverflow.com/questions/17864140/import-classes-into-java-files
 * https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it
 * https://stackoverflow.com/questions/13766209/effective-swapping-of-elements-of-an-array-in-java
 * https://beginnersbook.com/2013/12/java-arraylist-get-method-example/
 * https://stackoverflow.com/questions/18838781/converting-string-array-to-an-integer-array
 * https://www.chegg.com/homework-help/questions-and-answers/java-problem-link-gaspricetxt-https-wwwdropboxcom-s-8ysnrjas10tg5yb-gaspricestxt-dl-0-q32219005
 * https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
 * https://www.geeksforgeeks.org/list-interface-java-examples/
 * https://stackify.com/specify-handle-exceptions-java/
 * https://www.geeksforgeeks.org/collections-sort-java-examples/
 * https://www.geeksforgeeks.org/comparator-interface-java/
 * https://stackoverflow.com/questions/59080952/difficulty-with-java-program-passing-the-txt-file-into-an-array-list-to-setup-th
 */