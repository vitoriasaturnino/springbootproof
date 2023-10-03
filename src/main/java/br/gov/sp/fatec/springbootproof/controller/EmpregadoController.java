package br.gov.sp.fatec.springbootproof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.sp.fatec.springbootproof.entity.Empregado;
import br.gov.sp.fatec.springbootproof.service.EmpregadoService;

import java.util.List;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {

  @Autowired
  private EmpregadoService empregadoService;

  @PostMapping("/criar")
  public ResponseEntity<Empregado> createEmpregado(@RequestBody Empregado empregado) {
    Empregado novoEmpregado = empregadoService.createEmpregado(empregado);
    return new ResponseEntity<>(novoEmpregado, HttpStatus.CREATED);
  }

  @GetMapping("/todos")
  public ResponseEntity<List<Empregado>> getAllEmpregados() {
    List<Empregado> empregados = empregadoService.getAllEmpregados();
    return new ResponseEntity<>(empregados, HttpStatus.OK);
  }

  @GetMapping("/buscar")
  public ResponseEntity<List<Empregado>> buscarPorCtpsOuEmail(
      @RequestParam(name = "ctps", required = false) Long ctps, 
      @RequestParam(name = "email", required = false) String email) {

    List<Empregado> empregados = empregadoService.buscarEmpregados(ctps, email);

    if (empregados != null && !empregados.isEmpty()) {
      return new ResponseEntity<>(empregados, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}