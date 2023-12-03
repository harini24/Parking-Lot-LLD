package org.example.repositories;

import org.example.models.Operator;
import org.example.models.Token;
import org.example.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TokenRepository {
    private Map<Long, Token> tokens = new TreeMap<>();
    private long previousID = 0;
    public Token saveToken(Token token){
        previousID += 1;
        token.setId(previousID);
        tokens.put(previousID , token);
        return token;
    }

    public Optional<Token> getTokenById(Long id){
        if(tokens.containsKey(id)){
            Optional.of(tokens.get(id));
        }
        return Optional.empty();
    }
}
