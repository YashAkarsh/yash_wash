package com.haier.globalwasher.modle.enum_;

import c.a1;
import c.n;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public enum c {
    SELF_CLOTHES("SELF_CLOTHES", R.string.Laundry_ticket_Laundry_coupon, R.color.app_white),
    SELF_DRY("SELF_DRY", R.string.Laundry_ticket_Drying_coupon, R.color.app_white),
    SELF_SHOES("SELF_SHOES", R.string.Laundry_ticket_Shoe_washing_coupon, R.color.app_white),
    SELF_COMMON("SELF_COMMON", R.string.Laundry_ticket_Universal_coupon, R.color.app_white);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f24427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a1
    int f24428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n
    int f24429c;

    c(String str, int i7, int i8) {
        this.f24427a = str;
        this.f24428b = i7;
        this.f24429c = i8;
    }

    public static c e(String str) {
        for (c cVar : values()) {
            if (cVar.b().equals(str)) {
                return cVar;
            }
        }
        return null;
    }

    public String b() {
        return this.f24427a;
    }

    public int c() {
        return this.f24429c;
    }

    public int d() {
        return this.f24428b;
    }
}
