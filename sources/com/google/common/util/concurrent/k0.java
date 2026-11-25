package com.google.common.util.concurrent;

import com.google.common.collect.d7;
import com.google.common.collect.ib;
import com.google.common.collect.x6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class k0<V, C> extends k<V, C> {

    abstract class a extends k<V, C>.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<com.google.common.base.a0<V>> f22799i;

        a(x6<? extends l1<? extends V>> x6Var, boolean z7) {
            super(x6Var, z7, true);
            this.f22799i = x6Var.isEmpty() ? d7.x() : ib.u(x6Var.size());
            for (int i7 = 0; i7 < x6Var.size(); i7++) {
                this.f22799i.add(null);
            }
        }

        @Override // com.google.common.util.concurrent.k.a
        final void l(boolean z7, int i7, V v7) {
            List<com.google.common.base.a0<V>> list = this.f22799i;
            if (list != null) {
                list.set(i7, com.google.common.base.a0.d(v7));
            } else {
                com.google.common.base.e0.h0(z7 || k0.this.isCancelled(), "Future was done before all dependencies completed");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.k.a
        final void n() {
            List<com.google.common.base.a0<V>> list = this.f22799i;
            if (list != null) {
                k0.this.A(u(list));
            } else {
                com.google.common.base.e0.g0(k0.this.isDone());
            }
        }

        @Override // com.google.common.util.concurrent.k.a
        void t() {
            super.t();
            this.f22799i = null;
        }

        abstract C u(List<com.google.common.base.a0<V>> list);
    }

    static final class b<V> extends k0<V, List<V>> {

        private final class a extends k0<V, List<V>>.a {
            a(x6<? extends l1<? extends V>> x6Var, boolean z7) {
                super(x6Var, z7);
            }

            @Override // com.google.common.util.concurrent.k0.a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public List<V> u(List<com.google.common.base.a0<V>> list) {
                ArrayList arrayListU = ib.u(list.size());
                Iterator<com.google.common.base.a0<V>> it = list.iterator();
                while (it.hasNext()) {
                    com.google.common.base.a0<V> next = it.next();
                    arrayListU.add(next != null ? next.k() : null);
                }
                return Collections.unmodifiableList(arrayListU);
            }
        }

        b(x6<? extends l1<? extends V>> x6Var, boolean z7) {
            L(new a(x6Var, z7));
        }
    }

    k0() {
    }
}
