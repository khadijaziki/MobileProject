package com.example.mobile_project;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.selection );
        mRecyclerView = (RecyclerView) findViewById( R.id.recucler_users );
        new selectiion().readusers( new selectiion.Datastatus() {


                                        @Override
                                        public void DataIsLoaded(List<Professionnel> users, List<String> keys) {
                                            new RecyclerViewConfig().setConfig( mRecyclerView, UserListActivity.this, users, keys );
                                        }

                                        @Override
                                        public void DataIsInserted() {

                                        }

                                        @Override
                                        public void DataIsDeleted() {

                                        }
                                    }

        );
    }
}
