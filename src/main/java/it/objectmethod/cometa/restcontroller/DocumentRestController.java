package it.objectmethod.cometa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.cometa.domain.Articolo;
import it.objectmethod.cometa.domain.Documento;
import it.objectmethod.cometa.domain.Lotto;
import it.objectmethod.cometa.domain.ProfiloDocumento;
import it.objectmethod.cometa.domain.RigaDocumento;
import it.objectmethod.cometa.repository.ArticoloRepository;
import it.objectmethod.cometa.repository.DocumentoRepository;
import it.objectmethod.cometa.repository.LottoRepository;
import it.objectmethod.cometa.repository.ProfiloDocumentoRepository;
import it.objectmethod.cometa.repository.RigaDocumentoRepository;

@RestController
public class DocumentRestController {

	@Autowired
	private DocumentoRepository documentoRepository;

	@Autowired
	private ProfiloDocumentoRepository profiloDocumentoRepository;

	@Autowired
	private RigaDocumentoRepository rigaDocumentoRepository;

	@Autowired
	private ArticoloRepository articoloRepository;

	@Autowired
	private LottoRepository lottoRepository;

	@CrossOrigin
	@PostMapping("/insertDocument")
	public String insertDocumentTodb(@RequestParam("codice") String codice, @RequestParam("data") String data,
			@RequestBody RigaDocumento[] righeDoc) {

		Long idProfDoc = null;
		Long idDoc = null;
		String returnMess = "ok";

		idProfDoc = insertToDBProfileDoc(codice);
		idDoc = insertDocToDB(idProfDoc, data);
		insertRowToDB(idDoc, righeDoc);

		return returnMess;
	}

	@CrossOrigin
	@PostMapping("/checkRow")
	public String checkRow(@RequestParam("codice") String tipoDoc, @RequestBody RigaDocumento row) {
		String message = "ok";
		String codice= null;
		
		if (tipoDoc.equals("Carico")) {
			
			codice=row.getIdArticolo();
			Articolo article = articoloRepository.findArticleForCode(codice);
			
			if (article == null) {
				message = "Article missing";
			}

		} else if (tipoDoc.equals("Scarico")) {
			codice=row.getIdLotto();
			Lotto lotto = lottoRepository.findLottoForCode(codice);
			if (lotto == null) {
				message = "Lotto missing";
			}

		}
		return message;
	}

	@CrossOrigin
	@GetMapping("/getProgressNumber")
	public Long getProgressNumber() {
		
		Long progressNumber=null;
		
		progressNumber = documentoRepository.findLastProgressNumberDocument();
		if(progressNumber == null) {
			progressNumber = Long.parseLong("0");
		}
		
		return progressNumber + 1;
	}
	
	// =============================================\\

	private void insertRowToDB(Long idDoc, RigaDocumento[] righeDoc) {
		for (int i = 0; i < righeDoc.length; i++) {

			righeDoc[i].setIdDocumento(idDoc);
			rigaDocumentoRepository.save(righeDoc[i]);
		}
	}

	private Long insertDocToDB(Long idProfDoc, String data) {
		Documento doc = new Documento();
		doc.setData(data);
		doc.setIdProfiloDocumento(idProfDoc);

		doc = documentoRepository.saveAndFlush(doc);
		return doc.getId();
	}

	private Long insertToDBProfileDoc(String codice) {

		char movMerci = '0';

		if (codice.equals("carico")) {
			movMerci = '+';
		} else if (codice.equals("scarico")) {
			movMerci = '-';
		}

		ProfiloDocumento profDoc = new ProfiloDocumento();
		profDoc.setCodice(codice);
		profDoc.setMovimentoMerce(movMerci);

		profDoc = profiloDocumentoRepository.saveAndFlush(profDoc);

		return profDoc.getId();

	}
}
