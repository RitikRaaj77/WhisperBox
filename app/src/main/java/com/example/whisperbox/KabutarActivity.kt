package com.example.whisperbox

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class KabutarActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kabutar)

        auth = FirebaseAuth.getInstance()

        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            if(auth.currentUser != null){
                val i = Intent(this,MainActivity::class.java)
                finish()
                startActivity(i)
            }else{
                val i = Intent(this,LoginActivity::class.java)
                finish()
                startActivity(i)
            }
        },4000)
    }
}