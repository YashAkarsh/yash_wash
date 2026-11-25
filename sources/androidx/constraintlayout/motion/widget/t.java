package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
public class t {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 1;
    public static final int I = 2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f4268J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;
    public static final int N = 4;
    public static final int O = 5;
    public static final int P = 6;
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    public static final int U = 4;
    public static final int V = 5;
    public static final int W = 6;
    public static final int X = 7;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f4269t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f4270u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f4271v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f4272w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f4273x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f4274y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f4275z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4276a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4277b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4278c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4279d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4280e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4281f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4282g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f4283h = 4.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f4284i = 1.2f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f4285j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f4286k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4287l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4288m = 10.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4289n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f4290o = 1.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f4291p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f4292q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f4293r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4294s = 0;

    public t A(boolean moveWhenScrollAtTop) {
        this.f4285j = moveWhenScrollAtTop;
        return this;
    }

    public t B(int flags) {
        this.f4287l = flags;
        return this;
    }

    public t C(int mode) {
        this.f4281f = mode;
        return this;
    }

    public t D(int rotationCenterId) {
        this.f4282g = rotationCenterId;
        return this;
    }

    public t E(int springBoundary) {
        this.f4293r = springBoundary;
        return this;
    }

    public t F(float springDamping) {
        this.f4289n = springDamping;
        return this;
    }

    public t G(float springMass) {
        this.f4290o = springMass;
        return this;
    }

    public t H(float springStiffness) {
        this.f4291p = springStiffness;
        return this;
    }

    public t I(float springStopThreshold) {
        this.f4292q = springStopThreshold;
        return this;
    }

    public t J(int side) {
        this.f4278c = side;
        return this;
    }

    public t K(int side) {
        this.f4277b = side;
        return this;
    }

    public t L(int side) {
        this.f4279d = side;
        return this;
    }

    public int a() {
        return this.f4294s;
    }

    public int b() {
        return this.f4276a;
    }

    public float c() {
        return this.f4286k;
    }

    public float d() {
        return this.f4288m;
    }

    public int e() {
        return this.f4280e;
    }

    public float f() {
        return this.f4284i;
    }

    public float g() {
        return this.f4283h;
    }

    public boolean h() {
        return this.f4285j;
    }

    public int i() {
        return this.f4287l;
    }

    public int j() {
        return this.f4281f;
    }

    public int k() {
        return this.f4282g;
    }

    public int l() {
        return this.f4293r;
    }

    public float m() {
        return this.f4289n;
    }

    public float n() {
        return this.f4290o;
    }

    public float o() {
        return this.f4291p;
    }

    public float p() {
        return this.f4292q;
    }

    public int q() {
        return this.f4278c;
    }

    public int r() {
        return this.f4277b;
    }

    public int s() {
        return this.f4279d;
    }

    public void t(int autoCompleteMode) {
        this.f4294s = autoCompleteMode;
    }

    public t u(int dragDirection) {
        this.f4276a = dragDirection;
        return this;
    }

    public t v(int dragScale) {
        this.f4286k = dragScale;
        return this;
    }

    public t w(int dragThreshold) {
        this.f4288m = dragThreshold;
        return this;
    }

    public t x(int id) {
        this.f4280e = id;
        return this;
    }

    public t y(int maxAcceleration) {
        this.f4284i = maxAcceleration;
        return this;
    }

    public t z(int maxVelocity) {
        this.f4283h = maxVelocity;
        return this;
    }
}
