package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public final class q1 {

    @Deprecated
    public static final int A = 17;

    @Deprecated
    public static final int B = 18;

    @Deprecated
    public static final int C = 19;

    @Deprecated
    public static final int D = 20;

    @Deprecated
    public static final int E = 21;

    @Deprecated
    public static final int F = 22;

    @Deprecated
    public static final int G = 23;

    @Deprecated
    public static final int H = 24;

    @Deprecated
    public static final int I = 25;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f6804J = 26;
    public static final int K = 27;
    public static final int L = 28;

    @Deprecated
    public static final int M = 32;

    @Deprecated
    public static final int N = 33;

    @Deprecated
    public static final int O = 34;

    @Deprecated
    public static final int P = 35;

    @Deprecated
    public static final int Q = 36;

    @Deprecated
    public static final int R = 37;

    @Deprecated
    public static final int S = 38;

    @Deprecated
    public static final int T = 39;

    @Deprecated
    public static final int U = 40;

    @Deprecated
    public static final int V = 41;

    @Deprecated
    public static final int W = 42;

    @Deprecated
    public static final int X = 43;

    @Deprecated
    public static final int Y = 44;

    @Deprecated
    public static final int Z = 45;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f6805a = 255;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Deprecated
    public static final int f6806a0 = 46;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f6807b = 5;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Deprecated
    public static final int f6808b0 = 47;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f6809c = 6;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Deprecated
    public static final int f6810c0 = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f6811d = 7;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f6812e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f6813f = 65280;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final int f6814g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final int f6815h = 9;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final int f6816i = 10;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final int f6817j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Deprecated
    public static final int f6818k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final int f6819l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final int f6820m = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final int f6821n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final int f6822o = 5;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Deprecated
    public static final int f6823p = 6;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    public static final int f6824q = 7;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Deprecated
    public static final int f6825r = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Deprecated
    public static final int f6826s = 9;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Deprecated
    public static final int f6827t = 10;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Deprecated
    public static final int f6828u = 11;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Deprecated
    public static final int f6829v = 12;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Deprecated
    public static final int f6830w = 13;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Deprecated
    public static final int f6831x = 14;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Deprecated
    public static final int f6832y = 15;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Deprecated
    public static final int f6833z = 16;

    private q1() {
    }

    @Deprecated
    public static int a(MotionEvent motionEvent, int i7) {
        return motionEvent.findPointerIndex(i7);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int c(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static float d(MotionEvent motionEvent, int i7) {
        return motionEvent.getAxisValue(i7);
    }

    @Deprecated
    public static float e(MotionEvent motionEvent, int i7, int i8) {
        return motionEvent.getAxisValue(i7, i8);
    }

    @Deprecated
    public static int f(MotionEvent motionEvent) {
        return motionEvent.getButtonState();
    }

    @Deprecated
    public static int g(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    @Deprecated
    public static int h(MotionEvent motionEvent, int i7) {
        return motionEvent.getPointerId(i7);
    }

    @Deprecated
    public static int i(MotionEvent motionEvent) {
        return motionEvent.getSource();
    }

    @Deprecated
    public static float j(MotionEvent motionEvent, int i7) {
        return motionEvent.getX(i7);
    }

    @Deprecated
    public static float k(MotionEvent motionEvent, int i7) {
        return motionEvent.getY(i7);
    }

    public static boolean l(@c.m0 MotionEvent motionEvent, int i7) {
        return (motionEvent.getSource() & i7) == i7;
    }
}
