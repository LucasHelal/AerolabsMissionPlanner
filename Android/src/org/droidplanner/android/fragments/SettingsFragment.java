package org.droidplanner.android.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.droidplanner.android.DroidPlannerApp;
import org.droidplanner.android.R;

public class SettingsFragment extends Fragment {

    private DroidPlannerApp dpApp;
    private EditText password;
    private Button enterButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.fragment_dev_mode, container, false);

        password = (EditText) returnView.findViewById(R.id.dev_mode_password);
        enterButton = (Button) returnView.findViewById(R.id.button_enter_dev_mode);
        dpApp = (DroidPlannerApp) getActivity().getApplication();

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dpApp.tryStartDevMode(password.getText().toString());
            }
        });

        return returnView;
    }

}
