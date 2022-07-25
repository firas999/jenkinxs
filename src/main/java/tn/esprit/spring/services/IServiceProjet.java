package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.projet;

public interface IServiceProjet {
	List<projet> retrieveAllProjets();

	projet addProjet(projet p);

	projet updateProjet(Long id,projet p);

	pro
	
}
