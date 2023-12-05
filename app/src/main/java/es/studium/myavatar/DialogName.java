package es.studium.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;

public class DialogName extends DialogFragment {
    DialogFragment dg;
    EditText nombre;
    String name;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // crear el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // iniciar el inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // iniciar el view inflando el layout
        View myView = inflater.inflate(R.layout.fragment_dialog_name, null);
        nombre = myView.findViewById(R.id.editTextNombre);
        builder.setView(myView)
                // crear una clase anónima para sobreescribir el método onClick
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!(nombre.getText().toString().isEmpty())) {
                            name = nombre.getText().toString();
                            // crear un objeto Bundle para trasferir los datos
                            Bundle data = new Bundle();
                            // guardar el nombre en el bundle
                            data.putString("name", name);
                            // iniciar el siguiente diálogo
                            dg = new DialogGender();
                            // trasferir los datos al DialogGender
                            dg.setArguments(data);
                            dg.setCancelable(false);
                            dg.show(getParentFragmentManager(), "Dialog Gender");
                            dialog.dismiss();
                        } else {
                           Toast toast = Toast.makeText(getActivity(), R.string.missingInput, Toast.LENGTH_SHORT);
                           toast.setGravity(Gravity.CENTER, 0, 100);
                           toast.show();
                        }
                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.dialogColor);

        return alertDialog;
    }
}
