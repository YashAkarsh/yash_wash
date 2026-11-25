package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import java.io.FileNotFoundException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6126a = "tree";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f6127a = 512;

        private a() {
        }
    }

    @t0(19)
    private static class b {
        private b() {
        }

        @t
        public static Uri a(String str, String str2) {
            return DocumentsContract.buildDocumentUri(str, str2);
        }

        @t
        static boolean b(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
            return DocumentsContract.deleteDocument(contentResolver, uri);
        }

        @t
        static String c(Uri uri) {
            return DocumentsContract.getDocumentId(uri);
        }

        @t
        static boolean d(Context context, @o0 Uri uri) {
            return DocumentsContract.isDocumentUri(context, uri);
        }
    }

    /* JADX INFO: renamed from: androidx.core.provider.c$c, reason: collision with other inner class name */
    @t0(21)
    private static class C0069c {
        private C0069c() {
        }

        @t
        static Uri a(String str, String str2) {
            return DocumentsContract.buildChildDocumentsUri(str, str2);
        }

        @t
        static Uri b(Uri uri, String str) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
        }

        @t
        static Uri c(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }

        @t
        public static Uri d(String str, String str2) {
            return DocumentsContract.buildTreeDocumentUri(str, str2);
        }

        @t
        static Uri e(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
            return DocumentsContract.createDocument(contentResolver, uri, str, str2);
        }

        @t
        static String f(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        @t
        static Uri g(@m0 ContentResolver contentResolver, @m0 Uri uri, @m0 String str) throws FileNotFoundException {
            return DocumentsContract.renameDocument(contentResolver, uri, str);
        }
    }

    @t0(24)
    private static class d {
        private d() {
        }

        @t
        static boolean a(@m0 Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }

        @t
        static boolean b(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(contentResolver, uri, uri2);
        }
    }

    private c() {
    }

    @o0
    public static Uri a(@m0 String str, @o0 String str2) {
        return C0069c.a(str, str2);
    }

    @o0
    public static Uri b(@m0 Uri uri, @m0 String str) {
        return C0069c.b(uri, str);
    }

    @o0
    public static Uri c(@m0 String str, @m0 String str2) {
        return b.a(str, str2);
    }

    @o0
    public static Uri d(@m0 Uri uri, @m0 String str) {
        return C0069c.c(uri, str);
    }

    @o0
    public static Uri e(@m0 String str, @m0 String str2) {
        return C0069c.d(str, str2);
    }

    @o0
    public static Uri f(@m0 ContentResolver contentResolver, @m0 Uri uri, @m0 String str, @m0 String str2) throws FileNotFoundException {
        return C0069c.e(contentResolver, uri, str, str2);
    }

    @o0
    public static String g(@m0 Uri uri) {
        return b.c(uri);
    }

    @o0
    public static String h(@m0 Uri uri) {
        return C0069c.f(uri);
    }

    public static boolean i(@m0 Context context, @o0 Uri uri) {
        return b.d(context, uri);
    }

    public static boolean j(@m0 Uri uri) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d.a(uri);
        }
        List<String> pathSegments = uri.getPathSegments();
        return pathSegments.size() >= 2 && f6126a.equals(pathSegments.get(0));
    }

    public static boolean k(@m0 ContentResolver contentResolver, @m0 Uri uri, @m0 Uri uri2) throws FileNotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? d.b(contentResolver, uri, uri2) : b.b(contentResolver, uri);
    }

    @o0
    public static Uri l(@m0 ContentResolver contentResolver, @m0 Uri uri, @m0 String str) throws FileNotFoundException {
        return C0069c.g(contentResolver, uri, str);
    }
}
