package ua.artemii.firsttask;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ua.artemii.firsttask.databinding.ListItemBinding;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.FragmentViewHolder> {

    public static final String TAG = FragmentAdapter.class.getCanonicalName();

    private int mCheckedPos = -1;
    private List<Item> mItems;

    FragmentAdapter(List<Item> items) {
        this.mItems = items;
    }

    @NonNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        ua.artemii.firsttask.databinding.ListItemBinding itemBinding =
                ListItemBinding.inflate(inflater, parent, false);

        return new FragmentViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final FragmentViewHolder holder, final int position) {
        final Item curItem = mItems.get(position);
        holder.itemBinding.image.setImageResource(R.drawable.ic_launcher_foreground);
        holder.itemBinding.title.setText(curItem.getTitle());
        holder.itemBinding.description.setText(curItem.getDescription());
        holder.itemView.setBackgroundColor(mCheckedPos == position ? Color.GREEN : Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class FragmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ListItemBinding itemBinding;

        FragmentViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            itemView.setOnClickListener(this);
            this.itemBinding = binding;
        }

        @Override
        public void onClick(View v) {
            if (getAdapterPosition() != mCheckedPos) {
                notifyItemChanged(mCheckedPos);
                Log.d(TAG, "Change last checked holder on "
                        + mCheckedPos + "-th position background to unchecked state");
                mCheckedPos = getAdapterPosition();
                Log.d(TAG, "Change new unchecked on "
                        + mCheckedPos + "-th position holder background to checked state");
                notifyItemChanged(mCheckedPos);
            }
        }
    }
}





