package com.br.smart_wallet_ms.service;

import com.br.smart_wallet_ms.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

}
