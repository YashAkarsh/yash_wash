package com.alipay.security.mobile.module.d;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13913g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f13907a = str;
        this.f13908b = str2;
        this.f13909c = str3;
        this.f13910d = str4;
        this.f13911e = str5;
        this.f13912f = str6;
        this.f13913g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String strSubstring;
        StringBuilder sb2;
        String strSubstring2;
        StringBuilder sb3;
        String strSubstring3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f13907a);
        stringBuffer.append("," + this.f13908b);
        stringBuffer.append("," + this.f13909c);
        stringBuffer.append("," + this.f13910d);
        if (o0.a.d(this.f13911e) || this.f13911e.length() < 20) {
            sb = new StringBuilder(",");
            strSubstring = this.f13911e;
        } else {
            sb = new StringBuilder(",");
            strSubstring = this.f13911e.substring(0, 20);
        }
        sb.append(strSubstring);
        stringBuffer.append(sb.toString());
        if (o0.a.d(this.f13912f) || this.f13912f.length() < 20) {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f13912f;
        } else {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f13912f.substring(0, 20);
        }
        sb2.append(strSubstring2);
        stringBuffer.append(sb2.toString());
        if (o0.a.d(this.f13913g) || this.f13913g.length() < 20) {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.f13913g;
        } else {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.f13913g.substring(0, 20);
        }
        sb3.append(strSubstring3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
