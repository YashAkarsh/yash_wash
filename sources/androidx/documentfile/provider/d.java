package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f7316d;

    d(@o0 a aVar, Context context, Uri uri) {
        super(aVar);
        this.f7315c = context;
        this.f7316d = uri;
    }

    @Override // androidx.documentfile.provider.a
    public boolean a() {
        return b.a(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public boolean b() {
        return b.b(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public a c(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.a
    public a d(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.a
    public boolean e() {
        try {
            return DocumentsContract.deleteDocument(this.f7315c.getContentResolver(), this.f7316d);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.a
    public boolean f() {
        return b.d(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public String k() {
        return b.f(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public String m() {
        return b.h(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public Uri n() {
        return this.f7316d;
    }

    @Override // androidx.documentfile.provider.a
    public boolean o() {
        return b.i(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public boolean q() {
        return b.j(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public boolean r() {
        return b.k(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public long s() {
        return b.l(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public long t() {
        return b.m(this.f7315c, this.f7316d);
    }

    @Override // androidx.documentfile.provider.a
    public a[] u() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.a
    public boolean v(String str) {
        throw new UnsupportedOperationException();
    }
}
