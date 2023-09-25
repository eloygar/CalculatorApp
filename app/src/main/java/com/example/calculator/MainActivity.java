package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private EditText entrada;
    private Button calcularPrimoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.solucion);
        entrada = findViewById(R.id.numero);
        calcularPrimoButton = findViewById(R.id.button);

        calcularPrimoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = entrada.getText().toString();
                int posicion = Integer.parseInt(input);
                int primo = obtenerPrimoEnPosicion(posicion);
                result.setText("El número primo en la posición " + posicion + " es: " + primo);

            }
        });
    }

    /// codigo de internet
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int obtenerPrimoEnPosicion(int posicion) {
        if (posicion <= 0) {
            throw new IllegalArgumentException("La posición debe ser mayor que cero");
        }

        int contador = 0;
        int numero = 2; // Empezamos desde el primer número primo
        while (true) {
            if (esPrimo(numero)) {
                contador++;
                if (contador == posicion) {
                    return numero;
                }
            }
            numero++;
        }
    }
}
