package com.example.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.netflixclone.databinding.ActivityFormLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        VerificarUsuarioLogado()
        supportActionBar!!.hide()

        binding.txtTelaCadastro.setOnClickListener{
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }

        binding.btEntrar.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val senha = binding.etSenha.text.toString()
            val mensagem = binding.tvMessageErro

            if(email.isEmpty() || senha.isEmpty()){
                mensagem.setText("Preencha todos os campos.")
            } else {
                AutenticarUsuario()
            }
        }
    }
    private fun AutenticarUsuario(){
        val email = binding.etEmail.text.toString()
        val senha = binding.etSenha.text.toString()
        val mensagem = binding.tvMessageErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener{
            if (it.isSuccessful){
                Toast.makeText(this, "Login efetuado com Sucesso!", Toast.LENGTH_SHORT).show()
                IrParaTelaDeFilmes()
            }
        }.addOnFailureListener{

            var erro = it

            when{
             erro is FirebaseAuthInvalidCredentialsException -> mensagem.setText("E-mail ou Senha estão incorretos")
             erro is FirebaseNetworkException -> mensagem.setText("Sem conexão com a internet!")
             else -> mensagem.setText("Erro ao logar usuário")
            }
        }
    }
    private fun VerificarUsuarioLogado(){
        val usuarioLogado = FirebaseAuth.getInstance().currentUser
        if (usuarioLogado != null){
            IrParaTelaDeFilmes()
        }
    }
    private fun IrParaTelaDeFilmes(){
        val intent = Intent(this, ListaFilmes::class.java)
        startActivity(intent)
        finish()
    }
}