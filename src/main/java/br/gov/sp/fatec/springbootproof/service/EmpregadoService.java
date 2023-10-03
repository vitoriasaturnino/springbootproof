package br.gov.sp.fatec.springbootproof.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

import br.gov.sp.fatec.springbootproof.entity.Empregado;
//import br.gov.sp.fatec.springbootproof.interfaces.IEmpregadoService;
import br.gov.sp.fatec.springbootproof.repository.EmpregadoRepository;

@Service
public class EmpregadoService {

  @Autowired
  private EmpregadoRepository empregadoRepo;
    
  @Transactional
  public Empregado createEmpregado(Empregado empregado) {
    if (empregado == null ||
        empregado.getNomeCompleto() == null ||
        empregado.getNomeCompleto().isBlank() ||
        empregado.getCtps() == null ||
        empregado.getDataHoraCadastro() == null ||
        empregado.getEmail() == null ||
        empregado.getEmail().isBlank()) {
      throw new IllegalArgumentException("Dados inválidos!");
    }
    try {
      return empregadoRepo.save(empregado);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao inserir empregado!");
    }
  }

  public List<Empregado> getAllEmpregados() {
    return empregadoRepo.findAll();
  }

  public Empregado getByCtps(Long ctps) {
    return empregadoRepo.findByCtps(ctps);
  }

  public Empregado getByEmail(String email) {
    return empregadoRepo.findByEmail(email);
  }
}