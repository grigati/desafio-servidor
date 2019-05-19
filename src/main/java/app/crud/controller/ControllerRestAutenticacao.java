package app.crud.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import app.crud.payload.ResponseAutenticacao;
import app.crud.payload.SolicitacaoLogin;
import app.crud.repository.RepositoryUsuario;
import app.crud.repository.RepositoryRole;
import app.crud.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class ControllerRestAutenticacao {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Autowired
    RepositoryRole repositoryRole;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/entrar")
    public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody SolicitacaoLogin login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getCpf(),
                        login.getSenha()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new ResponseAutenticacao(jwt));
    }
}
