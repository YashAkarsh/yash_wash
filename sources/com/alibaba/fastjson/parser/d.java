package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final char f12830b0 = 26;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f12831c0 = -1;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f12832d0 = -2;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f12833e0 = 0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f12834f0 = 1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f12835g0 = 2;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f12836h0 = 3;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f12837i0 = 4;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f12838j0 = 5;

    String A1();

    Number B1(boolean z7);

    float C(char c8);

    void E();

    void F();

    boolean G(c cVar);

    Number G0();

    int H();

    float I0();

    void J0(Collection<String> collection, char c8);

    void K();

    int L0();

    boolean N1();

    void Q(int i7);

    String Q0(char c8);

    String R1();

    String T0(k kVar);

    int V0();

    void Y0(Locale locale);

    double a1(char c8);

    int b();

    void close();

    char d1();

    String e();

    void e1(TimeZone timeZone);

    String g0(k kVar, char c8);

    Locale getLocale();

    TimeZone getTimeZone();

    BigDecimal h0();

    BigDecimal i1(char c8);

    boolean isEnabled(int i7);

    int l0(char c8);

    char next();

    byte[] o0();

    String p0(k kVar, char c8);

    long q();

    void q1();

    Enum<?> r(Class<?> cls, k kVar, char c8);

    void r0(c cVar, boolean z7);

    String s0(k kVar);

    void s1();

    boolean u();

    boolean v(char c8);

    void v0(int i7);

    long w1(char c8);

    String x0();

    void z1();
}
