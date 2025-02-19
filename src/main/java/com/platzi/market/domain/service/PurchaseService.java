package com.platzi.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public List<Purchase> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId).orElse(null);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Optional<Purchase> getPurchase(int purchaseId) {
        return purchaseRepository.getPurchase(purchaseId);
    }

    public boolean delete(int purchaseId) {
        return getPurchase(purchaseId).map(purchase -> {
            purchaseRepository.delete(purchaseId);
            return true;
        }).orElse(false);
    }
    
    
    
}
