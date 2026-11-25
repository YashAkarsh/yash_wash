package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class DynamiteModule {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    @GuardedBy("DynamiteModule.class")
    private static Boolean f16046h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    @GuardedBy("DynamiteModule.class")
    private static String f16047i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    private static boolean f16048j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    private static int f16049k = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    @GuardedBy("DynamiteModule.class")
    private static s f16054p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    @GuardedBy("DynamiteModule.class")
    private static t f16055q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f16056a;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ThreadLocal<p> f16050l = new ThreadLocal<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ThreadLocal<Long> f16051m = new f();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final b.a f16052n = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c1.a
    @m0
    public static final b f16040b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c1.a
    @m0
    public static final b f16041c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c1.a
    @m0
    public static final b f16042d = new j();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c1.a
    @m0
    public static final b f16043e = new k();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c1.a
    @m0
    public static final b f16044f = new l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c1.a
    @m0
    public static final b f16045g = new m();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @m0
    public static final b f16053o = new n();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @o0
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @c1.a
    public static class a extends Exception {
        /* synthetic */ a(String str, r rVar) {
            super(str);
        }

        /* synthetic */ a(String str, Throwable th, r rVar) {
            super(str, th);
        }
    }

    public interface b {

        public interface a {
            int a(@m0 Context context, @m0 String str, boolean z7) throws a;

            int b(@m0 Context context, @m0 String str);
        }

        /* JADX INFO: renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b, reason: collision with other inner class name */
        public static class C0186b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @c1.a
            public int f16057a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @c1.a
            public int f16058b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @c1.a
            public int f16059c = 0;
        }

        @c1.a
        @m0
        C0186b a(@m0 Context context, @m0 String str, @m0 a aVar) throws a;
    }

    private DynamiteModule(Context context) {
        u.k(context);
        this.f16056a = context;
    }

    @c1.a
    public static int a(@m0 Context context, @m0 String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(com.alibaba.android.arouter.utils.b.f12515h);
            sb.append("ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (com.google.android.gms.common.internal.s.b(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String strValueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(strValueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e8) {
            String strValueOf2 = String.valueOf(e8.getMessage());
            Log.e("DynamiteModule", strValueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @c1.a
    public static int c(@m0 Context context, @m0 String str) {
        return f(context, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x02b4 A[Catch: all -> 0x0309, TryCatch #4 {all -> 0x0309, blocks: (B:3:0x0023, B:7:0x0081, B:12:0x0089, B:15:0x008f, B:26:0x00b1, B:104:0x0239, B:105:0x0244, B:107:0x0246, B:109:0x0248, B:110:0x0250, B:132:0x02b4, B:133:0x02cd, B:112:0x0252, B:114:0x0264, B:116:0x026f, B:118:0x0276, B:120:0x0285, B:130:0x02ab, B:131:0x02b3, B:115:0x0269, B:134:0x02ce, B:135:0x0308), top: B:150:0x0023, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x008f A[Catch: all -> 0x0309, TRY_LEAVE, TryCatch #4 {all -> 0x0309, blocks: (B:3:0x0023, B:7:0x0081, B:12:0x0089, B:15:0x008f, B:26:0x00b1, B:104:0x0239, B:105:0x0244, B:107:0x0246, B:109:0x0248, B:110:0x0250, B:132:0x02b4, B:133:0x02cd, B:112:0x0252, B:114:0x0264, B:116:0x026f, B:118:0x0276, B:120:0x0285, B:130:0x02ab, B:131:0x02b3, B:115:0x0269, B:134:0x02ce, B:135:0x0308), top: B:150:0x0023, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0099  */
    /* JADX WARN: Code duplicated, block: B:19:0x009d  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:25:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00bb A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TRY_ENTER, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c2 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f2 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TRY_ENTER, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x016b A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0177 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01a5 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01ac A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01b4 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x01ce A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01de A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01f3 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TRY_LEAVE, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0204  */
    /* JADX WARN: Code duplicated, block: B:88:0x0208  */
    /* JADX WARN: Code duplicated, block: B:91:0x0213  */
    /* JADX WARN: Code duplicated, block: B:94:0x021a A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TRY_ENTER, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0223 A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x022c A[Catch: all -> 0x0238, a -> 0x0245, RemoteException -> 0x0247, TryCatch #7 {RemoteException -> 0x0247, a -> 0x0245, all -> 0x0238, blocks: (B:28:0x00b5, B:32:0x00bb, B:34:0x00c2, B:35:0x00ec, B:39:0x00f2, B:41:0x00fa, B:43:0x00fe, B:44:0x010b, B:51:0x011a, B:53:0x0120, B:55:0x0147, B:57:0x014f, B:58:0x0156, B:59:0x015e, B:54:0x0134, B:62:0x0161, B:63:0x0162, B:64:0x016a, B:65:0x016b, B:66:0x0173, B:69:0x0176, B:70:0x0177, B:72:0x01a5, B:74:0x01ac, B:76:0x01b4, B:82:0x01ed, B:84:0x01f3, B:94:0x021a, B:95:0x0222, B:77:0x01c3, B:78:0x01cb, B:80:0x01ce, B:81:0x01de, B:96:0x0223, B:97:0x022b, B:98:0x022c, B:99:0x0234, B:102:0x0237), top: B:154:0x00b5 }] */
    @c1.a
    @m0
    public static DynamiteModule e(@m0 Context context, @m0 b bVar, @m0 String str) throws a {
        int i7;
        Boolean bool;
        s sVarK;
        int iC;
        com.google.android.gms.dynamic.d dVarV6;
        DynamiteModule dynamiteModule;
        p pVar;
        Cursor cursor;
        t tVar;
        p pVar2;
        Boolean boolValueOf;
        com.google.android.gms.dynamic.d dVarT6;
        Cursor cursor2;
        ThreadLocal<p> threadLocal = f16050l;
        p pVar3 = threadLocal.get();
        p pVar4 = new p(null);
        threadLocal.set(pVar4);
        ThreadLocal<Long> threadLocal2 = f16051m;
        long jLongValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            b.C0186b c0186bA = bVar.a(context, str, f16052n);
            int i8 = c0186bA.f16057a;
            int i9 = c0186bA.f16058b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i8);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i9);
            Log.i("DynamiteModule", sb.toString());
            int i10 = c0186bA.f16059c;
            if (i10 != 0) {
                if (i10 != -1) {
                    if (i10 == 1 || c0186bA.f16058b != 0) {
                        if (i10 == -1) {
                            DynamiteModule dynamiteModuleH = h(context, str);
                            if (jLongValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(jLongValue));
                            }
                            cursor2 = pVar4.f16062a;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            threadLocal.set(pVar3);
                            return dynamiteModuleH;
                        }
                        if (i10 == 1) {
                            StringBuilder sb2 = new StringBuilder(47);
                            sb2.append("VersionPolicy returned invalid code:");
                            sb2.append(i10);
                            throw new a(sb2.toString(), null);
                        }
                        try {
                            i7 = c0186bA.f16058b;
                            try {
                                synchronized (DynamiteModule.class) {
                                    bool = f16046h;
                                }
                                if (bool != null) {
                                    throw new a("Failed to determine which loading route to use.", null);
                                }
                                if (bool.booleanValue()) {
                                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 51);
                                    sb3.append("Selected remote version of ");
                                    sb3.append(str);
                                    sb3.append(", version >= ");
                                    sb3.append(i7);
                                    Log.i("DynamiteModule", sb3.toString());
                                    synchronized (DynamiteModule.class) {
                                        tVar = f16055q;
                                    }
                                    if (tVar != null) {
                                        throw new a("DynamiteLoaderV2 was not cached.", null);
                                    }
                                    pVar2 = threadLocal.get();
                                    if (pVar2 != null || pVar2.f16062a == null) {
                                        throw new a("No result cursor", null);
                                    }
                                    Context applicationContext = context.getApplicationContext();
                                    Cursor cursor3 = pVar2.f16062a;
                                    com.google.android.gms.dynamic.f.z3(null);
                                    synchronized (DynamiteModule.class) {
                                        boolValueOf = Boolean.valueOf(f16049k >= 2);
                                    }
                                    if (boolValueOf.booleanValue()) {
                                        Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                        dVarT6 = tVar.u6(com.google.android.gms.dynamic.f.z3(applicationContext), str, i7, com.google.android.gms.dynamic.f.z3(cursor3));
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                        dVarT6 = tVar.t6(com.google.android.gms.dynamic.f.z3(applicationContext), str, i7, com.google.android.gms.dynamic.f.z3(cursor3));
                                    }
                                    Context context2 = (Context) com.google.android.gms.dynamic.f.y0(dVarT6);
                                    if (context2 == null) {
                                        throw new a("Failed to get module context", null);
                                    }
                                    dynamiteModule = new DynamiteModule(context2);
                                } else {
                                    StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 51);
                                    sb4.append("Selected remote version of ");
                                    sb4.append(str);
                                    sb4.append(", version >= ");
                                    sb4.append(i7);
                                    Log.i("DynamiteModule", sb4.toString());
                                    sVarK = k(context);
                                    if (sVarK != null) {
                                        throw new a("Failed to create IDynamiteLoader.", null);
                                    }
                                    iC = sVarK.c();
                                    if (iC >= 3) {
                                        pVar = threadLocal.get();
                                        if (pVar != null) {
                                            throw new a("No cached result cursor holder", null);
                                        }
                                        dVarV6 = sVarK.w6(com.google.android.gms.dynamic.f.z3(context), str, i7, com.google.android.gms.dynamic.f.z3(pVar.f16062a));
                                    } else if (iC == 2) {
                                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                                        dVarV6 = sVarK.x6(com.google.android.gms.dynamic.f.z3(context), str, i7);
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                        dVarV6 = sVarK.v6(com.google.android.gms.dynamic.f.z3(context), str, i7);
                                    }
                                    if (com.google.android.gms.dynamic.f.y0(dVarV6) != null) {
                                        throw new a("Failed to load remote module.", null);
                                    }
                                    dynamiteModule = new DynamiteModule((Context) com.google.android.gms.dynamic.f.y0(dVarV6));
                                }
                                if (jLongValue == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(Long.valueOf(jLongValue));
                                }
                                cursor = pVar4.f16062a;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                threadLocal.set(pVar3);
                                return dynamiteModule;
                            } catch (RemoteException e8) {
                                throw new a("Failed to load remote module.", e8, null);
                            } catch (a e9) {
                                throw e9;
                            } catch (Throwable th) {
                                g1.i.a(context, th);
                                throw new a("Failed to load remote module.", th, null);
                            }
                        } catch (a e10) {
                            String strValueOf = String.valueOf(e10.getMessage());
                            Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to load remote module: ".concat(strValueOf) : new String("Failed to load remote module: "));
                            int i11 = c0186bA.f16057a;
                            if (i11 == 0 || bVar.a(context, str, new q(i11, 0)).f16059c != -1) {
                                throw new a("Remote load failed. No local fallback found.", e10, null);
                            }
                            DynamiteModule dynamiteModuleH2 = h(context, str);
                            if (jLongValue == 0) {
                                f16051m.remove();
                            } else {
                                f16051m.set(Long.valueOf(jLongValue));
                            }
                            Cursor cursor4 = pVar4.f16062a;
                            if (cursor4 != null) {
                                cursor4.close();
                            }
                            f16050l.set(pVar3);
                            return dynamiteModuleH2;
                        }
                    }
                } else if (c0186bA.f16057a != 0) {
                    i10 = -1;
                    if (i10 == 1) {
                    }
                    if (i10 == -1) {
                        DynamiteModule dynamiteModuleH3 = h(context, str);
                        if (jLongValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(jLongValue));
                        }
                        cursor2 = pVar4.f16062a;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        threadLocal.set(pVar3);
                        return dynamiteModuleH3;
                    }
                    if (i10 == 1) {
                        StringBuilder sb5 = new StringBuilder(47);
                        sb5.append("VersionPolicy returned invalid code:");
                        sb5.append(i10);
                        throw new a(sb5.toString(), null);
                    }
                    i7 = c0186bA.f16058b;
                    synchronized (DynamiteModule.class) {
                        bool = f16046h;
                        if (bool != null) {
                            throw new a("Failed to determine which loading route to use.", null);
                        }
                        if (bool.booleanValue()) {
                            StringBuilder sb6 = new StringBuilder(String.valueOf(str).length() + 51);
                            sb6.append("Selected remote version of ");
                            sb6.append(str);
                            sb6.append(", version >= ");
                            sb6.append(i7);
                            Log.i("DynamiteModule", sb6.toString());
                            synchronized (DynamiteModule.class) {
                                tVar = f16055q;
                                if (tVar != null) {
                                    throw new a("DynamiteLoaderV2 was not cached.", null);
                                }
                                pVar2 = threadLocal.get();
                                if (pVar2 != null) {
                                }
                                throw new a("No result cursor", null);
                            }
                        }
                        StringBuilder sb7 = new StringBuilder(String.valueOf(str).length() + 51);
                        sb7.append("Selected remote version of ");
                        sb7.append(str);
                        sb7.append(", version >= ");
                        sb7.append(i7);
                        Log.i("DynamiteModule", sb7.toString());
                        sVarK = k(context);
                        if (sVarK != null) {
                            throw new a("Failed to create IDynamiteLoader.", null);
                        }
                        iC = sVarK.c();
                        if (iC >= 3) {
                            pVar = threadLocal.get();
                            if (pVar != null) {
                                throw new a("No cached result cursor holder", null);
                            }
                            dVarV6 = sVarK.w6(com.google.android.gms.dynamic.f.z3(context), str, i7, com.google.android.gms.dynamic.f.z3(pVar.f16062a));
                        } else if (iC == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                            dVarV6 = sVarK.x6(com.google.android.gms.dynamic.f.z3(context), str, i7);
                        } else {
                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                            dVarV6 = sVarK.v6(com.google.android.gms.dynamic.f.z3(context), str, i7);
                        }
                        if (com.google.android.gms.dynamic.f.y0(dVarV6) != null) {
                            throw new a("Failed to load remote module.", null);
                        }
                        dynamiteModule = new DynamiteModule((Context) com.google.android.gms.dynamic.f.y0(dVarV6));
                        if (jLongValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(jLongValue));
                        }
                        cursor = pVar4.f16062a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(pVar3);
                        return dynamiteModule;
                    }
                }
            }
            int i12 = c0186bA.f16057a;
            int i13 = c0186bA.f16058b;
            StringBuilder sb8 = new StringBuilder(String.valueOf(str).length() + 92);
            sb8.append("No acceptable module ");
            sb8.append(str);
            sb8.append(" found. Local version is ");
            sb8.append(i12);
            sb8.append(" and remote version is ");
            sb8.append(i13);
            sb8.append(com.alibaba.android.arouter.utils.b.f12515h);
            throw new a(sb8.toString(), null);
        } catch (Throwable th2) {
            if (jLongValue == 0) {
                f16051m.remove();
            } else {
                f16051m.set(Long.valueOf(jLongValue));
            }
            Cursor cursor5 = pVar4.f16062a;
            if (cursor5 != null) {
                cursor5.close();
            }
            f16050l.set(pVar3);
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009d A[Catch: all -> 0x00a8, TryCatch #2 {, blocks: (B:9:0x0025, B:11:0x002d, B:13:0x0033, B:43:0x00a6, B:15:0x0037, B:16:0x003a, B:17:0x003d, B:19:0x0041, B:22:0x004a, B:24:0x0052, B:27:0x0059, B:34:0x0085, B:35:0x008d, B:30:0x0060, B:32:0x0066, B:33:0x0077, B:38:0x0090, B:41:0x0093, B:42:0x009d), top: B:129:0x0025, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0168 A[Catch: all -> 0x01c9, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x01c9, blocks: (B:3:0x0002, B:56:0x00d5, B:59:0x00dc, B:68:0x0102, B:90:0x015a, B:94:0x0168, B:119:0x01c2, B:120:0x01c5, B:114:0x01ba, B:62:0x00e2, B:64:0x00f4, B:66:0x00fe, B:65:0x00f9, B:123:0x01c8, B:4:0x0003, B:7:0x0008, B:8:0x0024, B:54:0x00d2, B:36:0x008e, B:39:0x0091, B:47:0x00aa, B:55:0x00d4, B:53:0x00b0), top: B:130:0x0002, inners: #0, #4 }] */
    public static int f(@m0 Context context, @m0 String str, boolean z7) {
        Throwable th;
        RemoteException e8;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f16046h;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader != null) {
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        i(classLoader);
                                    } catch (a unused) {
                                    }
                                    bool = Boolean.TRUE;
                                }
                            } else if (f16048j) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                Boolean bool2 = Boolean.TRUE;
                                if (bool2.equals(null)) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int iG = g(context, str, z7);
                                        String str2 = f16047i;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader classLoaderA = d.a();
                                            if (classLoaderA == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    com.google.android.gms.dynamite.b.a();
                                                    String str3 = f16047i;
                                                    u.k(str3);
                                                    classLoaderA = com.google.android.gms.dynamite.a.a(str3, ClassLoader.getSystemClassLoader());
                                                } else {
                                                    String str4 = f16047i;
                                                    u.k(str4);
                                                    classLoaderA = new e(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            i(classLoaderA);
                                            declaredField.set(null, classLoaderA);
                                            f16046h = bool2;
                                            return iG;
                                        }
                                        return iG;
                                    } catch (a unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                            f16046h = bool;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e9) {
                        String string = e9.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(string);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                }
                boolean zBooleanValue = bool.booleanValue();
                int iT6 = 0;
                if (zBooleanValue) {
                    try {
                        return g(context, str, z7);
                    } catch (a e10) {
                        String strValueOf = String.valueOf(e10.getMessage());
                        Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                s sVarK = k(context);
                try {
                    if (sVarK != null) {
                        try {
                            int iC = sVarK.c();
                            if (iC >= 3) {
                                p pVar = f16050l.get();
                                if (pVar == null || (cursor = pVar.f16062a) == null) {
                                    Cursor cursor3 = (Cursor) com.google.android.gms.dynamic.f.y0(sVarK.y6(com.google.android.gms.dynamic.f.z3(context), str, z7, f16051m.get().longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i7 = cursor3.getInt(0);
                                                cursor2 = (i7 <= 0 || !j(cursor3)) ? cursor3 : null;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                iT6 = i7;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                            }
                                        } catch (RemoteException e11) {
                                            e8 = e11;
                                            cursor2 = cursor3;
                                            String strValueOf2 = String.valueOf(e8.getMessage());
                                            Log.w("DynamiteModule", strValueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf2) : new String("Failed to retrieve remote module version: "));
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    }
                                } else {
                                    iT6 = cursor.getInt(0);
                                }
                            } else if (iC == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iT6 = sVarK.u6(com.google.android.gms.dynamic.f.z3(context), str, z7);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iT6 = sVarK.t6(com.google.android.gms.dynamic.f.z3(context), str, z7);
                            }
                        } catch (RemoteException e12) {
                            e8 = e12;
                        }
                    }
                    return iT6;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            g1.i.a(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private static int g(Context context, String str, boolean z7) throws Throwable {
        Throwable th;
        Exception e8;
        ?? r7 = 0;
        ?? r8 = 0;
        ?? r9 = 0;
        ?? r10 = 0;
        try {
            try {
                boolean z8 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z7 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(f16051m.get().longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z9 = false;
                            int i7 = cursorQuery.getInt(0);
                            if (i7 > 0) {
                                synchronized (DynamiteModule.class) {
                                    f16047i = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        f16049k = cursorQuery.getInt(columnIndex);
                                    }
                                    int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader");
                                    if (columnIndex2 >= 0) {
                                        if (cursorQuery.getInt(columnIndex2) == 0) {
                                            z8 = false;
                                        }
                                        f16048j = z8;
                                        z9 = z8;
                                    }
                                }
                                if (j(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z9) {
                                throw new a("forcing fallback to container DynamiteLoader impl", r9 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i7;
                        }
                    } catch (Exception e9) {
                        e8 = e9;
                        if (e8 instanceof a) {
                            throw e8;
                        }
                        throw new a("V2 version check failed", e8, r8 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new a("Failed to connect to dynamite module ContentResolver.", r10 == true ? 1 : 0);
            } catch (Throwable th2) {
                th = th2;
                r7 = context;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (Exception e10) {
            e8 = e10;
        } catch (Throwable th3) {
            th = th3;
            if (r7 != 0) {
                r7.close();
            }
            throw th;
        }
    }

    private static DynamiteModule h(Context context, String str) {
        String strValueOf = String.valueOf(str);
        Log.i("DynamiteModule", strValueOf.length() != 0 ? "Selected local version of ".concat(strValueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    @GuardedBy("DynamiteModule.class")
    private static void i(ClassLoader classLoader) throws a {
        t tVar;
        r rVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                tVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                tVar = iInterfaceQueryLocalInterface instanceof t ? (t) iInterfaceQueryLocalInterface : new t(iBinder);
            }
            f16055q = tVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e8) {
            throw new a("Failed to instantiate dynamite loader", e8, rVar);
        }
    }

    private static boolean j(Cursor cursor) {
        p pVar = f16050l.get();
        if (pVar == null || pVar.f16062a != null) {
            return false;
        }
        pVar.f16062a = cursor;
        return true;
    }

    @o0
    private static s k(Context context) {
        s sVar;
        synchronized (DynamiteModule.class) {
            s sVar2 = f16054p;
            if (sVar2 != null) {
                return sVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    sVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    sVar = iInterfaceQueryLocalInterface instanceof s ? (s) iInterfaceQueryLocalInterface : new s(iBinder);
                }
                if (sVar != null) {
                    f16054p = sVar;
                    return sVar;
                }
            } catch (Exception e8) {
                String strValueOf = String.valueOf(e8.getMessage());
                Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    @c1.a
    @m0
    public Context b() {
        return this.f16056a;
    }

    @c1.a
    @m0
    public IBinder d(@m0 String str) throws a {
        try {
            return (IBinder) this.f16056a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e8) {
            String strValueOf = String.valueOf(str);
            throw new a(strValueOf.length() != 0 ? "Failed to instantiate module class: ".concat(strValueOf) : new String("Failed to instantiate module class: "), e8, null);
        }
    }
}
