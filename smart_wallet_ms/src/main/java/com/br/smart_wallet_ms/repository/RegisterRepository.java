package com.br.smart_wallet_ms.repository;

import com.br.smart_wallet_ms.models.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel, Long>{
}