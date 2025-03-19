package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
}
