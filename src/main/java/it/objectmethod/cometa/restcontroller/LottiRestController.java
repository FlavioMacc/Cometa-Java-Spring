package it.objectmethod.cometa.restcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.objectmethod.cometa.domain.Articolo;
import it.objectmethod.cometa.domain.Lotto;
import it.objectmethod.cometa.repository.LottoRepository;

@RestController
public class LottiRestController {
	
	@Autowired
	private LottoRepository lottoRepository;
	
	public void insertToDB(String line) {
		String [] data = line.split(";");
		
		Lotto lotto = new Lotto();
		lotto.setId(Long.parseLong(data[0].substring(1, data[0].length()-1)));
		lotto.setCodiceLotto(data[1].substring(1, data[1].length()-1));
		lotto.setIdArticolo(Long.parseLong(data[2].substring(1, data[2].length()-1)));
		lotto.setQuantita(Integer.parseInt(data[3].substring(1, data[3].length()-1)));
		lottoRepository.save(lotto);	
	}
	
	@PostMapping("/readFileLotti")
	public String uploadFile(@RequestParam("lotti") MultipartFile file) throws Exception {
		
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
	@GetMapping("/getCodeLottoForIdArticle")
	public String getIdArticleForCode(@RequestParam("idArticle") Long codice) {
		String lottoCode=null;
		Lotto lotto=null;
		
		lotto=lottoRepository.findLottoForArticleId(codice);
		lottoCode=lotto.getCodiceLotto();
		
		return lottoCode;
	}

}
