package com.example.lesson7_practice;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView androidPhone , iosPhone;
    RadioButton kaspi_radio , forte_radio;
    CheckBox present_Check , deliver_Check;
    Button send_btn;
    String way_of_pay , way_of_send , and_txt , ios_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidPhone = findViewById(R.id.andChooseTel);
        iosPhone = findViewById(R.id.ios_choose_tel);
        kaspi_radio = findViewById(R.id.rad_kaspi);
        forte_radio = findViewById(R.id.rad_forte);
        present_Check = findViewById(R.id.chbx_present);
        deliver_Check = findViewById(R.id.chbx_delivery);
        send_btn = findViewById(R.id.btn_send);
        registerForContextMenu(androidPhone);
        registerForContextMenu(iosPhone);
        send_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(kaspi_radio.isChecked()){
                    way_of_pay = "By Kaspi";
                }
                else if(forte_radio.isChecked()){
                    way_of_pay = "By Forte";
                }
                if(present_Check.isChecked()){
                    way_of_send = "It's a present";
                }
                if(deliver_Check.isChecked()){
                    way_of_send = "It's sent by delivery";
                }
                String result = "Android:" + androidPhone.getText()+ "\n"+
                        "iOS: " + iosPhone.getText()+"\n"+
                        "Way of pay: " + way_of_pay + "\n"+
                        "Way of send: " + way_of_send;
                Toast.makeText(MainActivity.this ,  result , Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu ,  View v ,  ContextMenu.ContextMenuInfo menuInfo) {
        if(v==androidPhone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu ,  menu);
        }
        else{
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu ,  menu);
        }
        super.onCreateContextMenu(menu ,  v ,  menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.phone_samsung:
                androidPhone.setText("Samsung");
                break;
            case R.id.phone_xiaomi:
                androidPhone.setText("Xiaomi");
                break;
            case R.id.phone_huawei:
                androidPhone.setText("Huawei");
                break;
            case R.id.phone_mi:
                androidPhone.setText("MI");
                break;
            case R.id.phone_8:
                iosPhone.setText("iPhone 8");
                break;
            case R.id.phone_10:
                iosPhone.setText("iPhone 10");
                break;
            case R.id.phone_11:
                iosPhone.setText("iPhone 11");
                break;
            case R.id.phone_12:
                iosPhone.setText("iPhone 12");
                break;
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(  R.menu.main , menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this , "Setting menu clicked" , Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this , "Exit menu clicked" , Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this , "Cut menu clicked" , Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this , "Save menu clicked" , Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}