package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.q;
import androidx.lifecycle.q0;
import androidx.loader.content.c;
import c.j0;
import c.m0;
import c.o0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.loader.app.a$a, reason: collision with other inner class name */
    public interface InterfaceC0103a<D> {
        @j0
        void a(@m0 c<D> cVar, D d8);

        @m0
        @j0
        c<D> b(int i7, @o0 Bundle bundle);

        @j0
        void c(@m0 c<D> cVar);
    }

    public static void c(boolean z7) {
        b.f8372d = z7;
    }

    @m0
    public static <T extends q & q0> a d(@m0 T t7) {
        return new b(t7, t7.getViewModelStore());
    }

    @j0
    public abstract void a(int i7);

    @Deprecated
    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @o0
    public abstract <D> c<D> e(int i7);

    public boolean f() {
        return false;
    }

    @m0
    @j0
    public abstract <D> c<D> g(int i7, @o0 Bundle bundle, @m0 InterfaceC0103a<D> interfaceC0103a);

    public abstract void h();

    @m0
    @j0
    public abstract <D> c<D> i(int i7, @o0 Bundle bundle, @m0 InterfaceC0103a<D> interfaceC0103a);
}
