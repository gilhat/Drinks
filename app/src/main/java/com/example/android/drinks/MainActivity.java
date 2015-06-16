package com.example.android.drinks;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    int quantityBeer=0;
    int quantityWine=0;
    int quantityLiquor=0;


    //public static final String EXTRA_MESSAGE="com.example.android.drinks.MESSAGE";
    public static final String MESSAGEWEIGHT = "com.example.android.MESSAGEWEIGHT";
    public static final String MESSAGEBEER = "com.example.android.MESSAGEBEER";
    public static final String MESSAGEWINE = "com.example.android.MESSAGEWINE";
    public static final String MESSAGELIQUOR = "com.example.android.MESSAGELIQUOR";


   /* public void sendMessage (View view){

        Intent intent = new Intent(this, ShowResult.class);
        EditText editText = (EditText) findViewById(R.id.weight);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }*/


    private void displayMessage(String message){
        TextView quantityBeerView = (TextView) findViewById(R.id.quantity_beer);
        quantityBeerView.setText(message);

    }

    private void display(int number){
        TextView quantityBeerTextView = (TextView) findViewById(R.id.quantity_beer);
        quantityBeerTextView.setText(number + "ml");


    }
    public void addBeer(View view){
        quantityBeer = quantityBeer + 50;
        display(quantityBeer);

    }
    public void decreaseBeer(View view){
        int number = quantityBeer;
        number = number - 50;
        if(number<=0){
            quantityBeer=0;}
        else {
            quantityBeer=number;
        }
        display(quantityBeer);
    }

    private void displayTwo(int number){
        TextView quantityBeerTextView = (TextView) findViewById(R.id.quantity_wine);
        quantityBeerTextView.setText(number + "ml");


    }
    public void addWine(View view){
        quantityWine = quantityWine + 20;
        displayTwo(quantityWine);

    }
    public void decreaseWine(View view){
        int number = quantityWine;
        number = number - 20;
        if(number<=0){
            quantityWine=0;}
        else {
            quantityWine=number;
        }
        displayTwo(quantityWine);
    }

    private void displayThree(int number){
        TextView quantityBeerTextView = (TextView) findViewById(R.id.quantity_liquor);
        quantityBeerTextView.setText(number+"ml");


    }
    public void addLiquor(View view){
        quantityLiquor = quantityLiquor + 10;
        displayThree(quantityLiquor);

    }
    public void decreaseLiquor(View view){
        int number = quantityLiquor;
        number = number - 10;
        if(number<=0){
            quantityLiquor=0;}
        else {
            quantityLiquor=number;
        }
        displayThree(quantityLiquor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void buttonClick(View v){
        //Button button=(Button) v;
        Intent intent = new Intent(getApplicationContext(), ShowResult.class);
        EditText editText = (EditText) findViewById(R.id.weight);
        TextView textViewOne = (TextView) findViewById(R.id.input_beer);
        TextView textViewTwo = (TextView) findViewById(R.id.input_wine);
        TextView textViewThree = (TextView) findViewById(R.id.input_liquor);

        String message = editText.getText().toString();
        intent.putExtra(MESSAGEWEIGHT, message);

        String messageOne = textViewOne.getText().toString();
        intent.putExtra(MESSAGEBEER, messageOne);

        String messageTwo = textViewTwo.getText().toString();
        intent.putExtra(MESSAGEWINE, messageTwo);

        String messageThree = textViewThree.getText().toString();
        intent.putExtra(MESSAGELIQUOR, messageThree);

        //intent.putExtra(MESSAGE, 1);
        startActivity(intent);


    }

}
