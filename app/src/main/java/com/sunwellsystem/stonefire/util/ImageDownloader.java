package com.sunwellsystem.stonefire.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by sunwell on 10/5/17.
 */

public class ImageDownloader<T> extends HandlerThread {

    private static final String TAG = "ImageDownloader";
    private static final int MESSAGE_DOWNLOAD = 0;
    private Handler requestHandler;
    private Handler responseHandler;
    private ConcurrentMap<T,String> mRequestMap = new ConcurrentHashMap<>();
    private DownloadListener<T> downloadListener;
    private Drawable defDrawable;

    public ImageDownloader(Handler _responsehandler, Drawable _defDrawable) {
        super(TAG);
        this.responseHandler = _responsehandler;
        this.defDrawable = _defDrawable;
    }

    public void queueImage(T target, String url) {
//        if (url == null) {
//            mRequestMap.remove(target);
//        } else {
//            mRequestMap.put(target, url);
//            requestHandler.obtainMessage(MESSAGE_DOWNLOAD, target).sendToTarget();
//        }
        mRequestMap.put(target, url != null ? url : "");
        requestHandler.obtainMessage(MESSAGE_DOWNLOAD, target).sendToTarget();
        Log.i(TAG, "Got a URL: " + url);
    }

    public void clearQueue() {
        requestHandler.removeMessages(MESSAGE_DOWNLOAD);
    }

    public void setThumbnailDownloadListener(DownloadListener<T> listener) {
        downloadListener = listener;
    }

    public interface DownloadListener<T> {
        void onImageDownloaded(T target, Bitmap thumbnail);
        void onImageDownloaded(T target, Drawable drawable);
    }

    @Override
    protected void onLooperPrepared() {
        requestHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == MESSAGE_DOWNLOAD) {
                    T target = (T) msg.obj;
                    Log.i(TAG, "Got a request for URL: " + mRequestMap.get(target));
                    handleRequest(target);
                } }
        };
    }

    private void handleRequest(final T target) {
        final String url = mRequestMap.get(target);

        Bitmap bitmap = null;
        if(url.length() > 0) {
            try {
                byte[] bitmapBytes = Util.sendGetRequest(url);
                bitmap = BitmapFactory
                        .decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
                Log.i(TAG, "Bitmap created");
            }
            catch(Exception e) {
                Log.w("Stonefire", "Error when dwonloading image");
            }
        }
        else
            bitmap = null;

        final Bitmap imageBitmap = bitmap;


        responseHandler.post(new Runnable() {
            public void run() {
                if (mRequestMap.get(target) != url) {
                    return;
                }
                if(imageBitmap != null)
                    downloadListener.onImageDownloaded(target, imageBitmap);
                else
                    downloadListener.onImageDownloaded(target, ImageDownloader.this.defDrawable);
            }
        });


//        try {
//            if (url.length() <= 0) {
//                responseHandler.post(new Runnable() {
//                    public void run() {
//                        if (mRequestMap.get(target) != url) {
//                            return;
//                        }
////                        mRequestMap.remove(target);
//                        downloadListener.onImageDownloaded(target, ImageDownloader.this.defDrawable);
//                    }
//                });
//            }
//            else {
//                byte[] bitmapBytes = null;
//                Bitmap bitmap = null;
//                if(url.length() > 0) {
//                    bitmapBytes = Util.sendGetRequest(url);
//                    bitmap = BitmapFactory
//                            .decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
//                }
//                Log.i(TAG, "Bitmap created");
//
//                responseHandler.post(new Runnable() {
//                    public void run() {
//                        if (mRequestMap.get(target) != url) {
//                            return;
//                        }
////                        mRequestMap.remove(target);
//                        downloadListener.onImageDownloaded(target, bitmap);
//                    }
//                });
//            }
//        } catch (IOException ioe) {
//            Log.e(TAG, "Error downloading image", ioe);
//            responseHandler.post(new Runnable() {
//                public void run() {
//                    if (mRequestMap.get(target) != url) {
//                        return;
//                    }
//                    downloadListener.onImageDownloaded(target, defDrawable);
//                }
//            });
//        }
    }
}
