package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.m;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17208a;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    private class C0191b extends BottomSheetBehavior.g {
        private C0191b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@m0 View view, float f8) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@m0 View view, int i7) {
            if (i7 == 5) {
                b.this.D();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.f17208a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void E(@m0 BottomSheetBehavior<?> bottomSheetBehavior, boolean z7) {
        this.f17208a = z7;
        if (bottomSheetBehavior.o0() == 5) {
            D();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) getDialog()).u();
        }
        bottomSheetBehavior.U(new C0191b());
        bottomSheetBehavior.K0(5);
    }

    private boolean F(boolean z7) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof com.google.android.material.bottomsheet.a)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorR = aVar.r();
        if (!bottomSheetBehaviorR.t0() || !aVar.s()) {
            return false;
        }
        E(bottomSheetBehaviorR, z7);
        return true;
    }

    @Override // androidx.fragment.app.c
    public void dismiss() {
        if (F(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.c
    public void dismissAllowingStateLoss() {
        if (F(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.m, androidx.fragment.app.c
    @m0
    public Dialog onCreateDialog(@o0 Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(getContext(), getTheme());
    }
}
