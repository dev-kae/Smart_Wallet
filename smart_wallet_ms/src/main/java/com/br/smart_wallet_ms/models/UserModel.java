package com.br.smart_wallet_ms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class UserModel implements Serializable {
    private final Long serialVersion = 1L;

    @Id
    UUID id;
    String name;
    String password;
    String email;
    String profilePicture;
}
