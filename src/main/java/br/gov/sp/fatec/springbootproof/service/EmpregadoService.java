package br.gov.sp.fatec.springbootproof.service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springbootproof.entity.Empregado;
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
        empregado.getEmail() == null ||
        empregado.getEmail().isBlank()) {
      throw new IllegalArgumentException("Dados inválidos!");
    }

    empregado.setDataHoraCadastro(Date.from(Instant.now()));
    try {
      return empregadoRepo.save(empregado);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao inserir empregado!");
    }
  }

  public List<Empregado> getAllEmpregados() {
    return empregadoRepo.findAll();
  }

  public List<Empregado> buscarEmpregados(Long ctps, String email) {
    if (ctps != null && email != null) {
      return empregadoRepo.findByCtpsOrEmail(ctps, email);
    } else if (ctps != null) {
      return empregadoRepo.findByCtps(ctps);
    } else if (email != null) {
      return empregadoRepo.findByEmail(email);
    } else {
      return empregadoRepo.findAll();
    }
}
}