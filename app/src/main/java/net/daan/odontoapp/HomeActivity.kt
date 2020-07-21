package net.daan.odontoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import net.daan.odontoapp.adapter.DentistaRecyclerAdapter
import net.daan.odontoapp.http.HttpHelper
import net.daan.odontoapp.model.Dentista
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class HomeActivity : AppCompatActivity() {

    private lateinit var email: String
    private lateinit var senha: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {
        email = intent.getStringExtra("EMAIL")!!
        senha = intent.getStringExtra("SENHA")!!

        buttom_abrir_cadastro_dentista.setOnClickListener {
            val abrirCadastroDentista = Intent(this, CadastroDentistaActivity::class.java)

            abrirCadastroDentista.putExtra("EMAIL", email)
            abrirCadastroDentista.putExtra("SENHA", senha)

            startActivity(abrirCadastroDentista)
        }

        buttom_abrir_lista_dentistas.setOnClickListener {
            val abrirListaDentsita = Intent(this, MainActivity::class.java)
            abrirListaDentsita.putExtra("EMAIL", email)
            abrirListaDentsita.putExtra("SENHA", senha)

            startActivity(abrirListaDentsita)

        }

    }


}
