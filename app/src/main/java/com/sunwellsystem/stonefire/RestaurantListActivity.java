package com.sunwellsystem.stonefire;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunwellsystem.stonefire.util.ImageDownloader;
import com.sunwellsystem.stonefire.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import sunwell.stonefire.core.entity.Tenant;

public class RestaurantListActivity extends AppCompatActivity {

    ProgressDialogFragment dialogFragment;
    RecyclerView tenantList;
    ImageDownloader<TenantHolder> downloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_restaurant_list);

            tenantList = (RecyclerView) findViewById(R.id.tenantList);
            tenantList.setLayoutManager(new LinearLayoutManager(this));

            FragmentManager fm = getSupportFragmentManager();
            dialogFragment = new ProgressDialogFragment();
            dialogFragment.setCancelable(false);
            dialogFragment.show(fm, "LOADING");

            Handler responseHandler = new Handler();
            Drawable defDrawable = getResources().getDrawable(R.mipmap.ic_launcher);
            downloader = new ImageDownloader<>(responseHandler, defDrawable);
            downloader.setThumbnailDownloadListener(
                    new ImageDownloader.DownloadListener<TenantHolder>() {

                        @Override
                        public void onImageDownloaded(TenantHolder _tenantHolder, Bitmap _bitmap) {
                            Drawable drawable = new BitmapDrawable(getResources(), _bitmap);
                            _tenantHolder.bindDrawable(drawable);
                        }

                        @Override
                        public void onImageDownloaded(TenantHolder _tenantHolder, Drawable _drawable) {
                            _tenantHolder.bindDrawable(_drawable);
                        }
                    }
            );
            downloader.start();
            downloader.getLooper();

            new FetchTenantsTask().execute();
        }
        catch(Exception e) {
            Log.d("Stonefire", "Error when constructing Return List Activity, message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        downloader.clearQueue();
        downloader.quit();
    }

    private class TenantHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public TextView nameTextView;
        public TextView descTextView;

        public TenantHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.tenant_image);
            nameTextView = (TextView) itemView.findViewById(R.id.tenant_name);
            descTextView = (TextView) itemView.findViewById(R.id.tenant_description);
        }

        public void bindDrawable(Drawable drawable) {
            imageView.setImageDrawable(drawable);
        }
    }

    private class TenantAdapter extends RecyclerView.Adapter<TenantHolder> {
        private List<Tenant> tenants;
        public TenantAdapter(List<Tenant> tenants) {
            this.tenants = tenants;
        }

        @Override
        public TenantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(RestaurantListActivity.this);
            View view = layoutInflater
                    .inflate(R.layout.tenant_row, parent, false);
            return new TenantHolder(view);
        }

        @Override
        public void onBindViewHolder(TenantHolder holder, int position) {
            Tenant tenant = this.tenants.get(position);
            holder.nameTextView.setText(tenant.getName());
            holder.descTextView.setText(tenant.getDescription());
            if(tenant.getProfilePicture() == null)
                downloader.queueImage(holder, null);
            else {
                Log.d("Stonefire", "Tenant: " + tenant.getName() + " pos: " + position + " url: " + Util.getImageURL(tenant.getId(), tenant.getProfilePicture()));
                downloader.queueImage(holder, Util.getImageURL(tenant.getId(), tenant.getProfilePicture()));
            }
        }

        @Override
        public int getItemCount() {
            return this.tenants.size();
        }
    }

    private class FetchTenantsTask extends AsyncTask<Void, Void, List<Tenant>>
    {
        @Override
        protected List<Tenant> doInBackground(Void... params) {
            try {
                String responseString = Util.getRequest(Util.TENANTS_URL);
                JSONObject jsonObj = new JSONObject(responseString);
                JSONArray tenantsList = jsonObj.getJSONArray("tenantsList");
                List<Tenant> tenants = parseTenantJSON(tenantsList);
                return tenants;
            } catch (Exception e) {
                Log.d("STONEFIRE", "Exception: " + e.getMessage());
                e.printStackTrace();
                return null;

            }
        }

        @Override
        protected void onPostExecute(List<Tenant> tenants) {
            RestaurantListActivity.this.tenantList.setAdapter(new TenantAdapter(tenants));
            dialogFragment.dismiss();
        }
    }

//    public class ImageDownloader<T> extends HandlerThread {
//
//        private static final String TAG = "ImageDownloader";
//        private static final int MESSAGE_DOWNLOAD = 0;
//        private Handler mRequestHandler;
//        private ConcurrentMap<T,String> mRequestMap = new ConcurrentHashMap<>();
//
//        public ImageDownloader() {
//            super(TAG);
//        }
//
//        public void queueImage(T target, String url) {
//            if (url == null) {
//                mRequestMap.remove(target);
//            } else {
//                mRequestMap.put(target, url);
//                mRequestHandler.obtainMessage(MESSAGE_DOWNLOAD, target).sendToTarget();
//            }
//            Log.i(TAG, "Got a URL: " + url);
//        }
//
//        public void clearQueue() {
//            mRequestHandler.removeMessages(MESSAGE_DOWNLOAD);
//        }
//
//        public interface ThumbnailDownloadListener<T> {
//            void onImageDownloaded(T target, Bitmap thumbnail);
//        }
//
//        @Override
//        protected void onLooperPrepared() {
//            mRequestHandler = new Handler() {
//                @Override
//                public void handleMessage(Message msg) {
//                    if (msg.what == MESSAGE_DOWNLOAD) {
//                        T target = (T) msg.obj;
//                        Log.i(TAG, "Got a request for URL: " + mRequestMap.get(target));
//                        handleRequest(target);
//                    } }
//            };
//        }
//
//        private void handleRequest(final T target) {
//            try {
//                final String url = mRequestMap.get(target);
//                if (url == null) {
//                    return; }
//                byte[] bitmapBytes = Util.sendGetRequest(url);
//                final Bitmap bitmap = BitmapFactory
//                        .decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
//                Log.i(TAG, "Bitmap created");
//            } catch (IOException ioe) {
//                Log.e(TAG, "Error downloading image", ioe);
//            }
//        }
//    }

    private List<Tenant> parseTenantJSON(JSONArray _array) throws JSONException {
        List<Tenant> retval = null;
        if(_array.length() <= 0)
            return retval;

        retval = new LinkedList<>();
        for(int i = 0 ; i < _array.length(); i++) {
            Tenant t = new Tenant();
            JSONObject obj = _array.getJSONObject(i);

            t.setId(obj.getString("id"));
            t.setName(obj.getString("name"));
            t.setCity(obj.has("city") ? obj.getString("city") : null);
            t.setProvince(obj.has("province") ? obj.getString("province") : null);
            t.setCountry(obj.has("country") ? obj.getString("country") : null);
            t.setDescription(obj.has("description") ? obj.getString("description") : null);
            t.setPhoneNumber(obj.has("phoneNumber") ? obj.getString("phoneNumber") : null);
            t.setMemo(obj.has("memo") ? obj.getString("memo") : null);
            t.setNews(obj.has("news") ? obj.getString("news") : null);
            t.setProfilePicture(obj.has("profilePicture") ? obj.getString("profilePicture") : null);
            t.setLogo(obj.has("logo") ? obj.getString("logo") : null);

            retval.add(t);
        }

        return retval;
    }

//    private class SamplePostTest extends AsyncTask<Void, Void, List<Tenant>>
//    {
//
//        @Override
//        protected List<Tenant> doInBackground(Void... params) {
//            try {
//                Log.d("STONEFIRE", "posting now...");
//                JSONObject obj = new JSONObject();
//                obj.put("email", "tenant1@example.com");
//                obj.put("password", "12345");
//                String responseString = Util.postRequest(Util.LOGIN_URL, String.valueOf(obj));
//                Log.d("STONEFIRE", responseString);
//                JSONObject jsonObj = new JSONObject(responseString);
//            } catch (Exception e) {
//                Log.d("STONEFIRE", "Exception: " + e.getMessage());
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(List<Tenant> tenants) {
//            dialogFragment.dismiss();
//        }
//    }


}
