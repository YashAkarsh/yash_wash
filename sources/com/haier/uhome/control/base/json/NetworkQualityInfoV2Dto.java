package com.haier.uhome.control.base.json;

import g3.b;
import y2.a;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkQualityInfoV2Dto {

    @b(name = "ilostRatio")
    private int ilostRatio;

    @b(name = "its")
    private int its;

    @b(name = "lanIP")
    private String lanIP;

    @b(name = "machineId")
    private String machineId;

    @b(name = "moduleVersion")
    private String moduleVersion;

    @b(name = "netType")
    private String netType;

    @b(name = "isOnLine")
    private boolean onLine;

    @b(name = "prssi")
    private int prssi;

    @b(name = "rssi")
    private int rssi;

    @b(name = "signalLevel")
    private int signalLevel;

    @b(name = a.C)
    private String ssid;

    @b(name = "statusLastChangeTime")
    private long statusLastChangeTime;

    public int getIlostRatio() {
        return this.ilostRatio;
    }

    public int getIts() {
        return this.its;
    }

    public String getLanIP() {
        return this.lanIP;
    }

    public String getMachineId() {
        return this.machineId;
    }

    public String getModuleVersion() {
        return this.moduleVersion;
    }

    public String getNetType() {
        return this.netType;
    }

    public int getPrssi() {
        return this.prssi;
    }

    public int getRssi() {
        return this.rssi;
    }

    public int getSignalLevel() {
        return this.signalLevel;
    }

    public String getSsid() {
        return this.ssid;
    }

    public long getStatusLastChangeTime() {
        return this.statusLastChangeTime;
    }

    public boolean isOnLine() {
        return this.onLine;
    }

    public void setIlostRatio(int i7) {
        this.ilostRatio = i7;
    }

    public void setIts(int i7) {
        this.its = i7;
    }

    public void setLanIP(String str) {
        this.lanIP = str;
    }

    public void setMachineId(String str) {
        this.machineId = str;
    }

    public void setModuleVersion(String str) {
        this.moduleVersion = str;
    }

    public void setNetType(String str) {
        this.netType = str;
    }

    public void setOnLine(boolean z7) {
        this.onLine = z7;
    }

    public void setPrssi(int i7) {
        this.prssi = i7;
    }

    public void setRssi(int i7) {
        this.rssi = i7;
    }

    public void setSignalLevel(int i7) {
        this.signalLevel = i7;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setStatusLastChangeTime(long j7) {
        this.statusLastChangeTime = j7;
    }
}
