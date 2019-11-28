package com.example.beatboxer.recycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder> {
   private static int viewHolderCount;
   private int numberItems;
   private Context parent;
   public NumbersAdapter(int numberOfItems,Context parent){

       numberItems = numberOfItems;
       viewHolderCount=0;
       this.parent = parent;
   }
    @Override
    public NumbersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem,parent,false);
        NumbersViewHolder viewHolder = new NumbersViewHolder(view);
        viewHolder.viewHolderIndex.setText("ViewHolder index:"+viewHolderCount);
        viewHolderCount++;
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(NumbersViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumbersViewHolder extends RecyclerView.ViewHolder{
        TextView listItemNumberView;
        TextView viewHolderIndex;

        public NumbersViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.tv_number_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int positionIndex = getAdapterPosition();
                    Toast toast = Toast.makeText(parent,"Нажат элемент" + positionIndex,Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
