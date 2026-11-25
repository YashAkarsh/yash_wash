package com.google.android.gms.common.api.internal;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class k0 extends com.google.android.gms.common.api.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f15316e = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";

    public k0(String str) {
    }

    @Override // com.google.android.gms.common.api.k
    public final void A() {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void B(@c.m0 com.google.android.gms.common.api.k.b bVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void C(@c.m0 com.google.android.gms.common.api.k.c cVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void E(@c.m0 FragmentActivity fragmentActivity) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void F(@c.m0 com.google.android.gms.common.api.k.b bVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void G(@c.m0 com.google.android.gms.common.api.k.c cVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final ConnectionResult d() {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final ConnectionResult e(long j7, @c.m0 TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final com.google.android.gms.common.api.n<Status> f() {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void g() {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void i() {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    @c.m0
    public final ConnectionResult p(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean t(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean u() {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean v() {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean w(@c.m0 com.google.android.gms.common.api.k.b bVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean x(@c.m0 com.google.android.gms.common.api.k.c cVar) {
        throw new UnsupportedOperationException(this.f15316e);
    }
}
