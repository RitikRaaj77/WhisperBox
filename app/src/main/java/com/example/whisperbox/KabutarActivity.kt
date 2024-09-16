package com.example.whisperbox

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KabutarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kabutar)

        Handler(Looper.myLooper()!!).postDelayed(Runnable {
//            if(auth.currentUser != null){
//                navController.navigate(R.id.action_splashFragment_to_homeFragment)
//            }else{
//                navController.navigate(R.id.action_splashFragment_to_signUpFragment)
//            }
            val i = Intent(this,SignUpActivity::class.java)
            finish()
            startActivity(i)
        },2000)
    }
}