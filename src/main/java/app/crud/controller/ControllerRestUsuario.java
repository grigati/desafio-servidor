package app.crud.controller;
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
}
