package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f8669b = "MediaSessionManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final boolean f8670c = Log.isLoggable(f8669b, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f8671d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile j f8672e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f8673a;

    interface a {
        boolean a(c cVar);

        Context d();
    }

    interface c {
        String J();

        int a();

        int b();
    }

    private j(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f8673a = new t(context);
        } else {
            this.f8673a = new k(context);
        }
    }

    @m0
    public static j b(@m0 Context context) {
        j jVar = f8672e;
        if (jVar == null) {
            synchronized (f8671d) {
                jVar = f8672e;
                if (jVar == null) {
                    f8672e = new j(context.getApplicationContext());
                    jVar = f8672e;
                }
            }
        }
        return jVar;
    }

    Context a() {
        return this.f8673a.d();
    }

    public boolean c(@m0 b bVar) {
        if (bVar != null) {
            return this.f8673a.a(bVar.f8675a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f8674b = "android.media.session.MediaController";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f8675a;

        public b(@m0 String str, int i7, int i8) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f8675a = new t.a(str, i7, i8);
            } else {
                this.f8675a = new u.a(str, i7, i8);
            }
        }

        @m0
        public String a() {
            return this.f8675a.J();
        }

        public int b() {
            return this.f8675a.b();
        }

        public int c() {
            return this.f8675a.a();
        }

        public boolean equals(@o0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f8675a.equals(((b) obj).f8675a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8675a.hashCode();
        }

        @t0(28)
        @x0({x0.a.LIBRARY_GROUP})
        public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f8675a = new t.a(remoteUserInfo);
        }
    }
}
