package org.example.repositories;

import org.example.models.Bill;
import org.example.models.Token;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BillRepository {
    private Map<Long, Bill> bills = new TreeMap<>();
    private long previousID = 0;
    public Bill saveBill(Bill bill){
        previousID += 1;
        bill.setId(previousID);
        bills.put(previousID , bill);
        return bill;
    }

    public Optional<Bill> getBillById(Long id){
        if(bills.containsKey(id)){
            Optional.of(bills.get(id));
        }
        return Optional.empty();
    }
}
