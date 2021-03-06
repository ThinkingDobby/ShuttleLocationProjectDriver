package kr.rabbito.shuttlelocationprojectdriver.functions

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat


fun getLocation(result: Array<Double>, locationManager: LocationManager, context: Context, activity: Activity) {
    val locationListener = object : LocationListener {

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            //super.onStatusChanged(provider, status, extras)
        }

        override fun onLocationChanged(location: Location) {
            // 위치 정보 전달 목적으로 호출(자동으로 호출)
            result[0] = location.latitude
            result[1] = location.longitude
            Log.d("서비스", "주기적 갱신중,${result[0]},${result[1]}")
        }

        override fun onProviderEnabled(provider: String) {
            // provider가 사용 가능한 생태가 되는 순간 호출
        }

        override fun onProviderDisabled(provider: String) {
            // provider가 사용 불가능 상황이 되는 순간 호출
        }
    }
    //Listener를 사용하여 위치를 갱신할 주기를 설정
    //Listener 미사용시 주석처리
    // 매개변수로 위치 정보 제공자, LocationListener 호출 주기, 변경 위치 거리의 정보, LocationListener전달
    locationManager.requestLocationUpdates(
        LocationManager.GPS_PROVIDER, 10000
        , 10.0f, locationListener)
}