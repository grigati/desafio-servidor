package app.crud.payload;

import app.crud.model.Usuario;
import app.crud.model.EnderecoEmail;
import app.crud.model.Telefone;
import app.crud.model.Role;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.validation.constraints.*;
import javax.persistence.*;

public class SolicitacaoAlteracaoCadastro {
    private Long id;
    private Set<Role> roles = new HashSet<>();

    @NotNull
    @Size(min = 3)
    @Size(max = 100)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$")
    private String nome;

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String cep;

    @NotEmpty
    private String logradouro;

    @NotEmpty
    private String bairro;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String uf;

    private String complemento;

    @Size(min=1)
    private List<Telefone> telefones;

    @Size(min=1)
    private List<EnderecoEmail> emails;

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
    * Returns value of role
    * @return
    */
    public Set<Role> getRoles() {
    	return roles;
    }

    /**
    * Sets new value of role
    * @param
    */
    public void setRoles(Set<Role> roles) {
    	this.roles = roles;
    }

    /**
    * Returns value of nome
    * @return
    */
    public String getNome() {
    	return nome;
    }

    /**
    * Sets new value of nome
    * @param
    */
    public void setNome(String nome) {
    	this.nome = nome;
    }

    /**
    * Returns value of cpf
    * @return
    */
    public String getCpf() {
    	return cpf;
    }

    /**
    * Sets new value of cpf
    * @param
    */
    public void setCpf(String cpf) {
    	this.cpf = cpf;
    }

    /**
    * Returns value of cep
    * @return
    */
    public String getCep() {
    	return cep;
    }

    /**
    * Sets new value of cep
    * @param
    */
    public void setCep(String cep) {
    	this.cep = cep;
    }

    /**
    * Returns value of logradouro
    * @return
    */
    public String getLogradouro() {
    	return logradouro;
    }

    /**
    * Sets new value of logradouro
    * @param
    */
    public void setLogradouro(String logradouro) {
    	this.logradouro = logradouro;
    }

    /**
    * Returns value of bairro
    * @return
    */
    public String getBairro() {
    	return bairro;
    }

    /**
    * Sets new value of bairro
    * @param
    */
    public void setBairro(String bairro) {
    	this.bairro = bairro;
    }

    /**
    * Returns value of cidade
    * @return
    */
    public String getCidade() {
    	return cidade;
    }

    /**
    * Sets new value of cidade
    * @param
    */
    public void setCidade(String cidade) {
    	this.cidade = cidade;
    }

    /**
    * Returns value of uf
    * @return
    */
    public String getUf() {
    	return uf;
    }

    /**
    * Sets new value of uf
    * @param
    */
    public void setUf(String uf) {
    	this.uf = uf;
    }

    /**
    * Returns value of complemento
    * @return
    */
    public String getComplemento() {
    	return complemento;
    }

    /**
    * Sets new value of complemento
    * @param
    */
    public void setComplemento(String complemento) {
    	this.complemento = complemento;
    }

    /**
    * Returns value of telefones
    * @return
    */
    public List<Telefone> getTelefones() {
    	return telefones;
    }

    /**
    * Sets new value of telefones
    * @param
    */
    public void setTelefones(List<Telefone> telefones) {
    	this.telefones = telefones;
    }

    /**
    * Returns value of emails
    * @return
    */
    public List<EnderecoEmail> getEmails() {
    	return emails;
    }

    /**
    * Sets new value of emails
    * @param
    */
    public void setEmails(List<EnderecoEmail> emails) {
    	this.emails = emails;
    }

    public Usuario getUsuario() {
      Usuario usuario = new Usuario();
      usuario.setCep(cep);
      usuario.setUf(uf);
      usuario.setId(id);
      usuario.setNome(nome);
      usuario.setRoles(roles);
      usuario.setTelefones(telefones);
      usuario.setCidade(cidade);
      usuario.setBairro(bairro);
      usuario.setCpf(cpf);
      usuario.setLogradouro(logradouro);
      usuario.setComplemento(complemento);
      usuario.setEmails(emails);

      return usuario;
    }
}
