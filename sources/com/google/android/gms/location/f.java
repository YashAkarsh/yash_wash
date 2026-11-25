package com.google.android.gms.location;

import com.google.android.gms.internal.location.zzbe;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
public interface f {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f16338m0 = 1;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f16339n0 = 2;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f16340o0 = 4;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final long f16341p0 = -1;

    @g1.d0
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private double f16346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private double f16347f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f16348g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f16342a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c
        private int f16343b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f16344c = Long.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private short f16345d = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f16349h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f16350i = -1;

        @c.m0
        public f a() {
            String str = this.f16342a;
            if (str == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            int i7 = this.f16343b;
            if (i7 == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((i7 & 4) != 0 && this.f16350i < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            long j7 = this.f16344c;
            if (j7 == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.f16345d == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            int i8 = this.f16349h;
            if (i8 >= 0) {
                return new zzbe(str, i7, (short) 1, this.f16346e, this.f16347f, this.f16348g, j7, i8, this.f16350i);
            }
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        }

        @c.m0
        public a b(@c.v(from = -90.0d, to = 90.0d) double d8, @c.v(from = -180.0d, to = 180.0d) double d9, @c.v(from = 0.0d, fromInclusive = false) float f8) {
            boolean z7 = d8 >= -90.0d && d8 <= 90.0d;
            StringBuilder sb = new StringBuilder(42);
            sb.append("Invalid latitude: ");
            sb.append(d8);
            com.google.android.gms.common.internal.u.b(z7, sb.toString());
            boolean z8 = d9 >= -180.0d && d9 <= 180.0d;
            StringBuilder sb2 = new StringBuilder(43);
            sb2.append("Invalid longitude: ");
            sb2.append(d9);
            com.google.android.gms.common.internal.u.b(z8, sb2.toString());
            boolean z9 = f8 > 0.0f;
            StringBuilder sb3 = new StringBuilder(31);
            sb3.append("Invalid radius: ");
            sb3.append(f8);
            com.google.android.gms.common.internal.u.b(z9, sb3.toString());
            this.f16345d = (short) 1;
            this.f16346e = d8;
            this.f16347f = d9;
            this.f16348g = f8;
            return this;
        }

        @c.m0
        public a c(long j7) {
            if (j7 < 0) {
                this.f16344c = -1L;
            } else {
                this.f16344c = g1.k.e().d() + j7;
            }
            return this;
        }

        @c.m0
        public a d(int i7) {
            this.f16350i = i7;
            return this;
        }

        @c.m0
        public a e(@c.e0(from = 0) int i7) {
            this.f16349h = i7;
            return this;
        }

        @c.m0
        public a f(@c.m0 String str) {
            this.f16342a = (String) com.google.android.gms.common.internal.u.l(str, "Request ID can't be set to null");
            return this;
        }

        @c.m0
        public a g(@c int i7) {
            this.f16343b = i7;
            return this;
        }
    }

    public @interface b {
    }

    public @interface c {
    }

    @c.m0
    String u();
}
