package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import c.m0;
import c.o0;
import c.x0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5709d = "ComplexColorCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shader f5710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f5711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5712c;

    private d(Shader shader, ColorStateList colorStateList, @c.l int i7) {
        this.f5710a = shader;
        this.f5711b = colorStateList;
        this.f5712c = i7;
    }

    @m0
    private static d a(@m0 Resources resources, @c.n int i7, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i7);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(g.c(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static d b(@c.l int i7) {
        return new d(null, null, i7);
    }

    static d c(@m0 ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(@m0 Shader shader) {
        return new d(shader, null, 0);
    }

    @o0
    public static d g(@m0 Resources resources, @c.n int i7, @o0 Resources.Theme theme) {
        try {
            return a(resources, i7, theme);
        } catch (Exception e8) {
            Log.e(f5709d, "Failed to inflate ComplexColor.", e8);
            return null;
        }
    }

    @c.l
    public int e() {
        return this.f5712c;
    }

    @o0
    public Shader f() {
        return this.f5710a;
    }

    public boolean h() {
        return this.f5710a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f5710a == null && (colorStateList = this.f5711b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f5711b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f5712c) {
                this.f5712c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(@c.l int i7) {
        this.f5712c = i7;
    }

    public boolean l() {
        return h() || this.f5712c != 0;
    }
}
