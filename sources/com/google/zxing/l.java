package com.google.zxing;

import com.google.zxing.oned.b0;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements v {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23743a;

        static {
            int[] iArr = new int[com.google.zxing.a.values().length];
            f23743a = iArr;
            try {
                iArr[com.google.zxing.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23743a[com.google.zxing.a.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23743a[com.google.zxing.a.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23743a[com.google.zxing.a.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23743a[com.google.zxing.a.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23743a[com.google.zxing.a.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23743a[com.google.zxing.a.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23743a[com.google.zxing.a.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23743a[com.google.zxing.a.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23743a[com.google.zxing.a.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23743a[com.google.zxing.a.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23743a[com.google.zxing.a.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23743a[com.google.zxing.a.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b a(String str, com.google.zxing.a aVar, int i7, int i8) throws w {
        return b(str, aVar, i7, i8, null);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<g, ?> map) throws w {
        v lVar;
        switch (a.f23743a[aVar.ordinal()]) {
            case 1:
                lVar = new com.google.zxing.oned.l();
                break;
            case 2:
                lVar = new b0();
                break;
            case 3:
                lVar = new com.google.zxing.oned.j();
                break;
            case 4:
                lVar = new com.google.zxing.oned.u();
                break;
            case 5:
                lVar = new com.google.zxing.qrcode.b();
                break;
            case 6:
                lVar = new com.google.zxing.oned.f();
                break;
            case 7:
                lVar = new com.google.zxing.oned.h();
                break;
            case 8:
                lVar = new com.google.zxing.oned.d();
                break;
            case 9:
                lVar = new com.google.zxing.oned.o();
                break;
            case 10:
                lVar = new e2.d();
                break;
            case 11:
                lVar = new com.google.zxing.oned.b();
                break;
            case 12:
                lVar = new b2.b();
                break;
            case 13:
                lVar = new z1.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
        }
        return lVar.b(str, aVar, i7, i8, map);
    }
}
