package com.rewards.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for reward service.
 */
class RewardServiceTest {

    private final RewardService rewardService = new RewardService();

    @Test
    void shouldCalculatePointsForAmountAbove100() {
        int points = rewardService.calculatePoints(120);
        Assertions.assertEquals(90, points);
    }

    @Test
    void shouldCalculatePointsForAmountBetween50And100() {
        int points = rewardService.calculatePoints(80);
        Assertions.assertEquals(30, points);
    }

    @Test
    void shouldReturnZeroForAmountBelow50() {
        int points = rewardService.calculatePoints(40);
        Assertions.assertEquals(0, points);
    }

    @Test
    void shouldThrowExceptionForNegativeAmount() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> rewardService.calculatePoints(-100)
        );
    }
}
