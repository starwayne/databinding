package com.starwayne.databinding;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starwayne.databinding.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class PersonListAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private static final int ITEM_VIEW_TYPE_MAN = 1;
    private static final int ITEM_VIEW_TYPE_WOMAN = 2;

    private final LayoutInflater mLayoutInflater;

    private OnItemClickListener mListener;
    private List<Person> mPersonList;

    public interface OnItemClickListener {
        void onPersonClick(Person Person);
    }

    public PersonListAdapter(Context context) {
        mLayoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPersonList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        final Person Person = mPersonList.get(position);
        if (Person.isMale()) {
            return ITEM_VIEW_TYPE_MAN;
        } else {
            return ITEM_VIEW_TYPE_WOMAN;
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ITEM_VIEW_TYPE_MAN) {
            binding = DataBindingUtil.inflate(mLayoutInflater,
                    R.layout.list_item_man, parent, false);
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflater,
                    R.layout.list_item_woman, parent, false);
        }
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Person person = mPersonList.get(position);
        holder.getBinding().setVariable(BR.item, person);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onPersonClick(person);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void addAll(List<Person> Persons) {
        mPersonList.addAll(Persons);
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void add(Person Person) {
        int position = mRandom.nextInt(mPersonList.size() + 1);
        mPersonList.add(position, Person);
        notifyItemInserted(position);
    }

    public void remove() {
        if (mPersonList.size() == 0) {
            return;
        }
        int position = mRandom.nextInt(mPersonList.size());
        mPersonList.remove(position);
        notifyItemRemoved(position);
    }
}
