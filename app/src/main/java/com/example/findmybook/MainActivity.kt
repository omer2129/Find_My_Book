package com.example.findmybook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var signup:Button=findViewById(R.id.btnsignup)
        var signin:Button=findViewById(R.id.btnsignin)
        var username:EditText=findViewById(R.id.editTextName)
        var password:EditText=findViewById(R.id.editTextPass)

        var strUsername = username.text.toString()
        var strPassword = password.text.toString()

        signup.setOnClickListener({

            var auth:FirebaseAuth=Firebase.auth
            auth.createUserWithEmailAndPassword(strUsername, strPassword).addOnCompleteListener(this)
            {
                task->
                if(task.isSuccessful)
                    Toast.makeText(this@MainActivity, "User is created", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this@MainActivity, "Unable to create new user", Toast.LENGTH_SHORT).show()
            }
        })

        signin.setOnClickListener({
            var auth2:FirebaseAuth=Firebase.auth
            auth2.signInWithEmailAndPassword(strUsername, strPassword).addOnCompleteListener(this)
            {
                task->
                if(task.isSuccessful)
                    Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this@MainActivity, "Unable to Login", Toast.LENGTH_SHORT).show()

            }
        })
    }
}
