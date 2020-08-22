package com.example.veri.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.veri.R;
import com.example.veri.databinding.ActivityMainBinding;
import com.example.veri.presenter.IPresenter;
import com.example.veri.presenter.IViewPresenter;
import com.example.veri.presenter.VerifierPresenter;

public class MainActivity extends AppCompatActivity implements IViewPresenter {
    public static final String TAG=MainActivity.class.getSimpleName();
    private ActivityMainBinding mBinding;
    private IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mPresenter = new VerifierPresenter(this);

        mBinding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,"Changed" + charSequence.toString());
                mPresenter.evaluatePass(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void showWeak() {
        Log.d(TAG,"Weeak");
        mBinding.textView.setText(R.string.weak);
        mBinding.textView.setBackgroundColor(Color.RED);
        mBinding.textView.setTextColor(Color.WHITE);

    }

    @Override
    public void showMedium() {
        Log.d(TAG,"Medium");
        mBinding.textView.setText(R.string.medium);
        mBinding.textView.setBackgroundColor(Color.YELLOW);
        //mBinding.textView.setTextColor(Color.WHITE);

    }

    @Override
    public void showStrong() {
        Log.d(TAG,"Strong");
        mBinding.textView.setText(R.string.strong);
        mBinding.textView.setBackgroundColor(Color.GREEN);
        //mBinding.textView.setTextColor(Color.WHITE);

    }
}