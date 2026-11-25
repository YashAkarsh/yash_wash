package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5412c = "NotifManCompat";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5413d = "checkOpNoThrow";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5414e = "OP_POST_NOTIFICATION";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5415f = "android.support.useSideChannel";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5416g = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f5417h = 19;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f5418i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f5419j = 6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f5420k = "enabled_notification_listeners";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.z("sEnabledNotificationListenersLock")
    private static String f5422m = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @c.z("sLock")
    private static d f5425p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5426q = -1000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5427r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f5428s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5429t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5430u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5431v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5432w = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NotificationManager f5434b;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Object f5421l = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @c.z("sEnabledNotificationListenersLock")
    private static Set<String> f5423n = new HashSet();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f5424o = new Object();

    private static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f5439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f5440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f5441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Notification f5442d;

        b(String str, int i7, String str2, Notification notification) {
            this.f5439a = str;
            this.f5440b = i7;
            this.f5441c = str2;
            this.f5442d = notification;
        }

        @Override // androidx.core.app.n5.e
        public void a(android.support.v4.app.a aVar) throws RemoteException {
            aVar.U5(this.f5439a, this.f5440b, this.f5441c, this.f5442d);
        }

        @c.m0
        public String toString() {
            return "NotifyTask[packageName:" + this.f5439a + ", id:" + this.f5440b + ", tag:" + this.f5441c + "]";
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ComponentName f5443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f5444b;

        c(ComponentName componentName, IBinder iBinder) {
            this.f5443a = componentName;
            this.f5444b = iBinder;
        }
    }

    private static class d implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f5445f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f5446g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f5447h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f5448i = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f5449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HandlerThread f5450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f5451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<ComponentName, a> f5452d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Set<String> f5453e = new HashSet();

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ComponentName f5454a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            android.support.v4.app.a f5456c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f5455b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            ArrayDeque<e> f5457d = new ArrayDeque<>();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f5458e = 0;

            a(ComponentName componentName) {
                this.f5454a = componentName;
            }
        }

        d(Context context) {
            this.f5449a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f5450b = handlerThread;
            handlerThread.start();
            this.f5451c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f5455b) {
                return true;
            }
            boolean zBindService = this.f5449a.bindService(new Intent(n5.f5416g).setComponent(aVar.f5454a), this, 33);
            aVar.f5455b = zBindService;
            if (zBindService) {
                aVar.f5458e = 0;
            } else {
                Log.w(n5.f5412c, "Unable to bind to listener " + aVar.f5454a);
                this.f5449a.unbindService(this);
            }
            return aVar.f5455b;
        }

        private void b(a aVar) {
            if (aVar.f5455b) {
                this.f5449a.unbindService(this);
                aVar.f5455b = false;
            }
            aVar.f5456c = null;
        }

        private void c(e eVar) {
            j();
            for (a aVar : this.f5452d.values()) {
                aVar.f5457d.add(eVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f5452d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f5452d.get(componentName);
            if (aVar != null) {
                aVar.f5456c = android.support.v4.app.a.b.i0(iBinder);
                aVar.f5458e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f5452d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable(n5.f5412c, 3)) {
                Log.d(n5.f5412c, "Processing component " + aVar.f5454a + ", " + aVar.f5457d.size() + " queued tasks");
            }
            if (aVar.f5457d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f5456c == null) {
                i(aVar);
                return;
            }
            while (true) {
                e eVarPeek = aVar.f5457d.peek();
                if (eVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable(n5.f5412c, 3)) {
                        Log.d(n5.f5412c, "Sending task " + eVarPeek);
                    }
                    eVarPeek.a(aVar.f5456c);
                    aVar.f5457d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable(n5.f5412c, 3)) {
                        Log.d(n5.f5412c, "Remote service has died: " + aVar.f5454a);
                    }
                } catch (RemoteException e8) {
                    Log.w(n5.f5412c, "RemoteException communicating with " + aVar.f5454a, e8);
                }
            }
            if (aVar.f5457d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        private void i(a aVar) {
            if (this.f5451c.hasMessages(3, aVar.f5454a)) {
                return;
            }
            int i7 = aVar.f5458e + 1;
            aVar.f5458e = i7;
            if (i7 <= 6) {
                int i8 = (1 << (i7 - 1)) * 1000;
                if (Log.isLoggable(n5.f5412c, 3)) {
                    Log.d(n5.f5412c, "Scheduling retry for " + i8 + " ms");
                }
                this.f5451c.sendMessageDelayed(this.f5451c.obtainMessage(3, aVar.f5454a), i8);
                return;
            }
            Log.w(n5.f5412c, "Giving up on delivering " + aVar.f5457d.size() + " tasks to " + aVar.f5454a + " after " + aVar.f5458e + " retries");
            aVar.f5457d.clear();
        }

        private void j() {
            Set<String> setQ = n5.q(this.f5449a);
            if (setQ.equals(this.f5453e)) {
                return;
            }
            this.f5453e = setQ;
            List<ResolveInfo> listQueryIntentServices = this.f5449a.getPackageManager().queryIntentServices(new Intent().setAction(n5.f5416g), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setQ.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w(n5.f5412c, "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f5452d.containsKey(componentName2)) {
                    if (Log.isLoggable(n5.f5412c, 3)) {
                        Log.d(n5.f5412c, "Adding listener record for " + componentName2);
                    }
                    this.f5452d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f5452d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable(n5.f5412c, 3)) {
                        Log.d(n5.f5412c, "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public void h(e eVar) {
            this.f5451c.obtainMessage(0, eVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                c((e) message.obj);
                return true;
            }
            if (i7 == 1) {
                c cVar = (c) message.obj;
                e(cVar.f5443a, cVar.f5444b);
                return true;
            }
            if (i7 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i7 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(n5.f5412c, 3)) {
                Log.d(n5.f5412c, "Connected to service " + componentName);
            }
            this.f5451c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(n5.f5412c, 3)) {
                Log.d(n5.f5412c, "Disconnected from service " + componentName);
            }
            this.f5451c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface e {
        void a(android.support.v4.app.a aVar) throws RemoteException;
    }

    private n5(Context context) {
        this.f5433a = context;
        this.f5434b = (NotificationManager) context.getSystemService("notification");
    }

    private void E(e eVar) {
        synchronized (f5424o) {
            if (f5425p == null) {
                f5425p = new d(this.f5433a.getApplicationContext());
            }
            f5425p.h(eVar);
        }
    }

    private static boolean F(Notification notification) {
        Bundle bundleN = l2.n(notification);
        return bundleN != null && bundleN.getBoolean(f5415f);
    }

    @c.m0
    public static n5 p(@c.m0 Context context) {
        return new n5(context);
    }

    @c.m0
    public static Set<String> q(@c.m0 Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), f5420k);
        synchronized (f5421l) {
            if (string != null) {
                if (!string.equals(f5422m)) {
                    String[] strArrSplit = string.split(":", -1);
                    HashSet hashSet = new HashSet(strArrSplit.length);
                    for (String str : strArrSplit) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    f5423n = hashSet;
                    f5422m = string;
                }
                set = f5423n;
            } else {
                set = f5423n;
            }
            throw th;
        }
        return set;
    }

    @c.m0
    public List<NotificationChannel> A() {
        return Build.VERSION.SDK_INT >= 26 ? this.f5434b.getNotificationChannels() : Collections.emptyList();
    }

    @c.m0
    public List<l1> B() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> listA = A();
            if (!listA.isEmpty()) {
                ArrayList arrayList = new ArrayList(listA.size());
                Iterator<NotificationChannel> it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new l1(s1.a(it.next())));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public void C(int i7, @c.m0 Notification notification) {
        D(null, i7, notification);
    }

    public void D(@c.o0 String str, int i7, @c.m0 Notification notification) {
        if (!F(notification)) {
            this.f5434b.notify(str, i7, notification);
        } else {
            E(new b(this.f5433a.getPackageName(), i7, str, notification));
            this.f5434b.cancel(str, i7);
        }
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f5434b.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f5433a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f5433a.getApplicationInfo();
        String packageName = this.f5433a.getApplicationContext().getPackageName();
        int i7 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod(f5413d, cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(f5414e).get(Integer.class)).intValue()), Integer.valueOf(i7), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(int i7) {
        c(null, i7);
    }

    public void c(@c.o0 String str, int i7) {
        this.f5434b.cancel(str, i7);
    }

    public void d() {
        this.f5434b.cancelAll();
    }

    public void e(@c.m0 NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5434b.createNotificationChannel(notificationChannel);
        }
    }

    public void f(@c.m0 l1 l1Var) {
        e(l1Var.m());
    }

    public void g(@c.m0 NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5434b.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void h(@c.m0 v1 v1Var) {
        g(v1Var.f());
    }

    public void i(@c.m0 List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5434b.createNotificationChannelGroups(list);
        }
    }

    public void j(@c.m0 List<v1> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<v1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f());
        }
        this.f5434b.createNotificationChannelGroups(arrayList);
    }

    public void k(@c.m0 List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5434b.createNotificationChannels(list);
        }
    }

    public void l(@c.m0 List<l1> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<l1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m());
        }
        this.f5434b.createNotificationChannels(arrayList);
    }

    public void m(@c.m0 String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5434b.deleteNotificationChannel(str);
        }
    }

    public void n(@c.m0 String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5434b.deleteNotificationChannelGroup(str);
        }
    }

    public void o(@c.m0 Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            Iterator it = this.f5434b.getNotificationChannels().iterator();
            while (it.hasNext()) {
                NotificationChannel notificationChannelA = s1.a(it.next());
                if (!collection.contains(notificationChannelA.getId()) && (Build.VERSION.SDK_INT < 30 || !collection.contains(notificationChannelA.getParentChannelId()))) {
                    this.f5434b.deleteNotificationChannel(notificationChannelA.getId());
                }
            }
        }
    }

    public int r() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f5434b.getImportance();
        }
        return -1000;
    }

    @c.o0
    public NotificationChannel s(@c.m0 String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f5434b.getNotificationChannel(str);
        }
        return null;
    }

    @c.o0
    public NotificationChannel t(@c.m0 String str, @c.m0 String str2) {
        return Build.VERSION.SDK_INT >= 30 ? this.f5434b.getNotificationChannel(str, str2) : s(str);
    }

    @c.o0
    public l1 u(@c.m0 String str) {
        NotificationChannel notificationChannelS;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannelS = s(str)) == null) {
            return null;
        }
        return new l1(notificationChannelS);
    }

    @c.o0
    public l1 v(@c.m0 String str, @c.m0 String str2) {
        NotificationChannel notificationChannelT;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannelT = t(str, str2)) == null) {
            return null;
        }
        return new l1(notificationChannelT);
    }

    @c.o0
    public NotificationChannelGroup w(@c.m0 String str) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            return this.f5434b.getNotificationChannelGroup(str);
        }
        if (i7 >= 26) {
            Iterator<NotificationChannelGroup> it = y().iterator();
            while (it.hasNext()) {
                NotificationChannelGroup notificationChannelGroupA = i5.a(it.next());
                if (notificationChannelGroupA.getId().equals(str)) {
                    return notificationChannelGroupA;
                }
            }
        }
        return null;
    }

    @c.o0
    public v1 x(@c.m0 String str) {
        NotificationChannelGroup notificationChannelGroupW;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            NotificationChannelGroup notificationChannelGroupW2 = w(str);
            if (notificationChannelGroupW2 != null) {
                return new v1(notificationChannelGroupW2);
            }
            return null;
        }
        if (i7 < 26 || (notificationChannelGroupW = w(str)) == null) {
            return null;
        }
        return new v1(notificationChannelGroupW, A());
    }

    @c.m0
    public List<NotificationChannelGroup> y() {
        return Build.VERSION.SDK_INT >= 26 ? this.f5434b.getNotificationChannelGroups() : Collections.emptyList();
    }

    @c.m0
    public List<v1> z() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 26) {
            List<NotificationChannelGroup> listY = y();
            if (!listY.isEmpty()) {
                List<NotificationChannel> listEmptyList = i7 >= 28 ? Collections.emptyList() : A();
                ArrayList arrayList = new ArrayList(listY.size());
                Iterator<NotificationChannelGroup> it = listY.iterator();
                while (it.hasNext()) {
                    NotificationChannelGroup notificationChannelGroupA = i5.a(it.next());
                    if (Build.VERSION.SDK_INT >= 28) {
                        arrayList.add(new v1(notificationChannelGroupA));
                    } else {
                        arrayList.add(new v1(notificationChannelGroupA, listEmptyList));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    private static class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f5435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f5436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f5437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f5438d;

        a(String str) {
            this.f5435a = str;
            this.f5436b = 0;
            this.f5437c = null;
            this.f5438d = true;
        }

        @Override // androidx.core.app.n5.e
        public void a(android.support.v4.app.a aVar) throws RemoteException {
            if (this.f5438d) {
                aVar.h2(this.f5435a);
            } else {
                aVar.i4(this.f5435a, this.f5436b, this.f5437c);
            }
        }

        @c.m0
        public String toString() {
            return "CancelTask[packageName:" + this.f5435a + ", id:" + this.f5436b + ", tag:" + this.f5437c + ", all:" + this.f5438d + "]";
        }

        a(String str, int i7, String str2) {
            this.f5435a = str;
            this.f5436b = i7;
            this.f5437c = str2;
            this.f5438d = false;
        }
    }
}
