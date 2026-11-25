package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f5519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    CharSequence f5520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f5521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<l1> f5523e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final v1 f5524a;

        public a(@c.m0 String str) {
            this.f5524a = new v1(str);
        }

        @c.m0
        public v1 a() {
            return this.f5524a;
        }

        @c.m0
        public a b(@c.o0 String str) {
            this.f5524a.f5521c = str;
            return this;
        }

        @c.m0
        public a c(@c.o0 CharSequence charSequence) {
            this.f5524a.f5520b = charSequence;
            return this;
        }
    }

    v1(@c.m0 String str) {
        this.f5523e = Collections.emptyList();
        this.f5519a = (String) androidx.core.util.w.l(str);
    }

    @c.t0(26)
    private List<l1> b(List<NotificationChannel> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<NotificationChannel> it = list.iterator();
        while (it.hasNext()) {
            NotificationChannel notificationChannelA = s1.a(it.next());
            if (this.f5519a.equals(notificationChannelA.getGroup())) {
                arrayList.add(new l1(notificationChannelA));
            }
        }
        return arrayList;
    }

    @c.m0
    public List<l1> a() {
        return this.f5523e;
    }

    @c.o0
    public String c() {
        return this.f5521c;
    }

    @c.m0
    public String d() {
        return this.f5519a;
    }

    @c.o0
    public CharSequence e() {
        return this.f5520b;
    }

    NotificationChannelGroup f() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 26) {
            return null;
        }
        u1.a();
        NotificationChannelGroup notificationChannelGroupA = t1.a(this.f5519a, this.f5520b);
        if (i7 >= 28) {
            notificationChannelGroupA.setDescription(this.f5521c);
        }
        return notificationChannelGroupA;
    }

    public boolean g() {
        return this.f5522d;
    }

    @c.m0
    public a h() {
        return new a(this.f5519a).c(this.f5520b).b(this.f5521c);
    }

    @c.t0(28)
    v1(@c.m0 NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    @c.t0(26)
    v1(@c.m0 NotificationChannelGroup notificationChannelGroup, @c.m0 List<NotificationChannel> list) {
        this(notificationChannelGroup.getId());
        this.f5520b = notificationChannelGroup.getName();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            this.f5521c = notificationChannelGroup.getDescription();
        }
        if (i7 >= 28) {
            this.f5522d = notificationChannelGroup.isBlocked();
            this.f5523e = b(notificationChannelGroup.getChannels());
        } else {
            this.f5523e = b(list);
        }
    }
}
