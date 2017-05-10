package com.hyunseok.android.bbsbasic;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hyunseok.android.bbsbasic.domain.Memo;
import com.hyunseok.android.bbsbasic.interfaces.ListInterface;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class ListFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    private List<Memo> datas = new ArrayList<>();

    View view = null;
    Context context = null;

    ListInterface listInterface = null;

    RecyclerView recyclerView;
    ListAdapter listAdapter;
    Button btn_new;

    public ListFragment() {
    }

    @SuppressWarnings("unused")
    public static ListFragment newInstance(int columnCount) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view != null)
            return view;

        view = inflater.inflate(R.layout.layout_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.list);

        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        listAdapter = new ListAdapter(context, datas);
        recyclerView.setAdapter(listAdapter);

        btn_new = (Button) view.findViewById(R.id.btn_new);
        btn_new.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        this.listInterface = (ListInterface) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setData(List<Memo> datas) {
        this.datas = datas;
    }

    public void refreshAdapter() {
        listAdapter = new ListAdapter(context, datas);
        recyclerView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_new :
                // 메인의 goDetail함수를 호출한다.
                listInterface.goDetail();
                break;
        }
    }
}
