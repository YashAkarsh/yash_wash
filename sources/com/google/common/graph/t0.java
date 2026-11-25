package com.google.common.graph;

import com.google.common.collect.ck;
import com.google.common.collect.ma;
import com.google.common.collect.u8;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class t0<N> {

    private static final class b<N> extends t0<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final s0<N> f21686a;

        class a implements Iterable<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterable f21687a;

            a(Iterable iterable) {
                this.f21687a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new d(this.f21687a);
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.t0$b$b, reason: collision with other inner class name */
        class C0276b implements Iterable<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterable f21689a;

            C0276b(Iterable iterable) {
                this.f21689a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new e(this.f21689a, c.PREORDER);
            }
        }

        class c implements Iterable<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterable f21691a;

            c(Iterable iterable) {
                this.f21691a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new e(this.f21691a, c.POSTORDER);
            }
        }

        private final class d extends ck<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Queue<N> f21693a = new ArrayDeque();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Set<N> f21694b = new HashSet();

            d(Iterable<? extends N> iterable) {
                for (N n7 : iterable) {
                    if (this.f21694b.add(n7)) {
                        this.f21693a.add(n7);
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.f21693a.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N nRemove = this.f21693a.remove();
                for (N n7 : b.this.f21686a.b(nRemove)) {
                    if (this.f21694b.add(n7)) {
                        this.f21693a.add(n7);
                    }
                }
                return nRemove;
            }
        }

        private final class e extends com.google.common.collect.e<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Deque<b<N>.e.a> f21696c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Set<N> f21697d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final c f21698e;

            private final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final N f21700a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final Iterator<? extends N> f21701b;

                a(N n7, Iterable<? extends N> iterable) {
                    this.f21700a = n7;
                    this.f21701b = iterable.iterator();
                }
            }

            e(Iterable<? extends N> iterable, c cVar) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.f21696c = arrayDeque;
                this.f21697d = new HashSet();
                arrayDeque.push(new a(null, iterable));
                this.f21698e = cVar;
            }

            @Override // com.google.common.collect.e
            protected N a() {
                N n7;
                while (!this.f21696c.isEmpty()) {
                    b<N>.e.a first = this.f21696c.getFirst();
                    boolean zAdd = this.f21697d.add(first.f21700a);
                    boolean z7 = true;
                    boolean z8 = !first.f21701b.hasNext();
                    if ((!zAdd || this.f21698e != c.PREORDER) && (!z8 || this.f21698e != c.POSTORDER)) {
                        z7 = false;
                    }
                    if (z8) {
                        this.f21696c.pop();
                    } else {
                        N next = first.f21701b.next();
                        if (!this.f21697d.contains(next)) {
                            this.f21696c.push(d(next));
                        }
                    }
                    if (z7 && (n7 = first.f21700a) != null) {
                        return n7;
                    }
                }
                return (N) b();
            }

            b<N>.e.a d(N n7) {
                return new a(n7, b.this.f21686a.b(n7));
            }
        }

        b(s0<N> s0Var) {
            super();
            this.f21686a = (s0) com.google.common.base.e0.E(s0Var);
        }

        private void j(N n7) {
            this.f21686a.b(n7);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> a(Iterable<? extends N> iterable) {
            com.google.common.base.e0.E(iterable);
            if (ma.C(iterable)) {
                return u8.A();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return new a(iterable);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> b(N n7) {
            com.google.common.base.e0.E(n7);
            return a(u8.B(n7));
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> c(Iterable<? extends N> iterable) {
            com.google.common.base.e0.E(iterable);
            if (ma.C(iterable)) {
                return u8.A();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return new c(iterable);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> d(N n7) {
            com.google.common.base.e0.E(n7);
            return c(u8.B(n7));
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> e(Iterable<? extends N> iterable) {
            com.google.common.base.e0.E(iterable);
            if (ma.C(iterable)) {
                return u8.A();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return new C0276b(iterable);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> f(N n7) {
            com.google.common.base.e0.E(n7);
            return e(u8.B(n7));
        }
    }

    private enum c {
        PREORDER,
        POSTORDER
    }

    private static final class d<N> extends t0<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final s0<N> f21706a;

        class a implements Iterable<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterable f21707a;

            a(Iterable iterable) {
                this.f21707a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new C0277d(this.f21707a);
            }
        }

        class b implements Iterable<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterable f21709a;

            b(Iterable iterable) {
                this.f21709a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new f(this.f21709a);
            }
        }

        class c implements Iterable<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterable f21711a;

            c(Iterable iterable) {
                this.f21711a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new e(this.f21711a);
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.t0$d$d, reason: collision with other inner class name */
        private final class C0277d extends ck<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Queue<N> f21713a = new ArrayDeque();

            C0277d(Iterable<? extends N> iterable) {
                Iterator<? extends N> it = iterable.iterator();
                while (it.hasNext()) {
                    this.f21713a.add(it.next());
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.f21713a.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N nRemove = this.f21713a.remove();
                ma.a(this.f21713a, d.this.f21706a.b(nRemove));
                return nRemove;
            }
        }

        private final class e extends com.google.common.collect.e<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final ArrayDeque<d<N>.e.a> f21715c;

            private final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final N f21717a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final Iterator<? extends N> f21718b;

                a(N n7, Iterable<? extends N> iterable) {
                    this.f21717a = n7;
                    this.f21718b = iterable.iterator();
                }
            }

            e(Iterable<? extends N> iterable) {
                ArrayDeque<d<N>.e.a> arrayDeque = new ArrayDeque<>();
                this.f21715c = arrayDeque;
                arrayDeque.addLast(new a(null, iterable));
            }

            @Override // com.google.common.collect.e
            protected N a() {
                while (!this.f21715c.isEmpty()) {
                    d<N>.e.a last = this.f21715c.getLast();
                    if (last.f21718b.hasNext()) {
                        this.f21715c.addLast(d(last.f21718b.next()));
                    } else {
                        this.f21715c.removeLast();
                        N n7 = last.f21717a;
                        if (n7 != null) {
                            return n7;
                        }
                    }
                }
                return (N) b();
            }

            d<N>.e.a d(N n7) {
                return new a(n7, d.this.f21706a.b(n7));
            }
        }

        private final class f extends ck<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Deque<Iterator<? extends N>> f21720a;

            f(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.f21720a = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.f21720a.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                Iterator<? extends N> last = this.f21720a.getLast();
                N n7 = (N) com.google.common.base.e0.E(last.next());
                if (!last.hasNext()) {
                    this.f21720a.removeLast();
                }
                Iterator<? extends N> it = d.this.f21706a.b(n7).iterator();
                if (it.hasNext()) {
                    this.f21720a.addLast(it);
                }
                return n7;
            }
        }

        d(s0<N> s0Var) {
            super();
            this.f21706a = (s0) com.google.common.base.e0.E(s0Var);
        }

        private void j(N n7) {
            this.f21706a.b(n7);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> a(Iterable<? extends N> iterable) {
            com.google.common.base.e0.E(iterable);
            if (ma.C(iterable)) {
                return u8.A();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return new a(iterable);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> b(N n7) {
            com.google.common.base.e0.E(n7);
            return a(u8.B(n7));
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> c(Iterable<? extends N> iterable) {
            com.google.common.base.e0.E(iterable);
            if (ma.C(iterable)) {
                return u8.A();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return new c(iterable);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> d(N n7) {
            com.google.common.base.e0.E(n7);
            return c(u8.B(n7));
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> e(Iterable<? extends N> iterable) {
            com.google.common.base.e0.E(iterable);
            if (ma.C(iterable)) {
                return u8.A();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return new b(iterable);
        }

        @Override // com.google.common.graph.t0
        public Iterable<N> f(N n7) {
            com.google.common.base.e0.E(n7);
            return e(u8.B(n7));
        }
    }

    public static <N> t0<N> g(s0<N> s0Var) {
        com.google.common.base.e0.E(s0Var);
        return new b(s0Var);
    }

    public static <N> t0<N> h(s0<N> s0Var) {
        com.google.common.base.e0.E(s0Var);
        if (s0Var instanceof i) {
            com.google.common.base.e0.e(((i) s0Var).f(), "Undirected graphs can never be trees.");
        }
        if (s0Var instanceof o0) {
            com.google.common.base.e0.e(((o0) s0Var).f(), "Undirected networks can never be trees.");
        }
        return new d(s0Var);
    }

    public abstract Iterable<N> a(Iterable<? extends N> iterable);

    public abstract Iterable<N> b(N n7);

    public abstract Iterable<N> c(Iterable<? extends N> iterable);

    public abstract Iterable<N> d(N n7);

    public abstract Iterable<N> e(Iterable<? extends N> iterable);

    public abstract Iterable<N> f(N n7);

    private t0() {
    }
}
