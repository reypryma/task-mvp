package com.learnMVP.todolist.module.login;

import android.view.View;

import com.learnMVP.todolist.base.BaseFragmentHolderActivity;

public class LoginActivity extends BaseFragmentHolderActivity {

    protected LoginFragment loginFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        btnBack.setVisibility(View.GONE);

        loginFragment = new LoginFragment();
        LoginPresenter presenter = new LoginPresenter(loginFragment);
        loginFragment.setPresenter(presenter);
        setCurrentFragment(loginFragment, false);
    }
}
