package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.api.Status;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@Deprecated
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f15281e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    @GuardedBy("sLock")
    private static j f15282f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private final String f15283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Status f15284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f15286d;

    @g1.d0
    @c1.a
    j(String str, boolean z7) {
        this.f15283a = str;
        this.f15284b = Status.f15063f;
        this.f15285c = z7;
        this.f15286d = !z7;
    }

    @c1.a
    private static j b(String str) {
        j jVar;
        synchronized (f15281e) {
            jVar = f15282f;
            if (jVar == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(com.alibaba.android.arouter.utils.b.f12515h);
                throw new IllegalStateException(sb.toString());
            }
        }
        return jVar;
    }

    @g1.d0
    @c1.a
    static void c() {
        synchronized (f15281e) {
            f15282f = null;
        }
    }

    @c.o0
    @c1.a
    public static String d() {
        return b("getGoogleAppId").f15283a;
    }

    @c1.a
    @c.m0
    public static Status e(@c.m0 Context context) {
        Status status;
        com.google.android.gms.common.internal.u.l(context, "Context must not be null.");
        synchronized (f15281e) {
            if (f15282f == null) {
                f15282f = new j(context);
            }
            status = f15282f.f15284b;
        }
        return status;
    }

    @c1.a
    @c.m0
    public static Status f(@c.m0 Context context, @c.m0 String str, boolean z7) {
        com.google.android.gms.common.internal.u.l(context, "Context must not be null.");
        com.google.android.gms.common.internal.u.h(str, "App ID must be nonempty.");
        synchronized (f15281e) {
            j jVar = f15282f;
            if (jVar != null) {
                return jVar.a(str);
            }
            j jVar2 = new j(str, z7);
            f15282f = jVar2;
            return jVar2.f15284b;
        }
    }

    @c1.a
    public static boolean g() {
        j jVarB = b("isMeasurementEnabled");
        return jVarB.f15284b.G0() && jVarB.f15285c;
    }

    @c1.a
    public static boolean h() {
        return b("isMeasurementExplicitlyDisabled").f15286d;
    }

    @g1.d0
    @c1.a
    Status a(String str) {
        String str2 = this.f15283a;
        if (str2 == null || str2.equals(str)) {
            return Status.f15063f;
        }
        String str3 = this.f15283a;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
        sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
        sb.append(str3);
        sb.append("'.");
        return new Status(10, sb.toString());
    }

    @g1.d0
    @c1.a
    j(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", androidx.constraintlayout.core.motion.utils.w.b.f3027b, resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z7 = true;
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z8 = integer == 0;
            z7 = integer != 0;
            this.f15286d = z8;
        } else {
            this.f15286d = false;
        }
        this.f15285c = z7;
        String strB = com.google.android.gms.common.internal.l1.b(context);
        strB = strB == null ? new com.google.android.gms.common.internal.z(context).a("google_app_id") : strB;
        if (TextUtils.isEmpty(strB)) {
            this.f15284b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f15283a = null;
        } else {
            this.f15283a = strB;
            this.f15284b = Status.f15063f;
        }
    }
}
