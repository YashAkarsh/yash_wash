package com.realsil.sdk.core.bluetooth.scanner;

import android.os.Parcel;
import android.os.Parcelable;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ScannerParams implements Parcelable {
    public static final Parcelable.Creator<ScannerParams> CREATOR = new a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f33173n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f33174o = 17;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f33175p = 18;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f33176q = 32;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f33177r = 33;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f33178s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f33179t = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f33180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f33181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f33182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f33183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f33184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f33185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f33186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f33187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f33188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f33189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f33190k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f33191l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<CompatScanFilter> f33192m;

    public static class a implements Parcelable.Creator<ScannerParams> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScannerParams createFromParcel(Parcel parcel) {
            return new ScannerParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScannerParams[] newArray(int i7) {
            return new ScannerParams[i7];
        }
    }

    public ScannerParams() {
        this(0);
    }

    public void A(int i7) {
        this.f33185f = i7;
    }

    public void B(List<CompatScanFilter> list) {
        this.f33192m = list;
    }

    public void D(int i7) {
        this.f33181b = i7;
    }

    public void E(int i7) {
        this.f33180a = i7;
    }

    public void F(long j7) {
        this.f33186g = j7;
    }

    public String a() {
        return this.f33184e;
    }

    public long b() {
        return this.f33188i;
    }

    public String d() {
        return this.f33182c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f33190k;
    }

    public int f() {
        return this.f33185f;
    }

    public List<CompatScanFilter> g() {
        return this.f33192m;
    }

    public int h() {
        return this.f33181b;
    }

    public int i() {
        return this.f33180a;
    }

    public long j() {
        return this.f33186g;
    }

    public boolean k() {
        return this.f33187h;
    }

    public boolean l() {
        return this.f33191l;
    }

    public boolean n() {
        return this.f33183d;
    }

    public boolean o() {
        return this.f33189j;
    }

    public void p(String str) {
        this.f33184e = str;
    }

    public void s(boolean z7) {
        this.f33187h = z7;
    }

    public void t(long j7) {
        this.f33188i = j7;
    }

    public void u(boolean z7) {
        this.f33191l = z7;
    }

    public void w(String str) {
        this.f33182c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f33180a);
        parcel.writeInt(this.f33181b);
        parcel.writeString(this.f33182c);
        parcel.writeByte(this.f33183d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f33184e);
        parcel.writeInt(this.f33185f);
        parcel.writeLong(this.f33186g);
        parcel.writeByte(this.f33187h ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f33188i);
        parcel.writeByte(this.f33189j ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f33190k);
        parcel.writeByte(this.f33191l ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f33192m);
    }

    public void x(boolean z7) {
        this.f33183d = z7;
    }

    public void y(int i7) {
        this.f33190k = i7;
    }

    public void z(boolean z7) {
        this.f33189j = z7;
    }

    public ScannerParams(int i7) {
        this.f33180a = 0;
        this.f33181b = 0;
        this.f33183d = true;
        this.f33185f = -1000;
        this.f33186g = RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT;
        this.f33188i = 3000L;
        this.f33189j = true;
        this.f33190k = 255;
        this.f33191l = true;
        this.f33192m = new ArrayList();
        this.f33180a = i7;
        this.f33187h = false;
        this.f33181b = 0;
    }

    public ScannerParams(Parcel parcel) {
        this.f33180a = 0;
        this.f33181b = 0;
        this.f33183d = true;
        this.f33185f = -1000;
        this.f33186g = RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT;
        this.f33188i = 3000L;
        this.f33189j = true;
        this.f33190k = 255;
        this.f33191l = true;
        this.f33192m = new ArrayList();
        this.f33180a = parcel.readInt();
        this.f33181b = parcel.readInt();
        this.f33182c = parcel.readString();
        this.f33183d = parcel.readByte() != 0;
        this.f33184e = parcel.readString();
        this.f33185f = parcel.readInt();
        this.f33186g = parcel.readLong();
        this.f33187h = parcel.readByte() != 0;
        this.f33188i = parcel.readLong();
        this.f33189j = parcel.readByte() != 0;
        this.f33190k = parcel.readInt();
        this.f33191l = parcel.readByte() != 0;
        this.f33192m = parcel.createTypedArrayList(CompatScanFilter.CREATOR);
    }
}
