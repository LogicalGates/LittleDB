package com.littledb.muhammadrazasaeed.demoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.razasaeed.littledb.LittleDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        textView = findViewById(R.id.textView);
        findViewById(R.id.btnRemove).setOnClickListener(this);
        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnLoad).setOnClickListener(this);
        findViewById(R.id.btnContains).setOnClickListener(this);
        findViewById(R.id.btnSaveWithEditor).setOnClickListener(this);
        findViewById(R.id.btnLoadTestEditor).setOnClickListener(this);
        findViewById(R.id.btnSaveList).setOnClickListener(this);
        findViewById(R.id.btnLoadList).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRemove:
                onBtnRemovePressed();
                break;
            case R.id.btnSave:
                onBtnSavePressed();
                break;
            case R.id.btnLoad:
                onBtnLoadPressed();
                break;
            case R.id.btnContains:
                onBtnContainsPressed();
                break;
            case R.id.btnSaveWithEditor:
                onBtnSaveWithEditorPressed();
                break;
            case R.id.btnLoadTestEditor:
                onBtnLoadTestEditorPressed();
                break;
            case R.id.btnSaveList:
                onBtnSaveListPressed();
                break;
            case R.id.btnLoadList:
                onBtnLoadListPressed();
                break;
        }
    }

    private void onBtnLoadListPressed() {
        List<String> getNames = LittleDB.getListOfStrings("captech");
        StringBuilder stringBuilder = new StringBuilder("Result: ");
        for (String result : getNames) {
            stringBuilder.append(result).append(", ");
        }
        textView.setText(stringBuilder.toString());
        showToast(stringBuilder.toString());
    }

    private void onBtnSaveListPressed() {
        List<String> names = new ArrayList<>();
        names.add("Hassan");
        names.add("Afzal");
        names.add("Khalid");
        names.add("Waqar");
        LittleDB.putList("captech", names);
        textView.setText(R.string.saved_a_list);
        showToast(getString(R.string.saved_a_list));
    }

    private void onBtnLoadTestEditorPressed() {
        String LoadEditorText = LittleDB.getString("key1") + ", " + LittleDB.getString("key2") + ", " + LittleDB.getString("key3");
        String getResult = getString(R.string.loaded_text) + LoadEditorText;
        textView.setText(getResult);
        showToast(getResult);
    }

    private void onBtnSaveWithEditorPressed() {
        new LittleDB.Editor()
                .put("key1", "Adnan")
                .put("key2", "Qasim")
                .put("key3", "Saeed")
                .commit();
        textView.setText(R.string.some_text_was_saved);
        showToast(getString(R.string.some_text_was_saved));
    }

    private void onBtnContainsPressed() {
        boolean isContain = LittleDB.contains("boolean");
        String containTxt = getString(R.string.contains2) + isContain;
        if (isContain) {
            showToast(containTxt);
            textView.setText(containTxt);
        } else {
            showToast(getString(R.string.saved_text_removed));
            textView.setText(getString(R.string.saved_text_removed));
        }
    }

    private void onBtnLoadPressed() {
        String LoadText = LittleDB.getString(R.string.key, "");
        String getResult = getString(R.string.loaded_text) + LoadText;
        textView.setText(getResult);
        showToast(getResult);
    }

    private void onBtnSavePressed() {
        LittleDB.put(R.string.key, "Raza Saeed");
        LittleDB.put("integer", 25);
        LittleDB.put("float", 25.2f);
        LittleDB.put("long", 2352354214L);
        LittleDB.put("double", 25.2345);
        LittleDB.put("boolean", false);
        textView.setText(R.string.some_text_was_saved);
        showToast("Saved Successfully");
    }

    private void onBtnRemovePressed() {
        LittleDB.remove(R.string.key);
        LittleDB.remove("integer");
        LittleDB.remove("float");
        LittleDB.remove("long");
        LittleDB.remove("double");
        LittleDB.remove("boolean");
        textView.setText(R.string.saved_text_removed);
        showToast(getString(R.string.saved_text_removed));
    }

    private void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }
}
