package herrera.martin.usoflexibledefragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SemanalFragment extends Fragment {


    public SemanalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_semanal, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String datosPasados="";
        try{
            datosPasados= getArguments().getString("datos");
        }catch (Exception e){
            datosPasados="NO HAY DATOS";
        }

        TextView txtDatosMostrar=view.findViewById(R.id.txtDatosMostrar);
        txtDatosMostrar.setText(datosPasados);
    }
}
