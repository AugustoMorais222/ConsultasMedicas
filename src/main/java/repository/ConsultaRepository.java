package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
