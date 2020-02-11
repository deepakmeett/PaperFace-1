package com.meet.paperface.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meet.paperface.R;
import com.meet.paperface.model.Your_Order_Model;

import java.util.List;
public class Your_Order_Adapter extends RecyclerView.Adapter<Your_Order_Adapter.ViewHolder> {

      Context fcontext;
     List<Your_Order_Model> fupload;

    public void add(Your_Order_Model s) {
        fupload.add( s );
    }

    public Your_Order_Adapter(Context context, List<Your_Order_Model> user) {
        fcontext = context;
        fupload = user;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( fcontext ).inflate( R.layout.data_list_shop, parent, false );

        ViewHolder holder=new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.page.setText( fupload.get( position ).getPage() );
        holder.rs.setText( fupload.get( position ).getRs() );
        holder.date.setText( fupload.get( position ).getDate() );

    }

    @Override
    public int getItemCount() {
        return fupload.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

         TextView page;
         TextView rs;
         TextView date;

        ViewHolder(@NonNull View itemView) {
            super( itemView );
            page = itemView.findViewById( R.id.card_Pages_shop_blank );
            rs = itemView.findViewById( R.id.card_Rupees_shop_blank );
            date = itemView.findViewById( R.id.card_date_blank );

        }
    }
}

