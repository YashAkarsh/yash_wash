package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.MessengerShareContentUtility;

/* JADX INFO: loaded from: classes.dex */
public abstract class n0 implements DialogInterface.OnClickListener {
    public static n0 b(Activity activity, @c.o0 Intent intent, int i7) {
        return new k0(intent, activity, i7);
    }

    public static n0 c(@c.m0 Fragment fragment, @c.o0 Intent intent, int i7) {
        return new l0(intent, fragment, i7);
    }

    public static n0 d(@c.m0 com.google.android.gms.common.api.internal.m mVar, @c.o0 Intent intent, int i7) {
        return new m0(intent, mVar, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i7) {
        try {
            a();
        } catch (ActivityNotFoundException e8) {
            Log.e("DialogRedirect", true == Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e8);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
