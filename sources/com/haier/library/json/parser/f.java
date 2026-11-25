package com.haier.library.json.parser;

import androidx.constraintlayout.core.motion.utils.w;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f26723a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f26724b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f26725c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f26726d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f26727e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26728f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26729g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f26730h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f26731i = 9;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f26732j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f26733k = 11;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f26734l = 12;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f26735m = 13;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f26736n = 14;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f26737o = 15;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f26738p = 16;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f26739q = 17;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f26740r = 18;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f26741s = 20;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f26742t = 21;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f26743u = 22;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f26744v = 23;

    public static String a(int i7) {
        switch (i7) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return w.b.f3028c;
            case 4:
                return w.b.f3030e;
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return com.paytm.pgsdk.d.G;
            case 8:
                return "null";
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return "{";
            case 13:
                return com.alipay.sdk.util.j.f13808d;
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return ",";
            case 17:
                return ":";
            case 18:
                return "ident";
            case 19:
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
        }
    }
}
