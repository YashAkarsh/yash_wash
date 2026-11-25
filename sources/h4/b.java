package h4;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f34044j = -1000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f34045k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f34046l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothDevice f34047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f34048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f34050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f34051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f34052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f34053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f34054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f34055i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f34056a;

        public boolean equals(Object obj) {
            return obj instanceof b ? this.f34056a.equals(((b) obj).f34047a.getAddress()) : super.equals(obj);
        }
    }

    public b(BluetoothDevice bluetoothDevice, String str) {
        this(bluetoothDevice, str, -1000, false, false, null);
    }

    public int a() {
        return this.f34052f;
    }

    public BluetoothDevice b() {
        return this.f34047a;
    }

    public String c() {
        return this.f34048b;
    }

    public int d() {
        return this.f34049c;
    }

    public byte[] e() {
        return this.f34053g;
    }

    public boolean equals(Object obj) {
        return obj instanceof b ? this.f34047a.getAddress().equals(((b) obj).f34047a.getAddress()) : super.equals(obj);
    }

    public j f() {
        return this.f34054h;
    }

    public boolean g() {
        return this.f34050d;
    }

    public boolean h() {
        return this.f34051e;
    }

    public boolean i() {
        return this.f34055i;
    }

    public void j(boolean z7) {
        this.f34050d = z7;
    }

    public void k(boolean z7) {
        this.f34051e = z7;
    }

    public void l(int i7) {
        this.f34052f = i7;
        this.f34051e = i7 == 2;
    }

    public void m(BluetoothDevice bluetoothDevice) {
        this.f34047a = bluetoothDevice;
    }

    public void n(boolean z7) {
        this.f34055i = z7;
    }

    public void o(String str) {
        this.f34048b = str;
    }

    public void p(int i7) {
        this.f34049c = i7;
    }

    public void q(byte[] bArr) {
        this.f34053g = bArr;
        j jVarL = j.l(bArr);
        this.f34054h = jVarL;
        if (jVarL == null || jVarL.j() == null) {
            return;
        }
        this.f34055i = this.f34054h.j().contains(d4.c.f33464l);
    }

    public b(BluetoothDevice bluetoothDevice, String str, int i7) {
        this(bluetoothDevice, str, i7, false, false, null);
    }

    public b(BluetoothDevice bluetoothDevice, String str, int i7, boolean z7, boolean z8) {
        this(bluetoothDevice, str, i7, z7, z8, null);
    }

    public b(BluetoothDevice bluetoothDevice, String str, int i7, boolean z7, boolean z8, byte[] bArr) {
        this.f34047a = bluetoothDevice;
        this.f34048b = str;
        this.f34049c = i7;
        this.f34050d = z7;
        this.f34051e = z8;
        q(bArr);
    }
}
