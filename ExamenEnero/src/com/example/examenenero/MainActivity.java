package com.example.examenenero;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Destino[] destinos = new Destino[]{
			new Destino("Zona A", "Asia", "30"),
			new Destino("Zona B", "Oceania", "30"),
			new Destino("Zona C", "América", "20"),
			new Destino("Zona D", "Europa", "20"),
			new Destino("Zona D", "Estación lunar", "500000")
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
		super(b, R.layout.activity_spinner, destinos);
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
		
		final Spinner cmbOpciones = (Spinner)findViewById(R.id.CmbOpciones);
		
		AdaptadorDestino adapter = new AdaptadorDestino(this);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		cmbOpciones.setAdapter(adapter);
		
		cmbOpciones.setOnItemSelectedListener(
				new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent,
							android.view.View v, int position, long id) {
						zona = destinos[position].getZona();
		                 continente = destinos[position].getContinente();
		                 precio = Integer.parseInt(destinos[position].getPrecio());	
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
