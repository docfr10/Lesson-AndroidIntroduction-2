package com.example.lesson_androidintroduction_2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Доступность нижней и верхней грани экрана для размещения контента
        enableEdgeToEdge()
        // Связь xml файла и кода
        setContentView(R.layout.activity_main)
        // Определение границ экрана телефона
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Взаимодействие с UI элементами в коде
        val textView = findViewById<TextView>(R.id.textView)
        val textView3: TextView = findViewById(R.id.textView3)
        val button = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Изменение текста в текстовом элементе
        textView.text = "Новый текст"

        // Слушатель нажатий
        button.setOnClickListener {
            textView3.setText(R.string.app_name)
        }

        var change = true

        imageView.setOnClickListener {
            // Смена изображения

            if (change) {
                imageView.setImageResource(R.drawable.maxresdefault)
                change = false
            } else {
                imageView.setImageResource(R.drawable.cat)
                change = true
            }
        }
    }
}