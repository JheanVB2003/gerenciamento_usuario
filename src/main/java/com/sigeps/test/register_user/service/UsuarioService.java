package com.sigeps.test.register_user.service;

import com.sigeps.test.register_user.dto.UsuarioDTO;
import com.sigeps.test.register_user.exception.CpfExistenteException;
import com.sigeps.test.register_user.exception.EmailExistenteException;
import com.sigeps.test.register_user.exception.UsuarioNaoEncontrado;
import com.sigeps.test.register_user.infra.GlobalExceptionHandler;
import com.sigeps.test.register_user.model.UsuarioModel;
import com.sigeps.test.register_user.repository.IUsuarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    public final IUsuarioRepository iUsuarioRepository;

    public UsuarioService(IUsuarioRepository iUsuarioRepository){
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Transactional
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        if (iUsuarioRepository.existsByCpf(usuarioDTO.getCpf()) && (iUsuarioRepository.existsByEmail(usuarioDTO.getEmail()))){
            throw new RuntimeException("CPF e EMAIL já cadastrados no sistema!");
        } else if ((iUsuarioRepository.existsByCpf(usuarioDTO.getCpf()))){
            throw new CpfExistenteException();
        }else if((iUsuarioRepository.existsByEmail(usuarioDTO.getEmail()))){
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

    private UsuarioDTO mapToDTO(UsuarioModel usuarioModel) {
        UsuarioDTO userdto = new UsuarioDTO();

        userdto.setNome(usuarioModel.getNome());
        userdto.setCpf(usuarioModel.getCpf());
        userdto.setEmail(usuarioModel.getEmail());
        userdto.setSexo(usuarioModel.getSexo());
        userdto.setTelefone(usuarioModel.getTelefone());

        return userdto;
    }

    private UsuarioModel mapToModel(UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = new UsuarioModel();

       // if (usuarioDTO.getId() != null){
       //     usuarioModel.setId(usuarioDTO.getId());
      //  }
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setCpf(usuarioDTO.getCpf());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setSexo(usuarioDTO.getSexo());
        usuarioModel.setTelefone(usuarioDTO.getTelefone());
        return usuarioModel;
    }


}
