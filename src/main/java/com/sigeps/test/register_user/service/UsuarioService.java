package com.sigeps.test.register_user.service;

import com.sigeps.test.register_user.dto.AunthenticationDTO;
import com.sigeps.test.register_user.dto.LoginResponseDTO;
import com.sigeps.test.register_user.dto.UsuarioDTO;
import com.sigeps.test.register_user.enums.Perfil;
import com.sigeps.test.register_user.exception.CpfExistenteException;
import com.sigeps.test.register_user.exception.EmailExistenteException;
import com.sigeps.test.register_user.exception.UsuarioNaoEncontrado;
import com.sigeps.test.register_user.infra.GlobalExceptionHandler;
import com.sigeps.test.register_user.model.UsuarioModel;
import com.sigeps.test.register_user.repository.IUsuarioRepository;

import com.sigeps.test.register_user.security.TokenService;
import com.sigeps.test.register_user.security.UsuarioDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sigeps.test.register_user.enums.Perfil.ROLE_ADMIN;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository iUsuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public LoginResponseDTO login(AunthenticationDTO data) {

        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = authenticationManager.authenticate(userNamePassword);
        var token = tokenService.generateToken((UsuarioDetails) auth.getPrincipal());

        return new LoginResponseDTO(token);
    }

    @Transactional
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        if (iUsuarioRepository.existsByCpf(usuarioDTO.cpf()) && (iUsuarioRepository.existsByEmail(usuarioDTO.email()))){
            throw new RuntimeException("CPF e EMAIL já cadastrados no sistema!");
        } else if ((iUsuarioRepository.existsByCpf(usuarioDTO.cpf()))){
            throw new CpfExistenteException();
        }else if((iUsuarioRepository.existsByEmail(usuarioDTO.email()))){
            throw new EmailExistenteException();
        }

        UsuarioModel usuarioModel = mapToModel(usuarioDTO);
        UsuarioModel usuarioSalvo = iUsuarioRepository.save(usuarioModel);
        return mapToDTO(usuarioSalvo);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO buscarUsuarioPorId(Long id) {
        UsuarioModel usuarioModel = iUsuarioRepository.findById(id)
                .orElseThrow(UsuarioNaoEncontrado::new);
        return mapToDTO(usuarioModel);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO buscarUsuarioPorCPF(String cpf) {
        UsuarioModel usuarioModel = iUsuarioRepository.findByCpf(cpf)
                .orElseThrow(UsuarioNaoEncontrado::new);
        return mapToDTO(usuarioModel);
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listarUsuarios() {
        return iUsuarioRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UsuarioDTO atualizarPessoa(Long id, UsuarioDTO usuarioDTO){

        UsuarioModel usuarioModelExistente = iUsuarioRepository.findById(id)
               .orElseThrow(UsuarioNaoEncontrado::new);


        usuarioModelExistente.setNome(usuarioDTO.nome());
        usuarioModelExistente.setCpf(usuarioDTO.cpf());
        usuarioModelExistente.setEmail(usuarioDTO.email());
        usuarioModelExistente.setSexo(usuarioDTO.sexo());
        usuarioModelExistente.setTelefone(usuarioDTO.telefone());

        usuarioModelExistente = iUsuarioRepository.save(usuarioModelExistente);

        return mapToDTO(usuarioModelExistente);
    }

    @Transactional
    public  void deletarUsuario(Long id){
        if (!iUsuarioRepository.existsById(id)){
            throw new UsuarioNaoEncontrado("Pessoa com ID " + id + " não encontrada para exclusão.");
        }
        iUsuarioRepository.deleteById(id);
    }

    private UsuarioDTO mapToDTO(UsuarioModel usuarioModel) {
        return new UsuarioDTO(
                usuarioModel.getNome(),
                usuarioModel.getCpf(),
                usuarioModel.getEmail(),
                usuarioModel.getSexo(),
                usuarioModel.getTelefone(),
                usuarioModel.getSenha()
        );
    }

    private UsuarioModel mapToModel(UsuarioDTO data){
       return new UsuarioModel(
                data.nome(),
                data.cpf(),
                data.email(),
                data.sexo(),
                data.telefone(),
                new BCryptPasswordEncoder().encode(data.senha())
        );
    }


}
