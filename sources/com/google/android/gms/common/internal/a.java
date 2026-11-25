package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a extends m.a {
    @c.o0
    @c1.a
    public static Account y0(@c.m0 m mVar) {
        Account accountE = null;
        if (mVar != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    accountE = mVar.e();
                } catch (RemoteException unused) {
                    Log.w("AccountAccessor", "Remote account accessor probably died");
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return accountE;
    }

    @Override // com.google.android.gms.common.internal.m
    @c.m0
    public final Account e() {
        throw null;
    }

    public final boolean equals(@c.o0 Object obj) {
        throw null;
    }
}
