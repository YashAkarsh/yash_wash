package kotlin.math;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f34968a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public static final double f34969b = Math.log(2.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h5.e
    public static final double f34970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h5.e
    public static final double f34971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @h5.e
    public static final double f34972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @h5.e
    public static final double f34973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @h5.e
    public static final double f34974g;

    static {
        double dUlp = Math.ulp(1.0d);
        f34970c = dUlp;
        double dSqrt = Math.sqrt(dUlp);
        f34971d = dSqrt;
        double dSqrt2 = Math.sqrt(dSqrt);
        f34972e = dSqrt2;
        double d8 = 1;
        f34973f = d8 / dSqrt;
        f34974g = d8 / dSqrt2;
    }

    private a() {
    }
}
