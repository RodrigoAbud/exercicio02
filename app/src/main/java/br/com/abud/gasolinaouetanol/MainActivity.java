package br.com.abud.gasolinaouetanol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    private TextView valorEtanolTextView;
    private TextView valorGasolinaTextView;
    private TextView resultadoTextView;
    private ImageView imageResult;
    private double valorEtanol = 0.0;
    private double valorGasolina = 0.0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorEtanolTextView = findViewById(R.id.valorEtanolTextView);
        valorGasolinaTextView = findViewById(R.id.valorGasolinaTextView);
        resultadoTextView = findViewById(R.id.resultTextView);
        imageResult = findViewById(R.id.imageResult);
        SeekBar gasolinaSeekbar = findViewById(R.id.seekBarGasolina);
        gasolinaSeekbar.setOnSeekBarChangeListener(onSeekBarChangeListenerGasolina);
        SeekBar etanolSeekbar = findViewById(R.id.seekBarEtanol);
        etanolSeekbar.setOnSeekBarChangeListener(onSeekBarChangeListenerEtanol);

        valorEtanolTextView.addTextChangedListener(textWatcher);
        valorGasolinaTextView.addTextChangedListener(textWatcher);


    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            double resultado = valorEtanol / valorGasolina;

            if (resultado >= 0.7) {
                resultadoTextView.setText(getResources().getString(R.string.gasolina));
                imageResult.setImageResource(R.drawable.gasolina);

            }else {
                resultadoTextView.setText(getResources().getString(R.string.etanol));
                imageResult.setImageResource(R.drawable.etanol);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerGasolina =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    valorGasolina = progress / 100D;
                    double valorGasolinaFinal = valorGasolina;
                    valorGasolinaTextView.setText(currencyFormat.format(valorGasolinaFinal));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
    };

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerEtanol =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    valorEtanol = progress / 100D;
                    double valorEtanolFinal = valorEtanol;
                    valorEtanolTextView.setText(currencyFormat.format(valorEtanolFinal));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
    };



}
