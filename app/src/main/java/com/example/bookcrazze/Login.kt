
package com.example.bookcrazze
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.bookcraze.Usernames
import com.example.bookcrazze.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val usernames = Usernames.userList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            validateUser()
        }

        binding.textView.setOnClickListener {
            startActivity(Intent(this, Registro::class.java))
            Animatoo.animateSwipeRight(this)
        }
    }

    private fun validateUser() {
        val user = binding.edtxtUsuario.text.toString()
        val password = binding.edtxtContrasenna.text.toString()
        val userFound = usernames.find { username ->
            username.username == user && username.password == password
        }

        if (userFound != null) {
            val intent = Intent(this, Inicio::class.java)
            intent.putExtra("username", userFound.username)
            startActivity(intent)

            Animatoo.animateSwipeRight(this)
        } else {
            binding.tilUsuario.error = "Usuario o contraseña incorrecta"
            binding.tilContrasenna.error = "Usuario o contraseña incorrecta"
            binding.edtxtUsuario.setText("")
            binding.edtxtContrasenna.setText("")
        }
    }

}
