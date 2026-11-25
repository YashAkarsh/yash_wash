package com.haier.uhome.usdk.api;

import com.haier.uhome.control.base.api.r;
import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class uSDKNetworkQualityInfo {
    private r info;

    protected uSDKNetworkQualityInfo(r rVar) {
        this.info = rVar;
        if (rVar == null) {
            e3.a.o("create uSDKNetworkQualityInfo with null NetworkQualityInfo", new Object[0]);
            this.info = new r();
        }
    }

    public int getLocalPacketLossRate() {
        return this.info.c();
    }

    public int getLocalRoundTripTime() {
        return this.info.b();
    }

    public int getRemotePacketLossRate() {
        return this.info.e();
    }

    public int getRemoteRoundTripTime() {
        return this.info.d();
    }

    public int getStrength() {
        return this.info.a();
    }

    public String toString() {
        return this.info.toString();
    }
}
