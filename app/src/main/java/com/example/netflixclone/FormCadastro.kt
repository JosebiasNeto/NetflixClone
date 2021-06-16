package com.example.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.netflixclone.databinding.ActivityFormCadastroBinding
import com.google.firebase.FirebaseApiNotAvailableException
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        Toolbar()

        binding.btCadastrar.setOnClickListener{

            val email = binding.etEmail.text.toString()
            val senha = binding.etSenha.text.toString()
            val mensagem = binding.tvMessageCadastro

            if (email.isEmpty() || senha.isEmpty()){
                mensagem.setText("Preencha todos os campos.")
            } else {
                CadastrarUsuario()
            }
        }

    }

    private fun CadastrarUsuario(){

        val email = binding.etEmail.text.toString()
        val senha = binding.etSenha.text.toString()
        val mensagem = binding.tvMessageCadastro

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener{
            if (it.isSuccessful){
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                binding.etEmail.setText("")
                binding.etSenha.setText("")
                mensagem.setText("")
            }
        }.addOnFailureListener{
            mensagem.setText("Erro ao cadastrar usuário.")
        }

    }

    private fun Toolbar(){
        val toolbar = binding.toolbarCadastro
        toolbar.setBackgroundColor(getColor(R.color.white))
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
    }
}