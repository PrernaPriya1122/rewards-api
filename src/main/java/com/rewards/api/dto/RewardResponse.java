package com.rewards.api.dto;

import java.util.Map;

/**
 * Response DTO for rewards.
 */
public class RewardResponse {

    private Long customerId;
    private String customerName;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;

    public RewardResponse(Long customerId, String customerName,
                          Map<String, Integer> monthlyPoints,
                          int totalPoints) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
