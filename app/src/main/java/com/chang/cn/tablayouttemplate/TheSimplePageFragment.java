package com.chang.cn.tablayouttemplate;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TheSimplePageFragment#onViewCreated} factory method to
 * create an instance of this fragment.
 */
public class TheSimplePageFragment extends LazyLoadFragment {
    private static final String ARG_PARAM1 = "param1";
    @InjectView(R.id.page_text_content)
    TextView pageTextContent;

    private String mParam1;

    public TheSimplePageFragment() {
    }

    public static TheSimplePageFragment newInstance(String param1) {
        TheSimplePageFragment fragment = new TheSimplePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_the_simple_page;
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!TextUtils.isEmpty(mParam1))
            pageTextContent.setText(mParam1);
    }

    @Override
    public void loadData() {
        super.loadData();
        Log.d("chang","mParam1:"+mParam1);
    }

}
