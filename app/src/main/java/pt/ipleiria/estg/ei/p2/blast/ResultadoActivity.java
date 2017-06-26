package pt.ipleiria.estg.ei.p2.blast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private static final String MENSAGEM = "pt.ipleiria.estg.ei.p2.blast.abburbano.MENSAGEM";
    private TextView txtMensagem;
    private TextView txtBooster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultado);

        txtMensagem = (TextView) findViewById(R.id.txtMensagem);
        txtBooster = (TextView) findViewById(R.id.txtBooster);

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(MENSAGEM);
        txtMensagem.setText(mensagem);


        Intent intent2 = getIntent();
        int boost = intent2.getIntExtra("countbooster", 0);
        txtBooster.setText("Rebentou " + boost + " Bonus!");
    }

    public void onClickNao(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onClickSim(View view) {
        setResult(RESULT_OK);
        finish();
    }
    public static Intent createIntent(Context context) {
        return new Intent(context, ResultadoActivity.class);
    }

    public static Intent createIntent(Context context, String mensagem) {
        return new Intent(context, ResultadoActivity.class).putExtra(MENSAGEM, mensagem);
    }



}
