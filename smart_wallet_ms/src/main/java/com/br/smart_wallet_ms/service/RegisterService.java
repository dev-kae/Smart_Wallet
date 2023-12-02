package com.br.smart_wallet_ms.service;

import com.br.smart_wallet_ms.api.DTO.RegisterDTO;
import com.br.smart_wallet_ms.api.response.RegisterResponse;
import com.br.smart_wallet_ms.models.RegisterModel;
import com.br.smart_wallet_ms.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegisterService {

    private RegisterRepository repository;

    public RegisterResponse save (RegisterDTO request){
        var register = new RegisterModel();
        BeanUtils.copyProperties(request, register);
        repository.save(register);
        return new RegisterResponse(request.initialDate(), request.finalDate(), request.category());
    }

    public List<RegisterResponse> findAll(){
        return repository.findAll().stream()
                .map(RegisterModel -> new RegisterResponse(
                        RegisterModel.getInitialDate(),
                        RegisterModel.getFinalDate(),
                        RegisterModel.getCategory()
                )).collect(Collectors.toList());
    }

    public RegisterResponse findById(Long id){
        Optional<RegisterModel> register0 = repository.findById(id);
        if(register0.isEmpty())throw new RuntimeException();
        Optional<RegisterResponse> response0 = register0.map(
                registerModel -> new RegisterResponse(
                        registerModel.getInitialDate(),
                        registerModel.getFinalDate(),
                        registerModel.getCategory()
                ));
        return response0.get();
    }
}
