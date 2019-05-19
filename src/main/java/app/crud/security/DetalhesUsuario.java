package app.crud.security;

import app.crud.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DetalhesUsuario implements UserDetails {
    private Long id;
    private String nome;
    private String cpf;
    @JsonIgnore
    private String senha;
    private Collection<? extends GrantedAuthority> permissoes;

    public DetalhesUsuario(Long id, String nome, String cpf, String senha, Collection<? extends GrantedAuthority> permissoes) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.permissoes = permissoes;
    }

    public static DetalhesUsuario create(Usuario usuario) {
        List<GrantedAuthority> permissoes = usuario.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new DetalhesUsuario(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getSenha(),
                permissoes
        );
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissoes;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalhesUsuario that = (DetalhesUsuario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
