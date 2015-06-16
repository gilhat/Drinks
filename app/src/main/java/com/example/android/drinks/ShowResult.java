package com.example.android.drinks;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ShowResult extends ActionBarActivity {


    /*private void displayWeight (String string){
        TextView quantityBeerTextView = (TextView) findViewById(R.id.display_weight);
        quantityBeerTextView.setText(string + "kg");}

       */
    String message = "null";
    String messageOne="123";
    String messageTwo="123";
    String messageThree="123";
    String one = "oooo";
    String two = "ooo";
    String three = "00";
    String four = "o";
    double result = 0;
    String promille = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.MESSAGEWEIGHT);
        display(message + "kg");
        messageOne = intent.getStringExtra(MainActivity.MESSAGEBEER);
        displayBeer(messageOne + "ml");
        messageTwo = intent.getStringExtra(MainActivity.MESSAGEWINE);
        displayWine(messageTwo + "ml");
        messageThree = intent.getStringExtra(MainActivity.MESSAGELIQUOR);
        displayLiquor(messageThree + "ml");


        messageOne = "0" + messageOne;
        messageTwo = "0" + messageTwo;
        messageThree = "0" + messageThree;
        message = "0" + message;
        System.out.println(messageOne + "huhu");
        int weight = Integer.parseInt(message.replaceAll("[\\D]", ""));
        System.out.println(messageOne);
        int beer= Integer.parseInt(messageOne.replaceAll("[\\D]", ""));
        int wine= Integer.parseInt(messageTwo.replaceAll("[\\D]", ""));
        int liquor= Integer.parseInt(messageThree.replaceAll("[\\D]", ""));





        result= (((0.05*beer)+(0.14*wine)+(0.40*liquor))*0.8)/(0.68*weight);

        NumberFormat df = new DecimalFormat("#.00");
        promille = df.format(result);

        //promille = Double.toString(result);
        displayPromille(promille+ " ‰");



        kommentar(result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void goBackToMain(View v){
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(), MainActivity.class));


    }
    private void display(String data){
        TextView newView = (TextView) findViewById(R.id.display_weight);
        newView.setText(data);
    }
    private void displayBeer(String data){
        TextView newView = (TextView) findViewById(R.id.display_beeer);
        newView.setText(data);
    }
    private void displayWine(String data){
        TextView newView = (TextView) findViewById(R.id.display_winne);
        newView.setText(data);
    }
    private void displayLiquor(String data){
        TextView newView = (TextView) findViewById(R.id.display_liquorr);
        newView.setText(data);
    }
    private void displayPromille(String data){
        TextView newView = (TextView) findViewById(R.id.display_promille);
        newView.setText(data);
    }


    private void kommentar(double data) {
        TextView newView = (TextView) findViewById(R.id.du_solltest);
        if (data < 0.5) {

            newView.setText("Du darfst noch Auto fahren");


        } else if (data >= 0.5 && data < 1.2) {

            newView.setText("Du hast schon einen kleinen sitzen und solltes kein Auto mehr fahren");


        } else if (data >= 0.5){

            newView.setText("Alter Säufer!!! geh mal langsam nach Hause!!!");


        }


    }

}
