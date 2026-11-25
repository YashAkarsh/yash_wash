package com.alipay.sdk.packet;

import com.alipay.sdk.encrypt.f;
import com.alipay.sdk.util.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13720b = o.e(24);

    public c(boolean z7) {
        this.f13719a = z7;
    }

    private static int a(String str) {
        return Integer.parseInt(str);
    }

    private static String d(int i7) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i7));
    }

    private static byte[] e(String str, String str2) {
        return com.alipay.sdk.encrypt.e.a(str, str2);
    }

    private static byte[] f(String str, byte[] bArr, String str2) {
        return f.b(str, bArr, str2);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    private static byte[] g(byte[]... bArr) throws Throwable {
        DataOutputStream dataOutputStream;
        ?? r7 = 0;
        byteArray = null;
        byte[] byteArray = null;
        if (bArr != null) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new ByteArrayOutputStream();
                        try {
                            dataOutputStream = new DataOutputStream(length);
                            try {
                                for (byte[] bArr2 : bArr) {
                                    dataOutputStream.write(d(bArr2.length).getBytes());
                                    dataOutputStream.write(bArr2);
                                }
                                dataOutputStream.flush();
                                byteArray = length.toByteArray();
                                try {
                                    length.close();
                                } catch (Exception unused) {
                                }
                            } catch (Exception e8) {
                                e = e8;
                                com.alipay.sdk.util.d.d(e);
                                if (length != 0) {
                                    try {
                                        length.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                if (dataOutputStream != null) {
                                }
                                return byteArray;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            dataOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            r7 = length;
                            if (r7 != 0) {
                                try {
                                    r7.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (r7 != 0) {
                                throw th;
                            }
                            try {
                                r7.close();
                                throw th;
                            } catch (Exception unused4) {
                                throw th;
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        length = 0;
                        dataOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r7 != 0) {
                            r7.close();
                        }
                        if (r7 != 0) {
                            throw th;
                        }
                        r7.close();
                        throw th;
                    }
                    try {
                        dataOutputStream.close();
                    } catch (Exception unused5) {
                    }
                    return byteArray;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    private static byte[] h(String str, byte[] bArr, String str2) {
        return f.d(str, bArr, str2);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0076: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:119), block:B:37:0x0076 */
    public b b(d dVar, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        ByteArrayInputStream byteArrayInputStream2;
        String str3;
        ByteArrayInputStream byteArrayInputStream3 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(dVar.b());
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str2 = new String(bArr2);
                    try {
                        byte[] bArr3 = new byte[5];
                        byteArrayInputStream.read(bArr3);
                        int iA = a(new String(bArr3));
                        if (iA > 0) {
                            byte[] bArrB = new byte[iA];
                            byteArrayInputStream.read(bArrB);
                            if (this.f13719a) {
                                bArrB = h(this.f13720b, bArrB, str);
                            }
                            if (dVar.a()) {
                                bArrB = com.alipay.sdk.encrypt.c.b(bArrB);
                            }
                            str3 = new String(bArrB);
                        } else {
                            str3 = null;
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e8) {
                        e = e8;
                        com.alipay.sdk.util.d.d(e);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        str3 = null;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str2 = null;
                }
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream3 = byteArrayInputStream2;
                if (byteArrayInputStream3 != null) {
                    try {
                        byteArrayInputStream3.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            byteArrayInputStream = null;
            str2 = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream3 != null) {
                byteArrayInputStream3.close();
            }
            throw th;
        }
        if (str2 == null && str3 == null) {
            return null;
        }
        return new b(str2, str3);
    }

    public d c(b bVar, boolean z7, String str) {
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.a().getBytes();
        byte[] bytes2 = bVar.b().getBytes();
        if (z7) {
            try {
                bytes2 = com.alipay.sdk.encrypt.c.a(bytes2);
            } catch (Exception unused) {
                z7 = false;
            }
        }
        return new d(z7, this.f13719a ? g(bytes, e(this.f13720b, j0.a.f34207c), f(this.f13720b, bytes2, str)) : g(bytes, bytes2));
    }
}
