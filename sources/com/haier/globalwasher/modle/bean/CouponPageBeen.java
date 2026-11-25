package com.haier.globalwasher.modle.bean;

import com.haier.globalwasher.modle.utils.d0;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class CouponPageBeen implements Serializable {
    private String couponCode;
    private int couponId;
    private String couponStatus;
    private String couponType;
    private String couponValue;
    private String currencySymbol;
    private String expiredStart;
    private boolean isSelect = false;
    private ArrayList<LaundryCoupon> laundryList;
    private String validityEndTime;

    public String getCouponCode() {
        return this.couponCode;
    }

    public int getCouponId() {
        return this.couponId;
    }

    public String getCouponStatus() {
        return this.couponStatus;
    }

    public String getCouponType() {
        return this.couponType;
    }

    public String getCouponValue() {
        return this.couponValue;
    }

    public String getCurrencySymbol() {
        return d0.a(this.currencySymbol);
    }

    public String getExpiredStart() {
        return this.expiredStart;
    }

    public ArrayList<LaundryCoupon> getLaundryList() {
        return this.laundryList;
    }

    public String getValidityEndTime() {
        return this.validityEndTime;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setCouponCode(String str) {
        this.couponCode = str;
    }

    public void setCouponId(int i7) {
        this.couponId = i7;
    }

    public void setCouponStatus(String str) {
        this.couponStatus = str;
    }

    public void setCouponType(String str) {
        this.couponType = str;
    }

    public void setCouponValue(String str) {
        this.couponValue = str;
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public void setExpiredStart(String str) {
        this.expiredStart = str;
    }

    public void setLaundryList(ArrayList<LaundryCoupon> arrayList) {
        this.laundryList = arrayList;
    }

    public void setSelect(boolean z7) {
        this.isSelect = z7;
    }

    public void setValidityEndTime(String str) {
        this.validityEndTime = str;
    }
}
