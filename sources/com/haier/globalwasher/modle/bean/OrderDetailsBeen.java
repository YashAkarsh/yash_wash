package com.haier.globalwasher.modle.bean;

import com.haier.globalwasher.modle.utils.d0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OrderDetailsBeen implements Serializable {
    private String accessToken;
    private String actualName;
    private String actualPrice;
    private String blueMac;
    private String coupunName;
    private String coupunPrice;
    private String currencySymbol;
    private DeviceDetailBeen deviceInfo;
    private DeviceListBeen deviceList;
    private String directive;
    private String finishTime;
    private String hotLine;
    private int isBle;
    private String isCleaningComplete;
    private String laundryActivityTitle;
    private String orderCode;
    private int orderDeviType;
    private String orderId;
    private String orderStatus;
    private String orderTime;
    private String payAmount;
    private String payWindowRemainingTime;
    private Integer points;
    private String price;
    private String runCount;
    private RunModeBeen runMode;
    private String salePrice;
    private boolean start;
    private String statusErrorCode;
    private String statusErrorMesg;

    public OrderDetailsBeen(String str, String str2, String str3, DeviceDetailBeen deviceDetailBeen, String str4, String str5, String str6, String str7, String str8, RunModeBeen runModeBeen, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Integer num, String str16, String str17, String str18) {
        this.actualName = str;
        this.orderId = str2;
        this.orderCode = str3;
        this.deviceInfo = deviceDetailBeen;
        this.price = str4;
        this.salePrice = str5;
        this.orderStatus = str6;
        this.statusErrorCode = str7;
        this.statusErrorMesg = str8;
        this.runMode = runModeBeen;
        this.runCount = str9;
        this.finishTime = str10;
        this.orderTime = str11;
        this.payWindowRemainingTime = str12;
        this.actualPrice = str13;
        this.coupunPrice = str14;
        this.coupunName = str15;
        this.points = num;
        this.isCleaningComplete = str16;
        this.hotLine = str17;
        this.currencySymbol = str18;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getActualName() {
        return this.actualName;
    }

    public String getActualPrice() {
        return this.actualPrice;
    }

    public String getBlueMac() {
        return this.blueMac;
    }

    public String getCoupunName() {
        return this.coupunName;
    }

    public String getCoupunPrice() {
        return this.coupunPrice;
    }

    public String getCurrencySymbol() {
        return d0.a(this.currencySymbol);
    }

    public DeviceDetailBeen getDeviceInfo() {
        return this.deviceInfo;
    }

    public DeviceListBeen getDeviceList() {
        return this.deviceList;
    }

    public String getDirective() {
        return this.directive;
    }

    public String getFinishTime() {
        return this.finishTime;
    }

    public String getHotLine() {
        return this.hotLine;
    }

    public int getIsBle() {
        return this.isBle;
    }

    public String getIsCleaningComplete() {
        return this.isCleaningComplete;
    }

    public String getLaundryActivityTitle() {
        return this.laundryActivityTitle;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public int getOrderDeviType() {
        return this.orderDeviType;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public String getPayAmount() {
        return this.payAmount;
    }

    public String getPayWindowRemainingTime() {
        String str = this.payWindowRemainingTime;
        return (str == null || "null".equals(str) || "".equals(this.payWindowRemainingTime)) ? "0" : this.payWindowRemainingTime;
    }

    public Integer getPoints() {
        return this.points;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRunCount() {
        String str = this.runCount;
        return str == null ? "1" : str;
    }

    public RunModeBeen getRunMode() {
        return this.runMode;
    }

    public String getSalePrice() {
        return this.salePrice;
    }

    public String getStatusErrorCode() {
        return this.statusErrorCode;
    }

    public String getStatusErrorMesg() {
        return this.statusErrorMesg;
    }

    public boolean isStart() {
        return this.start;
    }

    public void setActualName(String str) {
        this.actualName = str;
    }

    public void setActualPrice(String str) {
        this.actualPrice = str;
    }

    public void setCoupunName(String str) {
        this.coupunName = str;
    }

    public void setCoupunPrice(String str) {
        this.coupunPrice = str;
    }

    public void setDeviceInfo(DeviceDetailBeen deviceDetailBeen) {
        this.deviceInfo = deviceDetailBeen;
    }

    public void setDeviceList(DeviceListBeen deviceListBeen) {
        this.deviceList = deviceListBeen;
    }

    public void setFinishTime(String str) {
        this.finishTime = str;
    }

    public void setHotLine(String str) {
        this.hotLine = str;
    }

    public void setIsCleaningComplete(String str) {
        this.isCleaningComplete = str;
    }

    public void setLaundryActivityTitle(String str) {
        this.laundryActivityTitle = str;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public void setPayAmount(String str) {
        this.payAmount = str;
    }

    public void setPayWindowRemainingTime(String str) {
        this.payWindowRemainingTime = str;
    }

    public void setPoints(Integer num) {
        this.points = num;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRunCount(String str) {
        this.runCount = str;
    }

    public void setRunMode(RunModeBeen runModeBeen) {
        this.runMode = runModeBeen;
    }

    public void setSalePrice(String str) {
        this.salePrice = str;
    }

    public void setStart(boolean z7) {
        this.start = z7;
    }

    public void setStatusErrorCode(String str) {
        this.statusErrorCode = str;
    }

    public void setStatusErrorMesg(String str) {
        this.statusErrorMesg = str;
    }

    public String toString() {
        return "OrderDetailsBeen{orderId='" + this.orderId + "', orderCode='" + this.orderCode + "', deviceInfo=" + this.deviceInfo + ", deviceList=" + this.deviceList + ", price='" + this.price + "', salePrice='" + this.salePrice + "', orderStatus='" + this.orderStatus + "', statusErrorCode='" + this.statusErrorCode + "', statusErrorMesg='" + this.statusErrorMesg + "', runMode=" + this.runMode + ", runCount='" + this.runCount + "', finishTime='" + this.finishTime + "', orderTime='" + this.orderTime + "', payWindowRemainingTime='" + this.payWindowRemainingTime + "', actualPrice='" + this.actualPrice + "', coupunPrice='" + this.coupunPrice + "', coupunName='" + this.coupunName + "', points=" + this.points + ", isCleaningComplete='" + this.isCleaningComplete + "', hotLine='" + this.hotLine + "', currencySymbol='" + this.currencySymbol + "', actualName='" + this.actualName + "'}";
    }

    public OrderDetailsBeen() {
    }
}
