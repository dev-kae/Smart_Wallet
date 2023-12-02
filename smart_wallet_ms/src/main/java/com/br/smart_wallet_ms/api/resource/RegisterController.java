package com.br.smart_wallet_ms.api.resource;

import com.br.smart_wallet_ms.api.DTO.RegisterDTO;
import com.br.smart_wallet_ms.api.response.RegisterResponse;
import com.br.smart_wallet_ms.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegisterResponse>save(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(registerDTO));
    }
    @GetMapping
    public ResponseEntity<List<RegisterResponse>>getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegisterResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
