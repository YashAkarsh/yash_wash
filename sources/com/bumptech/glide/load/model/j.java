package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f14486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f14487d;

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f14488e = "User-Agent";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f14489f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f14490g = "Accept-Encoding";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f14491h = "identity";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final Map<String, List<i>> f14492i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f14493a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f14494b = f14492i;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14495c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14496d = true;

        static {
            String property = System.getProperty("http.agent");
            f14489f = property;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                map.put("User-Agent", Collections.singletonList(new b(property)));
            }
            map.put("Accept-Encoding", Collections.singletonList(new b(f14491h)));
            f14492i = Collections.unmodifiableMap(map);
        }

        private Map<String, List<i>> d() {
            HashMap map = new HashMap(this.f14494b.size());
            for (Map.Entry<String, List<i>> entry : this.f14494b.entrySet()) {
                map.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return map;
        }

        private void e() {
            if (this.f14493a) {
                this.f14493a = false;
                this.f14494b = d();
            }
        }

        private List<i> f(String str) {
            List<i> list = this.f14494b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f14494b.put(str, arrayList);
            return arrayList;
        }

        public a a(String str, i iVar) {
            if ((this.f14495c && "Accept-Encoding".equalsIgnoreCase(str)) || (this.f14496d && "User-Agent".equalsIgnoreCase(str))) {
                return g(str, iVar);
            }
            e();
            f(str).add(iVar);
            return this;
        }

        public a b(String str, String str2) {
            return a(str, new b(str2));
        }

        public j c() {
            this.f14493a = true;
            return new j(this.f14494b);
        }

        public a g(String str, i iVar) {
            e();
            if (iVar == null) {
                this.f14494b.remove(str);
            } else {
                List<i> listF = f(str);
                listF.clear();
                listF.add(iVar);
            }
            if (this.f14495c && "Accept-Encoding".equalsIgnoreCase(str)) {
                this.f14495c = false;
            }
            if (this.f14496d && "User-Agent".equalsIgnoreCase(str)) {
                this.f14496d = false;
            }
            return this;
        }

        public a h(String str, String str2) {
            return g(str, str2 == null ? null : new b(str2));
        }
    }

    static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14497a;

        b(String str) {
            this.f14497a = str;
        }

        @Override // com.bumptech.glide.load.model.i
        public String a() {
            return this.f14497a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f14497a.equals(((b) obj).f14497a);
            }
            return false;
        }

        public int hashCode() {
            return this.f14497a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f14497a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f14486c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f14486c.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<i> value = entry.getValue();
            for (int i7 = 0; i7 < value.size(); i7++) {
                sb.append(value.get(i7).a());
                if (i7 != value.size() - 1) {
                    sb.append(',');
                }
            }
            map.put(entry.getKey(), sb.toString());
        }
        return map;
    }

    @Override // com.bumptech.glide.load.model.e
    public Map<String, String> a() {
        if (this.f14487d == null) {
            synchronized (this) {
                if (this.f14487d == null) {
                    this.f14487d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f14487d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f14486c.equals(((j) obj).f14486c);
        }
        return false;
    }

    public int hashCode() {
        return this.f14486c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f14486c + '}';
    }
}
