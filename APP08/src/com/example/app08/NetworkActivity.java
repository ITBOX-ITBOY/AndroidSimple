package com.example.app08;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NetworkActivity extends Activity {

	private EditText et_network_url;
	private EditText et_network_result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network);

		et_network_url = (EditText) findViewById(R.id.et_network_url);
		et_network_result = (EditText) findViewById(R.id.et_network_result);
	}

	public void testConnectionGet(View v) {
		final ProgressDialog progressDialog = ProgressDialog.show(this, null, "处理中。。。。");

		new Thread() {
			public void run() {
				String path = et_network_url.getText().toString() + "?name=Tom&age=34";

				try {
					URL url = new URL(path);
					HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
					openConnection.setRequestMethod("GET");
					openConnection.setConnectTimeout(5000);
					openConnection.setReadTimeout(6000);
					openConnection.connect();

					int resultCode = openConnection.getResponseCode();

					if (resultCode == 200) {
						InputStream inputStream = openConnection.getInputStream();

						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = -1;
						while ((len = inputStream.read(buffer)) != -1) {
							byteArrayOutputStream.write(buffer, 0, len);
						}
						final String result = byteArrayOutputStream.toString();

						byteArrayOutputStream.close();
						inputStream.close();

						runOnUiThread(new Runnable() {
							public void run() {
								et_network_result.setText(result);
								progressDialog.dismiss();
							}
						});
					}
					// 网络连接断开
					openConnection.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();

	}

	/*
	 * 使用httpUrlConnection提交post请求
	 */
	/*
	 * 1. 显示ProgressDialog 2. 启动分线程 3. 在分线程, 发送请求, 得到响应数据 1). 得到path 2). 创建URL对象
	 * 3). 打开连接, 得到HttpURLConnection对象 4). 设置请求方式,连接超时, 读取数据超时 5). 连接服务器 6).
	 * 发请求, 得到响应数据 得到输出流, 写请求体:name=Tom1&age=11 得到响应码, 必须是200才读取 得到InputStream,
	 * 并读取成String 7). 断开连接 4. 在主线程, 显示得到的结果, 移除dialog
	 */
	public void testConnectionPost(View v) {
		final ProgressDialog progressDialog = ProgressDialog.show(this, null, "正在加载中。。。。");

		new Thread() {
			public void run() {
				String path = et_network_url.getText().toString();
				try {
					URL url = new URL(path);
					HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
					openConnection.setRequestMethod("POST");
					openConnection.setConnectTimeout(5000);
					openConnection.setReadTimeout(6000);
					openConnection.connect();

					OutputStream outputStream = openConnection.getOutputStream();
					String data = "name=Tom&age=34";
					outputStream.write(data.getBytes("utf-8"));
					int resultCode = openConnection.getResponseCode();

					if (resultCode == 200) {
						InputStream inputStream = openConnection.getInputStream();

						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = -1;
						while ((len = inputStream.read(buffer)) != -1) {
							byteArrayOutputStream.write(buffer, 0, len);
						}
						final String result = byteArrayOutputStream.toString();

						byteArrayOutputStream.close();
						inputStream.close();

						runOnUiThread(new Runnable() {
							public void run() {
								et_network_result.setText(result);
								progressDialog.dismiss();
							}
						});
					}
					// 网络连接断开
					openConnection.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
					progressDialog.dismiss();
				}
			}
		}.start();

	}

	/*
	 * 使用httpClient提交get请求
	 */
	public void testClientGet(View v) {
		final ProgressDialog progressDialog = ProgressDialog.show(this, null, "处理中。。。。");

		new Thread() {
			public void run() {
				String path = et_network_url.getText().toString() + "?name=Tom&age=34";

				try {
					//获取httpClient对象
					HttpClient httpClient=new DefaultHttpClient();
					//参数设置
					HttpParams params = httpClient.getParams();
					HttpConnectionParams.setConnectionTimeout(params, 5000);
					HttpConnectionParams.setSoTimeout(params, 5000);
					//进行发送请求
					HttpGet httpGet=new HttpGet(path);
					HttpResponse execute = httpClient.execute(httpGet);
					
					int statusCode = execute.getStatusLine().getStatusCode();

					if (statusCode == 200) {
						//获取响应的实体
						HttpEntity entity=execute.getEntity();
						final String result = EntityUtils.toString(entity);
						
						runOnUiThread(new Runnable() {
							public void run() {
								et_network_result.setText(result);
								progressDialog.dismiss();
							}
						});
					}
					// 网络连接断开
					httpClient.getConnectionManager().shutdown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	/*
	 * 使用httpClient提交post请求
	 */
	public void testClientPost(View v) {
		//1. 显示ProgressDialog
		final ProgressDialog dialog = ProgressDialog.show(this, null, "正在请求中...");
		//2. 启动分线程
		new Thread(){
			//3. 在分线程, 发送请求, 得到响应数据
			public void run() {
				try {
					//1). 得到path
					String path = et_network_url.getText().toString();
					
					//2). 创建HttpClient对象
					HttpClient httpClient = new DefaultHttpClient();
					//3). 设置超时
					HttpParams params = httpClient.getParams();
					HttpConnectionParams.setConnectionTimeout(params, 5000);
					HttpConnectionParams.setSoTimeout(params, 5000);
					//4). 创建请求对象
					HttpPost request = new HttpPost(path);
					//设置请求体
					List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
					parameters.add(new BasicNameValuePair("name", "Tom4"));
					parameters.add(new BasicNameValuePair("age", "14"));
					HttpEntity entity = new UrlEncodedFormEntity(parameters);
					request.setEntity(entity);
					
					//5). 执行请求对象, 得到响应对象
					HttpResponse response = httpClient.execute(request);
					
					int statusCode = response.getStatusLine().getStatusCode();
					if(statusCode==200) {
						//6). 得到响应体文本
						entity = response.getEntity();
						final String result = EntityUtils.toString(entity);
						//4. 要主线程, 显示数据, 移除dialog
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								et_network_result.setText(result);
								dialog.dismiss();
							}
						});
					}
					//7). 断开连接
					httpClient.getConnectionManager().shutdown();
				} catch (Exception e) {
					e.printStackTrace();
					//如果出了异常要移除dialog
					dialog.dismiss();
				}
			}
		}.start();
	}

}
