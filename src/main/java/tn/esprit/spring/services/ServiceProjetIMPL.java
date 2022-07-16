package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.projet;
import tn.esprit.spring.repository.ProjetRepository;

@Service
public class ServiceProjetIMPL implements IServiceProjet{
@Autowired
ProjetRepository ProjetRepo;
@Override
	public projet addProjet(projet p) {
		// TODO Auto-generated method stub
	System.out.println(p.getChef());
		return ProjetRepo.save(p);
	}
@Override
	public void removeProjet(Long id) {
		ProjetRepo.deleteById(id);
		
	}
@Override
	public List<projet> retrieveAllProjets() {
		// TODO Auto-generated method stub
		return ProjetRepo.findAll();
	}
	@Override
		public projet retrieveProjet(Long id) {
			// TODO Auto-generated method stub
		return ProjetRepo.findById(id).orElseThrow(null);
		}
	@Override
		public projet updateProjet(Long id,projet p) {
			Optional<projet> projetData= ProjetRepo.findById(id);
			
			if (projetData.isPresent()) {
				projet _projet = projetData.get();
				_projet.setTitre(p.getTitre());
				_projet.setDescription(p.getDescription());
				_projet.setChef(p.getChef());
				return ProjetRepo.save(_projet);
			}
			else
		return null;
		}
	@Override
		public List<projet> PorjetFermer() {
			
			return null;
		}
		
		@Override
			public List<projet>  FindbyTitre(String titre) {
				
				return ProjetRepo.findByTitre(titre);
			}


}
