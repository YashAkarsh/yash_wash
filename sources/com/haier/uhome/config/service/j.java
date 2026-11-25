package com.haier.uhome.config.service;

import com.haier.uhome.config.json.req.NoPasswordRxAckReq;
import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class j implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConfigNative f28641a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static j f28642a = new j();

        private a() {
        }
    }

    public static j a() {
        return a.f28642a;
    }

    public int b() {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "stopRxAck().", new Object[0]);
        int iStopRxAck = this.f28641a.stopRxAck();
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "stopRxAck() ret %d", Integer.valueOf(iStopRxAck));
        return iStopRxAck;
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        try {
            if (basicReq == null) {
                throw new com.haier.uhome.config.b.a(2, "null request type");
            }
            if (!(basicReq instanceof NoPasswordRxAckReq)) {
                throw new com.haier.uhome.config.b.a(2, "wrong request type");
            }
            NoPasswordRxAckReq noPasswordRxAckReq = (NoPasswordRxAckReq) basicReq;
            return a(noPasswordRxAckReq.getSn(), noPasswordRxAckReq.getDevId(), noPasswordRxAckReq.getTypeId(), noPasswordRxAckReq.getTimeout());
        } catch (com.haier.uhome.config.b.a e8) {
            e8.a();
            return e8.b();
        } catch (Exception e9) {
            e3.a.v("sendReq excp -> %s", e9);
            return 0;
        }
    }

    private j() {
        ConfigNative configNative = new ConfigNative();
        this.f28641a = configNative;
        configNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    public int a(int i7, String str, String str2, int i8) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "startRxAck(%d,%s,%s,%d).", Integer.valueOf(i7), str, str2, Integer.valueOf(i8));
        int iStartRxAck = this.f28641a.startRxAck(i7, str, str2, i8);
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "startRxAck(%d,%s,%s,%d) ret %d", Integer.valueOf(i7), str, str2, Integer.valueOf(i8), Integer.valueOf(iStartRxAck));
        return iStartRxAck;
    }
}
