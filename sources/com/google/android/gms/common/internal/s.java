package com.google.android.gms.common.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class s {

    @c1.a
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f15790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f15791b;

        /* synthetic */ a(Object obj, m1 m1Var) {
            u.k(obj);
            this.f15791b = obj;
            this.f15790a = new ArrayList();
        }

        @c1.a
        @c.m0
        public a a(@c.m0 String str, @c.o0 Object obj) {
            List<String> list = this.f15790a;
            u.k(str);
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(str.length() + 1 + strValueOf.length());
            sb.append(str);
            sb.append("=");
            sb.append(strValueOf);
            list.add(sb.toString());
            return this;
        }

        @c1.a
        @c.m0
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f15791b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f15790a.size();
            for (int i7 = 0; i7 < size; i7++) {
                sb.append(this.f15790a.get(i7));
                if (i7 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private s() {
        throw new AssertionError("Uninstantiable");
    }

    @c1.a
    public static boolean a(@c.m0 Bundle bundle, @c.m0 Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> setKeySet = bundle.keySet();
        if (!setKeySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!b(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    @c1.a
    public static boolean b(@c.o0 Object obj, @c.o0 Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @c1.a
    public static int c(@c.m0 Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @c1.a
    @c.m0
    public static a d(@c.m0 Object obj) {
        return new a(obj, null);
    }
}
