package com.saschakiefer.fraud.repositories;

import com.saschakiefer.fraud.models.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
