package com.jiker.keju.controller;

import org.junit.Assert;
import org.junit.Test;

public class TaxiValuationControllerTest {
    private TaxiValuationController taxiValuationController = new TaxiValuationController();

    @Test
    public void taxiValuation() {
        Assert.assertEquals(taxiValuationController.taxiValuation(
                "1公里,等待0分钟\\n" +
                "3公里,等待0分钟\\n" +
                "10公里,等待0分钟\\n" +
                "2公里,等待3分钟"),
                "收费6元\\n" +
                "收费7元\\n" +
                "收费13元\\n" +
                "收费7元\\n");
    }

    @Test
    public void calculateFee() {
        Assert.assertEquals(taxiValuationController.calculateFee("5公里,等待3分钟"), "9");
        Assert.assertNotEquals(taxiValuationController.calculateFee("5公里,等待3分钟"), "11.00");
    }

    @Test
    public void mileageFee() {
        Assert.assertEquals(taxiValuationController.mileageFee("10"), "13.20");
        Assert.assertNotEquals(taxiValuationController.mileageFee("7"), "11.00");
    }

    @Test
    public void waitingFee() {
        Assert.assertEquals(taxiValuationController.waitingFee("10"), "2.50");
        Assert.assertNotEquals(taxiValuationController.waitingFee("7"), "2.50");
    }
}