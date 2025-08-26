package br.unisanta.tp04_cadastro_alunos

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
class MainActivity : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var fabProximo: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtNome = findViewById(R.id.edtNome)
        fabProximo = findViewById(R.id.fabProximo)

        fabProximo.setOnClickListener {
            val nome = edtNome.text.toString()
            if (nome.isNotEmpty()) {
                val intent = Intent(this, DetalhesActivity::class.java)
                intent.putExtra("NOME", nome)
                startActivity(intent)
                edtNome.text.clear()
            }
        }
    }
}

