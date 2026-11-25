package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f12569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f12570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f12571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f12573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f12574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f12575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    e f12576i;

    e() {
    }

    boolean a(e eVar) {
        int i7 = this.f12569b;
        if (i7 != 1) {
            if (i7 != 15) {
                if (i7 == 12) {
                    return eVar.f12572e.equals(this.f12572e) && eVar.f12573f.equals(this.f12573f);
                }
                if (i7 != 13) {
                    switch (i7) {
                        case 3:
                        case 4:
                            return eVar.f12570c == this.f12570c;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return eVar.f12572e.equals(this.f12572e) && eVar.f12573f.equals(this.f12573f) && eVar.f12574g.equals(this.f12574g);
                    }
                }
            }
            return eVar.f12571d == this.f12571d;
        }
        return eVar.f12572e.equals(this.f12572e);
    }

    void b(int i7) {
        this.f12569b = 3;
        this.f12570c = i7;
        this.f12575h = (3 + i7) & Integer.MAX_VALUE;
    }

    void c(int i7, String str, String str2, String str3) {
        this.f12569b = i7;
        this.f12572e = str;
        this.f12573f = str2;
        this.f12574g = str3;
        if (i7 != 1 && i7 != 7 && i7 != 8) {
            if (i7 == 12) {
                this.f12575h = (i7 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i7 != 13) {
                this.f12575h = (i7 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.f12575h = (i7 + str.hashCode()) & Integer.MAX_VALUE;
    }

    e(int i7, e eVar) {
        this.f12568a = i7;
        this.f12569b = eVar.f12569b;
        this.f12570c = eVar.f12570c;
        this.f12571d = eVar.f12571d;
        this.f12572e = eVar.f12572e;
        this.f12573f = eVar.f12573f;
        this.f12574g = eVar.f12574g;
        this.f12575h = eVar.f12575h;
    }
}
