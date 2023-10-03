package br.gov.sp.fatec.springbootproof.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.springbootproof.entity.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{
    List<Empregado> findByCtpsOrEmail(Long ctps, String email);
    List<Empregado> findByCtps(Long ctps);
    List<Empregado> findByEmail(String email);
}