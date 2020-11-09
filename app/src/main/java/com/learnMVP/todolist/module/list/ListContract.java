package com.learnMVP.todolist.module.list;

import com.learnMVP.todolist.base.BasePresenter;
import com.learnMVP.todolist.base.BaseView;
import com.learnMVP.todolist.data.model.Task;

import java.util.List;

public interface ListContract {
    interface View extends BaseView<Presenter> {
        void sendToAddTask();
        void sendToEditTask(String id);
    }

    interface Presenter extends BasePresenter {
        void addTask();
        void editTask(String id);
        List<Task> getTasks();
    }
}
