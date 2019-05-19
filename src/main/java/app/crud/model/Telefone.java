package app.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "telefone")
    private String telefone;

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
    * Returns value of tipo
    * @return
    */
    public String getTipo() {
    	return tipo;
    }

    /**
    * Sets new value of tipo
    * @param
    */
    public void setTipo(String tipo) {
    	this.tipo = tipo;
    }

    /**
    * Returns value of telefone
    * @return
    */
    public String getTelefone() {
    	return telefone;
    }

    /**
    * Sets new value of telefone
    * @param
    */
    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    }
    }
