package com.rewards.api.controller;

import com.rewards.api.dto.RewardResponse;
import com.rewards.api.model.Transaction;
import com.rewards.api.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for rewards.
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<RewardResponse> getRewards() {

        List<Transaction> transactions = List.of(
                new Transaction(1L, "John Doe", 120, LocalDate.now().minusMonths(2)),
                new Transaction(1L, "John Doe", 75, LocalDate.now().minusMonths(1)),
                new Transaction(2L, "Jane Smith", 200, LocalDate.now().minusMonths(2)),
                new Transaction(2L, "Jane Smith", 90, LocalDate.now())
        );

        return rewardService.calculateRewards(transactions);
    }
}
