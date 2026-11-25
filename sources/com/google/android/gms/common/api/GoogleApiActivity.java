package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import c.m0;
import c.o0;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g1.d0
    protected int f15060a = 0;

    @m0
    public static Intent a(@m0 Context context, @m0 PendingIntent pendingIntent, int i7, boolean z7) {
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i7);
        intent.putExtra("notify_manager", z7);
        return intent;
    }

    private final void b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent == null) {
            com.google.android.gms.common.g.x().B(this, ((Integer) com.google.android.gms.common.internal.u.k(num)).intValue(), 2, this);
            this.f15060a = 1;
            return;
        }
        try {
            startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
            this.f15060a = 1;
        } catch (ActivityNotFoundException e8) {
            if (extras.getBoolean("notify_manager", true)) {
                com.google.android.gms.common.api.internal.i.z(this).M(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
            } else {
                String string = pendingIntent.toString();
                StringBuilder sb = new StringBuilder(string.length() + 36);
                sb.append("Activity not found while launching ");
                sb.append(string);
                sb.append(com.alibaba.android.arouter.utils.b.f12515h);
                String string2 = sb.toString();
                if (Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                    string2 = string2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                }
                Log.e("GoogleApiActivity", string2, e8);
            }
            this.f15060a = 1;
            finish();
        } catch (IntentSender.SendIntentException e9) {
            Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e9);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i7, int i8, @m0 Intent intent) {
        super.onActivityResult(i7, i8, intent);
        if (i7 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f15060a = 0;
            setResult(i8, intent);
            if (booleanExtra) {
                com.google.android.gms.common.api.internal.i iVarZ = com.google.android.gms.common.api.internal.i.z(this);
                if (i8 == -1) {
                    iVarZ.b();
                } else if (i8 == 0) {
                    iVarZ.M(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i7 == 2) {
            this.f15060a = 0;
            setResult(i8, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(@m0 DialogInterface dialogInterface) {
        this.f15060a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f15060a = bundle.getInt("resolution");
        }
        if (this.f15060a != 1) {
            b();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(@m0 Bundle bundle) {
        bundle.putInt("resolution", this.f15060a);
        super.onSaveInstanceState(bundle);
    }
}
