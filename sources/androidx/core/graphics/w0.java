package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public final class w0 {
    public static final void a(@a7.d Canvas canvas, float f8, float f9, float f10, float f11, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(f8, f9, f10, f11);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void b(@a7.d Canvas canvas, int i7, int i8, int i9, int i10, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(i7, i8, i9, i10);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void c(@a7.d Canvas canvas, @a7.d Path clipPath, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(clipPath, "clipPath");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipPath(clipPath);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void d(@a7.d Canvas canvas, @a7.d Rect clipRect, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(clipRect, "clipRect");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void e(@a7.d Canvas canvas, @a7.d RectF clipRect, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(clipRect, "clipRect");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void f(@a7.d Canvas canvas, @a7.d Matrix matrix, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(matrix, "matrix");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static /* synthetic */ void g(Canvas canvas, Matrix matrix, i5.l block, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            matrix = new Matrix();
        }
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(matrix, "matrix");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void h(@a7.d Canvas canvas, float f8, float f9, float f10, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.rotate(f8, f9, f10);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static /* synthetic */ void i(Canvas canvas, float f8, float f9, float f10, i5.l block, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            f8 = 0.0f;
        }
        if ((i7 & 2) != 0) {
            f9 = 0.0f;
        }
        if ((i7 & 4) != 0) {
            f10 = 0.0f;
        }
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.rotate(f8, f9, f10);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void j(@a7.d Canvas canvas, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void k(@a7.d Canvas canvas, float f8, float f9, float f10, float f11, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.scale(f8, f9, f10, f11);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static /* synthetic */ void l(Canvas canvas, float f8, float f9, float f10, float f11, i5.l block, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            f8 = 1.0f;
        }
        if ((i7 & 2) != 0) {
            f9 = 1.0f;
        }
        if ((i7 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i7 & 8) != 0) {
            f11 = 0.0f;
        }
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.scale(f8, f9, f10, f11);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void m(@a7.d Canvas canvas, float f8, float f9, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.skew(f8, f9);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static /* synthetic */ void n(Canvas canvas, float f8, float f9, i5.l block, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            f8 = 0.0f;
        }
        if ((i7 & 2) != 0) {
            f9 = 0.0f;
        }
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.skew(f8, f9);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final void o(@a7.d Canvas canvas, float f8, float f9, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.translate(f8, f9);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static /* synthetic */ void p(Canvas canvas, float f8, float f9, i5.l block, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            f8 = 0.0f;
        }
        if ((i7 & 2) != 0) {
            f9 = 0.0f;
        }
        kotlin.jvm.internal.l0.p(canvas, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        int iSave = canvas.save();
        canvas.translate(f8, f9);
        try {
            block.z(canvas);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.i0.c(1);
        }
    }
}
