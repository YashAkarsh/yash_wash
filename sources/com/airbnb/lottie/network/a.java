package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.f;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    JSON(".json"),
    ZIP(".zip");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12167a;

    a(String str) {
        this.f12167a = str;
    }

    public static a a(String str) {
        for (a aVar : values()) {
            if (str.endsWith(aVar.f12167a)) {
                return aVar;
            }
        }
        f.e("Unable to find correct extension for " + str);
        return JSON;
    }

    public String b() {
        return ".temp" + this.f12167a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f12167a;
    }
}
