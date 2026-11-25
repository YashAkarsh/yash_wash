package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.h0;
import androidx.core.app.l2;
import androidx.media.R;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public static class a extends b {
        private void L(RemoteViews remoteViews) {
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", this.f5381a.r() != 0 ? this.f5381a.r() : this.f5381a.f5302a.getResources().getColor(R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media.app.c.b
        int E(int i7) {
            return i7 <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.c.b
        int F() {
            return this.f5381a.s() != null ? R.layout.notification_template_media_custom : super.F();
        }

        @Override // androidx.media.app.c.b, androidx.core.app.l2.q
        @x0({x0.a.LIBRARY_GROUP})
        public void b(h0 h0Var) {
            if (Build.VERSION.SDK_INT < 24) {
                super.b(h0Var);
                return;
            }
            Notification.Builder builderA = h0Var.a();
            androidx.media.app.b.a();
            builderA.setStyle(A(androidx.media.app.a.a()));
        }

        @Override // androidx.media.app.c.b, androidx.core.app.l2.q
        @x0({x0.a.LIBRARY_GROUP})
        public RemoteViews v(h0 h0Var) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsP = this.f5381a.p() != null ? this.f5381a.p() : this.f5381a.s();
            if (remoteViewsP == null) {
                return null;
            }
            RemoteViews remoteViewsB = B();
            e(remoteViewsB, remoteViewsP);
            L(remoteViewsB);
            return remoteViewsB;
        }

        @Override // androidx.media.app.c.b, androidx.core.app.l2.q
        @x0({x0.a.LIBRARY_GROUP})
        public RemoteViews w(h0 h0Var) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z7 = true;
            boolean z8 = this.f5381a.s() != null;
            if (!z8 && this.f5381a.p() == null) {
                z7 = false;
            }
            if (!z7) {
                return null;
            }
            RemoteViews remoteViewsC = C();
            if (z8) {
                e(remoteViewsC, this.f5381a.s());
            }
            L(remoteViewsC);
            return remoteViewsC;
        }

        @Override // androidx.core.app.l2.q
        @x0({x0.a.LIBRARY_GROUP})
        public RemoteViews x(h0 h0Var) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsW = this.f5381a.w() != null ? this.f5381a.w() : this.f5381a.s();
            if (remoteViewsW == null) {
                return null;
            }
            RemoteViews remoteViewsB = B();
            e(remoteViewsB, remoteViewsW);
            L(remoteViewsB);
            return remoteViewsB;
        }
    }

    private c() {
    }

    public static class b extends l2.q {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f8629i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f8630j = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f8631e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        MediaSessionCompat.Token f8632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f8633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PendingIntent f8634h;

        public b() {
        }

        private RemoteViews D(l2.b bVar) {
            boolean z7 = bVar.a() == null;
            RemoteViews remoteViews = new RemoteViews(this.f5381a.f5302a.getPackageName(), R.layout.notification_media_action);
            remoteViews.setImageViewResource(R.id.action0, bVar.e());
            if (!z7) {
                remoteViews.setOnClickPendingIntent(R.id.action0, bVar.a());
            }
            remoteViews.setContentDescription(R.id.action0, bVar.j());
            return remoteViews;
        }

        public static MediaSessionCompat.Token G(Notification notification) {
            Parcelable parcelable;
            Bundle bundleN = l2.n(notification);
            if (bundleN == null || (parcelable = bundleN.getParcelable(l2.f5180b0)) == null) {
                return null;
            }
            return MediaSessionCompat.Token.b(parcelable);
        }

        @t0(21)
        Notification.MediaStyle A(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.f8631e;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.f8632f;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.g());
            }
            return mediaStyle;
        }

        RemoteViews B() {
            int iMin = Math.min(this.f5381a.f5303b.size(), 5);
            RemoteViews remoteViewsC = c(false, E(iMin), false);
            remoteViewsC.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i7 = 0; i7 < iMin; i7++) {
                    remoteViewsC.addView(R.id.media_actions, D(this.f5381a.f5303b.get(i7)));
                }
            }
            if (this.f8633g) {
                remoteViewsC.setViewVisibility(R.id.cancel_action, 0);
                remoteViewsC.setInt(R.id.cancel_action, "setAlpha", this.f5381a.f5302a.getResources().getInteger(R.integer.cancel_button_image_alpha));
                remoteViewsC.setOnClickPendingIntent(R.id.cancel_action, this.f8634h);
            } else {
                remoteViewsC.setViewVisibility(R.id.cancel_action, 8);
            }
            return remoteViewsC;
        }

        RemoteViews C() {
            RemoteViews remoteViewsC = c(false, F(), true);
            int size = this.f5381a.f5303b.size();
            int[] iArr = this.f8631e;
            int iMin = iArr == null ? 0 : Math.min(iArr.length, 3);
            remoteViewsC.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i7 = 0; i7 < iMin; i7++) {
                    if (i7 >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i7), Integer.valueOf(size - 1)));
                    }
                    remoteViewsC.addView(R.id.media_actions, D(this.f5381a.f5303b.get(this.f8631e[i7])));
                }
            }
            if (this.f8633g) {
                remoteViewsC.setViewVisibility(R.id.end_padder, 8);
                remoteViewsC.setViewVisibility(R.id.cancel_action, 0);
                remoteViewsC.setOnClickPendingIntent(R.id.cancel_action, this.f8634h);
                remoteViewsC.setInt(R.id.cancel_action, "setAlpha", this.f5381a.f5302a.getResources().getInteger(R.integer.cancel_button_image_alpha));
            } else {
                remoteViewsC.setViewVisibility(R.id.end_padder, 0);
                remoteViewsC.setViewVisibility(R.id.cancel_action, 8);
            }
            return remoteViewsC;
        }

        int E(int i7) {
            return i7 <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }

        int F() {
            return R.layout.notification_template_media;
        }

        public b H(PendingIntent pendingIntent) {
            this.f8634h = pendingIntent;
            return this;
        }

        public b I(MediaSessionCompat.Token token) {
            this.f8632f = token;
            return this;
        }

        public b J(int... iArr) {
            this.f8631e = iArr;
            return this;
        }

        public b K(boolean z7) {
            return this;
        }

        @Override // androidx.core.app.l2.q
        @x0({x0.a.LIBRARY_GROUP})
        public void b(h0 h0Var) {
            h0Var.a().setStyle(A(new Notification.MediaStyle()));
        }

        @Override // androidx.core.app.l2.q
        @x0({x0.a.LIBRARY_GROUP})
        public RemoteViews v(h0 h0Var) {
            return null;
        }

        @Override // androidx.core.app.l2.q
        @x0({x0.a.LIBRARY_GROUP})
        public RemoteViews w(h0 h0Var) {
            return null;
        }

        public b(l2.g gVar) {
            z(gVar);
        }
    }
}
