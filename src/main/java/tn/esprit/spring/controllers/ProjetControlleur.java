package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.projet;
import tn.esprit.spring.services.IServiceProjet;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Projets")
public class ProjetControlleur {
	@Autowired
	IServiceProjet ProjetService;

	@GetMapping("/AfficheProjets")
	public ResponseEntity<List<projet>> AfficheProjets (){
		List<projet> P;
		
	@GetMapping("/AfficheProjet/{id}")
	public ResponseEntity<projet> AfficheProjet (@PathVariable Long id){
		projet P= ProjetService.retrieveProjet(id);
		if (P==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(P, HttpStatus.OK);
	}
	
	@PostMapping("/add-projet")
	addProjet(p);
	}
	
	@rojet/{id}")
	public projet ModifierProjet(@PathVariable Long id,@RequestBody projet P){
		
		
		return ProjetService.updateProjet(id,P);
		
		}
	
	@DeleteMapping("/deleteProjet/{id}")
	public void deleteProjet(@PathVariable("id") Long idP)
	{
		ProjetService.removeProjet(idP);
	}
	
	@GetMapping("/FindBytitle/{titre}")
	public ResponseEntity<List<projet> > AfficheProjetParTitre (@PathVariable String titre){
		List<projet>  P= ProjetService.FindbyTitre(titre);
		if (P==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(P, HttpStatus.OK);
	}
}
