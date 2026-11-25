package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f6623a;

    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final Uri f6625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private final ClipDescription f6626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        private final Uri f6627c;

        b(@m0 Uri uri, @m0 ClipDescription clipDescription, @o0 Uri uri2) {
            this.f6625a = uri;
            this.f6626b = clipDescription;
            this.f6627c = uri2;
        }

        @Override // androidx.core.view.inputmethod.s.c
        @o0
        public Uri a() {
            return this.f6627c;
        }

        @Override // androidx.core.view.inputmethod.s.c
        @m0
        public ClipDescription b() {
            return this.f6626b;
        }

        @Override // androidx.core.view.inputmethod.s.c
        @m0
        public Uri c() {
            return this.f6625a;
        }

        @Override // androidx.core.view.inputmethod.s.c
        public void d() {
        }

        @Override // androidx.core.view.inputmethod.s.c
        @o0
        public Object e() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.s.c
        public void f() {
        }
    }

    private interface c {
        @o0
        Uri a();

        @m0
        ClipDescription b();

        @m0
        Uri c();

        void d();

        @o0
        Object e();

        void f();
    }

    public s(@m0 Uri uri, @m0 ClipDescription clipDescription, @o0 Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f6623a = new a(uri, clipDescription, uri2);
        } else {
            this.f6623a = new b(uri, clipDescription, uri2);
        }
    }

    @o0
    public static s g(@o0 Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new s(new a(obj));
        }
        return null;
    }

    @m0
    public Uri a() {
        return this.f6623a.c();
    }

    @m0
    public ClipDescription b() {
        return this.f6623a.b();
    }

    @o0
    public Uri c() {
        return this.f6623a.a();
    }

    public void d() {
        this.f6623a.f();
    }

    public void e() {
        this.f6623a.d();
    }

    @o0
    public Object f() {
        return this.f6623a.e();
    }

    @t0(25)
    private static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        final InputContentInfo f6624a;

        a(@m0 Object obj) {
            this.f6624a = h.a(obj);
        }

        @Override // androidx.core.view.inputmethod.s.c
        @o0
        public Uri a() {
            return this.f6624a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.s.c
        @m0
        public ClipDescription b() {
            return this.f6624a.getDescription();
        }

        @Override // androidx.core.view.inputmethod.s.c
        @m0
        public Uri c() {
            return this.f6624a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.s.c
        public void d() {
            this.f6624a.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.s.c
        @m0
        public Object e() {
            return this.f6624a;
        }

        @Override // androidx.core.view.inputmethod.s.c
        public void f() {
            this.f6624a.releasePermission();
        }

        a(@m0 Uri uri, @m0 ClipDescription clipDescription, @o0 Uri uri2) {
            r.a();
            this.f6624a = q.a(uri, clipDescription, uri2);
        }
    }

    private s(@m0 c cVar) {
        this.f6623a = cVar;
    }
}
