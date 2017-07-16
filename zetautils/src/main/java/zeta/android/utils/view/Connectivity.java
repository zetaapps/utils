package zeta.android.utils.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class Connectivity {

    private ConnectivityManager mConnectivityManager;

    public Connectivity(Context context) {
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * Conveys if the device has some sort of network connectivity.
     *
     * @return true if the device has network connectivity
     */
    public boolean isConnected() {
        NetworkInfo activeNetwork = mConnectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    /**
     * Conveys if the device is connected to WIFI.
     *
     * @return true if connected to WIFI
     */
    public boolean isConnectedToWifi() {
        NetworkInfo activeNetwork = mConnectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

}
