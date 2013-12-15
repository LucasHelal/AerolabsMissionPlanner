package com.droidplanner.drone;

import java.util.List;

import com.droidplanner.drone.variables.mission.WaypointEvent_Type;
import com.droidplanner.parameters.Parameter;

public class DroneInterfaces {

	public enum DroneEventsType {
		ORIENTATION, SPEED, BATTERY, GPS, GUIDEDPOINT, NAVIGATION, ATTIUTDE, RADIO, RC_IN, RC_OUT, ARMING, FAILSAFE, MODE, STATE, MISSION;
	}

	public interface OnDroneListner {
		public void onDroneEvent(DroneEventsType droneEvents);
		
		public List<DroneEventsType> getSupportedEvents();
	}
	
	public interface OnParameterManagerListner {
		public void onBeginReceivingParameters();

		public void onParameterReceived(Parameter parameter, int index,
				int count);

		public void onEndReceivingParameters(List<Parameter> parameter);
	}

	public interface OnWaypointManagerListener {
		public void onBeginWaypointEvent(WaypointEvent_Type wpEvent);

		public void onWaypointEvent(WaypointEvent_Type wpEvent, int index,
				int count);

		public void onEndWaypointEvent(WaypointEvent_Type wpEvent);

	}
}