package com.kolon.recyclerviewpagination;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RelativeLayout;
import com.kolon.recyclerviewpagination.log.TimberLog;
import java.util.ArrayList;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RelativeLayout progressBar;

    private ArrayList<String> pagingDataList = new ArrayList<>();
    private ArrayList<String> itemDataList = new ArrayList<>();

    private boolean isLoading = false;

    private final int ORIGIN_DATA_SIZE = 100;
    private int initialSize = 10;
    private int pageSize = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recyclerView1);
        this.progressBar = findViewById(R.id.main_progressbar);

        // TimberLog 적용
        Timber.plant(new TimberLog());
        Timber.i("START TIMBER JAVA!!!");

        initData();
        populateData();
        initAdapter();
        initScrollListener();
    }

    // paging 처리할 임시 datat생
    public void initData() {
        for (int i = 0; i < ORIGIN_DATA_SIZE; i++) {
            itemDataList.add("ITEM :: " + String.valueOf(i + 1));
        }
    }

    // 초기 PaingData setting생성, 처음 10개만 보여준다.
    private void populateData() {
        for (int i = 0; i < this.initialSize; i++) {
            pagingDataList.add(itemDataList.get(i));
        }
    }

    private void initAdapter() {
        adapter = new RecyclerViewAdapter(this, pagingDataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    // 리사이클러 뷰 리스
    private void initScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                int currentLastItem = layoutManager.findLastCompletelyVisibleItemPosition() + 1;
                int currentDataSize = pagingDataList.size();

                if (!isLoading) {
                    if (layoutManager != null && currentLastItem == currentDataSize) {
                        //리스트 마지막에 도달하면, Progressbar보여준다.
                        progressBar.setVisibility(View.VISIBLE);
                        loadMore();
                        isLoading = true;
                    }
                }
            }
        });
    }

    private void loadMore() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                pagingDataList.add(null);
                adapter.notifyItemInserted(pagingDataList.size() - 1);

                pagingDataList.remove(pagingDataList.size() - 1);
                int scrollPosition = pagingDataList.size();

                adapter.notifyItemRemoved(scrollPosition);

                int currentSize = scrollPosition;
                int nextLimit = currentSize + pageSize;  // 20개씩 늘어남.

                if (nextLimit > itemDataList.size()) {
                    nextLimit = itemDataList.size();
                }

                while (currentSize - 1 < nextLimit) {
                    pagingDataList.add("Item " + currentSize);
                    currentSize++;
                }

                adapter.notifyDataSetChanged();
                isLoading = false;

                progressBar.setVisibility(View.GONE);
            }
        }, 2000);
    }
}