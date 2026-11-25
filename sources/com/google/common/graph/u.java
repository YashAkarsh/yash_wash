package com.google.common.graph;

import com.google.common.collect.af;
import com.google.common.collect.u8;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class u<N> extends com.google.common.collect.e<t<N>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i<N> f21722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Iterator<N> f21723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected N f21724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Iterator<N> f21725f;

    private static final class b<N> extends u<N> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public t<N> a() {
            while (!this.f21725f.hasNext()) {
                if (!d()) {
                    return b();
                }
            }
            return t.k(this.f21724e, this.f21725f.next());
        }

        private b(i<N> iVar) {
            super(iVar);
        }
    }

    private static final class c<N> extends u<N> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Set<N> f21726g;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public t<N> a() {
            while (true) {
                if (this.f21725f.hasNext()) {
                    N next = this.f21725f.next();
                    if (!this.f21726g.contains(next)) {
                        return t.n(this.f21724e, next);
                    }
                } else {
                    this.f21726g.add(this.f21724e);
                    if (!d()) {
                        this.f21726g = null;
                        return b();
                    }
                }
            }
        }

        private c(i<N> iVar) {
            super(iVar);
            this.f21726g = af.y(iVar.l().size());
        }
    }

    static <N> u<N> e(i<N> iVar) {
        return iVar.f() ? new b(iVar) : new c(iVar);
    }

    protected final boolean d() {
        com.google.common.base.e0.g0(!this.f21725f.hasNext());
        if (!this.f21723d.hasNext()) {
            return false;
        }
        N next = this.f21723d.next();
        this.f21724e = next;
        this.f21725f = this.f21722c.b((Object) next).iterator();
        return true;
    }

    private u(i<N> iVar) {
        this.f21724e = null;
        this.f21725f = u8.A().iterator();
        this.f21722c = iVar;
        this.f21723d = iVar.l().iterator();
    }
}
