package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import c.m0;
import c.o0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f7310b = "DocumentFile";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final a f7311a;

    a(@o0 a aVar) {
        this.f7311a = aVar;
    }

    @m0
    public static a h(@m0 File file) {
        return new c(null, file);
    }

    @o0
    public static a i(@m0 Context context, @m0 Uri uri) {
        return new d(null, context, uri);
    }

    @o0
    public static a j(@m0 Context context, @m0 Uri uri) {
        return new e(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
    }

    public static boolean p(@m0 Context context, @o0 Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public abstract boolean a();

    public abstract boolean b();

    @o0
    public abstract a c(@m0 String str);

    @o0
    public abstract a d(@m0 String str, @m0 String str2);

    public abstract boolean e();

    public abstract boolean f();

    @o0
    public a g(@m0 String str) {
        for (a aVar : u()) {
            if (str.equals(aVar.k())) {
                return aVar;
            }
        }
        return null;
    }

    @o0
    public abstract String k();

    @o0
    public a l() {
        return this.f7311a;
    }

    @o0
    public abstract String m();

    @m0
    public abstract Uri n();

    public abstract boolean o();

    public abstract boolean q();

    public abstract boolean r();

    public abstract long s();

    public abstract long t();

    @m0
    public abstract a[] u();

    public abstract boolean v(@m0 String str);
}
