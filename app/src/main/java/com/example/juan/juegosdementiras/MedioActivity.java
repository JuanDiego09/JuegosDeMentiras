package com.example.juan.juegosdementiras;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.juegosdementiras.entidades.User;
import com.example.juan.juegosdementiras.utilidades.Conexion;
import com.example.juan.juegosdementiras.utilidades.Utilidades;

import java.util.Random;

public class MedioActivity extends AppCompatActivity {


    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;
    TextView player1, player2, puntaje2, puntaje1;
    ImageView imagenActuan, imagenAnterior;
    Drawable parejas[] = new Drawable[12], defecto;
    int onclick;
    int asignados = 0, asignados1, asignados2, asignados3, asignados4, asignados5, asignados6;
    int n = 0, num, puntajeG1, puntajeG2;
    int cantidadParejas = 1;
    CountDownTimer timer;
    Chronometer chronometer;
    Conexion conn;
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medio);
        conn = new Conexion(this, "puntaje", null, 1);

        defecto = getResources().getDrawable(R.mipmap.pregunta);
        chronometer = findViewById(R.id.chronometer);
        btn1 = findViewById(R.id.btn1m);
        btn2 = findViewById(R.id.btn2m);
        btn3 = findViewById(R.id.btn3m);
        btn4 = findViewById(R.id.btn4m);
        btn5 = findViewById(R.id.btn5m);
        btn6 = findViewById(R.id.btn6m);
        btn7 = findViewById(R.id.btn7m);
        btn8 = findViewById(R.id.btn8m);
        btn9 = findViewById(R.id.btn9m);
        btn10 = findViewById(R.id.btn10m);
        btn11 = findViewById(R.id.btn11m);
        btn12 = findViewById(R.id.btn12m);
        player1 = findViewById(R.id.txtplayer1);
        player2 = findViewById(R.id.txtplayer2);
        puntaje1 = findViewById(R.id.txtpuntaje1);
        puntaje2 = findViewById(R.id.txtpuntaje2);
        player1.setText("" + User.player1);
        player2.setText("" + User.player2);
        chronometer.start();

        numeroJugador();
        generarParejas();
        colores();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn1.setImageDrawable(parejas[0]);
                    imagenAnterior = btn1;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn1.setImageDrawable(parejas[0]);
                    imagenActuan = btn1;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn2.setImageDrawable(parejas[1]);
                    imagenAnterior = btn2;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn2.setImageDrawable(parejas[1]);
                    imagenActuan = btn2;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn3.setImageDrawable(parejas[2]);
                    imagenAnterior = btn3;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn3.setImageDrawable(parejas[2]);
                    imagenActuan = btn3;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn4.setImageDrawable(parejas[3]);
                    imagenAnterior = btn4;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn4.setImageDrawable(parejas[3]);
                    imagenActuan = btn4;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn5.setImageDrawable(parejas[4]);
                    imagenAnterior = btn5;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn5.setImageDrawable(parejas[4]);
                    imagenActuan = btn5;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn6.setImageDrawable(parejas[5]);
                    imagenAnterior = btn6;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn6.setImageDrawable(parejas[5]);
                    imagenActuan = btn6;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn7.setImageDrawable(parejas[6]);
                    imagenAnterior = btn7;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn7.setImageDrawable(parejas[6]);
                    imagenActuan = btn7;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn8.setImageDrawable(parejas[7]);
                    imagenAnterior = btn8;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn8.setImageDrawable(parejas[7]);
                    imagenActuan = btn8;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn9.setImageDrawable(parejas[8]);
                    imagenAnterior = btn9;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn9.setImageDrawable(parejas[8]);
                    imagenActuan = btn9;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn10.setImageDrawable(parejas[9]);
                    imagenAnterior = btn10;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn10.setImageDrawable(parejas[9]);
                    imagenActuan = btn10;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn11.setImageDrawable(parejas[10]);
                    imagenAnterior = btn11;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn11.setImageDrawable(parejas[10]);
                    imagenActuan = btn11;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclick == 0) {
                    btn12.setImageDrawable(parejas[11]);
                    imagenAnterior = btn12;
                    imagenAnterior.setEnabled(false);
                    onclick = 1;
                } else if (onclick == 1) {
                    btn12.setImageDrawable(parejas[11]);
                    imagenActuan = btn12;
                    imagenActuan.setEnabled(false);
                    onclick = 2;
                    tiempo();
                    if (cantidadParejas == 6) {
                        termina();
                    }
                }
            }
        });


    }

    private void colores() {
        if (User.puntajej == 1) {
            player1.setTextColor(Color.parseColor("#000000"));
            puntaje1.setTextColor(Color.parseColor("#000000"));
            player2.setTextColor(Color.parseColor("#FF676A7E"));
            puntaje2.setTextColor(Color.parseColor("#FF676A7E"));
        } else {
            player2.setTextColor(Color.parseColor("#000000"));
            puntaje2.setTextColor(Color.parseColor("#000000"));
            player1.setTextColor(Color.parseColor("#FF676A7E"));
            puntaje1.setTextColor(Color.parseColor("#FF676A7E"));
        }
    }

    private void numeroJugador() {
        num = (int) (Math.floor(Math.random() * 2) + 1);
        User.puntajej = num;
    }

    private void tiempo() {
        timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if (!imagenActuan.getDrawable().getConstantState().equals(imagenAnterior.getDrawable().getConstantState())) {
                    imagenActuan.setImageDrawable(defecto);
                    imagenAnterior.setImageDrawable(defecto);
                    imagenAnterior.setEnabled(true);
                    imagenActuan.setEnabled(true);
                    if (User.puntajej == 1) {
                        User.puntajej = 2;
                        User.puntaje1 = User.puntaje1 - 2;
                    } else if (User.puntajej == 2) {
                        User.puntajej = 1;
                        User.puntaje2 = User.puntaje2 - 2;
                    }
                    colores();
                } else {
                    cantidadParejas++;
                    imagenActuan.setVisibility(View.INVISIBLE);
                    imagenAnterior.setVisibility(View.INVISIBLE);
                    if (User.puntajej == 1) {
                        User.puntaje1 = User.puntaje1 + 100;
                    } else if (User.puntajej == 2) {
                        User.puntaje2 = User.puntaje2 + 100;
                    }
                }
                puntaje1.setText("Puntaje " + User.puntaje1);
                puntaje2.setText("Puntaje " + User.puntaje2);
                onclick = 0;
                timer.cancel();
            }
        };
        timer.start();
    }
    private void termina() {
        chronometer.stop();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("FINALIZA");
        String mensaje = "";
        builder.setMessage("Tiempo de juego " + chronometer.getContentDescription());
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNeutralButton("Publicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();

        registrar();
    }

    private void registrar() {
        bd = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.NOMBRE_USER, User.player1);
        values.put(Utilidades.PUNTAJE, User.puntaje1);
        values.put(Utilidades.NIVEL, "medio");
        values.put(Utilidades.TIEMPO, (String) chronometer.getContentDescription());
        values.put(Utilidades.TIPO, User.tipo);

        bd.insert(Utilidades.TABLA_PUNTAJE, Utilidades.PUNTAJE, values);

        values.put(Utilidades.NOMBRE_USER, User.player2);
        values.put(Utilidades.PUNTAJE, User.puntaje2);
        values.put(Utilidades.NIVEL, "medio");
        values.put(Utilidades.TIEMPO, (String) chronometer.getContentDescription());
        values.put(Utilidades.TIPO, User.tipo);

        bd.insert(Utilidades.TABLA_PUNTAJE, Utilidades.PUNTAJE, values);
    }


    private void generarParejas() {
        while (asignados < 12) {
            n = new Random().nextInt(12);
            switch (n + 1) {
                case 1:
                    while (asignados1 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img1);
                        asignados++;
                        asignados1++;
                    }
                    break;
                case 2:
                    while (asignados2 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img2);
                        asignados++;
                        asignados2++;
                    }
                    break;
                case 3:
                    while (asignados3 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img3);
                        asignados++;
                        asignados3++;
                    }
                    break;
                case 4:
                    while (asignados4 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img4);
                        asignados++;
                        asignados4++;
                    }
                    break;
                case 5:
                    while (asignados5 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img5);
                        asignados++;
                        asignados5++;
                    }
                    break;
                case 6:
                    while (asignados6< 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img6);
                        asignados++;
                        asignados6++;
                    }
                    break;
            }
        }
    }
}
