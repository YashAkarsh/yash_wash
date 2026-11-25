package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public interface d1 extends SpinnerAdapter {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f1810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LayoutInflater f1811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LayoutInflater f1812c;

        public a(@c.m0 Context context) {
            this.f1810a = context;
            this.f1811b = LayoutInflater.from(context);
        }

        @c.m0
        public LayoutInflater a() {
            LayoutInflater layoutInflater = this.f1812c;
            return layoutInflater != null ? layoutInflater : this.f1811b;
        }

        @c.o0
        public Resources.Theme b() {
            LayoutInflater layoutInflater = this.f1812c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void c(@c.o0 Resources.Theme theme) {
            if (theme == null) {
                this.f1812c = null;
            } else if (theme == this.f1810a.getTheme()) {
                this.f1812c = this.f1811b;
            } else {
                this.f1812c = LayoutInflater.from(new androidx.appcompat.view.d(this.f1810a, theme));
            }
        }
    }

    @c.o0
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@c.o0 Resources.Theme theme);
}
