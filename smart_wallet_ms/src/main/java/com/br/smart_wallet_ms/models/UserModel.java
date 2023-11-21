package com.br.smart_wallet_ms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserModel {
    @Id
    UUID id;
    String name;
    String password;
    String email;
    String profilePicture;


}
