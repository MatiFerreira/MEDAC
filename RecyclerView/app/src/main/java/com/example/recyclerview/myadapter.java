package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author Mathias Ferreira
 * **/
public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder> {
    private List<String>names;
    private int layout;
    private OnItemClickListener listener;

    public myadapter(List<String>names,int layout,OnItemClickListener listener){
         this.layout = layout;
         this.listener = listener;
         this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false); /*INFLAMOS LA VISTA*/
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(names.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView textViewname;

        public  ViewHolder(View view){
            super(view);
            this.textViewname = view.findViewById(R.id.textview);
        }

        public void bind(final String name,final OnItemClickListener listener){
            this.textViewname.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemclick(name,getAdapterPosition());
                }
            });
        }

    }

    public interface OnItemClickListener{
        void onItemclick(String nombre,int posicion);
    }

}
