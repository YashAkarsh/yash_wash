package com.haier.globalwasher.modle.bean.pay;

import com.haier.globalwasher.modle.bean.CouponBeen;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PayPageBeen {
    private CouponBeen coupons;
    private ArrayList<PayListBeen> payListBeen;

    public CouponBeen getCoupons() {
        return this.coupons;
    }

    public ArrayList<PayListBeen> getPayListBeen() {
        return this.payListBeen;
    }

    public void setCoupons(CouponBeen couponBeen) {
        this.coupons = couponBeen;
    }

    public void setPayListBeen(ArrayList<PayListBeen> arrayList) {
        this.payListBeen = arrayList;
    }
}
