package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.l2;
import com.google.android.gms.common.internal.m2;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
abstract class f0 extends l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15567a;

    protected f0(byte[] bArr) {
        com.google.android.gms.common.internal.u.a(bArr.length == 25);
        this.f15567a = Arrays.hashCode(bArr);
    }

    protected static byte[] y0(String str) {
        try {
            return str.getBytes(CharEncoding.ISO_8859_1);
        } catch (UnsupportedEncodingException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // com.google.android.gms.common.internal.m2
    public final com.google.android.gms.dynamic.d a() {
        return com.google.android.gms.dynamic.f.z3(z3());
    }

    public final boolean equals(@c.o0 Object obj) {
        com.google.android.gms.dynamic.d dVarA;
        if (obj != null && (obj instanceof m2)) {
            try {
                m2 m2Var = (m2) obj;
                if (m2Var.t() == this.f15567a && (dVarA = m2Var.a()) != null) {
                    return Arrays.equals(z3(), (byte[]) com.google.android.gms.dynamic.f.y0(dVarA));
                }
                return false;
            } catch (RemoteException e8) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f15567a;
    }

    @Override // com.google.android.gms.common.internal.m2
    public final int t() {
        return this.f15567a;
    }

    abstract byte[] z3();
}
