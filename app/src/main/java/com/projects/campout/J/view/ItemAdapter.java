package com.projects.campout.J.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.projects.campout.J.model.api.entity.Section;
import com.projects.campout.J.R;
import com.projects.campout.J.view.ItemAdapter.ItemHolder;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

  private static final int SECTION_TYPE = 0;
  private static final int ITEM_TYPE = 1;
  private final Context context;

  private List<Object> items;

  public ItemAdapter(Context context, List<Object> items) {
    this.context = context;
    this.items = items;
  }

  @Override
  public int getItemViewType(int position) {
    if (items.get(position) instanceof Section) {
      return SECTION_TYPE;
    }
    return ITEM_TYPE;
  }

  @NonNull
  @Override
  public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    int layoutId = (viewType == SECTION_TYPE) ? R.layout.section : R.layout.item;
    View view = LayoutInflater.from(context).inflate(layoutId,parent,false);
    return new ItemHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public class ItemHolder extends RecyclerView.ViewHolder {

    private TextView itemView;

    public ItemHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = (TextView) itemView;

    }

    private void bind(int position){
      //TODO Use relevant information for section or item
      itemView.setText(items.get(position).toString());
    }
  }
}


