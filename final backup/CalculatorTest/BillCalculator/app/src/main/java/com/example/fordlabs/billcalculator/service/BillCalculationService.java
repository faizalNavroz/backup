package com.example.fordlabs.billcalculator.service;

import android.util.Log;

import com.example.fordlabs.billcalculator.model.Customer;
import com.example.fordlabs.billcalculator.model.Discount;
import com.example.fordlabs.billcalculator.model.Purchase;

public class BillCalculationService {


    public Double  calculate(Purchase purchase) {

        Double totalAmount = 0.0;
        Double purchasedAmount = purchase.getServiceCost()+ purchase.getProductCost();
        //Double D = getMembershipDiscount(purchase,purchasedAmount) + (getProductDiscount(purchase,purchasedAmount));
        totalAmount = purchasedAmount-(getMembershipDiscount(purchase,purchase.getServiceCost()) + getProductDiscount(purchase,purchase.getProductCost()));
        return totalAmount;
    }

    private Double getProductDiscount(Purchase purchase, Double totalAmount) {
        Double percentage = purchase.getDiscount().getProductDiscount(purchase.getCustomer().getMember());
        return percentage * totalAmount;
    }

    private Double getMembershipDiscount(Purchase purchase, Double totalAmount) {
        Double percentage = purchase.getDiscount().getServiceDiscount(purchase.getCustomer().getMemberType());
        return percentage * totalAmount;
    }
}
