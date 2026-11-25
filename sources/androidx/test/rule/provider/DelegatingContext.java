package androidx.test.rule.provider;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import androidx.test.internal.util.Checks;
import c.m0;
import c.o0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class DelegatingContext extends ContextWrapper {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f10405g = "DelegatingContext";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f10406h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f10407i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f10409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentResolver f10410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f10411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f10412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f10413f;

    public DelegatingContext(@m0 Context context, @m0 String prefix, @m0 ContentResolver contentResolver) {
        super((Context) Checks.f(context));
        this.f10411d = new HashSet();
        this.f10412e = new HashSet();
        this.f10413f = new HashSet();
        this.f10409b = context;
        this.f10408a = (String) Checks.f(prefix);
        this.f10410c = (ContentResolver) Checks.f(contentResolver);
    }

    private String c(@m0 String name) {
        Checks.b(!TextUtils.isEmpty(name), "Name cannot be empty or null");
        String strValueOf = String.valueOf(this.f10408a);
        String strValueOf2 = String.valueOf(name);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    boolean a(@m0 String name) {
        Checks.b(!TextUtils.isEmpty(name), "Database name cannot be empty or null");
        return this.f10411d.add(name);
    }

    void b(@m0 String permission) {
        Checks.b(!TextUtils.isEmpty(permission), "permission cannot be null or empty");
        this.f10413f.add(permission);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent service, @m0 ServiceConnection conn, int flags) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfPermission(@m0 String permission) {
        return checkPermission(permission, -1, -1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfUriPermission(@m0 Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingPermission(@m0 String permission) {
        return checkPermission(permission, -1, -1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingUriPermission(@m0 Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkPermission(@m0 String permission, int pid, int uid) {
        Checks.b(!TextUtils.isEmpty(permission), "permission cannot be null or empty");
        return this.f10413f.contains(permission) ? -1 : 0;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(@m0 String permission) {
        return checkPermission(permission, -1, -1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(@m0 Uri uri, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void clearWallpaper() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(@m0 Configuration overrideConfiguration) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createDisplayContext(@m0 Display display) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        Set<String> set = this.f10411d;
        return (String[]) set.toArray(new String[set.size()]);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(@m0 String name) {
        Checks.b(!TextUtils.isEmpty(name), "Database name cannot be empty or null");
        if (!this.f10411d.contains(name) || !this.f10409b.deleteDatabase(c(name))) {
            return false;
        }
        this.f10411d.remove(name);
        return true;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(@m0 String name) {
        Checks.b(!TextUtils.isEmpty(name), "File name cannot be empty or null");
        if (!this.f10412e.contains(name) || !this.f10409b.deleteFile(c(name))) {
            return false;
        }
        this.f10412e.remove(name);
        return true;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfPermission(@m0 String permission, String message) {
        enforcePermission(permission, -1, -1, message);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingPermission(@m0 String permission, String message) {
        enforcePermission(permission, -1, -1, message);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforcePermission(@m0 String permission, int pid, int uid, String message) {
        if (checkPermission(permission, pid, uid) != 0) {
            String strConcat = message != null ? message.concat(": ") : "";
            StringBuilder sb = new StringBuilder(String.valueOf(strConcat).length() + 14 + String.valueOf(permission).length());
            sb.append(strConcat);
            sb.append("No permission ");
            sb.append(permission);
            throw new SecurityException(sb.toString());
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(@m0 Uri uri, int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        Set<String> set = this.f10412e;
        return (String[]) set.toArray(new String[set.size()]);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return this.f10410c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(@m0 String name) {
        Checks.b(!TextUtils.isEmpty(name), "Database name cannot be empty or null");
        return this.f10409b.getDatabasePath(c(name));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(@m0 String name, int mode) {
        Checks.b(!TextUtils.isEmpty(name), "Directory name cannot be empty or null");
        return this.f10409b.getDir(c(name), mode);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String s7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String s7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(@m0 String name) {
        Checks.b(!TextUtils.isEmpty(name), "File name cannot be empty or null");
        return this.f10409b.getFileStreamPath(c(name));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String name, int mode) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@m0 String name) {
        Checks.b(!TextUtils.isEmpty(name), "name cannot be empty or null");
        if ("appops".equals(name)) {
            return this.f10409b.getSystemService("appops");
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getSystemServiceName(Class<?> aClass) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable getWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean isRestricted() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(@m0 String name) throws FileNotFoundException {
        Checks.b(!TextUtils.isEmpty(name), "File name cannot be empty or null");
        if (this.f10412e.contains(name)) {
            return this.f10409b.openFileInput(c(name));
        }
        throw new FileNotFoundException(String.format("File %s is not found in current context", name));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(@m0 String name, int mode) throws FileNotFoundException {
        Checks.b(!TextUtils.isEmpty(name), "File name cannot be empty or null");
        FileOutputStream fileOutputStreamOpenFileOutput = this.f10409b.openFileOutput(c(name), mode);
        if (fileOutputStreamOpenFileOutput != null) {
            this.f10412e.add(name);
        }
        return fileOutputStreamOpenFileOutput;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(@m0 String name, int mode, SQLiteDatabase.CursorFactory factory) {
        Checks.b(!TextUtils.isEmpty(name), "Database name cannot be empty or null");
        if (!this.f10411d.contains(name)) {
            a(name);
            String strC = c(name);
            if (this.f10409b.getDatabasePath(strC).exists() && !this.f10409b.deleteDatabase(strC)) {
                StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 65);
                sb.append("Database with prefixed name ");
                sb.append(strC);
                sb.append(" already exists but failed to delete.");
                Log.w(f10405g, sb.toString());
            }
        }
        return this.f10409b.openOrCreateDatabase(c(name), mode, factory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable peekWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void revokeUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String s7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(@m0 Intent intent, String s7, BroadcastReceiver broadcastReceiver, Handler handler, int i7, String s8, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String s7, BroadcastReceiver broadcastReceiver, Handler handler, int i7, String s8, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i7, String s7, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i7, String s7, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int resID) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(Bitmap bitmap) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intents) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean startInstrumentation(@m0 ComponentName componentName, String s7, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i7, int i8, int i9) throws IntentSender.SendIntentException {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(@m0 ServiceConnection serviceConnection) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver receiver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(@o0 Uri uri, @o0 String readPermission, @o0 String writePermission, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String s7, Handler handler) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String s7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String s7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(InputStream inputStream) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intents, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i7, int i8, int i9, Bundle bundle) throws IntentSender.SendIntentException {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(@m0 String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        Checks.b(!TextUtils.isEmpty(name), "Database name cannot be empty or null");
        String strC = c(name);
        if (!this.f10411d.contains(name)) {
            a(name);
            if (this.f10409b.getDatabasePath(strC).exists() && !this.f10409b.deleteDatabase(strC)) {
                StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 66);
                sb.append("Database with prefixed name ");
                sb.append(strC);
                sb.append(" already exists and cannot be deleted.");
                Log.w(f10405g, sb.toString());
            }
        }
        return this.f10409b.openOrCreateDatabase(strC, mode, factory, errorHandler);
    }
}
