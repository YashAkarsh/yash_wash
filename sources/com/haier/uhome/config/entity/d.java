package com.haier.uhome.config.entity;

import com.haier.uhome.config.json.notify.ConfigStateNotify;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28505a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f28506b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f28509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f28510f;

    private d(String str, String str2, int i7, int i8) {
        this.f28507c = str;
        this.f28508d = str2;
        this.f28509e = Integer.valueOf(i7);
        this.f28510f = Integer.valueOf(i8);
    }

    public String a() {
        return this.f28507c;
    }

    public String b() {
        return this.f28508d;
    }

    public int c() {
        return this.f28509e.intValue();
    }

    public int d() {
        return this.f28509e.intValue() / 1000;
    }

    public int e() {
        return this.f28510f.intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return Objects.equals(this.f28507c, dVar.f28507c) && Objects.equals(this.f28508d, dVar.f28508d) && Objects.equals(this.f28509e, dVar.f28509e) && Objects.equals(this.f28510f, dVar.f28510f);
    }

    public int hashCode() {
        return Objects.hash(this.f28507c, this.f28508d, this.f28509e, this.f28510f);
    }

    public String toString() {
        return "ConfigStateDTO{wifiMac='" + this.f28507c + "', uplusId='" + this.f28508d + "', code=" + this.f28509e + ", type=" + this.f28510f + '}';
    }

    public static d a(ConfigStateNotify configStateNotify, int i7) {
        return new d(configStateNotify.getWifiMac(), configStateNotify.getUplusId(), configStateNotify.getCode(), i7);
    }
}
