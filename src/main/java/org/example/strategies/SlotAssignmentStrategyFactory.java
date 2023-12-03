package org.example.strategies;

import org.example.enums.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {

    public static SlotAssignmentStrategy getSlotForType(SlotAssignmentStrategyType slotAssignmentStrategyType){
        return new RandomSlotAssignmentStrategy();
    }
}
