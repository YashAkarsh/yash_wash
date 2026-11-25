package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.j;
import c.j0;
import c.m0;
import c.o0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class c<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    InterfaceC0106c<D> f8407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b<D> f8408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f8409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f8410e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f8411f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f8412g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f8413h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f8414i = false;

    public final class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            c.this.p();
        }
    }

    public interface b<D> {
        void a(@m0 c<D> cVar);
    }

    /* JADX INFO: renamed from: androidx.loader.content.c$c, reason: collision with other inner class name */
    public interface InterfaceC0106c<D> {
        void a(@m0 c<D> cVar, @o0 D d8);
    }

    public c(@m0 Context context) {
        this.f8409d = context.getApplicationContext();
    }

    public boolean A() {
        boolean z7 = this.f8413h;
        this.f8413h = false;
        this.f8414i |= z7;
        return z7;
    }

    @j0
    public void B(@m0 InterfaceC0106c<D> interfaceC0106c) {
        InterfaceC0106c<D> interfaceC0106c2 = this.f8407b;
        if (interfaceC0106c2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0106c2 != interfaceC0106c) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f8407b = null;
    }

    @j0
    public void C(@m0 b<D> bVar) {
        b<D> bVar2 = this.f8408c;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (bVar2 != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f8408c = null;
    }

    @j0
    public void a() {
        this.f8411f = true;
        n();
    }

    @j0
    public boolean b() {
        return o();
    }

    public void c() {
        this.f8414i = false;
    }

    @m0
    public String d(@o0 D d8) {
        StringBuilder sb = new StringBuilder(64);
        j.a(d8, sb);
        sb.append(com.alipay.sdk.util.j.f13808d);
        return sb.toString();
    }

    @j0
    public void e() {
        b<D> bVar = this.f8408c;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @j0
    public void f(@o0 D d8) {
        InterfaceC0106c<D> interfaceC0106c = this.f8407b;
        if (interfaceC0106c != null) {
            interfaceC0106c.a(this, d8);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f8406a);
        printWriter.print(" mListener=");
        printWriter.println(this.f8407b);
        if (this.f8410e || this.f8413h || this.f8414i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f8410e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f8413h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f8414i);
        }
        if (this.f8411f || this.f8412g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f8411f);
            printWriter.print(" mReset=");
            printWriter.println(this.f8412g);
        }
    }

    @j0
    public void h() {
        q();
    }

    @m0
    public Context i() {
        return this.f8409d;
    }

    public int j() {
        return this.f8406a;
    }

    public boolean k() {
        return this.f8411f;
    }

    public boolean l() {
        return this.f8412g;
    }

    public boolean m() {
        return this.f8410e;
    }

    @j0
    protected void n() {
    }

    @j0
    protected boolean o() {
        return false;
    }

    @j0
    public void p() {
        if (this.f8410e) {
            h();
        } else {
            this.f8413h = true;
        }
    }

    @j0
    protected void q() {
    }

    @j0
    protected void r() {
    }

    @j0
    protected void s() {
    }

    @j0
    protected void t() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        j.a(this, sb);
        sb.append(" id=");
        sb.append(this.f8406a);
        sb.append(com.alipay.sdk.util.j.f13808d);
        return sb.toString();
    }

    @j0
    public void u(int i7, @m0 InterfaceC0106c<D> interfaceC0106c) {
        if (this.f8407b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f8407b = interfaceC0106c;
        this.f8406a = i7;
    }

    @j0
    public void v(@m0 b<D> bVar) {
        if (this.f8408c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f8408c = bVar;
    }

    @j0
    public void w() {
        r();
        this.f8412g = true;
        this.f8410e = false;
        this.f8411f = false;
        this.f8413h = false;
        this.f8414i = false;
    }

    public void x() {
        if (this.f8414i) {
            p();
        }
    }

    @j0
    public final void y() {
        this.f8410e = true;
        this.f8412g = false;
        this.f8411f = false;
        s();
    }

    @j0
    public void z() {
        this.f8410e = false;
        t();
    }
}
