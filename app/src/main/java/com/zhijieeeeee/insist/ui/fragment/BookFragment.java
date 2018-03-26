package com.zhijieeeeee.insist.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.fragment.BaseFragment;
import com.zhijieeeeee.insist.bean.Book;
import com.zhijieeeeee.insist.contract.BookContract;
import com.zhijieeeeee.insist.presenter.BookPresenter;
import com.zhijieeeeee.insist.ui.adapter.BookAdapter;
import com.zhijieeeeee.insist.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tangzhijie on 2018/3/26.
 */

public class BookFragment extends BaseFragment<BookPresenter> implements BookContract.View {
    @BindView(R.id.ll_reading)
    LinearLayout llReading;
    @BindView(R.id.tv_book_name)
    TextView tvBookName;
    @BindView(R.id.tv_start_date)
    TextView tvStartDate;
    @BindView(R.id.tv_read_done)
    TextView tvReadDone;
    @BindView(R.id.tv_read_num)
    TextView tvReadNum;
    @BindView(R.id.rv_record)
    RecyclerView rvRecord;
    @BindView(R.id.btn_add)
    FloatingActionButton btnAdd;

    private Book mReadingBook;
    private BookAdapter bookAdapter;
    private List<Book> bookList = new ArrayList<>();

    @Override
    public void showBookList(List<Book> list) {
        bookList.clear();
        bookList.addAll(list);
        bookAdapter.notifyDataSetChanged();
        tvReadNum.setText("已读：" + list.size() + "本");
    }

    @Override
    public void notifyListChange() {
        bookAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshComplete() {

    }

    @Override
    public void showReadingBook(Book book) {
        mReadingBook = book;
        if (mReadingBook != null) {
            btnAdd.setVisibility(View.GONE);
            llReading.setVisibility(View.VISIBLE);
            tvBookName.setText("《" + mReadingBook.getName() + "》");
            tvStartDate.setText("开始时间 : " + mReadingBook.getStartDate());
        } else {
            btnAdd.setVisibility(View.VISIBLE);
            llReading.setVisibility(View.GONE);
        }
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.book_fragment;
    }

    @Override
    public void before(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        rvRecord.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void initData() {
        bookAdapter = new BookAdapter(bookList);
        bookAdapter.bindToRecyclerView(rvRecord);

        mPresenter.getReadingBook();
        mPresenter.getReadBookList(true);
    }

    @Override
    public boolean registerEventBus() {
        return false;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @OnClick({R.id.tv_read_done, R.id.btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_read_done:
                new AlertDialog.Builder(mActivity)
                        .setTitle("你确定读完了吗？")
                        .setPositiveButton("读完了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (mReadingBook != null) {
                                    mPresenter.setReadComplete(mReadingBook);
                                }
                            }
                        })
                        .setNegativeButton("还没", null).create().show();
                break;
            case R.id.btn_add:
                final EditText et = new EditText(mActivity);
                new AlertDialog.Builder(mActivity).setTitle("请输入书名")
                        .setView(et)
                        .setPositiveButton("添加", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String input = et.getText().toString();
                                if (TextUtils.isEmpty(input)) {
                                    ToastUtil.show("书名不能为空");
                                } else {
                                    mPresenter.insertBook(input);
                                }
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
        }
    }
}
