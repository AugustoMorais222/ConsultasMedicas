package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
