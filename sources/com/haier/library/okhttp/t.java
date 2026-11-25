package com.haier.library.okhttp;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f27802b;

    public t(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (map == null) {
            throw new NullPointerException("authParams == null");
        }
        this.f27801a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.f27802b = Collections.unmodifiableMap(linkedHashMap);
    }

    public t a(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f27802b);
        linkedHashMap.put("charset", charset.name());
        return new t(this.f27801a, linkedHashMap);
    }

    public String b() {
        return this.f27801a;
    }

    public Map<String, String> c() {
        return this.f27802b;
    }

    public String d() {
        return this.f27802b.get("realm");
    }

    public Charset e() {
        String str = this.f27802b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return n.d.f27696k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (tVar.f27801a.equals(this.f27801a) && tVar.f27802b.equals(this.f27802b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f27801a.hashCode()) * 31) + this.f27802b.hashCode();
    }

    public String toString() {
        return this.f27801a + " authParams=" + this.f27802b;
    }

    public t(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str2 != null) {
            this.f27801a = str;
            this.f27802b = Collections.singletonMap("realm", str2);
            return;
        }
        throw new NullPointerException("realm == null");
    }
}
