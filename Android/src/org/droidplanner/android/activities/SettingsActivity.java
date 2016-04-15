package org.droidplanner.android.activities;

import android.app.FragmentManager;
import android.os.Bundle;

import org.droidplanner.android.DroidPlannerApp;
import org.droidplanner.android.R;
import org.droidplanner.android.fragments.DevModeSettingsFragment;
import org.droidplanner.android.fragments.SettingsFragment;

/**
 * This activity holds the SettingsFragment.
 */
public class SettingsActivity extends DrawerNavigationUI implements DroidPlannerApp.DevModeListener {

	private FragmentManager fm;
	private SettingsFragment settingsFragment;
	private DevModeSettingsFragment devModeSettingsFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		fm = getFragmentManager();
		devModeSettingsFragment = new DevModeSettingsFragment();
		settingsFragment = new SettingsFragment();

		if (dpApp.isDevModeOn()) {
			fm.beginTransaction().add(R.id.fragment_settings_layout, devModeSettingsFragment).commit();
		} else {
			fm.beginTransaction().add(R.id.fragment_settings_layout, settingsFragment).commit();
		}

		dpApp.registerDevModeListener(this);
	}

    @Override
    protected int getToolbarId() {
        return R.id.actionbar_toolbar;
    }

    @Override
	protected int getNavigationDrawerMenuItemId() {
		return R.id.navigation_settings;
	}

	@Override
	public void onApiConnected() {
        super.onApiConnected();
	}

	@Override
	public void onDevModeStart() {
		super.onDevModeStart();
		fm.beginTransaction().replace(R.id.fragment_settings_layout, devModeSettingsFragment).commit();
	}

	@Override
	public void onDevModeStop() {
		super.onDevModeStop();
		fm.beginTransaction().replace(R.id.fragment_settings_layout, settingsFragment).commit();
	}
}
