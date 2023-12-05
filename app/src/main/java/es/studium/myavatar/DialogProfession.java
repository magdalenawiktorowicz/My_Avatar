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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DialogProfession extends DialogFragment {
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment fragmentFinal;
    Spinner spinnerProfession;
    String profession = "";
    public DialogProfession() {}

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle data = getArguments();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.fragment_dialog_profession, null);
        spinnerProfession = myView.findViewById(R.id.spinnerProfession);
        builder.setView(myView)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (spinnerProfession.getSelectedItemPosition() == 0) {
                            Toast toast = Toast.makeText(getActivity(), R.string.missingChoice, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 100);
                            toast.show();
                        } else {
                            int pos = spinnerProfession.getSelectedItemPosition();
                            String[] strArray = getResources().getStringArray(R.array.listaProfession);
                            profession = strArray[pos].toString();
                            data.putString("profession", profession);
                            fm = getFragmentManager();
                            fragmentFinal = new FragmentFinal();
                            fragmentFinal.setArguments(data);
                            ft = fm.beginTransaction();
                            ft.replace(R.id.fragmentContainerView, fragmentFinal, "fragmentFinal")
                                    .addToBackStack(null)
                                    .commit();
                            dialog.dismiss();
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
