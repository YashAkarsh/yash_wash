package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class d1 extends com.google.android.gms.dynamic.h<t0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d1 f15676c = new d1();

    private d1() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View c(Context context, int i7, int i8) throws com.google.android.gms.dynamic.h.a {
        d1 d1Var = f15676c;
        try {
            zax zaxVar = new zax(1, i7, i8, null);
            return (View) com.google.android.gms.dynamic.f.y0(d1Var.b(context).t6(com.google.android.gms.dynamic.f.z3(context), zaxVar));
        } catch (Exception e8) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i7);
            sb.append(" and color ");
            sb.append(i8);
            throw new com.google.android.gms.dynamic.h.a(sb.toString(), e8);
        }
    }

    @Override // com.google.android.gms.dynamic.h
    public final /* synthetic */ t0 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof t0 ? (t0) iInterfaceQueryLocalInterface : new t0(iBinder);
    }
}
