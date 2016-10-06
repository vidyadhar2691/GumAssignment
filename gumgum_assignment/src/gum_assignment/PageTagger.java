package gum_assignment;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class PageTagger {
	//Initiating MaxentTagger
	MaxentTagger tag = new MaxentTagger("taggers/english-left3words-distsim.tagger");
	public String tagText(String text){		
				
		//Splitting data into array to avoid java.lang.OutOfMemoryError: GC overhead limit exceeded
		String[] new_text=text.split(" ");
		String tagged_text="";
		for (int i=0; i<new_text.length;i++){
			tagged_text=tagged_text.concat(tag.tagString(new_text[i]));
		}		
		return tagged_text;
	}
	
	public String getText(URL url){
		
		String data ="";
		try {
			//Parsing data from webpage
			Connection conn= Jsoup.connect(url.toString()).maxBodySize(0);
			Document doc=Jsoup.parse(conn.get().html());
			data =doc.body().text();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);;
		}
		return data.trim();
		
		
		
		
	}

}
