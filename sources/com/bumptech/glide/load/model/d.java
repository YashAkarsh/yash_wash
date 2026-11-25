package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14468f = "@#&=*+-_.,:!?()/~'%";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f14469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f14470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private URL f14473e;

    public d(URL url) {
        this(url, e.f14475b);
    }

    private String c() {
        if (TextUtils.isEmpty(this.f14472d)) {
            String string = this.f14471c;
            if (TextUtils.isEmpty(string)) {
                string = this.f14469a.toString();
            }
            this.f14472d = Uri.encode(string, f14468f);
        }
        return this.f14472d;
    }

    private URL d() throws MalformedURLException {
        if (this.f14473e == null) {
            this.f14473e = new URL(c());
        }
        return this.f14473e;
    }

    public String a() {
        String str = this.f14471c;
        return str != null ? str : this.f14469a.toString();
    }

    public Map<String, String> b() {
        return this.f14470b.a();
    }

    public String e() {
        return c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a().equals(dVar.a()) && this.f14470b.equals(dVar.f14470b);
    }

    public URL f() throws MalformedURLException {
        return d();
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f14470b.hashCode();
    }

    public String toString() {
        return a() + '\n' + this.f14470b.toString();
    }

    public d(String str) {
        this(str, e.f14475b);
    }

    public d(URL url, e eVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (eVar != null) {
            this.f14469a = url;
            this.f14471c = null;
            this.f14470b = eVar;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }

    public d(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (eVar != null) {
            this.f14471c = str;
            this.f14469a = null;
            this.f14470b = eVar;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }
}
