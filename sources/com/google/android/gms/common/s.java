package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes.dex */
public class s extends androidx.fragment.app.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f15898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f15899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private Dialog f15900c;

    @c.m0
    public static s C(@c.m0 Dialog dialog) {
        return D(dialog, null);
    }

    @c.m0
    public static s D(@c.m0 Dialog dialog, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        s sVar = new s();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.u.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        sVar.f15898a = dialog2;
        if (onCancelListener != null) {
            sVar.f15899b = onCancelListener;
        }
        return sVar;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(@c.m0 DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f15899b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.c
    @c.m0
    public Dialog onCreateDialog(@c.o0 Bundle bundle) {
        Dialog dialog = this.f15898a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f15900c == null) {
            this.f15900c = new AlertDialog.Builder((Context) com.google.android.gms.common.internal.u.k(getContext())).create();
        }
        return this.f15900c;
    }

    @Override // androidx.fragment.app.c
    public void show(@c.m0 FragmentManager fragmentManager, @c.o0 String str) {
        super.show(fragmentManager, str);
    }
}
