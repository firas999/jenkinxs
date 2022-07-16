package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.projet;

@Repository
public interface ProjetRepository extends JpaRepository<projet, Long>  {
	List<projet> findByTitre(String titre);
}
