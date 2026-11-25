package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
class w4 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Notification.Builder f5526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l2.g f5527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RemoteViews f5528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RemoteViews f5529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Bundle> f5530f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f5531g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RemoteViews f5533i;

    w4(l2.g gVar) {
        int i7;
        this.f5527c = gVar;
        this.f5525a = gVar.f5302a;
        if (Build.VERSION.SDK_INT >= 26) {
            m4.a();
            this.f5526b = l4.a(gVar.f5302a, gVar.L);
        } else {
            this.f5526b = new Notification.Builder(gVar.f5302a);
        }
        Notification notification = gVar.U;
        this.f5526b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, gVar.f5310i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(gVar.f5306e).setContentText(gVar.f5307f).setContentInfo(gVar.f5312k).setContentIntent(gVar.f5308g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(gVar.f5309h, (notification.flags & 128) != 0).setLargeIcon(gVar.f5311j).setNumber(gVar.f5313l).setProgress(gVar.f5322u, gVar.f5323v, gVar.f5324w);
        this.f5526b.setSubText(gVar.f5319r).setUsesChronometer(gVar.f5316o).setPriority(gVar.f5314m);
        Iterator<l2.b> it = gVar.f5303b.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        Bundle bundle = gVar.E;
        if (bundle != null) {
            this.f5531g.putAll(bundle);
        }
        int i8 = Build.VERSION.SDK_INT;
        this.f5528d = gVar.I;
        this.f5529e = gVar.f5301J;
        this.f5526b.setShowWhen(gVar.f5315n);
        this.f5526b.setLocalOnly(gVar.A).setGroup(gVar.f5325x).setGroupSummary(gVar.f5326y).setSortKey(gVar.f5327z);
        this.f5532h = gVar.Q;
        this.f5526b.setCategory(gVar.D).setColor(gVar.F).setVisibility(gVar.G).setPublicVersion(gVar.H).setSound(notification.sound, notification.audioAttributes);
        List listE = i8 < 28 ? e(g(gVar.f5304c), gVar.X) : gVar.X;
        if (listE != null && !listE.isEmpty()) {
            Iterator it2 = listE.iterator();
            while (it2.hasNext()) {
                this.f5526b.addPerson((String) it2.next());
            }
        }
        this.f5533i = gVar.K;
        if (gVar.f5305d.size() > 0) {
            Bundle bundle2 = gVar.t().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i9 = 0; i9 < gVar.f5305d.size(); i9++) {
                bundle4.putBundle(Integer.toString(i9), y4.j(gVar.f5305d.get(i9)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            gVar.t().putBundle("android.car.EXTENSIONS", bundle2);
            this.f5531g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i10 = Build.VERSION.SDK_INT;
        Icon icon = gVar.W;
        if (icon != null) {
            this.f5526b.setSmallIcon(icon);
        }
        if (i10 >= 24) {
            this.f5526b.setExtras(gVar.E).setRemoteInputHistory(gVar.f5321t);
            RemoteViews remoteViews = gVar.I;
            if (remoteViews != null) {
                this.f5526b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = gVar.f5301J;
            if (remoteViews2 != null) {
                this.f5526b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = gVar.K;
            if (remoteViews3 != null) {
                this.f5526b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i10 >= 26) {
            this.f5526b.setBadgeIconType(gVar.M).setSettingsText(gVar.f5320s).setShortcutId(gVar.N).setTimeoutAfter(gVar.P).setGroupAlertBehavior(gVar.Q);
            if (gVar.C) {
                this.f5526b.setColorized(gVar.B);
            }
            if (!TextUtils.isEmpty(gVar.L)) {
                this.f5526b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator<r5> it3 = gVar.f5304c.iterator();
            while (it3.hasNext()) {
                this.f5526b.addPerson(it3.next().k());
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            this.f5526b.setAllowSystemGeneratedContextualActions(gVar.S);
            this.f5526b.setBubbleMetadata(l2.f.k(gVar.T));
            androidx.core.content.p pVar = gVar.O;
            if (pVar != null) {
                this.f5526b.setLocusId(pVar.c());
            }
        }
        if (i11 >= 31 && (i7 = gVar.R) != 0) {
            this.f5526b.setForegroundServiceBehavior(i7);
        }
        if (gVar.V) {
            if (this.f5527c.f5326y) {
                this.f5532h = 2;
            } else {
                this.f5532h = 1;
            }
            this.f5526b.setVibrate(null);
            this.f5526b.setSound(null);
            int i12 = notification.defaults & (-2) & (-3);
            notification.defaults = i12;
            this.f5526b.setDefaults(i12);
            if (i11 >= 26) {
                if (TextUtils.isEmpty(this.f5527c.f5325x)) {
                    this.f5526b.setGroup(l2.P0);
                }
                this.f5526b.setGroupAlertBehavior(this.f5532h);
            }
        }
    }

    private void b(l2.b bVar) {
        IconCompat iconCompatF = bVar.f();
        Notification.Action.Builder builder = new Notification.Action.Builder(iconCompatF != null ? iconCompatF.L() : null, bVar.j(), bVar.a());
        if (bVar.g() != null) {
            for (RemoteInput remoteInput : s6.d(bVar.g())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = bVar.d() != null ? new Bundle(bVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", bVar.b());
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            builder.setAllowGeneratedReplies(bVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", bVar.h());
        if (i7 >= 28) {
            builder.setSemanticAction(bVar.h());
        }
        if (i7 >= 29) {
            builder.setContextual(bVar.l());
        }
        if (i7 >= 31) {
            builder.setAuthenticationRequired(bVar.k());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", bVar.i());
        builder.addExtras(bundle);
        this.f5526b.addAction(builder.build());
    }

    @c.o0
    private static List<String> e(@c.o0 List<String> list, @c.o0 List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.b bVar = new androidx.collection.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    @c.o0
    private static List<String> g(@c.o0 List<r5> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<r5> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().j());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    @Override // androidx.core.app.h0
    public Notification.Builder a() {
        return this.f5526b;
    }

    public Notification c() {
        Bundle bundleN;
        RemoteViews remoteViewsX;
        RemoteViews remoteViewsV;
        l2.q qVar = this.f5527c.f5318q;
        if (qVar != null) {
            qVar.b(this);
        }
        RemoteViews remoteViewsW = qVar != null ? qVar.w(this) : null;
        Notification notificationD = d();
        if (remoteViewsW != null) {
            notificationD.contentView = remoteViewsW;
        } else {
            RemoteViews remoteViews = this.f5527c.I;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (qVar != null && (remoteViewsV = qVar.v(this)) != null) {
            notificationD.bigContentView = remoteViewsV;
        }
        if (qVar != null && (remoteViewsX = this.f5527c.f5318q.x(this)) != null) {
            notificationD.headsUpContentView = remoteViewsX;
        }
        if (qVar != null && (bundleN = l2.n(notificationD)) != null) {
            qVar.a(bundleN);
        }
        return notificationD;
    }

    protected Notification d() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 26) {
            return this.f5526b.build();
        }
        if (i7 >= 24) {
            Notification notificationBuild = this.f5526b.build();
            if (this.f5532h != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f5532h == 2) {
                    h(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f5532h == 1) {
                    h(notificationBuild);
                }
            }
            return notificationBuild;
        }
        this.f5526b.setExtras(this.f5531g);
        Notification notificationBuild2 = this.f5526b.build();
        RemoteViews remoteViews = this.f5528d;
        if (remoteViews != null) {
            notificationBuild2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f5529e;
        if (remoteViews2 != null) {
            notificationBuild2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f5533i;
        if (remoteViews3 != null) {
            notificationBuild2.headsUpContentView = remoteViews3;
        }
        if (this.f5532h != 0) {
            if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.f5532h == 2) {
                h(notificationBuild2);
            }
            if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.f5532h == 1) {
                h(notificationBuild2);
            }
        }
        return notificationBuild2;
    }

    Context f() {
        return this.f5525a;
    }
}
