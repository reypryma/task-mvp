package com.learnMVP.todolist.module.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.learnMVP.todolist.R;
import com.learnMVP.todolist.base.BaseFragment;
import com.learnMVP.todolist.data.model.Task;
import com.learnMVP.todolist.module.create.AddTaskActivity;
import com.learnMVP.todolist.module.update.UpdateTaskActivity;
import com.learnMVP.todolist.utils.RecyclerViewAdapterTodoList;

import static com.learnMVP.todolist.utils.Route.TASK_ID;

public class ListFragment extends BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list_task, container, false);

        RecyclerView rvTask = fragmentView.findViewById(R.id.rv_task);
        FloatingActionButton btnTaskAdd = fragmentView.findViewById(R.id.btn_task_add);
        btnTaskAdd.setOnClickListener(view -> presenter.addTask());
        RecyclerViewAdapterTodoList adapterTodoList = new RecyclerViewAdapterTodoList();
        rvTask.setHasFixedSize(true);
        rvTask.setLayoutManager(new LinearLayoutManager(activity));
        rvTask.setAdapter(adapterTodoList);
        adapterTodoList.setTaskList(presenter.getTasks());
        adapterTodoList.setTodoListClickListener(new RecyclerViewAdapterTodoList.TodoListClickListener() {
            @Override
            public void onTaskClick(Task task) {
                String id = task.getId();
                presenter.editTask(id);
            }

            @Override
            public void onTaskCheckBoxClick(Task task) {

            }
        });
        setTitle(getResources().getString(R.string.app_name));
        return fragmentView;
    }

    @Override
    public void setPresenter(ListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sendToAddTask() {
        Intent intent = new Intent(activity, AddTaskActivity.class);
        startActivity(intent);
    }

    @Override
    public void sendToEditTask(String id) {
        Intent intent = new Intent(activity, UpdateTaskActivity.class);
        intent.putExtra(TASK_ID, id);
        startActivity(intent);
    }
}
