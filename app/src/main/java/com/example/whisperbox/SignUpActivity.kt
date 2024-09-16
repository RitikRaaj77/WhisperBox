package com.example.whisperbox

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.whisperbox.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mDatabaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btnIn.setOnClickListener {
            val name = binding.nameTxt.text.toString()
            val email = binding.emailTxt.text.toString()
            val password = binding.pswdTxt.text.toString()
            val rePassword = binding.rePswdTxt.text.toString()

            signUp(email, password, rePassword, name)
        }
        binding.authSignInTxt.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(i)
        }


    }

    private fun signUp(email: String, password: String, rePassword: String, name: String) {
        if (password == rePassword) {
            auth.createUserWithEmailAndPassword(email, rePassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        addUserToDataBase(name, email, auth.currentUser?.uid!!)
                        val i = Intent(this@SignUpActivity, MainActivity::class.java)
                        finish()
                        startActivity(i)
                    } else {
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        } else {
            Toast.makeText(this, "Re-entered password is not same", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addUserToDataBase(name: String, email: String, uid: String?) {
        mDatabaseReference = FirebaseDatabase.getInstance().getReference()
        mDatabaseReference.child("user").child(uid!!).setValue(User(name, email, uid))
    }
}
//.reference.child("task")
//            .child(auth.currentUser?.uid.toString())