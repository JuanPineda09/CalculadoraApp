package com.example.calculadoraapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.example.calculadoraapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val punto = findViewById<Button>(R.id.btnPunto);
        val cero = findViewById<Button>(R.id.btn0);
        val uno = findViewById<Button>(R.id.btn1);
        val tres = findViewById<Button>(R.id.btn3);
        val dos = findViewById<Button>(R.id.btn2);
        val cuatro = findViewById<Button>(R.id.btn4);
        val seis = findViewById<Button>(R.id.btn6);
        val cinco = findViewById<Button>(R.id.btn5);
        val siete = findViewById<Button>(R.id.btn7);
        val ocho = findViewById<Button>(R.id.btn8);
        val nueve = findViewById<Button>(R.id.btn9);
        val asterisco = findViewById<Button>(R.id.btnAsterisco);
        val menos = findViewById<Button>(R.id.btnMenos);
        val mas = findViewById<Button>(R.id.btnMas);
        val dividido = findViewById<Button>(R.id.btnDividido);
        val delete = findViewById<Button>(R.id.btnDelete);
        val supr = findViewById<Button>(R.id.btnSupr);
        val resultado = findViewById<Button>(R.id.btnIgual);
        val editView = findViewById<EditText>(R.id.editText);
        val textView = findViewById<TextView>(R.id.textView);

        val operaciones = Operaciones();

        var num1 = 0.0;
        var num2 = 0.0;
        var acumulado = 0.0;
        var operacionSigno = "";



        punto.setOnClickListener {
            editView.append(".");
        }
        cero.setOnClickListener {
            editView.append("0");
        }

        uno.setOnClickListener {
            editView.append("1");
        }

        dos.setOnClickListener {
            editView.append("2");
        }

        tres.setOnClickListener {
            editView.append("3");
        }

        cuatro.setOnClickListener {
            editView.append("4");
        }

        cinco.setOnClickListener {
            editView.append("5");
        }

        seis.setOnClickListener {
            editView.append("6");
        }

        siete.setOnClickListener {
            editView.append("7");
        }

        ocho.setOnClickListener {
            editView.append("8");
        }

        nueve.setOnClickListener {
            editView.append("9");
        }

        asterisco.setOnClickListener {
            num1 =editView.text.toString().toDouble();
            operacionSigno = "*";
            textView.text = "${editView.text.toString()}*";
            editView.text.clear();
        }

        menos.setOnClickListener {
            num1 =editView.text.toString().toDouble();
            operacionSigno = "-";
            textView.text = "${editView.text.toString()}-";
            editView.text.clear();
        }
        mas.setOnClickListener {
            num1 =editView.text.toString().toDouble();
            operacionSigno = "+";
            textView.text = "${editView.text.toString()}+";
            editView.text.clear();
        }
        dividido.setOnClickListener {
            num1 =editView.text.toString().toDouble();
            operacionSigno = "/";
            textView.text = "${editView.text.toString()}/";
            editView.text.clear();
        }
        supr.setOnClickListener {
            editView.text.clear();
            textView.text = "";
        }
        delete.setOnClickListener {
            editView.text.clear();
            }
        resultado.setOnClickListener {
            num2 = editView.text.toString().toDouble();
            editView.text.clear();
            if(operacionSigno == "*"){
                editView.text.clear();
                editView.append("${operaciones.multiplicar(num1, num2)}");
                textView.text = "${operaciones.multiplicar(num1, num2)}";
                num1 = operaciones.multiplicar(num1, num2);
            }else if(operacionSigno == "+") {
                editView.text.clear();
                editView.append("${operaciones.sumar(num1, num2)}");
                textView.text = "${operaciones.sumar(num1, num2)}";
                num1 = operaciones.sumar(num1, num2);
            }else if(operacionSigno == "-") {
                editView.text.clear();
                editView.append("${operaciones.restar(num1, num2)}");
                textView.text = "${operaciones.restar(num1, num2)}";
                num1 = operaciones.restar(num1, num2);
            }else{
                editView.text.clear();
                editView.append("${operaciones.dividir(num1, num2)}");
                textView.text = "${operaciones.dividir(num1, num2)}";
                num1 = operaciones.dividir(num1, num2);
            }
        }
    }

}