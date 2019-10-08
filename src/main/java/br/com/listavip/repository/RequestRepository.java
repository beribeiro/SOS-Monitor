package br.com.listavip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.listavip.model.Requests;

@Repository
public interface RequestRepository extends CrudRepository<Requests, Long> {

	
	@Query("SELECT a FROM Requests a WHERE a.Aberto = 'Sim' AND a.ultimo_analista IN (:analysts) ORDER BY a.Data")
    public List<Requests> findAllOpenRequestsOrderByDate(@Param("analysts") List <String> analysts);
	
}
