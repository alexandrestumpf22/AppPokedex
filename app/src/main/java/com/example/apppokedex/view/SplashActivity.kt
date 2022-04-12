package com.example.apppokedex.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.example.apppokedex.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val backgroudImg : ImageView = findViewById(R.id.ivLogo)
        val sideAnimation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.slide)
        backgroudImg.startAnimation(sideAnimation)


        if (checkForInternet(this@SplashActivity)){
            changeToList()
        }
        else{
            Toast.makeText(this@SplashActivity, R.string.erro_internet, Toast.LENGTH_LONG).show()
            finish()
        }
    }

    fun changeToList(){
        val intent = Intent(this@SplashActivity, ListActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed({
            intent.change()
            finish()
        },3000)
    }

    fun Intent.change(){
        startActivity(this)
        finish()
    }

    //verificando se tem internet
    private fun checkForInternet(context: Context): Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when{
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                else -> false
            }
        }
        else{
            @Suppress("DEPRECATION") val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION") return networkInfo.isConnected
        }
    }
}