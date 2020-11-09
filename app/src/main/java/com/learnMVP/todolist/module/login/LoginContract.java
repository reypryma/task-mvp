package com.learnMVP.todolist.module.login;

import com.learnMVP.todolist.base.BasePresenter;
import com.learnMVP.todolist.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void redirectToHome();
    }

    interface Presenter extends BasePresenter {
        void performLogin(String email, String pass);
    }
}
