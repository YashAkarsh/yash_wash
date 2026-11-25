package com.haier.uhome.usdk.api;

import com.haier.uhome.smart.api.BaseSmartRsp;
import com.haier.uhome.smart.api.SmartDevice;
import com.haier.uhome.smart.api.SmartDevicePair;
import com.haier.uhome.smart.api.SmartOpRsp;
import com.haier.uhome.smart.api.SmartReadRsp;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SmartDevice f30659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ISmartDeviceListener f30660b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f30666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f30667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f30668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f30669g;

        public a a(String str) {
            this.f30663a = str;
            return this;
        }

        public a b(String str) {
            this.f30664b = str;
            return this;
        }

        public a c(String str) {
            this.f30665c = str;
            return this;
        }

        public a d(String str) {
            this.f30666d = str;
            return this;
        }

        public a e(String str) {
            this.f30667e = str;
            return this;
        }

        public a f(String str) {
            this.f30668f = str;
            return this;
        }

        public a g(String str) {
            this.f30669g = str;
            return this;
        }

        public o a() {
            return new o(this.f30663a, this.f30664b, this.f30665c, this.f30666d, this.f30667e, this.f30668f, this.f30669g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    public void a(List<q> list, final IuSDKCallback iuSDKCallback) {
        this.f30659a.reportStatus(z.a(list), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.t1
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                o.d(iuSDKCallback, errorConst);
            }
        });
    }

    public void b(List<q> list, final IuSDKCallback iuSDKCallback) {
        this.f30659a.reportAlarm(z.a(list), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.v1
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                o.c(iuSDKCallback, errorConst);
            }
        });
    }

    public ISmartDeviceListener i() {
        return this.f30660b;
    }

    private o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f30659a = new SmartDevice(str, str2, str3, str4, str5, str6, str7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    public void a(String str, String str2, final IuSDKCallback iuSDKCallback) {
        this.f30659a.reportBigData(str, str2, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.u1
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                o.b(iuSDKCallback, errorConst);
            }
        });
    }

    public String c() {
        return this.f30659a.getSwVersion();
    }

    public String d() {
        return this.f30659a.getHwVersion();
    }

    public String e() {
        return this.f30659a.getSwType();
    }

    public String f() {
        return this.f30659a.getHwType();
    }

    public String g() {
        return this.f30659a.getKey();
    }

    public SmartDevice h() {
        return this.f30659a;
    }

    public void a(IuSDKCallback iuSDKCallback) {
        a(15, iuSDKCallback);
    }

    public String b() {
        return this.f30659a.getUplusId();
    }

    public void a(int i7, final IuSDKCallback iuSDKCallback) {
        this.f30659a.bindWindow(i7, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.s1
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                o.a(iuSDKCallback, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    public String a() {
        return this.f30659a.getDevId();
    }

    protected void a(ISmartDeviceListener iSmartDeviceListener) {
        this.f30660b = iSmartDeviceListener;
        if (iSmartDeviceListener == null) {
            this.f30659a.setListener(null);
        } else {
            this.f30659a.setListener(iSmartDeviceListener);
        }
    }

    public void a(final com.haier.uhome.usdk.api.interfaces.f fVar) {
        if (fVar == null) {
            this.f30660b = null;
            this.f30659a.setListener(null);
        } else {
            ISmartDeviceListener iSmartDeviceListener = new ISmartDeviceListener() { // from class: com.haier.uhome.usdk.api.o.1
                @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceListener
                public void onBusinessDown(String str, String str2, byte[] bArr) {
                    fVar.a(str, str2, bArr);
                }

                @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceListener
                public void onCloudMsg(String str, int i7, int i8) {
                    fVar.a(str, i7, i8);
                }

                @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceListener
                public void onDeviceBindCallback(String str, int i7, int i8) {
                    fVar.b(str, i7, i8);
                }

                @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceListener
                public SmartOpRsp onDeviceOpCallback(String str, int i7, String str2, List<SmartDevicePair> list) {
                    s sVarA = fVar.a(str, i7, str2, z.b(list));
                    if (sVarA == null) {
                        return null;
                    }
                    return sVarA.a();
                }

                @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceListener
                public SmartReadRsp onDeviceReadCallback(String str, int i7, String str2) {
                    t tVarA = fVar.a(str, i7, str2);
                    if (tVarA == null) {
                        return null;
                    }
                    return tVarA.a();
                }

                @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceListener
                public BaseSmartRsp onDeviceWriteCallback(String str, int i7, String str2, String str3) {
                    n nVarA = fVar.a(str, i7, str2, str3);
                    if (nVarA == null) {
                        return null;
                    }
                    return nVarA.b();
                }
            };
            this.f30660b = iSmartDeviceListener;
            this.f30659a.setListener(iSmartDeviceListener);
        }
    }
}
