package workshop.restservice;

public class ServiceProvider {
	private static PersoonService persoonservice = new PersoonService();

	public static PersoonService getPersoonService() {
		return persoonservice;
	}
}