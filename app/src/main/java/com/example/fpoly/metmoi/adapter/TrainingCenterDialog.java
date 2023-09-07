package com.example.fpoly.metmoi.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fpoly.R;

public class TrainingCenterDialog extends Dialog {
    private Button btnFptHcm;
    private Button btnFptHanoi;
    private Button btnFptQuynhon, btn_fpt_danang,btn_fpt_cantho;


    private OnTrainingCenterSelectedListener listener;

    public TrainingCenterDialog(Context context, OnTrainingCenterSelectedListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_training_center);

        btnFptHcm = findViewById(R.id.btn_fpt_hcm);
        btnFptHanoi = findViewById(R.id.btn_fpt_hanoi);
        btnFptQuynhon = findViewById(R.id.btn_fpt_quynhon);
        btn_fpt_danang = findViewById(R.id.btn_fpt_danang);
        btn_fpt_cantho = findViewById(R.id.btn_fpt_cantho);


        btnFptHcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrainingCenterSelected("FPT HCM");
                dismiss();
            }
        });

        btnFptHanoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrainingCenterSelected("FPT Hà Nội");
                dismiss();
            }
        });

        btnFptQuynhon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrainingCenterSelected("FPT Quy Nhơn");
                dismiss();
            }
        });
        btn_fpt_danang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrainingCenterSelected("FPT Đà Nẵng");
                dismiss();
            }
        });
        btn_fpt_cantho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrainingCenterSelected("FPT Can Tho");
                dismiss();
            }
        });

    }

    public interface OnTrainingCenterSelectedListener {
        void onTrainingCenterSelected(String trainingCenter);
    }
}