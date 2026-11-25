package com.haier.uhome.control.base.api;

import android.text.TextUtils;
import com.haier.uhome.usdk.base.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f28779d;

    public b() {
        this.f28779d = 0L;
    }

    public void a(long j7) {
        this.f28779d = j7;
    }

    protected void b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mName is empty");
        }
        this.f28776a = str;
    }

    protected void c(String str) {
        this.f28777b = str;
    }

    public String getName() {
        return this.f28776a;
    }

    public String getTimestamp() {
        return this.f28778c;
    }

    @Keep
    public long getUniqueId() {
        return this.f28779d;
    }

    public String getValue() {
        return this.f28777b;
    }

    public String toString() {
        return String.format("DeviceAlarm[name=%s,value=%s,timestamp=%s,uniqueId=%s]", this.f28776a, this.f28777b, this.f28778c, Long.valueOf(this.f28779d));
    }

    protected void a(String str) {
        this.f28778c = str;
    }

    public b(String str, String str2) {
        b(str);
        c(str2);
        this.f28778c = com.haier.library.common.util.a0.b();
        this.f28779d = 0L;
    }

    public b(String str, String str2, long j7) {
        b(str);
        c(str2);
        this.f28778c = com.haier.library.common.util.a0.b();
        this.f28779d = j7;
    }
}
