package org.chromium.net;

import android.content.Context;
import android.util.Log;
import c.g1;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39438a = "j";

    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f39439b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f39440c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f39441d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f39442e = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final s f39443a;

        /* JADX INFO: renamed from: org.chromium.net.j$a$a, reason: collision with other inner class name */
        class C0523a implements Comparator<l> {
            C0523a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(l lVar, l lVar2) {
                if (l.f39450c.equals(lVar.e())) {
                    return 1;
                }
                if (l.f39450c.equals(lVar2.e())) {
                    return -1;
                }
                return -a.d(lVar.f(), lVar2.f());
            }
        }

        public static abstract class b {
            public abstract void a(String str);
        }

        public a(Context context) {
            this(e(context));
        }

        @g1
        static int d(String str, String str2) {
            if (str == null || str2 == null) {
                throw new IllegalArgumentException("The input values cannot be null");
            }
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            for (int i7 = 0; i7 < strArrSplit.length && i7 < strArrSplit2.length; i7++) {
                try {
                    int i8 = Integer.parseInt(strArrSplit[i7]);
                    int i9 = Integer.parseInt(strArrSplit2[i7]);
                    if (i8 != i9) {
                        return Integer.signum(i8 - i9);
                    }
                } catch (NumberFormatException e8) {
                    throw new IllegalArgumentException("Unable to convert version segments into integers: " + strArrSplit[i7] + " & " + strArrSplit2[i7], e8);
                }
            }
            return Integer.signum(strArrSplit.length - strArrSplit2.length);
        }

        private static s e(Context context) {
            l lVar = m(context, new ArrayList(l.d(context))).get(0);
            if (Log.isLoggable(j.f39438a, 3)) {
                Log.d(j.f39438a, String.format("Using '%s' provider for creating CronetEngine.Builder.", lVar));
            }
            return lVar.c().f39443a;
        }

        @g1
        static List<l> m(Context context, List<l> list) {
            if (list.size() == 0) {
                throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
            }
            Iterator<l> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().g()) {
                    it.remove();
                }
            }
            if (list.size() == 0) {
                throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
            }
            Collections.sort(list, new C0523a());
            return list;
        }

        public a a(String str, Set<byte[]> set, boolean z7, Date date) {
            this.f39443a.a(str, set, z7, date);
            return this;
        }

        public a b(String str, int i7, int i8) {
            this.f39443a.b(str, i7, i8);
            return this;
        }

        public j c() {
            return this.f39443a.c();
        }

        public a f(boolean z7) {
            this.f39443a.d(z7);
            return this;
        }

        public a g(boolean z7) {
            this.f39443a.e(z7);
            return this;
        }

        public a h(int i7, long j7) {
            this.f39443a.f(i7, j7);
            return this;
        }

        public a i(boolean z7) {
            this.f39443a.h(z7);
            return this;
        }

        public a j(boolean z7) {
            this.f39443a.i(z7);
            return this;
        }

        @Deprecated
        public a k(boolean z7) {
            return this;
        }

        public String l() {
            return this.f39443a.k();
        }

        public a n(b bVar) {
            this.f39443a.m(bVar);
            return this;
        }

        public a o(String str) {
            this.f39443a.n(str);
            return this;
        }

        public a p(String str) {
            this.f39443a.p(str);
            return this;
        }

        public a(s sVar) {
            this.f39443a = sVar;
        }
    }

    public abstract URLStreamHandlerFactory b();

    public abstract byte[] c();

    public abstract String d();

    public abstract t0.a e(String str, t0.b bVar, Executor executor);

    public abstract URLConnection f(URL url) throws IOException;

    public abstract void g();

    public abstract void h(String str, boolean z7);

    public abstract void i();
}
