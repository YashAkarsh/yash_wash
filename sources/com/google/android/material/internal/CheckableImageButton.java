package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.customview.view.AbsSavedState;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f17736g = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17739f;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f17740c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(@m0 Parcel parcel) {
            this.f17740c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f17740c ? 1 : 0);
        }

        public SavedState(@m0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel);
        }
    }

    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, @m0 AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.U0(CheckableImageButton.this.a());
            l0Var.V0(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f17738e;
    }

    public boolean b() {
        return this.f17739f;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f17737d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i7) {
        if (!this.f17737d) {
            return super.onCreateDrawableState(i7);
        }
        int[] iArr = f17736g;
        return View.mergeDrawableStates(super.onCreateDrawableState(i7 + iArr.length), iArr);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f17740c);
    }

    @Override // android.view.View
    @m0
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f17740c = this.f17737d;
        return savedState;
    }

    public void setCheckable(boolean z7) {
        if (this.f17738e != z7) {
            this.f17738e = z7;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        if (!this.f17738e || this.f17737d == z7) {
            return;
        }
        this.f17737d = z7;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z7) {
        this.f17739f = z7;
    }

    @Override // android.view.View
    public void setPressed(boolean z7) {
        if (this.f17739f) {
            super.setPressed(z7);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f17737d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f17738e = true;
        this.f17739f = true;
        n2.B1(this, new a());
    }
}
