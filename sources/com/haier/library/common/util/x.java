package com.haier.library.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f26620f = "LocalBroadcastManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f26621g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f26622h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f26623i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static x f26624j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f26625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f26626b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f26627c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<b> f26628d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f26629e;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                x.this.b();
            }
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f26631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<c> f26632b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f26631a = intent;
            this.f26632b = arrayList;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f26633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f26634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f26635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f26636d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f26633a = intentFilter;
            this.f26634b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f26634b);
            sb.append(" filter=");
            sb.append(this.f26633a);
            if (this.f26636d) {
                sb.append(" DEAD");
            }
            sb.append(com.alipay.sdk.util.j.f13808d);
            return sb.toString();
        }
    }

    private x(Context context) {
        this.f26625a = context;
        this.f26629e = new a(context.getMainLooper());
    }

    public static x a(Context context) {
        x xVar;
        synchronized (f26623i) {
            if (f26624j == null) {
                f26624j = new x(context.getApplicationContext());
            }
            xVar = f26624j;
        }
        return xVar;
    }

    void b() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f26626b) {
                size = this.f26628d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f26628d.toArray(bVarArr);
                this.f26628d.clear();
            }
            for (int i7 = 0; i7 < size; i7++) {
                b bVar = bVarArr[i7];
                int size2 = bVar.f26632b.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    c cVar = bVar.f26632b.get(i8);
                    if (!cVar.f26636d) {
                        cVar.f26634b.onReceive(this.f26625a, bVar.f26631a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f26626b) {
            ArrayList<c> arrayListRemove = this.f26626b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                c cVar = arrayListRemove.get(size);
                cVar.f26636d = true;
                for (int i7 = 0; i7 < cVar.f26633a.countActions(); i7++) {
                    String action = cVar.f26633a.getAction(i7);
                    ArrayList<c> arrayList = this.f26627c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f26634b == broadcastReceiver) {
                                cVar2.f26636d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f26627c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public void d(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f26626b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f26626b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f26626b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i7 = 0; i7 < intentFilter.countActions(); i7++) {
                String action = intentFilter.getAction(i7);
                ArrayList<c> arrayList2 = this.f26627c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f26627c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean e(Intent intent) {
        int i7;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        String str3;
        synchronized (this.f26626b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f26625a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z7 = (intent.getFlags() & 8) != 0;
            if (z7) {
                Log.v(f26620f, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f26627c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z7) {
                    Log.v(f26620f, "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i8 = 0;
                while (i8 < arrayList3.size()) {
                    c cVar = arrayList3.get(i8);
                    if (z7) {
                        Log.v(f26620f, "Matching against filter " + cVar.f26633a);
                    }
                    if (cVar.f26635c) {
                        if (z7) {
                            Log.v(f26620f, "  Filter's target already added");
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
                        int iMatch = cVar.f26633a.match(action, strResolveTypeIfNeeded, scheme, data, categories, f26620f);
                        if (iMatch >= 0) {
                            if (z7) {
                                Log.v(f26620f, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f26635c = true;
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
                            Log.v(f26620f, "  Filter did not match: " + str3);
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
                        ((c) arrayList5.get(i9)).f26635c = false;
                    }
                    this.f26628d.add(new b(intent, arrayList5));
                    if (!this.f26629e.hasMessages(1)) {
                        this.f26629e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void f(Intent intent) {
        if (e(intent)) {
            b();
        }
    }
}
