package com.devjansen.crud.usuario.business;

import com.devjansen.crud.usuario.infrastructure.entity.Usuario;
import com.devjansen.crud.usuario.infrastructure.exceptions.ConflictExceptions;
import com.devjansen.crud.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    //injeção de depedencia usando o @Required do lombok
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    //metodo para salvar o usario
    public Usuario salvaUsuario(Usuario usuario) {
        emailExistente(usuario.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    //metodo para fazer a verificação se o email existe, retorna um boolean
    public boolean verificaEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    //metodo se o email existe retorna uma Exceptions
    public void emailExistente(String email) {

        if (verificaEmailExistente(email)) {
            throw new ConflictExceptions("Email ja cadastrado " + email);
        }

    }

}
