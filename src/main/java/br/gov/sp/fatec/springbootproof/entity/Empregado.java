package br.gov.sp.fatec.springbootproof.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "emp_empregado")
public class Empregado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_id")
  private Long id;

  @Column(name = "emp_nome_completo")
  private String nomeCompleto;

  @Column(name = "emp_ctps")
  private Long ctps;

  @Column(name = "emp_data_hora_cadastro")
  private Date dataHoraCadastro;

  @Column(name = "emp_email")
  private String email;

  @Column(name = "emp_carga_horaria")
  private Float cargaHoraria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Long getCtps() {
        return ctps;
    }

    public void setCtps(Long ctps) {
        this.ctps = ctps;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
