package com.google.android.gms.maps.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16528a = "p1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SuppressLint({"StaticFieldLeak"})
    private static Context f16529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static s1 f16530c;

    public static s1 a(Context context, @c.o0 com.google.android.gms.maps.f.a aVar) throws com.google.android.gms.common.i {
        s1 r1Var;
        com.google.android.gms.common.internal.u.k(context);
        String str = f16528a;
        Log.d(str, "preferredRenderer: ".concat(String.valueOf(aVar)));
        s1 s1Var = f16530c;
        if (s1Var != null) {
            return s1Var;
        }
        int iM = com.google.android.gms.common.k.m(context, 13400000);
        if (iM != 0) {
            throw new com.google.android.gms.common.i(iM);
        }
        Log.i(str, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) d(((ClassLoader) com.google.android.gms.common.internal.u.k(c(context, aVar).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                r1Var = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                r1Var = iInterfaceQueryLocalInterface instanceof s1 ? (s1) iInterfaceQueryLocalInterface : new r1(iBinder);
            }
            f16530c = r1Var;
            try {
                Context contextC = c(context, aVar);
                contextC.getClass();
                r1Var.i1(com.google.android.gms.dynamic.f.z3(contextC.getResources()), com.google.android.gms.common.k.f15854l);
                return f16530c;
            } catch (RemoteException e8) {
                throw new com.google.android.gms.maps.model.k(e8);
            }
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl");
        }
    }

    private static Context b(Exception exc, Context context) {
        Log.e(f16528a, "Failed to load maps module, use pre-Chimera", exc);
        return com.google.android.gms.common.k.i(context);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001b  */
    @c.o0
    private static Context c(Context context, @c.o0 com.google.android.gms.maps.f.a aVar) {
        String str;
        Context contextB;
        Context context2 = f16529b;
        if (context2 != null) {
            return context2;
        }
        context.getApplicationContext();
        if (aVar == null) {
            str = "com.google.android.gms.maps_dynamite";
        } else {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 0) {
                str = "com.google.android.gms.maps_legacy_dynamite";
            } else if (iOrdinal != 1) {
                str = "com.google.android.gms.maps_dynamite";
            } else {
                str = "com.google.android.gms.maps_core_dynamite";
            }
        }
        try {
            contextB = DynamiteModule.e(context, DynamiteModule.f16040b, str).b();
        } catch (Exception e8) {
            if (str.equals("com.google.android.gms.maps_dynamite")) {
                contextB = b(e8, context);
            } else {
                try {
                    Log.d(f16528a, "Attempting to load maps_dynamite again.");
                    contextB = DynamiteModule.e(context, DynamiteModule.f16040b, "com.google.android.gms.maps_dynamite").b();
                } catch (Exception e9) {
                    contextB = b(e9, context);
                }
            }
        }
        f16529b = contextB;
        return contextB;
    }

    private static <T> T d(Class cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException unused) {
            String name = cls.getName();
            throw new IllegalStateException(name.length() != 0 ? "Unable to call the default constructor of ".concat(name) : new String("Unable to call the default constructor of "));
        } catch (InstantiationException unused2) {
            String name2 = cls.getName();
            throw new IllegalStateException(name2.length() != 0 ? "Unable to instantiate the dynamic class ".concat(name2) : new String("Unable to instantiate the dynamic class "));
        }
    }
}
