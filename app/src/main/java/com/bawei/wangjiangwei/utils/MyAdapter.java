package com.bawei.wangjiangwei.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.entity.NewsEntity;

import java.util.List;
/**
 * 姓名：王江伟
 * 时间：2019年12月3日10:28:24
 * 作用：适配器
 */
public class MyAdapter extends BaseAdapter {
    private List<NewsEntity.ShopGridDataBean> list;

    public MyAdapter(List<NewsEntity.ShopGridDataBean> list) {

        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = View.inflate(parent.getContext(), R.layout.buju,null);
            viewHolder = new ViewHolder();

            viewHolder.imageView = convertView.findViewById(R.id.img);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.price = convertView.findViewById(R.id.price);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NewsEntity.ShopGridDataBean shopGridDataBean = list.get(position);
        NetUtils.getInstance().getPhoto(shopGridDataBean.getImageurl(),viewHolder.imageView);
        viewHolder.name.setText(shopGridDataBean.getTitle());
        viewHolder.price.setText(shopGridDataBean.getPrice());
        return convertView;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView name;
        TextView price;
    }
}
