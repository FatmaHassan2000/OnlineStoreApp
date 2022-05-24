package com.example.finalprojict;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PieceAdapter extends RecyclerView.Adapter<PieceAdapter.pieceViewHolder> {
    ArrayList<Piece> pieces;
    Context context;

    public PieceAdapter(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    @NonNull
    @Override
    public PieceAdapter.pieceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_main_item,null,false) ;

        PieceAdapter.pieceViewHolder p = new PieceAdapter.pieceViewHolder(v) ;
        return p;
    }

    public void onBindViewHolder(@NonNull PieceAdapter.pieceViewHolder holder, int position) {
        Piece p = pieces.get(position);
        holder.name.setText((p.getName()));
        holder.price.setText((p.getPrice()));
        holder.rating.setText((p.getRating()));
        holder.image.setImageResource(p.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context , Info.class);
                i.putExtra("name", pieces.get(position).getName());
                i.putExtra("price", pieces.get(position).getPrice());
                i.putExtra("rating", pieces.get(position).getRating());
                i.putExtra("image", pieces.get(position).getImage());
                i.putExtra("desc" , pieces.get(position).getDesc());

                context.startActivity(i);
            }

        });
    }

    @Override
    public int getItemCount() {
        return pieces.size();
    }

    public class pieceViewHolder extends RecyclerView.ViewHolder {
        ImageView image,favourite;
        TextView name,price,rating;
        public pieceViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            image=itemView.findViewById(R.id.pieceimg);
            favourite=itemView.findViewById(R.id.piecefav);
            name=itemView.findViewById(R.id.piecename);
            price=itemView.findViewById(R.id.pieceprice);
            rating=itemView.findViewById(R.id.piecerating);
        }
    }
}
