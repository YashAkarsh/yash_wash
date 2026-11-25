package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f39967a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Class<?>> f39968b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Throwable> f39969c = new ArrayList();

    public static class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f39970a = 1;

        public a(String str) {
            super(str);
        }
    }

    g() {
    }

    private i a(i iVar) {
        try {
            Iterator<String> it = this.f39967a.iterator();
            while (it.hasNext()) {
                iVar = iVar.g(d.e(iVar, it.next()));
            }
            return iVar;
        } catch (e.a e8) {
            return d(e8);
        }
    }

    private String[] b(String[] strArr, int i7, int i8) {
        ArrayList arrayList = new ArrayList();
        while (i7 != i8) {
            arrayList.add(strArr[i7]);
            i7++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private i d(Throwable th) {
        return i.e(g.class, th);
    }

    public static g g(String[] strArr) {
        g gVar = new g();
        gVar.h(strArr);
        return gVar;
    }

    private void h(String[] strArr) {
        j(i(strArr));
    }

    public i c(org.junit.runner.a aVar) {
        if (!this.f39969c.isEmpty()) {
            return d(new org.junit.runners.model.e(this.f39969c));
        }
        List<Class<?>> list = this.f39968b;
        return a(i.c(aVar, (Class[]) list.toArray(new Class[list.size()])));
    }

    public List<Class<?>> e() {
        return Collections.unmodifiableList(this.f39968b);
    }

    public List<String> f() {
        return Collections.unmodifiableList(this.f39967a);
    }

    String[] i(String... strArr) {
        String strSubstring;
        int i7 = 0;
        while (i7 != strArr.length) {
            String str = strArr[i7];
            if (str.equals("--")) {
                return b(strArr, i7 + 1, strArr.length);
            }
            if (!str.startsWith("--")) {
                return b(strArr, i7, strArr.length);
            }
            if (str.startsWith("--filter=") || str.equals("--filter")) {
                if (str.equals("--filter")) {
                    i7++;
                    if (i7 >= strArr.length) {
                        this.f39969c.add(new a(str + " value not specified"));
                        break;
                    }
                    strSubstring = strArr[i7];
                } else {
                    strSubstring = str.substring(str.indexOf(61) + 1);
                }
                this.f39967a.add(strSubstring);
            } else {
                this.f39969c.add(new a("JUnit knows nothing about the " + str + " option"));
            }
            i7++;
        }
        return new String[0];
    }

    void j(String[] strArr) {
        for (String str : strArr) {
            try {
                this.f39968b.add(org.junit.internal.c.a(str));
            } catch (ClassNotFoundException e8) {
                this.f39969c.add(new IllegalArgumentException("Could not find class [" + str + "]", e8));
            }
        }
    }
}
