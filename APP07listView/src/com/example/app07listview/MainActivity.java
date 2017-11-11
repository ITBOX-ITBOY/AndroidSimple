package com.example.app07listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView lv_main;
	private List<ShopInfo> data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv_main = (ListView) findViewById(R.id.lv_main);
		
		//׼����������
		data = new ArrayList<ShopInfo>();
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----1", "content----1"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----2", "content----2"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----3", "content----3"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----4", "content----4"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----5", "content----5"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----6", "content----6"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----7", "content----7"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----8", "content----8"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----9", "content----9"));
		data.add(new ShopInfo(R.drawable.ic_launcher, "name----10", "content----10"));
		//׼��BaseAdapter����
		MyAdapter adapter = new MyAdapter();
		//����Adapter��ʾ�б�
		lv_main.setAdapter(adapter);
	}
	
	
	class MyAdapter extends BaseAdapter {

		//���ؼ������ݵ�����
		@Override
		public int getCount() {
			Log.e("TAG", "getCount()");
			return data.size();
		}

		//����ָ���±��Ӧ�����ݶ���
		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		/**
		 * ����ָ���±�����Ӧ��item��View����
		 * position : �±�
		 * convertView : �ɸ��õĻ���Item��ͼ����, ǰn+1��Ϊnull
		 * parent : ListView����
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//Log.e("TAG", "getView() position="+position+" convertView="+convertView);
			//���û�и��õ�
			if(convertView==null) {
				Log.e("TAG", "getView() position="+position+" convertView="+convertView);
				//����item�Ĳ���, �õ�View����
				convertView = View.inflate(MainActivity.this, R.layout.item_simple_adapter, null);
			}
			
			//����position���ö�Ӧ������
				//�õ���ǰ�е����ݶ���
			ShopInfo shopInfo = data.get(position);
				//�õ���View����
			ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_item_icon);
			TextView nameTV = (TextView) convertView.findViewById(R.id.tv_item_name);
			TextView contentTV = (TextView) convertView.findViewById(R.id.tv_item_content);
				//��������
			imageView.setImageResource(shopInfo.getIcon());
			nameTV.setText(shopInfo.getName());
			contentTV.setText(shopInfo.getContent());
			
			return convertView;
		}
	}
	public static void main(String[] args) {
		
	}
}


