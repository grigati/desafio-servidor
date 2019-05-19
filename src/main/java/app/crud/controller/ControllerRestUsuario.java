package app.crud.controller;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;
import javax.validation.Valid;
import app.crud.security.DetalhesUsuario;
import app.crud.security.UsuarioAutenticado;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.crud.repository.*;
import app.crud.model.*;

@RestController
@RequestMapping("/api")
public class ControllerRestUsuario {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Autowired
    RepositoryRole repositoryRole;

    @Autowired
    RepositoryOperacao repositoryOperacao;

    // Busca o usuário autenticado
    @GetMapping("/usuario")
    public Usuario getUsuarioAutenticado(@UsuarioAutenticado DetalhesUsuario usuario) throws Exception {
      return repositoryUsuario.findById(usuario.getId())
        .orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    // Busca todos os usuários
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() throws Exception {
        return repositoryUsuario.findAll();
    }

    // TODO: remover a senha da response
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/usuario/{id}")
    public Usuario getUsuarioPorId(@UsuarioAutenticado DetalhesUsuario usuarioAutenticado, @PathVariable(value = "id") Long id) throws Exception {
      return repositoryUsuario.findById(id)
        .orElseThrow(() -> new Exception("Usuário não encontrado com id" + id));
      }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/usuario")
    public Usuario cadastrarUsuario(@UsuarioAutenticado DetalhesUsuario usuarioAutenticado, @Valid @RequestBody Usuario usuario) throws Exception {
      RoleName roleName = usuario.getRoles().stream().findFirst().get().getName();
      Optional<Role> role = repositoryRole.findByName(roleName);
      if (!role.isPresent()) {
        throw new Exception("Não foi possível encontrar o tipo de usuário");
      }

      // Adicona as permissões
      Set<Role> roles = new HashSet<>();
      roles.add(role.get());
      usuario.setRoles(roles);

      // Tira as máscaras dos campos
      usuario.setCep(usuario.getCep().replaceAll("\\D", ""));
      usuario.setCpf(usuario.getCpf().replaceAll("\\D", ""));

      List<Telefone> telefones = usuario.getTelefones();
      telefones.forEach((telefone) -> {
        String telSemMascara = telefone.getTelefone().replaceAll("\\D", "");
        telefone.setTelefone(telSemMascara);
      });
      usuario.setCep(usuario.getCep().replaceAll("\\D", ""));

      Usuario usuarioCadastrado = repositoryUsuario.save(usuario);

      // Adiciona a operação no banco de dados
      Usuario usuarioResponsavel = new Usuario();
      usuarioResponsavel.setId(usuarioAutenticado.getId());

      Operacao op = new Operacao();
      op.setResponsavel(usuarioResponsavel);
      op.setDataOperacao(new Date());
      op.setDescricao("Cadastra usuario de CPF " + usuario.getCpf());
      repositoryOperacao.save(op);

      return usuarioCadastrado;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/usuario")
    public Usuario atualizarUsuario(@UsuarioAutenticado DetalhesUsuario usuarioAutenticado, @Valid @RequestBody Usuario usuario) throws Exception {
      RoleName roleName = usuario.getRoles().stream().findFirst().get().getName();
      Optional<Role> role = repositoryRole.findByName(roleName);
      if (!role.isPresent()) {
        throw new Exception("Não foi possível encontrar o tipo de usuário");
      }

      Set<Role> roles = new HashSet<>();
      roles.add(role.get());
      usuario.setRoles(roles);

      // Tira as máscaras dos campos
      usuario.setCep(usuario.getCep().replaceAll("\\D", ""));
      usuario.setCpf(usuario.getCpf().replaceAll("\\D", ""));

      List<Telefone> telefones = usuario.getTelefones();
      telefones.forEach((telefone) -> {
        String telSemMascara = telefone.getTelefone().replaceAll("\\D", "");
        telefone.setTelefone(telSemMascara);
      });
      usuario.setCep(usuario.getCep().replaceAll("\\D", ""));

      Usuario usuarioCadastrado = repositoryUsuario.save(usuario);

      // Adiciona a operação no banco de dados
      Usuario usuarioResponsavel = new Usuario();
      usuarioResponsavel.setId(usuarioAutenticado.getId());

      Operacao op = new Operacao();
      op.setResponsavel(usuarioResponsavel);
      op.setDataOperacao(new Date());
      op.setDescricao("Atualiza usuario de CPF " + usuario.getCpf());
      repositoryOperacao.save(op);

      return usuarioCadastrado;
    }

    // Retorna id do usuário deletado
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/usuario/{id}")
    public Long deleteUser(@UsuarioAutenticado DetalhesUsuario usuario, @PathVariable(value = "id") Long id) throws Exception {
        repositoryUsuario.deleteById(id);

        Usuario usuarioResponsavel = new Usuario();
        usuarioResponsavel.setId(usuario.getId());

        Operacao op = new Operacao();
        op.setResponsavel(usuarioResponsavel);
        op.setDataOperacao(new Date());
        op.setDescricao("Deleta usuario de id " + id);
        repositoryOperacao.save(op);

        return id;
    }
}
