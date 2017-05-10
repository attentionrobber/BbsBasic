package com.hyunseok.android.bbsbasic;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hyunseok.android.bbsbasic.domain.Memo;
import com.hyunseok.android.bbsbasic.interfaces.DetailInterface;

import java.sql.SQLException;
import java.util.Date;


public class DetailFragment extends Fragment implements View.OnClickListener{

    int position = -1;

    View view = null;
    Context context = null;
    DetailInterface detailInterface = null;

    Button btn_save, btn_cancle;
    EditText editText;

    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_detail, container, false);
            btn_save = (Button) view.findViewById(R.id.btn_save);
            btn_cancle = (Button) view.findViewById(R.id.btn_cancle);
            editText = (EditText) view.findViewById(R.id.editText);

            btn_save.setOnClickListener(this);
            btn_cancle.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        this.detailInterface = (DetailInterface) context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save :
                try {
                    Memo memo = makeMemo();
                    detailInterface.saveToList(memo);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_cancle :
                detailInterface.backToList();
                break;
        }
    }

    private Memo makeMemo() {
        Memo memo = new Memo();

        memo.setMemo(editText.getText().toString());
        memo.setDate(new Date(System.currentTimeMillis()));

        return memo;
    }
}
