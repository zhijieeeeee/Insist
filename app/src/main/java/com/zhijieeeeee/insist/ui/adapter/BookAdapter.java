package com.zhijieeeeee.insist.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.bean.Book;

import java.util.List;

/**
 * Created by tangzhijie on 2018/3/26.
 */

public class BookAdapter extends BaseQuickAdapter<Book, BaseViewHolder> {

    public BookAdapter(@Nullable List<Book> data) {
        super(R.layout.item_book, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Book item) {
        helper.setText(R.id.tv_name, "《" + item.getName() + "》");
        helper.setText(R.id.tv_period, item.getStartDate() + " 至 " + item.getEndDate());
    }
}
