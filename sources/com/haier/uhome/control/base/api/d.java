package com.haier.uhome.control.base.api;

import android.text.TextUtils;
import com.haier.uhome.usdk.base.annotation.Keep;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f28785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f28786d;

    protected d() {
        a(0L);
        b(0L);
    }

    public void a(long j7) {
        this.f28785c = j7;
    }

    public void b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("DeviceAttribute value must not be null!");
        }
        this.f28784b = str;
    }

    public String getName() {
        return this.f28783a;
    }

    @Keep
    public long getTimeStamp() {
        return this.f28786d;
    }

    @Keep
    public long getUniqueId() {
        return this.f28785c;
    }

    public String getValue() {
        return this.f28784b;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s{attrName=%s,attrValue=%s,uid=%d,ts=%d}", getClass().getSimpleName(), this.f28783a, this.f28784b, Long.valueOf(this.f28785c), Long.valueOf(this.f28786d));
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("DeviceAttribute name must not be empty!");
        }
        this.f28783a = str;
    }

    public void b(long j7) {
        this.f28786d = j7;
    }

    public d(String str, String str2) {
        this();
        a(str);
        b(str2);
    }

    public d(String str, String str2, long j7, long j8) {
        this(str, str2);
        a(j7);
        b(j8);
    }
}
