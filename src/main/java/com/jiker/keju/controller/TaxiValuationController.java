package com.jiker.keju.controller;

import com.jiker.keju.common.Tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TaxiValuationController {

    public String taxiValuation(String text) {
        Tools tools = new Tools();
        String[] strArray = tools.stingToStringArray(text);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append("收费").append(calculateFee(strArray[i])).append("元\n");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 2);
    }

    public String calculateFee(String str) {
        String[] feeType = str.split(",");
        String mf = mileageFee(feeType[0].replace("公里", ""));
        String wf = waitingFee(feeType[1].replace("等待", "").replace("分钟", ""));
        BigDecimal db = new BigDecimal(String.valueOf(Double.valueOf(mf) + Double.valueOf(wf)));
        return String.valueOf(db.setScale(0, BigDecimal.ROUND_HALF_UP));
    }

    public String mileageFee(String mileage) {
        DecimalFormat df = new DecimalFormat("#.00");
        if (Integer.parseInt(mileage) > 2 && Integer.parseInt(mileage) <= 8) {
            return df.format((Integer.parseInt(mileage) - 2) * 0.8 + 6);
        } else if (Integer.parseInt(mileage) > 8) {
            return df.format((Integer.parseInt(mileage) - 8) * 0.8 * 1.5 + (6 + (6 * 0.8)));
        } else {
            return df.format(6);
        }
    }

    public String waitingFee(String waitingTime) {
        DecimalFormat df = new DecimalFormat("#.00");
        int time = Integer.parseInt(waitingTime);
        return df.format(time * 0.25);
    }
}
