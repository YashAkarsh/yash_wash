package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@s1.a
@s1.b
public abstract class bk<T> {

    static class a extends bk<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.s f19965a;

        a(com.google.common.base.s sVar) {
            this.f19965a = sVar;
        }

        @Override // com.google.common.collect.bk
        public Iterable<T> b(T t7) {
            return (Iterable) this.f19965a.apply(t7);
        }
    }

    class b extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f19966b;

        class a implements Consumer<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Consumer f19968a;

            a(Consumer consumer) {
                this.f19968a = consumer;
            }

            @Override // java.util.function.Consumer
            public void accept(T t7) {
                this.f19968a.accept(t7);
                bk.this.b(t7).forEach(this);
            }
        }

        b(Object obj) {
            this.f19966b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public ck<T> iterator() {
            return bk.this.e(this.f19966b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> consumer) {
            com.google.common.base.e0.E(consumer);
            new a(consumer).accept(this.f19966b);
        }
    }

    class c extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f19970b;

        class a implements Consumer<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Consumer f19972a;

            a(Consumer consumer) {
                this.f19972a = consumer;
            }

            @Override // java.util.function.Consumer
            public void accept(T t7) {
                bk.this.b(t7).forEach(this);
                this.f19972a.accept(t7);
            }
        }

        c(Object obj) {
            this.f19970b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public ck<T> iterator() {
            return bk.this.c(this.f19970b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> consumer) {
            com.google.common.base.e0.E(consumer);
            new a(consumer).accept(this.f19970b);
        }
    }

    class d extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f19974b;

        d(Object obj) {
            this.f19974b = obj;
        }

        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public ck<T> iterator() {
            return new e(this.f19974b);
        }
    }

    private final class e extends ck<T> implements ud<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<T> f19976a;

        e(T t7) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f19976a = arrayDeque;
            arrayDeque.add(t7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f19976a.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.ud
        public T next() {
            T tRemove = this.f19976a.remove();
            ma.a(this.f19976a, bk.this.b(tRemove));
            return tRemove;
        }

        @Override // com.google.common.collect.ud
        public T peek() {
            return this.f19976a.element();
        }
    }

    private final class f extends com.google.common.collect.e<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayDeque<g<T>> f19978c;

        f(T t7) {
            ArrayDeque<g<T>> arrayDeque = new ArrayDeque<>();
            this.f19978c = arrayDeque;
            arrayDeque.addLast(d(t7));
        }

        private g<T> d(T t7) {
            return new g<>(t7, bk.this.b(t7).iterator());
        }

        @Override // com.google.common.collect.e
        protected T a() {
            while (!this.f19978c.isEmpty()) {
                g<T> last = this.f19978c.getLast();
                if (!last.f19981b.hasNext()) {
                    this.f19978c.removeLast();
                    return last.f19980a;
                }
                this.f19978c.addLast(d(last.f19981b.next()));
            }
            return b();
        }
    }

    private static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T f19980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator<T> f19981b;

        g(T t7, Iterator<T> it) {
            this.f19980a = (T) com.google.common.base.e0.E(t7);
            this.f19981b = (Iterator) com.google.common.base.e0.E(it);
        }
    }

    private final class h extends ck<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Deque<Iterator<T>> f19982a;

        h(T t7) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f19982a = arrayDeque;
            arrayDeque.addLast(ua.Y(com.google.common.base.e0.E(t7)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f19982a.isEmpty();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.f19982a.getLast();
            T t7 = (T) com.google.common.base.e0.E(last.next());
            if (!last.hasNext()) {
                this.f19982a.removeLast();
            }
            Iterator<T> it = bk.this.b(t7).iterator();
            if (it.hasNext()) {
                this.f19982a.addLast(it);
            }
            return t7;
        }
    }

    @Deprecated
    public static <T> bk<T> g(com.google.common.base.s<T, ? extends Iterable<T>> sVar) {
        com.google.common.base.e0.E(sVar);
        return new a(sVar);
    }

    @Deprecated
    public final h5<T> a(T t7) {
        com.google.common.base.e0.E(t7);
        return new d(t7);
    }

    public abstract Iterable<T> b(T t7);

    ck<T> c(T t7) {
        return new f(t7);
    }

    @Deprecated
    public final h5<T> d(T t7) {
        com.google.common.base.e0.E(t7);
        return new c(t7);
    }

    ck<T> e(T t7) {
        return new h(t7);
    }

    @Deprecated
    public final h5<T> f(T t7) {
        com.google.common.base.e0.E(t7);
        return new b(t7);
    }
}
