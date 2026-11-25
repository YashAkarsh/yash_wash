package com.haier.library.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.haier.library.common.util.w;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f26341n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f26342o = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f26347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f26348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f26349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f26350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f26351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f26352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f26353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private NetworkInfo.State f26354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private NetworkInfo.DetailedState f26355m;

    /* JADX INFO: renamed from: com.haier.library.common.b.a$a, reason: collision with other inner class name */
    public static final class C0348a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f26356a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f26357b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f26358c = "NONE";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f26359d = "NONE";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f26360e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f26361f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f26362g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f26363h = "";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f26365j = "";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f26364i = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f26366k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private NetworkInfo.State f26367l = NetworkInfo.State.DISCONNECTED;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private NetworkInfo.DetailedState f26368m = NetworkInfo.DetailedState.IDLE;

        public C0348a b(int i7) {
            this.f26356a = i7;
            return this;
        }

        public C0348a c(NetworkInfo.DetailedState detailedState) {
            this.f26368m = detailedState;
            return this;
        }

        public C0348a d(NetworkInfo.State state) {
            this.f26367l = state;
            return this;
        }

        public C0348a e(String str) {
            this.f26358c = str;
            return this;
        }

        public C0348a f(boolean z7) {
            this.f26360e = z7;
            return this;
        }

        public a g() {
            return new a(this);
        }

        public C0348a i(int i7) {
            this.f26357b = i7;
            return this;
        }

        public C0348a j(String str) {
            this.f26359d = str;
            return this;
        }

        public C0348a k(boolean z7) {
            this.f26361f = z7;
            return this;
        }

        public C0348a l(String str) {
            this.f26363h = str;
            return this;
        }

        public C0348a m(boolean z7) {
            this.f26362g = z7;
            return this;
        }

        public C0348a o(String str) {
            this.f26364i = str;
            return this;
        }

        public C0348a p(boolean z7) {
            this.f26366k = z7;
            return this;
        }

        public C0348a r(String str) {
            this.f26365j = str;
            return this;
        }
    }

    public a(C0348a c0348a) {
        this.f26343a = c0348a.f26356a;
        this.f26344b = c0348a.f26357b;
        this.f26345c = c0348a.f26358c;
        this.f26346d = c0348a.f26359d;
        this.f26347e = c0348a.f26360e;
        this.f26348f = c0348a.f26361f;
        this.f26349g = c0348a.f26362g;
        this.f26350h = c0348a.f26363h;
        this.f26351i = c0348a.f26364i;
        this.f26352j = c0348a.f26365j;
        this.f26353k = c0348a.f26366k;
        this.f26354l = c0348a.f26367l;
        this.f26355m = c0348a.f26368m;
    }

    public static a b(Context context, NetworkInfo networkInfo, boolean z7) {
        return new C0348a().b(networkInfo.getType()).i(networkInfo.getSubtype()).e(networkInfo.getTypeName()).j(networkInfo.getSubtypeName()).f(networkInfo.isConnected()).k(networkInfo.isFailover()).m(networkInfo.isRoaming()).l(w.g(context)).o(w.d(context)).r(w.b()).p(z7).d(networkInfo.getState()).c(networkInfo.getDetailedState()).g();
    }

    public static a c(Context context, boolean z7) {
        if (context == null) {
            e3.a.h("context is null", new Object[0]);
            return null;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? d(z7) : b(context, activeNetworkInfo, z7);
    }

    public static a d(boolean z7) {
        return new C0348a().p(z7).g();
    }

    public int a() {
        return this.f26343a;
    }

    public int e() {
        return this.f26344b;
    }

    public String f() {
        return this.f26345c;
    }

    public String g() {
        return this.f26346d;
    }

    public boolean h() {
        return this.f26347e;
    }

    public boolean i() {
        return this.f26348f;
    }

    public boolean j() {
        return this.f26349g;
    }

    public String k() {
        return this.f26350h;
    }

    public String l() {
        return this.f26351i;
    }

    public String m() {
        return this.f26352j;
    }

    public boolean n() {
        return this.f26353k;
    }

    public NetworkInfo.State o() {
        return this.f26354l;
    }

    public NetworkInfo.DetailedState p() {
        return this.f26355m;
    }

    public String toString() {
        return "ConnectStatus{type=" + this.f26343a + ", subType=" + this.f26344b + ", typeName='" + this.f26345c + "', subTypeName='" + this.f26346d + "', isAvailable=" + this.f26347e + ", isFailover=" + this.f26348f + ", isRoaming=" + this.f26349g + ", networkId='" + this.f26350h + "', networkName='" + this.f26351i + "', networkIp='" + this.f26352j + "', isApEnable=" + this.f26353k + ", state=" + this.f26354l + ", detailedState=" + this.f26355m + '}';
    }
}
