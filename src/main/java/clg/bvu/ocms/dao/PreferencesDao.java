package clg.bvu.ocms.dao;

import clg.bvu.ocms.model.Preference;

public interface PreferencesDao {

	Preference getPreferences(Integer userId);

	int savePreferences(Integer option1, Integer option2, Integer option3,
			Integer userId);

}
