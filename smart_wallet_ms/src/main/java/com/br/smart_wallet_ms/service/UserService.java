package com.br.smart_wallet_ms.service;

import com.br.smart_wallet_ms.api.DTO.UserDTO;
import com.br.smart_wallet_ms.api.response.UserResponse;
import com.br.smart_wallet_ms.models.UserModel;
import com.br.smart_wallet_ms.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;

    public UserResponse save(UserDTO request){
        Optional<UserModel> user0 = repository.findByEmail(request.email());
        if(user0.isPresent()){
            throw new RuntimeException();
        }
        var user = new UserModel();
        BeanUtils.copyProperties(request, user);
        this.repository.save(user);
        return new UserResponse(request.name(), request.email(), request.profilePicture());
    }
    public List<UserResponse> findAll(){
        return repository.findAll().stream()
                .map(UserModel -> new UserResponse(
                        UserModel.getProfilePicture(),
                        UserModel.getEmail(),
                        UserModel.getName()
                ))
                .collect(Collectors.toList());
    }

    public UserResponse findById(Long id){
        Optional<UserModel> user0 = repository.findById(id);
        if(user0.isEmpty()){
            throw new RuntimeException("User not found");
        }
        Optional<UserResponse> response0 = user0.map(
                userModel -> new UserResponse(
                        userModel.getProfilePicture(),
                        userModel.getEmail(),
                        userModel.getName()
                ));
        return response0.get();
    }
}
