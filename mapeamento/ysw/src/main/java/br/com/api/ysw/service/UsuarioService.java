package br.com.api.ysw.service;

import br.com.api.ysw.exception.ErroAutenticacao;
import br.com.api.ysw.exception.RegraNegocioException;
import br.com.api.ysw.model.Usuario;
import br.com.api.ysw.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if(!usuario.isPresent()){
            throw new ErroAutenticacao("usuário não encontrado com o email informado.");
        }
        if(!usuario.get().getPassword().equals(password)){
            throw new ErroAutenticacao("Senha incorreta.");
        }
        return usuario.get();
    }

    @Transactional
    public Usuario salvarUsuario(Usuario usuario){
        usuario.setUsuario_id(null);
        validarEmail(usuario.getEmail());
        return usuarioRepository.save(usuario);
    }

    public void validarEmail(String email) {
        boolean existe = usuarioRepository.existsByEmail(email);
        if(existe){
            throw new RegraNegocioException("Ja existe um usuario cadastrado com este email");
        }
    }
}
