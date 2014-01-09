package com.example.examenenero;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Destino[] destinos = new Destino[]{
			new Destino("Zona A", "Asia", "30"),
			new Destino("Zona B", "Oceania", "30"),
			new Destino("Zona C", "América", "20"),
			new Destino("Zona D", "África", "20"),
			new Destino("Zona E", "Europa", "10")
	};
	
	RadioButton rnormal, rurgente;
	static double tarifa;
	int peso = 0;
	int precio;
	String zona, continente, resultado, clase, decoracion;
	CheckBox tarjeta, regalo;
	
class AdaptadorDestino extends ArrayAdapter<Destino>{
	
	Activity a;
	AdaptadorDestino(Activity b){
		super(b, R.layout.activity_spinner);
		this.a = b;
	}
	
	public View getDropDownView ( int position, View convertView, ViewGroup parent){
        return getView (position, convertView, parent);
}

public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = a.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_spinner, null);
            
            final TextView lblZona = (TextView)item.findViewById(R.id.LblZona);
            lblZona.setText(destinos[position].getZona());
            
            final TextView lblContinente = (TextView)item.findViewById(R.id.LblContinente);
            lblContinente.setText(destinos[position].getContinente());
            
            final TextView lblPrecio = (TextView)item.findViewById(R.id.LblPrecio);
            lblPrecio.setText(destinos[position].getPrecio());

            return(item);
    }
	
	
}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
