package app.crud.security;

import app.crud.model.Usuario;
import app.crud.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String cpf)
            throws UsernameNotFoundException {
        // Usuario loga bo sistema com o cpf
        Usuario usuario = repositoryUsuario.findByCpf(cpf)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado com CPF " + cpf)
        );

        return DetalhesUsuario.create(usuario);
    }

    // Usado no JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        Usuario usuario = repositoryUsuario.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("Usuario nao encontrado com a id: " + id)
        );

        return DetalhesUsuario.create(usuario);
    }
}
