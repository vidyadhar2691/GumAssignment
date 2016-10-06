package gum_assignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class POS_Tagging {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
		//Arraylist to store URls
		ArrayList<URL> webpages= new ArrayList<URL>();
		webpages.add(new URL("http://www.gumgum.com/"));
		webpages.add(new URL("http://www.popcrunch.com/jimmy-kimmel-engaged/"));
		webpages.add(new URL("http://gumgum-public.s3.amazonaws.com/numbers.html"));
		webpages.add(new URL("http://www.windingroad.com/articles/reviews/quick-drive-2012-bmw-z4-sdrive28i/"));
		
		//PageTagger object creation
		PageTagger obj = new PageTagger();
		PrintStream output;
		//
		for (int i=0;i<webpages.size();i++){
			String a=obj.getText(webpages.get(i)); //Extracting data from the webpages.
			//Creating output files for each URL(webpage).
			output = new PrintStream(new FileOutputStream("URL_"+Integer.toString(i+1)+"_output.txt"));
			//Tagging the extracted data.
			output.print(obj.tagText(a));
			output.close();
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		} 
		
		System.out.println("Done...Please refresh the project to view the output files.");
		
		

	}

}