package com.example.finalprojict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    public static Context context;
    private List<CartItem> cartList;


    public CartAdapter(Context context, List<CartItem> cartAdapterList) {
        this.context = context;
        this.cartList = cartAdapterList;
    }

    public CartAdapter(Cart cart, int cart_item, ArrayList<CartItem> cartList) {this.cartList = cartList;
    }



    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item,null,false) ;
        CartViewHolder c = new CartViewHolder(v);
        return c;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int i) {

        CartItem cartItem = cartList.get(i);
        cartViewHolder.cartName.setText(cartItem.getName());
        cartViewHolder.cartPrice.setText(cartItem.getPrice());
        cartViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteHelper db = new SQLiteHelper(context);
                boolean res =db.deleteCartItim(cartList.get(i).getName());
                if(res){
                    Toast.makeText(context, "Itim deleted", Toast.LENGTH_SHORT).show();
                    cartList.remove(i);
                    notifyItemRemoved(i);
                }else
                    Toast.makeText(context, "failed delete", Toast.LENGTH_SHORT).show();
            }
        });
    /*    cartViewHolder.cartComponent.setText(cartItem.getcomponent());
        cartViewHolder.cartImage.setImageResource(cartItem.getImg());*/


    }
    public void addItem(CartItem cart){
        this.cartList.add(cart);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView cartImage;
        TextView cartName, cartPrice, cartComponent;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();


            cartImage = itemView.findViewById(R.id.item_img);
            cartName = itemView.findViewById(R.id.item_name);
            cartPrice = itemView.findViewById(R.id.price);
            cartComponent = itemView.findViewById(R.id.item_place);
        }
    }



}
