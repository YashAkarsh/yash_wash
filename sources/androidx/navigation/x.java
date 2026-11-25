package androidx.navigation;

import android.annotation.SuppressLint;
import c.m0;
import c.o0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"TypeParameterUnusedInFormals"})
public class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Class<?>, String> f8967b = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, w<? extends l>> f8968a = new HashMap<>();

    @m0
    static String c(@m0 Class<? extends w> cls) {
        HashMap<Class<?>, String> map = f8967b;
        String strValue = map.get(cls);
        if (strValue == null) {
            w.b bVar = (w.b) cls.getAnnotation(w.b.class);
            strValue = bVar != null ? bVar.value() : null;
            if (!g(strValue)) {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
            map.put(cls, strValue);
        }
        return strValue;
    }

    private static boolean g(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    @o0
    public final w<? extends l> a(@m0 w<? extends l> wVar) {
        return b(c(wVar.getClass()), wVar);
    }

    @o0
    @c.i
    public w<? extends l> b(@m0 String str, @m0 w<? extends l> wVar) {
        if (g(str)) {
            return this.f8968a.put(str, wVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    @m0
    public final <T extends w<?>> T d(@m0 Class<T> cls) {
        return (T) e(c(cls));
    }

    @c.i
    @m0
    public <T extends w<?>> T e(@m0 String str) {
        if (!g(str)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        w<? extends l> wVar = this.f8968a.get(str);
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
    }

    Map<String, w<? extends l>> f() {
        return this.f8968a;
    }
}
