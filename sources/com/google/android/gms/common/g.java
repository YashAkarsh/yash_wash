package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.b1;
import androidx.core.app.c1;
import androidx.core.app.l2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.b2;
import com.google.android.gms.common.api.internal.h2;
import com.google.android.gms.common.api.internal.zabx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c.m0
    public static final String f15569i = "com.google.android.gms";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.z("mLock")
    private String f15572g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f15570j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final g f15571k = new g();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f15568h = h.f15574a;

    @c.m0
    public static final com.google.android.gms.tasks.m<Map<com.google.android.gms.common.api.internal.c<?>, String>> M(@c.m0 com.google.android.gms.common.api.l<?> lVar, @c.m0 com.google.android.gms.common.api.l<?>... lVarArr) {
        com.google.android.gms.common.internal.u.l(lVar, "Requested API must not be null.");
        for (com.google.android.gms.common.api.l<?> lVar2 : lVarArr) {
            com.google.android.gms.common.internal.u.l(lVar2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(lVarArr.length + 1);
        arrayList.add(lVar);
        arrayList.addAll(Arrays.asList(lVarArr));
        return com.google.android.gms.common.api.internal.i.y().B(arrayList);
    }

    @c.m0
    public static g x() {
        return f15571k;
    }

    public boolean A(@c.m0 Activity activity, int i7, int i8) {
        return B(activity, i7, i8, null);
    }

    public boolean B(@c.m0 Activity activity, int i7, int i8, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogT = t(activity, i7, i8, onCancelListener);
        if (dialogT == null) {
            return false;
        }
        H(activity, dialogT, k.f15853k, onCancelListener);
        return true;
    }

    public void C(@c.m0 Context context, int i7) {
        I(context, i7, null, g(context, i7, 0, "n"));
    }

    public void D(@c.m0 Context context, @c.m0 ConnectionResult connectionResult) {
        I(context, connectionResult.K(), null, w(context, connectionResult));
    }

    @c.o0
    final Dialog E(@c.m0 Context context, int i7, com.google.android.gms.common.internal.n0 n0Var, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        if (i7 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.j0.d(context, i7));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strC = com.google.android.gms.common.internal.j0.c(context, i7);
        if (strC != null) {
            builder.setPositiveButton(strC, n0Var);
        }
        String strG = com.google.android.gms.common.internal.j0.g(context, i7);
        if (strG != null) {
            builder.setTitle(strG);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i7)), new IllegalArgumentException());
        return builder.create();
    }

    @c.m0
    public final Dialog F(@c.m0 Activity activity, @c.m0 DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.j0.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        H(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    @c.o0
    public final zabx G(Context context, b2 b2Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(b2Var);
        context.registerReceiver(zabxVar, intentFilter);
        zabxVar.a(context);
        if (n(context, "com.google.android.gms")) {
            return zabxVar;
        }
        b2Var.a();
        zabxVar.b();
        return null;
    }

    final void H(Activity activity, Dialog dialog, String str, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                s.D(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        c.b(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    final void I(Context context, int i7, @c.o0 String str, @c.o0 PendingIntent pendingIntent) {
        int i8;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i7), null), new IllegalArgumentException());
        if (i7 == 18) {
            J(context);
            return;
        }
        if (pendingIntent == null) {
            if (i7 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strF = com.google.android.gms.common.internal.j0.f(context, i7);
        String strE = com.google.android.gms.common.internal.j0.e(context, i7);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) com.google.android.gms.common.internal.u.k(context.getSystemService("notification"));
        l2.g gVarZ0 = new l2.g(context).e0(true).D(true).P(strF).z0(new l2.e().A(strE));
        if (g1.l.k(context)) {
            com.google.android.gms.common.internal.u.q(g1.v.i());
            gVarZ0.t0(context.getApplicationInfo().icon).k0(2);
            if (g1.l.l(context)) {
                gVarZ0.a(com.google.android.gms.base.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.string.common_open_on_phone), pendingIntent);
            } else {
                gVarZ0.N(pendingIntent);
            }
        } else {
            gVarZ0.t0(android.R.drawable.stat_sys_warning).B0(resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker)).H0(System.currentTimeMillis()).N(pendingIntent).O(strE);
        }
        if (g1.v.n()) {
            com.google.android.gms.common.internal.u.q(g1.v.n());
            synchronized (f15570j) {
                str2 = this.f15572g;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String strB = com.google.android.gms.common.internal.j0.b(context);
                if (notificationChannel == null) {
                    c1.a();
                    notificationManager.createNotificationChannel(b1.a("com.google.android.gms.availability", strB, 4));
                } else if (!strB.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(strB);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            gVarZ0.H(str2);
        }
        Notification notificationH = gVarZ0.h();
        if (i7 == 1 || i7 == 2 || i7 == 3) {
            l.f15863g.set(false);
            i8 = 10436;
        } else {
            i8 = 39789;
        }
        notificationManager.notify(i8, notificationH);
    }

    final void J(Context context) {
        new w(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean K(@c.m0 Activity activity, @c.m0 com.google.android.gms.common.api.internal.m mVar, int i7, int i8, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogE = E(activity, i7, com.google.android.gms.common.internal.n0.d(mVar, e(activity, i7, "d"), 2), onCancelListener);
        if (dialogE == null) {
            return false;
        }
        H(activity, dialogE, k.f15853k, onCancelListener);
        return true;
    }

    public final boolean L(@c.m0 Context context, @c.m0 ConnectionResult connectionResult, int i7) {
        PendingIntent pendingIntentW;
        if (com.google.android.gms.common.wrappers.a.a(context) || (pendingIntentW = w(context, connectionResult)) == null) {
            return false;
        }
        I(context, connectionResult.K(), null, com.google.android.gms.internal.base.k.a(context, 0, GoogleApiActivity.a(context, pendingIntentW, i7, true), com.google.android.gms.internal.base.k.f16088a | 134217728));
        return true;
    }

    @Override // com.google.android.gms.common.h
    @c1.a
    @com.google.android.gms.common.internal.y
    public int c(@c.m0 Context context) {
        return super.c(context);
    }

    @Override // com.google.android.gms.common.h
    @c.o0
    @c1.a
    @com.google.android.gms.common.internal.y
    public Intent e(@c.o0 Context context, int i7, @c.o0 String str) {
        return super.e(context, i7, str);
    }

    @Override // com.google.android.gms.common.h
    @c.o0
    public PendingIntent f(@c.m0 Context context, int i7, int i8) {
        return super.f(context, i7, i8);
    }

    @Override // com.google.android.gms.common.h
    @c.m0
    public final String h(int i7) {
        return super.h(i7);
    }

    @Override // com.google.android.gms.common.h
    @com.google.android.gms.common.internal.l
    public int j(@c.m0 Context context) {
        return super.j(context);
    }

    @Override // com.google.android.gms.common.h
    @c1.a
    @com.google.android.gms.common.internal.y
    public int k(@c.m0 Context context, int i7) {
        return super.k(context, i7);
    }

    @Override // com.google.android.gms.common.h
    public final boolean o(int i7) {
        return super.o(i7);
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> q(@c.m0 com.google.android.gms.common.api.j<?> jVar, @c.m0 com.google.android.gms.common.api.j<?>... jVarArr) {
        return M(jVar, jVarArr).w(new com.google.android.gms.tasks.l() { // from class: com.google.android.gms.common.v
            @Override // com.google.android.gms.tasks.l
            public final com.google.android.gms.tasks.m a(Object obj) {
                int i7 = g.f15568h;
                return com.google.android.gms.tasks.p.g(null);
            }
        });
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> r(@c.m0 com.google.android.gms.common.api.l<?> lVar, @c.m0 com.google.android.gms.common.api.l<?>... lVarArr) {
        return M(lVar, lVarArr).w(new com.google.android.gms.tasks.l() { // from class: com.google.android.gms.common.u
            @Override // com.google.android.gms.tasks.l
            public final com.google.android.gms.tasks.m a(Object obj) {
                int i7 = g.f15568h;
                return com.google.android.gms.tasks.p.g(null);
            }
        });
    }

    @c.o0
    public Dialog s(@c.m0 Activity activity, int i7, int i8) {
        return t(activity, i7, i8, null);
    }

    @c.o0
    public Dialog t(@c.m0 Activity activity, int i7, int i8, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        return E(activity, i7, com.google.android.gms.common.internal.n0.b(activity, e(activity, i7, "d"), i8), onCancelListener);
    }

    @c.o0
    public Dialog u(@c.m0 Fragment fragment, int i7, int i8) {
        return v(fragment, i7, i8, null);
    }

    @c.o0
    public Dialog v(@c.m0 Fragment fragment, int i7, int i8, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        return E(fragment.requireContext(), i7, com.google.android.gms.common.internal.n0.c(fragment, e(fragment.requireContext(), i7, "d"), i8), onCancelListener);
    }

    @c.o0
    public PendingIntent w(@c.m0 Context context, @c.m0 ConnectionResult connectionResult) {
        return connectionResult.r0() ? connectionResult.p0() : f(context, connectionResult.K(), 0);
    }

    @c.m0
    @c.j0
    public com.google.android.gms.tasks.m<Void> y(@c.m0 Activity activity) {
        int i7 = f15568h;
        com.google.android.gms.common.internal.u.f("makeGooglePlayServicesAvailable must be called from the main thread");
        int iK = k(activity, i7);
        if (iK == 0) {
            return com.google.android.gms.tasks.p.g(null);
        }
        h2 h2VarU = h2.u(activity);
        h2VarU.t(new ConnectionResult(iK, null), 0);
        return h2VarU.v();
    }

    @TargetApi(26)
    public void z(@c.m0 Context context, @c.m0 String str) {
        if (g1.v.n()) {
            com.google.android.gms.common.internal.u.k(((NotificationManager) com.google.android.gms.common.internal.u.k(context.getSystemService("notification"))).getNotificationChannel(str));
        }
        synchronized (f15570j) {
            this.f15572g = str;
        }
    }
}
