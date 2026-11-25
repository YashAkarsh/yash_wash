package com.google.common.reflect;

import com.google.common.base.e0;
import com.google.common.base.f0;
import com.google.common.base.g0;
import com.google.common.base.w;
import com.google.common.collect.ck;
import com.google.common.collect.d6;
import com.google.common.collect.d7;
import com.google.common.collect.h5;
import com.google.common.collect.td;
import com.google.common.collect.u8;
import com.google.common.collect.v7;
import com.google.common.collect.wb;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class m<T> extends com.google.common.reflect.i<T> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f22467d = 3637540370352322684L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f22468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient com.google.common.reflect.k f22469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient com.google.common.reflect.k f22470c;

    class a extends com.google.common.reflect.e.b<T> {
        a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.e, com.google.common.reflect.c
        public m<T> a() {
            return m.this;
        }

        @Override // com.google.common.reflect.e.b, com.google.common.reflect.e
        Type[] r() {
            return m.this.r().l(super.r());
        }

        @Override // com.google.common.reflect.e.b, com.google.common.reflect.e
        Type[] s() {
            return m.this.v().l(super.s());
        }

        @Override // com.google.common.reflect.e.b, com.google.common.reflect.e
        Type t() {
            return m.this.r().j(super.t());
        }

        @Override // com.google.common.reflect.e, com.google.common.reflect.c
        public String toString() {
            return a() + com.alibaba.android.arouter.utils.b.f12515h + super.toString();
        }
    }

    class b extends com.google.common.reflect.e.a<T> {
        b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.e, com.google.common.reflect.c
        public m<T> a() {
            return m.this;
        }

        @Override // com.google.common.reflect.e.a, com.google.common.reflect.e
        Type[] r() {
            return m.this.r().l(super.r());
        }

        @Override // com.google.common.reflect.e.a, com.google.common.reflect.e
        Type[] s() {
            return m.this.v().l(super.s());
        }

        @Override // com.google.common.reflect.e.a, com.google.common.reflect.e
        Type t() {
            return m.this.r().j(super.t());
        }

        @Override // com.google.common.reflect.e, com.google.common.reflect.c
        public String toString() {
            return a() + "(" + w.p(", ").n(s()) + ")";
        }
    }

    class c extends n {
        c() {
        }

        @Override // com.google.common.reflect.n
        void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.n
        void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.n
        void e(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(m.this.f22468a + "contains a type variable and is not safe for the operation");
        }

        @Override // com.google.common.reflect.n
        void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    class d extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u8.a f22474b;

        d(u8.a aVar) {
            this.f22474b = aVar;
        }

        @Override // com.google.common.reflect.n
        void b(Class<?> cls) {
            this.f22474b.a(cls);
        }

        @Override // com.google.common.reflect.n
        void c(GenericArrayType genericArrayType) {
            this.f22474b.a(o.i(m.W(genericArrayType.getGenericComponentType()).x()));
        }

        @Override // com.google.common.reflect.n
        void d(ParameterizedType parameterizedType) {
            this.f22474b.a((Class) parameterizedType.getRawType());
        }

        @Override // com.google.common.reflect.n
        void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.n
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type[] f22476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f22477b;

        e(Type[] typeArr, boolean z7) {
            this.f22476a = typeArr;
            this.f22477b = z7;
        }

        boolean a(Type type) {
            for (Type type2 : this.f22476a) {
                boolean zL = m.W(type2).L(type);
                boolean z7 = this.f22477b;
                if (zL == z7) {
                    return z7;
                }
            }
            return !this.f22477b;
        }

        boolean b(Type type) {
            m<?> mVarW = m.W(type);
            for (Type type2 : this.f22476a) {
                boolean zL = mVarW.L(type2);
                boolean z7 = this.f22477b;
                if (zL == z7) {
                    return z7;
                }
            }
            return !this.f22477b;
        }
    }

    private final class f extends m<T>.k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f22478f = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private transient u8<m<? super T>> f22479d;

        private f() {
            super();
        }

        private Object readResolve() {
            return m.this.E().z0();
        }

        @Override // com.google.common.reflect.m.k
        public m<T>.k A0() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.m.k
        public Set<Class<? super T>> B0() {
            return u8.p(i.f22488b.a().c(m.this.y()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.m.k, com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<m<? super T>> c0() {
            u8<m<? super T>> u8Var = this.f22479d;
            if (u8Var != null) {
                return u8Var;
            }
            u8<m<? super T>> u8VarM = h5.v(i.f22487a.a().d(m.this)).p(j.f22493a).M();
            this.f22479d = u8VarM;
            return u8VarM;
        }

        @Override // com.google.common.reflect.m.k
        public m<T>.k z0() {
            return this;
        }

        /* synthetic */ f(m mVar, a aVar) {
            this();
        }
    }

    private final class g extends m<T>.k {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final long f22481g = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient m<T>.k f22482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private transient u8<m<? super T>> f22483e;

        class a implements g0<Class<?>> {
            a() {
            }

            @Override // com.google.common.base.g0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }

            @Override // com.google.common.base.g0, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return f0.a(this, obj);
            }
        }

        g(m<T>.k kVar) {
            super();
            this.f22482d = kVar;
        }

        private Object readResolve() {
            return m.this.E().A0();
        }

        @Override // com.google.common.reflect.m.k
        public m<T>.k A0() {
            return this;
        }

        @Override // com.google.common.reflect.m.k
        public Set<Class<? super T>> B0() {
            return h5.v(i.f22488b.c(m.this.y())).p(new a()).M();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.m.k, com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<m<? super T>> c0() {
            u8<m<? super T>> u8Var = this.f22483e;
            if (u8Var != null) {
                return u8Var;
            }
            u8<m<? super T>> u8VarM = h5.v(this.f22482d).p(j.f22494b).M();
            this.f22483e = u8VarM;
            return u8VarM;
        }

        @Override // com.google.common.reflect.m.k
        public m<T>.k z0() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }
    }

    private static final class h<T> extends m<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f22486e = 0;

        h(Type type) {
            super(type, null);
        }
    }

    private static abstract class i<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final i<m<?>> f22487a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final i<Class<?>> f22488b = new b();

        static class a extends i<m<?>> {
            a() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.m.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends m<?>> e(m<?> mVar) {
                return mVar.t();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.m.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(m<?> mVar) {
                return mVar.x();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.m.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public m<?> g(m<?> mVar) {
                return mVar.u();
            }
        }

        static class b extends i<Class<?>> {
            b() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.m.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.m.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.m.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        class c extends e<K> {
            c(i iVar) {
                super(iVar);
            }

            @Override // com.google.common.reflect.m.i
            d7<K> c(Iterable<? extends K> iterable) {
                d7.b bVarM = d7.m();
                for (K k7 : iterable) {
                    if (!f(k7).isInterface()) {
                        bVarM.a(k7);
                    }
                }
                return super.c(bVarM.e());
            }

            @Override // com.google.common.reflect.m.i.e, com.google.common.reflect.m.i
            Iterable<? extends K> e(K k7) {
                return u8.A();
            }
        }

        static class d extends td<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Comparator f22490c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map f22491d;

            d(Comparator comparator, Map map) {
                this.f22490c = comparator;
                this.f22491d = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.td, java.util.Comparator
            public int compare(K k7, K k8) {
                return this.f22490c.compare(this.f22491d.get(k7), this.f22491d.get(k8));
            }
        }

        private static class e<K> extends i<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final i<K> f22492c;

            e(i<K> iVar) {
                super(null);
                this.f22492c = iVar;
            }

            @Override // com.google.common.reflect.m.i
            Iterable<? extends K> e(K k7) {
                return this.f22492c.e(k7);
            }

            @Override // com.google.common.reflect.m.i
            Class<?> f(K k7) {
                return this.f22492c.f(k7);
            }

            @Override // com.google.common.reflect.m.i
            K g(K k7) {
                return this.f22492c.g(k7);
            }
        }

        private i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @u1.a
        private int b(K k7, Map<? super K, Integer> map) {
            Integer num = map.get(k7);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = f(k7).isInterface();
            Iterator<? extends K> it = e(k7).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, b(it.next(), map));
            }
            K kG = g(k7);
            int iMax2 = iMax;
            if (kG != null) {
                iMax2 = Math.max(iMax, b(kG, map));
            }
            int i7 = iMax2 + 1;
            map.put(k7, Integer.valueOf(i7));
            return i7;
        }

        private static <K, V> d7<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (d7<K>) new d(comparator, map).l(map.keySet());
        }

        final i<K> a() {
            return new c(this);
        }

        d7<K> c(Iterable<? extends K> iterable) {
            HashMap mapI0 = wb.i0();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), mapI0);
            }
            return h(mapI0, td.A().F());
        }

        final d7<K> d(K k7) {
            return c(d7.z(k7));
        }

        abstract Iterable<? extends K> e(K k7);

        abstract Class<?> f(K k7);

        abstract K g(K k7);

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class j implements g0<m<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f22493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f22494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ j[] f22495c;

        static enum a extends j {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.base.g0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(m<?> mVar) {
                return ((((m) mVar).f22468a instanceof TypeVariable) || (((m) mVar).f22468a instanceof WildcardType)) ? false : true;
            }
        }

        static enum b extends j {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.base.g0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(m<?> mVar) {
                return mVar.x().isInterface();
            }
        }

        static {
            a aVar = new a("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0);
            f22493a = aVar;
            b bVar = new b("INTERFACE_ONLY", 1);
            f22494b = bVar;
            f22495c = new j[]{aVar, bVar};
        }

        private j(String str, int i7) {
            super(str, i7);
        }

        public static j valueOf(String str) {
            return (j) Enum.valueOf(j.class, str);
        }

        public static j[] values() {
            return (j[]) f22495c.clone();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        /* synthetic */ j(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    public class k extends d6<m<? super T>> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f22496c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient u8<m<? super T>> f22497a;

        k() {
        }

        public m<T>.k A0() {
            return new g(this);
        }

        public Set<Class<? super T>> B0() {
            return u8.p(i.f22488b.c(m.this.y()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<m<? super T>> c0() {
            u8<m<? super T>> u8Var = this.f22497a;
            if (u8Var != null) {
                return u8Var;
            }
            u8<m<? super T>> u8VarM = h5.v(i.f22487a.d(m.this)).p(j.f22493a).M();
            this.f22497a = u8VarM;
            return u8VarM;
        }

        public m<T>.k z0() {
            return new f(m.this, null);
        }
    }

    /* synthetic */ m(Type type, a aVar) {
        this(type);
    }

    private m<? extends T> A(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (m<? extends T>) W(typeArr[0]).z(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private m<? super T> C(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            m<?> mVarW = W(type);
            if (mVarW.L(cls)) {
                return (m<? super T>) mVarW.B(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean F(Type type, TypeVariable<?> typeVariable) {
        if (this.f22468a.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return l(this.f22468a).equals(l(type));
        }
        WildcardType wildcardTypeJ = j(typeVariable, (WildcardType) type);
        return n(wildcardTypeJ.getUpperBounds()).b(this.f22468a) && n(wildcardTypeJ.getLowerBounds()).a(this.f22468a);
    }

    private boolean I(Type type) {
        Iterator<m<? super T>> it = E().iterator();
        while (it.hasNext()) {
            Type typeW = it.next().w();
            if (typeW != null && W(typeW).L(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean M(GenericArrayType genericArrayType) {
        Type type = this.f22468a;
        if (!(type instanceof Class)) {
            if (type instanceof GenericArrayType) {
                return W(((GenericArrayType) type).getGenericComponentType()).L(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            return V(cls.getComponentType()).L(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean N(ParameterizedType parameterizedType) {
        Class<? super Object> clsX = W(parameterizedType).x();
        if (!b0(clsX)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = clsX.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i7 = 0; i7 < typeParameters.length; i7++) {
            if (!W(r().j(typeParameters[i7])).F(actualTypeArguments[i7], typeParameters[i7])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || I(parameterizedType.getOwnerType());
    }

    private boolean R(GenericArrayType genericArrayType) {
        Type type = this.f22468a;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : W(genericArrayType.getGenericComponentType()).L(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return W(genericArrayType.getGenericComponentType()).L(((GenericArrayType) this.f22468a).getGenericComponentType());
        }
        return false;
    }

    private boolean S() {
        return com.google.common.primitives.f0.c().contains(this.f22468a);
    }

    private static Type U(Type type) {
        return o.e.f22510b.b(type);
    }

    public static <T> m<T> V(Class<T> cls) {
        return new h(cls);
    }

    public static m<?> W(Type type) {
        return new h(type);
    }

    private m<?> Y(Type type) {
        m<?> mVarW = W(r().j(type));
        mVarW.f22470c = this.f22470c;
        mVarW.f22469b = this.f22469b;
        return mVarW;
    }

    private Type a0(Class<?> cls) {
        if ((this.f22468a instanceof Class) && (cls.getTypeParameters().length == 0 || x().getTypeParameters().length != 0)) {
            return cls;
        }
        m mVarC0 = c0(cls);
        return new com.google.common.reflect.k().n(mVarC0.B(x()).f22468a, this.f22468a).j(mVarC0.f22468a);
    }

    private boolean b0(Class<?> cls) {
        ck<Class<? super T>> it = y().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @s1.d
    static <T> m<? extends T> c0(Class<T> cls) {
        if (cls.isArray()) {
            return (m<? extends T>) W(o.k(c0(cls.getComponentType()).f22468a));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : c0(cls.getEnclosingClass()).f22468a;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (m<? extends T>) W(o.n(type, cls, typeParameters)) : V(cls);
    }

    private static e f(Type[] typeArr) {
        return new e(typeArr, true);
    }

    private m<? super T> g(Type type) {
        m<? super T> mVar = (m<? super T>) W(type);
        if (mVar.x().isInterface()) {
            return null;
        }
        return mVar;
    }

    private d7<m<? super T>> h(Type[] typeArr) {
        d7.b bVarM = d7.m();
        for (Type type : typeArr) {
            m<?> mVarW = W(type);
            if (mVarW.x().isInterface()) {
                bVarM.a(mVarW);
            }
        }
        return bVarM.e();
    }

    private static Type i(TypeVariable<?> typeVariable, Type type) {
        return type instanceof WildcardType ? j(typeVariable, (WildcardType) type) : l(type);
    }

    private static WildcardType j(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!f(bounds).a(type)) {
                arrayList.add(l(type));
            }
        }
        return new o.j(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType k(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i7 = 0; i7 < actualTypeArguments.length; i7++) {
            actualTypeArguments[i7] = i(typeParameters[i7], actualTypeArguments[i7]);
        }
        return o.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type l(Type type) {
        if (type instanceof ParameterizedType) {
            return k((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? o.k(l(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e n(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private m<? extends T> o(Class<?> cls) {
        return (m<? extends T>) W(U(q().z(cls.getComponentType()).f22468a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m<? super T> p(Class<? super T> cls) {
        return (m<? super T>) W(U(((m) e0.Z(q(), "%s isn't a super type of %s", cls, this)).B(cls.getComponentType()).f22468a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.k r() {
        com.google.common.reflect.k kVar = this.f22470c;
        if (kVar != null) {
            return kVar;
        }
        com.google.common.reflect.k kVarD = com.google.common.reflect.k.d(this.f22468a);
        this.f22470c = kVarD;
        return kVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.k v() {
        com.google.common.reflect.k kVar = this.f22469b;
        if (kVar != null) {
            return kVar;
        }
        com.google.common.reflect.k kVarF = com.google.common.reflect.k.f(this.f22468a);
        this.f22469b = kVarF;
        return kVarF;
    }

    private Type w() {
        Type type = this.f22468a;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u8<Class<? super T>> y() {
        u8.a aVarK = u8.k();
        new d(aVarK).a(this.f22468a);
        return aVarK.e();
    }

    public final m<? super T> B(Class<? super T> cls) {
        e0.y(b0(cls), "%s is not a super class of %s", cls, this);
        Type type = this.f22468a;
        if (type instanceof TypeVariable) {
            return C(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return C(cls, ((WildcardType) type).getUpperBounds());
        }
        return cls.isArray() ? p(cls) : (m<? super T>) Y(c0(cls).f22468a);
    }

    public final Type D() {
        return this.f22468a;
    }

    public final m<T>.k E() {
        return new k();
    }

    public final boolean H() {
        return q() != null;
    }

    public final boolean J() {
        Type type = this.f22468a;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean K(m<?> mVar) {
        return L(mVar.D());
    }

    public final boolean L(Type type) {
        e0.E(type);
        if (type instanceof WildcardType) {
            return f(((WildcardType) type).getLowerBounds()).b(this.f22468a);
        }
        Type type2 = this.f22468a;
        if (type2 instanceof WildcardType) {
            return f(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || f(((TypeVariable) this.f22468a).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return W(type).R((GenericArrayType) this.f22468a);
        }
        if (type instanceof Class) {
            return b0((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return N((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return M((GenericArrayType) type);
        }
        return false;
    }

    public final boolean O(m<?> mVar) {
        return mVar.L(D());
    }

    public final boolean P(Type type) {
        return W(type).L(D());
    }

    public final com.google.common.reflect.e<T, Object> T(Method method) {
        e0.y(b0(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    @u1.a
    final m<T> X() {
        new c().a(this.f22468a);
        return this;
    }

    public final m<?> Z(Type type) {
        e0.E(type);
        return W(v().j(type));
    }

    public final m<T> d0() {
        return S() ? V(com.google.common.primitives.f0.e((Class) this.f22468a)) : this;
    }

    public final <X> m<T> e0(com.google.common.reflect.j<X> jVar, m<X> mVar) {
        return new h(new com.google.common.reflect.k().o(v7.z(new com.google.common.reflect.k.d(jVar.f22453a), mVar.f22468a)).j(this.f22468a));
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f22468a.equals(((m) obj).f22468a);
        }
        return false;
    }

    public final <X> m<T> f0(com.google.common.reflect.j<X> jVar, Class<X> cls) {
        return e0(jVar, V(cls));
    }

    public final m<T> g0() {
        return J() ? V(com.google.common.primitives.f0.f((Class) this.f22468a)) : this;
    }

    public int hashCode() {
        return this.f22468a.hashCode();
    }

    public final com.google.common.reflect.e<T, T> m(Constructor<?> constructor) {
        e0.y(constructor.getDeclaringClass() == x(), "%s not declared by %s", constructor, x());
        return new b(constructor);
    }

    public final m<?> q() {
        Type typeJ = o.j(this.f22468a);
        if (typeJ == null) {
            return null;
        }
        return W(typeJ);
    }

    final d7<m<? super T>> t() {
        Type type = this.f22468a;
        if (type instanceof TypeVariable) {
            return h(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds());
        }
        d7.b bVarM = d7.m();
        for (Type type2 : x().getGenericInterfaces()) {
            bVarM.a(Y(type2));
        }
        return bVarM.e();
    }

    public String toString() {
        return o.t(this.f22468a);
    }

    final m<? super T> u() {
        Type type = this.f22468a;
        if (type instanceof TypeVariable) {
            return g(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return g(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = x().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (m<? super T>) Y(genericSuperclass);
    }

    protected Object writeReplace() {
        return W(new com.google.common.reflect.k().j(this.f22468a));
    }

    public final Class<? super T> x() {
        return y().iterator().next();
    }

    public final m<? extends T> z(Class<?> cls) {
        e0.u(!(this.f22468a instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.f22468a;
        if (type instanceof WildcardType) {
            return A(cls, ((WildcardType) type).getLowerBounds());
        }
        if (H()) {
            return o(cls);
        }
        e0.y(x().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        m<? extends T> mVar = (m<? extends T>) W(a0(cls));
        e0.y(mVar.K(this), "%s does not appear to be a subtype of %s", mVar, this);
        return mVar;
    }

    protected m() {
        Type typeA = a();
        this.f22468a = typeA;
        e0.x0(!(typeA instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeA);
    }

    protected m(Class<?> cls) {
        Type typeA = super.a();
        if (typeA instanceof Class) {
            this.f22468a = typeA;
        } else {
            this.f22468a = com.google.common.reflect.k.d(cls).j(typeA);
        }
    }

    private m(Type type) {
        this.f22468a = (Type) e0.E(type);
    }
}
