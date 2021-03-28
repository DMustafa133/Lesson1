package com.example.lesson1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class firstRecyclerViewAdapter extends RecyclerView.Adapter<firstRecyclerViewAdapter.infoViewHolder> {



    private List<DataClass> dataClass;
    private OnItemCickListener onItemCickListener;
    public static final String DATA_INFO = "data_info";

    public firstRecyclerViewAdapter(OnItemCickListener onItemCickListener) {
        this.onItemCickListener = onItemCickListener;
    }


    public void setDataClassList(List<DataClass> dataClass) {
        this.dataClass = dataClass;
        notifyDataSetChanged();
    }

    public void removeData(int position) {
        dataClass.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public List<DataClass> getInfo() {
        return dataClass;
    }

    @NonNull
    @Override
    public infoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_list_item,
                parent, false);
        return new infoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull infoViewHolder holder, int position) {

        holder.tv_fio.setText(dataClass.get(position).getFio());
        holder.tv_date.setText(dataClass.get(position).getDate());
        holder.tv_email.setText(dataClass.get(position).getEmail());
        holder.imageView.setImageResource(dataClass.get(position).getImage());
        holder.btn_del.setText("Delete");
    }

    @Override
    public int getItemCount() {
        return dataClass == null ? 0: dataClass.size();
    }

    public interface OnItemCickListener {
        void itemClick(View v, int adapterPosition);
        void itemDelete(int adapterPosition);
    }


    class infoViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tv_fio;
        TextView tv_date;
        TextView tv_email;
        Button btn_del;

        public infoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tv_fio = itemView.findViewById(R.id.tv_fio);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_email = itemView.findViewById(R.id.tv_email);
            btn_del = itemView.findViewById(R.id.btn_delete);


            itemView.setOnClickListener(v -> {
                if(onItemCickListener != null) {
                    onItemCickListener.itemClick(v, getAdapterPosition());
                }
            });
            btn_del.setOnClickListener(v -> {
                onItemCickListener.itemDelete(getAdapterPosition());
            });

        }
    }
}
