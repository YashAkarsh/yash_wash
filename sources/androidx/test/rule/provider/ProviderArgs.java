package androidx.test.rule.provider;

import android.content.ContentProvider;
import android.util.Log;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class ProviderArgs {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f10414h = "ProviderArgs";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends ContentProvider> f10416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f10418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f10419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f10420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WeakReference<ContentProvider> f10421g;

    public ProviderArgs(String authority, Class<? extends ContentProvider> providerClass) {
        this.f10415a = authority;
        this.f10416b = providerClass;
    }

    public void a(String... dbCmds) {
        String[] strArr = this.f10418d;
        if (strArr == null) {
            this.f10418d = dbCmds;
            return;
        }
        String[] strArr2 = new String[strArr.length + dbCmds.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        System.arraycopy(dbCmds, 0, strArr2, this.f10418d.length, dbCmds.length);
        this.f10418d = strArr2;
    }

    public String b() {
        return this.f10415a;
    }

    public File c() {
        return this.f10419e;
    }

    public String[] d() {
        return this.f10418d;
    }

    public File e() {
        return this.f10420f;
    }

    public String f() {
        return this.f10417c;
    }

    public ContentProvider g() {
        WeakReference<ContentProvider> weakReference = this.f10421g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Class<? extends ContentProvider> h() {
        return this.f10416b;
    }

    public boolean i() {
        return this.f10419e != null;
    }

    public boolean j() {
        return this.f10418d != null;
    }

    public boolean k() {
        return this.f10420f != null;
    }

    public boolean l() {
        return this.f10417c != null;
    }

    public void m(File dbCmdFile) {
        if (this.f10419e != null) {
            Log.w(f10414h, String.format("Database command file for ContentProvider with authority %s already set", this.f10415a));
        }
        this.f10419e = dbCmdFile;
    }

    public void n(String... dbCmds) {
        if (this.f10418d != null) {
            Log.w(f10414h, String.format("Database commands for ContentProvider with authority %s already set", this.f10415a));
        }
        this.f10418d = dbCmds;
    }

    public void o(File dbDataFile) {
        if (this.f10420f != null) {
            Log.w(f10414h, String.format("Database file to restore for ContentProvider with authority %s already set", this.f10415a));
        }
        this.f10420f = dbDataFile;
    }

    public void p(String dbName) {
        if (this.f10417c != null) {
            Log.w(f10414h, String.format("Database name for ContentProvider with authority %s already exists", this.f10415a));
        }
        this.f10417c = dbName;
    }

    public void q(ContentProvider provider) {
        if (this.f10421g != null) {
            Log.w(f10414h, String.format("Reference to Provider instance with authority %s already set", this.f10415a));
        }
        this.f10421g = new WeakReference<>(provider);
    }
}
