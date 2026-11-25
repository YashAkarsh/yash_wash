package m1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import c.i1;
import c.m0;
import c.o0;
import c.x0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class a {
    private a() {
    }

    @m0
    public static AttributeSet a(@m0 Context context, @i1 int i7, @m0 CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i7);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            }
            throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
        } catch (IOException | XmlPullParserException e8) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i7));
            notFoundException.initCause(e8);
            throw notFoundException;
        }
    }

    @TargetApi(21)
    public static void b(@o0 RippleDrawable rippleDrawable, int i7) {
        rippleDrawable.setRadius(i7);
    }

    @o0
    public static PorterDuffColorFilter c(@m0 Drawable drawable, @o0 ColorStateList colorStateList, @o0 PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
