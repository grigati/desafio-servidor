package app.crud.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tb_operacao")
public class Operacao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Usuario responsavel;

    @Column(name = "data")
    private Date dataOperacao;

    @Column(name = "descricao")
    private String descricao;

  	/**
  	* Returns value of id
  	* @return
  	*/
  	public Long getId() {
  		return id;
  	}

  	/**
  	* Sets new value of id
  	* @param
  	*/
  	public void setId(Long id) {
  		this.id = id;
  	}

  	/**
  	* Returns value of responsavel
  	* @return
  	*/
  	public Usuario getResponsavel() {
  		return responsavel;
  	}

  	/**
  	* Sets new value of responsavel
  	* @param
  	*/
  	public void setResponsavel(Usuario responsavel) {
  		this.responsavel = responsavel;
  	}

  	/**
  	* Returns value of dataOperacao
  	* @return
  	*/
  	public Date getDataOperacao() {
  		return dataOperacao;
  	}

  	/**
  	* Sets new value of dataOperacao
  	* @param
  	*/
  	public void setDataOperacao(Date dataOperacao) {
  		this.dataOperacao = dataOperacao;
  	}

  	/**
  	* Returns value of descricao
  	* @return
  	*/
  	public String getDescricao() {
  		return descricao;
  	}

  	/**
  	* Sets new value of descricao
  	* @param
  	*/
  	public void setDescricao(String descricao) {
  		this.descricao = descricao;
  	}
}
