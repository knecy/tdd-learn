package com.jiker.keju;

import com.jiker.keju.common.Tools;
import com.jiker.keju.controller.TaxiValuationController;

public class AppRunner {

    static Tools tools = new Tools();

    public static void main(String[] args) {
        TaxiValuationController taxiValuationController = new TaxiValuationController();
        try {
            String testDataFile = tools.fileReader("src/main/resources/" + args[0]);
            String receipt = taxiValuationController.taxiValuation(testDataFile);
            System.out.println(receipt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
