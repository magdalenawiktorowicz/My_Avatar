package es.studium.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;

public class DialogGender extends DialogFragment {
    String gender = "";
    RadioGroup radioGroup;
    RadioButton radioBtnFemale;
    RadioButton radioBtnMale;
    DialogFragment ds;

   public DialogGender() {}

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle data = getArguments();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.fragment_dialog_gender, null);
        radioGroup = myView.findViewById(R.id.radioGroup);
        radioBtnFemale = myView.findViewById(R.id.radioBtnFemale);
        radioBtnMale = myView.findViewById(R.id.radioBtnMale);
        builder.setView(myView)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (radioBtnFemale.isChecked()) {
                            DialogGender.this.gender = "Female";
                            data.putString("gender", gender);
                            ds = new DialogSpecies();
                            ds.setArguments(data);
                            ds.setCancelable(false);
                            ds.show(getParentFragmentManager(), "Dialog Species");
                        } else if (radioBtnMale.isChecked()) {
                            DialogGender.this.gender = "Male";
                            data.putString("gender", gender);
                            ds = new DialogSpecies();
                            ds.setArguments(data);
                            ds.setCancelable(false);
                            ds.show(getParentFragmentManager(), "Dialog Species");
                        } else {
                            Toast toast = Toast.makeText(getActivity(), R.string.missingRadio, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 100);
                            toast.show();
                        }
                        dialog.dismiss();
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
