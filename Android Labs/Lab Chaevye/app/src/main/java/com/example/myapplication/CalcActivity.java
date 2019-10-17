package com.example.myapplication;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat; // Для форматирования денежных сумм

public class CalcActivity extends AppCompatActivity {
    // Форматировщики денежных сумм и процентов
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();

    private double amount = 0.0; // Сумма счёта
    private double percent = 0.0; // Процент чаевых по умолчанию.
    private EditText et_amount; // Поле для ввода суммы счёта
    private SeekBar sb_percent; // Ползунок для процентов
    private TextView tv_percent; // Поле для значения процента
    private TextView tv_tip; // Поле для суммы чаевых
    private TextView tv_total; // Поле для итоговой суммы

    // Создание объекта калькулятор чаевых:
    private Calc tipCalc = new Calc();

    // Вызывается метод onCreate при создании активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_amount = findViewById(R.id.et_amount);
        sb_percent = findViewById(R.id.sb_percent);
        tv_percent = findViewById(R.id.tv_percent);
        tv_tip = findViewById(R.id.tv_tip);
        tv_total = findViewById(R.id.tv_total);

        tv_tip.setText(currencyFormat.format(0)); // Заполнить 0
        tv_total.setText(currencyFormat.format(0)); // Заполнить 0

        et_amount.addTextChangedListener(amountTextWatcher);
        sb_percent.setOnSeekBarChangeListener(sbListener);
    }
    // Интерфейс слушателя изменений текста в EditText
    private final TextWatcher amountTextWatcher = new TextWatcher() {
        // Вызывается при изменении пользователем величины счета
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                amount = Double.parseDouble(s.toString());
            // Обновление полей с чаевыми и общей суммой в формате денежной величины
            tv_tip.setText(currencyFormat.format(tipCalc.calculateTip(amount,percent)));
            tv_total.setText(currencyFormat.format(tipCalc.calculateTotal(amount, percent)));
        }
        @Override
        public void afterTextChanged(Editable s) { }
        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
        };

    // Интерфейс слушателя изменений состояния SeekBar
    private final OnSeekBarChangeListener sbListener = new OnSeekBarChangeListener() {
        // Обновление процента чаевых и итоговой суммы
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            percent = progress / 100.0; // Назначение процента чаевых
            // Вычисление чаевых и общей суммы. Вывод их на экран.
            tv_percent.setText(percentFormat.format(percent));
            tv_tip.setText(currencyFormat.format(tipCalc.calculateTip(amount,percent)));
            tv_total.setText(currencyFormat.format(tipCalc.calculateTotal(amount, percent)));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    };
}
