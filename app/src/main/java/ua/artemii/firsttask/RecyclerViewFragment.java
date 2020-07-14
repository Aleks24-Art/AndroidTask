package ua.artemii.firsttask;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ua.artemii.firsttask.databinding.RecyclerViewFragmentBinding;

public class RecyclerViewFragment extends Fragment {

    private static final String TAG = RecyclerViewFragment.class.getCanonicalName();

    private RecyclerViewFragmentBinding binding;
    private static final int ITEM_LIST_SIZE = 30;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = RecyclerViewFragmentBinding.inflate(inflater, container, false);
        Button btnBack = binding.btnBack;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity())
                        .getSupportFragmentManager()
                            .popBackStack(MyFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                Log.d(TAG, "Returning to "
                        + MyFragment.class.getSimpleName()
                        + " from " + RecyclerViewFragment.class.getSimpleName());
            }
        });

        initRecyclerView();

        return binding.getRoot();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = binding.recyclerView;

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(((MainActivity)getActivity())
                        .getApplicationContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < ITEM_LIST_SIZE; i++) {
            items.add(new Item("Title", "Description"));
        }

        FragmentAdapter adapter =
                new FragmentAdapter(items);

        recyclerView.setAdapter(adapter);
    }
}
