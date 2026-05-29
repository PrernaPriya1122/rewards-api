package com.rewards.api.service;

import com.rewards.api.dto.RewardResponse;
import com.rewards.api.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service to calculate reward points.
 */
@Service
public class RewardService {

    /**
     * Calculates points for all customers.
     */
    public List<RewardResponse> calculateRewards(List<Transaction> transactions) {

        Map<Long, List<Transaction>> groupedTransactions =
                transactions.stream()
                        .collect(Collectors.groupingBy(Transaction::getCustomerId));

        List<RewardResponse> responses = new ArrayList<>();

        for (Map.Entry<Long, List<Transaction>> entry : groupedTransactions.entrySet()) {

            List<Transaction> customerTransactions = entry.getValue();

            Map<String, Integer> monthlyPoints = new HashMap<>();
            int totalPoints = 0;

            for (Transaction transaction : customerTransactions) {

                int points = calculatePoints(transaction.getAmount());

                Month month = transaction.getTransactionDate().getMonth();

                monthlyPoints.put(
                        month.name(),
                        monthlyPoints.getOrDefault(month.name(), 0) + points
                );

                totalPoints += points;
            }

            Transaction firstTransaction = customerTransactions.get(0);

            responses.add(
                    new RewardResponse(
                            firstTransaction.getCustomerId(),
                            firstTransaction.getCustomerName(),
                            monthlyPoints,
                            totalPoints
                    )
            );
        }

        return responses;
    }

    /**
     * Calculates reward points for single transaction.
     */
    public int calculatePoints(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        int points = 0;

        if (amount > 100) {
            points += (int) ((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }

        return points;
    }
}
