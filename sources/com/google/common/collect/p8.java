package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public abstract class p8<E> extends r8<E> implements hd<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @v1.b
    private transient d7<E> f20882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @v1.b
    private transient u8<hd.a<E>> f20883d;

    class a extends ck<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        E f20885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f20886c;

        a(Iterator it) {
            this.f20886c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20884a > 0 || this.f20886c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f20884a <= 0) {
                hd.a aVar = (hd.a) this.f20886c.next();
                this.f20885b = (E) aVar.getElement();
                this.f20884a = aVar.getCount();
            }
            this.f20884a--;
            return this.f20885b;
        }
    }

    public static class b<E> extends x6.a<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final hd<E> f20888b;

        public b() {
            this(eb.t());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void o(Object obj, int i7) {
            this.f20888b.add((E) com.google.common.base.e0.E(obj), i7);
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e8) {
            this.f20888b.add((E) com.google.common.base.e0.E(e8));
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b<E> b(E... eArr) {
            super.b(eArr);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public b<E> c(Iterable<? extends E> iterable) {
            if (iterable instanceof hd) {
                md.f(iterable).h0(new ObjIntConsumer() { // from class: com.google.common.collect.q8
                    @Override // java.util.function.ObjIntConsumer
                    public final void accept(Object obj, int i7) {
                        this.f20976a.o(obj, i7);
                    }
                });
            } else {
                super.c(iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b<E> d(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @u1.a
        public b<E> l(E e8, int i7) {
            this.f20888b.add((E) com.google.common.base.e0.E(e8), i7);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public p8<E> e() {
            return p8.t(this.f20888b);
        }

        @s1.d
        p8<E> n() {
            return this.f20888b.isEmpty() ? p8.I() : za.T(this.f20888b.entrySet());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @u1.a
        public b<E> p(E e8, int i7) {
            this.f20888b.setCount((E) com.google.common.base.e0.E(e8), i7);
            return this;
        }

        b(hd<E> hdVar) {
            this.f20888b = hdVar;
        }
    }

    static final class c<E> extends u8.b<E> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final List<hd.a<E>> f20889j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final hd<E> f20890k;

        c(List<hd.a<E>> list, hd<E> hdVar) {
            this.f20889j = list;
            this.f20890k = hdVar;
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f20890k.contains(obj);
        }

        @Override // com.google.common.collect.u8.b
        E get(int i7) {
            return this.f20889j.get(i7).getElement();
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f20889j.size();
        }
    }

    private final class d extends fa<hd.a<E>> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final long f20891k = 0;

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.fa
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public hd.a<E> get(int i7) {
            return p8.this.A(i7);
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof hd.a)) {
                return false;
            }
            hd.a aVar = (hd.a) obj;
            return aVar.getCount() > 0 && p8.this.l0(aVar.getElement()) == aVar.getCount();
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return p8.this.h();
        }

        @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
        public int hashCode() {
            return p8.this.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p8.this.e().size();
        }

        @Override // com.google.common.collect.u8, com.google.common.collect.x6
        @s1.c
        Object writeReplace() {
            return new e(p8.this);
        }

        /* synthetic */ d(p8 p8Var, a aVar) {
            this();
        }
    }

    @s1.c
    static class e<E> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final p8<E> f20893a;

        e(p8<E> p8Var) {
            this.f20893a = p8Var;
        }

        Object readResolve() {
            return this.f20893a.entrySet();
        }
    }

    static final class f implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20894c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f20895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int[] f20896b;

        f(hd<?> hdVar) {
            int size = hdVar.entrySet().size();
            this.f20895a = new Object[size];
            this.f20896b = new int[size];
            int i7 = 0;
            for (hd.a<?> aVar : hdVar.entrySet()) {
                this.f20895a[i7] = aVar.getElement();
                this.f20896b[i7] = aVar.getCount();
                i7++;
            }
        }

        Object readResolve() {
            eb ebVarU = eb.u(this.f20895a.length);
            int i7 = 0;
            while (true) {
                Object[] objArr = this.f20895a;
                if (i7 >= objArr.length) {
                    return p8.t(ebVarU);
                }
                ebVarU.add(objArr[i7], this.f20896b[i7]);
                i7++;
            }
        }
    }

    p8() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int B(Object obj) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void D(Function function, ToIntFunction toIntFunction, hd hdVar, Object obj) {
        hdVar.add(com.google.common.base.e0.E(function.apply(obj)), toIntFunction.applyAsInt(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ hd F(hd hdVar, hd hdVar2) {
        hdVar.addAll(hdVar2);
        return hdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p8 H(hd hdVar) {
        return r(hdVar.entrySet());
    }

    public static <E> p8<E> I() {
        return (p8<E>) je.f20494j;
    }

    public static <E> p8<E> J(E e8) {
        return p(e8);
    }

    public static <E> p8<E> K(E e8, E e9) {
        return p(e8, e9);
    }

    public static <E> p8<E> L(E e8, E e9, E e10) {
        return p(e8, e9, e10);
    }

    public static <E> p8<E> M(E e8, E e9, E e10, E e11) {
        return p(e8, e9, e10, e11);
    }

    public static <E> p8<E> N(E e8, E e9, E e10, E e11, E e12) {
        return p(e8, e9, e10, e11, e12);
    }

    public static <E> p8<E> O(E e8, E e9, E e10, E e11, E e12, E e13, E... eArr) {
        return new b().a(e8).a(e9).a(e10).a(e11).a(e12).a(e13).b(eArr).e();
    }

    @s1.a
    public static <E> Collector<E, ?, p8<E>> P() {
        return S(Function.identity(), new ToIntFunction() { // from class: com.google.common.collect.o8
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return p8.B(obj);
            }
        });
    }

    public static <T, E> Collector<T, ?, p8<E>> S(final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(toIntFunction);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.k8
            @Override // java.util.function.Supplier
            public final Object get() {
                return eb.t();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.l8
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                p8.D(function, toIntFunction, (hd) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.m8
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return p8.F((hd) obj, (hd) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.n8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return p8.H((hd) obj);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <E> b<E> o() {
        return new b<>();
    }

    private static <E> p8<E> p(E... eArr) {
        eb ebVarT = eb.t();
        Collections.addAll(ebVarT, eArr);
        return r(ebVarT.entrySet());
    }

    static <E> p8<E> r(Collection<? extends hd.a<? extends E>> collection) {
        return collection.isEmpty() ? I() : je.T(collection);
    }

    public static <E> p8<E> t(Iterable<? extends E> iterable) {
        if (iterable instanceof p8) {
            p8<E> p8Var = (p8) iterable;
            if (!p8Var.h()) {
                return p8Var;
            }
        }
        return r((iterable instanceof hd ? md.f(iterable) : eb.v(iterable)).entrySet());
    }

    public static <E> p8<E> u(Iterator<? extends E> it) {
        eb ebVarT = eb.t();
        ua.a(ebVarT, it);
        return r(ebVarT.entrySet());
    }

    public static <E> p8<E> v(E[] eArr) {
        return p(eArr);
    }

    private u8<hd.a<E>> w() {
        return isEmpty() ? u8.A() : new d(this, null);
    }

    abstract hd.a<E> A(int i7);

    @Override // com.google.common.collect.hd
    @u1.a
    @Deprecated
    public final boolean E(E e8, int i7, int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x6
    public d7<E> a() {
        d7<E> d7Var = this.f20882c;
        if (d7Var != null) {
            return d7Var;
        }
        d7<E> d7VarA = super.a();
        this.f20882c = d7VarA;
        return d7VarA;
    }

    @Override // com.google.common.collect.hd
    @u1.a
    @Deprecated
    public final int add(E e8, int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x6
    @s1.c
    int b(Object[] objArr, int i7) {
        ck<hd.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            hd.a<E> next = it.next();
            Arrays.fill(objArr, i7, next.getCount() + i7, next.getElement());
            i7 += next.getCount();
        }
        return i7;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return l0(obj) > 0;
    }

    @Override // java.util.Collection, com.google.common.collect.hd
    public boolean equals(Object obj) {
        return md.k(this, obj);
    }

    @Override // java.lang.Iterable, com.google.common.collect.hd
    public /* synthetic */ void forEach(Consumer consumer) {
        gd.a(this, consumer);
    }

    public /* synthetic */ void h0(ObjIntConsumer objIntConsumer) {
        gd.b(this, objIntConsumer);
    }

    @Override // java.util.Collection, com.google.common.collect.hd
    public int hashCode() {
        return af.k(entrySet());
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return new a(entrySet().iterator());
    }

    @Override // com.google.common.collect.hd
    @u1.a
    @Deprecated
    public final int remove(Object obj, int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.hd
    @u1.a
    @Deprecated
    public final int setCount(E e8, int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.hd
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.x6
    @s1.c
    Object writeReplace() {
        return new f(this);
    }

    @Override // com.google.common.collect.hd
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public abstract u8<E> e();

    @Override // com.google.common.collect.hd
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public u8<hd.a<E>> entrySet() {
        u8<hd.a<E>> u8Var = this.f20883d;
        if (u8Var != null) {
            return u8Var;
        }
        u8<hd.a<E>> u8VarW = w();
        this.f20883d = u8VarW;
        return u8VarW;
    }
}
