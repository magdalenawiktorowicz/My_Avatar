package es.studium.myavatar;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment implements View.OnClickListener {
    Button btnGenerar;
    DialogName dn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public Fragment1() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnGenerar = view.findViewById(R.id.btnGenerateAvatar);
        btnGenerar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnGenerar.getId()) {
            // iniciar el primer diálogo
            dn = new DialogName();
            dn.setCancelable(false);
            // mostrar el primer diálogo
            dn.show(getParentFragmentManager(), "Dialog Name");
        }
    }
}