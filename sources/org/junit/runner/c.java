package org.junit.runner;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f39956f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f39957g = Pattern.compile("([\\s\\S]*)\\((.*)\\)");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f39958h = new c(null, "No Tests", new Annotation[0]);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f39959i = new c(null, "Test mechanism", new Annotation[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<c> f39960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f39961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Serializable f39962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Annotation[] f39963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Class<?> f39964e;

    private c(Class<?> cls, String str, Annotation... annotationArr) {
        this(cls, str, str, annotationArr);
    }

    public static c c(Class<?> cls) {
        return new c(cls, cls.getName(), cls.getAnnotations());
    }

    public static c d(String str, Serializable serializable, Annotation... annotationArr) {
        return new c(null, str, serializable, annotationArr);
    }

    public static c e(String str, Annotation... annotationArr) {
        return new c(null, str, annotationArr);
    }

    public static c f(Class<?> cls, String str) {
        return new c(cls, j(str, cls.getName()), new Annotation[0]);
    }

    public static c g(Class<?> cls, String str, Annotation... annotationArr) {
        return new c(cls, j(str, cls.getName()), annotationArr);
    }

    public static c h(String str, String str2, Serializable serializable) {
        return new c(null, j(str2, str), serializable, new Annotation[0]);
    }

    public static c i(String str, String str2, Annotation... annotationArr) {
        return new c(null, j(str2, str), annotationArr);
    }

    private static String j(String str, String str2) {
        return String.format("%s(%s)", str, str2);
    }

    private String v(int i7, String str) {
        Matcher matcher = f39957g.matcher(toString());
        return matcher.matches() ? matcher.group(i7) : str;
    }

    public void a(c cVar) {
        this.f39960a.add(cVar);
    }

    public c b() {
        return new c(this.f39964e, this.f39961b, this.f39963d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f39962c.equals(((c) obj).f39962c);
        }
        return false;
    }

    public int hashCode() {
        return this.f39962c.hashCode();
    }

    public <T extends Annotation> T k(Class<T> cls) {
        for (Annotation annotation : this.f39963d) {
            if (annotation.annotationType().equals(cls)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public Collection<Annotation> l() {
        return Arrays.asList(this.f39963d);
    }

    public ArrayList<c> m() {
        return new ArrayList<>(this.f39960a);
    }

    public String n() {
        return this.f39964e != null ? this.f39964e.getName() : v(2, toString());
    }

    public String o() {
        return this.f39961b;
    }

    public String p() {
        return v(1, null);
    }

    public Class<?> q() {
        if (this.f39964e != null) {
            return this.f39964e;
        }
        String strN = n();
        if (strN == null) {
            return null;
        }
        try {
            this.f39964e = Class.forName(strN, false, getClass().getClassLoader());
            return this.f39964e;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public boolean r() {
        return equals(f39958h);
    }

    public boolean t() {
        return !u();
    }

    public String toString() {
        return o();
    }

    public boolean u() {
        return this.f39960a.isEmpty();
    }

    public int w() {
        if (u()) {
            return 1;
        }
        Iterator<c> it = this.f39960a.iterator();
        int iW = 0;
        while (it.hasNext()) {
            iW += it.next().w();
        }
        return iW;
    }

    private c(Class<?> cls, String str, Serializable serializable, Annotation... annotationArr) {
        this.f39960a = new ConcurrentLinkedQueue();
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The display name must not be empty.");
        }
        if (serializable == null) {
            throw new IllegalArgumentException("The unique id must not be null.");
        }
        this.f39964e = cls;
        this.f39961b = str;
        this.f39962c = serializable;
        this.f39963d = annotationArr;
    }
}
