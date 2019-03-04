package workshop.restservice;

	public class Persoon {
		private String voornaam;
		private String achternaam;
		private int leeftijd;
		public Persoon(String voornaam, String achternaam, int leeftijd) {
			super();
			this.voornaam = voornaam;
			this.achternaam = achternaam;
			this.leeftijd = leeftijd;
		}
		public String getVoornaam() {
			return voornaam;
		}
		public void setVoornaam(String voornaam) {
			this.voornaam = voornaam;
		}
		public String getAchternaam() {
			return achternaam;
		}
		public void setAchternaam(String achternaam) {
			this.achternaam = achternaam;
		}
		public int getLeeftijd() {
			return leeftijd;
		}
		public void setLeeftijd(int leeftijd) {
			this.leeftijd = leeftijd;
		}
}
