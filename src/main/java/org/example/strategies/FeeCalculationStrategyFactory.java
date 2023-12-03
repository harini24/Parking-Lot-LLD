package org.example.strategies;

import org.example.enums.FeeCalculationStrategyType;

public class FeeCalculationStrategyFactory {
    public static FeeCalculationStrategy getFeeForType(FeeCalculationStrategyType feeCalculationStrategyType){
        return new TireOneFeeCalculationStrategy();
    }
}
