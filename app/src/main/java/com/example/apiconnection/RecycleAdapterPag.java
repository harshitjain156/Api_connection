package com.example.apiconnection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiconnection.ModelResponses.HomeResponses.Datum;

import java.util.List;

public class RecycleAdapterPag extends RecyclerView.Adapter<RecycleAdapterPag.ViewHolder> {
    private Context context;
    private List<Datum> contacts;

    public RecycleAdapterPag(Context context, List<Datum> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public RecycleAdapterPag.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterPag.ViewHolder holder, int position) {
        Datum homeresponse=contacts.get(position);

        holder.name.setText(contacts.get(position).getName());
        holder.name_class.setText(homeresponse.getClass_());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView name_class;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this::onClick);
            name=itemView.findViewById(R.id.name);
            name_class=itemView.findViewById(R.id.name_class);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,"error",Toast.LENGTH_SHORT).show();
        }
    }
}
