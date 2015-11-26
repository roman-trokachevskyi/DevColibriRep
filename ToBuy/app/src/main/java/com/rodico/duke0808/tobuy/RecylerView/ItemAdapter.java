package com.rodico.duke0808.tobuy.RecylerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import com.rodico.duke0808.tobuy.R;

/**
 * Created by duke0808 on 26.11.15.
 */


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> implements DraggableItemAdapter<ItemAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    private Context context;
    ItemList currentList;

    public ItemAdapter(Context context, ItemList list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        currentList = list;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p/>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p/>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout, parent);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p/>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p/>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle effcient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = currentList.get(position);
        holder.textView.setText(item.title);
        holder.checkBox.setChecked(item.checked);
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return currentList.size();
    }

    /**
     * Called when user is attempt to drag the item.
     *
     * @param holder   The ViewHolder which is associated to item user is attempt to start dragging.
     * @param position The position of the item within the adapter's data set.
     * @param x        Touched X position. Relative from the itemView's top-left.
     * @param y        Touched Y position. Relative from the itemView's top-left.
     * @return Whether can start dragging.
     */
    @Override
    public boolean onCheckCanStartDrag(MyViewHolder holder, int position, int x, int y) {
        return false;
    }

    /**
     * Called after the {@link #onCheckCanStartDrag(RecyclerView.ViewHolder, int, int, int)} method returned true.
     *
     * @param holder   The ViewHolder which is associated to item user is attempt to start dragging.
     * @param position The position of the item within the adapter's data set.
     * @return null: no constraints (= new ItemDraggableRange(0, getItemCount() - 1)),
     * otherwise: the range specified item can be drag-sortable.
     */
    @Override
    public ItemDraggableRange onGetItemDraggableRange(MyViewHolder holder, int position) {
        return null;
    }

    /**
     * Called when item is moved. Should apply the move operation result to data set.
     *
     * @param fromPosition Previous position of the item.
     * @param toPosition   New position of the item.
     */
    @Override
    public void onMoveItem(int fromPosition, int toPosition) {

    }

    public class MyViewHolder extends AbstractDraggableItemViewHolder{
        TextView textView;
        CheckBox checkBox;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_text);
            checkBox = (CheckBox) itemView.findViewById(R.id.item_check_box);
        }
    }
}
