package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class l1 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f5154s = "miscellaneous";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final boolean f5155t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f5156u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    final String f5157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    CharSequence f5158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f5160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f5161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f5162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Uri f5163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    AudioAttributes f5164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f5165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f5166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f5167k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long[] f5168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f5169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String f5170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f5171o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f5172p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f5173q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f5174r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l1 f5175a;

        public a(@c.m0 String str, int i7) {
            this.f5175a = new l1(str, i7);
        }

        @c.m0
        public l1 a() {
            return this.f5175a;
        }

        @c.m0
        public a b(@c.m0 String str, @c.m0 String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                l1 l1Var = this.f5175a;
                l1Var.f5169m = str;
                l1Var.f5170n = str2;
            }
            return this;
        }

        @c.m0
        public a c(@c.o0 String str) {
            this.f5175a.f5160d = str;
            return this;
        }

        @c.m0
        public a d(@c.o0 String str) {
            this.f5175a.f5161e = str;
            return this;
        }

        @c.m0
        public a e(int i7) {
            this.f5175a.f5159c = i7;
            return this;
        }

        @c.m0
        public a f(int i7) {
            this.f5175a.f5166j = i7;
            return this;
        }

        @c.m0
        public a g(boolean z7) {
            this.f5175a.f5165i = z7;
            return this;
        }

        @c.m0
        public a h(@c.o0 CharSequence charSequence) {
            this.f5175a.f5158b = charSequence;
            return this;
        }

        @c.m0
        public a i(boolean z7) {
            this.f5175a.f5162f = z7;
            return this;
        }

        @c.m0
        public a j(@c.o0 Uri uri, @c.o0 AudioAttributes audioAttributes) {
            l1 l1Var = this.f5175a;
            l1Var.f5163g = uri;
            l1Var.f5164h = audioAttributes;
            return this;
        }

        @c.m0
        public a k(boolean z7) {
            this.f5175a.f5167k = z7;
            return this;
        }

        @c.m0
        public a l(@c.o0 long[] jArr) {
            l1 l1Var = this.f5175a;
            l1Var.f5167k = jArr != null && jArr.length > 0;
            l1Var.f5168l = jArr;
            return this;
        }
    }

    l1(@c.m0 String str, int i7) {
        this.f5162f = true;
        this.f5163g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.f5166j = 0;
        this.f5157a = (String) androidx.core.util.w.l(str);
        this.f5159c = i7;
        this.f5164h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean a() {
        return this.f5173q;
    }

    public boolean b() {
        return this.f5171o;
    }

    public boolean c() {
        return this.f5162f;
    }

    @c.o0
    public AudioAttributes d() {
        return this.f5164h;
    }

    @c.o0
    public String e() {
        return this.f5170n;
    }

    @c.o0
    public String f() {
        return this.f5160d;
    }

    @c.o0
    public String g() {
        return this.f5161e;
    }

    @c.m0
    public String h() {
        return this.f5157a;
    }

    public int i() {
        return this.f5159c;
    }

    public int j() {
        return this.f5166j;
    }

    public int k() {
        return this.f5172p;
    }

    @c.o0
    public CharSequence l() {
        return this.f5158b;
    }

    NotificationChannel m() {
        String str;
        String str2;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 26) {
            return null;
        }
        c1.a();
        NotificationChannel notificationChannelA = b1.a(this.f5157a, this.f5158b, this.f5159c);
        notificationChannelA.setDescription(this.f5160d);
        notificationChannelA.setGroup(this.f5161e);
        notificationChannelA.setShowBadge(this.f5162f);
        notificationChannelA.setSound(this.f5163g, this.f5164h);
        notificationChannelA.enableLights(this.f5165i);
        notificationChannelA.setLightColor(this.f5166j);
        notificationChannelA.setVibrationPattern(this.f5168l);
        notificationChannelA.enableVibration(this.f5167k);
        if (i7 >= 30 && (str = this.f5169m) != null && (str2 = this.f5170n) != null) {
            notificationChannelA.setConversationId(str, str2);
        }
        return notificationChannelA;
    }

    @c.o0
    public String n() {
        return this.f5169m;
    }

    @c.o0
    public Uri o() {
        return this.f5163g;
    }

    @c.o0
    public long[] p() {
        return this.f5168l;
    }

    public boolean q() {
        return this.f5174r;
    }

    public boolean r() {
        return this.f5165i;
    }

    public boolean s() {
        return this.f5167k;
    }

    @c.m0
    public a t() {
        return new a(this.f5157a, this.f5159c).h(this.f5158b).c(this.f5160d).d(this.f5161e).i(this.f5162f).j(this.f5163g, this.f5164h).g(this.f5165i).f(this.f5166j).k(this.f5167k).l(this.f5168l).b(this.f5169m, this.f5170n);
    }

    @c.t0(26)
    l1(@c.m0 NotificationChannel notificationChannel) {
        this(notificationChannel.getId(), notificationChannel.getImportance());
        this.f5158b = notificationChannel.getName();
        this.f5160d = notificationChannel.getDescription();
        this.f5161e = notificationChannel.getGroup();
        this.f5162f = notificationChannel.canShowBadge();
        this.f5163g = notificationChannel.getSound();
        this.f5164h = notificationChannel.getAudioAttributes();
        this.f5165i = notificationChannel.shouldShowLights();
        this.f5166j = notificationChannel.getLightColor();
        this.f5167k = notificationChannel.shouldVibrate();
        this.f5168l = notificationChannel.getVibrationPattern();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            this.f5169m = notificationChannel.getParentChannelId();
            this.f5170n = notificationChannel.getConversationId();
        }
        this.f5171o = notificationChannel.canBypassDnd();
        this.f5172p = notificationChannel.getLockscreenVisibility();
        if (i7 >= 29) {
            this.f5173q = notificationChannel.canBubble();
        }
        if (i7 >= 30) {
            this.f5174r = notificationChannel.isImportantConversation();
        }
    }
}
