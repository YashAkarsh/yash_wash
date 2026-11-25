package com.haier.globalwasher.modle.bean.pay;

import com.google.gson.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PasTmResultBeen implements Serializable {
    private String BANKNAME;
    private String BANKTXNID;
    private String CHECKSUMHASH;
    private String CURRENCY;
    private String GATEWAYNAME;
    private String MID;
    private String ORDERID;
    private String PAYMENTMODE;
    private String RESPCODE;
    private String RESPMSG;
    private String STATUS;
    private String TXNAMOUNT;
    private String TXNDATE;
    private String TXNID;

    class a extends com.google.gson.reflect.a<ArrayList<PasTmResultBeen>> {
        a() {
        }
    }

    class b extends com.google.gson.reflect.a<ArrayList<PasTmResultBeen>> {
        b() {
        }
    }

    public static List<PasTmResultBeen> arrayPasTmResultBeenFromData(String str) {
        return (List) new f().o(str, new a().getType());
    }

    public static PasTmResultBeen objectFromData(String str) {
        return (PasTmResultBeen) new f().n(str, PasTmResultBeen.class);
    }

    public String getBANKNAME() {
        return this.BANKNAME;
    }

    public String getBANKTXNID() {
        return this.BANKTXNID;
    }

    public String getCHECKSUMHASH() {
        return this.CHECKSUMHASH;
    }

    public String getCURRENCY() {
        return this.CURRENCY;
    }

    public String getGATEWAYNAME() {
        return this.GATEWAYNAME;
    }

    public String getMID() {
        return this.MID;
    }

    public String getORDERID() {
        return this.ORDERID;
    }

    public String getPAYMENTMODE() {
        return this.PAYMENTMODE;
    }

    public String getRESPCODE() {
        return this.RESPCODE;
    }

    public String getRESPMSG() {
        return this.RESPMSG;
    }

    public String getSTATUS() {
        return this.STATUS;
    }

    public String getTXNAMOUNT() {
        return this.TXNAMOUNT;
    }

    public String getTXNDATE() {
        return this.TXNDATE;
    }

    public String getTXNID() {
        return this.TXNID;
    }

    public void setBANKNAME(String str) {
        this.BANKNAME = str;
    }

    public void setBANKTXNID(String str) {
        this.BANKTXNID = str;
    }

    public void setCHECKSUMHASH(String str) {
        this.CHECKSUMHASH = str;
    }

    public void setCURRENCY(String str) {
        this.CURRENCY = str;
    }

    public void setGATEWAYNAME(String str) {
        this.GATEWAYNAME = str;
    }

    public void setMID(String str) {
        this.MID = str;
    }

    public void setORDERID(String str) {
        this.ORDERID = str;
    }

    public void setPAYMENTMODE(String str) {
        this.PAYMENTMODE = str;
    }

    public void setRESPCODE(String str) {
        this.RESPCODE = str;
    }

    public void setRESPMSG(String str) {
        this.RESPMSG = str;
    }

    public void setSTATUS(String str) {
        this.STATUS = str;
    }

    public void setTXNAMOUNT(String str) {
        this.TXNAMOUNT = str;
    }

    public void setTXNDATE(String str) {
        this.TXNDATE = str;
    }

    public void setTXNID(String str) {
        this.TXNID = str;
    }

    public String toString() {
        return "PasTmResultBeen{STATUS='" + this.STATUS + "', RESPMSG='" + this.RESPMSG + "', CHECKSUMHASH='" + this.CHECKSUMHASH + "', BANKNAME='" + this.BANKNAME + "', ORDERID='" + this.ORDERID + "', TXNAMOUNT='" + this.TXNAMOUNT + "', TXNDATE='" + this.TXNDATE + "', MID='" + this.MID + "', TXNID='" + this.TXNID + "', RESPCODE='" + this.RESPCODE + "', PAYMENTMODE='" + this.PAYMENTMODE + "', BANKTXNID='" + this.BANKTXNID + "', CURRENCY='" + this.CURRENCY + "', GATEWAYNAME='" + this.GATEWAYNAME + "'}";
    }

    public static PasTmResultBeen objectFromData(String str, String str2) {
        try {
            return (PasTmResultBeen) new f().n(new JSONObject(str).getString(str), PasTmResultBeen.class);
        } catch (JSONException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static List<PasTmResultBeen> arrayPasTmResultBeenFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) new f().o(jSONObject.getString(str), new b().getType());
        } catch (JSONException e8) {
            e8.printStackTrace();
            return new ArrayList();
        }
    }
}
