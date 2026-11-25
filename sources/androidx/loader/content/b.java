package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.os.e;
import androidx.core.os.g0;
import c.m0;
import c.o0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b extends a<Cursor> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final c<Cursor>.a f8398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Uri f8399s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String[] f8400t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    String f8401u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    String[] f8402v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    String f8403w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Cursor f8404x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    e f8405y;

    public b(@m0 Context context) {
        super(context);
        this.f8398r = new c.a();
    }

    @Override // androidx.loader.content.a
    public void D() {
        super.D();
        synchronized (this) {
            e eVar = this.f8405y;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    @Override // androidx.loader.content.c
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void f(Cursor cursor) {
        if (l()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f8404x;
        this.f8404x = cursor;
        if (m()) {
            super.f(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @o0
    public String[] O() {
        return this.f8400t;
    }

    @o0
    public String P() {
        return this.f8401u;
    }

    @o0
    public String[] Q() {
        return this.f8402v;
    }

    @o0
    public String R() {
        return this.f8403w;
    }

    @m0
    public Uri S() {
        return this.f8399s;
    }

    @Override // androidx.loader.content.a
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public Cursor I() {
        synchronized (this) {
            if (H()) {
                throw new g0();
            }
            this.f8405y = new e();
        }
        try {
            Cursor cursorA = androidx.core.content.b.a(i().getContentResolver(), this.f8399s, this.f8400t, this.f8401u, this.f8402v, this.f8403w, this.f8405y);
            if (cursorA != null) {
                try {
                    cursorA.getCount();
                    cursorA.registerContentObserver(this.f8398r);
                } catch (RuntimeException e8) {
                    cursorA.close();
                    throw e8;
                }
            }
            synchronized (this) {
                this.f8405y = null;
            }
            return cursorA;
        } catch (Throwable th) {
            synchronized (this) {
                this.f8405y = null;
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.a
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void J(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public void V(@o0 String[] strArr) {
        this.f8400t = strArr;
    }

    public void W(@o0 String str) {
        this.f8401u = str;
    }

    public void X(@o0 String[] strArr) {
        this.f8402v = strArr;
    }

    public void Y(@o0 String str) {
        this.f8403w = str;
    }

    public void Z(@m0 Uri uri) {
        this.f8399s = uri;
    }

    @Override // androidx.loader.content.a, androidx.loader.content.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f8399s);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f8400t));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f8401u);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f8402v));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f8403w);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f8404x);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f8413h);
    }

    @Override // androidx.loader.content.c
    protected void r() {
        super.r();
        t();
        Cursor cursor = this.f8404x;
        if (cursor != null && !cursor.isClosed()) {
            this.f8404x.close();
        }
        this.f8404x = null;
    }

    @Override // androidx.loader.content.c
    protected void s() {
        Cursor cursor = this.f8404x;
        if (cursor != null) {
            f(cursor);
        }
        if (A() || this.f8404x == null) {
            h();
        }
    }

    @Override // androidx.loader.content.c
    protected void t() {
        b();
    }

    public b(@m0 Context context, @m0 Uri uri, @o0 String[] strArr, @o0 String str, @o0 String[] strArr2, @o0 String str2) {
        super(context);
        this.f8398r = new c.a();
        this.f8399s = uri;
        this.f8400t = strArr;
        this.f8401u = str;
        this.f8402v = strArr2;
        this.f8403w = str2;
    }
}
