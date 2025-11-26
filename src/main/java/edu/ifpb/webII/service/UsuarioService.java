package edu.ifpb.webII.service;

import edu.ifpb.webII.model.Usuario;
import edu.ifpb.webII.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        var authorities = u.getPerfis().stream()
                .map(p -> new SimpleGrantedAuthority(p.getNome()))
                .collect(Collectors.toList());

        return org.springframework.security.core.userdetails.User.builder()
                .username(u.getUsername())
                .password(u.getSenha())
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!u.isAtivo())
                .build();
    }
}
