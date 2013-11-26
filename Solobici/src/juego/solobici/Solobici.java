package juego.solobici;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Solobici extends Activity {

	private Button bAcercaDe;
	private Button bJuego;
	private Button bPreferencias;
	private Button bSalir;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Bot�n y escuchador para la pantalla "Juego"
        //Al hacer click en este bot�n llamamos al m�todo lanzarJuego()
        bJuego = (Button) findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new OnClickListener(){
        	public void onClick(View view) {
        		lanzarJuego();
        	}
        });
        
        //Bot�n y escuchador para la pantalla de Preferencias
        //Al hacer click en este bot�n llamamos al m�todo lanzarPreferencias()
        bPreferencias = (Button) findViewById(R.id.Boton02);
        bPreferencias.setOnClickListener(new OnClickListener(){
        	public void onClick(View view) {
        		lanzarPreferencias();
        	}
        });
        
        //Bot�n y escuchador para la pantalla "Acerca de"
        //Al hacer click en este bot�n llamamos al m�todo lanzarAcercaDe()
        bAcercaDe = (Button) findViewById(R.id.Boton03);
        bAcercaDe.setOnClickListener(new OnClickListener(){
        	public void onClick(View view) {
        		lanzarAcercaDe();
        	}
        });

        //Bot�n y escuchador para la pantalla "Salir"
        //Al hacer click en este bot�n llamamos al m�todo lanzarSalir()
        bSalir = (Button) findViewById(R.id.Boton04);
        bSalir.setOnClickListener(new OnClickListener(){
        	public void onClick(View view) {
        		lanzarSalir();
        	}
        });

    }

    //M�todo que activa la pantalla Juego
    public void lanzarJuego(){
    	Intent i = new Intent(this, Juego.class);
    	startActivity(i);
    }

    //M�todo que activa la pantalla AcercaDe
    public void lanzarAcercaDe(){
    	Intent i = new Intent(this, AcercaDe.class);
    	startActivity(i);
    }
    
    //M�todo que activa la pantalla Configuraci�n de Preferencias
    public void lanzarPreferencias(){
    	Intent i = new Intent(this, Preferencias.class);
    	startActivity(i);
    }

    //M�todo que muestra el valor de algunas preferencias
    public void lanzarSalir(){
    	mostrarPreferencias();
    	//finish();
    }

    public void mostrarPreferencias() {
    	SharedPreferences pref = getSharedPreferences("juego.solobici.solobici_preferences", MODE_PRIVATE);
    	String s = "M�sica: " + pref.getBoolean("musica", true) +
    				", Gr�ficos: " + pref.getString("preguntas", "?");
    	Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_principal, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.acercaDe:
    		lanzarAcercaDe();
    		break;
    	
    	case R.id.configuracion:
    		lanzarPreferencias();
    		break;
    	
    	}
    	return false;
    }    
}
