package androidx.test.rule.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.test.mock.MockContentResolver;
import android.text.TextUtils;
import android.util.Log;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import c.g1;
import c.m0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.rules.l;
import org.junit.runner.c;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class ProviderTestRule implements l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10422e = "ProviderTestRule";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<WeakReference<ContentProvider>> f10423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<DatabaseArgs> f10424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentResolver f10425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DelegatingContext f10426d;

    public static class Builder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f10427d = "test.";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Class<? extends ContentProvider>> f10428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, DatabaseArgs> f10429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f10430c;

        public <T extends ContentProvider> Builder(@m0 Class<T> providerClass, @m0 String providerAuth) {
            HashMap map = new HashMap();
            this.f10428a = map;
            this.f10429b = new HashMap();
            this.f10430c = f10427d;
            Checks.f(providerClass);
            Checks.f(providerAuth);
            map.put(providerAuth, providerClass);
        }

        private ContentProvider c(String auth, Class<? extends ContentProvider> clazz, MockContentResolver resolver, Context context) {
            try {
                ContentProvider contentProviderNewInstance = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
                ProviderInfo providerInfo = new ProviderInfo();
                providerInfo.authority = auth;
                contentProviderNewInstance.attachInfo(context, providerInfo);
                resolver.addProvider(providerInfo.authority, contentProviderNewInstance);
                return contentProviderNewInstance;
            } catch (IllegalAccessException e8) {
                String strValueOf = String.valueOf(clazz.toString());
                Log.e(ProviderTestRule.f10422e, strValueOf.length() != 0 ? "IllegalAccessException occurred when trying create new Instance for ".concat(strValueOf) : new String("IllegalAccessException occurred when trying create new Instance for "));
                throw new RuntimeException(e8);
            } catch (InstantiationException e9) {
                String strValueOf2 = String.valueOf(clazz.toString());
                Log.e(ProviderTestRule.f10422e, strValueOf2.length() != 0 ? "InstantiationException occurred when trying create new Instance for ".concat(strValueOf2) : new String("InstantiationException occurred when trying create new Instance for "));
                throw new RuntimeException(e9);
            } catch (NoSuchMethodException e10) {
                String strValueOf3 = String.valueOf(clazz.toString());
                Log.e(ProviderTestRule.f10422e, strValueOf3.length() != 0 ? "NoSuchMethodException occurred when trying create new Instance for ".concat(strValueOf3) : new String("NoSuchMethodException occurred when trying create new Instance for "));
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                String strValueOf4 = String.valueOf(clazz.toString());
                Log.e(ProviderTestRule.f10422e, strValueOf4.length() != 0 ? "InvocationTargetException occurred when trying create new Instance for ".concat(strValueOf4) : new String("InvocationTargetException occurred when trying create new Instance for "));
                throw new RuntimeException(e11);
            }
        }

        private DatabaseArgs d(String dbName) {
            if (this.f10429b.containsKey(dbName)) {
                return this.f10429b.get(dbName);
            }
            DatabaseArgs databaseArgs = new DatabaseArgs(dbName);
            this.f10429b.put(dbName, databaseArgs);
            return databaseArgs;
        }

        public <T extends ContentProvider> Builder a(@m0 Class<T> providerClass, @m0 String providerAuth) {
            Checks.f(providerClass);
            Checks.f(providerAuth);
            Checks.j(this.f10428a.size() > 0, "No existing provider yet while trying to add more");
            Checks.j(!this.f10428a.containsKey(providerAuth), String.format("ContentProvider with authority %s already exists.", providerAuth));
            this.f10428a.put(providerAuth, providerClass);
            return this;
        }

        public ProviderTestRule b() {
            HashSet hashSet = new HashSet();
            MockContentResolver mockContentResolver = new MockContentResolver();
            DelegatingContext delegatingContext = new DelegatingContext(InstrumentationRegistry.b().getTargetContext(), this.f10430c, mockContentResolver);
            for (Map.Entry<String, Class<? extends ContentProvider>> entry : this.f10428a.entrySet()) {
                hashSet.add(new WeakReference(c(entry.getKey(), entry.getValue(), mockContentResolver, delegatingContext)));
            }
            return new ProviderTestRule(hashSet, new HashSet(this.f10429b.values()), mockContentResolver, delegatingContext);
        }

        public Builder e(@m0 String dbName, @m0 String... dbCmds) {
            Checks.f(dbName);
            Checks.f(dbCmds);
            d(dbName).j(dbCmds);
            return this;
        }

        public Builder f(@m0 String dbName, @m0 File dbCmdFile) {
            Checks.f(dbName);
            Checks.f(dbCmdFile);
            d(dbName).i(dbCmdFile);
            return this;
        }

        public Builder g(@m0 String dbName, @m0 File dbDataFile) {
            Checks.f(dbName);
            Checks.f(dbDataFile);
            d(dbName).k(dbDataFile);
            return this;
        }

        public Builder h(@m0 String prefix) {
            Checks.b(!TextUtils.isEmpty(prefix), "The prefix cannot be null or empty");
            this.f10430c = prefix;
            return this;
        }
    }

    private class ProviderStatement extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f10431a;

        public ProviderStatement(j base) {
            this.f10431a = base;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            try {
                ProviderTestRule.this.n();
                this.f10431a.a();
            } finally {
                ProviderTestRule.this.f();
            }
        }
    }

    @g1
    ProviderTestRule(Set<WeakReference<ContentProvider>> providersRef, Set<DatabaseArgs> databaseArgsSet, ContentResolver resolver, DelegatingContext context) {
        this.f10423a = providersRef;
        this.f10424b = databaseArgsSet;
        this.f10425c = resolver;
        this.f10426d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Iterator<WeakReference<ContentProvider>> it = this.f10423a.iterator();
        while (it.hasNext()) {
            ContentProvider contentProvider = it.next().get();
            if (contentProvider != null) {
                contentProvider.shutdown();
            }
        }
        Iterator<DatabaseArgs> it2 = this.f10424b.iterator();
        while (it2.hasNext()) {
            String strE = it2.next().e();
            if (strE != null) {
                this.f10426d.deleteDatabase(strE);
            }
        }
        d();
    }

    private void g(DatabaseArgs databaseArgs) throws Throwable {
        File fileB = databaseArgs.b();
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileB), Charset.forName("UTF-8")));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            bufferedReader2.close();
                            databaseArgs.a((String[]) arrayList.toArray(new String[arrayList.size()]));
                            return;
                        } else if (!TextUtils.isEmpty(line)) {
                            arrayList.add(line);
                        }
                    } catch (IOException e8) {
                        e = e8;
                        bufferedReader = bufferedReader2;
                        Log.e(f10422e, String.format("Cannot open command file %s to read", fileB));
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void h(File src, File dest) throws IOException {
        File parentFile = dest.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            String str = String.format("error happened creating parent dir for file %s", dest);
            Log.e(f10422e, str);
            throw new IOException(str);
        }
        FileChannel channel = new FileInputStream(src).getChannel();
        FileChannel channel2 = new FileOutputStream(dest).getChannel();
        try {
            try {
                channel.transferTo(0L, channel.size(), channel2);
                channel.close();
                channel2.close();
            } catch (IOException e8) {
                Log.e(f10422e, String.format("error happened copying file from %s to %s", src, dest));
                throw e8;
            }
        } catch (Throwable th) {
            channel.close();
            channel2.close();
            throw th;
        }
    }

    private void j(DatabaseArgs databaseArgs) throws IOException {
        File fileD = databaseArgs.d();
        Checks.j(fileD.exists(), String.format("The database file %s doesn't exist!", fileD));
        String strE = databaseArgs.e();
        h(fileD, this.f10426d.getDatabasePath(strE));
        this.f10426d.a(strE);
    }

    private void m(DatabaseArgs databaseArgs) throws Throwable {
        if (databaseArgs.h()) {
            j(databaseArgs);
        }
        if (databaseArgs.f()) {
            g(databaseArgs);
        }
        if (databaseArgs.g()) {
            l(databaseArgs.e(), databaseArgs.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() throws Throwable {
        e();
        Iterator<DatabaseArgs> it = this.f10424b.iterator();
        while (it.hasNext()) {
            m(it.next());
        }
    }

    @Override // org.junit.rules.l
    public j a(j base, c description) {
        return new ProviderStatement(base);
    }

    protected void d() {
    }

    protected void e() {
    }

    public ContentResolver i() {
        return this.f10425c;
    }

    public void k(@m0 String permission) {
        Checks.b(!TextUtils.isEmpty(permission), "permission cannot be null or empty");
        this.f10426d.b(permission);
    }

    public void l(@m0 String dbName, @m0 String... dbCmds) {
        Checks.f(dbName);
        Checks.f(dbCmds);
        if (dbCmds.length > 0) {
            SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = this.f10426d.openOrCreateDatabase(dbName, 0, null);
            for (String str : dbCmds) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        sQLiteDatabaseOpenOrCreateDatabase.execSQL(str);
                    } catch (SQLiteException e8) {
                        Log.e(f10422e, String.format("Error executing sql command %s, possibly wrong or duplicated commands (e.g. same table insertion command without checking current table existence).", str));
                        throw e8;
                    }
                }
            }
        }
    }
}
