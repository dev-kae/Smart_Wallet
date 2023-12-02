package com.br.smart_wallet_ms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Table(name="registers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date initialDate;
    private Date finalDate;
    private String category;
}
