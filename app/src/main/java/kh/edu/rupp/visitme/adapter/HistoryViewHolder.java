package kh.edu.rupp.visitme.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.visitme.databinding.ViewHolderHistoryBinding;
import kh.edu.rupp.visitme.model.History;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    private ViewHolderHistoryBinding binding;

    public HistoryViewHolder(@NonNull ViewHolderHistoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(History history) {
        Picasso.get().load(history.getFoodImage()).into(binding.FoodImage);
        binding.FoodName.setText(history.getFoodName());
        binding.FoodPrice.setText(String.valueOf(history.getPrice()));
        binding.FoodDate.setText(history.getFoodDate());
    }

}


