package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import c.o0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f7314c;

    c(@o0 a aVar, File file) {
        super(aVar);
        this.f7314c = file;
    }

    private static boolean w(File file) {
        File[] fileArrListFiles = file.listFiles();
        boolean zW = true;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    zW &= w(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    zW = false;
                }
            }
        }
        return zW;
    }

    private static String x(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(iLastIndexOf + 1).toLowerCase());
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // androidx.documentfile.provider.a
    public boolean a() {
        return this.f7314c.canRead();
    }

    @Override // androidx.documentfile.provider.a
    public boolean b() {
        return this.f7314c.canWrite();
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public a c(String str) {
        File file = new File(this.f7314c, str);
        if (file.isDirectory() || file.mkdir()) {
            return new c(this, file);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public a d(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + com.alibaba.android.arouter.utils.b.f12515h + extensionFromMimeType;
        }
        File file = new File(this.f7314c, str2);
        try {
            file.createNewFile();
            return new c(this, file);
        } catch (IOException e8) {
            Log.w("DocumentFile", "Failed to createFile: " + e8);
            return null;
        }
    }

    @Override // androidx.documentfile.provider.a
    public boolean e() {
        w(this.f7314c);
        return this.f7314c.delete();
    }

    @Override // androidx.documentfile.provider.a
    public boolean f() {
        return this.f7314c.exists();
    }

    @Override // androidx.documentfile.provider.a
    public String k() {
        return this.f7314c.getName();
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public String m() {
        if (this.f7314c.isDirectory()) {
            return null;
        }
        return x(this.f7314c.getName());
    }

    @Override // androidx.documentfile.provider.a
    public Uri n() {
        return Uri.fromFile(this.f7314c);
    }

    @Override // androidx.documentfile.provider.a
    public boolean o() {
        return this.f7314c.isDirectory();
    }

    @Override // androidx.documentfile.provider.a
    public boolean q() {
        return this.f7314c.isFile();
    }

    @Override // androidx.documentfile.provider.a
    public boolean r() {
        return false;
    }

    @Override // androidx.documentfile.provider.a
    public long s() {
        return this.f7314c.lastModified();
    }

    @Override // androidx.documentfile.provider.a
    public long t() {
        return this.f7314c.length();
    }

    @Override // androidx.documentfile.provider.a
    public a[] u() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = this.f7314c.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                arrayList.add(new c(this, file));
            }
        }
        return (a[]) arrayList.toArray(new a[arrayList.size()]);
    }

    @Override // androidx.documentfile.provider.a
    public boolean v(String str) {
        File file = new File(this.f7314c.getParentFile(), str);
        if (!this.f7314c.renameTo(file)) {
            return false;
        }
        this.f7314c = file;
        return true;
    }
}
