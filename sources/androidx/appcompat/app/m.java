package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import c.h0;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class m extends androidx.fragment.app.c {
    public m() {
    }

    @Override // androidx.fragment.app.c
    @m0
    public Dialog onCreateDialog(@o0 Bundle bundle) {
        return new l(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.c
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@m0 Dialog dialog, int i7) {
        if (!(dialog instanceof l)) {
            super.setupDialog(dialog, i7);
            return;
        }
        l lVar = (l) dialog;
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        lVar.i(1);
    }

    public m(@h0 int i7) {
        super(i7);
    }
}
