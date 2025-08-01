package com.sigeps.test.register_user.security;

import com.sigeps.test.register_user.model.UsuarioModel;
import com.sigeps.test.register_user.repository.IUsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioDetailsService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UsuarioModel usuarioModel = usuarioRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));

        return new UsuarioDetails(usuarioModel);
    }
}
