package com.cn.android.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * create by libo
 * create on 2018/11/15
 * description 高德定位工具类
 */
public class LocationManager implements AMapLocationListener {
    private ILocationCallBack callBack;

    public LocationManager() {

    }

    public void startLocation(Context context) {
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        AMapLocationClient mLocationClient = new AMapLocationClient( context );
        mLocationClient.setLocationListener( this );
        mLocationOption.setLocationMode( AMapLocationClientOption.AMapLocationMode.Hight_Accuracy ); //设置定位模式
        mLocationOption.setOnceLocation( true );
        mLocationOption.setOnceLocationLatest( true );
        mLocationOption.setNeedAddress( true );  //是否返回地址信息
        mLocationOption.setWifiActiveScan( false );
        mLocationOption.setMockEnable( false );//设置是否允许模拟位置,默认为true，允许模拟位置
        mLocationOption.setLocationCacheEnable( false );
        mLocationClient.setLocationOption( mLocationOption );
        mLocationClient.startLocation();
    }

    public static boolean isLocationEnabled(Context context) {
        int locationMode;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode = Settings.Secure.getInt( context.getContentResolver(), Settings.Secure.LOCATION_MODE );
                Log.i( "exp==============",String.valueOf(  locationMode) );
            } catch (Settings.SettingNotFoundException e) {
                Log.i( "exp==============",e.getMessage() );
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            locationProviders = Settings.Secure.getString( context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED );
            return !TextUtils.isEmpty( locationProviders );
        }
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }

        if (aMapLocation.getErrorCode() == 0) {
            double lat = aMapLocation.getLatitude();//获取纬度
            double lgt = aMapLocation.getLongitude();//获取经度
            String country = aMapLocation.getCountry();//国家信息
            String province = aMapLocation.getProvince();//省信息
            String city = aMapLocation.getCity();//城市信息
            String district = aMapLocation.getDistrict();//城区信息
            String street = aMapLocation.getStreet();//街道信息

            if (callBack != null) {
                callBack.callBack( country + province + city + district + street, lat, lgt, aMapLocation );
            }
        }
    }

//    /**
//     * 自定义图标
//     * @return
//     */
//    public MarkerOptions getMarkerOption(String str, double lat, double lgt) {
//        MarkerOptions markerOptions = new MarkerOptions();
////        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.coordinate));
//        markerOptions.position(new LatLng(lat,lgt));
//        markerOptions.title(str);
//        markerOptions.snippet("纬度:" + lat + "   经度:" + lgt);
//        markerOptions.period(100);
//        return markerOptions;
//    }

    public interface ILocationCallBack {
        void callBack(String str, double lat, double lgt, AMapLocation aMapLocation);
    }

    public void setLocationCallBack(ILocationCallBack callBack) {
        this.callBack = callBack;
    }

//    /**
    /**
     *  MD5:  A0:DE:DE:61:86:05:AA:1A:E0:E0:88:1F:0E:2D:66:F4
     *          SHA1: 1C:1D:45:BE:2E:65:57:3B:D9:8D:AF:95:F8:A4:43:3D:B6:26:40:CD
     *          SHA256: 89:38:DA:90:61:56:EE:42:A7:5D:49:30:87:7D:59:90:1B:FA:71:A5:6A:F1:E5:42:01:A7:13:BC:40:18:54:0E
     */
}

