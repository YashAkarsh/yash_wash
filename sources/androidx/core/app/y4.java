package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@c.t0(16)
class y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5570a = "NotificationCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f5571b = "android.support.dataRemoteInputs";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f5572c = "android.support.allowGeneratedReplies";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5573d = "icon";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5574e = "title";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5575f = "actionIntent";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5576g = "extras";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f5577h = "remoteInputs";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f5578i = "dataOnlyRemoteInputs";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f5579j = "resultKey";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f5580k = "label";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f5581l = "choices";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f5582m = "allowFreeFormInput";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f5583n = "allowedDataTypes";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f5584o = "semanticAction";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f5585p = "showsUserInterface";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static Field f5587r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static boolean f5588s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static Field f5590u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static Field f5591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static Field f5592w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static Field f5593x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static boolean f5594y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Object f5586q = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Object f5589t = new Object();

    private y4() {
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i7 = 0; i7 < size; i7++) {
            Bundle bundle = list.get(i7);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i7, bundle);
            }
        }
        return sparseArray;
    }

    private static boolean b() {
        if (f5594y) {
            return false;
        }
        try {
            if (f5590u == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                f5591v = cls.getDeclaredField(f5573d);
                f5592w = cls.getDeclaredField("title");
                f5593x = cls.getDeclaredField(f5575f);
                Field declaredField = Notification.class.getDeclaredField("actions");
                f5590u = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e8) {
            Log.e(f5570a, "Unable to access notification actions", e8);
            f5594y = true;
        } catch (NoSuchFieldException e9) {
            Log.e(f5570a, "Unable to access notification actions", e9);
            f5594y = true;
        }
        return !f5594y;
    }

    private static s6 c(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(f5583n);
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new s6(bundle.getString(f5579j), bundle.getCharSequence(f5580k), bundle.getCharSequenceArray(f5581l), bundle.getBoolean(f5582m), 0, bundle.getBundle(f5576g), hashSet);
    }

    private static s6[] d(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        s6[] s6VarArr = new s6[bundleArr.length];
        for (int i7 = 0; i7 < bundleArr.length; i7++) {
            s6VarArr[i7] = c(bundleArr[i7]);
        }
        return s6VarArr;
    }

    public static l2.b e(Notification notification, int i7) {
        SparseArray sparseParcelableArray;
        synchronized (f5589t) {
            try {
                try {
                    Object[] objArrH = h(notification);
                    if (objArrH != null) {
                        Object obj = objArrH[i7];
                        Bundle bundleK = k(notification);
                        return l(f5591v.getInt(obj), (CharSequence) f5592w.get(obj), (PendingIntent) f5593x.get(obj), (bundleK == null || (sparseParcelableArray = bundleK.getSparseParcelableArray(x4.f5538e)) == null) ? null : (Bundle) sparseParcelableArray.get(i7));
                    }
                } catch (IllegalAccessException e8) {
                    Log.e(f5570a, "Unable to access notification actions", e8);
                    f5594y = true;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int f(Notification notification) {
        int length;
        synchronized (f5589t) {
            Object[] objArrH = h(notification);
            length = objArrH != null ? objArrH.length : 0;
        }
        return length;
    }

    static l2.b g(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f5576g);
        return new l2.b(bundle.getInt(f5573d), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable(f5575f), bundle.getBundle(f5576g), d(i(bundle, f5577h)), d(i(bundle, f5578i)), bundle2 != null ? bundle2.getBoolean(f5572c, false) : false, bundle.getInt(f5584o), bundle.getBoolean(f5585p), false, false);
    }

    private static Object[] h(Notification notification) {
        synchronized (f5589t) {
            if (!b()) {
                return null;
            }
            try {
                return (Object[]) f5590u.get(notification);
            } catch (IllegalAccessException e8) {
                Log.e(f5570a, "Unable to access notification actions", e8);
                f5594y = true;
                return null;
            }
        }
    }

    private static Bundle[] i(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    static Bundle j(l2.b bVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatF = bVar.f();
        bundle.putInt(f5573d, iconCompatF != null ? iconCompatF.A() : 0);
        bundle.putCharSequence("title", bVar.j());
        bundle.putParcelable(f5575f, bVar.a());
        Bundle bundle2 = bVar.d() != null ? new Bundle(bVar.d()) : new Bundle();
        bundle2.putBoolean(f5572c, bVar.b());
        bundle.putBundle(f5576g, bundle2);
        bundle.putParcelableArray(f5577h, n(bVar.g()));
        bundle.putBoolean(f5585p, bVar.i());
        bundle.putInt(f5584o, bVar.h());
        return bundle;
    }

    public static Bundle k(Notification notification) {
        synchronized (f5586q) {
            if (f5588s) {
                return null;
            }
            try {
                if (f5587r == null) {
                    Field declaredField = Notification.class.getDeclaredField(f5576g);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(f5570a, "Notification.extras field is not of type Bundle");
                        f5588s = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f5587r = declaredField;
                }
                Bundle bundle = (Bundle) f5587r.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f5587r.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e8) {
                Log.e(f5570a, "Unable to access notification extras", e8);
                f5588s = true;
                return null;
            } catch (NoSuchFieldException e9) {
                Log.e(f5570a, "Unable to access notification extras", e9);
                f5588s = true;
                return null;
            }
        }
    }

    public static l2.b l(int i7, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        s6[] s6VarArrD;
        s6[] s6VarArrD2;
        boolean z7;
        if (bundle != null) {
            s6VarArrD = d(i(bundle, x4.f5539f));
            s6VarArrD2 = d(i(bundle, f5571b));
            z7 = bundle.getBoolean(f5572c);
        } else {
            s6VarArrD = null;
            s6VarArrD2 = null;
            z7 = false;
        }
        return new l2.b(i7, charSequence, pendingIntent, bundle, s6VarArrD, s6VarArrD2, z7, 0, true, false, false);
    }

    private static Bundle m(s6 s6Var) {
        Bundle bundle = new Bundle();
        bundle.putString(f5579j, s6Var.o());
        bundle.putCharSequence(f5580k, s6Var.n());
        bundle.putCharSequenceArray(f5581l, s6Var.h());
        bundle.putBoolean(f5582m, s6Var.f());
        bundle.putBundle(f5576g, s6Var.m());
        Set<String> setG = s6Var.g();
        if (setG != null && !setG.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setG.size());
            Iterator<String> it = setG.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList(f5583n, arrayList);
        }
        return bundle;
    }

    private static Bundle[] n(s6[] s6VarArr) {
        if (s6VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[s6VarArr.length];
        for (int i7 = 0; i7 < s6VarArr.length; i7++) {
            bundleArr[i7] = m(s6VarArr[i7]);
        }
        return bundleArr;
    }

    public static Bundle o(Notification.Builder builder, l2.b bVar) {
        IconCompat iconCompatF = bVar.f();
        builder.addAction(iconCompatF != null ? iconCompatF.A() : 0, bVar.j(), bVar.a());
        Bundle bundle = new Bundle(bVar.d());
        if (bVar.g() != null) {
            bundle.putParcelableArray(x4.f5539f, n(bVar.g()));
        }
        if (bVar.c() != null) {
            bundle.putParcelableArray(f5571b, n(bVar.c()));
        }
        bundle.putBoolean(f5572c, bVar.b());
        return bundle;
    }
}
