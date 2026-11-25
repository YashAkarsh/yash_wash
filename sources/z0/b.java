package z0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f40656b = "GlideModule";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f40657a;

    public b(Context context) {
        this.f40657a = context;
    }

    private static a b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.newInstance();
                if (objNewInstance instanceof a) {
                    return (a) objNewInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e8);
            } catch (InstantiationException e9) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e9);
            }
        } catch (ClassNotFoundException e10) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e10);
        }
    }

    public List<a> a() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f40657a.getPackageManager().getApplicationInfo(this.f40657a.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (f40656b.equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(b(str));
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e8) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e8);
        }
    }
}
