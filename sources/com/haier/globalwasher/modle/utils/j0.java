package com.haier.globalwasher.modle.utils;

import android.os.Handler;
import android.os.Message;
import com.haier.uhome.usdk.api.uSDKDevice;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class j0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static j0 f24628g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24629a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<b> f24630b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24631c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f24632d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f24633e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    a f24634f;

    public interface a {
        void a(int i7);
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public uSDKDevice f24635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g0 f24636b;

        public b(uSDKDevice usdkdevice, g0 g0Var) {
            this.f24635a = usdkdevice;
            this.f24636b = g0Var;
        }

        public g0 a() {
            return this.f24636b;
        }

        public uSDKDevice b() {
            return this.f24635a;
        }

        public void c(g0 g0Var) {
            this.f24636b = g0Var;
        }

        public void d(uSDKDevice usdkdevice) {
            this.f24635a = usdkdevice;
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i7 = message.what;
            if (i7 == 0 || i7 == 2) {
                j0.this.f24634f.a(((Integer) message.obj).intValue());
            }
        }
    }

    private j0() {
    }

    public static j0 f() {
        if (f24628g == null) {
            f24628g = new j0();
        }
        return f24628g;
    }

    public void a(uSDKDevice usdkdevice) {
        for (int i7 = 0; i7 < this.f24630b.size(); i7++) {
            if (this.f24630b.get(i7) != null && this.f24630b.get(i7).b().getDeviceId().equals(usdkdevice.getDeviceId())) {
                if (this.f24630b.get(i7).a() != null) {
                    this.f24630b.get(i7).a().e();
                }
                this.f24630b.remove(i7);
                this.f24630b.add(new b(usdkdevice, null));
                return;
            }
        }
        this.f24630b.add(new b(usdkdevice, null));
    }

    public void b(uSDKDevice usdkdevice, g0 g0Var) {
        for (int i7 = 0; i7 < this.f24630b.size(); i7++) {
            if (this.f24630b.get(i7) != null && this.f24630b.get(i7).b().getDeviceId().equals(usdkdevice.getDeviceId())) {
                if (this.f24630b.get(i7).a() != null) {
                    this.f24630b.get(i7).a().e();
                }
                this.f24630b.remove(i7);
                this.f24630b.add(new b(usdkdevice, g0Var));
                return;
            }
        }
        this.f24630b.add(new b(usdkdevice, g0Var));
    }

    public void c(uSDKDevice usdkdevice, a aVar) {
        this.f24634f = aVar;
        g0 g0Var = new g0(new c(), 10);
        b(usdkdevice, g0Var);
        g0Var.d();
    }

    public void d(uSDKDevice usdkdevice) {
    }

    public ArrayList<b> e() {
        return this.f24630b;
    }

    public boolean g() {
        return this.f24631c;
    }

    public void h(uSDKDevice usdkdevice) {
        if (usdkdevice == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f24630b.size(); i7++) {
            if (this.f24630b.get(i7) != null && this.f24630b.get(i7).b().getDeviceId().equals(usdkdevice.getDeviceId())) {
                if (this.f24630b.get(i7).a() != null) {
                    this.f24630b.get(i7).a().e();
                }
                this.f24630b.remove(i7);
                return;
            }
        }
    }

    public void i(boolean z7) {
        this.f24631c = z7;
    }
}
