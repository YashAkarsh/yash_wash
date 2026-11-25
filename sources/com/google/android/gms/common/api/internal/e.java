package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class e {

    @c1.a
    public interface b<R> {
        @c1.a
        void a(@c.m0 Status status);

        @c1.a
        void b(@c.m0 R r7);
    }

    @c1.a
    public static abstract class a<R extends com.google.android.gms.common.api.t, A extends com.google.android.gms.common.api.a.b> extends BasePendingResult<R> implements b<R> {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @c1.a
        private final com.google.android.gms.common.api.a.c<A> f15187r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @c.o0
        @c1.a
        private final com.google.android.gms.common.api.a<?> f15188s;

        @c1.a
        @Deprecated
        protected a(@c.m0 com.google.android.gms.common.api.a.c<A> cVar, @c.m0 com.google.android.gms.common.api.k kVar) {
            super((com.google.android.gms.common.api.k) com.google.android.gms.common.internal.u.l(kVar, "GoogleApiClient must not be null"));
            this.f15187r = (com.google.android.gms.common.api.a.c) com.google.android.gms.common.internal.u.k(cVar);
            this.f15188s = null;
        }

        @c1.a
        private void B(@c.m0 RemoteException remoteException) {
            a(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        @c1.a
        public final void A(@c.m0 A a8) throws DeadObjectException {
            try {
                w(a8);
            } catch (DeadObjectException e8) {
                B(e8);
                throw e8;
            } catch (RemoteException e9) {
                B(e9);
            }
        }

        @Override // com.google.android.gms.common.api.internal.e.b
        @c1.a
        public final void a(@c.m0 Status status) {
            com.google.android.gms.common.internal.u.b(!status.G0(), "Failed result must not be success");
            R rK = k(status);
            o(rK);
            z(rK);
        }

        @Override // com.google.android.gms.common.api.internal.e.b
        @c1.a
        public /* bridge */ /* synthetic */ void b(@c.m0 Object obj) {
            super.o((com.google.android.gms.common.api.t) obj);
        }

        @c1.a
        protected abstract void w(@c.m0 A a8) throws RemoteException;

        @c.o0
        @c1.a
        public final com.google.android.gms.common.api.a<?> x() {
            return this.f15188s;
        }

        @c1.a
        @c.m0
        public final com.google.android.gms.common.api.a.c<A> y() {
            return this.f15187r;
        }

        @c1.a
        protected void z(@c.m0 R r7) {
        }

        @c1.a
        protected a(@c.m0 com.google.android.gms.common.api.a<?> aVar, @c.m0 com.google.android.gms.common.api.k kVar) {
            super((com.google.android.gms.common.api.k) com.google.android.gms.common.internal.u.l(kVar, "GoogleApiClient must not be null"));
            com.google.android.gms.common.internal.u.l(aVar, "Api must not be null");
            this.f15187r = (com.google.android.gms.common.api.a.c<A>) aVar.b();
            this.f15188s = aVar;
        }

        @c1.a
        @c.g1
        protected a(@c.m0 BasePendingResult.a<R> aVar) {
            super(aVar);
            this.f15187r = new com.google.android.gms.common.api.a.c<>();
            this.f15188s = null;
        }
    }
}
