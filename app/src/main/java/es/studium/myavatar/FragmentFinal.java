package es.studium.myavatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FragmentFinal extends Fragment {
    int vida = (int) (Math.random() * 100);
    int magia = (int) (Math.random() * 10);
    int fuerza = (int) (Math.random() * 20);
    int velocidad = (int) (Math.random() * 5);

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    String name, gender, species, profession;
    TextView txtViewName;
    ImageView avatar;
    ProgressBar pgVida, pgMagia, pgFuerza, pgVelocidad;
    EditText editViewVida, editViewMagia, editViewFuerza, editViewVelocidad;

    public FragmentFinal() {
        // Required empty public constructor
    }

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
        View view = inflater.inflate(R.layout.fragment_final, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();
        Bundle data = getArguments();
        if (data != null) {
            // obtener los datos del Bundle
            name = data.getString("name");
            gender = data.getString("gender").toLowerCase();
            species = data.getString("species").toLowerCase();
            profession = data.getString("profession").toLowerCase();
        }

        txtViewName = view.findViewById(R.id.textViewInitialName);
        // establecer el nombre del usuario
        txtViewName.setText(name);

        avatar = view.findViewById(R.id.initialImage);
        // establecer el nombre del fichero jpg según lo que ha seleccionado el usuario
        String avatarName = species + "_" + gender + "_" + profession;
        // obtener el id del recurso (fichero jpg)
        int idAvatarRes = context.getResources().getIdentifier(avatarName, "drawable", context.getPackageName());
        // si el recurso existe
        if (idAvatarRes != 0) {
            // obtener el objeto Drawable
            Drawable drawable = ContextCompat.getDrawable(context, idAvatarRes);
            // establecer la imagen en la vista con el recurso Drawable
            avatar.setImageDrawable(drawable);
        }

        // asociar los progress bars de la vista con los objetos en Java
        pgVida = view.findViewById(R.id.progressBarVida);
        pgMagia = view.findViewById(R.id.progressBarMagia);
        pgFuerza = view.findViewById(R.id.progressBarFuerza);
        pgVelocidad = view.findViewById(R.id.progressBarVelocidad);

        // asociar los TextViews de la vista con los objetos en Java
        editViewVida = view.findViewById(R.id.textViewVidaFinal);
        editViewMagia = view.findViewById(R.id.textViewMagiaFinal);
        editViewFuerza = view.findViewById(R.id.textViewFuerzaFinal);
        editViewVelocidad = view.findViewById(R.id.textViewVelocidadFinal);

        // establecer los poderes
        pgVida.setProgress(vida);
        editViewVida.setText(vida + "/100");
        pgMagia.setProgress(magia);
        editViewMagia.setText(magia + "/10");
        pgFuerza.setProgress(fuerza);
        editViewFuerza.setText(fuerza + "/20");
        pgVelocidad.setProgress(velocidad);
        editViewVelocidad.setText(velocidad + "/5");
    }
}