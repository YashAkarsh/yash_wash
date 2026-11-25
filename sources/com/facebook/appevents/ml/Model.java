package com.facebook.appevents.ml;

import android.os.AsyncTask;
import c.o0;
import c.x0;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class Model {
    private static final String DIR_NAME = "facebook_ml/";
    private static final int EMBEDDING_SIZE = 64;
    private static final int SEQ_LEN = 128;
    public static final String SHOULD_FILTER = "SHOULD_FILTER";
    private static final List<String> SUGGESTED_EVENTS_PREDICTION = Arrays.asList(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, "other", AppEventsConstants.EVENT_NAME_PURCHASED);
    private static final Map<String, String> WEIGHTS_KEY_MAPPING = new HashMap<String, String>() { // from class: com.facebook.appevents.ml.Model.1
        {
            put("embedding.weight", "embed.weight");
            put("dense1.weight", "fc1.weight");
            put("dense2.weight", "fc2.weight");
            put("dense3.weight", "fc3.weight");
            put("dense1.bias", "fc1.bias");
            put("dense2.bias", "fc2.bias");
            put("dense3.bias", "fc3.bias");
        }
    };

    @o0
    private Weight convs_1_bias;

    @o0
    private Weight convs_1_weight;

    @o0
    private Weight convs_2_bias;

    @o0
    private Weight convs_2_weight;

    @o0
    private Weight convs_3_bias;

    @o0
    private Weight convs_3_weight;
    private File dir;

    @o0
    private Weight embedding;

    @o0
    private Weight fc1_bias;

    @o0
    private Weight fc1_weight;

    @o0
    private Weight fc2_bias;

    @o0
    private Weight fc2_weight;

    @o0
    private Weight fc3_bias;

    @o0
    private Weight fc3_weight;
    private File modelFile;

    @o0
    private String modelUri;
    private File ruleFile;

    @o0
    private String ruleUri;
    private float[] thresholds;
    private String useCase;
    private int versionID;

    static class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
        File destFile;
        Runnable onSuccess;
        String uriStr;

        FileDownloadTask(String str, File file, Runnable runnable) {
            this.uriStr = str;
            this.destFile = file;
            this.onSuccess = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(this.uriStr);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.onSuccess.run();
            }
        }
    }

    private static class Weight {
        public float[] data;
        public int[] shape;

        Weight(int[] iArr, float[] fArr) {
            this.shape = iArr;
            this.data = fArr;
        }
    }

    Model(String str, int i7, String str2, @o0 String str3, float[] fArr) {
        this.useCase = str;
        this.versionID = i7;
        this.thresholds = fArr;
        this.modelUri = str2;
        this.ruleUri = str3;
        File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
        this.dir = file;
        if (!file.exists()) {
            this.dir.mkdirs();
        }
        this.modelFile = new File(this.dir, str + "_" + i7);
        this.ruleFile = new File(this.dir, str + "_" + i7 + "_rule");
    }

    private void deleteOldFiles() {
        File[] fileArrListFiles = this.dir.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        String str = this.useCase + "_" + this.versionID;
        for (File file : fileArrListFiles) {
            String name = file.getName();
            if (name.startsWith(this.useCase) && !name.startsWith(str)) {
                file.delete();
            }
        }
    }

    private void downloadModel(Runnable runnable) {
        if (this.modelFile.exists()) {
            runnable.run();
        } else if (this.modelUri != null) {
            new FileDownloadTask(this.modelUri, this.modelFile, runnable).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadRule(Runnable runnable) {
        if (this.ruleFile.exists() || this.ruleUri == null) {
            runnable.run();
        } else {
            new FileDownloadTask(this.ruleUri, this.ruleFile, runnable).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initializeWeights() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.modelFile);
            int iAvailable = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[iAvailable];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (iAvailable < 4) {
                return false;
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 4);
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            int i7 = byteBufferWrap.getInt();
            int i8 = i7 + 4;
            if (iAvailable < i8) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i7));
            JSONArray jSONArrayNames = jSONObject.names();
            int length = jSONArrayNames.length();
            String[] strArr = new String[length];
            for (int i9 = 0; i9 < length; i9++) {
                strArr[i9] = jSONArrayNames.getString(i9);
            }
            Arrays.sort(strArr);
            HashMap map = new HashMap();
            int i10 = 0;
            while (true) {
                int i11 = 1;
                if (i10 >= length) {
                    this.embedding = (Weight) map.get("embed.weight");
                    this.convs_1_weight = (Weight) map.get("convs.0.weight");
                    this.convs_2_weight = (Weight) map.get("convs.1.weight");
                    this.convs_3_weight = (Weight) map.get("convs.2.weight");
                    Weight weight = this.convs_1_weight;
                    float[] fArr = weight.data;
                    int[] iArr = weight.shape;
                    weight.data = Operator.transpose3D(fArr, iArr[0], iArr[1], iArr[2]);
                    Weight weight2 = this.convs_2_weight;
                    float[] fArr2 = weight2.data;
                    int[] iArr2 = weight2.shape;
                    weight2.data = Operator.transpose3D(fArr2, iArr2[0], iArr2[1], iArr2[2]);
                    Weight weight3 = this.convs_3_weight;
                    float[] fArr3 = weight3.data;
                    int[] iArr3 = weight3.shape;
                    weight3.data = Operator.transpose3D(fArr3, iArr3[0], iArr3[1], iArr3[2]);
                    this.convs_1_bias = (Weight) map.get("convs.0.bias");
                    this.convs_2_bias = (Weight) map.get("convs.1.bias");
                    this.convs_3_bias = (Weight) map.get("convs.2.bias");
                    this.fc1_weight = (Weight) map.get("fc1.weight");
                    this.fc2_weight = (Weight) map.get("fc2.weight");
                    this.fc3_weight = (Weight) map.get("fc3.weight");
                    Weight weight4 = this.fc1_weight;
                    float[] fArr4 = weight4.data;
                    int[] iArr4 = weight4.shape;
                    weight4.data = Operator.transpose2D(fArr4, iArr4[0], iArr4[1]);
                    Weight weight5 = this.fc2_weight;
                    float[] fArr5 = weight5.data;
                    int[] iArr5 = weight5.shape;
                    weight5.data = Operator.transpose2D(fArr5, iArr5[0], iArr5[1]);
                    Weight weight6 = this.fc3_weight;
                    float[] fArr6 = weight6.data;
                    int[] iArr6 = weight6.shape;
                    weight6.data = Operator.transpose2D(fArr6, iArr6[0], iArr6[1]);
                    this.fc1_bias = (Weight) map.get("fc1.bias");
                    this.fc2_bias = (Weight) map.get("fc2.bias");
                    this.fc3_bias = (Weight) map.get("fc3.bias");
                    return true;
                }
                String str = strArr[i10];
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length2 = jSONArray.length();
                int[] iArr7 = new int[length2];
                for (int i12 = 0; i12 < length2; i12++) {
                    int i13 = jSONArray.getInt(i12);
                    iArr7[i12] = i13;
                    i11 *= i13;
                }
                int i14 = i11 * 4;
                int i15 = i8 + i14;
                if (i15 > iAvailable) {
                    return false;
                }
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr, i8, i14);
                byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                float[] fArr7 = new float[i11];
                byteBufferWrap2.asFloatBuffer().get(fArr7, 0, i11);
                Map<String, String> map2 = WEIGHTS_KEY_MAPPING;
                if (map2.containsKey(str)) {
                    str = map2.get(str);
                }
                map.put(str, new Weight(iArr7, fArr7));
                i10++;
                i8 = i15;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    @o0
    File getRuleFile() {
        return this.ruleFile;
    }

    void initialize(final Runnable runnable) {
        downloadModel(new Runnable() { // from class: com.facebook.appevents.ml.Model.2
            @Override // java.lang.Runnable
            public void run() {
                if (Model.this.initializeWeights()) {
                    Model.this.downloadRule(runnable);
                }
            }
        });
        deleteOldFiles();
    }

    @o0
    String predict(float[] fArr, String str) {
        float[] fArrEmbedding = Operator.embedding(Utils.vectorize(str, 128), this.embedding.data, 1, 128, 64);
        Weight weight = this.convs_1_weight;
        float[] fArr2 = weight.data;
        int[] iArr = weight.shape;
        float[] fArrConv1D = Operator.conv1D(fArrEmbedding, fArr2, 1, 128, 64, iArr[2], iArr[0]);
        Weight weight2 = this.convs_2_weight;
        float[] fArr3 = weight2.data;
        int[] iArr2 = weight2.shape;
        float[] fArrConv1D2 = Operator.conv1D(fArrEmbedding, fArr3, 1, 128, 64, iArr2[2], iArr2[0]);
        Weight weight3 = this.convs_3_weight;
        float[] fArr4 = weight3.data;
        int[] iArr3 = weight3.shape;
        float[] fArrConv1D3 = Operator.conv1D(fArrEmbedding, fArr4, 1, 128, 64, iArr3[2], iArr3[0]);
        float[] fArr5 = this.convs_1_bias.data;
        int[] iArr4 = this.convs_1_weight.shape;
        Operator.add(fArrConv1D, fArr5, 1, (128 - iArr4[2]) + 1, iArr4[0]);
        float[] fArr6 = this.convs_2_bias.data;
        int[] iArr5 = this.convs_2_weight.shape;
        Operator.add(fArrConv1D2, fArr6, 1, (128 - iArr5[2]) + 1, iArr5[0]);
        float[] fArr7 = this.convs_3_bias.data;
        int[] iArr6 = this.convs_3_weight.shape;
        Operator.add(fArrConv1D3, fArr7, 1, (128 - iArr6[2]) + 1, iArr6[0]);
        int[] iArr7 = this.convs_1_weight.shape;
        Operator.relu(fArrConv1D, ((128 - iArr7[2]) + 1) * iArr7[0]);
        int[] iArr8 = this.convs_2_weight.shape;
        Operator.relu(fArrConv1D2, ((128 - iArr8[2]) + 1) * iArr8[0]);
        int[] iArr9 = this.convs_3_weight.shape;
        Operator.relu(fArrConv1D3, ((128 - iArr9[2]) + 1) * iArr9[0]);
        int[] iArr10 = this.convs_1_weight.shape;
        int i7 = iArr10[2];
        float[] fArrMaxPool1D = Operator.maxPool1D(fArrConv1D, (128 - i7) + 1, iArr10[0], (128 - i7) + 1);
        int[] iArr11 = this.convs_2_weight.shape;
        int i8 = iArr11[2];
        float[] fArrMaxPool1D2 = Operator.maxPool1D(fArrConv1D2, (128 - i8) + 1, iArr11[0], (128 - i8) + 1);
        int[] iArr12 = this.convs_3_weight.shape;
        int i9 = iArr12[2];
        float[] fArrConcatenate = Operator.concatenate(Operator.concatenate(Operator.concatenate(fArrMaxPool1D, fArrMaxPool1D2), Operator.maxPool1D(fArrConv1D3, (128 - i9) + 1, iArr12[0], (128 - i9) + 1)), fArr);
        Weight weight4 = this.fc1_weight;
        float[] fArr8 = weight4.data;
        float[] fArr9 = this.fc1_bias.data;
        int[] iArr13 = weight4.shape;
        float[] fArrDense = Operator.dense(fArrConcatenate, fArr8, fArr9, 1, iArr13[1], iArr13[0]);
        Operator.relu(fArrDense, this.fc1_bias.shape[0]);
        Weight weight5 = this.fc2_weight;
        float[] fArr10 = weight5.data;
        float[] fArr11 = this.fc2_bias.data;
        int[] iArr14 = weight5.shape;
        float[] fArrDense2 = Operator.dense(fArrDense, fArr10, fArr11, 1, iArr14[1], iArr14[0]);
        Operator.relu(fArrDense2, this.fc2_bias.shape[0]);
        Weight weight6 = this.fc3_weight;
        float[] fArr12 = weight6.data;
        float[] fArr13 = this.fc3_bias.data;
        int[] iArr15 = weight6.shape;
        float[] fArrDense3 = Operator.dense(fArrDense2, fArr12, fArr13, 1, iArr15[1], iArr15[0]);
        Operator.softmax(fArrDense3, this.fc3_bias.shape[0]);
        return processPredictionResult(fArrDense3);
    }

    @o0
    String processAddressDetectionResult(float[] fArr) {
        if (fArr[1] >= this.thresholds[0]) {
            return SHOULD_FILTER;
        }
        return null;
    }

    @o0
    String processPredictionResult(float[] fArr) {
        if (fArr.length != 0 && this.thresholds.length != 0) {
            if (this.useCase.equals(ModelManager.MODEL_SUGGESTED_EVENTS)) {
                return processSuggestedEventResult(fArr);
            }
            if (this.useCase.equals(ModelManager.MODEL_ADDRESS_DETECTION)) {
                return processAddressDetectionResult(fArr);
            }
        }
        return null;
    }

    @o0
    String processSuggestedEventResult(float[] fArr) {
        if (this.thresholds.length != fArr.length) {
            return null;
        }
        int i7 = 0;
        while (true) {
            float[] fArr2 = this.thresholds;
            if (i7 >= fArr2.length) {
                return "other";
            }
            if (fArr[i7] >= fArr2[i7]) {
                return SUGGESTED_EVENTS_PREDICTION.get(i7);
            }
            i7++;
        }
    }
}
