package unal.todosalau.energysavvybogotsenergeticus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etHoursOfUse;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHoursOfUse = findViewById(R.id.etHoursOfUse);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateEnergyConsumption();
            }
        });
    }

    private void calculateEnergyConsumption() {
        String hoursOfUseStr = etHoursOfUse.getText().toString();
        if (!hoursOfUseStr.isEmpty()) {
            int hoursOfUse = Integer.parseInt(hoursOfUseStr);

            Electrodomestico electrodomestico = new Electrodomestico("Laptop", 50, 90);
            int consumption = CalculadoraConsumo.calcularConsumoDiario(electrodomestico, hoursOfUse);

            tvResult.setText("Consumo diario: " + consumption + " Wh");
        } else {
            tvResult.setText("Ingrese las horas de uso");
        }
    }
}