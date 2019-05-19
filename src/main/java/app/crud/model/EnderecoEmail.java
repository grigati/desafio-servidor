package app.crud.model;

import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Table(name = "tb_email")
public class EnderecoEmail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Email
    @Column(name = "email")
    private String email;

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
  	* Returns value of email
  	* @return
  	*/
  	public String getEmail() {
  		return email;
  	}

  	/**
  	* Sets new value of email
  	* @param
  	*/
  	public void setEmail(String email) {
  		this.email = email;
  	}
  }
