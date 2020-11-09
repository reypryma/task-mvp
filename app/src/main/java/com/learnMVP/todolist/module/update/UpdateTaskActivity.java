package com.learnMVP.todolist.module.update;

import com.learnMVP.todolist.base.BaseFragmentHolderActivity;

import static com.learnMVP.todolist.utils.Route.TASK_ID;

public class UpdateTaskActivity extends BaseFragmentHolderActivity {

    UpdateTaskFragment updateTaskFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        updateTaskFragment = new UpdateTaskFragment();
        UpdateTaskPresenter presenter = new UpdateTaskPresenter(updateTaskFragment);
        updateTaskFragment.setPresenter(presenter);

        String id = getIntent().getStringExtra(TASK_ID);
        presenter.setId(id);
        setCurrentFragment(updateTaskFragment, true);
    }
}
