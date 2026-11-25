package f;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import c.x0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public final class a {

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    @t0(15)
    public static class C0416a {
        private C0416a() {
        }

        @t
        public static void a(@m0 Resources resources, int i7, int i8, @m0 TypedValue typedValue, boolean z7) {
            resources.getValueForDensity(i7, i8, typedValue, z7);
        }
    }

    @t0(18)
    public static class b {
        private b() {
        }

        @t
        public static void a(@m0 ObjectAnimator objectAnimator, boolean z7) {
            objectAnimator.setAutoCancel(z7);
        }
    }

    @t0(21)
    public static class c {
        private c() {
        }

        @m0
        @t
        public static Drawable a(@m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
            return Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
        }

        @t
        public static int b(@m0 TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @t
        public static void c(@m0 Drawable drawable, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }

    private a() {
    }
}
