package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import c.m0;
import c.o0;
import java.io.Serializable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public abstract class u<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    public static final u<Integer> f8921b = new c(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    public static final u<Integer> f8922c = new d(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    public static final u<int[]> f8923d = new e(true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    public static final u<Long> f8924e = new f(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    public static final u<long[]> f8925f = new g(true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m0
    public static final u<Float> f8926g = new h(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @m0
    public static final u<float[]> f8927h = new i(true);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @m0
    public static final u<Boolean> f8928i = new j(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @m0
    public static final u<boolean[]> f8929j = new k(true);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @m0
    public static final u<String> f8930k = new a(true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @m0
    public static final u<String[]> f8931l = new b(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8932a;

    class a extends u<String> {
        a(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return androidx.constraintlayout.core.motion.utils.w.b.f3030e;
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public String b(@m0 Bundle bundle, @m0 String str) {
            return (String) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public String k(@m0 String str) {
            return str;
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 String str2) {
            bundle.putString(str, str2);
        }
    }

    class b extends u<String[]> {
        b(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return "string[]";
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public String[] b(@m0 Bundle bundle, @m0 String str) {
            return (String[]) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public String[] k(@m0 String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    class c extends u<Integer> {
        c(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return androidx.constraintlayout.core.motion.utils.w.b.f3027b;
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer b(@m0 Bundle bundle, @m0 String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer k(@m0 String str) {
            return str.startsWith("0x") ? Integer.valueOf(Integer.parseInt(str.substring(2), 16)) : Integer.valueOf(Integer.parseInt(str));
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @m0 Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    class d extends u<Integer> {
        d(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return "reference";
        }

        @Override // androidx.navigation.u
        @c.c
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer b(@m0 Bundle bundle, @m0 String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer k(@m0 String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @c.c @m0 Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    class e extends u<int[]> {
        e(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return "integer[]";
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public int[] b(@m0 Bundle bundle, @m0 String str) {
            return (int[]) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public int[] k(@m0 String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    class f extends u<Long> {
        f(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return "long";
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Long b(@m0 Bundle bundle, @m0 String str) {
            return (Long) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Long k(@m0 String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            return str.startsWith("0x") ? Long.valueOf(Long.parseLong(str.substring(2), 16)) : Long.valueOf(Long.parseLong(str));
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @m0 Long l7) {
            bundle.putLong(str, l7.longValue());
        }
    }

    class g extends u<long[]> {
        g(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return "long[]";
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public long[] b(@m0 Bundle bundle, @m0 String str) {
            return (long[]) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public long[] k(@m0 String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    class h extends u<Float> {
        h(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return androidx.constraintlayout.core.motion.utils.w.b.f3028c;
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Float b(@m0 Bundle bundle, @m0 String str) {
            return (Float) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Float k(@m0 String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @m0 Float f8) {
            bundle.putFloat(str, f8.floatValue());
        }
    }

    class i extends u<float[]> {
        i(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return "float[]";
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public float[] b(@m0 Bundle bundle, @m0 String str) {
            return (float[]) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public float[] k(@m0 String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    class j extends u<Boolean> {
        j(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return androidx.constraintlayout.core.motion.utils.w.b.f3031f;
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Boolean b(@m0 Bundle bundle, @m0 String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Boolean k(@m0 String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if (com.paytm.pgsdk.d.G.equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @m0 Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    class k extends u<boolean[]> {
        k(boolean z7) {
            super(z7);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return "boolean[]";
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean[] b(@m0 Bundle bundle, @m0 String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean[] k(@m0 String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static final class l<D extends Enum> extends p<D> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @m0
        private final Class<D> f8933n;

        public l(@m0 Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.f8933n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // androidx.navigation.u.p, androidx.navigation.u
        @m0
        public String c() {
            return this.f8933n.getName();
        }

        @Override // androidx.navigation.u.p
        @m0
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public D k(@m0 String str) {
            for (D d8 : this.f8933n.getEnumConstants()) {
                if (d8.name().equals(str)) {
                    return d8;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.f8933n.getName() + com.alibaba.android.arouter.utils.b.f12515h);
        }
    }

    public static final class m<D extends Parcelable> extends u<D[]> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @m0
        private final Class<D[]> f8934m;

        public m(@m0 Class<D> cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
            try {
                this.f8934m = (Class<D[]>) Class.forName("[L" + cls.getName() + com.alipay.sdk.util.j.f13806b);
            } catch (ClassNotFoundException e8) {
                throw new RuntimeException(e8);
            }
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return this.f8934m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.f8934m.equals(((m) obj).f8934m);
        }

        public int hashCode() {
            return this.f8934m.hashCode();
        }

        @Override // androidx.navigation.u
        @o0
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public D[] b(@m0 Bundle bundle, @m0 String str) {
            return (D[]) ((Parcelable[]) bundle.get(str));
        }

        @Override // androidx.navigation.u
        @m0
        public D[] k(@m0 String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 D[] dArr) {
            this.f8934m.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    public static final class n<D> extends u<D> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @m0
        private final Class<D> f8935m;

        public n(@m0 Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.f8935m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        @Override // androidx.navigation.u
        @o0
        public D b(@m0 Bundle bundle, @m0 String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return this.f8935m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.f8935m.equals(((n) obj).f8935m);
        }

        @Override // androidx.navigation.u
        @m0
        /* JADX INFO: renamed from: h */
        public D k(@m0 String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public int hashCode() {
            return this.f8935m.hashCode();
        }

        @Override // androidx.navigation.u
        public void i(@m0 Bundle bundle, @m0 String str, @o0 D d8) {
            this.f8935m.cast(d8);
            if (d8 == null || (d8 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d8);
            } else if (d8 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d8);
            }
        }
    }

    public static final class o<D extends Serializable> extends u<D[]> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @m0
        private final Class<D[]> f8936m;

        public o(@m0 Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
            try {
                this.f8936m = (Class<D[]>) Class.forName("[L" + cls.getName() + com.alipay.sdk.util.j.f13806b);
            } catch (ClassNotFoundException e8) {
                throw new RuntimeException(e8);
            }
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return this.f8936m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.f8936m.equals(((o) obj).f8936m);
        }

        public int hashCode() {
            return this.f8936m.hashCode();
        }

        @Override // androidx.navigation.u
        @o0
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public D[] b(@m0 Bundle bundle, @m0 String str) {
            return (D[]) ((Serializable[]) bundle.get(str));
        }

        @Override // androidx.navigation.u
        @m0
        public D[] k(@m0 String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 D[] dArr) {
            this.f8936m.cast(dArr);
            bundle.putSerializable(str, dArr);
        }
    }

    u(boolean z7) {
        this.f8932a = z7;
    }

    @m0
    public static u<?> a(@o0 String str, @o0 String str2) {
        String strSubstring;
        u<Integer> uVar = f8921b;
        if (uVar.c().equals(str)) {
            return uVar;
        }
        u uVar2 = f8923d;
        if (uVar2.c().equals(str)) {
            return uVar2;
        }
        u<Long> uVar3 = f8924e;
        if (uVar3.c().equals(str)) {
            return uVar3;
        }
        u uVar4 = f8925f;
        if (uVar4.c().equals(str)) {
            return uVar4;
        }
        u<Boolean> uVar5 = f8928i;
        if (uVar5.c().equals(str)) {
            return uVar5;
        }
        u uVar6 = f8929j;
        if (uVar6.c().equals(str)) {
            return uVar6;
        }
        u<String> uVar7 = f8930k;
        if (uVar7.c().equals(str)) {
            return uVar7;
        }
        u uVar8 = f8931l;
        if (uVar8.c().equals(str)) {
            return uVar8;
        }
        u<Float> uVar9 = f8926g;
        if (uVar9.c().equals(str)) {
            return uVar9;
        }
        u uVar10 = f8927h;
        if (uVar10.c().equals(str)) {
            return uVar10;
        }
        u<Integer> uVar11 = f8922c;
        if (uVar11.c().equals(str)) {
            return uVar11;
        }
        if (str == null || str.isEmpty()) {
            return uVar7;
        }
        try {
            if (!str.startsWith(com.alibaba.android.arouter.utils.b.f12515h) || str2 == null) {
                strSubstring = str;
            } else {
                strSubstring = str2 + str;
            }
            if (str.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                Class<?> cls = Class.forName(strSubstring);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new m(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new o(cls);
                }
            } else {
                Class<?> cls2 = Class.forName(strSubstring);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new n(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new l(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new p(cls2);
                }
            }
            throw new IllegalArgumentException(strSubstring + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(e8);
        }
    }

    @m0
    static u d(@m0 String str) {
        try {
            try {
                try {
                    try {
                        u<Integer> uVar = f8921b;
                        uVar.k(str);
                        return uVar;
                    } catch (IllegalArgumentException unused) {
                        u<Boolean> uVar2 = f8928i;
                        uVar2.k(str);
                        return uVar2;
                    }
                } catch (IllegalArgumentException unused2) {
                    u<Float> uVar3 = f8926g;
                    uVar3.k(str);
                    return uVar3;
                }
            } catch (IllegalArgumentException unused3) {
                u<Long> uVar4 = f8924e;
                uVar4.k(str);
                return uVar4;
            }
        } catch (IllegalArgumentException unused4) {
            return f8930k;
        }
    }

    @m0
    static u e(@o0 Object obj) {
        if (obj instanceof Integer) {
            return f8921b;
        }
        if (obj instanceof int[]) {
            return f8923d;
        }
        if (obj instanceof Long) {
            return f8924e;
        }
        if (obj instanceof long[]) {
            return f8925f;
        }
        if (obj instanceof Float) {
            return f8926g;
        }
        if (obj instanceof float[]) {
            return f8927h;
        }
        if (obj instanceof Boolean) {
            return f8928i;
        }
        if (obj instanceof boolean[]) {
            return f8929j;
        }
        if ((obj instanceof String) || obj == null) {
            return f8930k;
        }
        if (obj instanceof String[]) {
            return f8931l;
        }
        if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new m(obj.getClass().getComponentType());
        }
        if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new o(obj.getClass().getComponentType());
        }
        if (obj instanceof Parcelable) {
            return new n(obj.getClass());
        }
        if (obj instanceof Enum) {
            return new l(obj.getClass());
        }
        if (obj instanceof Serializable) {
            return new p(obj.getClass());
        }
        throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
    }

    @o0
    public abstract T b(@m0 Bundle bundle, @m0 String str);

    @m0
    public abstract String c();

    public boolean f() {
        return this.f8932a;
    }

    @m0
    T g(@m0 Bundle bundle, @m0 String str, @m0 String str2) {
        T tK = k(str2);
        i(bundle, str, tK);
        return tK;
    }

    @m0
    /* JADX INFO: renamed from: h */
    public abstract T k(@m0 String str);

    public abstract void i(@m0 Bundle bundle, @m0 String str, @o0 T t7);

    @m0
    public String toString() {
        return c();
    }

    public static class p<D extends Serializable> extends u<D> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @m0
        private final Class<D> f8937m;

        public p(@m0 Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
            if (!cls.isEnum()) {
                this.f8937m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
        }

        @Override // androidx.navigation.u
        @m0
        public String c() {
            return this.f8937m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof p) {
                return this.f8937m.equals(((p) obj).f8937m);
            }
            return false;
        }

        public int hashCode() {
            return this.f8937m.hashCode();
        }

        @Override // androidx.navigation.u
        @o0
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public D b(@m0 Bundle bundle, @m0 String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.u
        @m0
        public D k(@m0 String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.u
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(@m0 Bundle bundle, @m0 String str, @o0 D d8) {
            this.f8937m.cast(d8);
            bundle.putSerializable(str, d8);
        }

        p(boolean z7, @m0 Class<D> cls) {
            super(z7);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.f8937m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }
}
