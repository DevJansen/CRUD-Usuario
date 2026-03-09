package com.devjansen.crud.usuario.controller;

import com.devjansen.crud.usuario.business.UsuarioService;
import com.devjansen.crud.usuario.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));
    }

}
