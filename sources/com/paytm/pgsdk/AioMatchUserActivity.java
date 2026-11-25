package com.paytm.pgsdk;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import c.o0;

/* JADX INFO: loaded from: classes2.dex */
public class AioMatchUserActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f32925f = "check_user_login_only";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32926d = 12;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32927e = 13;

    private void a0() {
        if (!p.i(this)) {
            d0(false, false);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(s.f33093p, "net.one97.paytm.AJRUserLoggedInCheckActivity"));
            p.a("Launching Paytm App");
            startActivityForResult(intent, 13);
        } catch (ActivityNotFoundException e8) {
            p.k(e8);
            d0(false, false);
        } catch (Exception e9) {
            p.k(e9);
            d0(false, false);
        }
    }

    private boolean b0(Intent intent) {
        if (p.i(this)) {
            try {
                Intent intent2 = new Intent();
                intent2.putExtras(intent);
                intent2.setComponent(new ComponentName(s.f33093p, "net.one97.paytm.AJRUserPhoneMatchActivity"));
                p.a("Launching Paytm App");
                startActivityForResult(intent2, 12);
                return true;
            } catch (Exception e8) {
                p.k(e8);
            }
        }
        return false;
    }

    private void c0(boolean z7) {
        Intent intent = new Intent();
        intent.setAction(d.H);
        intent.putExtra(d.f32997J, z7);
        androidx.localbroadcastmanager.content.a.b(getApplicationContext()).d(intent);
        finish();
    }

    private void d0(boolean z7, boolean z8) {
        Intent intent = new Intent();
        intent.setAction(d.I);
        intent.putExtra(d.K, z8);
        intent.putExtra(d.L, z7);
        androidx.localbroadcastmanager.content.a.b(getApplicationContext()).d(intent);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, @o0 Intent intent) {
        super.onActivityResult(i7, i8, intent);
        boolean z7 = false;
        if (i7 == 12 && intent != null) {
            if (i8 == -1 && intent.getExtras() != null) {
                z7 = intent.getExtras().getBoolean("IF_USER_MATCHES", false);
            }
            c0(z7);
            return;
        }
        if (i7 != 13 || intent == null) {
            return;
        }
        if (i8 == -1 && intent.getExtras() != null) {
            z7 = intent.getExtras().getBoolean(d.K, false);
        }
        d0(true, z7);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@o0 Bundle bundle) {
        setTheme(R.style.TransparentActivityTheme);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (getIntent().getBooleanExtra(f32925f, false)) {
            a0();
        } else {
            if (b0(getIntent())) {
                return;
            }
            c0(false);
        }
    }
}
