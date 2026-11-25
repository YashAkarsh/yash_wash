package org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f39449b = "App-Packaged-Cronet-Provider";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f39450c = "Fallback-Cronet-Provider";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f39451d = "CronetProviderClassName";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f39452e = "l";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f39453f = "org.chromium.net.impl.JavaCronetProvider";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f39454g = "org.chromium.net.impl.NativeCronetProvider";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f39455h = "com.google.android.gms.net.PlayServicesCronetProvider";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f39456i = "com.google.android.gms.net.GmsCoreCronetProvider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f39457a;

    protected l(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.f39457a = context;
    }

    private static boolean a(Context context, Set<l> set) {
        int identifier = context.getResources().getIdentifier(f39451d, androidx.constraintlayout.core.motion.utils.w.b.f3030e, context.getPackageName());
        boolean z7 = false;
        if (identifier == 0) {
            return false;
        }
        String string = context.getResources().getString(identifier);
        if (string != null && !string.equals(f39455h) && !string.equals(f39456i) && !string.equals(f39453f) && !string.equals(f39454g)) {
            z7 = true;
            if (!b(context, string, set, true)) {
                Log.e(f39452e, "Unable to instantiate Cronet implementation class " + string + " that is listed as in the app string resource file under " + f39451d + " key");
            }
        }
        return z7;
    }

    private static boolean b(Context context, String str, Set<l> set, boolean z7) {
        try {
            set.add((l) context.getClassLoader().loadClass(str).asSubclass(l.class).getConstructor(Context.class).newInstance(context));
            return true;
        } catch (ClassNotFoundException e8) {
            h(str, z7, e8);
            return false;
        } catch (IllegalAccessException e9) {
            h(str, z7, e9);
            return false;
        } catch (InstantiationException e10) {
            h(str, z7, e10);
            return false;
        } catch (NoSuchMethodException e11) {
            h(str, z7, e11);
            return false;
        } catch (InvocationTargetException e12) {
            h(str, z7, e12);
            return false;
        }
    }

    public static List<l> d(Context context) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(context, linkedHashSet);
        b(context, f39455h, linkedHashSet, false);
        b(context, f39456i, linkedHashSet, false);
        b(context, f39454g, linkedHashSet, false);
        b(context, f39453f, linkedHashSet, false);
        return Collections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    private static void h(String str, boolean z7, Exception exc) {
        if (z7) {
            Log.e(f39452e, "Unable to load provider class: " + str, exc);
            return;
        }
        String str2 = f39452e;
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Tried to load " + str + " provider class but it wasn't included in the app classpath");
        }
    }

    public abstract j.a c();

    public abstract String e();

    public abstract String f();

    public abstract boolean g();

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + e() + ", version=" + f() + ", enabled=" + g() + "]";
    }
}
