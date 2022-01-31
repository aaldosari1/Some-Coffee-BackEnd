package com.example.Some_Coffee_BackEnd.CoffeeTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {

        this.tableRepository = tableRepository;
    }

    public List<CoffeeTable> getTables() {

        return tableRepository.findAll();
    }

    public CoffeeTable getTable(String id) {
        Long tableId = Long.parseLong(id);
        return tableRepository.findById(tableId).orElse(null);
    }

    public CoffeeTable addTable(CoffeeTable coffeeTable) {

        return tableRepository.save(coffeeTable);
    }

    public void deleteTable(String id) {
        Long tableId = Long.parseLong(id);
        tableRepository.deleteById(tableId);
    }

    public void updateSection(String id, CoffeeTable data) {
        Long tableId = Long.parseLong(id);
        CoffeeTable coffeeTable = tableRepository.findById(tableId).orElse(null);


        if (coffeeTable != null) {
            coffeeTable.setTableSize(data.getTableSize());
            tableRepository.save(coffeeTable);
        }
    }
}
