package androidx.test.rule.provider;

import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
final class DatabaseArgs {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10400e = "DatabaseArgs";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f10402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f10403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f10404d;

    public DatabaseArgs(String dbName) {
        this.f10401a = dbName;
    }

    public void a(String... dbCmds) {
        String[] strArr = this.f10402b;
        if (strArr == null) {
            this.f10402b = dbCmds;
            return;
        }
        String[] strArr2 = new String[strArr.length + dbCmds.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        System.arraycopy(dbCmds, 0, strArr2, this.f10402b.length, dbCmds.length);
        this.f10402b = strArr2;
    }

    public File b() {
        return this.f10403c;
    }

    public String[] c() {
        return this.f10402b;
    }

    public File d() {
        return this.f10404d;
    }

    public String e() {
        return this.f10401a;
    }

    public boolean f() {
        return this.f10403c != null;
    }

    public boolean g() {
        return this.f10402b != null;
    }

    public boolean h() {
        return this.f10404d != null;
    }

    public void i(File dbCmdFile) {
        if (this.f10403c != null) {
            Log.w(f10400e, String.format("Command file for database %s already set", this.f10401a));
        }
        this.f10403c = dbCmdFile;
    }

    public void j(String... dbCmds) {
        if (this.f10402b != null) {
            Log.w(f10400e, String.format("Commands for database %s already set", this.f10401a));
        }
        this.f10402b = dbCmds;
    }

    public void k(File dbDataFile) {
        if (this.f10404d != null) {
            Log.w(f10400e, String.format("Data file to restore for database %s already set", this.f10401a));
        }
        this.f10404d = dbDataFile;
    }
}
