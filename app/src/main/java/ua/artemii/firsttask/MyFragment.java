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

import ua.artemii.firsttask.databinding.ActivityMainBinding;
import ua.artemii.firsttask.databinding.MyFragmentBinding;

public class MyFragment extends Fragment {

    public static final String TAG = MyFragment.class.getCanonicalName();
    private Button btnToSecondFragment;
    private MyFragmentBinding binding;
    private ActivityMainBinding mainBinding;
    private RecyclerViewFragment recyclerViewFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MyFragmentBinding.inflate(inflater, container, false);

        mainBinding = ActivityMainBinding
                .inflate(((MainActivity)getActivity())
                        .getLayoutInflater(), container, false);

        btnToSecondFragment = binding.btnToSecondFrag;

        btnToSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewFragment = new RecyclerViewFragment();
                getActivity()
                        .getSupportFragmentManager()
                            .beginTransaction()
                                .addToBackStack(MyFragment.TAG)
                                    .replace(mainBinding.container.getId(),
                                        recyclerViewFragment)
                                            .commit();

                Log.d(TAG, "Adding "
                        + recyclerViewFragment.getClass().getName()
                            + " in container");
            }
        });

        return binding.getRoot();
    }



}
