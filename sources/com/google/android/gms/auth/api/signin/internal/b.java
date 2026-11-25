package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.m0;
import c.o0;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.u;
import g1.d0;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lock f14992c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    @GuardedBy("sLk")
    private static b f14993d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lock f14994a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("mLk")
    private final SharedPreferences f14995b;

    @d0
    b(Context context) {
        this.f14995b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @c1.a
    @m0
    public static b b(@m0 Context context) {
        u.k(context);
        f14992c.lock();
        try {
            if (f14993d == null) {
                f14993d = new b(context.getApplicationContext());
            }
            return f14993d;
        } finally {
            f14992c.unlock();
        }
    }

    private static final String k(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @c1.a
    public void a() {
        this.f14994a.lock();
        try {
            this.f14995b.edit().clear().apply();
        } finally {
            this.f14994a.unlock();
        }
    }

    @o0
    @c1.a
    public GoogleSignInAccount c() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(k("googleSignInAccount", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.a1(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    @o0
    @c1.a
    public GoogleSignInOptions d() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(k("googleSignInOptions", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.J0(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    @o0
    @c1.a
    public String e() {
        return g("refreshToken");
    }

    @c1.a
    public void f(@m0 GoogleSignInAccount googleSignInAccount, @m0 GoogleSignInOptions googleSignInOptions) {
        u.k(googleSignInAccount);
        u.k(googleSignInOptions);
        j("defaultGoogleSignInAccount", googleSignInAccount.d1());
        u.k(googleSignInAccount);
        u.k(googleSignInOptions);
        String strD1 = googleSignInAccount.d1();
        j(k("googleSignInAccount", strD1), googleSignInAccount.e1());
        j(k("googleSignInOptions", strD1), googleSignInOptions.V0());
    }

    @o0
    protected final String g(@m0 String str) {
        this.f14994a.lock();
        try {
            return this.f14995b.getString(str, null);
        } finally {
            this.f14994a.unlock();
        }
    }

    protected final void h(@m0 String str) {
        this.f14994a.lock();
        try {
            this.f14995b.edit().remove(str).apply();
        } finally {
            this.f14994a.unlock();
        }
    }

    public final void i() {
        String strG = g("defaultGoogleSignInAccount");
        h("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        h(k("googleSignInAccount", strG));
        h(k("googleSignInOptions", strG));
    }

    protected final void j(@m0 String str, @m0 String str2) {
        this.f14994a.lock();
        try {
            this.f14995b.edit().putString(str, str2).apply();
        } finally {
            this.f14994a.unlock();
        }
    }
}
