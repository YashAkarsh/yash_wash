package com.haier.globalwasher.modle.enum_;

import c.a1;
import c.n;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    FREE(1, R.string.scan_qr_code_title, R.color.order_id_text),
    IN_USE_SUBSCRIBE(2, R.string.scan_qr_code_title, R.color.order_id_text),
    IN_USE_NOT_SUBSCRIBE(3, R.string.scan_qr_code_title, R.color.order_id_text),
    CAN_NOT_RUN(4, R.string.scan_qr_code_title, R.color.order_id_text),
    BLUR_TOOTH_MAKE_AN_APPOINTMENT(5, R.string.scan_qr_code_title, R.color.order_id_text);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f24416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a1
    int f24417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n
    int f24418c;

    a(int i7, int i8, int i9) {
        this.f24416a = i7;
        this.f24417b = i8;
        this.f24418c = i9;
    }

    public static a d(int i7) {
        for (a aVar : values()) {
            if (aVar.e() == i7) {
                return aVar;
            }
        }
        return CAN_NOT_RUN;
    }

    public int b() {
        return this.f24418c;
    }

    public int c() {
        return this.f24417b;
    }

    public int e() {
        return this.f24416a;
    }

    public void f(int i7) {
        this.f24418c = i7;
    }

    public void g(int i7) {
        this.f24417b = i7;
    }

    public void h(int i7) {
        this.f24416a = i7;
    }
}
