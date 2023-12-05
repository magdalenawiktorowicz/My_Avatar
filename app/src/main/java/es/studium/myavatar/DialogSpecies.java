package es.studium.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogSpecies extends DialogFragment {
    DialogFragment dp;
    Spinner spinnerSpecies;
    String species = "";

    public DialogSpecies() {}

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle data = getArguments();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.fragment_dialog_species, null);
        spinnerSpecies = myView.findViewById(R.id.spinnerSpecies);
        builder.setView(myView)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (spinnerSpecies.getSelectedItemPosition() == 0) {
                            Toast toast = Toast.makeText(getActivity(), R.string.missingChoice, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 100);
                            toast.show();
                        } else {
                            int pos = spinnerSpecies.getSelectedItemPosition();
                            String[] strArray = getResources().getStringArray(R.array.listaSpecies);
                            species = strArray[pos].toString();
                            data.putString("species", species);
                            dp = new DialogProfession();
                            dp.setArguments(data);
                            dp.setCancelable(false);
                            dp.show(getParentFragmentManager(), "Dialog Profession");
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
