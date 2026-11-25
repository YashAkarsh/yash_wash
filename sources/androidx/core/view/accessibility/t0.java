package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public interface t0 {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Bundle f6531a;

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public void a(@c.o0 Bundle bundle) {
            this.f6531a = bundle;
        }
    }

    public static final class b extends a {
        public boolean b() {
            return this.f6531a.getBoolean(l0.Q);
        }

        public int c() {
            return this.f6531a.getInt(l0.O);
        }
    }

    public static final class c extends a {
        @c.o0
        public String b() {
            return this.f6531a.getString(l0.P);
        }
    }

    public static final class d extends a {
        public int b() {
            return this.f6531a.getInt(l0.X);
        }

        public int c() {
            return this.f6531a.getInt(l0.Y);
        }
    }

    public static final class e extends a {
        public int b() {
            return this.f6531a.getInt(l0.V);
        }

        public int c() {
            return this.f6531a.getInt(l0.U);
        }
    }

    public static final class f extends a {
        public float b() {
            return this.f6531a.getFloat(l0.W);
        }
    }

    public static final class g extends a {
        public int b() {
            return this.f6531a.getInt(l0.S);
        }

        public int c() {
            return this.f6531a.getInt(l0.R);
        }
    }

    public static final class h extends a {
        @c.o0
        public CharSequence b() {
            return this.f6531a.getCharSequence(l0.T);
        }
    }

    boolean a(@c.m0 View view, @c.o0 a aVar);
}
