package com.haier.globalwasher.view.activity.order;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.OrderDetailUIBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.enum_.e;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.h0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.i;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.globalwasher.view.custom_view.mlistview.MaxHeightListView;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import easypay.appinvoke.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OrderDetailsActivity extends BaseListActivity<OrderDetailUIBeen> implements com.haier.globalwasher.mvp_api.adapter.d<OrderDetailUIBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private static final String N = "orderId";
    private static final String O = "orderDetail";
    com.haier.globalwasher.mvp_api.adapter.a<OrderDetailUIBeen, com.haier.globalwasher.mvp_api.adapter.b> D;
    private FontTextView E;
    private FontTextView F;
    private FontTextView G;
    private FontTextView H;
    private BaseData<OrderDetailsBeen> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Intent f25711J;
    private Resources K;
    XListView L;
    private i B = new i();
    private String C = "OrderDetailsActivity";
    Map<Integer, c> M = new HashMap();

    class a extends d {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.view.activity.order.OrderDetailsActivity.d
        public void h(BaseData<OrderDetailsBeen> baseData) {
            Drawable drawableH;
            OrderDetailsActivity.this.E.setText(e.e(Integer.parseInt(baseData.getData().getOrderStatus())).d());
            switch (b.f25713a[e.e(Integer.parseInt(baseData.getData().getOrderStatus())).ordinal()]) {
                case 1:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_jinxingzhong_dingdanxiangqing);
                    break;
                case 2:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_jinxingzhong_dingdanxiangqing);
                    break;
                case 3:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_wancheng_dingdanxiangqing);
                    break;
                case 4:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_wancheng_dingdanxiangqing);
                    break;
                case 5:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_guanbidingdan_dingdanxiangqing);
                    break;
                case 6:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_guzhang_dingdanxiangqing);
                    break;
                case 7:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_guanbidingdan_dingdanxiangqing);
                    break;
                case 8:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_guzhang_dingdanxiangqing);
                    break;
                case 9:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_jinxingzhong_dingdanxiangqing);
                    break;
                case 10:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_guzhang_dingdanxiangqing);
                    break;
                case 11:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_jinxingzhong_dingdanxiangqing);
                    break;
                default:
                    drawableH = OrderDetailsActivity.this.B.h(R.drawable.icon_guanbidingdan_dingdanxiangqing);
                    break;
            }
            drawableH.setBounds(0, 0, drawableH.getMinimumWidth(), drawableH.getMinimumHeight());
            OrderDetailsActivity.this.E.setCompoundDrawables(drawableH, null, null, null);
            if (baseData.getData().getDeviceInfo() != null) {
                OrderDetailsActivity.this.H.setText(baseData.getData().getDeviceInfo().getLaundryInfo().getName() + "");
                OrderDetailsActivity.this.F.setText("#" + d0.f(baseData.getData().getDeviceInfo().getSerialNumber()) + " 「" + d0.c(baseData.getData().getDeviceInfo().getSerialNumber()) + OrderDetailsActivity.this.K.getString(R.string.the_laundry_is_floor_F) + "」 " + baseData.getData().getDeviceInfo().getName());
                FontTextView fontTextView = OrderDetailsActivity.this.G;
                StringBuilder sb = new StringBuilder();
                sb.append(baseData.getData().getDeviceInfo().getLocation());
                sb.append("");
                fontTextView.setText(sb.toString());
            } else {
                OrderDetailsActivity.this.H.setText("");
                OrderDetailsActivity.this.F.setText("# 「" + OrderDetailsActivity.this.K.getString(R.string.the_laundry_is_floor_F) + "」 ");
                OrderDetailsActivity.this.G.setText("");
            }
            Drawable drawableH2 = OrderDetailsActivity.this.B.h(R.drawable.icon_dianoumingcheng);
            drawableH2.setBounds(0, 0, drawableH2.getMinimumWidth(), drawableH2.getMinimumHeight());
            OrderDetailsActivity.this.H.setCompoundDrawables(drawableH2, null, null, null);
            Drawable drawableH3 = OrderDetailsActivity.this.B.h(R.drawable.icon_xiyijimingcheng);
            drawableH3.setBounds(0, 0, drawableH3.getMinimumWidth(), drawableH3.getMinimumHeight());
            OrderDetailsActivity.this.F.setCompoundDrawables(drawableH3, null, null, null);
            Drawable drawableH4 = OrderDetailsActivity.this.B.h(R.drawable.icon_dizhi_bai);
            drawableH4.setBounds(0, 0, drawableH4.getMinimumWidth(), drawableH4.getMinimumHeight());
            OrderDetailsActivity.this.G.setCompoundDrawables(drawableH4, null, null, null);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25713a;

        static {
            int[] iArr = new int[e.values().length];
            f25713a = iArr;
            try {
                iArr[e.YUYUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25713a[e.RESUERVE_VERIFICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25713a[e.PAY_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25713a[e.ORDER_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25713a[e.ORDER_CENCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25713a[e.NO_PAY_OUT_TIME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25713a[e.FAULT_CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25713a[e.SECCESS_PAY_OUT_TIME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25713a[e.VERIFICATION_NO_PAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25713a[e.SUCCESS_PAY_FAULT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25713a[e.CLEANING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<OrderDetailUIBeen.KeyVelauBeen> f25714a;

        class a extends ClickableSpan {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f25716a;

            a(int i7) {
                this.f25716a = i7;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                q.c(OrderDetailsActivity.this.C, "arrayList.get(position).value=" + ((OrderDetailUIBeen.KeyVelauBeen) c.this.f25714a.get(this.f25716a)).value);
                if (((OrderDetailUIBeen.KeyVelauBeen) c.this.f25714a.get(this.f25716a)).value != null) {
                    c cVar = c.this;
                    h0.a(OrderDetailsActivity.this, ((OrderDetailUIBeen.KeyVelauBeen) cVar.f25714a.get(this.f25716a)).value);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(OrderDetailsActivity.this.B.g(R.color.app_zhexian_blue_relg));
                textPaint.setUnderlineText(true);
            }
        }

        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            TextView f25718a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            TextView f25719b;

            public b() {
            }
        }

        public c(ArrayList<OrderDetailUIBeen.KeyVelauBeen> arrayList) {
            this.f25714a = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f25714a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i7) {
            return this.f25714a.get(i7);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i7) {
            return i7;
        }

        @Override // android.widget.Adapter
        public View getView(int i7, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(OrderDetailsActivity.this, R.layout.order_detail_child_item, null);
                bVar = new b();
                view.setTag(bVar);
                bVar.f25718a = (TextView) view.findViewById(R.id.tv_key);
                bVar.f25719b = (TextView) view.findViewById(R.id.tv_value);
            } else {
                bVar = (b) view.getTag();
            }
            SpannableString spannableString = new SpannableString(this.f25714a.get(i7).key);
            if (this.f25714a.get(i7).value != null) {
                bVar.f25719b.setText(this.f25714a.get(i7).value + "");
            }
            bVar.f25718a.setText(this.f25714a.get(i7).key);
            bVar.f25719b.setTextSize(15.0f);
            int i8 = this.f25714a.get(i7).tag;
            if (i8 != 1) {
                if (i8 == 6 || i8 == 7) {
                    String[] strArrSplit = this.f25714a.get(i7).key.split(" ");
                    int length = strArrSplit.length > 1 ? 0 + strArrSplit[0].length() + strArrSplit[1].length() + 1 : 0;
                    int length2 = this.f25714a.get(i7).key.length();
                    bVar.f25719b.setTextColor(OrderDetailsActivity.this.B.g(R.color.app_zhexian_blue_relg));
                    spannableString.setSpan(new TextAppearanceSpan(OrderDetailsActivity.this, R.style.order_detail_coupon_small), length, length2, 33);
                    bVar.f25718a.setText(spannableString, TextView.BufferType.SPANNABLE);
                } else if (i8 == 8) {
                    bVar.f25718a.setTextColor(OrderDetailsActivity.this.B.g(e.RESUERVE_VERIFICATION.c()));
                } else if (i8 == 10) {
                    bVar.f25719b.setTextSize(12.0f);
                    bVar.f25719b.setTextColor(OrderDetailsActivity.this.B.g(R.color.app_text));
                } else if (i8 != 11) {
                    switch (i8) {
                        default:
                            bVar.f25718a.setTextColor(OrderDetailsActivity.this.B.g(R.color.app_text));
                            bVar.f25719b.setTextColor(OrderDetailsActivity.this.B.g(R.color.app_text));
                            bVar.f25719b.setTextSize(15.0f);
                        case 101:
                        case 102:
                        case Constants.ACTION_SUBMIT_BTN_USER_PWD_NB /* 103 */:
                        case 104:
                        case 105:
                        case Constants.ACTION_SUBMIT_CLICKED /* 106 */:
                        case Constants.OTP_FILLER_WEB_SUCCESS /* 107 */:
                        case 108:
                        case 109:
                        case Constants.LOG_ERROR_OTP /* 110 */:
                        case 111:
                            return view;
                    }
                } else {
                    SpannableString spannableString2 = new SpannableString(this.f25714a.get(i7).value);
                    spannableString2.setSpan(new a(i7), 0, this.f25714a.get(i7).value.length(), 33);
                    bVar.f25719b.setHighlightColor(0);
                    bVar.f25719b.setMovementMethod(LinkMovementMethod.getInstance());
                    bVar.f25719b.setText(spannableString2, TextView.BufferType.SPANNABLE);
                }
            } else {
                bVar.f25719b.setTextColor(OrderDetailsActivity.this.B.g(R.color.app_zhexian_blue_relg));
            }
            return view;
        }
    }

    public abstract class d extends BaseListActivity<OrderDetailUIBeen>.a {
        public d() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a, com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<OrderDetailUIBeen> arrayList) {
            OrderDetailsActivity orderDetailsActivity = OrderDetailsActivity.this;
            com.haier.globalwasher.mvp_api.adapter.a<OrderDetailUIBeen, com.haier.globalwasher.mvp_api.adapter.b> aVar = orderDetailsActivity.D;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
                return;
            }
            OrderDetailsActivity orderDetailsActivity2 = OrderDetailsActivity.this;
            orderDetailsActivity.D = new com.haier.globalwasher.mvp_api.adapter.a<>(orderDetailsActivity2, arrayList, orderDetailsActivity2);
            OrderDetailsActivity orderDetailsActivity3 = OrderDetailsActivity.this;
            orderDetailsActivity3.L.setAdapter((ListAdapter) orderDetailsActivity3.D);
        }

        public abstract void h(BaseData<OrderDetailsBeen> baseData);
    }

    public static void z0(Context context, BaseData<OrderDetailsBeen> baseData) {
        Intent intent = new Intent(context, (Class<?>) OrderDetailsActivity.class);
        intent.putExtra(O, baseData);
        context.startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_order_details;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.B;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        d0("", 1, new View[0]);
        View viewInflate = View.inflate(this, R.layout.order_detail_top, null);
        this.f25711J = getIntent();
        this.K = getResources();
        this.I = (BaseData) this.f25711J.getSerializableExtra(O);
        this.E = (FontTextView) viewInflate.findViewById(R.id.tv_order_stuta);
        this.H = (FontTextView) viewInflate.findViewById(R.id.tv_washer_name);
        this.F = (FontTextView) viewInflate.findViewById(R.id.tv_washer_floor_device_num_device_name);
        this.G = (FontTextView) viewInflate.findViewById(R.id.tv_washer_);
        addViewInToolbarBottom(viewInflate);
        this.L = (XListView) findViewById(R.id.lv_order_detail);
        n0(false);
        return this.L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.B.i("", this.I, new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, OrderDetailUIBeen orderDetailUIBeen) {
        bVar.b(R.id.tv_title, R.id.view_line, R.id.lv_max_child_item);
        TextView textView = (TextView) bVar.a(R.id.tv_title);
        View view = (View) bVar.a(R.id.view_line);
        if (orderDetailUIBeen.getTitle() == null || orderDetailUIBeen.getTitle().length() <= 0) {
            view.setVisibility(8);
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            view.setVisibility(0);
            textView.setText(orderDetailUIBeen.getTitle());
        }
        MaxHeightListView maxHeightListView = (MaxHeightListView) bVar.a(R.id.lv_max_child_item);
        if (this.M.get(Integer.valueOf(i7)) == null) {
            this.M.put(Integer.valueOf(i7), new c(orderDetailUIBeen.getArrayList()));
        }
        maxHeightListView.setAdapter((ListAdapter) this.M.get(Integer.valueOf(i7)));
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.order_detail_page, null), 1);
    }
}
