package org.example.repositories;

import org.example.models.Gate;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();
    public Optional<Gate> findGateById(Long gateId){
        // db.execute('select * from gates where id = 11');
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }
}
