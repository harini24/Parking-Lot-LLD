package org.example.dto;

import org.example.models.Token;

public class GenerateBillRequestDTO {

    private Long GateId;
    private Long tokenId;

    public Long getGateId() {
        return GateId;
    }

    public void setGateId(Long gateId) {
        GateId = gateId;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }
}
