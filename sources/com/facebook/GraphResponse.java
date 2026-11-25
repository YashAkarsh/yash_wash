package com.facebook;

import android.util.Log;
import com.alipay.sdk.util.j;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class GraphResponse {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    private static final String TAG = "GraphResponse";
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final JSONObject graphObject;
    private final JSONArray graphObjectArray;
    private final String rawResponse;
    private final GraphRequest request;

    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    static List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(new GraphResponse(list.get(i7), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }

    private static GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError facebookRequestErrorCheckResponseAndCreateError = FacebookRequestError.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
            if (facebookRequestErrorCheckResponseAndCreateError != null) {
                Log.e(TAG, facebookRequestErrorCheckResponseAndCreateError.toString());
                if (facebookRequestErrorCheckResponseAndCreateError.getErrorCode() == 190 && Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                    if (facebookRequestErrorCheckResponseAndCreateError.getSubErrorCode() != 493) {
                        AccessToken.setCurrentAccessToken(null);
                    } else if (!AccessToken.getCurrentAccessToken().isExpired()) {
                        AccessToken.expireCurrentAccessToken();
                    }
                }
                return new GraphResponse(graphRequest, httpURLConnection, facebookRequestErrorCheckResponseAndCreateError);
            }
            Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", NON_JSON_RESPONSE_PROPERTY);
            if (stringPropertyAsJSON instanceof JSONObject) {
                return new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONObject) stringPropertyAsJSON);
            }
            if (stringPropertyAsJSON instanceof JSONArray) {
                return new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONArray) stringPropertyAsJSON);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    private static List<GraphResponse> createResponsesFromObject(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) throws JSONException, FacebookException {
        Object obj2;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 1) {
            GraphRequest graphRequest = list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("body", obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                obj2 = jSONArray;
            } catch (IOException e8) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e8)));
                obj2 = obj;
            } catch (JSONException e9) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e9)));
                obj2 = obj;
            }
        } else {
            obj2 = obj;
        }
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (jSONArray2.length() == size) {
                for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                    GraphRequest graphRequest2 = list.get(i7);
                    try {
                        arrayList.add(createResponseFromObject(graphRequest2, httpURLConnection, jSONArray2.get(i7), obj));
                    } catch (FacebookException e10) {
                        arrayList.add(new GraphResponse(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e10)));
                    } catch (JSONException e11) {
                        arrayList.add(new GraphResponse(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e11)));
                    }
                }
                return arrayList;
            }
        }
        throw new FacebookException("Unexpected number of results");
    }

    static List<GraphResponse> createResponsesFromStream(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws Throwable {
        String streamToString = Utility.readStreamToString(inputStream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(streamToString.length()), streamToString);
        return createResponsesFromString(streamToString, httpURLConnection, graphRequestBatch);
    }

    static List<GraphResponse> createResponsesFromString(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws JSONException, FacebookException, IOException {
        List<GraphResponse> listCreateResponsesFromObject = createResponsesFromObject(httpURLConnection, graphRequestBatch, new JSONTokener(str).nextValue());
        Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.getId(), Integer.valueOf(str.length()), listCreateResponsesFromObject);
        return listCreateResponsesFromObject;
    }

    static List<GraphResponse> fromHttpConnection(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        try {
            try {
                if (!FacebookSdk.isFullyInitialized()) {
                    Log.e(TAG, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                    throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
                }
                InputStream errorStream = httpURLConnection.getResponseCode() >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                List<GraphResponse> listCreateResponsesFromStream = createResponsesFromStream(errorStream, httpURLConnection, graphRequestBatch);
                Utility.closeQuietly(errorStream);
                return listCreateResponsesFromStream;
            } catch (FacebookException e8) {
                Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e8);
                List<GraphResponse> listConstructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, e8);
                Utility.closeQuietly(null);
                return listConstructErrorResponses;
            } catch (Exception e9) {
                Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e9);
                List<GraphResponse> listConstructErrorResponses2 = constructErrorResponses(graphRequestBatch, httpURLConnection, new FacebookException(e9));
                Utility.closeQuietly(null);
                return listConstructErrorResponses2;
            }
        } catch (Throwable th) {
            Utility.closeQuietly(null);
            throw th;
        }
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    public GraphRequest getRequest() {
        return this.request;
    }

    public GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String strOptString;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.graphObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("paging")) == null) {
            strOptString = null;
        } else {
            strOptString = pagingDirection == PagingDirection.NEXT ? jSONObjectOptJSONObject.optString("next") : jSONObjectOptJSONObject.optString("previous");
        }
        if (Utility.isNullOrEmpty(strOptString)) {
            return null;
        }
        if (strOptString != null && strOptString.equals(this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            return new GraphRequest(this.request.getAccessToken(), new URL(strOptString));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.connection;
            objArr[0] = Integer.valueOf(httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
            str = String.format(locale, TimeModel.f18789i, objArr);
        } catch (IOException unused) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + j.f13808d;
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.request = graphRequest;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
    }
}
