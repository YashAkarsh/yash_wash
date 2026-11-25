package com.airbnb.lottie.model;

import c.l;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f11941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f11943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f11944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public final int f11945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final int f11946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f11947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11948k;

    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f8, a aVar, int i7, float f9, float f10, @l int i8, @l int i9, float f11, boolean z7) {
        this.f11938a = str;
        this.f11939b = str2;
        this.f11940c = f8;
        this.f11941d = aVar;
        this.f11942e = i7;
        this.f11943f = f9;
        this.f11944g = f10;
        this.f11945h = i8;
        this.f11946i = i9;
        this.f11947j = f11;
        this.f11948k = z7;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f11938a.hashCode() * 31) + this.f11939b.hashCode()) * 31) + this.f11940c)) * 31) + this.f11941d.ordinal()) * 31) + this.f11942e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f11943f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f11945h;
    }
}
