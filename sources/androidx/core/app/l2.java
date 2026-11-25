package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l2 {

    @SuppressLint({"ActionValue"})
    public static final String A = "android.title";
    public static final String A0 = "sys";

    @SuppressLint({"ActionValue"})
    public static final String B = "android.title.big";
    public static final String B0 = "service";

    @SuppressLint({"ActionValue"})
    public static final String C = "android.text";
    public static final String C0 = "reminder";

    @SuppressLint({"ActionValue"})
    public static final String D = "android.subText";
    public static final String D0 = "recommendation";

    @SuppressLint({"ActionValue"})
    public static final String E = "android.remoteInputHistory";
    public static final String E0 = "status";

    @SuppressLint({"ActionValue"})
    public static final String F = "android.infoText";
    public static final String F0 = "workout";

    @SuppressLint({"ActionValue"})
    public static final String G = "android.summaryText";
    public static final String G0 = "location_sharing";

    @SuppressLint({"ActionValue"})
    public static final String H = "android.bigText";
    public static final String H0 = "stopwatch";

    @SuppressLint({"ActionValue"})
    public static final String I = "android.icon";
    public static final String I0 = "missed_call";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5176J = "android.largeIcon";
    public static final int J0 = 0;

    @SuppressLint({"ActionValue"})
    public static final String K = "android.largeIcon.big";
    public static final int K0 = 1;

    @SuppressLint({"ActionValue"})
    public static final String L = "android.progress";
    public static final int L0 = 2;

    @SuppressLint({"ActionValue"})
    public static final String M = "android.progressMax";
    public static final int M0 = 0;

    @SuppressLint({"ActionValue"})
    public static final String N = "android.progressIndeterminate";
    public static final int N0 = 1;

    @SuppressLint({"ActionValue"})
    public static final String O = "android.showChronometer";
    public static final int O0 = 2;

    @SuppressLint({"ActionValue"})
    public static final String P = "android.chronometerCountDown";
    public static final String P0 = "silent";

    @SuppressLint({"ActionValue"})
    public static final String Q = "android.colorized";
    public static final int Q0 = 0;

    @SuppressLint({"ActionValue"})
    public static final String R = "android.showWhen";
    public static final int R0 = 1;

    @SuppressLint({"ActionValue"})
    public static final String S = "android.picture";
    public static final int S0 = 2;

    @SuppressLint({"ActionValue"})
    public static final String T = "android.pictureContentDescription";

    @SuppressLint({"ActionValue"})
    public static final String U = "android.showBigPictureWhenCollapsed";

    @SuppressLint({"ActionValue"})
    public static final String V = "android.textLines";

    @SuppressLint({"ActionValue"})
    public static final String W = "android.template";
    public static final String X = "androidx.core.app.extra.COMPAT_TEMPLATE";

    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String Y = "android.people";

    @SuppressLint({"ActionValue"})
    public static final String Z = "android.people.list";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5177a = "android.intent.category.NOTIFICATION_PREFERENCES";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5178a0 = "android.backgroundImageUri";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5179b = "android.intent.extra.CHANNEL_ID";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5180b0 = "android.mediaSession";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5181c = "android.intent.extra.CHANNEL_GROUP_ID";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5182c0 = "android.compactActions";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5183d = "android.intent.extra.NOTIFICATION_TAG";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5184d0 = "android.selfDisplayName";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5185e = "android.intent.extra.NOTIFICATION_ID";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5186e0 = "android.messagingStyleUser";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5187f = -1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5188f0 = "android.conversationTitle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5189g = 1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5190g0 = "android.messages";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5191h = 2;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5192h0 = "android.messages.historic";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5193i = 4;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5194i0 = "android.isGroupConversation";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5195j = -1;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5196j0 = "android.hiddenConversationTitle";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5197k = 1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5198k0 = "android.audioContents";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5199l = 2;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @c.l
    public static final int f5200l0 = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5201m = 4;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f5202m0 = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5203n = 8;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f5204n0 = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5205o = 16;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f5206o0 = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5207p = 32;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f5208p0 = "call";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5209q = 64;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f5210q0 = "navigation";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Deprecated
    public static final int f5211r = 128;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f5212r0 = "msg";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f5213s = 256;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f5214s0 = "email";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5215t = 512;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f5216t0 = "event";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5217u = 4096;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f5218u0 = "promo";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5219v = 0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f5220v0 = "alarm";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5221w = -1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f5222w0 = "progress";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5223x = -2;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f5224x0 = "social";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f5225y = 1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f5226y0 = "err";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f5227z = 2;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f5228z0 = "transport";

    public static class b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f5229m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f5230n = 1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f5231o = 2;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f5232p = 3;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f5233q = 4;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f5234r = 5;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f5235s = 6;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f5236t = 7;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f5237u = 8;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f5238v = 9;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f5239w = 10;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        static final String f5240x = "android.support.action.showsUserInterface";

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        static final String f5241y = "android.support.action.semanticAction";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f5242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.o0
        private IconCompat f5243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final s6[] f5244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final s6[] f5245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f5247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f5248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f5249h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f5250i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f5251j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f5252k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f5253l;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IconCompat f5254a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final CharSequence f5255b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final PendingIntent f5256c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f5257d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final Bundle f5258e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private ArrayList<s6> f5259f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f5260g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f5261h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private boolean f5262i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f5263j;

            public a(@c.o0 IconCompat iconCompat, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private void d() {
                if (this.f5262i && this.f5256c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            @c.t0(19)
            @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
            @c.m0
            public static a f(@c.m0 Notification.Action action) {
                a aVar = action.getIcon() != null ? new a(IconCompat.m(action.getIcon()), action.title, action.actionIntent) : new a(action.icon, action.title, action.actionIntent);
                RemoteInput[] remoteInputs = action.getRemoteInputs();
                if (remoteInputs != null && remoteInputs.length != 0) {
                    for (RemoteInput remoteInput : remoteInputs) {
                        aVar.b(s6.e(remoteInput));
                    }
                }
                int i7 = Build.VERSION.SDK_INT;
                if (i7 >= 24) {
                    aVar.f5257d = action.getAllowGeneratedReplies();
                }
                if (i7 >= 28) {
                    aVar.k(action.getSemanticAction());
                }
                if (i7 >= 29) {
                    aVar.j(action.isContextual());
                }
                if (i7 >= 31) {
                    aVar.i(action.isAuthenticationRequired());
                }
                return aVar;
            }

            @c.m0
            public a a(@c.o0 Bundle bundle) {
                if (bundle != null) {
                    this.f5258e.putAll(bundle);
                }
                return this;
            }

            @c.m0
            public a b(@c.o0 s6 s6Var) {
                if (this.f5259f == null) {
                    this.f5259f = new ArrayList<>();
                }
                if (s6Var != null) {
                    this.f5259f.add(s6Var);
                }
                return this;
            }

            @c.m0
            public b c() {
                d();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<s6> arrayList3 = this.f5259f;
                if (arrayList3 != null) {
                    for (s6 s6Var : arrayList3) {
                        if (s6Var.r()) {
                            arrayList.add(s6Var);
                        } else {
                            arrayList2.add(s6Var);
                        }
                    }
                }
                s6[] s6VarArr = arrayList.isEmpty() ? null : (s6[]) arrayList.toArray(new s6[arrayList.size()]);
                return new b(this.f5254a, this.f5255b, this.f5256c, this.f5258e, arrayList2.isEmpty() ? null : (s6[]) arrayList2.toArray(new s6[arrayList2.size()]), s6VarArr, this.f5257d, this.f5260g, this.f5261h, this.f5262i, this.f5263j);
            }

            @c.m0
            public a e(@c.m0 InterfaceC0052b interfaceC0052b) {
                interfaceC0052b.a(this);
                return this;
            }

            @c.m0
            public Bundle g() {
                return this.f5258e;
            }

            @c.m0
            public a h(boolean z7) {
                this.f5257d = z7;
                return this;
            }

            @c.m0
            public a i(boolean z7) {
                this.f5263j = z7;
                return this;
            }

            @c.m0
            public a j(boolean z7) {
                this.f5262i = z7;
                return this;
            }

            @c.m0
            public a k(int i7) {
                this.f5260g = i7;
                return this;
            }

            @c.m0
            public a l(boolean z7) {
                this.f5261h = z7;
                return this;
            }

            public a(int i7, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent) {
                this(i7 != 0 ? IconCompat.y(null, "", i7) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public a(@c.m0 b bVar) {
                this(bVar.f(), bVar.f5251j, bVar.f5252k, new Bundle(bVar.f5242a), bVar.g(), bVar.b(), bVar.h(), bVar.f5247f, bVar.l(), bVar.k());
            }

            private a(@c.o0 IconCompat iconCompat, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent, @c.m0 Bundle bundle, @c.o0 s6[] s6VarArr, boolean z7, int i7, boolean z8, boolean z9, boolean z10) {
                this.f5257d = true;
                this.f5261h = true;
                this.f5254a = iconCompat;
                this.f5255b = g.A(charSequence);
                this.f5256c = pendingIntent;
                this.f5258e = bundle;
                this.f5259f = s6VarArr == null ? null : new ArrayList<>(Arrays.asList(s6VarArr));
                this.f5257d = z7;
                this.f5260g = i7;
                this.f5261h = z8;
                this.f5262i = z9;
                this.f5263j = z10;
            }
        }

        /* JADX INFO: renamed from: androidx.core.app.l2$b$b, reason: collision with other inner class name */
        public interface InterfaceC0052b {
            @c.m0
            a a(@c.m0 a aVar);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface c {
        }

        public b(int i7, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent) {
            this(i7 != 0 ? IconCompat.y(null, "", i7) : null, charSequence, pendingIntent);
        }

        @c.o0
        public PendingIntent a() {
            return this.f5252k;
        }

        public boolean b() {
            return this.f5246e;
        }

        @c.o0
        public s6[] c() {
            return this.f5245d;
        }

        @c.m0
        public Bundle d() {
            return this.f5242a;
        }

        @Deprecated
        public int e() {
            return this.f5250i;
        }

        @c.o0
        public IconCompat f() {
            int i7;
            if (this.f5243b == null && (i7 = this.f5250i) != 0) {
                this.f5243b = IconCompat.y(null, "", i7);
            }
            return this.f5243b;
        }

        @c.o0
        public s6[] g() {
            return this.f5244c;
        }

        public int h() {
            return this.f5248g;
        }

        public boolean i() {
            return this.f5247f;
        }

        @c.o0
        public CharSequence j() {
            return this.f5251j;
        }

        public boolean k() {
            return this.f5253l;
        }

        public boolean l() {
            return this.f5249h;
        }

        public static final class d implements InterfaceC0052b {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static final String f5264e = "android.wearable.EXTENSIONS";

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final String f5265f = "flags";

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final String f5266g = "inProgressLabel";

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final String f5267h = "confirmLabel";

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private static final String f5268i = "cancelLabel";

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private static final int f5269j = 1;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private static final int f5270k = 2;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private static final int f5271l = 4;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private static final int f5272m = 1;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f5273a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private CharSequence f5274b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private CharSequence f5275c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private CharSequence f5276d;

            public d() {
                this.f5273a = 1;
            }

            private void l(int i7, boolean z7) {
                if (z7) {
                    this.f5273a = i7 | this.f5273a;
                } else {
                    this.f5273a = (~i7) & this.f5273a;
                }
            }

            @Override // androidx.core.app.l2.b.InterfaceC0052b
            @c.m0
            public a a(@c.m0 a aVar) {
                Bundle bundle = new Bundle();
                int i7 = this.f5273a;
                if (i7 != 1) {
                    bundle.putInt(f5265f, i7);
                }
                CharSequence charSequence = this.f5274b;
                if (charSequence != null) {
                    bundle.putCharSequence(f5266g, charSequence);
                }
                CharSequence charSequence2 = this.f5275c;
                if (charSequence2 != null) {
                    bundle.putCharSequence(f5267h, charSequence2);
                }
                CharSequence charSequence3 = this.f5276d;
                if (charSequence3 != null) {
                    bundle.putCharSequence(f5268i, charSequence3);
                }
                aVar.g().putBundle(f5264e, bundle);
                return aVar;
            }

            @c.m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d clone() {
                d dVar = new d();
                dVar.f5273a = this.f5273a;
                dVar.f5274b = this.f5274b;
                dVar.f5275c = this.f5275c;
                dVar.f5276d = this.f5276d;
                return dVar;
            }

            @c.o0
            @Deprecated
            public CharSequence c() {
                return this.f5276d;
            }

            @c.o0
            @Deprecated
            public CharSequence d() {
                return this.f5275c;
            }

            public boolean e() {
                return (this.f5273a & 4) != 0;
            }

            public boolean f() {
                return (this.f5273a & 2) != 0;
            }

            @c.o0
            @Deprecated
            public CharSequence g() {
                return this.f5274b;
            }

            public boolean h() {
                return (this.f5273a & 1) != 0;
            }

            @c.m0
            public d i(boolean z7) {
                l(1, z7);
                return this;
            }

            @c.m0
            @Deprecated
            public d j(@c.o0 CharSequence charSequence) {
                this.f5276d = charSequence;
                return this;
            }

            @c.m0
            @Deprecated
            public d k(@c.o0 CharSequence charSequence) {
                this.f5275c = charSequence;
                return this;
            }

            @c.m0
            public d m(boolean z7) {
                l(4, z7);
                return this;
            }

            @c.m0
            public d n(boolean z7) {
                l(2, z7);
                return this;
            }

            @c.m0
            @Deprecated
            public d o(@c.o0 CharSequence charSequence) {
                this.f5274b = charSequence;
                return this;
            }

            public d(@c.m0 b bVar) {
                this.f5273a = 1;
                Bundle bundle = bVar.d().getBundle(f5264e);
                if (bundle != null) {
                    this.f5273a = bundle.getInt(f5265f, 1);
                    this.f5274b = bundle.getCharSequence(f5266g);
                    this.f5275c = bundle.getCharSequence(f5267h);
                    this.f5276d = bundle.getCharSequence(f5268i);
                }
            }
        }

        public b(@c.o0 IconCompat iconCompat, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (s6[]) null, (s6[]) null, true, 0, true, false, false);
        }

        b(int i7, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent, @c.o0 Bundle bundle, @c.o0 s6[] s6VarArr, @c.o0 s6[] s6VarArr2, boolean z7, int i8, boolean z8, boolean z9, boolean z10) {
            this(i7 != 0 ? IconCompat.y(null, "", i7) : null, charSequence, pendingIntent, bundle, s6VarArr, s6VarArr2, z7, i8, z8, z9, z10);
        }

        b(@c.o0 IconCompat iconCompat, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent, @c.o0 Bundle bundle, @c.o0 s6[] s6VarArr, @c.o0 s6[] s6VarArr2, boolean z7, int i7, boolean z8, boolean z9, boolean z10) {
            this.f5247f = true;
            this.f5243b = iconCompat;
            if (iconCompat != null && iconCompat.D() == 2) {
                this.f5250i = iconCompat.A();
            }
            this.f5251j = g.A(charSequence);
            this.f5252k = pendingIntent;
            this.f5242a = bundle == null ? new Bundle() : bundle;
            this.f5244c = s6VarArr;
            this.f5245d = s6VarArr2;
            this.f5246e = z7;
            this.f5248g = i7;
            this.f5247f = z8;
            this.f5249h = z9;
            this.f5253l = z10;
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public static class d extends q {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f5277j = "androidx.core.app.NotificationCompat$BigPictureStyle";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f5278e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IconCompat f5279f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f5280g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CharSequence f5281h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f5282i;

        @c.t0(16)
        private static class a {
            private a() {
            }

            @c.t0(16)
            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            @c.t0(16)
            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        @c.t0(23)
        private static class b {
            private b() {
            }

            @c.t0(23)
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @c.t0(31)
        private static class c {
            private c() {
            }

            @c.t0(31)
            static void a(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @c.t0(31)
            static void b(Notification.BigPictureStyle bigPictureStyle, boolean z7) {
                bigPictureStyle.showBigPictureWhenCollapsed(z7);
            }
        }

        public d() {
        }

        @c.o0
        private static IconCompat A(@c.o0 Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.m((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.s((Bitmap) parcelable);
            }
            return null;
        }

        @c.m0
        public d B(@c.o0 Bitmap bitmap) {
            this.f5279f = bitmap == null ? null : IconCompat.s(bitmap);
            this.f5280g = true;
            return this;
        }

        @c.m0
        public d C(@c.o0 Bitmap bitmap) {
            this.f5278e = bitmap;
            return this;
        }

        @c.m0
        public d D(@c.o0 CharSequence charSequence) {
            this.f5382b = g.A(charSequence);
            return this;
        }

        @c.t0(31)
        @c.m0
        public d E(@c.o0 CharSequence charSequence) {
            this.f5281h = charSequence;
            return this;
        }

        @c.m0
        public d F(@c.o0 CharSequence charSequence) {
            this.f5383c = g.A(charSequence);
            this.f5384d = true;
            return this;
        }

        @c.t0(31)
        @c.m0
        public d G(boolean z7) {
            this.f5282i = z7;
            return this;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void b(h0 h0Var) {
            int i7 = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigPictureStyleBigPicture = new Notification.BigPictureStyle(h0Var.a()).setBigContentTitle(this.f5382b).bigPicture(this.f5278e);
            if (this.f5280g) {
                if (this.f5279f == null) {
                    a.a(bigPictureStyleBigPicture, null);
                } else {
                    b.a(bigPictureStyleBigPicture, this.f5279f.M(h0Var instanceof w4 ? ((w4) h0Var).f() : null));
                }
            }
            if (this.f5384d) {
                a.b(bigPictureStyleBigPicture, this.f5383c);
            }
            if (i7 >= 31) {
                c.b(bigPictureStyleBigPicture, this.f5282i);
                c.a(bigPictureStyleBigPicture, this.f5281h);
            }
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void g(@c.m0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(l2.K);
            bundle.remove(l2.S);
            bundle.remove(l2.U);
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        protected String t() {
            return f5277j;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void y(@c.m0 Bundle bundle) {
            super.y(bundle);
            if (bundle.containsKey(l2.K)) {
                this.f5279f = A(bundle.getParcelable(l2.K));
                this.f5280g = true;
            }
            this.f5278e = (Bitmap) bundle.getParcelable(l2.S);
            this.f5282i = bundle.getBoolean(l2.U);
        }

        public d(@c.o0 g gVar) {
            z(gVar);
        }
    }

    public static class e extends q {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f5283f = "androidx.core.app.NotificationCompat$BigTextStyle";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f5284e;

        public e() {
        }

        @c.m0
        public e A(@c.o0 CharSequence charSequence) {
            this.f5284e = g.A(charSequence);
            return this;
        }

        @c.m0
        public e B(@c.o0 CharSequence charSequence) {
            this.f5382b = g.A(charSequence);
            return this;
        }

        @c.m0
        public e C(@c.o0 CharSequence charSequence) {
            this.f5383c = g.A(charSequence);
            this.f5384d = true;
            return this;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void a(@c.m0 Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void b(h0 h0Var) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(h0Var.a()).setBigContentTitle(this.f5382b).bigText(this.f5284e);
            if (this.f5384d) {
                bigTextStyleBigText.setSummaryText(this.f5383c);
            }
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void g(@c.m0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(l2.H);
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        protected String t() {
            return f5283f;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void y(@c.m0 Bundle bundle) {
            super.y(bundle);
            this.f5284e = bundle.getCharSequence(l2.H);
        }

        public e(@c.o0 g gVar) {
            z(gVar);
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f5285h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f5286i = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PendingIntent f5287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PendingIntent f5288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private IconCompat f5289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.p
        private int f5291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f5293g;

        @c.t0(29)
        private static class a {
            private a() {
            }

            @c.o0
            @c.t0(29)
            static f a(@c.o0 Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                c cVarI = new c(bubbleMetadata.getIntent(), IconCompat.m(bubbleMetadata.getIcon())).b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).i(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    cVarI.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    cVarI.e(bubbleMetadata.getDesiredHeightResId());
                }
                return cVarI.a();
            }

            @c.o0
            @c.t0(29)
            static Notification.BubbleMetadata b(@c.o0 f fVar) {
                if (fVar == null || fVar.g() == null) {
                    return null;
                }
                v2.a();
                Notification.BubbleMetadata.Builder suppressNotification = u2.a().setIcon(fVar.f().L()).setIntent(fVar.g()).setDeleteIntent(fVar.c()).setAutoExpandBubble(fVar.b()).setSuppressNotification(fVar.i());
                if (fVar.d() != 0) {
                    suppressNotification.setDesiredHeight(fVar.d());
                }
                if (fVar.e() != 0) {
                    suppressNotification.setDesiredHeightResId(fVar.e());
                }
                return suppressNotification.build();
            }
        }

        @c.t0(30)
        private static class b {
            private b() {
            }

            @c.o0
            @c.t0(30)
            static f a(@c.o0 Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                c cVar = bubbleMetadata.getShortcutId() != null ? new c(bubbleMetadata.getShortcutId()) : new c(bubbleMetadata.getIntent(), IconCompat.m(bubbleMetadata.getIcon()));
                cVar.b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).i(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    cVar.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    cVar.e(bubbleMetadata.getDesiredHeightResId());
                }
                return cVar.a();
            }

            @c.o0
            @c.t0(30)
            static Notification.BubbleMetadata b(@c.o0 f fVar) {
                Notification.BubbleMetadata.Builder builderA;
                if (fVar == null) {
                    return null;
                }
                if (fVar.h() != null) {
                    v2.a();
                    builderA = h3.a(fVar.h());
                } else {
                    v2.a();
                    builderA = g3.a(fVar.g(), fVar.f().L());
                }
                builderA.setDeleteIntent(fVar.c()).setAutoExpandBubble(fVar.b()).setSuppressNotification(fVar.i());
                if (fVar.d() != 0) {
                    builderA.setDesiredHeight(fVar.d());
                }
                if (fVar.e() != 0) {
                    builderA.setDesiredHeightResId(fVar.e());
                }
                return builderA.build();
            }
        }

        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private PendingIntent f5294a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IconCompat f5295b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f5296c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @c.p
            private int f5297d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f5298e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private PendingIntent f5299f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private String f5300g;

            @Deprecated
            public c() {
            }

            @c.m0
            private c f(int i7, boolean z7) {
                if (z7) {
                    this.f5298e = i7 | this.f5298e;
                } else {
                    this.f5298e = (~i7) & this.f5298e;
                }
                return this;
            }

            @c.m0
            @SuppressLint({"SyntheticAccessor"})
            public f a() {
                String str = this.f5300g;
                if (str == null && this.f5294a == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.f5295b == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                f fVar = new f(this.f5294a, this.f5299f, this.f5295b, this.f5296c, this.f5297d, this.f5298e, str);
                fVar.j(this.f5298e);
                return fVar;
            }

            @c.m0
            public c b(boolean z7) {
                f(1, z7);
                return this;
            }

            @c.m0
            public c c(@c.o0 PendingIntent pendingIntent) {
                this.f5299f = pendingIntent;
                return this;
            }

            @c.m0
            public c d(@c.q(unit = 0) int i7) {
                this.f5296c = Math.max(i7, 0);
                this.f5297d = 0;
                return this;
            }

            @c.m0
            public c e(@c.p int i7) {
                this.f5297d = i7;
                this.f5296c = 0;
                return this;
            }

            @c.m0
            public c g(@c.m0 IconCompat iconCompat) {
                if (this.f5300g != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                if (iconCompat == null) {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                this.f5295b = iconCompat;
                return this;
            }

            @c.m0
            public c h(@c.m0 PendingIntent pendingIntent) {
                if (this.f5300g != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                this.f5294a = pendingIntent;
                return this;
            }

            @c.m0
            public c i(boolean z7) {
                f(2, z7);
                return this;
            }

            @c.t0(30)
            public c(@c.m0 String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new NullPointerException("Bubble requires a non-null shortcut id");
                }
                this.f5300g = str;
            }

            public c(@c.m0 PendingIntent pendingIntent, @c.m0 IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat != null) {
                    this.f5294a = pendingIntent;
                    this.f5295b = iconCompat;
                    return;
                }
                throw new NullPointerException("Bubbles require non-null icon");
            }
        }

        @c.o0
        public static f a(@c.o0 Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30) {
                return b.a(bubbleMetadata);
            }
            if (i7 == 29) {
                return a.a(bubbleMetadata);
            }
            return null;
        }

        @c.o0
        public static Notification.BubbleMetadata k(@c.o0 f fVar) {
            if (fVar == null) {
                return null;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30) {
                return b.b(fVar);
            }
            if (i7 == 29) {
                return a.b(fVar);
            }
            return null;
        }

        public boolean b() {
            return (this.f5292f & 1) != 0;
        }

        @c.o0
        public PendingIntent c() {
            return this.f5288b;
        }

        @c.q(unit = 0)
        public int d() {
            return this.f5290d;
        }

        @c.p
        public int e() {
            return this.f5291e;
        }

        @c.o0
        @SuppressLint({"InvalidNullConversion"})
        public IconCompat f() {
            return this.f5289c;
        }

        @c.o0
        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent g() {
            return this.f5287a;
        }

        @c.o0
        public String h() {
            return this.f5293g;
        }

        public boolean i() {
            return (this.f5292f & 2) != 0;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void j(int i7) {
            this.f5292f = i7;
        }

        private f(@c.o0 PendingIntent pendingIntent, @c.o0 PendingIntent pendingIntent2, @c.o0 IconCompat iconCompat, int i7, @c.p int i8, int i9, @c.o0 String str) {
            this.f5287a = pendingIntent;
            this.f5289c = iconCompat;
            this.f5290d = i7;
            this.f5291e = i8;
            this.f5288b = pendingIntent2;
            this.f5292f = i9;
            this.f5293g = str;
        }
    }

    public static class i extends q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f5356e = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f5357f = 3;

        private RemoteViews A(RemoteViews remoteViews, boolean z7) {
            int iMin;
            boolean z8 = true;
            RemoteViews remoteViewsC = c(true, R.layout.notification_template_custom_big, false);
            remoteViewsC.removeAllViews(R.id.actions);
            List<b> listC = C(this.f5381a.f5303b);
            if (!z7 || listC == null || (iMin = Math.min(listC.size(), 3)) <= 0) {
                z8 = false;
            } else {
                for (int i7 = 0; i7 < iMin; i7++) {
                    remoteViewsC.addView(R.id.actions, B(listC.get(i7)));
                }
            }
            int i8 = z8 ? 0 : 8;
            remoteViewsC.setViewVisibility(R.id.actions, i8);
            remoteViewsC.setViewVisibility(R.id.action_divider, i8);
            e(remoteViewsC, remoteViews);
            return remoteViewsC;
        }

        private RemoteViews B(b bVar) {
            boolean z7 = bVar.f5252k == null;
            RemoteViews remoteViews = new RemoteViews(this.f5381a.f5302a.getPackageName(), z7 ? R.layout.notification_action_tombstone : R.layout.notification_action);
            IconCompat iconCompatF = bVar.f();
            if (iconCompatF != null) {
                remoteViews.setImageViewBitmap(R.id.action_image, o(iconCompatF, this.f5381a.f5302a.getResources().getColor(R.color.notification_action_color_filter)));
            }
            remoteViews.setTextViewText(R.id.action_text, bVar.f5251j);
            if (!z7) {
                remoteViews.setOnClickPendingIntent(R.id.action_container, bVar.f5252k);
            }
            remoteViews.setContentDescription(R.id.action_container, bVar.f5251j);
            return remoteViews;
        }

        private static List<b> C(List<b> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                if (!bVar.l()) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void b(h0 h0Var) {
            if (Build.VERSION.SDK_INT >= 24) {
                Notification.Builder builderA = h0Var.a();
                n3.a();
                builderA.setStyle(m3.a());
            }
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return true;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        protected String t() {
            return f5356e;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews v(h0 h0Var) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsP = this.f5381a.p();
            if (remoteViewsP == null) {
                remoteViewsP = this.f5381a.s();
            }
            if (remoteViewsP == null) {
                return null;
            }
            return A(remoteViewsP, true);
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews w(h0 h0Var) {
            if (Build.VERSION.SDK_INT < 24 && this.f5381a.s() != null) {
                return A(this.f5381a.s(), false);
            }
            return null;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews x(h0 h0Var) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsW = this.f5381a.w();
            RemoteViews remoteViewsS = remoteViewsW != null ? remoteViewsW : this.f5381a.s();
            if (remoteViewsW == null) {
                return null;
            }
            return A(remoteViewsS, true);
        }
    }

    public interface j {
        @c.m0
        g a(@c.m0 g gVar);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface n {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface o {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface p {
    }

    public static abstract class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected g f5381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f5382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f5383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5384d = false;

        private int f() {
            Resources resources = this.f5381a.f5302a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float fH = (h(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - fH) * dimensionPixelSize) + (fH * dimensionPixelSize2));
        }

        private static float h(float f8, float f9, float f10) {
            if (f8 < f9) {
                return f9;
            }
            return f8 > f10 ? f10 : f8;
        }

        @c.o0
        static q i(@c.o0 String str) {
            if (str == null) {
                return null;
            }
            switch (str) {
                case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                    return new i();
                case "androidx.core.app.NotificationCompat$BigPictureStyle":
                    return new d();
                case "androidx.core.app.NotificationCompat$InboxStyle":
                    return new l();
                case "androidx.core.app.NotificationCompat$BigTextStyle":
                    return new e();
                case "androidx.core.app.NotificationCompat$MessagingStyle":
                    return new m();
                default:
                    return null;
            }
        }

        @c.o0
        private static q j(@c.o0 String str) {
            if (str == null) {
                return null;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new d();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new e();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new l();
            }
            if (i7 >= 24) {
                if (str.equals(Notification.MessagingStyle.class.getName())) {
                    return new m();
                }
                if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                    return new i();
                }
            }
            return null;
        }

        @c.o0
        static q k(@c.m0 Bundle bundle) {
            q qVarI = i(bundle.getString(l2.X));
            if (qVarI != null) {
                return qVarI;
            }
            if (bundle.containsKey(l2.f5184d0) || bundle.containsKey(l2.f5186e0)) {
                return new m();
            }
            if (bundle.containsKey(l2.S)) {
                return new d();
            }
            if (bundle.containsKey(l2.H)) {
                return new e();
            }
            return bundle.containsKey(l2.V) ? new l() : j(bundle.getString(l2.W));
        }

        @c.o0
        static q l(@c.m0 Bundle bundle) {
            q qVarK = k(bundle);
            if (qVarK == null) {
                return null;
            }
            try {
                qVarK.y(bundle);
                return qVarK;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        private Bitmap n(int i7, int i8, int i9) {
            return p(IconCompat.x(this.f5381a.f5302a, i7), i8, i9);
        }

        private Bitmap p(@c.m0 IconCompat iconCompat, int i7, int i8) {
            Drawable drawableG = iconCompat.G(this.f5381a.f5302a);
            int intrinsicWidth = i8 == 0 ? drawableG.getIntrinsicWidth() : i8;
            if (i8 == 0) {
                i8 = drawableG.getIntrinsicHeight();
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, i8, Bitmap.Config.ARGB_8888);
            drawableG.setBounds(0, 0, intrinsicWidth, i8);
            if (i7 != 0) {
                drawableG.mutate().setColorFilter(new PorterDuffColorFilter(i7, PorterDuff.Mode.SRC_IN));
            }
            drawableG.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }

        private Bitmap q(int i7, int i8, int i9, int i10) {
            int i11 = R.drawable.notification_icon_background;
            if (i10 == 0) {
                i10 = 0;
            }
            Bitmap bitmapN = n(i11, i10, i8);
            Canvas canvas = new Canvas(bitmapN);
            Drawable drawableMutate = this.f5381a.f5302a.getResources().getDrawable(i7).mutate();
            drawableMutate.setFilterBitmap(true);
            int i12 = (i8 - i9) / 2;
            int i13 = i9 + i12;
            drawableMutate.setBounds(i12, i12, i13, i13);
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            drawableMutate.draw(canvas);
            return bitmapN;
        }

        @c.o0
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public static q s(@c.m0 Notification notification) {
            Bundle bundleN = l2.n(notification);
            if (bundleN == null) {
                return null;
            }
            return l(bundleN);
        }

        private void u(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void a(@c.m0 Bundle bundle) {
            if (this.f5384d) {
                bundle.putCharSequence(l2.G, this.f5383c);
            }
            CharSequence charSequence = this.f5382b;
            if (charSequence != null) {
                bundle.putCharSequence(l2.B, charSequence);
            }
            String strT = t();
            if (strT != null) {
                bundle.putString(l2.X, strT);
            }
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void b(h0 h0Var) {
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0106  */
        /* JADX WARN: Code duplicated, block: B:36:0x0111  */
        /* JADX WARN: Code duplicated, block: B:37:0x011d  */
        /* JADX WARN: Code duplicated, block: B:38:0x0122  */
        /* JADX WARN: Code duplicated, block: B:40:0x0125 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:41:0x0127  */
        /* JADX WARN: Code duplicated, block: B:45:0x0149  */
        /* JADX WARN: Code duplicated, block: B:47:0x014f  */
        /* JADX WARN: Code duplicated, block: B:52:0x0182  */
        /* JADX WARN: Code duplicated, block: B:53:0x0195  */
        /* JADX WARN: Code duplicated, block: B:56:0x019a  */
        /* JADX WARN: Code duplicated, block: B:57:0x019c  */
        /* JADX WARN: Code duplicated, block: B:61:0x01a5  */
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        public RemoteViews c(boolean z7, int i7, boolean z8) {
            boolean z9;
            boolean z10;
            CharSequence charSequence;
            boolean z11;
            int i8;
            boolean z12;
            CharSequence charSequence2;
            Resources resources = this.f5381a.f5302a.getResources();
            RemoteViews remoteViews = new RemoteViews(this.f5381a.f5302a.getPackageName(), i7);
            this.f5381a.y();
            int i9 = Build.VERSION.SDK_INT;
            g gVar = this.f5381a;
            if (gVar.f5311j != null) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setImageViewBitmap(R.id.icon, this.f5381a.f5311j);
                if (z7 && this.f5381a.U.icon != 0) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                    int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
                    g gVar2 = this.f5381a;
                    remoteViews.setImageViewBitmap(R.id.right_icon, q(gVar2.U.icon, dimensionPixelSize, dimensionPixelSize2, gVar2.r()));
                    remoteViews.setViewVisibility(R.id.right_icon, 0);
                }
            } else if (z7 && gVar.U.icon != 0) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
                g gVar3 = this.f5381a;
                remoteViews.setImageViewBitmap(R.id.icon, q(gVar3.U.icon, dimensionPixelSize3, dimensionPixelSize4, gVar3.r()));
            }
            CharSequence charSequence3 = this.f5381a.f5306e;
            if (charSequence3 != null) {
                remoteViews.setTextViewText(R.id.title, charSequence3);
            }
            CharSequence charSequence4 = this.f5381a.f5307f;
            boolean z13 = true;
            if (charSequence4 != null) {
                remoteViews.setTextViewText(R.id.text, charSequence4);
                z9 = true;
            } else {
                z9 = false;
            }
            g gVar4 = this.f5381a;
            CharSequence charSequence5 = gVar4.f5312k;
            if (charSequence5 == null) {
                if (gVar4.f5313l > 0) {
                    if (this.f5381a.f5313l > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                        remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
                    } else {
                        remoteViews.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.f5381a.f5313l));
                    }
                    remoteViews.setViewVisibility(R.id.info, 0);
                } else {
                    remoteViews.setViewVisibility(R.id.info, 8);
                    z10 = false;
                }
                charSequence = this.f5381a.f5319r;
                if (charSequence != null) {
                    remoteViews.setTextViewText(R.id.text, charSequence);
                    charSequence2 = this.f5381a.f5307f;
                    if (charSequence2 != null) {
                        remoteViews.setTextViewText(R.id.text2, charSequence2);
                        remoteViews.setViewVisibility(R.id.text2, 0);
                        z11 = true;
                    } else {
                        remoteViews.setViewVisibility(R.id.text2, 8);
                        z11 = false;
                    }
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (z8) {
                        remoteViews.setTextViewTextSize(R.id.text, 0, resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                    }
                    remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                }
                if (this.f5381a.z() != 0) {
                    z13 = z10;
                } else if (this.f5381a.f5316o) {
                    remoteViews.setViewVisibility(R.id.chronometer, 0);
                    remoteViews.setLong(R.id.chronometer, "setBase", this.f5381a.z() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                    remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                    z12 = this.f5381a.f5317p;
                    if (z12 && i9 >= 24) {
                        remoteViews.setChronometerCountDown(R.id.chronometer, z12);
                    }
                } else {
                    remoteViews.setViewVisibility(R.id.time, 0);
                    remoteViews.setLong(R.id.time, "setTime", this.f5381a.z());
                }
                int i10 = R.id.right_side;
                if (z13) {
                    i8 = 0;
                } else {
                    i8 = 8;
                }
                remoteViews.setViewVisibility(i10, i8);
                remoteViews.setViewVisibility(R.id.line3, z9 ? 0 : 8);
                return remoteViews;
            }
            remoteViews.setTextViewText(R.id.info, charSequence5);
            remoteViews.setViewVisibility(R.id.info, 0);
            z9 = true;
            z10 = true;
            charSequence = this.f5381a.f5319r;
            if (charSequence != null) {
                remoteViews.setTextViewText(R.id.text, charSequence);
                charSequence2 = this.f5381a.f5307f;
                if (charSequence2 != null) {
                    remoteViews.setTextViewText(R.id.text2, charSequence2);
                    remoteViews.setViewVisibility(R.id.text2, 0);
                    z11 = true;
                } else {
                    remoteViews.setViewVisibility(R.id.text2, 8);
                    z11 = false;
                }
            } else {
                z11 = false;
            }
            if (z11) {
                if (z8) {
                    remoteViews.setTextViewTextSize(R.id.text, 0, resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                }
                remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
            }
            if (this.f5381a.z() != 0) {
                z13 = z10;
            } else if (this.f5381a.f5316o) {
                remoteViews.setViewVisibility(R.id.chronometer, 0);
                remoteViews.setLong(R.id.chronometer, "setBase", this.f5381a.z() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                z12 = this.f5381a.f5317p;
                if (z12) {
                    remoteViews.setChronometerCountDown(R.id.chronometer, z12);
                }
            } else {
                remoteViews.setViewVisibility(R.id.time, 0);
                remoteViews.setLong(R.id.time, "setTime", this.f5381a.z());
            }
            int i11 = R.id.right_side;
            if (z13) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            remoteViews.setViewVisibility(i11, i8);
            remoteViews.setViewVisibility(R.id.line3, z9 ? 0 : 8);
            return remoteViews;
        }

        @c.o0
        public Notification d() {
            g gVar = this.f5381a;
            if (gVar != null) {
                return gVar.h();
            }
            return null;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void e(RemoteViews remoteViews, RemoteViews remoteViews2) {
            u(remoteViews);
            remoteViews.removeAllViews(R.id.notification_main_column);
            remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(R.id.notification_main_column, 0);
            remoteViews.setViewPadding(R.id.notification_main_column_container, 0, f(), 0, 0);
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void g(@c.m0 Bundle bundle) {
            bundle.remove(l2.G);
            bundle.remove(l2.B);
            bundle.remove(l2.X);
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public Bitmap m(int i7, int i8) {
            return n(i7, i8, 0);
        }

        Bitmap o(@c.m0 IconCompat iconCompat, int i7) {
            return p(iconCompat, i7, 0);
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return false;
        }

        @c.o0
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected String t() {
            return null;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews v(h0 h0Var) {
            return null;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews w(h0 h0Var) {
            return null;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews x(h0 h0Var) {
            return null;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void y(@c.m0 Bundle bundle) {
            if (bundle.containsKey(l2.G)) {
                this.f5383c = bundle.getCharSequence(l2.G);
                this.f5384d = true;
            }
            this.f5382b = bundle.getCharSequence(l2.B);
        }

        public void z(@c.o0 g gVar) {
            if (this.f5381a != gVar) {
                this.f5381a = gVar;
                if (gVar != null) {
                    gVar.z0(this);
                }
            }
        }
    }

    @Deprecated
    public l2() {
    }

    @c.o0
    public static String A(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    @c.t0(19)
    public static boolean B(@c.m0 Notification notification) {
        return notification.extras.getBoolean(R);
    }

    @c.o0
    public static String C(@c.m0 Notification notification) {
        return notification.getSortKey();
    }

    @c.o0
    @c.t0(19)
    public static CharSequence D(@c.m0 Notification notification) {
        return notification.extras.getCharSequence(D);
    }

    public static long E(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0L;
    }

    @c.t0(19)
    public static boolean F(@c.m0 Notification notification) {
        return notification.extras.getBoolean(O);
    }

    public static int G(@c.m0 Notification notification) {
        return notification.visibility;
    }

    public static boolean H(@c.m0 Notification notification) {
        return (notification.flags & 512) != 0;
    }

    @c.o0
    public static b a(@c.m0 Notification notification, int i7) {
        return b(notification.actions[i7]);
    }

    @c.t0(20)
    @c.m0
    static b b(@c.m0 Notification.Action action) {
        s6[] s6VarArr;
        int i7;
        RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs == null) {
            s6VarArr = null;
        } else {
            s6[] s6VarArr2 = new s6[remoteInputs.length];
            for (int i8 = 0; i8 < remoteInputs.length; i8++) {
                RemoteInput remoteInput = remoteInputs[i8];
                s6VarArr2[i8] = new s6(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
            }
            s6VarArr = s6VarArr2;
        }
        int i9 = Build.VERSION.SDK_INT;
        boolean z7 = i9 >= 24 ? action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies() : action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        boolean z8 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        int semanticAction = i9 >= 28 ? action.getSemanticAction() : action.getExtras().getInt("android.support.action.semanticAction", 0);
        boolean zIsContextual = i9 >= 29 ? action.isContextual() : false;
        boolean zIsAuthenticationRequired = i9 >= 31 ? action.isAuthenticationRequired() : false;
        if (action.getIcon() != null || (i7 = action.icon) == 0) {
            return new b(action.getIcon() != null ? IconCompat.n(action.getIcon()) : null, action.title, action.actionIntent, action.getExtras(), s6VarArr, (s6[]) null, z7, semanticAction, z8, zIsContextual, zIsAuthenticationRequired);
        }
        return new b(i7, action.title, action.actionIntent, action.getExtras(), s6VarArr, (s6[]) null, z7, semanticAction, z8, zIsContextual, zIsAuthenticationRequired);
    }

    public static int c(@c.m0 Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean d(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return notification.getAllowSystemGeneratedContextualActions();
        }
        return false;
    }

    public static boolean e(@c.m0 Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int f(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    @c.o0
    public static f g(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return f.a(notification.getBubbleMetadata());
        }
        return null;
    }

    @c.o0
    public static String h(@c.m0 Notification notification) {
        return notification.category;
    }

    @c.o0
    public static String i(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    public static int j(@c.m0 Notification notification) {
        return notification.color;
    }

    @c.o0
    @c.t0(19)
    public static CharSequence k(@c.m0 Notification notification) {
        return notification.extras.getCharSequence(F);
    }

    @c.o0
    @c.t0(19)
    public static CharSequence l(@c.m0 Notification notification) {
        return notification.extras.getCharSequence(C);
    }

    @c.o0
    @c.t0(19)
    public static CharSequence m(@c.m0 Notification notification) {
        return notification.extras.getCharSequence(A);
    }

    @c.o0
    public static Bundle n(@c.m0 Notification notification) {
        return notification.extras;
    }

    @c.o0
    public static String o(@c.m0 Notification notification) {
        return notification.getGroup();
    }

    public static int p(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    static boolean q(@c.m0 Notification notification) {
        return (notification.flags & 128) != 0;
    }

    @c.t0(21)
    @c.m0
    public static List<b> r(@c.m0 Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle2 != null && (bundle = bundle2.getBundle("invisible_actions")) != null) {
            for (int i7 = 0; i7 < bundle.size(); i7++) {
                arrayList.add(y4.g(bundle.getBundle(Integer.toString(i7))));
            }
        }
        return arrayList;
    }

    public static boolean s(@c.m0 Notification notification) {
        return (notification.flags & 256) != 0;
    }

    @c.o0
    public static androidx.core.content.p t(@c.m0 Notification notification) {
        LocusId locusId;
        if (Build.VERSION.SDK_INT < 29 || (locusId = notification.getLocusId()) == null) {
            return null;
        }
        return androidx.core.content.p.d(locusId);
    }

    @c.m0
    static Notification[] u(@c.m0 Bundle bundle, @c.m0 String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i7 = 0; i7 < parcelableArray.length; i7++) {
            notificationArr[i7] = (Notification) parcelableArray[i7];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static boolean v(@c.m0 Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean w(@c.m0 Notification notification) {
        return (notification.flags & 8) != 0;
    }

    @c.m0
    public static List<r5> x(@c.m0 Notification notification) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(Z);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(r5.a(a2.a(it.next())));
                }
            }
        } else {
            String[] stringArray = notification.extras.getStringArray(Y);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    arrayList.add(new r5.c().g(str).a());
                }
            }
        }
        return arrayList;
    }

    @c.o0
    public static Notification y(@c.m0 Notification notification) {
        return notification.publicVersion;
    }

    @c.o0
    public static CharSequence z(@c.m0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getSettingsText();
        }
        return null;
    }

    public static final class h implements j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        static final String f5328d = "android.car.EXTENSIONS";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f5329e = "large_icon";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f5330f = "car_conversation";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f5331g = "app_color";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        static final String f5332h = "invisible_actions";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f5333i = "author";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f5334j = "text";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f5335k = "messages";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f5336l = "remote_input";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f5337m = "on_reply";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f5338n = "on_read";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f5339o = "participants";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final String f5340p = "timestamp";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bitmap f5341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f5342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5343c;

        @Deprecated
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String[] f5344a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final s6 f5345b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final PendingIntent f5346c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final PendingIntent f5347d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final String[] f5348e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final long f5349f;

            /* JADX INFO: renamed from: androidx.core.app.l2$h$a$a, reason: collision with other inner class name */
            public static class C0053a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final List<String> f5350a = new ArrayList();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final String f5351b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private s6 f5352c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private PendingIntent f5353d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private PendingIntent f5354e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private long f5355f;

                public C0053a(@c.m0 String str) {
                    this.f5351b = str;
                }

                @c.m0
                public C0053a a(@c.o0 String str) {
                    if (str != null) {
                        this.f5350a.add(str);
                    }
                    return this;
                }

                @c.m0
                public a b() {
                    List<String> list = this.f5350a;
                    return new a((String[]) list.toArray(new String[list.size()]), this.f5352c, this.f5354e, this.f5353d, new String[]{this.f5351b}, this.f5355f);
                }

                @c.m0
                public C0053a c(long j7) {
                    this.f5355f = j7;
                    return this;
                }

                @c.m0
                public C0053a d(@c.o0 PendingIntent pendingIntent) {
                    this.f5353d = pendingIntent;
                    return this;
                }

                @c.m0
                public C0053a e(@c.o0 PendingIntent pendingIntent, @c.o0 s6 s6Var) {
                    this.f5352c = s6Var;
                    this.f5354e = pendingIntent;
                    return this;
                }
            }

            a(@c.o0 String[] strArr, @c.o0 s6 s6Var, @c.o0 PendingIntent pendingIntent, @c.o0 PendingIntent pendingIntent2, @c.o0 String[] strArr2, long j7) {
                this.f5344a = strArr;
                this.f5345b = s6Var;
                this.f5347d = pendingIntent2;
                this.f5346c = pendingIntent;
                this.f5348e = strArr2;
                this.f5349f = j7;
            }

            public long a() {
                return this.f5349f;
            }

            @c.o0
            public String[] b() {
                return this.f5344a;
            }

            @c.o0
            public String c() {
                String[] strArr = this.f5348e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @c.o0
            public String[] d() {
                return this.f5348e;
            }

            @c.o0
            public PendingIntent e() {
                return this.f5347d;
            }

            @c.o0
            public s6 f() {
                return this.f5345b;
            }

            @c.o0
            public PendingIntent g() {
                return this.f5346c;
            }
        }

        public h() {
            this.f5343c = 0;
        }

        @c.t0(21)
        private static Bundle b(@c.m0 a aVar) {
            Bundle bundle = new Bundle();
            String str = (aVar.d() == null || aVar.d().length <= 1) ? null : aVar.d()[0];
            int length = aVar.b().length;
            Parcelable[] parcelableArr = new Parcelable[length];
            for (int i7 = 0; i7 < length; i7++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", aVar.b()[i7]);
                bundle2.putString(f5333i, str);
                parcelableArr[i7] = bundle2;
            }
            bundle.putParcelableArray(f5335k, parcelableArr);
            s6 s6VarF = aVar.f();
            if (s6VarF != null) {
                bundle.putParcelable(f5336l, new RemoteInput.Builder(s6VarF.o()).setLabel(s6VarF.n()).setChoices(s6VarF.h()).setAllowFreeFormInput(s6VarF.f()).addExtras(s6VarF.m()).build());
            }
            bundle.putParcelable(f5337m, aVar.g());
            bundle.putParcelable(f5338n, aVar.e());
            bundle.putStringArray(f5339o, aVar.d());
            bundle.putLong("timestamp", aVar.a());
            return bundle;
        }

        @c.t0(21)
        private static a f(@c.o0 Bundle bundle) {
            String[] strArr;
            boolean z7;
            s6 s6Var = null;
            if (bundle == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(f5335k);
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                String[] strArr2 = new String[length];
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z7 = true;
                        break;
                    }
                    Parcelable parcelable = parcelableArray[i7];
                    if (parcelable instanceof Bundle) {
                        String string = ((Bundle) parcelable).getString("text");
                        strArr2[i7] = string;
                        if (string != null) {
                            i7++;
                        }
                    }
                    z7 = false;
                    break;
                }
                if (!z7) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(f5338n);
            PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable(f5337m);
            RemoteInput remoteInput = (RemoteInput) bundle.getParcelable(f5336l);
            String[] stringArray = bundle.getStringArray(f5339o);
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            if (remoteInput != null) {
                s6Var = new s6(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
            }
            return new a(strArr, s6Var, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
        }

        @Override // androidx.core.app.l2.j
        @c.m0
        public g a(@c.m0 g gVar) {
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.f5341a;
            if (bitmap != null) {
                bundle.putParcelable(f5329e, bitmap);
            }
            int i7 = this.f5343c;
            if (i7 != 0) {
                bundle.putInt(f5331g, i7);
            }
            a aVar = this.f5342b;
            if (aVar != null) {
                bundle.putBundle(f5330f, b(aVar));
            }
            gVar.t().putBundle(f5328d, bundle);
            return gVar;
        }

        @c.l
        public int c() {
            return this.f5343c;
        }

        @c.o0
        public Bitmap d() {
            return this.f5341a;
        }

        @c.o0
        @Deprecated
        public a e() {
            return this.f5342b;
        }

        @c.m0
        public h g(@c.l int i7) {
            this.f5343c = i7;
            return this;
        }

        @c.m0
        public h h(@c.o0 Bitmap bitmap) {
            this.f5341a = bitmap;
            return this;
        }

        @c.m0
        @Deprecated
        public h i(@c.o0 a aVar) {
            this.f5342b = aVar;
            return this;
        }

        public h(@c.m0 Notification notification) {
            this.f5343c = 0;
            Bundle bundle = l2.n(notification) == null ? null : l2.n(notification).getBundle(f5328d);
            if (bundle != null) {
                this.f5341a = (Bitmap) bundle.getParcelable(f5329e);
                this.f5343c = bundle.getInt(f5331g, 0);
                this.f5342b = f(bundle.getBundle(f5330f));
            }
        }
    }

    public static class l extends q {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f5358f = "androidx.core.app.NotificationCompat$InboxStyle";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ArrayList<CharSequence> f5359e = new ArrayList<>();

        public l() {
        }

        @c.m0
        public l A(@c.o0 CharSequence charSequence) {
            if (charSequence != null) {
                this.f5359e.add(g.A(charSequence));
            }
            return this;
        }

        @c.m0
        public l B(@c.o0 CharSequence charSequence) {
            this.f5382b = g.A(charSequence);
            return this;
        }

        @c.m0
        public l C(@c.o0 CharSequence charSequence) {
            this.f5383c = g.A(charSequence);
            this.f5384d = true;
            return this;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void b(h0 h0Var) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(h0Var.a()).setBigContentTitle(this.f5382b);
            if (this.f5384d) {
                bigContentTitle.setSummaryText(this.f5383c);
            }
            Iterator<CharSequence> it = this.f5359e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine(it.next());
            }
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void g(@c.m0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(l2.V);
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        protected String t() {
            return f5358f;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void y(@c.m0 Bundle bundle) {
            super.y(bundle);
            this.f5359e.clear();
            if (bundle.containsKey(l2.V)) {
                Collections.addAll(this.f5359e, bundle.getCharSequenceArray(l2.V));
            }
        }

        public l(@c.o0 g gVar) {
            z(gVar);
        }
    }

    public static class m extends q {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f5360j = "androidx.core.app.NotificationCompat$MessagingStyle";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f5361k = 25;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<a> f5362e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<a> f5363f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private r5 f5364g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @c.o0
        private CharSequence f5365h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @c.o0
        private Boolean f5366i;

        m() {
        }

        @c.o0
        public static m E(@c.m0 Notification notification) {
            q qVarS = q.s(notification);
            if (qVarS instanceof m) {
                return (m) qVarS;
            }
            return null;
        }

        @c.o0
        private a F() {
            for (int size = this.f5362e.size() - 1; size >= 0; size--) {
                a aVar = this.f5362e.get(size);
                if (aVar.g() != null && !TextUtils.isEmpty(aVar.g().f())) {
                    return aVar;
                }
            }
            if (this.f5362e.isEmpty()) {
                return null;
            }
            List<a> list = this.f5362e;
            return list.get(list.size() - 1);
        }

        private boolean L() {
            for (int size = this.f5362e.size() - 1; size >= 0; size--) {
                a aVar = this.f5362e.get(size);
                if (aVar.g() != null && aVar.g().f() == null) {
                    return true;
                }
            }
            return false;
        }

        @c.m0
        private TextAppearanceSpan N(int i7) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i7), null);
        }

        private CharSequence O(@c.m0 a aVar) {
            androidx.core.text.a aVarC = androidx.core.text.a.c();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            CharSequence charSequenceF = aVar.g() == null ? "" : aVar.g().f();
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceF);
            int iR = androidx.core.view.n2.f6743t;
            if (zIsEmpty) {
                charSequenceF = this.f5364g.f();
                if (this.f5381a.r() != 0) {
                    iR = this.f5381a.r();
                }
            }
            CharSequence charSequenceM = aVarC.m(charSequenceF);
            spannableStringBuilder.append(charSequenceM);
            spannableStringBuilder.setSpan(N(iR), spannableStringBuilder.length() - charSequenceM.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "  ").append(aVarC.m(aVar.i() != null ? aVar.i() : ""));
            return spannableStringBuilder;
        }

        @c.m0
        public m A(@c.o0 a aVar) {
            if (aVar != null) {
                this.f5363f.add(aVar);
                if (this.f5363f.size() > 25) {
                    this.f5363f.remove(0);
                }
            }
            return this;
        }

        @c.m0
        public m B(@c.o0 a aVar) {
            if (aVar != null) {
                this.f5362e.add(aVar);
                if (this.f5362e.size() > 25) {
                    this.f5362e.remove(0);
                }
            }
            return this;
        }

        @c.m0
        public m C(@c.o0 CharSequence charSequence, long j7, @c.o0 r5 r5Var) {
            B(new a(charSequence, j7, r5Var));
            return this;
        }

        @c.m0
        @Deprecated
        public m D(@c.o0 CharSequence charSequence, long j7, @c.o0 CharSequence charSequence2) {
            this.f5362e.add(new a(charSequence, j7, new r5.c().f(charSequence2).a()));
            if (this.f5362e.size() > 25) {
                this.f5362e.remove(0);
            }
            return this;
        }

        @c.o0
        public CharSequence G() {
            return this.f5365h;
        }

        @c.m0
        public List<a> H() {
            return this.f5363f;
        }

        @c.m0
        public List<a> I() {
            return this.f5362e;
        }

        @c.m0
        public r5 J() {
            return this.f5364g;
        }

        @c.o0
        @Deprecated
        public CharSequence K() {
            return this.f5364g.f();
        }

        public boolean M() {
            g gVar = this.f5381a;
            if (gVar != null && gVar.f5302a.getApplicationInfo().targetSdkVersion < 28 && this.f5366i == null) {
                return this.f5365h != null;
            }
            Boolean bool = this.f5366i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @c.m0
        public m P(@c.o0 CharSequence charSequence) {
            this.f5365h = charSequence;
            return this;
        }

        @c.m0
        public m Q(boolean z7) {
            this.f5366i = Boolean.valueOf(z7);
            return this;
        }

        @Override // androidx.core.app.l2.q
        public void a(@c.m0 Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence(l2.f5184d0, this.f5364g.f());
            bundle.putBundle(l2.f5186e0, this.f5364g.m());
            bundle.putCharSequence(l2.f5196j0, this.f5365h);
            if (this.f5365h != null && this.f5366i.booleanValue()) {
                bundle.putCharSequence(l2.f5188f0, this.f5365h);
            }
            if (!this.f5362e.isEmpty()) {
                bundle.putParcelableArray(l2.f5190g0, a.a(this.f5362e));
            }
            if (!this.f5363f.isEmpty()) {
                bundle.putParcelableArray(l2.f5192h0, a.a(this.f5363f));
            }
            Boolean bool = this.f5366i;
            if (bool != null) {
                bundle.putBoolean(l2.f5194i0, bool.booleanValue());
            }
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public void b(h0 h0Var) {
            Notification.MessagingStyle messagingStyleA;
            Q(M());
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 24) {
                if (i7 >= 28) {
                    v3.a();
                    messagingStyleA = u3.a(this.f5364g.k());
                } else {
                    v3.a();
                    messagingStyleA = t3.a(this.f5364g.f());
                }
                Iterator<a> it = this.f5362e.iterator();
                while (it.hasNext()) {
                    messagingStyleA.addMessage(it.next().l());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    Iterator<a> it2 = this.f5363f.iterator();
                    while (it2.hasNext()) {
                        messagingStyleA.addHistoricMessage(it2.next().l());
                    }
                }
                if (this.f5366i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    messagingStyleA.setConversationTitle(this.f5365h);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    messagingStyleA.setGroupConversation(this.f5366i.booleanValue());
                }
                messagingStyleA.setBuilder(h0Var.a());
                return;
            }
            a aVarF = F();
            if (this.f5365h != null && this.f5366i.booleanValue()) {
                h0Var.a().setContentTitle(this.f5365h);
            } else if (aVarF != null) {
                h0Var.a().setContentTitle("");
                if (aVarF.g() != null) {
                    h0Var.a().setContentTitle(aVarF.g().f());
                }
            }
            if (aVarF != null) {
                h0Var.a().setContentText(this.f5365h != null ? O(aVarF) : aVarF.i());
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z7 = this.f5365h != null || L();
            for (int size = this.f5362e.size() - 1; size >= 0; size--) {
                a aVar = this.f5362e.get(size);
                CharSequence charSequenceO = z7 ? O(aVar) : aVar.i();
                if (size != this.f5362e.size() - 1) {
                    spannableStringBuilder.insert(0, (CharSequence) "\n");
                }
                spannableStringBuilder.insert(0, charSequenceO);
            }
            new Notification.BigTextStyle(h0Var.a()).setBigContentTitle(null).bigText(spannableStringBuilder);
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void g(@c.m0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(l2.f5186e0);
            bundle.remove(l2.f5184d0);
            bundle.remove(l2.f5188f0);
            bundle.remove(l2.f5196j0);
            bundle.remove(l2.f5190g0);
            bundle.remove(l2.f5192h0);
            bundle.remove(l2.f5194i0);
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        protected String t() {
            return f5360j;
        }

        @Override // androidx.core.app.l2.q
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected void y(@c.m0 Bundle bundle) {
            super.y(bundle);
            this.f5362e.clear();
            if (bundle.containsKey(l2.f5186e0)) {
                this.f5364g = r5.b(bundle.getBundle(l2.f5186e0));
            } else {
                this.f5364g = new r5.c().f(bundle.getString(l2.f5184d0)).a();
            }
            CharSequence charSequence = bundle.getCharSequence(l2.f5188f0);
            this.f5365h = charSequence;
            if (charSequence == null) {
                this.f5365h = bundle.getCharSequence(l2.f5196j0);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(l2.f5190g0);
            if (parcelableArray != null) {
                this.f5362e.addAll(a.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray(l2.f5192h0);
            if (parcelableArray2 != null) {
                this.f5363f.addAll(a.f(parcelableArray2));
            }
            if (bundle.containsKey(l2.f5194i0)) {
                this.f5366i = Boolean.valueOf(bundle.getBoolean(l2.f5194i0));
            }
        }

        @Deprecated
        public m(@c.m0 CharSequence charSequence) {
            this.f5364g = new r5.c().f(charSequence).a();
        }

        public static final class a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            static final String f5367g = "text";

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            static final String f5368h = "time";

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            static final String f5369i = "sender";

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            static final String f5370j = "type";

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            static final String f5371k = "uri";

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            static final String f5372l = "extras";

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            static final String f5373m = "person";

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            static final String f5374n = "sender_person";

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CharSequence f5375a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f5376b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @c.o0
            private final r5 f5377c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private Bundle f5378d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @c.o0
            private String f5379e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @c.o0
            private Uri f5380f;

            public a(@c.o0 CharSequence charSequence, long j7, @c.o0 r5 r5Var) {
                this.f5378d = new Bundle();
                this.f5375a = charSequence;
                this.f5376b = j7;
                this.f5377c = r5Var;
            }

            @c.m0
            static Bundle[] a(@c.m0 List<a> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i7 = 0; i7 < size; i7++) {
                    bundleArr[i7] = list.get(i7).m();
                }
                return bundleArr;
            }

            @c.o0
            static a e(@c.m0 Bundle bundle) {
                r5 r5VarA;
                try {
                    if (bundle.containsKey("text") && bundle.containsKey(f5368h)) {
                        if (bundle.containsKey(f5373m)) {
                            r5VarA = r5.b(bundle.getBundle(f5373m));
                        } else if (!bundle.containsKey(f5374n) || Build.VERSION.SDK_INT < 28) {
                            r5VarA = bundle.containsKey(f5369i) ? new r5.c().f(bundle.getCharSequence(f5369i)).a() : null;
                        } else {
                            r5VarA = r5.a(a2.a(bundle.getParcelable(f5374n)));
                        }
                        a aVar = new a(bundle.getCharSequence("text"), bundle.getLong(f5368h), r5VarA);
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            aVar.k(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey(f5372l)) {
                            aVar.d().putAll(bundle.getBundle(f5372l));
                        }
                        return aVar;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @c.m0
            static List<a> f(@c.m0 Parcelable[] parcelableArr) {
                a aVarE;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Parcelable parcelable : parcelableArr) {
                    if ((parcelable instanceof Bundle) && (aVarE = e((Bundle) parcelable)) != null) {
                        arrayList.add(aVarE);
                    }
                }
                return arrayList;
            }

            @c.m0
            private Bundle m() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f5375a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(f5368h, this.f5376b);
                r5 r5Var = this.f5377c;
                if (r5Var != null) {
                    bundle.putCharSequence(f5369i, r5Var.f());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(f5374n, this.f5377c.k());
                    } else {
                        bundle.putBundle(f5373m, this.f5377c.m());
                    }
                }
                String str = this.f5379e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f5380f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f5378d;
                if (bundle2 != null) {
                    bundle.putBundle(f5372l, bundle2);
                }
                return bundle;
            }

            @c.o0
            public String b() {
                return this.f5379e;
            }

            @c.o0
            public Uri c() {
                return this.f5380f;
            }

            @c.m0
            public Bundle d() {
                return this.f5378d;
            }

            @c.o0
            public r5 g() {
                return this.f5377c;
            }

            @c.o0
            @Deprecated
            public CharSequence h() {
                r5 r5Var = this.f5377c;
                if (r5Var == null) {
                    return null;
                }
                return r5Var.f();
            }

            @c.o0
            public CharSequence i() {
                return this.f5375a;
            }

            public long j() {
                return this.f5376b;
            }

            @c.m0
            public a k(@c.o0 String str, @c.o0 Uri uri) {
                this.f5379e = str;
                this.f5380f = uri;
                return this;
            }

            @c.t0(24)
            @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
            @c.m0
            Notification.MessagingStyle.Message l() {
                Notification.MessagingStyle.Message messageA;
                r5 r5VarG = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    z3.a();
                    messageA = y3.a(i(), j(), r5VarG != null ? r5VarG.k() : null);
                } else {
                    z3.a();
                    messageA = x3.a(i(), j(), r5VarG != null ? r5VarG.f() : null);
                }
                if (b() != null) {
                    messageA.setData(b(), c());
                }
                return messageA;
            }

            @Deprecated
            public a(@c.o0 CharSequence charSequence, long j7, @c.o0 CharSequence charSequence2) {
                this(charSequence, j7, new r5.c().f(charSequence2).a());
            }
        }

        public m(@c.m0 r5 r5Var) {
            if (!TextUtils.isEmpty(r5Var.f())) {
                this.f5364g = r5Var;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }

    public static final class r implements j {
        private static final String A = "displayIntent";
        private static final String B = "pages";
        private static final String C = "background";
        private static final String D = "contentIcon";
        private static final String E = "contentIconGravity";
        private static final String F = "contentActionIndex";
        private static final String G = "customSizePreset";
        private static final String H = "customContentHeight";
        private static final String I = "gravity";

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private static final String f5385J = "hintScreenTimeout";
        private static final String K = "dismissalId";
        private static final String L = "bridgeTag";
        private static final int M = 1;
        private static final int N = 2;
        private static final int O = 4;
        private static final int P = 8;
        private static final int Q = 16;
        private static final int R = 32;
        private static final int S = 64;
        private static final int T = 1;
        private static final int U = 8388613;
        private static final int V = 80;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f5386o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Deprecated
        public static final int f5387p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @Deprecated
        public static final int f5388q = 1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Deprecated
        public static final int f5389r = 2;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Deprecated
        public static final int f5390s = 3;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Deprecated
        public static final int f5391t = 4;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Deprecated
        public static final int f5392u = 5;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Deprecated
        public static final int f5393v = 0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Deprecated
        public static final int f5394w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final String f5395x = "android.wearable.EXTENSIONS";

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final String f5396y = "actions";

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final String f5397z = "flags";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<b> f5398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PendingIntent f5400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList<Notification> f5401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f5402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5403f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5404g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f5405h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f5406i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f5407j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f5408k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f5409l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f5410m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f5411n;

        public r() {
            this.f5398a = new ArrayList<>();
            this.f5399b = 1;
            this.f5401d = new ArrayList<>();
            this.f5404g = 8388613;
            this.f5405h = -1;
            this.f5406i = 0;
            this.f5408k = V;
        }

        private void N(int i7, boolean z7) {
            if (z7) {
                this.f5399b = i7 | this.f5399b;
            } else {
                this.f5399b = (~i7) & this.f5399b;
            }
        }

        @c.t0(20)
        private static Notification.Action i(b bVar) {
            int i7 = Build.VERSION.SDK_INT;
            IconCompat iconCompatF = bVar.f();
            Notification.Action.Builder builder = new Notification.Action.Builder(iconCompatF == null ? null : iconCompatF.L(), bVar.j(), bVar.a());
            Bundle bundle = bVar.d() != null ? new Bundle(bVar.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", bVar.b());
            if (i7 >= 24) {
                builder.setAllowGeneratedReplies(bVar.b());
            }
            if (i7 >= 31) {
                builder.setAuthenticationRequired(bVar.k());
            }
            builder.addExtras(bundle);
            s6[] s6VarArrG = bVar.g();
            if (s6VarArrG != null) {
                for (RemoteInput remoteInput : s6.d(s6VarArrG)) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            return builder.build();
        }

        @Deprecated
        public boolean A() {
            return (this.f5399b & 4) != 0;
        }

        @c.m0
        @Deprecated
        public List<Notification> B() {
            return this.f5401d;
        }

        public boolean C() {
            return (this.f5399b & 8) != 0;
        }

        @c.m0
        @Deprecated
        public r D(@c.o0 Bitmap bitmap) {
            this.f5402e = bitmap;
            return this;
        }

        @c.m0
        public r E(@c.o0 String str) {
            this.f5411n = str;
            return this;
        }

        @c.m0
        public r F(int i7) {
            this.f5405h = i7;
            return this;
        }

        @c.m0
        @Deprecated
        public r G(int i7) {
            this.f5403f = i7;
            return this;
        }

        @c.m0
        @Deprecated
        public r H(int i7) {
            this.f5404g = i7;
            return this;
        }

        @c.m0
        public r I(boolean z7) {
            N(1, z7);
            return this;
        }

        @c.m0
        @Deprecated
        public r J(int i7) {
            this.f5407j = i7;
            return this;
        }

        @c.m0
        @Deprecated
        public r K(int i7) {
            this.f5406i = i7;
            return this;
        }

        @c.m0
        public r L(@c.o0 String str) {
            this.f5410m = str;
            return this;
        }

        @c.m0
        @Deprecated
        public r M(@c.o0 PendingIntent pendingIntent) {
            this.f5400c = pendingIntent;
            return this;
        }

        @c.m0
        @Deprecated
        public r O(int i7) {
            this.f5408k = i7;
            return this;
        }

        @c.m0
        @Deprecated
        public r P(boolean z7) {
            N(32, z7);
            return this;
        }

        @c.m0
        @Deprecated
        public r Q(boolean z7) {
            N(16, z7);
            return this;
        }

        @c.m0
        public r R(boolean z7) {
            N(64, z7);
            return this;
        }

        @c.m0
        @Deprecated
        public r S(boolean z7) {
            N(2, z7);
            return this;
        }

        @c.m0
        @Deprecated
        public r T(int i7) {
            this.f5409l = i7;
            return this;
        }

        @c.m0
        @Deprecated
        public r U(boolean z7) {
            N(4, z7);
            return this;
        }

        @c.m0
        public r V(boolean z7) {
            N(8, z7);
            return this;
        }

        @Override // androidx.core.app.l2.j
        @c.m0
        public g a(@c.m0 g gVar) {
            Bundle bundle = new Bundle();
            if (!this.f5398a.isEmpty()) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f5398a.size());
                Iterator<b> it = this.f5398a.iterator();
                while (it.hasNext()) {
                    arrayList.add(i(it.next()));
                }
                bundle.putParcelableArrayList(f5396y, arrayList);
            }
            int i7 = this.f5399b;
            if (i7 != 1) {
                bundle.putInt(f5397z, i7);
            }
            PendingIntent pendingIntent = this.f5400c;
            if (pendingIntent != null) {
                bundle.putParcelable(A, pendingIntent);
            }
            if (!this.f5401d.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.f5401d;
                bundle.putParcelableArray(B, (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.f5402e;
            if (bitmap != null) {
                bundle.putParcelable(C, bitmap);
            }
            int i8 = this.f5403f;
            if (i8 != 0) {
                bundle.putInt(D, i8);
            }
            int i9 = this.f5404g;
            if (i9 != 8388613) {
                bundle.putInt(E, i9);
            }
            int i10 = this.f5405h;
            if (i10 != -1) {
                bundle.putInt(F, i10);
            }
            int i11 = this.f5406i;
            if (i11 != 0) {
                bundle.putInt(G, i11);
            }
            int i12 = this.f5407j;
            if (i12 != 0) {
                bundle.putInt(H, i12);
            }
            int i13 = this.f5408k;
            if (i13 != V) {
                bundle.putInt(I, i13);
            }
            int i14 = this.f5409l;
            if (i14 != 0) {
                bundle.putInt(f5385J, i14);
            }
            String str = this.f5410m;
            if (str != null) {
                bundle.putString(K, str);
            }
            String str2 = this.f5411n;
            if (str2 != null) {
                bundle.putString(L, str2);
            }
            gVar.t().putBundle(f5395x, bundle);
            return gVar;
        }

        @c.m0
        public r b(@c.m0 b bVar) {
            this.f5398a.add(bVar);
            return this;
        }

        @c.m0
        public r c(@c.m0 List<b> list) {
            this.f5398a.addAll(list);
            return this;
        }

        @c.m0
        @Deprecated
        public r d(@c.m0 Notification notification) {
            this.f5401d.add(notification);
            return this;
        }

        @c.m0
        @Deprecated
        public r e(@c.m0 List<Notification> list) {
            this.f5401d.addAll(list);
            return this;
        }

        @c.m0
        public r f() {
            this.f5398a.clear();
            return this;
        }

        @c.m0
        @Deprecated
        public r g() {
            this.f5401d.clear();
            return this;
        }

        @c.m0
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public r clone() {
            r rVar = new r();
            rVar.f5398a = new ArrayList<>(this.f5398a);
            rVar.f5399b = this.f5399b;
            rVar.f5400c = this.f5400c;
            rVar.f5401d = new ArrayList<>(this.f5401d);
            rVar.f5402e = this.f5402e;
            rVar.f5403f = this.f5403f;
            rVar.f5404g = this.f5404g;
            rVar.f5405h = this.f5405h;
            rVar.f5406i = this.f5406i;
            rVar.f5407j = this.f5407j;
            rVar.f5408k = this.f5408k;
            rVar.f5409l = this.f5409l;
            rVar.f5410m = this.f5410m;
            rVar.f5411n = this.f5411n;
            return rVar;
        }

        @c.m0
        public List<b> j() {
            return this.f5398a;
        }

        @c.o0
        @Deprecated
        public Bitmap k() {
            return this.f5402e;
        }

        @c.o0
        public String l() {
            return this.f5411n;
        }

        public int m() {
            return this.f5405h;
        }

        @Deprecated
        public int n() {
            return this.f5403f;
        }

        @Deprecated
        public int o() {
            return this.f5404g;
        }

        public boolean p() {
            return (this.f5399b & 1) != 0;
        }

        @Deprecated
        public int q() {
            return this.f5407j;
        }

        @Deprecated
        public int r() {
            return this.f5406i;
        }

        @c.o0
        public String s() {
            return this.f5410m;
        }

        @c.o0
        @Deprecated
        public PendingIntent t() {
            return this.f5400c;
        }

        @Deprecated
        public int u() {
            return this.f5408k;
        }

        @Deprecated
        public boolean v() {
            return (this.f5399b & 32) != 0;
        }

        @Deprecated
        public boolean w() {
            return (this.f5399b & 16) != 0;
        }

        public boolean x() {
            return (this.f5399b & 64) != 0;
        }

        @Deprecated
        public boolean y() {
            return (this.f5399b & 2) != 0;
        }

        @Deprecated
        public int z() {
            return this.f5409l;
        }

        public r(@c.m0 Notification notification) {
            this.f5398a = new ArrayList<>();
            this.f5399b = 1;
            this.f5401d = new ArrayList<>();
            this.f5404g = 8388613;
            this.f5405h = -1;
            this.f5406i = 0;
            this.f5408k = V;
            Bundle bundleN = l2.n(notification);
            Bundle bundle = bundleN != null ? bundleN.getBundle(f5395x) : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(f5396y);
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    b[] bVarArr = new b[size];
                    for (int i7 = 0; i7 < size; i7++) {
                        bVarArr[i7] = l2.b((Notification.Action) parcelableArrayList.get(i7));
                    }
                    Collections.addAll(this.f5398a, bVarArr);
                }
                this.f5399b = bundle.getInt(f5397z, 1);
                this.f5400c = (PendingIntent) bundle.getParcelable(A);
                Notification[] notificationArrU = l2.u(bundle, B);
                if (notificationArrU != null) {
                    Collections.addAll(this.f5401d, notificationArrU);
                }
                this.f5402e = (Bitmap) bundle.getParcelable(C);
                this.f5403f = bundle.getInt(D);
                this.f5404g = bundle.getInt(E, 8388613);
                this.f5405h = bundle.getInt(F, -1);
                this.f5406i = bundle.getInt(G, 0);
                this.f5407j = bundle.getInt(H);
                this.f5408k = bundle.getInt(I, V);
                this.f5409l = bundle.getInt(f5385J);
                this.f5410m = bundle.getString(K);
                this.f5411n = bundle.getString(L);
            }
        }
    }

    public static class g {
        private static final int Y = 5120;
        boolean A;
        boolean B;
        boolean C;
        String D;
        Bundle E;
        int F;
        int G;
        Notification H;
        RemoteViews I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        RemoteViews f5301J;
        RemoteViews K;
        String L;
        int M;
        String N;
        androidx.core.content.p O;
        long P;
        int Q;
        int R;
        boolean S;
        f T;
        Notification U;
        boolean V;
        Icon W;

        @Deprecated
        public ArrayList<String> X;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public Context f5302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public ArrayList<b> f5303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        public ArrayList<r5> f5304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<b> f5305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f5306e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        CharSequence f5307f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        PendingIntent f5308g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PendingIntent f5309h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        RemoteViews f5310i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Bitmap f5311j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        CharSequence f5312k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f5313l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f5314m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f5315n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f5316o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f5317p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        q f5318q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        CharSequence f5319r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        CharSequence f5320s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        CharSequence[] f5321t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f5322u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        int f5323v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f5324w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        String f5325x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        boolean f5326y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        String f5327z;

        @c.t0(19)
        public g(@c.m0 Context context, @c.m0 Notification notification) {
            ArrayList parcelableArrayList;
            this(context, l2.i(notification));
            Bundle bundle = notification.extras;
            q qVarS = q.s(notification);
            P(l2.m(notification)).O(l2.l(notification)).M(l2.k(notification)).A0(l2.D(notification)).o0(l2.z(notification)).z0(qVarS).N(notification.contentIntent).Z(l2.o(notification)).b0(l2.H(notification)).f0(l2.t(notification)).H0(notification.when).r0(l2.B(notification)).E0(l2.F(notification)).D(l2.e(notification)).j0(l2.w(notification)).i0(l2.v(notification)).e0(l2.s(notification)).c0(notification.largeIcon).E(l2.f(notification)).G(l2.h(notification)).F(l2.g(notification)).h0(notification.number).B0(notification.tickerText).N(notification.contentIntent).U(notification.deleteIntent).Y(notification.fullScreenIntent, l2.q(notification)).y0(notification.sound, notification.audioStreamType).F0(notification.vibrate).d0(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).T(notification.defaults).k0(notification.priority).J(l2.j(notification)).G0(l2.G(notification)).m0(l2.y(notification)).w0(l2.C(notification)).D0(l2.E(notification)).p0(l2.A(notification)).l0(bundle.getInt(l2.M), bundle.getInt(l2.L), bundle.getBoolean(l2.N)).C(l2.d(notification)).u0(notification.icon, notification.iconLevel).c(u(notification, qVarS));
            this.W = notification.getSmallIcon();
            Notification.Action[] actionArr = notification.actions;
            if (actionArr != null && actionArr.length != 0) {
                for (Notification.Action action : actionArr) {
                    b(b.a.f(action).c());
                }
            }
            List<b> listR = l2.r(notification);
            if (!listR.isEmpty()) {
                Iterator<b> it = listR.iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
            }
            String[] stringArray = notification.extras.getStringArray(l2.Y);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    g(str);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(l2.Z)) != null && !parcelableArrayList.isEmpty()) {
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    f(r5.a(a2.a(it2.next())));
                }
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 24 && bundle.containsKey(l2.P)) {
                I(bundle.getBoolean(l2.P));
            }
            if (i7 < 26 || !bundle.containsKey(l2.Q)) {
                return;
            }
            K(bundle.getBoolean(l2.Q));
        }

        @c.o0
        protected static CharSequence A(@c.o0 CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > Y) ? charSequence.subSequence(0, Y) : charSequence;
        }

        @c.o0
        private Bitmap B(@c.o0 Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f5302a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
        }

        private boolean I0() {
            q qVar = this.f5318q;
            return qVar == null || !qVar.r();
        }

        private void W(int i7, boolean z7) {
            if (z7) {
                Notification notification = this.U;
                notification.flags = i7 | notification.flags;
            } else {
                Notification notification2 = this.U;
                notification2.flags = (~i7) & notification2.flags;
            }
        }

        @c.o0
        @c.t0(19)
        private static Bundle u(@c.m0 Notification notification, @c.o0 q qVar) {
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove(l2.A);
            bundle.remove(l2.C);
            bundle.remove(l2.F);
            bundle.remove(l2.D);
            bundle.remove(l2.f5179b);
            bundle.remove(l2.f5181c);
            bundle.remove(l2.R);
            bundle.remove(l2.L);
            bundle.remove(l2.M);
            bundle.remove(l2.N);
            bundle.remove(l2.P);
            bundle.remove(l2.Q);
            bundle.remove(l2.Z);
            bundle.remove(l2.Y);
            bundle.remove(x4.f5537d);
            bundle.remove(x4.f5535b);
            bundle.remove(x4.f5536c);
            bundle.remove(x4.f5534a);
            bundle.remove(x4.f5538e);
            Bundle bundle2 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle2 != null) {
                Bundle bundle3 = new Bundle(bundle2);
                bundle3.remove("invisible_actions");
                bundle.putBundle("android.car.EXTENSIONS", bundle3);
            }
            if (qVar != null) {
                qVar.g(bundle);
            }
            return bundle;
        }

        @c.m0
        public g A0(@c.o0 CharSequence charSequence) {
            this.f5319r = A(charSequence);
            return this;
        }

        @c.m0
        public g B0(@c.o0 CharSequence charSequence) {
            this.U.tickerText = A(charSequence);
            return this;
        }

        @c.m0
        public g C(boolean z7) {
            this.S = z7;
            return this;
        }

        @c.m0
        @Deprecated
        public g C0(@c.o0 CharSequence charSequence, @c.o0 RemoteViews remoteViews) {
            this.U.tickerText = A(charSequence);
            this.f5310i = remoteViews;
            return this;
        }

        @c.m0
        public g D(boolean z7) {
            W(16, z7);
            return this;
        }

        @c.m0
        public g D0(long j7) {
            this.P = j7;
            return this;
        }

        @c.m0
        public g E(int i7) {
            this.M = i7;
            return this;
        }

        @c.m0
        public g E0(boolean z7) {
            this.f5316o = z7;
            return this;
        }

        @c.m0
        public g F(@c.o0 f fVar) {
            this.T = fVar;
            return this;
        }

        @c.m0
        public g F0(@c.o0 long[] jArr) {
            this.U.vibrate = jArr;
            return this;
        }

        @c.m0
        public g G(@c.o0 String str) {
            this.D = str;
            return this;
        }

        @c.m0
        public g G0(int i7) {
            this.G = i7;
            return this;
        }

        @c.m0
        public g H(@c.m0 String str) {
            this.L = str;
            return this;
        }

        @c.m0
        public g H0(long j7) {
            this.U.when = j7;
            return this;
        }

        @c.t0(24)
        @c.m0
        public g I(boolean z7) {
            this.f5317p = z7;
            t().putBoolean(l2.P, z7);
            return this;
        }

        @c.m0
        public g J(@c.l int i7) {
            this.F = i7;
            return this;
        }

        @c.m0
        public g K(boolean z7) {
            this.B = z7;
            this.C = true;
            return this;
        }

        @c.m0
        public g L(@c.o0 RemoteViews remoteViews) {
            this.U.contentView = remoteViews;
            return this;
        }

        @c.m0
        public g M(@c.o0 CharSequence charSequence) {
            this.f5312k = A(charSequence);
            return this;
        }

        @c.m0
        public g N(@c.o0 PendingIntent pendingIntent) {
            this.f5308g = pendingIntent;
            return this;
        }

        @c.m0
        public g O(@c.o0 CharSequence charSequence) {
            this.f5307f = A(charSequence);
            return this;
        }

        @c.m0
        public g P(@c.o0 CharSequence charSequence) {
            this.f5306e = A(charSequence);
            return this;
        }

        @c.m0
        public g Q(@c.o0 RemoteViews remoteViews) {
            this.f5301J = remoteViews;
            return this;
        }

        @c.m0
        public g R(@c.o0 RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        @c.m0
        public g S(@c.o0 RemoteViews remoteViews) {
            this.K = remoteViews;
            return this;
        }

        @c.m0
        public g T(int i7) {
            Notification notification = this.U;
            notification.defaults = i7;
            if ((i7 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @c.m0
        public g U(@c.o0 PendingIntent pendingIntent) {
            this.U.deleteIntent = pendingIntent;
            return this;
        }

        @c.m0
        public g V(@c.o0 Bundle bundle) {
            this.E = bundle;
            return this;
        }

        @c.m0
        public g X(int i7) {
            this.R = i7;
            return this;
        }

        @c.m0
        public g Y(@c.o0 PendingIntent pendingIntent, boolean z7) {
            this.f5309h = pendingIntent;
            W(128, z7);
            return this;
        }

        @c.m0
        public g Z(@c.o0 String str) {
            this.f5325x = str;
            return this;
        }

        @c.m0
        public g a(int i7, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent) {
            this.f5303b.add(new b(i7, charSequence, pendingIntent));
            return this;
        }

        @c.m0
        public g a0(int i7) {
            this.Q = i7;
            return this;
        }

        @c.m0
        public g b(@c.o0 b bVar) {
            if (bVar != null) {
                this.f5303b.add(bVar);
            }
            return this;
        }

        @c.m0
        public g b0(boolean z7) {
            this.f5326y = z7;
            return this;
        }

        @c.m0
        public g c(@c.o0 Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.E;
                if (bundle2 == null) {
                    this.E = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @c.m0
        public g c0(@c.o0 Bitmap bitmap) {
            this.f5311j = B(bitmap);
            return this;
        }

        @c.t0(21)
        @c.m0
        public g d(int i7, @c.o0 CharSequence charSequence, @c.o0 PendingIntent pendingIntent) {
            this.f5305d.add(new b(i7, charSequence, pendingIntent));
            return this;
        }

        @c.m0
        public g d0(@c.l int i7, int i8, int i9) {
            Notification notification = this.U;
            notification.ledARGB = i7;
            notification.ledOnMS = i8;
            notification.ledOffMS = i9;
            notification.flags = ((i8 == 0 || i9 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        @c.t0(21)
        @c.m0
        public g e(@c.o0 b bVar) {
            if (bVar != null) {
                this.f5305d.add(bVar);
            }
            return this;
        }

        @c.m0
        public g e0(boolean z7) {
            this.A = z7;
            return this;
        }

        @c.m0
        public g f(@c.o0 r5 r5Var) {
            if (r5Var != null) {
                this.f5304c.add(r5Var);
            }
            return this;
        }

        @c.m0
        public g f0(@c.o0 androidx.core.content.p pVar) {
            this.O = pVar;
            return this;
        }

        @c.m0
        @Deprecated
        public g g(@c.o0 String str) {
            if (str != null && !str.isEmpty()) {
                this.X.add(str);
            }
            return this;
        }

        @c.m0
        @Deprecated
        public g g0() {
            this.V = true;
            return this;
        }

        @c.m0
        public Notification h() {
            return new w4(this).c();
        }

        @c.m0
        public g h0(int i7) {
            this.f5313l = i7;
            return this;
        }

        @c.m0
        public g i() {
            this.f5303b.clear();
            return this;
        }

        @c.m0
        public g i0(boolean z7) {
            W(2, z7);
            return this;
        }

        @c.m0
        public g j() {
            this.f5305d.clear();
            Bundle bundle = this.E.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove("invisible_actions");
                this.E.putBundle("android.car.EXTENSIONS", bundle2);
            }
            return this;
        }

        @c.m0
        public g j0(boolean z7) {
            W(8, z7);
            return this;
        }

        @c.m0
        public g k() {
            this.f5304c.clear();
            this.X.clear();
            return this;
        }

        @c.m0
        public g k0(int i7) {
            this.f5314m = i7;
            return this;
        }

        @c.o0
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews l() {
            RemoteViews remoteViewsV;
            int i7 = Build.VERSION.SDK_INT;
            if (this.f5301J != null && I0()) {
                return this.f5301J;
            }
            w4 w4Var = new w4(this);
            q qVar = this.f5318q;
            if (qVar != null && (remoteViewsV = qVar.v(w4Var)) != null) {
                return remoteViewsV;
            }
            Notification notificationC = w4Var.c();
            return i7 >= 24 ? Notification.Builder.recoverBuilder(this.f5302a, notificationC).createBigContentView() : notificationC.bigContentView;
        }

        @c.m0
        public g l0(int i7, int i8, boolean z7) {
            this.f5322u = i7;
            this.f5323v = i8;
            this.f5324w = z7;
            return this;
        }

        @c.o0
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews m() {
            RemoteViews remoteViewsW;
            if (this.I != null && I0()) {
                return this.I;
            }
            w4 w4Var = new w4(this);
            q qVar = this.f5318q;
            if (qVar != null && (remoteViewsW = qVar.w(w4Var)) != null) {
                return remoteViewsW;
            }
            Notification notificationC = w4Var.c();
            return Build.VERSION.SDK_INT >= 24 ? Notification.Builder.recoverBuilder(this.f5302a, notificationC).createContentView() : notificationC.contentView;
        }

        @c.m0
        public g m0(@c.o0 Notification notification) {
            this.H = notification;
            return this;
        }

        @c.o0
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews n() {
            RemoteViews remoteViewsX;
            int i7 = Build.VERSION.SDK_INT;
            if (this.K != null && I0()) {
                return this.K;
            }
            w4 w4Var = new w4(this);
            q qVar = this.f5318q;
            if (qVar != null && (remoteViewsX = qVar.x(w4Var)) != null) {
                return remoteViewsX;
            }
            Notification notificationC = w4Var.c();
            return i7 >= 24 ? Notification.Builder.recoverBuilder(this.f5302a, notificationC).createHeadsUpContentView() : notificationC.headsUpContentView;
        }

        @c.m0
        public g n0(@c.o0 CharSequence[] charSequenceArr) {
            this.f5321t = charSequenceArr;
            return this;
        }

        @c.m0
        public g o(@c.m0 j jVar) {
            jVar.a(this);
            return this;
        }

        @c.m0
        public g o0(@c.o0 CharSequence charSequence) {
            this.f5320s = A(charSequence);
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews p() {
            return this.f5301J;
        }

        @c.m0
        public g p0(@c.o0 String str) {
            this.N = str;
            return this;
        }

        @c.o0
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public f q() {
            return this.T;
        }

        @c.m0
        public g q0(@c.o0 androidx.core.content.pm.x0 x0Var) {
            if (x0Var == null) {
                return this;
            }
            this.N = x0Var.k();
            if (this.O == null) {
                if (x0Var.o() != null) {
                    this.O = x0Var.o();
                } else if (x0Var.k() != null) {
                    this.O = new androidx.core.content.p(x0Var.k());
                }
            }
            if (this.f5306e == null) {
                P(x0Var.w());
            }
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.l
        public int r() {
            return this.F;
        }

        @c.m0
        public g r0(boolean z7) {
            this.f5315n = z7;
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews s() {
            return this.I;
        }

        @c.m0
        public g s0(boolean z7) {
            this.V = z7;
            return this;
        }

        @c.m0
        public Bundle t() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        @c.m0
        public g t0(int i7) {
            this.U.icon = i7;
            return this;
        }

        @c.m0
        public g u0(int i7, int i8) {
            Notification notification = this.U;
            notification.icon = i7;
            notification.iconLevel = i8;
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public int v() {
            return this.R;
        }

        @c.t0(23)
        @c.m0
        public g v0(@c.m0 IconCompat iconCompat) {
            this.W = iconCompat.M(this.f5302a);
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public RemoteViews w() {
            return this.K;
        }

        @c.m0
        public g w0(@c.o0 String str) {
            this.f5327z = str;
            return this;
        }

        @c.m0
        @Deprecated
        public Notification x() {
            return h();
        }

        @c.m0
        public g x0(@c.o0 Uri uri) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public int y() {
            return this.f5314m;
        }

        @c.m0
        public g y0(@c.o0 Uri uri, int i7) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = i7;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i7).build();
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public long z() {
            if (this.f5315n) {
                return this.U.when;
            }
            return 0L;
        }

        @c.m0
        public g z0(@c.o0 q qVar) {
            if (this.f5318q != qVar) {
                this.f5318q = qVar;
                if (qVar != null) {
                    qVar.z(this);
                }
            }
            return this;
        }

        public g(@c.m0 Context context, @c.m0 String str) {
            this.f5303b = new ArrayList<>();
            this.f5304c = new ArrayList<>();
            this.f5305d = new ArrayList<>();
            this.f5315n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.Q = 0;
            this.R = 0;
            Notification notification = new Notification();
            this.U = notification;
            this.f5302a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.U.audioStreamType = -1;
            this.f5314m = 0;
            this.X = new ArrayList<>();
            this.S = true;
        }

        @Deprecated
        public g(@c.m0 Context context) {
            this(context, (String) null);
        }
    }
}
