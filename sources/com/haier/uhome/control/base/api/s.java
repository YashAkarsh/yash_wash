package com.haier.uhome.control.base.api;

import com.haier.uhome.control.base.json.NetworkQualityInfoV2Dto;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NetworkQualityInfoV2Dto f28833a;

    public s(NetworkQualityInfoV2Dto networkQualityInfoV2Dto) {
        this.f28833a = networkQualityInfoV2Dto;
    }

    public String a() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return null;
        }
        return networkQualityInfoV2Dto.getMachineId();
    }

    public boolean b() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return false;
        }
        return networkQualityInfoV2Dto.isOnLine();
    }

    public long c() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return 0L;
        }
        return networkQualityInfoV2Dto.getStatusLastChangeTime();
    }

    public String d() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return null;
        }
        return networkQualityInfoV2Dto.getNetType();
    }

    public String e() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return null;
        }
        return networkQualityInfoV2Dto.getSsid();
    }

    public int f() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return 0;
        }
        return networkQualityInfoV2Dto.getRssi();
    }

    public int g() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return 0;
        }
        return networkQualityInfoV2Dto.getPrssi();
    }

    public int h() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return 0;
        }
        return networkQualityInfoV2Dto.getSignalLevel();
    }

    public int i() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return 0;
        }
        return networkQualityInfoV2Dto.getIlostRatio();
    }

    public int j() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return 0;
        }
        return networkQualityInfoV2Dto.getIts();
    }

    public String k() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return null;
        }
        return networkQualityInfoV2Dto.getLanIP();
    }

    public String l() {
        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = this.f28833a;
        if (networkQualityInfoV2Dto == null) {
            return null;
        }
        return networkQualityInfoV2Dto.getModuleVersion();
    }

    public String toString() {
        return "NetworkQualityInfoV2{mInfoV2Dto=" + this.f28833a + '}';
    }
}
