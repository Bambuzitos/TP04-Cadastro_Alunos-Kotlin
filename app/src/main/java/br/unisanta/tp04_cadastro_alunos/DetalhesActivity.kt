package br.unisanta.tp04_cadastro_alunos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class DetalhesActivity : AppCompatActivity() {

    private lateinit var txtNomeAluno: TextView
    private lateinit var txtMatricula: TextView
    private lateinit var btnGerarMatricula: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detalhes)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtNomeAluno = findViewById(R.id.txtNomeAluno)
        txtMatricula = findViewById(R.id.txtMatricula)
        btnGerarMatricula = findViewById(R.id.btnGerarMatricula)

        val nome = intent.getStringExtra("NOME")
        txtNomeAluno.text = "Aluno: $nome"

        btnGerarMatricula.setOnClickListener {
            val matricula = Random.nextInt(1000, 9999)
            txtMatricula.text = "Matrícula: $matricula"
            btnGerarMatricula.isEnabled = false
        }
    }
}

