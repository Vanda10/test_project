package kh.edu.rupp.visitme.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.visitme.databinding.ViewHolderHistoryBinding;
import kh.edu.rupp.visitme.model.History;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {

    private List<History> dataSet = new ArrayList<>();

    public HistoryAdapter(List<History> historyList) {
        this.dataSet = historyList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolderHistoryBinding binding = ViewHolderHistoryBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new HistoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History history = dataSet.get(position);
        holder.bind(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
