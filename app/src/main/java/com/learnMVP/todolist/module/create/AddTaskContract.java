package com.learnMVP.todolist.module.create;

import com.learnMVP.todolist.base.BasePresenter;
import com.learnMVP.todolist.base.BaseView;

public interface AddTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
    }

    interface Presenter extends BasePresenter {
        void saveData(String name, String time);
    }
}
