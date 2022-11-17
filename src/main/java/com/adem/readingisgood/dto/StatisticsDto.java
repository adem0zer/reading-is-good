package com.adem.readingisgood.dto;

import com.adem.readingisgood.common.Utility;
import lombok.Data;

@Data
public class StatisticsDto {
    String nameOfMonth;
    Long totalOrderCount;
    Long totalBookCount;
    Long totalPurchasedAmount;

    public StatisticsDto(int nameOfMonth, Long totalOrderCount, Long totalBookCount, Long totalPurchasedAmount) {
        this.nameOfMonth = Utility.getNameOfMonth(nameOfMonth);
        this.totalOrderCount = totalOrderCount;
        this.totalBookCount = totalBookCount;
        this.totalPurchasedAmount = totalPurchasedAmount;
    }
}
