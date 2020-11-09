package com.learnMVP.todolist.module.update;

import com.learnMVP.todolist.base.BasePresenter;
import com.learnMVP.todolist.base.BaseView;
import com.learnMVP.todolist.data.model.Task;

public interface UpdateTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
        void showData(Task task);
    }

    interface Presenter extends BasePresenter {
        void saveData(String name, String time);
        void loadData(String id);
        void setId(String id);
        void deleteData();
    }
}
