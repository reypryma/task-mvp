package com.learnMVP.todolist.module.list;

import android.view.View;

import com.learnMVP.todolist.base.BaseFragmentHolderActivity;

public class ListActivity extends BaseFragmentHolderActivity {

    ListFragment listFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        btnBack.setVisibility(View.GONE);

        listFragment = new ListFragment();
        ListPresenter presenter = new ListPresenter(listFragment);
        listFragment.setPresenter(presenter);
        setCurrentFragment(listFragment, false);
    }

}
