package br.gov.sp.fatec.springbootproof.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootproof.entity.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{

}