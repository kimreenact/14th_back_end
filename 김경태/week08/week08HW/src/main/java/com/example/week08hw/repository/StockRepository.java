package com.example.week08hw.repository;

import com.example.week08hw.entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StockRepository {

    private final List<Stock> stocks = new ArrayList<>();
    private Long sequence = 1L;

    public Stock save(
            Long storeId,
            String productName,
            int price,
            int quantity
    ) {
        Stock stock = new Stock(
                sequence++,
                storeId,
                productName,
                price,
                quantity
        );

        stocks.add(stock);
        return stock;
    }

    public List<Stock> findAll() {
        return stocks;
    }

    public List<Stock> findByStoreId(Long storeId) {
        return stocks.stream()
                .filter(stock -> stock.getStoreId().equals(storeId))
                .toList();
    }

    public Optional<Stock> findById(Long id) {
        return stocks.stream()
                .filter(stock -> stock.getId().equals(id))
                .findFirst();
    }

    public void delete(Stock stock) {
        stocks.remove(stock);
    }
}