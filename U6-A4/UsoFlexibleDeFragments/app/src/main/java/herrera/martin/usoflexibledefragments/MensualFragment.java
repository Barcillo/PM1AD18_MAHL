package herrera.martin.usoflexibledefragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MensualFragment extends Fragment {
    OnSemanaSeleccionadaListener activityObserver;
    private Button btnSem1,btnSem2,btnSem3,btnSem4;

    public MensualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mensual, container, false);
        btnSem1=(Button) view.findViewById(R.id.btnsemana1_card);
        btnSem2=(Button) view.findViewById(R.id.btnsemana2_card);
        btnSem3=(Button)view.findViewById(R.id.btnsemana3_card);
        btnSem4=(Button) view.findViewById(R.id.btnsemana4_card);

        btnSem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityObserver.semanaSeleccionada("Sem1");
            }
        });
        btnSem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityObserver.semanaSeleccionada("Sem2");
            }
        });
        btnSem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityObserver.semanaSeleccionada("Sem3");
            }
        });
        btnSem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityObserver.semanaSeleccionada("Sem4");
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityObserver=(OnSemanaSeleccionadaListener)activity;

    }

    public interface OnSemanaSeleccionadaListener{
        public void semanaSeleccionada(String nombreSemana);
    }
}
