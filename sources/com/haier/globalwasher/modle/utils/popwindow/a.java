package com.haier.globalwasher.modle.utils.popwindow;

import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import c.b0;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.utils.i0;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.haier.globalwasher.modle.utils.popwindow.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0324a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlertDialog f24685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener[] f24686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f24687c;

        ViewOnClickListenerC0324a(AlertDialog alertDialog, View.OnClickListener[] onClickListenerArr, int i7) {
            this.f24685a = alertDialog;
            this.f24686b = onClickListenerArr;
            this.f24687c = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f24685a.dismiss();
            View.OnClickListener onClickListener = this.f24686b[this.f24687c];
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public static AlertDialog a(BaseActivity baseActivity, View view) {
        if (baseActivity == null) {
            i0.d(MyApplication.k(), "上下文等于NULL");
            return null;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(baseActivity).create();
        if (!baseActivity.isFinishing()) {
            alertDialogCreate.show();
        }
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable());
        alertDialogCreate.setContentView(view);
        return alertDialogCreate;
    }

    public static void b(BaseActivity baseActivity, View view, @b0 Integer[] numArr, View.OnClickListener[] onClickListenerArr) throws Exception {
        if (baseActivity == null) {
            i0.d(MyApplication.k(), "上下文等于NULL");
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(baseActivity).create();
        if (!baseActivity.isFinishing()) {
            alertDialogCreate.show();
        }
        alertDialogCreate.setCancelable(false);
        Window window = alertDialogCreate.getWindow();
        Display defaultDisplay = baseActivity.getWindowManager().getDefaultDisplay();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.95d);
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable());
        }
        alertDialogCreate.setContentView(view);
        if (c(onClickListenerArr) && c(numArr)) {
            for (int i7 = 0; i7 < numArr.length; i7++) {
                view.findViewById(numArr[i7].intValue()).setOnClickListener(new ViewOnClickListenerC0324a(alertDialogCreate, onClickListenerArr, i7));
            }
        } else if (c(onClickListenerArr) || c(numArr)) {
            throw new Exception("按钮数量与监听事件数量不符合");
        }
    }

    private static boolean c(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? false : true;
    }
}
