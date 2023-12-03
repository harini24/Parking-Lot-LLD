package org.example.controllers;

import org.example.dto.IssueTokenRequestDTO;
import org.example.dto.IssueTokenResponseDTO;
import org.example.enums.ResponseType;
import org.example.models.Token;
import org.example.services.TokenService;

public class TokenController {
    TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public IssueTokenResponseDTO issueTicket(IssueTokenRequestDTO requestDTO){
        IssueTokenResponseDTO response = new IssueTokenResponseDTO();
        try {
            // todo validation
            Token token = tokenService.issueToken(requestDTO.getVehicleNumber(), requestDTO.getVehicleOwnerName(), requestDTO.getVehicleType(), requestDTO.getGateId());
            response.setToken(token);
            response.setResponseType(ResponseType.SUCCESS);
        } catch(Exception e){
          response.setResponseType(ResponseType.FAILURE);
        }
        return  response;
    }
}
