package org.junit.runners.parameterized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f40065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Object> f40066c;

    public d(String str, k kVar, List<Object> list) {
        d(str, "The name is missing.");
        d(kVar, "The test class is missing.");
        d(list, "The parameters are missing.");
        this.f40064a = str;
        this.f40065b = kVar;
        this.f40066c = Collections.unmodifiableList(new ArrayList(list));
    }

    private static void d(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public String a() {
        return this.f40064a;
    }

    public List<Object> b() {
        return this.f40066c;
    }

    public k c() {
        return this.f40065b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f40064a.equals(dVar.f40064a) && this.f40066c.equals(dVar.f40066c) && this.f40065b.equals(dVar.f40065b);
    }

    public int hashCode() {
        return ((((this.f40064a.hashCode() + 14747) * 14747) + this.f40065b.hashCode()) * 14747) + this.f40066c.hashCode();
    }

    public String toString() {
        return this.f40065b.k() + " '" + this.f40064a + "' with parameters " + this.f40066c;
    }
}
