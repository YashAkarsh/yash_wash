package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import c.x0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c1;
import kotlin.collections.o1;
import kotlin.p1;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private static final String f8274g = "values";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private static final String f8275h = "keys";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Map<String, Object> f8277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final Map<String, androidx.savedstate.b.c> f8278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Map<String, b<?>> f8279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final Map<String, kotlinx.coroutines.flow.e0<Object>> f8280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final androidx.savedstate.b.c f8281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    public static final a f8273f = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    private static final Class<? extends Object>[] f8276i = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        @x0({x0.a.LIBRARY_GROUP})
        @h5.l
        public final d0 a(@a7.e Bundle bundle, @a7.e Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new d0();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.l0.o(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new d0(map);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(d0.f8275h);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(d0.f8274g);
            if (!((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true)) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                Object obj = parcelableArrayList.get(i7);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i7));
            }
            return new d0(linkedHashMap);
        }

        @x0({x0.a.LIBRARY_GROUP})
        public final boolean b(@a7.e Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : d0.f8276i) {
                kotlin.jvm.internal.l0.m(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private a() {
        }
    }

    public d0(@a7.d Map<String, ? extends Object> initialState) {
        kotlin.jvm.internal.l0.p(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f8277a = linkedHashMap;
        this.f8278b = new LinkedHashMap();
        this.f8279c = new LinkedHashMap();
        this.f8280d = new LinkedHashMap();
        this.f8281e = new androidx.savedstate.b.c() { // from class: androidx.lifecycle.c0
            @Override // androidx.savedstate.b.c
            public final Bundle a() {
                return d0.p(this.f8263a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    @a7.d
    @x0({x0.a.LIBRARY_GROUP})
    @h5.l
    public static final d0 g(@a7.e Bundle bundle, @a7.e Bundle bundle2) {
        return f8273f.a(bundle, bundle2);
    }

    private final <T> w<T> k(String str, boolean z7, T t7) {
        b<?> bVar;
        b<?> bVar2 = this.f8279c.get(str);
        b<?> bVar3 = bVar2 instanceof w ? bVar2 : null;
        if (bVar3 != null) {
            return bVar3;
        }
        if (this.f8277a.containsKey(str)) {
            bVar = new b<>(this, str, this.f8277a.get(str));
        } else if (z7) {
            this.f8277a.put(str, t7);
            bVar = new b<>(this, str, t7);
        } else {
            bVar = new b<>(this, str);
        }
        this.f8279c.put(str, bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle p(d0 this$0) {
        kotlin.jvm.internal.l0.p(this$0, "this$0");
        for (Map.Entry entry : c1.D0(this$0.f8278b).entrySet()) {
            this$0.q((String) entry.getKey(), ((androidx.savedstate.b.c) entry.getValue()).a());
        }
        Set<String> setKeySet = this$0.f8277a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f8277a.get(str));
        }
        return androidx.core.os.d.b(p1.a(f8275h, arrayList), p1.a(f8274g, arrayList2));
    }

    @c.j0
    public final void e(@a7.d String key) {
        kotlin.jvm.internal.l0.p(key, "key");
        this.f8278b.remove(key);
    }

    @c.j0
    public final boolean f(@a7.d String key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return this.f8277a.containsKey(key);
    }

    @a7.e
    @c.j0
    public final <T> T h(@a7.d String key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return (T) this.f8277a.get(key);
    }

    @a7.d
    @c.j0
    public final <T> w<T> i(@a7.d String key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return k(key, false, null);
    }

    @a7.d
    @c.j0
    public final <T> w<T> j(@a7.d String key, T t7) {
        kotlin.jvm.internal.l0.p(key, "key");
        return k(key, true, t7);
    }

    @a7.d
    @c.j0
    public final <T> kotlinx.coroutines.flow.t0<T> l(@a7.d String key, T t7) {
        kotlin.jvm.internal.l0.p(key, "key");
        Map<String, kotlinx.coroutines.flow.e0<Object>> map = this.f8280d;
        kotlinx.coroutines.flow.e0<Object> e0VarA = map.get(key);
        if (e0VarA == null) {
            if (!this.f8277a.containsKey(key)) {
                this.f8277a.put(key, t7);
            }
            e0VarA = v0.a(this.f8277a.get(key));
            this.f8280d.put(key, e0VarA);
            map.put(key, e0VarA);
        }
        return kotlinx.coroutines.flow.k.m(e0VarA);
    }

    @a7.d
    @c.j0
    public final Set<String> m() {
        return o1.C(o1.C(this.f8277a.keySet(), this.f8278b.keySet()), this.f8279c.keySet());
    }

    @a7.e
    @c.j0
    public final <T> T n(@a7.d String key) {
        kotlin.jvm.internal.l0.p(key, "key");
        T t7 = (T) this.f8277a.remove(key);
        b<?> bVarRemove = this.f8279c.remove(key);
        if (bVarRemove != null) {
            bVarRemove.r();
        }
        this.f8280d.remove(key);
        return t7;
    }

    @a7.d
    @x0({x0.a.LIBRARY_GROUP})
    public final androidx.savedstate.b.c o() {
        return this.f8281e;
    }

    @c.j0
    public final <T> void q(@a7.d String key, @a7.e T t7) {
        kotlin.jvm.internal.l0.p(key, "key");
        if (!f8273f.b(t7)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            kotlin.jvm.internal.l0.m(t7);
            sb.append(t7.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        b<?> bVar = this.f8279c.get(key);
        b<?> bVar2 = bVar instanceof w ? bVar : null;
        if (bVar2 != null) {
            bVar2.q(t7);
        } else {
            this.f8277a.put(key, t7);
        }
        kotlinx.coroutines.flow.e0<Object> e0Var = this.f8280d.get(key);
        if (e0Var == null) {
            return;
        }
        e0Var.setValue(t7);
    }

    @c.j0
    public final void r(@a7.d String key, @a7.d androidx.savedstate.b.c provider) {
        kotlin.jvm.internal.l0.p(key, "key");
        kotlin.jvm.internal.l0.p(provider, "provider");
        this.f8278b.put(key, provider);
    }

    public static final class b<T> extends w<T> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @a7.d
        private String f8282m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @a7.e
        private d0 f8283n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@a7.e d0 d0Var, @a7.d String key, T t7) {
            super(t7);
            kotlin.jvm.internal.l0.p(key, "key");
            this.f8282m = key;
            this.f8283n = d0Var;
        }

        @Override // androidx.lifecycle.w, androidx.lifecycle.LiveData
        public void q(T t7) {
            d0 d0Var = this.f8283n;
            if (d0Var != null) {
                d0Var.f8277a.put(this.f8282m, t7);
                kotlinx.coroutines.flow.e0 e0Var = (kotlinx.coroutines.flow.e0) d0Var.f8280d.get(this.f8282m);
                if (e0Var != null) {
                    e0Var.setValue(t7);
                }
            }
            super.q(t7);
        }

        public final void r() {
            this.f8283n = null;
        }

        public b(@a7.e d0 d0Var, @a7.d String key) {
            kotlin.jvm.internal.l0.p(key, "key");
            this.f8282m = key;
            this.f8283n = d0Var;
        }
    }

    public d0() {
        this.f8277a = new LinkedHashMap();
        this.f8278b = new LinkedHashMap();
        this.f8279c = new LinkedHashMap();
        this.f8280d = new LinkedHashMap();
        this.f8281e = new androidx.savedstate.b.c() { // from class: androidx.lifecycle.c0
            @Override // androidx.savedstate.b.c
            public final Bundle a() {
                return d0.p(this.f8263a);
            }
        };
    }
}
