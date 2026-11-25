package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c.m0;
import com.alipay.sdk.util.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8443f = "LocalBroadcastManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f8444g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f8445h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f8446i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static a f8447j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f8449b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f8450c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<b> f8451d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f8452e;

    /* JADX INFO: renamed from: androidx.localbroadcastmanager.content.a$a, reason: collision with other inner class name */
    class HandlerC0108a extends Handler {
        HandlerC0108a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f8454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<c> f8455b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f8454a = intent;
            this.f8455b = arrayList;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f8456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f8457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f8458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f8459d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f8456a = intentFilter;
            this.f8457b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f8457b);
            sb.append(" filter=");
            sb.append(this.f8456a);
            if (this.f8459d) {
                sb.append(" DEAD");
            }
            sb.append(j.f13808d);
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f8448a = context;
        this.f8452e = new HandlerC0108a(context.getMainLooper());
    }

    @m0
    public static a b(@m0 Context context) {
        a aVar;
        synchronized (f8446i) {
            if (f8447j == null) {
                f8447j = new a(context.getApplicationContext());
            }
            aVar = f8447j;
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f8449b) {
                size = this.f8451d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f8451d.toArray(bVarArr);
                this.f8451d.clear();
            }
            for (int i7 = 0; i7 < size; i7++) {
                b bVar = bVarArr[i7];
                int size2 = bVar.f8455b.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    c cVar = bVar.f8455b.get(i8);
                    if (!cVar.f8459d) {
                        cVar.f8457b.onReceive(this.f8448a, bVar.f8454a);
                    }
                }
            }
        }
    }

    public void c(@m0 BroadcastReceiver broadcastReceiver, @m0 IntentFilter intentFilter) {
        synchronized (this.f8449b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f8449b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f8449b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i7 = 0; i7 < intentFilter.countActions(); i7++) {
                String action = intentFilter.getAction(i7);
                ArrayList<c> arrayList2 = this.f8450c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f8450c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(@m0 Intent intent) {
        int i7;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        String str3;
        synchronized (this.f8449b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f8448a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z7 = (intent.getFlags() & 8) != 0;
            if (z7) {
                Log.v(f8443f, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f8450c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z7) {
                    Log.v(f8443f, "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i8 = 0;
                while (i8 < arrayList3.size()) {
                    c cVar = arrayList3.get(i8);
                    if (z7) {
                        Log.v(f8443f, "Matching against filter " + cVar.f8456a);
                    }
                    if (cVar.f8458c) {
                        if (z7) {
                            Log.v(f8443f, "  Filter's target already added");
                        }
                        i7 = i8;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i7 = i8;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = cVar.f8456a.match(action, strResolveTypeIfNeeded, scheme, data, categories, f8443f);
                        if (iMatch >= 0) {
                            if (z7) {
                                Log.v(f8443f, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f8458c = true;
                        } else if (z7) {
                            if (iMatch == -4) {
                                str3 = "category";
                            } else if (iMatch == -3) {
                                str3 = "action";
                            } else if (iMatch != -2) {
                                str3 = iMatch != -1 ? "unknown reason" : "type";
                            } else {
                                str3 = "data";
                            }
                            Log.v(f8443f, "  Filter did not match: " + str3);
                        }
                        i8 = i7 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    arrayList4 = arrayList;
                    i8 = i7 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i9 = 0; i9 < arrayList5.size(); i9++) {
                        ((c) arrayList5.get(i9)).f8458c = false;
                    }
                    this.f8451d.add(new b(intent, arrayList5));
                    if (!this.f8452e.hasMessages(1)) {
                        this.f8452e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(@m0 Intent intent) {
        if (d(intent)) {
            a();
        }
    }

    public void f(@m0 BroadcastReceiver broadcastReceiver) {
        synchronized (this.f8449b) {
            ArrayList<c> arrayListRemove = this.f8449b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                c cVar = arrayListRemove.get(size);
                cVar.f8459d = true;
                for (int i7 = 0; i7 < cVar.f8456a.countActions(); i7++) {
                    String action = cVar.f8456a.getAction(i7);
                    ArrayList<c> arrayList = this.f8450c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f8457b == broadcastReceiver) {
                                cVar2.f8459d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f8450c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
