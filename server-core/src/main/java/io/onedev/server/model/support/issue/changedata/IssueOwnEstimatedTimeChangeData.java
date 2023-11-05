package io.onedev.server.model.support.issue.changedata;

import io.onedev.server.model.Group;
import io.onedev.server.model.User;
import io.onedev.server.notification.ActivityDetail;
import io.onedev.server.util.DateUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IssueOwnEstimatedTimeChangeData extends IssueChangeData {

	private static final long serialVersionUID = 1L;

	private final int oldValue;
	
	private final int newValue;
	
	public IssueOwnEstimatedTimeChangeData(int oldValue, int newValue) {
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	@Override
	public String getActivity() {
		return "changed own estimated time";
	}

	@Override
	public Map<String, Collection<User>> getNewUsers() {
		return new HashMap<>();
	}

	@Override
	public Map<String, Group> getNewGroups() {
		return new HashMap<>();
	}

	@Override
	public boolean affectsListing() {
		return false;
	}

	@Override
	public boolean isMinor() {
		return true;
	}

	@Override
	public ActivityDetail getActivityDetail() {
		Map<String, String> oldFieldValues = new HashMap<>();
		oldFieldValues.put("Own Estimated Time", DateUtils.formatWorkingPeriod(oldValue));
		Map<String, String> newFieldValues = new HashMap<>();
		newFieldValues.put("Own Estimated Time", DateUtils.formatWorkingPeriod(newValue));
		return ActivityDetail.compare(oldFieldValues, newFieldValues, true);
	}
	
}
