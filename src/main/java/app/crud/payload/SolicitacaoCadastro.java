package app.crud.payload;

import javax.validation.constraints.NotBlank;

public class SolicitacaoCadastro {
    @NotBlank
    private String cpf;

    @NotBlank
    private String senha;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
