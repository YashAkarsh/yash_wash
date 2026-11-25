package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class x0 extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f2018a;

    public x0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2018a = resources;
    }

    final Drawable a(int i7) throws Resources.NotFoundException {
        return super.getDrawable(i7);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i7) throws Resources.NotFoundException {
        return this.f2018a.getAnimation(i7);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i7) throws Resources.NotFoundException {
        return this.f2018a.getBoolean(i7);
    }

    @Override // android.content.res.Resources
    public int getColor(int i7) throws Resources.NotFoundException {
        return this.f2018a.getColor(i7);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i7) throws Resources.NotFoundException {
        return this.f2018a.getColorStateList(i7);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f2018a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i7) throws Resources.NotFoundException {
        return this.f2018a.getDimension(i7);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i7) throws Resources.NotFoundException {
        return this.f2018a.getDimensionPixelOffset(i7);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i7) throws Resources.NotFoundException {
        return this.f2018a.getDimensionPixelSize(i7);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f2018a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i7) throws Resources.NotFoundException {
        return this.f2018a.getDrawable(i7);
    }

    @Override // android.content.res.Resources
    @c.t0(15)
    public Drawable getDrawableForDensity(int i7, int i8) throws Resources.NotFoundException {
        return androidx.core.content.res.i.h(this.f2018a, i7, i8, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i7, int i8, int i9) {
        return this.f2018a.getFraction(i7, i8, i9);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f2018a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i7) throws Resources.NotFoundException {
        return this.f2018a.getIntArray(i7);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i7) throws Resources.NotFoundException {
        return this.f2018a.getInteger(i7);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i7) throws Resources.NotFoundException {
        return this.f2018a.getLayout(i7);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i7) throws Resources.NotFoundException {
        return this.f2018a.getMovie(i7);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i7, int i8, Object... objArr) throws Resources.NotFoundException {
        return this.f2018a.getQuantityString(i7, i8, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i7, int i8) throws Resources.NotFoundException {
        return this.f2018a.getQuantityText(i7, i8);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i7) throws Resources.NotFoundException {
        return this.f2018a.getResourceEntryName(i7);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i7) throws Resources.NotFoundException {
        return this.f2018a.getResourceName(i7);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i7) throws Resources.NotFoundException {
        return this.f2018a.getResourcePackageName(i7);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i7) throws Resources.NotFoundException {
        return this.f2018a.getResourceTypeName(i7);
    }

    @Override // android.content.res.Resources
    public String getString(int i7) throws Resources.NotFoundException {
        return this.f2018a.getString(i7);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i7) throws Resources.NotFoundException {
        return this.f2018a.getStringArray(i7);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i7) throws Resources.NotFoundException {
        return this.f2018a.getText(i7);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i7) throws Resources.NotFoundException {
        return this.f2018a.getTextArray(i7);
    }

    @Override // android.content.res.Resources
    public void getValue(int i7, TypedValue typedValue, boolean z7) throws Resources.NotFoundException {
        this.f2018a.getValue(i7, typedValue, z7);
    }

    @Override // android.content.res.Resources
    @c.t0(15)
    public void getValueForDensity(int i7, int i8, TypedValue typedValue, boolean z7) throws Resources.NotFoundException {
        f.a.C0416a.a(this.f2018a, i7, i8, typedValue, z7);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i7) throws Resources.NotFoundException {
        return this.f2018a.getXml(i7);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2018a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i7) throws Resources.NotFoundException {
        return this.f2018a.obtainTypedArray(i7);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i7) throws Resources.NotFoundException {
        return this.f2018a.openRawResource(i7);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i7) throws Resources.NotFoundException {
        return this.f2018a.openRawResourceFd(i7);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f2018a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f2018a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f2018a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    @c.t0(21)
    public Drawable getDrawable(int i7, Resources.Theme theme) throws Resources.NotFoundException {
        return androidx.core.content.res.i.g(this.f2018a, i7, theme);
    }

    @Override // android.content.res.Resources
    @c.t0(21)
    public Drawable getDrawableForDensity(int i7, int i8, Resources.Theme theme) {
        return androidx.core.content.res.i.h(this.f2018a, i7, i8, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i7, int i8) throws Resources.NotFoundException {
        return this.f2018a.getQuantityString(i7, i8);
    }

    @Override // android.content.res.Resources
    public String getString(int i7, Object... objArr) throws Resources.NotFoundException {
        return this.f2018a.getString(i7, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i7, CharSequence charSequence) {
        return this.f2018a.getText(i7, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z7) throws Resources.NotFoundException {
        this.f2018a.getValue(str, typedValue, z7);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i7, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f2018a.openRawResource(i7, typedValue);
    }
}
