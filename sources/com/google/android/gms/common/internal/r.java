package com.google.android.gms.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f15776b = new k("LibraryVersion", "");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static r f15777c = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f15778a = new ConcurrentHashMap<>();

    @g1.d0
    protected r() {
    }

    @c1.a
    @c.m0
    public static r a() {
        return f15777c;
    }

    @c1.a
    @c.m0
    public String b(@c.m0 String str) throws Throwable {
        String str2;
        u.h(str, "Please provide a valid libraryName");
        if (this.f15778a.containsKey(str)) {
            return this.f15778a.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        String property = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream resourceAsStream = r.class.getResourceAsStream(String.format("/%s.properties", str));
                try {
                    if (resourceAsStream != null) {
                        properties.load(resourceAsStream);
                        property = properties.getProperty("version", null);
                        k kVar = f15776b;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(property).length());
                        sb.append(str);
                        sb.append(" version is ");
                        sb.append(property);
                        kVar.l("LibraryVersion", sb.toString());
                    } else {
                        k kVar2 = f15776b;
                        String strValueOf = String.valueOf(str);
                        kVar2.n("LibraryVersion", strValueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(strValueOf) : new String("Failed to get app version for libraryName: "));
                    }
                    if (resourceAsStream != null) {
                        g1.q.b(resourceAsStream);
                    }
                } catch (IOException e8) {
                    e = e8;
                    inputStream = resourceAsStream;
                    str2 = null;
                    k kVar3 = f15776b;
                    String strValueOf2 = String.valueOf(str);
                    kVar3.f("LibraryVersion", strValueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(strValueOf2) : new String("Failed to get app version for libraryName: "), e);
                    if (inputStream != null) {
                        g1.q.b(inputStream);
                    }
                    property = str2;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = resourceAsStream;
                    if (inputStream2 != null) {
                        g1.q.b(inputStream2);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e9) {
            e = e9;
            str2 = null;
        }
        if (property == null) {
            f15776b.c("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            property = "UNKNOWN";
        }
        this.f15778a.put(str, property);
        return property;
    }
}
