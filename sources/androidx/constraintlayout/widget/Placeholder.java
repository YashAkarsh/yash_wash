package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f4624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4625c;

    public Placeholder(Context context) {
        super(context);
        this.f4623a = -1;
        this.f4624b = null;
        this.f4625c = 4;
        a(null);
    }

    private void a(AttributeSet attrs) {
        super.setVisibility(this.f4625c);
        this.f4623a = -1;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_placeholder);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.f4623a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4623a);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f4625c = typedArrayObtainStyledAttributes.getInt(index, this.f4625c);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout container) {
        if (this.f4624b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4624b.getLayoutParams();
        layoutParams2.f4561v0.b2(0);
        androidx.constraintlayout.core.widgets.e.b bVarH = layoutParams.f4561v0.H();
        androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.FIXED;
        if (bVarH != bVar) {
            layoutParams.f4561v0.c2(layoutParams2.f4561v0.m0());
        }
        if (layoutParams.f4561v0.j0() != bVar) {
            layoutParams.f4561v0.y1(layoutParams2.f4561v0.D());
        }
        layoutParams2.f4561v0.b2(8);
    }

    public void c(ConstraintLayout container) {
        if (this.f4623a == -1 && !isInEditMode()) {
            setVisibility(this.f4625c);
        }
        View viewFindViewById = container.findViewById(this.f4623a);
        this.f4624b = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.LayoutParams) viewFindViewById.getLayoutParams()).f4537j0 = true;
            this.f4624b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f4624b;
    }

    public int getEmptyVisibility() {
        return this.f4625c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int id) {
        View viewFindViewById;
        if (this.f4623a == id) {
            return;
        }
        View view = this.f4624b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f4624b.getLayoutParams()).f4537j0 = false;
            this.f4624b = null;
        }
        this.f4623a = id;
        if (id == -1 || (viewFindViewById = ((View) getParent()).findViewById(id)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int visibility) {
        this.f4625c = visibility;
    }

    public Placeholder(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4623a = -1;
        this.f4624b = null;
        this.f4625c = 4;
        a(attrs);
    }

    public Placeholder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4623a = -1;
        this.f4624b = null;
        this.f4625c = 4;
        a(attrs);
    }

    public Placeholder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.f4623a = -1;
        this.f4624b = null;
        this.f4625c = 4;
        a(attrs);
    }
}
