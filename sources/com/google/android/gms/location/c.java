package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.google.android.gms.common.api.j<com.google.android.gms.common.api.a.d.C0181d> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f16328k = 0;

    public c(@c.m0 Activity activity) {
        super(activity, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, com.google.android.gms.common.api.j.a.f15488c);
    }

    @c.w0("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    @c.m0
    public com.google.android.gms.tasks.m<Void> A(@c.m0 final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(pendingIntent) { // from class: com.google.android.gms.location.u1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final PendingIntent f16413a;

            {
                this.f16413a = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).J0(this.f16413a, new x1((com.google.android.gms.tasks.n) obj2));
            }
        }).f(2406).a());
    }

    @c.w0("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    @c.m0
    public com.google.android.gms.tasks.m<Void> B(@c.m0 final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(pendingIntent) { // from class: com.google.android.gms.location.s1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final PendingIntent f16409a;

            {
                this.f16409a = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).K0(this.f16409a);
                ((com.google.android.gms.tasks.n) obj2).c(null);
            }
        }).f(2402).a());
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> C(@c.m0 final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(pendingIntent) { // from class: com.google.android.gms.location.v1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final PendingIntent f16417a;

            {
                this.f16417a = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).L0(this.f16417a, new x1((com.google.android.gms.tasks.n) obj2));
            }
        }).f(2411).a());
    }

    @c.w0("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    @c.m0
    public com.google.android.gms.tasks.m<Void> D(@c.m0 final ActivityTransitionRequest activityTransitionRequest, @c.m0 final PendingIntent pendingIntent) {
        activityTransitionRequest.K(r());
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(activityTransitionRequest, pendingIntent) { // from class: com.google.android.gms.location.t1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ActivityTransitionRequest f16410a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final PendingIntent f16411b;

            {
                this.f16410a = activityTransitionRequest;
                this.f16411b = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).I0(this.f16410a, this.f16411b, new x1((com.google.android.gms.tasks.n) obj2));
            }
        }).f(2405).a());
    }

    @c.w0("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    @c.m0
    public com.google.android.gms.tasks.m<Void> E(final long j7, @c.m0 final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(j7, pendingIntent) { // from class: com.google.android.gms.location.q1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f16403a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final PendingIntent f16404b;

            {
                this.f16403a = j7;
                this.f16404b = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).H0(this.f16403a, this.f16404b);
                ((com.google.android.gms.tasks.n) obj2).c(null);
            }
        }).f(2401).a());
    }

    @c.w0("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    @c.m0
    public com.google.android.gms.tasks.m<Void> F(@c.m0 final PendingIntent pendingIntent, @c.m0 final SleepSegmentRequest sleepSegmentRequest) {
        com.google.android.gms.common.internal.u.l(pendingIntent, "PendingIntent must be specified.");
        return i(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(this, pendingIntent, sleepSegmentRequest) { // from class: com.google.android.gms.location.r1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final c f16405a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final PendingIntent f16406b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final SleepSegmentRequest f16407c;

            {
                this.f16405a = this;
                this.f16406b = pendingIntent;
                this.f16407c = sleepSegmentRequest;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                c cVar = this.f16405a;
                ((com.google.android.gms.internal.location.m) ((com.google.android.gms.internal.location.z) obj).M()).c6(this.f16406b, this.f16407c, new w1(cVar, (com.google.android.gms.tasks.n) obj2));
            }
        }).e(h2.f16359b).f(2410).a());
    }

    public c(@c.m0 Context context) {
        super(context, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, com.google.android.gms.common.api.j.a.f15488c);
    }
}
