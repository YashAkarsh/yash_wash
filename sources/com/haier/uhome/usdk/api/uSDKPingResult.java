package com.haier.uhome.usdk.api;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKPingResult {
    private com.haier.library.common.b.o pingResult;

    public uSDKPingResult(com.haier.library.common.b.o oVar) {
        this.pingResult = oVar;
    }

    public double getAverageTimeCost() {
        return this.pingResult.p();
    }

    public double getFastestTimeCost() {
        return this.pingResult.n();
    }

    public int getPacketLength() {
        return this.pingResult.q();
    }

    public double getPacketLossRate() {
        return this.pingResult.l();
    }

    public int getReceiveCount() {
        return this.pingResult.i();
    }

    public int getSendCount() {
        return this.pingResult.f();
    }

    public Map<Integer, y> getSequenceNumber2Result() {
        Map<Integer, com.haier.library.common.b.q> mapR = this.pingResult.r();
        if (mapR == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (Integer num : mapR.keySet()) {
            map.put(num, new y(mapR.get(num)));
        }
        return map;
    }

    public double getSlowestTimeCost() {
        return this.pingResult.o();
    }

    public String getUrl() {
        return this.pingResult.a();
    }

    public void setAverageTimeCost(double d8) {
        this.pingResult.m(d8);
    }

    public void setFastestTimeCost(double d8) {
        this.pingResult.g(d8);
    }

    public void setPacketLength(int i7) {
        this.pingResult.k(i7);
    }

    public void setPacketLossRate(double d8) {
        this.pingResult.b(d8);
    }

    public void setReceiveCount(int i7) {
        this.pingResult.h(i7);
    }

    public void setSendCount(int i7) {
        this.pingResult.c(i7);
    }

    public void setSequenceNumber2Result(Map<Integer, y> map) {
        if (map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        for (Integer num : map.keySet()) {
            map2.put(num, map.get(num).f31017a);
        }
    }

    public void setSlowestTimeCost(double d8) {
        this.pingResult.j(d8);
    }

    public void setUrl(String str) {
        this.pingResult.d(str);
    }

    public String toString() {
        return this.pingResult.toString();
    }

    public uSDKPingResult() {
        this.pingResult = new com.haier.library.common.b.o();
    }
}
