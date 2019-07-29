package it.objectmethod.cometa.restcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.opencsv.CSVReader;

import it.objectmethod.cometa.domain.Articolo;
import it.objectmethod.cometa.repository.ArticoloRepository;

@RestController
public class ArticoliRestController {

	@Autowired
	private ArticoloRepository articoloRepository;
	
	public void insertToDB(String line) {
		String [] data = line.split(";");
		
		Articolo articolo = new Articolo();
		articolo.setId(Long.parseLong(data[0].substring(1, data[0].length()-1)));
		articolo.setCodice(data[1].substring(1, data[1].length()-1));
		articolo.setDescrizione(data[2].substring(1, data[2].length()-1));
		
		articoloRepository.save(articolo);		
	}
	
	@CrossOrigin
	@PostMapping("/readFileArticoli")
	public String uploadFile(@RequestParam("articoli") MultipartFile file) throws Exception {
		
		BufferedReader br;
		try {

		     String line;
		     InputStream is = file.getInputStream();
		     br = new BufferedReader(new InputStreamReader(is));
		     while ((line = br.readLine()) != null) {
		    	 insertToDB(line);
		     }

		  } catch (IOException e) {
		    System.err.println(e.getMessage());       
		  }
		return "ok";
	}
	
	@CrossOrigin
	@GetMapping("/getAllArticles")
	public List<Articolo> getAllArticles(){
		List<Articolo> articles=null;
		
		articles=articoloRepository.findAll();
		
		return articles;
		
	}

}
