package com.example.Some_Coffee_BackEnd.CoffeeTable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoffeeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;
    private int tableSize;

    public CoffeeTable() {

    }

    public CoffeeTable(Long tableId, int tableSize) {
        this.tableId = tableId;
        this.tableSize = tableSize;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }
}
