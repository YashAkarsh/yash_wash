package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f4415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f4416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f4417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f4420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Rect f4421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4425k;

    public MockView(Context context) {
        super(context);
        this.f4415a = new Paint();
        this.f4416b = new Paint();
        this.f4417c = new Paint();
        this.f4418d = true;
        this.f4419e = true;
        this.f4420f = null;
        this.f4421g = new Rect();
        this.f4422h = Color.argb(255, 0, 0, 0);
        this.f4423i = Color.argb(255, 200, 200, 200);
        this.f4424j = Color.argb(255, 50, 50, 50);
        this.f4425k = 4;
        a(context, null);
    }

    private void a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MockView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.MockView_mock_label) {
                    this.f4420f = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f4418d = typedArrayObtainStyledAttributes.getBoolean(index, this.f4418d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f4422h = typedArrayObtainStyledAttributes.getColor(index, this.f4422h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.f4424j = typedArrayObtainStyledAttributes.getColor(index, this.f4424j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f4423i = typedArrayObtainStyledAttributes.getColor(index, this.f4423i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f4419e = typedArrayObtainStyledAttributes.getBoolean(index, this.f4419e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f4420f == null) {
            try {
                this.f4420f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f4415a.setColor(this.f4422h);
        this.f4415a.setAntiAlias(true);
        this.f4416b.setColor(this.f4423i);
        this.f4416b.setAntiAlias(true);
        this.f4417c.setColor(this.f4424j);
        this.f4425k = Math.round(this.f4425k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f4418d) {
            width--;
            height--;
            float f8 = width;
            float f9 = height;
            canvas.drawLine(0.0f, 0.0f, f8, f9, this.f4415a);
            canvas.drawLine(0.0f, f9, f8, 0.0f, this.f4415a);
            canvas.drawLine(0.0f, 0.0f, f8, 0.0f, this.f4415a);
            canvas.drawLine(f8, 0.0f, f8, f9, this.f4415a);
            canvas.drawLine(f8, f9, 0.0f, f9, this.f4415a);
            canvas.drawLine(0.0f, f9, 0.0f, 0.0f, this.f4415a);
        }
        String str = this.f4420f;
        if (str == null || !this.f4419e) {
            return;
        }
        this.f4416b.getTextBounds(str, 0, str.length(), this.f4421g);
        float fWidth = (width - this.f4421g.width()) / 2.0f;
        float fHeight = ((height - this.f4421g.height()) / 2.0f) + this.f4421g.height();
        this.f4421g.offset((int) fWidth, (int) fHeight);
        Rect rect = this.f4421g;
        int i7 = rect.left;
        int i8 = this.f4425k;
        rect.set(i7 - i8, rect.top - i8, rect.right + i8, rect.bottom + i8);
        canvas.drawRect(this.f4421g, this.f4417c);
        canvas.drawText(this.f4420f, fWidth, fHeight, this.f4416b);
    }

    public MockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4415a = new Paint();
        this.f4416b = new Paint();
        this.f4417c = new Paint();
        this.f4418d = true;
        this.f4419e = true;
        this.f4420f = null;
        this.f4421g = new Rect();
        this.f4422h = Color.argb(255, 0, 0, 0);
        this.f4423i = Color.argb(255, 200, 200, 200);
        this.f4424j = Color.argb(255, 50, 50, 50);
        this.f4425k = 4;
        a(context, attrs);
    }

    public MockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4415a = new Paint();
        this.f4416b = new Paint();
        this.f4417c = new Paint();
        this.f4418d = true;
        this.f4419e = true;
        this.f4420f = null;
        this.f4421g = new Rect();
        this.f4422h = Color.argb(255, 0, 0, 0);
        this.f4423i = Color.argb(255, 200, 200, 200);
        this.f4424j = Color.argb(255, 50, 50, 50);
        this.f4425k = 4;
        a(context, attrs);
    }
}
