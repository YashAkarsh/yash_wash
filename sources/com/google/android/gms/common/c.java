package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class c extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f15523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f15524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private Dialog f15525c;

    @c.m0
    public static c a(@c.m0 Dialog dialog) {
        return b(dialog, null);
    }

    @c.m0
    public static c b(@c.m0 Dialog dialog, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        c cVar = new c();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.u.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        cVar.f15523a = dialog2;
        if (onCancelListener != null) {
            cVar.f15524b = onCancelListener;
        }
        return cVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@c.m0 DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f15524b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    @c.m0
    public Dialog onCreateDialog(@c.o0 Bundle bundle) {
        Dialog dialog = this.f15523a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f15525c == null) {
            this.f15525c = new AlertDialog.Builder((Context) com.google.android.gms.common.internal.u.k(getActivity())).create();
        }
        return this.f15525c;
    }

    @Override // android.app.DialogFragment
    public void show(@c.m0 FragmentManager fragmentManager, @c.o0 String str) {
        super.show(fragmentManager, str);
    }
}
