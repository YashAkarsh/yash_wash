package com.haier.globalwasher.mvp_api.volley;

/* JADX INFO: loaded from: classes2.dex */
public class d implements r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24821e = 2500;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24822f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f24823g = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f24827d;

    public d() {
        this(f24821e, 0, 1.0f);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.r
    public int a() {
        return this.f24824a;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.r
    public int b() {
        return this.f24825b;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.r
    public void c(u uVar) throws u {
        this.f24825b++;
        int i7 = this.f24824a;
        this.f24824a = (int) (i7 + (i7 * this.f24827d));
        if (!e()) {
            throw uVar;
        }
    }

    public float d() {
        return this.f24827d;
    }

    protected boolean e() {
        return this.f24825b <= this.f24826c;
    }

    public d(int i7, int i8, float f8) {
        this.f24824a = i7;
        this.f24826c = i8;
        this.f24827d = f8;
    }
}
