package com.example.intent_implicito;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



public class MainActivity3 extends AppCompatActivity {
    private EditText textphone;
    private EditText url;
    private ImageButton telefono;
    private ImageButton botonojo;
    private ImageButton camara;
    private final int phone_call_code = 100;
    private final int  PICTURE_FROM_CAMARA =50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // activar flecha para ir atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // en el manifest de android se indica cual sera a donde llevara la flecha

        textphone = (EditText) findViewById(R.id.editTextPhone);
        url = (EditText) findViewById(R.id.editTextTextPersonName);
        telefono = (ImageButton) findViewById(R.id.imageButtontelefono);
        botonojo = (ImageButton) findViewById(R.id.imageButton2);
        camara = (ImageButton) findViewById(R.id.camara);



        /*BOTON DE LLAMADA*/
        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = textphone.getText().toString();
                if (numero != null) {
                    //COMPROBAR VERSION DE ANDROID QUE SE UTILIZA
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        /*Comprobar si ha acceptado o no los permisos*/
                        if (checkpermission(Manifest.permission.CALL_PHONE)){
                            //ha aceptado
                            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("Numero Telefono :"+numero));
                            startActivity(intent);
                        }else{
                            //no aceptado o es la 1 vez
                           if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){//Comprueba si no acepto o es la primera vez que va aceptar los permisos.
                               requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, phone_call_code); // esto lo que hace es preguntar al usuario si quiere aceptar o denegar los permisos
                           }else{
                               // si lo deniega -->
                               Toast.makeText(MainActivity3.this,"PORFAVOR ACEPTA LOS PERMISOS :(",Toast.LENGTH_SHORT).show(); // le salta un toast que le pide que si puede aceptar
                               Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS); /*ABRE LOS AJUSTE DE LA APP*/
                               i.addCategory(Intent.CATEGORY_DEFAULT);
                               i.setData(Uri.parse("package"+getPackageName())); /*VA A METER LOS CAMBIOS DENTRO DEL PAQUETE*/
                               i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); /*Crea una nueva tarea*/
                               i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);/*No Limpia  historial lo cual guarda los cambio al volver atras*/
                               i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);/* no Guarda en las actividades recientes*/
                               startActivity(i);
                           }
                        }

                    } else {
                        olderVersion(numero);
                    }
                }
            }

            private void olderVersion(String numero) {
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("TELEFONO: " + numero));
                if (checkpermission(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentCall);
                } else {
                    Toast.makeText(MainActivity3.this, "YOU DECLINED THE ACCESS", Toast.LENGTH_SHORT).show();
                }

            }


        });
        /*BOTON PARA LA DIRECCION WEB*/
        botonojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String direccion = url.getText().toString();
                if (direccion != null && !direccion.isEmpty()){
                    Intent intentweb = new Intent(Intent.ACTION_VIEW,Uri.parse("https://"+direccion)); /*Llamaos a una acion donde se va a ver una pagina donde le pasaremos con un uri el url*/
                    /*intentweb.setAction(Intent.ACTION_VIEW);
                    intentweb.setData(Uri.parse("https://"+direccion));*/ //Este codigo equivale a lo de arriba pero dividio en 2 partes donde se le pasa la accion y el dato
                    //Intent intentcontatos = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people")); /*Esto sirve para ver los contactos de tu lista*/
                   /* String email = "matthg7@outlook.com";
                    Intent intentEmail = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto"+email));PARA QUE SE HABRA CORREO PARA ENVIAR*/
                    //EMAIL COMPLETO -->
                    String email = "matthg7@outlook.com";
                    Intent intentEmailcompleto = new Intent(Intent.ACTION_VIEW,Uri.parse(email));
                    intentEmailcompleto.setType("plain/text"); /*Le indicamos que sera de formato correo*/
                    //intentEmailcompleto.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail"); /*Le pasamos la clase que se va abrir el gmail en concreto*/
                    intentEmailcompleto.putExtra(Intent.EXTRA_SUBJECT,"Mail`s title");/*TITULO DEL EMAIL    QUE PONDRA*/
                    intentEmailcompleto.putExtra(Intent.EXTRA_TEXT,"HOLA guapo te amo"); /*TEXTO QUE PONDRA EN EL EMAIL*/
                    intentEmailcompleto.putExtra(Intent.EXTRA_EMAIL,new String[]{"fernando@gmail.com","Paco@gmail.com"}); /*PONDRA EN EL EMAIL ESTOS CORREOS EXTRAS PARA ENVIAR*/
                    //Mejor que el usuario elija la app para el correo
                    startActivity(Intent.createChooser(intentEmailcompleto, "ELIGE LA APP QUE MAS TE GUSTE"));
                    //telefono 2 sin permisos requeridos
                    //Intent intentelefono = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:65612394"));
                    //startActivity(intentEmailcompleto);
                }
            }
        });
        /*BOTON PARA LA CAMARA que lo llama*/
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentcamara = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intentcamara,PICTURE_FROM_CAMARA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case PICTURE_FROM_CAMARA:
                    if (resultCode ==Activity.RESULT_OK ){
                        String result =  data.toUri(0);
                        Toast.makeText(this, "SALE ESTO: "+result, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "ERROR CON LA FOTO", Toast.LENGTH_SHORT).show();

                    }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { //Aqui sobreescribimos la pedida de permisos y con switch decimos que va hacer si llama al telefono por ejemplo
        //si es asi estamos en el caso de telefono
        switch (requestCode) {
            case phone_call_code:
                String permission  = permissions[0];
                int result = grantResults[0];
                if (permission.equals(Manifest.permission.CALL_PHONE)){ //Comprueba si el 1 permiso esta aceptado
                    //comprobar si ha sido acceptado o denegado el permiso
                    if (result == PackageManager.PERMISSION_GRANTED){  // recomprobacion de seguridad
                        // es que ha acceptado
                        String numeros = textphone.getText().toString();
                        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+numeros)); // se le pasa el numero que va a llamar
                        startActivity(intent); // inicia la actividad
                    }else{
                        //no acceptado
                        Toast.makeText(this, "DENEGADO", Toast.LENGTH_SHORT).show(); // salta un toast indicando que no ha acceptado
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    private boolean checkpermission(String Permission) {
        int result = this.checkCallingOrSelfPermission(Permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}