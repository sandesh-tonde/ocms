package clg.bvu.ocms.service;

public interface PreferencesService {

	String getPreferences(Integer userId);

	String savePreferences(Integer option1, Integer option2, Integer option3,
			Integer userId);

}
